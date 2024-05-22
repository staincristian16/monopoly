
package GUI;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private List<Casilla> casillas;
    private List<Jugador> jugadores;
    private int turnoActual;

    public Tablero(int numeroJugadores) {
        casillas = new ArrayList<>(40);
        jugadores = new ArrayList<>(numeroJugadores);
        inicializarTablero();
        inicializarJugadores(numeroJugadores);
        turnoActual = 0;
        
    }

    private void inicializarTablero() {
        // Agregar las 40 posiciones (ejemplo simple)
        casillas.add(new Salida(0, "Salida"));
         casillas.add(new Propiedad(1, "Mediterranean Avenue", 60, 2, Color.MAGENTA));
        casillas.add(new Propiedad(3, "avenida Baltica", 60, 4, Color.MAGENTA));
        casillas.add(new Impuesto(4, "Impuesto sobre el ingreso", 200));
        casillas.add(new Propiedad(5, "estacion", 200, 25, Color.WHITE));
        casillas.add(new Propiedad(6, "avenida oriental", 100, 8, Color.CYAN));
        casillas.add(new Impuesto(7, "Impuesto sobre el ingreso", 200));
        casillas.add(new Propiedad(8, "avenida varmont", 100, 8, Color.CYAN));
        casillas.add(new Propiedad(9, "avenida connecticut", 120, 10,Color.CYAN));
        casillas.add(new Carcel(10, "Cárcel"));
        casillas.add(new Propiedad(11, "Plaza san carlos", 140, 12, Color.PINK));
        casillas.add(new Propiedad(12, "compañia de electricidad", 150, 15,Color.WHITE));
        casillas.add(new Propiedad(13, "avenida estados", 140, 12,Color.PINK));
        casillas.add(new Propiedad(14, "avenida virginia", 160, 14,Color.PINK));
        casillas.add(new Propiedad(15, "ferrocarril pennsylvania", 200, 25,Color.WHITE));
        casillas.add(new Propiedad(16, "plaza st. james", 180, 16,Color.ORANGE));
        casillas.add(new Impuesto(17, "Impuesto sobre el ingreso", 1500));
        casillas.add(new Propiedad(18, "avenida tennessee", 180, 16,Color.ORANGE));
        casillas.add(new Propiedad(19, "avenida nueva york", 200, 18,Color.ORANGE));
        casillas.add(new Propiedad(20, "parada libre", 0,0,Color.WHITE));
        casillas.add(new Propiedad(21, "avenida kentichy", 220, 20,Color.RED));
        casillas.add(new Impuesto(22, "Impuesto sobre el ingreso", 300));
        casillas.add(new Propiedad(23, "avenida indiana", 200, 20,Color.RED));
        casillas.add(new Propiedad(24, "avenida illinois", 220, 22,Color.RED));
        casillas.add(new Propiedad(25, "ferrocarril B.O", 200, 25,Color.WHITE));
        casillas.add(new Propiedad(26, "avenida atlantico", 260, 26,Color.YELLOW));
        casillas.add(new Propiedad(27, "avenida ventnor", 260, 26,Color.YELLOW));
        casillas.add(new Propiedad(28, "servicio de agua", 150, 15,Color.WHITE));
        casillas.add(new Propiedad(29, "jardines marvin", 280, 28,Color.YELLOW));
        casillas.add(new Carcel(30, "carcel"));
        casillas.add(new Propiedad(31, "avenida pacifico", 300, 32,Color.GREEN));
        casillas.add(new Propiedad(32, "avenida carolina del norte", 300, 32,Color.GREEN));
        casillas.add(new Impuesto(33, "Impuesto sobre el ingreso", 200));
        casillas.add(new Propiedad(34, "avenida pennylvania", 320, 34,Color.GREEN));
        casillas.add(new Propiedad(35, "ferrocarril via rapida", 200, 25,Color.WHITE));
        casillas.add(new Impuesto(6, "Impuesto sobre el ingreso", 300));
        casillas.add(new Propiedad(37, "plaza park", 350, 35,Color.BLUE));
        casillas.add(new Impuesto(38, "Impuesto sobre el ingreso", 200));
        casillas.add(new Propiedad(39, "Muelle", 400, 50,Color.BLUE));
        
        
    }
    private void inicializarJugadores(int numeroJugadores) {
        for (int i = 1; i <= numeroJugadores; i++) {
            jugadores.add(new Jugador("Jugador " + i, 1500)); 
        }
    }

    public List<Casilla> getCasillas() {
        return casillas;
    }
     public List<Jugador> getJugadores() {
        return jugadores;
    }

    public Jugador getJugadorActual() {
        return jugadores.get(turnoActual);
    }

    public void siguienteTurno() {
        turnoActual = (turnoActual + 1) % jugadores.size();
    }
    public void verificarEliminacionJugadores() {
        for (Jugador jugador : jugadores) {
            if (!jugador.estaActivo()) {
                for (Propiedad propiedad : jugador.getPropiedades()) {
                    propiedad.setPropietario(null);
                }
                jugador.getPropiedades().clear();
            }
        }
    }

    public boolean hayGanador() {
        int jugadoresActivos = 0;
        for (Jugador jugador : jugadores) {
            if (jugador.estaActivo()) {
                jugadoresActivos++;
            }
        }
        return jugadoresActivos == 1;
    }

    public Jugador getGanador() {
        for (Jugador jugador : jugadores) {
            if (jugador.estaActivo()) {
                return jugador;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Casilla casilla : casillas) {
            sb.append(casilla).append("\n");
        }
        return sb.toString();
    }
}

