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
        self.remaining_time = burst_time  
        self.started = False


def calculate_gantt_chart(processes, age_limit):
    sorted_processes = sorted(processes, key=lambda p: (p.arrival_time, p.burst_time))
    gantt_chart = []
    total_cpu_idle_time = 0

    current_time = 0

    while sorted_processes:
        selected_process = None

        for process in sorted_processes:
            if process.arrival_time <= current_time:
                if process.age >= age_limit and (selected_process is None or process.age < selected_process.age):
                    selected_process = process
                elif selected_process is None or process.remaining_time < selected_process.remaining_time:
                    selected_process = process

            process.age += 1

        if selected_process is None:
            total_cpu_idle_time +=1
            current_time += 1
        else:
            if selected_process.started == False:
                selected_process.started = True
                selected_process.start_time = current_time
            if selected_process.remaining_time > 0:
                selected_process.remaining_time -= 1
                current_time += 1

            if selected_process.remaining_time == 0:
                sorted_processes.remove(selected_process)
                selected_process.completion_time = current_time
                selected_process.turnaround_time = selected_process.completion_time - selected_process.arrival_time
                selected_process.waiting_time = selected_process.turnaround_time - selected_process.burst_time
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


def calculate_average_waiting_time(gantt_chart):
    total_waiting_time = sum(process.waiting_time for process in gantt_chart)
    return total_waiting_time / len(gantt_chart)


def calculate_average_turnaround_time(gantt_chart):
    total_turnaround_time = sum(process.turnaround_time for process in gantt_chart)
    return total_turnaround_time / len(gantt_chart)


def calculate_throughput(gantt_chart):
    total_turnaround_time = sum(process.turnaround_time for process in gantt_chart)
    return len(gantt_chart) / total_turnaround_time


# Sample input
processes = [
    Process(1, 0, 3),
    Process(2, 6, 2),
    Process(3, 0, 9),
    Process(4, 3, 2),
    Process(5, 5, 5)
]

age_limit = float('inf')

gantt_chart, total_cpu_idle_time = calculate_gantt_chart(processes, age_limit)

print("Gantt Chart:")
print_gantt_chart(gantt_chart)

print("\nTotal CPU Idle Time:", total_cpu_idle_time)
print("Average Waiting Time:", calculate_average_waiting_time(gantt_chart))
print("Average Turnaround Time:", calculate_average_turnaround_time(gantt_chart))
print("Throughput:", calculate_throughput(gantt_chart))