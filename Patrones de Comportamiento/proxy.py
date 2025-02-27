from abc import ABC, abstractmethod

class Archivo(ABC):
    @abstractmethod
    def leer(self):
        pass

class ArchivoReal(Archivo):
    def __init__(self, nombre):
        self.nombre = nombre

    def leer(self):
        print(f"Leyendo el contenido del archivo: {self.nombre}")

class ProxyArchivo(Archivo):
    def __init__(self, nombre, usuario):
        self.nombre = nombre
        self.usuario = usuario
        self.archivo_real = None

    def leer (self):
        if self.usuario == "admin":
            if not self.archivo_real:
                self.archivo_real = ArchivoReal(self.nombre)
            self.archivo_real.leer()
        else:
            print(f"Acceso denegado a {self.nombre} para el usuario {self.usuario}")

archivo1 = ProxyArchivo("datos_confidenciales.pdf", "admin")
archivo1.leer()

archivo2 = ProxyArchivo("datos_confidenciales.pdf", "user")
archivo2.leer()