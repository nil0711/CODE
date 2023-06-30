import ttkbootstrap as tk


window = tk.Window(title='File',themename='cosmo')  
text = tk.StringVar()
label = tk.Label(master =window,text='ENter text below',textvariable=text)
label.pack()
entry = tk.Entry(master =window,textvariable=text)
entry.pack()
text = entry.get()


window.mainloop()  