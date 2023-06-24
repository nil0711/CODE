total_tracks_is_disk = 200
tracks = [93, 176, 42, 148, 27, 14, 180]
back = []
front = []
head_pointer = 55
started = False
started1 = False
number_of_cylinders = []
start_point = tracks[0]
forwarded = (
    True
    if head_pointer < tracks[0]
    or (head_pointer == tracks[0] and head_pointer < tracks[1])
    else False
)
if not forwarded:
    back.append(0)
else:
    tracks.append(total_tracks_is_disk-1)

while tracks:
    current_track = tracks[0]
    if (current_track < head_pointer and current_track <= start_point) or (head_pointer == tracks[0] and tracks[0] > tracks[1] and not started1):
        back.append(current_track)
    else:
        front.append(current_track)
    started1 = True
    tracks.remove(current_track)


front = sorted(front)
back = sorted(back,reverse=True)
tracks = front + back if forwarded else back + front


while tracks:
    next_pos = tracks[0]
    number_of_cylinders.append(abs(next_pos-head_pointer))
    print(f'start point in the list is {next_pos}\n\n({next_pos} - {head_pointer})', end=' + ') if not started else print(f'({next_pos} - {head_pointer})', end=' + ' if len(tracks)> 1 else '')
    started = True
    tracks.remove(next_pos)
    head_pointer = next_pos 

print(f' =  {sum(number_of_cylinders)}\n')
print(f'total number of cylinders is {sum(number_of_cylinders)}')
