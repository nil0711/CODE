class Process:
    def __init__(self, pid, arrival_time, burst_time, priority):
        self.pid = pid
        self.arrival_time = arrival_time
        self.burst_time = burst_time
        self.start_time = 0
        self.execution = burst_time
        self.completion_time = 0
        self.turnaround_time = 0
        self.waiting_time = 0
        self.started = False
        self.age = 0
        self.priority = priority


def priority_scheduling_preemptive(processes,age_limit):
    sorted_processes = sorted(processes, key=lambda p: (p.arrival_time, p.priority, p.pid))
    gantt_chart = []
    running_process = []
    aging_processes = []
    total_cpu_idle_time = 0

    current_time = 0
    while sorted_processes or running_process:
        for process in sorted_processes:
            if process.arrival_time <= current_time:
                if process not in running_process:
                    running_process.append(process)
        
        if running_process:
            for process in running_process:
                process.age += 1 
            selected_process = max(running_process, key=lambda p: p.priority)
            selected_process.age -= 1
            
            for process in running_process:
                if process.age >= age_limit:
                    aging_processes.append(process)
                    
            if aging_processes:
                potential_switch = max(aging_processes , key= lambda p : p.age)
                if selected_process.age <= potential_switch.age:
                    if selected_process.arrival_time <= potential_switch.arrival_time:
                        selected_process.age += 1
                        selected_process = potential_switch
            
            
            if not selected_process.started:
                selected_process.start_time = current_time
                selected_process.started = True
            
            selected_process.execution -= 1
            current_time += 1
            
            if selected_process.execution == 0:
                running_process.remove(selected_process)
                selected_process.completion_time = current_time
                selected_process.turnaround_time = selected_process.completion_time - selected_process.arrival_time
                selected_process.waiting_time = selected_process.turnaround_time - selected_process.burst_time
                gantt_chart.append(selected_process)
        else:
            if sorted_processes:
                total_cpu_idle_time += sorted_processes[0].arrival_time - current_time
                current_time = sorted_processes[0].arrival_time

        sorted_processes = [p for p in sorted_processes if p.execution > 0]

    return gantt_chart, total_cpu_idle_time



def print_gantt_chart(gantt_chart):
    print("{:<5} {:<10} {:<10} {:<10} {:<10} {:<10} {:<10} {:<10}".format(
        "PID", "Arrival", "Priority", "Start", "Burst", "Completion", "Turnaround", "Waiting"
    ))
    for process in gantt_chart:
        print("{:<5} {:<10} {:<10} {:<10} {:<10} {:<10} {:<10} {:<10}".format(
            process.pid, process.arrival_time, process.priority, process.start_time, process.burst_time,
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

def print_processes(processes):
    print("\nInput: ")
    print('\nProcesses: ')
    print("{:<5} {:<10} {:<10} {:<10} ".format(
        "PID", "Priority", "Arrival", "Burst"
    ))
    for process in processes:
        print("{:<5} {:<10} {:<10} {:<10} ".format(
            process.pid, process.priority, process.arrival_time, process.burst_time
        ))
    

processes=[
    Process(1, 0, 4, 4),
    Process(2 ,1 ,2 ,5),
    Process(3 ,2 ,3 ,6),
    Process(4 ,3 ,1 ,10),
    Process(5 ,4 ,2 ,9),
    Process(6 ,5 ,6 , 7)
]



age_limit = 6
gantt_chart, cpu_idle_time = priority_scheduling_preemptive(processes,age_limit)
print_processes(processes)

print("\nOutput: ")
print("Gantt Chart:")
print_gantt_chart(gantt_chart)

print("\nTotal CPU Idle Time:", cpu_idle_time)
print("Average Waiting Time:", calculate_average_waiting_time(gantt_chart))
print("Average Turnaround Time:", calculate_average_turnaround_time(gantt_chart))
print("Throughput:", calculate_throughput(gantt_chart))