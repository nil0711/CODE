import tkinter as tk
from tkinter import ttk
from tkinter.font import Font

window = tk.Tk()
def button_func():
    test = entry.get()
    label.configure(text=test,font=font1)
    button.configure(state='disabled')
    button2.configure(state='enabled')

def button2_func():
    button2.configure(state='disabled')
    button.configure(state='enabled') 
font1 = Font(family="Calibre", size=20, weight="bold")


window.title('File')
window.geometry('700x500')



label = ttk.Label(master=window, text='Thoot')
label.pack()

entry = ttk.Entry(master=window)
entry.pack()

button = ttk.Button(master=window, text='click', command=button_func)
button.pack()
button2 = ttk.Button(master=window,text='click to diable',state='disabled',command= button2_func)
button2.pack()
window.mainloop()
