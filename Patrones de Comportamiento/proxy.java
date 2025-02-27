interface ServicioMusica {
    void descargarCancion();
}

class ServicioMusicaReal implements ServicioMusica {
    private String cancion;

    public ServicioMusicaReal(String cancion) {
        this.cancion = cancion;
    }

    @Override
    public void descargarCancion() {
        System.out.println("Descargando la canción: " + cancion);
    }
}

class ProxyServicioMusica implements ServicioMusica {
    private String cancion;
    private String usuario;
    private ServicioMusicaReal servicioReal;

    public ProxyServicioMusica(String cancion, String usuario) {
        this.cancion = cancion;
        this.usuario = usuario;
        this.servicioReal = null;
    }

    @Override
    public void descargarCancion() {
        if ("premium".equals(usuario)) {
            if (servicioReal == null) {
                servicioReal = new ServicioMusicaReal(cancion);
            }
            servicioReal.descargarCancion();
        } else {
            System.out.println("Acceso denegado a la canción " + cancion + " para el usuario " + usuario + ". Necesitas una cuenta premium.");
        }
    }
}

public class proxy {
    public static void main(String[] args) {
        ServicioMusica cancion1 = new ProxyServicioMusica("Canción Exclusiva 1", "premium");
        cancion1.descargarCancion();

        ServicioMusica cancion2 = new ProxyServicioMusica("Canción Exclusiva 1", "normal");
        cancion2.descargarCancion();

        ServicioMusica cancion3 = new ProxyServicioMusica("Canción Exclusiva 2", "premium");
        cancion3.descargarCancion();
    }
}
