
package GUI;

import java.util.ArrayList;
import java.util.List;


public class Jugador {
    private String nombre;
    private int posicion;
    private int dinero;
    private List<Propiedad> propiedades;
    private int turnosPerdidos;
    private boolean activo; 

    public Jugador(String nombre, int dineroInicial) {
        this.nombre = nombre;
        this.posicion = 0; 
        this.dinero = dineroInicial;
        this.propiedades = new ArrayList<>();
        this.turnosPerdidos = 0; 
        this.activo = true; 
    }

    public String getNombre() {
        return nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public int getDinero() {
        return dinero;
    }

    public void mover(int espacios) {
        if (turnosPerdidos == 0) { 
            posicion = (posicion + espacios) % 40; 
        }
    }

    public void ajustarDinero(int monto) {
        dinero += monto;
        if (dinero < 0) {
            dinero = 0;
            activo = false; 
        }
    }
    public List<Propiedad> getPropiedades() {
        return propiedades;
    }

    public void agregarPropiedad(Propiedad propiedad) {
        propiedades.add(propiedad);
    }

    public void removerPropiedad(Propiedad propiedad) {
        propiedades.remove(propiedad);
    }

    public Propiedad getPropiedad(String nombre) {
        for (Propiedad propiedad : propiedades) {
            if (propiedad.getNombre().equals(nombre)) {
                return propiedad;
            }
        }
        return null;
    }

    public void pierdeTurnos(int numeroTurnos) {
        this.turnosPerdidos = numeroTurnos;
    }

    public boolean puedeMoverse() {
        return turnosPerdidos == 0;
    }

    public void decrementarTurnosPerdidos() {
        if (turnosPerdidos > 0) {
            turnosPerdidos--;
        }
    }

    public boolean estaActivo() {
        return activo;
    }

    @Override
    public String toString() {
        return nombre + " - Posición: " + posicion + " - Dinero: $" + dinero + " - Turnos Perdidos: " + turnosPerdidos + " - Activo: " + activo;
    }

    String getTurnosPerdidos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

