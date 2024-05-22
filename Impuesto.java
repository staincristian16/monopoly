
package GUI;


public class Impuesto extends Casilla {
    private int monto;

    public Impuesto(int posicion, String nombre, int monto) {
        super(posicion, nombre);
        this.monto = monto;
    }

    public int getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return super.toString() + "(Impuesto) - Monto: " + monto;
    }
}
