using Printf

mutable struct Process
    pid::Int
    arrival_time::Int
    burst_time::Int
    start_time::Int
    completion_time::Int
    turnaround_time::Int
    waiting_time::Int
    age::Int
    priority::Int

    function Process(pid, arrival_time, burst_time, priority)
        new(pid, arrival_time, burst_time, 0, 0, 0, 0, 0, priority)
    end
end

function priority_scheduling_starvation(processes, age_limit=Inf)
    sorted_processes = sort(processes, by=p -> (p.arrival_time, -p.priority, p.burst_time))
    gantt_chart = []
    total_cpu_idle_time = 0

    current_time = 0
    while !isempty(sorted_processes)
        selected_process = nothing
        for process in sorted_processes
            if process.arrival_time <= current_time
                if process.age >= age_limit && (isnothing(selected_process) || process.age < selected_process.age)
                    if isnothing(selected_process) || process.arrival_time < selected_process.arrival_time
                        selected_process = process
                    end
                elseif isnothing(selected_process) || process.priority < selected_process.priority
                    selected_process = process
                end
            end
        end

        if isnothing(selected_process)
            total_cpu_idle_time += 1
            current_time += 1
        else
            filter!(x -> x !== selected_process, sorted_processes)
            selected_process.start_time = current_time
            selected_process.completion_time = current_time + selected_process.burst_time
            selected_process.turnaround_time = selected_process.completion_time - selected_process.arrival_time
            selected_process.waiting_time = selected_process.turnaround_time - selected_process.burst_time
            current_time = selected_process.completion_time
            push!(gantt_chart, selected_process)
        end
    end

    return gantt_chart, total_cpu_idle_time
end

function print_gantt_chart(gantt_chart)
    @printf("%-5s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
        "PID", "Arrival", "Priority", "Start", "Burst", "Completion", "Turnaround", "Waiting"
    )
    for process in gantt_chart
        @printf("%-5d %-10d %-10d %-10d %-10d %-10d %-10d %-10d\n",
            process.pid, process.arrival_time, process.priority, process.start_time, process.burst_time,
            process.completion_time, process.turnaround_time, process.waiting_time
        )
    end
end

function calculate_average_waiting_time(processes)
    total_waiting_time = sum(process.waiting_time for process in processes)
    return total_waiting_time / length(processes)
end

function calculate_average_turnaround_time(processes)
    total_turnaround_time = sum(process.turnaround_time for process in processes)
    return total_turnaround_time / length(processes)
end

function calculate_throughput(gantt_chart)
    max_ct = maximum(process.completion_time for process in gantt_chart)
    min_at = minimum(process.arrival_time for process in gantt_chart)
    return length(gantt_chart) / (max_ct - min_at)
end

function print_processes(processes)
    println("\nInput:")
    println("\nProcesses:")
    @printf("%-5s %-10s %-10s %-10s\n", "PID", "Priority", "Arrival", "Burst")
    for process in processes
        @printf("%-5s %-10s %-10s %-10s\n",
            process.pid, process.priority, process.arrival_time, process.burst_time
        )
    end
end

processes = [
    Process(1, 0, 3, 2),
    Process(2, 6, 2, 1),
    Process(3, 0, 9, 3),
    Process(4, 1, 12, 4),
    Process(5, 5, 5, 2)
]

age_limit = 100
print_processes(processes)

gantt_chart, cpu_idle_time = priority_scheduling_starvation(processes, age_limit)

println("\nOutput:")
print_gantt_chart(gantt_chart)

println("\nTotal CPU Idle Time:", cpu_idle_time)
println("Average Waiting Time:", calculate_average_waiting_time(gantt_chart))
println("Average Turnaround Time:", calculate_average_turnaround_time(gantt_chart))
println("Throughput:", calculate_throughput(gantt_chart))
