
package GUI;



import java.awt.Color;

public class Propiedad extends Casilla {
    private int costoCompra;
    private int costoAlquiler;
    private Jugador propietario;
    private Color color; 

    public Propiedad(int posicion, String nombre, int costoCompra, int costoAlquiler, Color color) {
        super(posicion, nombre);
        this.costoCompra = costoCompra;
        this.costoAlquiler = costoAlquiler;
        this.color = color;
    }

    public int getCostoCompra() {
        return costoCompra;
    }

    public int getCostoAlquiler() {
        return costoAlquiler;
    }

    public Jugador getPropietario() {
        return propietario;
    }

    public boolean tienePropietario() {
        return propietario != null;
    }

    public void comprar(Jugador jugador) {
        if (jugador.getDinero() >= costoCompra) {
            jugador.ajustarDinero(-costoCompra);
            propietario = jugador;
            jugador.agregarPropiedad(this);
        }
    }

    public void cobrarAlquiler(Jugador jugador) {
        if (tienePropietario() && propietario != jugador) {
            jugador.ajustarDinero(-costoAlquiler);
            propietario.ajustarDinero(costoAlquiler);
        }
    }

    public Color getColor() {
        return color;
    }

    void setPropietario(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
