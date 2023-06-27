class DiskScheduler:
    def __init__(self, tracks, head_pointer):
        self.tracks = tracks
        self.head_pointer = head_pointer
        self.started = False
        self.number_of_cylinders = []

    def process_tracks(self):
        while self.tracks:
            sorted_tracks = sorted(self.tracks, key=lambda x: (abs(x - self.head_pointer), x))

            start_point = sorted_tracks[0] if not self.started else min(self.tracks, key=lambda x: (abs(x - self.head_pointer), x))

            if not self.started:
                print(f"Start point in the list is {start_point}\n\n({start_point} - {self.head_pointer})", end=" + ")
            else:
                if len(self.tracks) > 1:
                    print(f"({start_point} - {self.head_pointer})", end=" + ")
                else:
                    print(f"({start_point} - {self.head_pointer})", end="")

            self.started = True
            self.number_of_cylinders.append(abs(start_point - self.head_pointer))
            self.tracks.remove(start_point)
            self.head_pointer = start_point

        print(f" =  {sum(self.number_of_cylinders)}\n")
        print(f"Total number of cylinders is {sum(self.number_of_cylinders)}")


# Usage
tracks = [18, 170, 43, 140, 24, 16, 190]
head_pointer = 50

scheduler = DiskScheduler(tracks, head_pointer)
scheduler.process_tracks()
