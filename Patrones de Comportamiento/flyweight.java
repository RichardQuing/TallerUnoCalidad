import java.util.HashMap;
import java.util.Map;

class TipoVehiculo {
    private String nombre;
    private String color;
    private String sonido;

    public TipoVehiculo(String nombre, String color, String sonido) {
        this.nombre = nombre;
        this.color = color;
        this.sonido = sonido;
    }

    public void mostrar(int x, int y) {
        System.out.println("Mostrando vehículo " + nombre + " en [" + x + ", " + y + "] con color " + color + " y sonido " + sonido);
    }
}

class FabricaVehiculos {
    private static final Map<String, TipoVehiculo> tipos = new HashMap<>();

    public static TipoVehiculo obtenerTipo(String nombre, String color, String sonido) {
        if (!tipos.containsKey(nombre)) {
            System.out.println("Creando nuevo tipo de vehículo: " + nombre);
            tipos.put(nombre, new TipoVehiculo(nombre, color, sonido));
        }
        return tipos.get(nombre);
    }
}

class Vehiculo {
    private int x, y;
    private TipoVehiculo tipo;

    public Vehiculo(int x, int y, TipoVehiculo tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
    }

    public void dibujar() {
        tipo.mostrar(x, y);
    }
} 

public class flyweight {
    public static void main(String[] args) {
        TipoVehiculo tipoCoche = FabricaVehiculos.obtenerTipo("Coche", "Rojo", "sonido_coche.mp3");
        TipoVehiculo tipoMoto = FabricaVehiculos.obtenerTipo("Moto", "Negra", "sonido_moto.mp3");

        Vehiculo[] vehiculos = {
            new Vehiculo(10, 20, tipoCoche),
            new Vehiculo(50, 20, tipoCoche),
            new Vehiculo(-10, 20, tipoMoto),
            new Vehiculo(0, 0, tipoMoto)
        };

        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.dibujar();
        }
    }
}
