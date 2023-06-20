from collections import deque


class Process:
    def __init__(self, pid, arrival_time, burst_time):
        self.pid = pid
        self.arrival_time = arrival_time
        self.burst_time = burst_time
        self.execution = burst_time
        self.start_time = 0
        self.completion_time = 0
        self.turnaround_time = 0
        self.waiting_time = 0
        self.started = False


def round_robin_scheduling(processes, time_quantum):
    ready_queue = deque()
    cpu_idle_time = 0
    current_time = 0
    completed_process = []

    processes.sort(key=lambda x: (x.arrival_time, x.pid))

    while processes or ready_queue:
        if processes and not ready_queue:
            t = min(p.arrival_time for p in processes)
            if current_time < t:
                current_time = t
                cpu_idle_time += t
                continue

        while processes and current_time >= processes[0].arrival_time:
            ready_queue.append(processes.pop(0))

        if ready_queue:
            running_process = ready_queue.popleft()

            if running_process.arrival_time <= current_time and not running_process.started:
                running_process.start_time = current_time
                running_process.started = True

            if time_quantum < running_process.execution:
                running_process.execution -= time_quantum
                current_time += time_quantum
                while processes and current_time >= processes[0].arrival_time:
                    ready_queue.append(processes.pop(0))
                ready_queue.append(running_process)
            else:
                current_time += running_process.execution

                running_process.completion_time = current_time
                running_process.turnaround_time = running_process.completion_time - running_process.arrival_time
                running_process.waiting_time = running_process.turnaround_time - running_process.burst_time

                completed_process.append(running_process)

    return completed_process, cpu_idle_time


def print_gantt_chart(completed_process):
    print("{:<5} {:<10} {:<10} {:<10} {:<10} {:<10} {:<10}".format(
        "PID", "Arrival", "Start", "Burst", "Completion", "Turnaround", "Waiting"
    ))
    for process in completed_process:
        print("{:<5} {:<10} {:<10} {:<10} {:<10} {:<10} {:<10}".format(
            process.pid, process.arrival_time, process.start_time, process.burst_time,
            process.completion_time, process.turnaround_time, process.waiting_time
        ))


def calculate_average_waiting_time(completed_process):
    total_waiting_time = sum(process.waiting_time for process in completed_process)
    return total_waiting_time / len(completed_process)


def calculate_average_turnaround_time(completed_process):
    total_turnaround_time = sum(process.turnaround_time for process in completed_process)
    return total_turnaround_time / len(completed_process)


def calculate_throughput(completed_process):
    return len(completed_process) / sum(process.turnaround_time for process in completed_process)


processes = [
    Process(1, 0, 4),
    Process(2, 1, 5),
    Process(3, 2, 6),
    Process(4, 3, 3),
    Process(5, 4, 2),
    Process(6, 5, 4)
]

completed_process, cpu_idle_time = round_robin_scheduling(processes, time_quantum=2)

print("Gantt Chart:")
print_gantt_chart(completed_process)

print("\nTotal CPU Idle Time:", cpu_idle_time)
print("Average Waiting Time:", calculate_average_waiting_time(completed_process))
print("Average Turnaround Time:", calculate_average_turnaround_time(completed_process))
print("Throughput:", calculate_throughput(completed_process))
