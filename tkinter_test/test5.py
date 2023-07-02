import os
import shutil
import tkinter as tk
from tkinter import filedialog, messagebox, Listbox, MULTIPLE, END,ttk
import tkinter.simpledialog as simpledialog

import ttkbootstrap as nani
import zipfile
import time
import pwd
import grp

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




home = '/home/anon/'

class FileManagerApp:
    def __init__(self, root):
        
        self.root = root
        self.root.title("File Manager")
        self.root.geometry('1920x1080')
        self.current_directory = "/home/anon"
        
        self.help_button = tk.Button(root, text='Help',command=self.help_function)
        
        self.label2= tk.Label(root,text=self.current_directory)
        self.back_button = tk.Button(root, text="Back", command=self.go_back)
        self.home_button = tk.Button(root, text='Home', command=self.go_home)
        self.copy_button = tk.Button(root, text="Copy", command=self.copy_files, state='disabled')
        self.rename_button = tk.Button(root, text="Rename", command=self.rename_files, state='disabled')
        self.create_file_button = tk.Button(root, text="Create file", command=self.create_file)
        self.create_directory_button = tk.Button(root, text="Create folder", command=self.create_directory)
        self.delete_button = tk.Button(root, text="Delete", command=self.delete, state='disabled')
        self.search_button = tk.Button(root, text="Search", command=self.search)
        self.zip_button = tk.Button(root, text="Zip", command=self.zip_content, state='disabled')
        self.unzip_button = tk.Button(root, text="Unzip", command=self.unzip_content, state='disabled')
        self.open_with_button =tk.Button(root, text='Open with',command=self.open_with)
        self.properties_button = tk.Button(root, text="Properties", command=self.properties_content, state='disabled')
        self.change_permission_button = tk.Button(root,text='Change\npermission',command=self.change_permission)




        self.entry = tk.Entry(root, width=50)
        self.move_button = tk.Button(root, text="Move", command=self.move_files, state='disabled')  
        self.paste_button = tk.Button(root, text="Paste", command=self.paste_files, state='disabled')
        self.paste_here_button = tk.Button(root,text='Paste here',command=self.paste_files_here)
        self.frame = tk.Frame(root)
        self.listbox = Listbox(self.frame, selectmode=MULTIPLE, width=190, height=45)

        
        self.help_button.grid(row=2, column=0, padx=10, pady=10)
        self.back_button.grid(row=0, column=1, padx=10, pady=10)
        self.copy_button.grid(row=0, column=2, padx=10, pady=10)
        self.rename_button.grid(row = 2 , column= 6,padx=10,pady=10)
        self.zip_button.grid(row = 2 , column= 5,padx=5,pady=10)
        self.unzip_button.grid(row = 0 , column= 5,padx=5,pady=10)
        self.open_with_button.grid(row = 0 , column= 6,padx=5,pady=10)
        self.properties_button.grid(row = 0 , column= 3,padx=10,pady=10)
        self.delete_button.grid(row = 0 , column= 4,padx=10,pady=10)
        self.entry.grid(row=1, column=0, padx=10, pady=10)  
        
        self.label2.grid(row=0, column=0, padx=10, pady=10)
        self.home_button.grid(row=1, column=3, padx=10, pady=10)
        self.change_permission_button.grid(row=1, column=4, padx=10, pady=10)
        self.paste_here_button.grid(row=1, column=2, padx=10, pady=10)

        self.search_button.grid(row=1, column=1, padx=10, pady=10)
        self.move_button.grid(row=2, column=1, padx=10, pady=10)  
       
        self.paste_button.grid(row=2, column=2, padx=10, pady=10)  
        self.create_file_button.grid(row=2, column=3, padx=10, pady=10)
        self.create_directory_button.grid(row=2, column=4, padx=10, pady=10)
        self.frame.grid(row=3, column=0, columnspan=7, padx=10, pady=10)
        self.listbox.pack(side="left", fill="both", expand=True)

        self.listbox.bind("<Double-Button-1>", self.double_tap_action)

        self.listbox.bind("<<ListboxSelect>>", self.on_listbox_select)

        self.update_file_list()

    def unzip_content(self):
        selected_items = self.listbox.curselection()
        if not selected_items:
            return

        for index in selected_items:
            item = self.listbox.get(index)
            item_name = item.split(" ", 1)[1]
            item_path = os.path.join(self.current_directory, item_name)

            if item.startswith("1"):  
                continue

            if item_name.endswith(".zip"):
                folder_name = os.path.splitext(item_name)[0]
                folder_name = '(unzipped) ' + folder_name
                folder_path = os.path.join(self.current_directory, folder_name)

                try:
                    os.makedirs(folder_path, exist_ok=True)
                    shutil.unpack_archive(item_path, folder_path)
                    # os.remove(item_path) 
                    messagebox.showinfo("Unzip Successful", f"{item_name} has been unzipped.")
                except Exception as e:
                    messagebox.showerror("Error", f"Failed to unzip {item_name}. Error: {e}")

        self.update_file_list()
    
    def go_home(self):
        self.current_directory = home
        self.update_file_list()
    
    def open_with(self):
        selected_items = self.listbox.curselection()
        if len(selected_items) == 0:
            messagebox.showinfo("Error", "No file selected.")
            return

        selected_filenames = []
        for item in selected_items:
            file_info = self.listbox.get(item).split()
            file_name = " ".join(file_info[1:])
            selected_filenames.append(file_name)

        for filename in selected_filenames:
            file_path = os.path.join(self.current_directory, filename)
            os.system(f"xdg-open {file_path}")



    def help_function(self):
        messagebox.showinfo("Help", "Welcome to the Help Section\n\nThis is a file manager which is capable of doing the following things:\n\n1.Copy your files and folders\n2.Move your files and folders\n3.Delete your files and folders\n4.Rename your files and folders\n5.Search your files and folders\n6.Zip your files and folders\n7.Create new files and folders\n8.Change permissions of your files and folders\n\nThank you for reading.")

    
    def change_permission(self):
        selected_items = self.listbox.curselection()
        permission_number = self.entry.get()

        if not permission_number.isdigit():
            messagebox.showerror("Invalid Permission", "Please enter a valid permission number.")
            return

        permission_number = permission_number.zfill(3)

        if int(permission_number) < 0 or int(permission_number) > 777:
            messagebox.showerror("Invalid Permission", "Permission number must be between 000 and 777.")
            return

        for index in selected_items:
            item = self.listbox.get(index)
            item_type, item_name = item.split(" ", 1)

            item_path = os.path.join(self.current_directory, item_name)
            try:
                os.chmod(item_path, int(permission_number, 8))
            except OSError:
                messagebox.showerror("Permission Change Failed", f"Failed to change permission for {item_name}.")

        self.update_file_list()
    
    def paste_files_here(self):
        destination_directory = self.current_directory

        if not destination_directory or not os.path.isdir(destination_directory):
            messagebox.showinfo("Error", "Please enter a valid destination directory.")
            return

        for item_type, item_name in self.copied_files:
            source_path = os.path.join(self.current_directory, item_name)
            destination_path = os.path.join(destination_directory, item_name)

            if os.path.exists(destination_path):
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

    def rename_files(self):
        selected_items = self.listbox.curselection()

        new_name = self.entry.get()
        if not new_name:
            messagebox.showinfo("Caution", "Enter the new name in the entry field")
            return

        selected_item = self.listbox.get(selected_items[0])
        item_type, item_name = selected_item.split(" ", 1)
        source_path = os.path.join(self.current_directory, item_name)
        destination_path = os.path.join(self.current_directory, new_name)

        if os.path.exists(destination_path):
            messagebox.showinfo("Error", "A file or folder with the same name already exists.")
            return

        try:
            os.rename(source_path, destination_path)
            self.update_file_list()
            self.entry.delete(0, "end")
            self.rename_button.config(state=tk.DISABLED)
            messagebox.showinfo("Success", "Renamed successfully.")
        except Exception as e:
            messagebox.showinfo("Error", f"An error occurred: {str(e)}")  

        

    
    def properties_content(self):
        selected_items = self.listbox.curselection()
        if len(selected_items) == 0:
            messagebox.showinfo("Properties", "No item selected.")
            return
        
        item = self.listbox.get(selected_items[0])
        item_path = os.path.join(self.current_directory, item[2:])
        properties = ""
        
        if os.path.exists(item_path):
            if os.path.isdir(item_path):
                properties += f"Type: Directory\n"
            else:
                properties += f"Type: File\n"
            
            properties += f"Path: {item_path}\n"
            properties += f"Size: {os.path.getsize(item_path)} bytes\n"
            properties += f"Created: {time.ctime(os.path.getctime(item_path))}\n"
            properties += f"Last modified: {time.ctime(os.path.getmtime(item_path))}\n"
            properties += f"Owner: {pwd.getpwuid(os.stat(item_path).st_uid).pw_name}\n"
            properties += f"Group: {grp.getgrgid(os.stat(item_path).st_gid).gr_name}\n"
            properties += f"Permissions: {oct(os.stat(item_path).st_mode)[-3:]}\n"
            
            if not os.path.isdir(item_path):
                properties += f"Extension: {os.path.splitext(item_path)[1]}\n"
                properties += f"Readable: {os.access(item_path, os.R_OK)}\n"

                properties += f"Writable: {os.access(item_path, os.W_OK)}\n"
                properties += f"Executable: {os.access(item_path, os.X_OK)}\n"
                properties += f"Is Symbolic Link: {os.path.islink(item_path)}\n"
                properties += f"Parent Directory: {os.path.dirname(item_path)}\n"
            
            if os.path.isdir(item_path):
                properties += f"Contents: {', '.join(os.listdir(item_path))}\n"
                properties += f"Subdirectories: {len([name for name in os.listdir(item_path) if os.path.isdir(os.path.join(item_path, name))])}\n"
                properties += f"Files: {len([name for name in os.listdir(item_path) if os.path.isfile(os.path.join(item_path, name))])}\n"
        
        messagebox.showinfo("Properties", properties)


    def create_file(self):
        filename = self.entry.get()
        if not filename:
            messagebox.showinfo("Caution", "Enter the new name in the entry field")
            return
        file_path = os.path.join(self.current_directory, filename)
        if not os.path.exists(file_path):
            open(file_path, 'w').close()
            self.update_file_list()
            self.entry.delete(0, "end")
            messagebox.showinfo("Success", "File created successfully.")
        else:
            messagebox.showerror("Error", "A file with the same name already exists.")

    def create_directory(self):
        dirname = self.entry.get()
        if not dirname:
            messagebox.showinfo("Caution", "Enter the new name in the entry field")
            return
        dir_path =os.path.join(self.current_directory, dirname)
        if not os.path.exists(dir_path):
            os.mkdir(dir_path)
            self.update_file_list()
            self.entry.delete(0, "end")
            messagebox.showinfo("Success", "Directory created successfully.")
        else:
            messagebox.showerror("Error", "A directory with the same name already exists.")

    def delete(self):
        selected_items = self.listbox.curselection()
        self.deleted_files = []
        for index in selected_items:
            item = self.listbox.get(index)
            item_type, item_name = item.split(" ", 1)
            self.deleted_files.append((item_type, item_name))
        for item_type, item_name in self.deleted_files:
            source_path = os.path.join(self.current_directory, item_name)
            if item_type == "0": 
                os.remove(source_path)
            elif item_type == "1":  
                shutil.rmtree(source_path)
        
        self.delete_button.config(state=tk.DISABLED)
        
        self.update_file_list()
        messagebox.showinfo("Success", "Files deleted successfully")


    def search(self):
        search_term = self.entry.get()
        if not search_term:
            messagebox.showinfo("Caution", "Enter the search term in the entry field")
            return
        results = self._search_files( search_term)
        if results:
            message = f"Found {len(results)} instances of '{search_term}':\n"
            message += "\n".join(results)
            messagebox.showinfo("Search Results", message)
        else:
            messagebox.showinfo("Search Results", f"No instances of '{search_term}' found.")
    
    def _search_files(self, search_term):
        results = []
        for root, dirs, files in os.walk(home):
            for name in files + dirs:
                if search_term.lower() in name.lower():
                    results.append(os.path.join(root, name))
        return results

    def zip_content(self):
        zip_filename = self.entry.get()
        if not zip_filename:
            messagebox.showinfo("Caution", "Enter the zip file name in the entry field")
            return
        selected_indices = self.listbox.curselection()
        selected_items = [
            os.path.join(self.current_directory, self.listbox.get(idx).split(' ', 1)[1])
            for idx in selected_indices
        ]

        zip_filepath = os.path.join(self.current_directory, zip_filename + '.zip')
        with zipfile.ZipFile(zip_filepath, 'w') as zip_file:
            for item in selected_items:
                zip_file.write(item, os.path.basename(item))
        
        messagebox.showinfo("Zip Content", f"Items zipped successfully to '{zip_filepath}'.")
        self.update_file_list()
        
        self.zip_button.config(state=tk.DISABLED)


    def update_file_list(self):
        self.listbox.delete(0, END)

        items = os.listdir(self.current_directory)
        folders = []
        files = []

        for item in items:
            item_path = os.path.join(self.current_directory, item)
            if os.path.isdir(item_path):
                folders.append(item)
            else:
                files.append(item)

        folders.sort()
        files.sort()

        for folder in folders:
            self.listbox.insert(END, f"1 {folder}")

        for file in files:
            self.listbox.insert(END, f"0 {file}")

        self.label2.config(text=self.current_directory)


    def go_back(self):
        if self.current_directory != "/home/anon":
            self.current_directory = os.path.dirname(self.current_directory)

            self.update_file_list()

    def double_tap_action(self, event):
        selected_item = self.listbox.get(self.listbox.curselection())
        item_type, item_name = selected_item.split(" ", 1)
        if item_type == "1": 
            new_directory = os.path.join(self.current_directory, item_name)
            if os.path.isdir(new_directory):
                self.current_directory = new_directory
                cur_dir = new_directory
                self.update_file_list()
        elif item_type == '0':
            messagebox.showinfo("Open file", "Open file.")

    def copy_files(self):

        selected_items = self.listbox.curselection()

        self.copied_files = []
        for index in selected_items:
            item = self.listbox.get(index)
            item_type, item_name = item.split(" ", 1)
            self.copied_files.append((item_type, item_name))

        self.paste_button.config(state=tk.NORMAL)
        self.move_button.config(state=tk.NORMAL) 

    def paste_files(self):
        self.move_button.config(state=tk.DISABLED)  

        destination_directory = self.entry.get()


        if not destination_directory or not os.path.isdir(destination_directory):
            messagebox.showinfo("Error", "Please enter a valid destination directory.")
            return

        for item_type, item_name in self.copied_files:
            source_path = os.path.join(self.current_directory, item_name)
            destination_path = os.path.join(destination_directory, item_name)

            if os.path.exists(destination_path):
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

        self.update_file_list()
        self.entry.delete(0, "end")  

        self.paste_button.config(state=tk.DISABLED)
        self.move_button.config(state=tk.DISABLED)
        self.copy_button.config(state=tk.DISABLED)

    def move_files(self):
        self.paste_files()  
        self.delete_files() 
        messagebox.showinfo('Success','Moved sucessfully')
 

    def delete_files(self):
        for item_type, item_name in self.copied_files:
            source_path = os.path.join(self.current_directory, item_name)
            if item_type == "0": 
                os.remove(source_path)
            elif item_type == "1":  
                shutil.rmtree(source_path)

        self.update_file_list()

    def on_listbox_select(self, event):
        selected_items = self.listbox.curselection()
        if selected_items:
            if len(selected_items)==1:
                self.rename_button.config(state='normal')
                self.properties_button.config(state='normal')
            else:
                self.rename_button.config(state=tk.DISABLED)
                self.properties_button.config(state=tk.DISABLED)
    
            self.copy_button.config(state='normal')
            self.zip_button.config(state='normal')
            self.delete_button.config(state='normal')

            self.search_button.config(state=tk.DISABLED)



        else:
            self.copy_button.config(state=tk.DISABLED)
            self.rename_button.config(state=tk.DISABLED)
            self.zip_button.config(state=tk.DISABLED)
            self.delete_button.config(state=tk.DISABLED)
            self.properties_button.config(state=tk.DISABLED)

            
            self.search_button.config(state='normal')


root = nani.Window(themename='cosmo')
app = FileManagerApp(root)


root.mainloop()
