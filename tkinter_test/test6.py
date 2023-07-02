import os
import shutil
import tkinter as tk
import tkinter.simpledialog as simpledialog
from tkinter import filedialog, messagebox, Listbox, MULTIPLE, END

home = '/home/anon/Music/'


class ConflictDialog(simpledialog.Dialog):
    def __init__(self, parent, item_name):
        self.item_name = item_name
        super().__init__(parent)

    def body(self, master):
        message = f"A file or folder with the name '{self.item_name}' already exists. What do you want to do?"
        label = tk.Label(master, text=message)
        label.pack(padx=10, pady=10)

    def buttonbox(self):
        box = tk.Frame(self)

        overwrite_button = tk.Button(box, text="Overwrite", width=10, command=self.ok, default=tk.ACTIVE)
        overwrite_button.pack(side=tk.LEFT, padx=5, pady=5)

        rename_button = tk.Button(box, text="Rename", width=10, command=self.rename)
        rename_button.pack(side=tk.LEFT, padx=5, pady=5)

        skip_button = tk.Button(box, text="Skip", width=10, command=self.skip)
        skip_button.pack(side=tk.LEFT, padx=5, pady=5)

        self.bind("<Return>", self.ok)
        self.bind("<Escape>", self.skip)

        box.pack()

    def rename(self):
        self.result = 'rename'
        self.cancel()

    def skip(self):
        self.result = 'skip'
        self.cancel()


class FileManagerApp:
    def __init__(self, root):
        self.root = root
        self.root.title("File Manager")
        self.root.geometry('1920x1080')
        self.current_directory = home
        self.entry = tk.Entry(root, width=50)
        self.entry.grid(row=1, column=0, padx=10, pady=10)
        self.paste_here_button = tk.Button(root, text='Paste here', command=self.paste_files_here)
        self.paste_here_button.grid(row=1, column=2, padx=10, pady=10)
        self.copy_button = tk.Button(root, text="Copy", command=self.copy_files)
        self.copy_button.grid(row=0, column=2, padx=10, pady=10)

        self.frame = tk.Frame(root)
        self.listbox = Listbox(self.frame, selectmode=MULTIPLE, width=190, height=45)
        self.frame.grid(row=3, column=0, columnspan=7, padx=10, pady=10)
        self.listbox.pack(side="left", fill="both", expand=True)
        self.update_file_list()

        self.listbox.bind("<<ListboxSelect>>", self.on_listbox_select)

    def on_listbox_select(self, event):
        selected_items = self.listbox.curselection()

    def update_file_list(self):
        self.listbox.delete(0, END)

        for item in os.listdir(self.current_directory):
            item_path = os.path.join(self.current_directory, item)
            if os.path.isdir(item_path):
                self.listbox.insert(END, f"1 {item}")
            else:
                self.listbox.insert(END, f"0 {item}")

    def paste_files_here(self):
        destination_directory = self.current_directory

        if not destination_directory or not os.path.isdir(destination_directory):
            messagebox.showinfo("Error", "Please enter a valid destination directory.")
            return

        for item_type, item_name in self.copied_files:
            source_path = os.path.join(self.current_directory, item_name)
            destination_path = os.path.join(destination_directory, item_name)

            if os.path.exists(destination_path):
                # Conflict found
                dialog = ConflictDialog(self.root, item_name)
                response = dialog.result

                if response == 'overwrite':
                    if item_type == "0":
                        shutil.copy(source_path, destination_path)
                    elif item_type == "1":
                        if not os.path.isdir(source_path):
                            messagebox.showinfo("Error", f"{source_path} is not a valid directory.")
                            continue
                        shutil.copytree(source_path, destination_path)
                elif response == 'rename':
                    # Find a new name by appending '1' to the last
                    renamed_path = destination_path
                    counter = 1
                    while os.path.exists(renamed_path):
                        base_name, extension = os.path.splitext(destination_path)
                        renamed_path = f"{base_name}_{counter}{extension}"
                        counter += 1

                    if item_type == "0":
                        shutil.copy(source_path, renamed_path)
                    elif item_type == "1":
                        if not os.path.isdir(source_path):
                            messagebox.showinfo("Error", f"{source_path} is not a valid directory.")
                            continue
                        shutil.copytree(source_path, renamed_path)
                elif response == 'skip':
                    continue
            else:
                if item_type == "0":
                    shutil.copy(source_path, destination_path)
                elif item_type == "1":
                    if not os.path.isdir(source_path):
                        messagebox.showinfo("Error", f"{source_path} is not a valid directory.")
                        continue
                    shutil.copytree(source_path, destination_path)

        messagebox.showinfo('Success', 'Copied successfully')

    def copy_files(self):
        selected_items = self.listbox.curselection()

        self.copied_files = []
        for index in selected_items:
            item = self.listbox.get(index)
            item_type, item_name = item.split(" ", 1)
            self.copied_files.append((item_type, item_name))


root = tk.Tk()
app = FileManagerApp(root)
root.mainloop()
