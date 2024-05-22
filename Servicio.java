
package GUI;

public class Servicio extends Casilla {
    private int costoCompra;
    private int costoAlquiler;
    private String propietario;

    public Servicio(int posicion, String nombre, int costoCompra, int costoAlquiler) {
        super(posicion, nombre);
        this.costoCompra = costoCompra;
        this.costoAlquiler = costoAlquiler;
        this.propietario = null;
    }

    public int getCostoCompra() {
        return costoCompra;
    }

    public int getCostoAlquiler() {
        return costoAlquiler;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return super.toString() + " (Servicio) - Costo: " + costoCompra + " - Alquiler: " + costoAlquiler;
    }
}
