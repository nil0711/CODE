from tkinter.font import Font
from ttkbootstrap import *


def convert():
    a = entry_int.get()
    b=len(str(a))
    a = round(a*1.6,b)
    out_str.set(a)

font_family = "Calibre"
font_size = 20

window = Window(themename='cosmo')
window.title('Demo')
window.geometry('300x400')

font1 = Font(family=font_family, size=font_size, weight="bold")

label = Label(master=window, text='Miles To Kilometer', font=font1)
label.pack()

input_frame = Frame(master=window,padding=10)
entry_int = DoubleVar()
entry = Entry(master=input_frame,textvariable=entry_int)
button = Button(master=input_frame, text="Click ME!",command= convert)
entry.pack(side='left', padx=15)
button.pack(side='left')
input_frame.pack()


out_str = StringVar()
output_label = Label(master=window, text='Output', font=(font_family, font_size, 'bold'),textvariable=out_str)
output_label.pack()

window.mainloop()
