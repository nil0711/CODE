class Process:
    def __init__(self, pid, arrival_time, burst_time):
        self.pid = pid
        self.arrival_time = arrival_time
        self.burst_time = burst_time
        self.start_time = 0
        self.completion_time = 0
        self.turnaround_time = 0
        self.waiting_time = 0
        self.age = 0


def sjf(processes,age_limit):
    sorted_processes = sorted(processes, key=lambda p: (p.arrival_time, p.burst_time))
    gantt_chart = []
    total_cpu_idle_time = 0

    current_time = 0
    while sorted_processes:
        selected_process = None
        for process in sorted_processes:
            if process.arrival_time <= current_time:
                if process.age >= age_limit:
                    if process.arrival_time < selected_process.arrival_time:
                        selected_process = process

        


            process.age += 1

        if selected_process is None:
            total_cpu_idle_time += 1
            current_time += 1
        else:
            sorted_processes.remove(selected_process)
            selected_process.start_time = current_time
            selected_process.completion_time = current_time + selected_process.burst_time
            selected_process.turnaround_time = selected_process.completion_time - selected_process.arrival_time
            selected_process.waiting_time = selected_process.turnaround_time - selected_process.burst_time
            current_time = selected_process.completion_time
            gantt_chart.append(selected_process)

    return gantt_chart, total_cpu_idle_time


def print_gantt_chart(gantt_chart):
    print("{:<5} {:<10} {:<10} {:<10} {:<10} {:<10} {:<10}".format(
        "PID", "Arrival", "Start", "Burst", "Completion", "Turnaround", "Waiting"
    ))
    for process in gantt_chart:
        print("{:<5} {:<10} {:<10} {:<10} {:<10} {:<10} {:<10}".format(
            process.pid, process.arrival_time, process.start_time, process.burst_time,
            process.completion_time, process.turnaround_time, process.waiting_time
        ))


def calculate_average_waiting_time(processes):
    total_waiting_time = sum(process.waiting_time for process in processes)
    return total_waiting_time / len(processes)


def calculate_average_turnaround_time(processes):
    total_turnaround_time = sum(process.turnaround_time for process in processes)
    return total_turnaround_time / len(processes)


def calculate_throughput(gantt_chart):    
    max_ct = max(process.completion_time for process in gantt_chart)
    min_at = min(process.arrival_time for process in gantt_chart)
    return len(gantt_chart) / (max_ct-min_at) 


def print_processes(processes,age_limit):
    print("\nInput: ")
    print('\nProcesses: ')
    print("{:<5} {:<10} {:<10} ".format(
        "PID", "Arrival", "Burst"
    ))
    for process in processes:
        print("{:<5} {:<10} {:<10} ".format(
            process.pid, process.arrival_time, process.burst_time
        ))
        
    print(f"\nAge limit = {age_limit}")
    


# Sample input
processes = [
    Process(1, 1, 9),
    Process(2, 4, 2),
    Process(3, 3, 4),
    Process(4, 0, 5),
    Process(5, 2, 1)
]

age_limit = 4

print_processes(processes,age_limit)
gantt_chart, cpu_idle_time = sjf(processes,age_limit)

gantt_chart = sorted(gantt_chart, key = lambda p : p.start_time)

print("\nOutput: ")

print("\nGantt Chart:")
print_gantt_chart(gantt_chart)

print("\nTotal CPU Idle Time:", cpu_idle_time)
print("Average Waiting Time:", calculate_average_waiting_time(gantt_chart))
print("Average Turnaround Time:", calculate_average_turnaround_time(gantt_chart))
print("Throughput:", calculate_throughput(gantt_chart))

