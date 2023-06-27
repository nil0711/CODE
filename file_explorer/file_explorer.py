import ctypes as ct

c_file = "/home/anon/CODE/file_explorer/file_opretion.so"

c_fun = ct.CDLL(c_file)

a = c_fun.hello()

print(a)

c_fun.diplay(b"Anu Kumari",30)

