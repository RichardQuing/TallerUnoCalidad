
class TipoEnemigo:
    def __init__(self, nombre, textura, sonido):
        self.nombre = nombre
        self.textura = textura
        self.sonido = sonido

    def mostrar(self, x, y):
        print(f"Mostrando {self.nombre} en [{x}, {y}] con texto {self.textura} y sonido {self.sonido}")

class FabricaEnemigos:
    _tipos = {}

    @staticmethod
    def obtener_tipo(nombre, textura, sonido):
        if nombre not in FabricaEnemigos._tipos:
            print(f"Creando nuevo tipo de enemigos: {nombre}")
            FabricaEnemigos._tipos[nombre] = TipoEnemigo(nombre, textura, sonido)
        return FabricaEnemigos._tipos[nombre]

class Enemigo:
    def __init__(self, x, y, tipo):
        self.tipo = tipo
        self.x = x
        self.y = y
        
    def dibujar(self):
        self.tipo.mostrar(self.x, self.y)

tipo_orco = FabricaEnemigos.obtener_tipo("Orco", "orco.png", "sonido_orco.mp3")
tipo_elfo = FabricaEnemigos.obtener_tipo("Elfo", "elfo.png", "sonido_elfo.mp3")

enemigos = [
    Enemigo(10, 20, tipo_orco),
    Enemigo(50, 20, tipo_orco),
    Enemigo(-10, 20, tipo_elfo),
    Enemigo(0, 0, tipo_elfo),
]


for enemigo in enemigos:
    enemigo.dibujar()