mutable struct Process
    pid::Int
    arrival_time::Int
    burst_time::Int
    execution::Int
    start_time::Int
    completion_time::Int
    turnaround_time::Int
    waiting_time::Int
    started::Bool

    function Process(pid, arrival_time, burst_time)
        new(pid, arrival_time, burst_time, burst_time, 0, 0, 0, 0, false)
    end
end

using DataStructures
using Printf

function round_robin_scheduling(processes, time_quantum)
    ready_queue = Deque{Process}()
    cpu_idle_time = 0
    current_time = 0
    completed_process = []

    sort!(processes, by = x -> (x.arrival_time, x.pid))

    while !isempty(processes) || !isempty(ready_queue)
        if !isempty(processes) && isempty(ready_queue)
            t = minimum([p.arrival_time for p in processes])
            if current_time < t
                current_time = t
                cpu_idle_time += t
                continue
            end
        end

        while !isempty(processes) && current_time >= processes[1].arrival_time
            push!(ready_queue, popfirst!(processes))
        end

        if !isempty(ready_queue)
            running_process = popfirst!(ready_queue)

            if running_process.arrival_time <= current_time && !running_process.started
                running_process.start_time = current_time
                running_process.started = true
            end

            if time_quantum < running_process.execution
                running_process.execution -= time_quantum
                current_time += time_quantum
                while !isempty(processes) && current_time >= processes[1].arrival_time
                    push!(ready_queue, popfirst!(processes))
                end
                push!(ready_queue, running_process)
            else
                current_time += running_process.execution

                running_process.completion_time = current_time
                running_process.turnaround_time = running_process.completion_time - running_process.arrival_time
                running_process.waiting_time = running_process.turnaround_time - running_process.burst_time

                push!(completed_process, running_process)
            end
        end
    end

    completed_process, cpu_idle_time
end

function print_gantt_chart(completed_process)
    @printf("%-5s %-10s %-10s %-10s %-10s %-10s %-10s\n", "PID", "Arrival", "Start", "Burst", "Completion", "Turnaround", "Waiting")
    for process in completed_process
        @printf("%-5d %-10d %-10d %-10d %-10d %-10d %-10d\n",
            process.pid, process.arrival_time, process.start_time, process.burst_time,
            process.completion_time, process.turnaround_time, process.waiting_time
        )
    end
end

function calculate_average_waiting_time(completed_process)
    total_waiting_time = sum([process.waiting_time for process in completed_process])
    total_waiting_time / length(completed_process)
end

function calculate_average_turnaround_time(completed_process)
    total_turnaround_time = sum([process.turnaround_time for process in completed_process])
    total_turnaround_time / length(completed_process)
end

function calculate_throughput(gantt_chart)
    max_ct = maximum([process.completion_time for process in gantt_chart])
    min_at = minimum([process.arrival_time for process in gantt_chart])
    length(gantt_chart) / (max_ct - min_at)
end

function print_processes(processes)
    println("\nInput:")
    println("\nProcesses:")
    @printf("%-5s %-10s %-10s\n", "PID", "Arrival", "Burst")
    for process in processes
        @printf("%-5d %-10d %-10d\n", process.pid, process.arrival_time, process.burst_time)
    end
end

processes = [
    Process(1, 0, 4),
    Process(2, 1, 5),
    Process(3, 2, 6),
    Process(4, 3, 3),
    Process(5, 4, 2),
    Process(6, 5, 4)
]

print_processes(processes)
completed_process, cpu_idle_time = round_robin_scheduling(processes, 2)
completed_process = sort(completed_process, by = (p) -> p.pid)

println("\nOutput:")
print_gantt_chart(completed_process)

println("\nTotal CPU Idle Time:", cpu_idle_time)
println("Average Waiting Time:", calculate_average_waiting_time(completed_process))
println("Average Turnaround Time:", calculate_average_turnaround_time(completed_process))
println("Throughput:", calculate_throughput(completed_process))
