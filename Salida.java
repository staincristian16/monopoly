
package GUI;



    public class Salida extends Casilla {
    public Salida(int posicion, String nombre) {
        super(posicion, nombre);
    }

    public void efectoPasarPorSalida(Jugador jugador) {
       
        jugador.ajustarDinero(200);
    }
}

