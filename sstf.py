tracks = [18, 170, 43, 140, 24, 16, 190]
head_pointer = 50
started = False
number_of_cylinders = []

while tracks:
    sorted_tracks = sorted(tracks, key=lambda x: (abs(x - head_pointer), x))    
    
    start_point = sorted_tracks[0] if not started else min(tracks, key=lambda x: (abs(x - head_pointer), x))
    print(f'start point in the list is {start_point}\n\n({start_point} - {head_pointer})', end=' + ') if not started else print(f'({start_point} - {head_pointer})', end=' + ' if len(tracks)> 1 else '')
    started = True
    
    number_of_cylinders.append(abs(start_point - head_pointer))
    tracks.remove(start_point)
    head_pointer = start_point

print(f' =  {sum(number_of_cylinders)}\n')
print(f'total number of cylinders is {sum(number_of_cylinders)}')





