import java.util.ArrayList;
import java.util.List;

abstract class ComponenteArchivo {
    public abstract void mostrar(int nivel);
}

class Archivo extends ComponenteArchivo {
    private String nombre;

    public Archivo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void mostrar(int nivel) {
        System.out.println(" ".repeat(nivel) + "- " + nombre);
    }
}

class Carpeta extends ComponenteArchivo {
    private String nombre;
    private List<ComponenteArchivo> componentes;

    public Carpeta(String nombre) {
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }

    public void agregar(ComponenteArchivo componente) {
        componentes.add(componente);
    }

    @Override
    public void mostrar(int nivel) {
        System.out.println(" ".repeat(nivel) + "+ [" + nombre + "]");
        for (ComponenteArchivo componente : componentes) {
            componente.mostrar(nivel + 1);
        }
    }
}

public class composite {
    public static void main(String[] args) {
        Archivo archivo1 = new Archivo("proyecto_final.java");
        Archivo archivo2 = new Archivo("presentacion.pptx");
        Archivo archivo3 = new Archivo("reporte.pdf");

        Carpeta carpeta1 = new Carpeta("Trabajo");
        carpeta1.agregar(archivo1);
        carpeta1.agregar(archivo2);

        Carpeta carpeta2 = new Carpeta("Documentos");
        carpeta2.agregar(archivo3);

        Carpeta carpetaPrincipal = new Carpeta("/");
        carpetaPrincipal.agregar(carpeta1);
        carpetaPrincipal.agregar(carpeta2);

        carpetaPrincipal.mostrar(0);
    }
}
