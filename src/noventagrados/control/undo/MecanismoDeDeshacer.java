package noventagrados.control.undo;

import java.util.Date;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;

/**
 * Interface que define el mecanismo para deshacer y rehacer jugadas dentro de un juego.
 * Proporciona métodos para consultar el árbitro actual, el número de jugadas en el historial,
 * y para realizar o deshacer jugadas.
 */
public interface MecanismoDeDeshacer {

    /**
     * Consulta el árbitro actual que está gestionando el juego.
     *
     * @return El árbitro actual.
     */
    public Arbitro consultarArbitroActual();

    /**
     * Consulta el número total de jugadas almacenadas en el historial de jugadas.
     *
     * @return El número de jugadas en el historial.
     */
    public int consultarNumeroJugadasEnHistorico();

    /**
     * Deshace la última jugada realizada, volviendo al estado anterior del juego.
     * Si no es posible deshacer (por ejemplo, si no hay jugadas previas), no realiza ninguna acción.
     */
    public void deshacerJugada();

    /**
     * Realiza una nueva jugada y la agrega al historial de jugadas.
     * 
     * @param jugada La jugada a realizar.
     */
    public void hacerJugada(Jugada jugada);

    /**
     * Obtiene la fecha de inicio del juego.
     *
     * @return La fecha y hora en que comenzó el juego.
     */
    public Date obtenerFechaInicio();
}
