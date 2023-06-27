function print_gantt_chart(gantt_chart)
    println("{:<5s} {:<10s} {:<10s} {:<10s} {:<12s} {:<12s} {:<10s}".format(
        "PID", "Arrival", "Start", "Burst", "Completion", "Turnaround", "Waiting"
    ))
    
    for process in gantt_chart
        println("{:<5d} {:<10d} {:<10d} {:<10d} {:<12d} {:<12d} {:<10d}".format(
            process.pid, process.arrival_time, process.start_time, process.burst_time,
            process.completion_time, process.turnaround_time, process.waiting_time
        ))
    end
end