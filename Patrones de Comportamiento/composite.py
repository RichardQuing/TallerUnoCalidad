from abc import ABC, abstractmethod

class ComponenteArchivo(ABC):
    @abstractmethod
    def mostrar(self,nivel=0):
        pass

class Archivo(ComponenteArchivo):
    def __init__(self,nombre):
        self.nombre = nombre

    def mostrar(self,nivel=0):
        print(" " * nivel + f"- {self.nombre}")

class Carpeta(ComponenteArchivo):
    def __init__(self,nombre):
        self.nombre = nombre
        self.componentes = []

    def agregar(self,componente):
        self.componentes.append(componente)

    def mostrar(self, nivel = 0):
        print(" " * nivel + f"+ [{self.nombre}]")
        for componente in self.componentes:
            componente.mostrar(nivel + 1)

archivo1 = Archivo("docuemnto.txt")
archivo2 = Archivo("imagen.tjpg")
archivo3 = Archivo("video.mp4")

carpeta1 = Carpeta("Mis Docuemntos")
carpeta1.agregar(archivo1)
carpeta1.agregar(archivo2)

carpeta2 = Carpeta("Videos")
carpeta2.agregar(archivo3)

carpeta_principal = Carpeta("/")
carpeta_principal.agregar(carpeta1)
carpeta_principal.agregar(carpeta2)

carpeta_principal.mostrar()