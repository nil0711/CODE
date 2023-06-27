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
    
    function Process(pid, burst_time, arrival_time)
        new(pid, arrival_time, burst_time, 0, 0, 0, 0, 0, burst_time, false)
    end
end

function fcfs(processes)
    sorted_processes = sort(processes, by=p -> p.arrival_time)
    gantt_chart = []
    total_cpu_idle_time = 0
    current_time = 0
    
    while !isempty(sorted_processes)
        selected_process = nothing
        
        for process in sorted_processes
            if process.arrival_time <= current_time && selected_process === nothing
                selected_process = process
                selected_process.start_time = current_time
                current_time += selected_process.burst_time
                continue
            end
        end
        
        if selected_process == nothing
            total_cpu_idle_time += 1
            current_time += 1
        else
            filter!(p -> p != selected_process, sorted_processes)
            selected_process.completion_time = current_time
            selected_process.turnaround_time = selected_process.completion_time - selected_process.arrival_time
            selected_process.waiting_time = selected_process.turnaround_time - selected_process.burst_time
            push!(gantt_chart, selected_process)
        end
    end
    
    return gantt_chart, total_cpu_idle_time
end

function print_gantt_chart(gantt_chart)
    print("\nOutput: \n\n")
    println("PID\tArrival\tStart\tBurst\tCompletion\tTurnaround\tWaiting")
    for process in gantt_chart
        println("$(process.pid)\t$(process.arrival_time)\t$(process.start_time)\t$(process.burst_time)\t$(process.completion_time)\t\t$(process.turnaround_time)\t\t$(process.waiting_time)")
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
    print("\nInput: ")
    println("\nProcesses: ")
    @printf("%-5s %-10s %-10s\n", "PID", "Arrival", "Burst")
    for process in processes
        @printf("%-5s %-10s %-10s\n", process.pid, process.arrival_time, process.burst_time)
    end
end

processes = [
    Process(1, 4, 0),
    Process(2, 2, 1),
    Process(3, 3, 2),
    Process(4, 5, 3),
    Process(5, 6, 4),
    Process(6, 1, 5)
]
print_processes(processes)

gantt_chart, total_cpu_idle_time = fcfs(processes)

print_gantt_chart(gantt_chart)

println("\nTotal CPU Idle Time:", total_cpu_idle_time)
println("Average Waiting Time:", calculate_average_waiting_time(gantt_chart))
println("Average Turnaround Time:", calculate_average_turnaround_time(gantt_chart))
println("Throughput:", calculate_throughput(gantt_chart))
