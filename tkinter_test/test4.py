import tkinter as tk

window = tk.Tk()
window.geometry('1000x1000')
cvs = tk.Canvas(window, bg='white')
cvs.pack()
def draw_on_canvas(event):
    x = event.x
    y= event.y
    cvs.create_oval((x - bs /2 , y - bs /2,x + bs / 2, y + bs / 2 ))
bs = 4
cvs.bind('<Motion>',draw_on_canvas)
window.mainloop() 