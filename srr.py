from collections import deque


class Process:
    def __init__(self, pid, arrival_time, burst_time):
        self.pid = pid
        self.arrival_time = arrival_time
        self.burst_time = burst_time
        self.execution = burst_time
        self.time_quantum = 0
        self.start_time = 0
        self.completion_time = 0
        self.turnaround_time = 0
        self.waiting_time = 0
        self.started = False


def selfish_round_robin_scheduling(processes):
    ready_queue = deque(maxlen=3)
    waiting_queue = deque()
    cpu_idle_time = 0
    current_time = 0
    completed_process = []

    processes.sort(key=lambda x: (x.arrival_time, x.burst_time))

    for process in processes:
        waiting_queue.append(process)
        if len(ready_queue) < 3:
            current_process = waiting_queue.popleft()
            ready_queue.append(current_process)

    while ready_queue or waiting_queue:
        processes_to_remove = []

        for running_process in ready_queue:
            if running_process.arrival_time > current_time:
                cpu_idle_time += running_process.arrival_time - current_time
                current_time = running_process.arrival_time

            if running_process.started is False:
                running_process.start_time = current_time
                running_process.started = True

            current_time += 1
            running_process.burst_time -= 1

            if running_process.burst_time == 0:
                running_process.completion_time = current_time
                running_process.turnaround_time = running_process.completion_time - running_process.arrival_time
                running_process.waiting_time = running_process.start_time - running_process.arrival_time
                processes_to_remove.append(running_process)

            running_process.time_quantum += 2

        for process in processes_to_remove:
            ready_queue.remove(process)
            completed_process.append(process)

        if len(ready_queue) < 3 and waiting_queue:
            current_process = waiting_queue.popleft()
            ready_queue.append(current_process)

        for waiting_process in waiting_queue:
            waiting_process.time_quantum += 1

        highest_a = max(p.time_quantum for p in ready_queue) if ready_queue else 0
        lowest_a = min(p.time_quantum for p in waiting_queue) if waiting_queue else float('inf')

        if highest_a < lowest_a and ready_queue:
            removed_process = ready_queue.popleft()
            waiting_queue.append(removed_process)
            removed_waiting_process = waiting_queue.popleft()
            ready_queue.append(removed_waiting_process)

    return completed_process, cpu_idle_time


def print_gantt_chart(completed_process):
    print("{:<5} {:<10} {:<10} {:<10} {:<10} {:<10} {:<10}".format(
        "PID", "Arrival", "Start", "Burst", "Completion", "Turnaround", "Waiting"
    ))
    for process in completed_process:
        print("{:<5} {:<10} {:<10} {:<10} {:<10} {:<10} {:<10}".format(
            process.pid, process.arrival_time, process.start_time, process.execution,
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
    Process(1, 0, 10),
    Process(2, 2, 5),
    Process(3, 2, 8),
    Process(4, 2, 2),
    Process(5, 4, 6)
]

completed_process, cpu_idle_time = selfish_round_robin_scheduling(processes)

print("Gantt Chart:")
print_gantt_chart(completed_process)

print("\nTotal CPU Idle Time:", cpu_idle_time)
print("Average Waiting Time:", calculate_average_waiting_time(completed_process))
print("Average Turnaround Time:", calculate_average_turnaround_time(completed_process))
print("Throughput:", calculate_throughput(completed_process))