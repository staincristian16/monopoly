
package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableroPanel extends JPanel {
    private Tablero tablero;
    private Dado dado;
    private JTextArea textArea;
   
private void realizarTurno() {
    Jugador jugadorActual = tablero.getJugadorActual();
    if (!jugadorActual.puedeMoverse()) {
        jugadorActual.decrementarTurnosPerdidos();
        textArea.append(jugadorActual.getNombre() + " está en la cárcel y pierde 2 turnos. Turnos restantes: " + jugadorActual.getTurnosPerdidos() + "\n");
        actualizarTextArea();
        tablero.siguienteTurno();
        return;
    }

    int resultadoDado = dado.lanzar();
    jugadorActual.mover(resultadoDado);
    Casilla casillaActual = tablero.getCasillas().get(jugadorActual.getPosicion());

    if (casillaActual instanceof Propiedad) {
        Propiedad propiedad = (Propiedad) casillaActual;
        if (!propiedad.tienePropietario()) {
            int opcion = JOptionPane.showConfirmDialog(this, jugadorActual.getNombre() + ", ¿quieres comprar " + propiedad.getNombre() + " por $" + propiedad.getCostoCompra() + "?", "Compra de Propiedad", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                propiedad.comprar(jugadorActual);
                textArea.append(jugadorActual.getNombre() + " compró " + propiedad.getNombre() + ".\n");
            }
        } else {
            propiedad.cobrarAlquiler(jugadorActual);
            textArea.append(jugadorActual.getNombre() + " pagó $" + propiedad.getCostoAlquiler() + " de alquiler a " + propiedad.getPropietario().getNombre() + ".\n");
        }
    } else if (casillaActual instanceof Carcel) {
        ((Carcel) casillaActual).efectoCarceldelJugador(jugadorActual);
        textArea.append(jugadorActual.getNombre() + " cayó en la cárcel y pierde 2 turnos.\n");
    } else if (casillaActual instanceof Salida) {
        ((Salida) casillaActual).efectoPasarPorSalida(jugadorActual);
        textArea.append(jugadorActual.getNombre() + " pasó por la salida y ganó $200.\n");
    }

    actualizarTextArea();
    tablero.siguienteTurno();
    tablero.verificarEliminacionJugadores();
    verificarEstadoJuego();
}
private void verificarEstadoJuego() {
    if (tablero.hayGanador()) {
        Jugador ganador = tablero.getGanador();
        JOptionPane.showMessageDialog(this, ganador.getNombre() + " ha ganado el juego!");
    }
}



    public TableroPanel(int numeroJugadores) {
        this.tablero = new Tablero(numeroJugadores);
        this.dado = new Dado();
        this.textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        setLayout(new BorderLayout());
        JPanel tableroVisual = new JPanel(new GridLayout(4, 10));
        
        for (Casilla casilla : tablero.getCasillas()) {
            tableroVisual.add(new JLabel(casilla.toString()));
        }

        JButton lanzarDadoButton = new JButton("Lanzar Dado");
        lanzarDadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarTurno();
            }
        });

        add(tableroVisual, BorderLayout.CENTER);
        add(lanzarDadoButton, BorderLayout.SOUTH);
        add(new JScrollPane(textArea), BorderLayout.EAST);

        actualizarTextArea();
    }

    

    private void actualizarTextArea() {
        textArea.setText("");
        for (Jugador jugador : tablero.getJugadores()) {
            textArea.append(jugador + "\n");
        }
    }
    
    
    

    public static void main(String[] args) {
        int numeroJugadores = 6; // Puedes cambiar el número de jugadores aquí

        JFrame frame = new JFrame("Monopolio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.add(new TableroPanel(numeroJugadores));
        frame.setVisible(true);
    }
    
}
