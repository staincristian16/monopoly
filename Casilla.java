
package GUI;


public abstract class Casilla {
    private int posicion;
    private String nombre;

    public Casilla(int posicion, String nombre) {
        this.posicion = posicion;
        this.nombre = nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
