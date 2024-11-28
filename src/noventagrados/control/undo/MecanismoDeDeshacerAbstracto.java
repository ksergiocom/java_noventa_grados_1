package noventagrados.control.undo;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Tablero;

/**
 * Clase abstracta que implementa la interfaz {@link MecanismoDeDeshacer}.
 * Esta clase proporciona una implementación base para los mecanismos de deshcer y rehacer jugadas,
 * gestionando la fecha de inicio, los arbitros y el historial de jugada.
 */
abstract public class MecanismoDeDeshacerAbstracto implements MecanismoDeDeshacer {
    
    // Atributos
    /**
     * Fecha en que comenzó el juego o la sesión de jugadas.
     */
    protected Date fechaInicio;
    
    /**
     * Lista de arbitros que pueden estar asociados al proceso de jugadas.
     */
    protected List<Arbitro> arbitros;
    
    /**
     * Lista que almacena el historial de jugadas realizadas.
     */
    protected List<Jugada> jugadas;
    
    // Métodos concretos
    
    /**
     * Constructor que inicializa los atributos con la fecha de inicio proporcionada.
     * También inicializa las listas de arbitros y jugadas.
     * 
     * @param fecha La fecha de inicio del juego.
     */
    public MecanismoDeDeshacerAbstracto(Date fecha) {
        this.fechaInicio = fecha;
        this.jugadas = new ArrayList<Jugada>();
        this.arbitros = new ArrayList<Arbitro>();
    }
    
    /**
     * Obtiene la fecha en que comenzó el juego o la sesion de jugadas.
     * 
     * @return La fecha de inicio.
     */
    public Date obtenerFechaInicio() {
        return this.fechaInicio;
    }
    
    // Métodos abstractos a implementar en cada clase concreta
    
    /**
     * Consulta el numero de jugadas almacenadas en el historial de jugadas.
     * 
     * @return El numero de jugadas en el historial.
     */
    public abstract int consultarNumeroJugadasEnHistorico();
    
    /**
     * Deshace la última jugada realizada, volviendo al estado anterior del juego.
     */
    public abstract void deshacerJugada();
    
    /**
     * Realiza una nueva jugada y la agrega al historial de jugadas.
     * 
     * @param jugada La jugada a realizar.
     */
    public abstract void hacerJugada(Jugada jugada);
    
    /**
     * Consulta el árbitro actual que está gestionando el juego.
     * 
     * @return El árbitro actual.
     */
    public abstract Arbitro consultarArbitroActual();
}
