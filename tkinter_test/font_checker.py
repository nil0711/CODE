import tkinter as tk
from tkinter import font

root = tk.Tk()
available_fonts = font.families()
root.destroy()

for font in available_fonts:
    print(font)
