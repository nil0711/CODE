using Printf
mutable struct Process
    pid::Int
    arrival_time::Int
    burst_time::Int
    start_time::Int
    execution::Int
    completion_time::Int
    turnaround_time::Int
    waiting_time::Int
    started::Bool
    age::Int
    priority::Int
end

function Process(pid, arrival_time, burst_time, priority)
    Process(pid, arrival_time, burst_time, 0, burst_time, 0, 0, 0, false, 0, priority)
end

Base.isless(p1::Process, p2::Process) = p1.priority < p2.priority

function priority_scheduling_preemptive(processes, age_limit)
    sorted_processes = sort(processes, by=(p) -> (p.arrival_time, p.priority, p.pid))
    gantt_chart = []
    running_process = []
    aging_processes = []
    total_cpu_idle_time = 0

    current_time = 0
    while !isempty(sorted_processes) || !isempty(running_process)
        for process in sorted_processes
            if process.arrival_time <= current_time && !(process in running_process)
                push!(running_process, process)
            end
        end

        if !isempty(running_process)
            for process in running_process
                process.age += 1
            end
            selected_process = argmax(process -> process.priority, running_process)
            selected_process.age -= 1

            for process in running_process
                if process.age >= age_limit
                    push!(aging_processes, process)
                end
            end

            if !isempty(aging_processes)
                potential_switch = argmax(process -> process.age, aging_processes)
                if selected_process.age <= potential_switch.age
                    if selected_process.arrival_time <= potential_switch.arrival_time
                        selected_process.age += 1
                        selected_process = potential_switch
                    end
                end
            end

            if !selected_process.started
                selected_process.start_time = current_time
                selected_process.started = true
            end

            selected_process.execution -= 1
            current_time += 1

            if selected_process.execution == 0
                push!(gantt_chart, selected_process)
                filter!(process -> process != selected_process, running_process)
                selected_process.completion_time = current_time
                selected_process.turnaround_time = selected_process.completion_time - selected_process.arrival_time
                selected_process.waiting_time = selected_process.turnaround_time - selected_process.burst_time
            end
        else
            if !isempty(sorted_processes)
                total_cpu_idle_time += sorted_processes[1].arrival_time - current_time
                current_time = sorted_processes[1].arrival_time
            end
        end

        sorted_processes = filter((p) -> p.execution > 0, sorted_processes)
    end

    return gantt_chart, total_cpu_idle_time
end

function print_gantt_chart(gantt_chart)
    print("\nOutput: \n\n")
    println("PID\tPriority\tArrival\tStart\tBurst\tCompletion\tTurnaround\tWaiting")
    for process in gantt_chart
        println("$(process.pid)\t$(process.priority)\t\t$(process.arrival_time)\t$(process.start_time)\t$(process.burst_time)\t$(process.completion_time)\t\t$(process.turnaround_time)\t\t$(process.waiting_time)")
    end
end

function calculate_average_waiting_time(processes)
    total_waiting_time = sum([process.waiting_time for process in processes])
    return total_waiting_time / length(processes)
end

function calculate_average_turnaround_time(processes)
    total_turnaround_time = sum([process.turnaround_time for process in processes])
    return total_turnaround_time / length(processes)
end

function calculate_throughput(gantt_chart)
    max_ct = maximum([process.completion_time for process in gantt_chart])
    min_at = minimum([process.arrival_time for process in gantt_chart])
    return length(gantt_chart) / (max_ct - min_at)
end

function print_processes(processes)
    print("\nInput: ")
    println("\nProcesses: ")
    @printf("%-5s %-10s %-10s %-10s\n", "PID","Priority", "Arrival", "Burst")
    for process in processes
        @printf("%-5s %-10s %-10s %-10s\n", process.pid, process.priority, process.arrival_time, process.burst_time)
    end

    println("Age limit = 6")
end



processes = [
    Process(1, 0, 4, 4),
    Process(2, 1, 2, 5),
    Process(3, 2, 3, 6),
    Process(4, 3, 1, 10),
    Process(5, 4, 2, 9),
    Process(6, 5, 6, 7)
]

age_limit = 6


gantt_chart, cpu_idle_time = priority_scheduling_preemptive(processes, age_limit)
gantt_chart = sort(gantt_chart, by = (p) -> p.pid)

print_processes(processes)


print_gantt_chart(gantt_chart)

println("\nTotal CPU Idle Time:", cpu_idle_time)
println("Average Waiting Time:", calculate_average_waiting_time(gantt_chart))
println("Average Turnaround Time:", calculate_average_turnaround_time(gantt_chart))
println("Throughput:", calculate_throughput(gantt_chart))
