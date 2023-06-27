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

function priority_scheduling_non_preemptive(processes)
    sorted_processes = sort(processes, by = (p) -> (p.arrival_time, p.priority, p.pid))
    gantt_chart = []
    running_process = []
    total_cpu_idle_time = 0

    current_time = 0
    while !isempty(sorted_processes) || !isempty(running_process)
        for process in sorted_processes
            if process.arrival_time <= current_time
                push!(running_process, process)
            end
        end
        sorted_processes = [p for p in sorted_processes if !(p in running_process)]
        if isempty(running_process)
            total_cpu_idle_time += sorted_processes[1].arrival_time - current_time
            current_time = sorted_processes[1].arrival_time
        else
            priorities = [p.priority for p in running_process]
            max_priority_index = argmax(priorities)
            selected_process = running_process[max_priority_index]
            deleteat!(running_process, max_priority_index)

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
        @printf("%-5s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
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
    Process(1, 0, 4, 4),
    Process(2, 1, 2, 5),
    Process(3, 3, 3, 6),
    Process(4, 3, 1, 10),
    Process(5, 4, 2, 9),
    Process(6, 5, 6, 7)
]

age_limit = Inf
gantt_chart, cpu_idle_time = priority_scheduling_non_preemptive(processes)

gantt_chart = sort(gantt_chart, by = (p) -> p.pid)
println("\nOutput:")

println("Gantt Chart:")
print_gantt_chart(gantt_chart)

println("\nTotal CPU Idle Time:", cpu_idle_time)
println("Average Waiting Time:", calculate_average_waiting_time(gantt_chart))
println("Average Turnaround Time:", calculate_average_turnaround_time(gantt_chart))
println("Throughput:", calculate_throughput(gantt_chart))
