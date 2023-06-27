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

    function Process(pid, arrival_time, burst_time)
        new(pid, arrival_time, burst_time, 0, 0, 0, 0, 0)
    end
end

function sjf(processes, age_limit)
    sorted_processes = sort(processes, by = (p) -> (p.arrival_time, p.burst_time))
    gantt_chart = []
    total_cpu_idle_time = 0
    current_time = 0
    
    while !isempty(sorted_processes)
        selected_process = nothing
        
        for process in sorted_processes
            if process.arrival_time <= current_time
                if process.age >= age_limit && (selected_process == nothing || process.age < selected_process.age)
                    if selected_process == nothing || process.arrival_time < selected_process.arrival_time
                        selected_process = process
                    end
                elseif selected_process == nothing || process.burst_time < selected_process.burst_time
                    selected_process = process
                end
            end
            
            process.age += 1
        end
        
        if selected_process == nothing
            total_cpu_idle_time += 1
            current_time += 1
        else
            selected_process.start_time = current_time
            selected_process.completion_time = current_time + selected_process.burst_time
            selected_process.turnaround_time = selected_process.completion_time - selected_process.arrival_time
            selected_process.waiting_time = selected_process.turnaround_time - selected_process.burst_time
            current_time = selected_process.completion_time
            push!(gantt_chart, selected_process)
            deleteat!(sorted_processes, findfirst(x -> x == selected_process, sorted_processes))
        end
    end
    
    return gantt_chart, total_cpu_idle_time
end

function print_gantt_chart(gantt_chart)
    println("PID\tArrival\tStart\tBurst\tCompletion\tTurnaround\tWaiting")
    for process in gantt_chart
        println("$(process.pid)\t$(process.arrival_time)\t$(process.start_time)\t$(process.burst_time)\t$(process.completion_time)\t\t$(process.turnaround_time)\t\t$(process.waiting_time)")
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
    @printf("%-5s %-10s %-10s\n", "PID", "Arrival", "Burst")
    
    for process in processes
        @printf("%-5d %-10d %-10d\n", process.pid, process.arrival_time, process.burst_time)
    end
    println("Age limit = 1")
end



processes = [
    Process(1, 4, 0),
    Process(2, 2, 1),
    Process(3, 7, 2),
    Process(4, 5, 3),
    Process(5, 6, 4),
    Process(6, 1, 5)
]

age_limit = 1

print_processes(processes)
gantt_chart, cpu_idle_time = sjf(processes, age_limit)

gantt_chart = sort(gantt_chart, by = (p) -> p.pid)

println("\nOutput:")

print_gantt_chart(gantt_chart)

println("\nTotal CPU Idle Time:", cpu_idle_time)
println("Average Waiting Time:", calculate_average_waiting_time(gantt_chart))
println("Average Turnaround Time:", calculate_average_turnaround_time(gantt_chart))
println("Throughput:", calculate_throughput(gantt_chart))
