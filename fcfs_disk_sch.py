tracks = [93, 176, 42, 147, 27, 14, 180]
head_pointer = 55
started = False
number_of_cylinders = []

while tracks:
    next_pos = tracks[0]
    number_of_cylinders.append(abs(next_pos - head_pointer))
    print(
        f"start point in the list is {next_pos}\n\n({next_pos} - {head_pointer})",
        end=" + ",
    ) if not started else print(
        f"({next_pos} - {head_pointer})", end=" + " if len(tracks) > 1 else ""
    )
    started = True
    tracks.remove(next_pos)
    head_pointer = next_pos

print(f" =  {sum(number_of_cylinders)}\n")
print(f"total number of cylinders is {sum(number_of_cylinders)}")
