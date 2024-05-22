
package GUI;


public class Carcel extends Casilla {
    public Carcel(int posicion, String nombre) {
        super(posicion, nombre);
    }

    public void efectoCarceldelJugador(Jugador jugador) {
        // El jugador pierde 2 turnos
        jugador.pierdeTurnos(2);
    }
}
