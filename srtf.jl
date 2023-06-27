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
    remaining_time::Int
    started::Bool

    function Process(pid, arrival_time, burst_time)
        new(pid, arrival_time, burst_time, 0, 0, 0, 0, 0, burst_time, false)
    end
end

function srtf(processes, age_limit)
    sorted_processes = sort(processes, by = p -> (p.arrival_time, p.burst_time))
    gantt_chart = []
    total_cpu_idle_time = 0
    current_time = 0

    while !isempty(sorted_processes)
        selected_process = nothing

        for process in sorted_processes
            if process.arrival_time <= current_time
                if process.age >= age_limit && (selected_process == nothing || process.age < selected_process.age)
                    selected_process = process
                elseif selected_process == nothing || process.remaining_time < selected_process.remaining_time
                    selected_process = process
                end
            end

            process.age += 1
        end

        if selected_process == nothing
            total_cpu_idle_time += 1
            current_time += 1
        else
            if !selected_process.started
                selected_process.started = true
                selected_process.start_time = current_time
            end

            if selected_process.remaining_time > 0
                selected_process.remaining_time -= 1
                current_time += 1
            end

            if selected_process.remaining_time == 0
                filter!(p -> p != selected_process, sorted_processes)
                selected_process.completion_time = current_time
                selected_process.turnaround_time = selected_process.completion_time - selected_process.arrival_time
                selected_process.waiting_time = selected_process.turnaround_time - selected_process.burst_time
                push!(gantt_chart, selected_process)
            end
        end
    end

    return gantt_chart, total_cpu_idle_time
end

function print_gantt_chart(gantt_chart)
    @printf("%-5s %-10s %-10s %-10s %-10s %-10s %-10s\n", "PID", "Arrival", "Start", "Burst", "Completion", "Turnaround", "Waiting")
    for process in gantt_chart
        @printf("%-5d %-10d %-10d %-10d %-10d %-10d %-10d\n",
            process.pid, process.arrival_time, process.start_time, process.burst_time,
            process.completion_time, process.turnaround_time, process.waiting_time
        )
    end
end

function calculate_average_waiting_time(gantt_chart)
    total_waiting_time = sum(process.waiting_time for process in gantt_chart)
    return total_waiting_time / length(gantt_chart)
end

function calculate_average_turnaround_time(gantt_chart)
    total_turnaround_time = sum(process.turnaround_time for process in gantt_chart)
    return total_turnaround_time / length(gantt_chart)
end

function calculate_throughput(gantt_chart)
    max_ct = maximum(process.completion_time for process in gantt_chart)
    min_at = minimum(process.arrival_time for process in gantt_chart)
    return length(gantt_chart) / (max_ct - min_at)
end

function print_processes(processes)
    println("\nInput: ")
    println("\nProcesses: ")
    @printf("%-5s %-10s %-10s\n", "PID", "Arrival", "Burst")
    for process in processes
        @printf("%-5d %-10d %-10d\n", process.pid, process.arrival_time, process.burst_time)
    end
end

processes = [
    Process(1, 0, 3),
    Process(2, 6, 2),
    Process(3, 0, 9),
    Process(4, 3, 2),
    Process(5, 5, 5)
]

age_limit = Inf
print_processes(processes)

gantt_chart, total_cpu_idle_time = srtf(processes, age_limit)

println("\nOutput:")
print_gantt_chart(gantt_chart)

println("\nTotal CPU Idle Time: ", total_cpu_idle_time)
println("Average Waiting Time: ", calculate_average_waiting_time(gantt_chart))
println("Average Turnaround Time: ", calculate_average_turnaround_time(gantt_chart))
println("Throughput: ", calculate_throughput(gantt_chart))
