package noventagrados.control.undo;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Tablero;

/**
 * Clase abstracta que implementa la interfaz.
 * Esta clase proporciona una implementación base para los mecanismos de deshcer y rehacer jugadas,
 * gestionando la fecha de inicio, los arbitros y el historial de jugada.
 * 
 * @author <a href="val1002@alu.ubu.es">Víctor Acevedo Lorenzo</a>
 * @author <a href="skx1024@alu.ubu.es">Sergiy Khoudoley</a>
 * @version 1.0
 * @since 1.0 
 */
abstract public class MecanismoDeDeshacerAbstracto implements MecanismoDeDeshacer {
    
    // Atributos
    /**
     * Fecha en que comenzó el juego o la sesión de jugadas.
     */
    protected Date fechaInicio;
    
    // Métodos concretos
    
    /**
     * Constructor que inicializa los atributos con la fecha de inicio proporcionada.
     * También inicializa las listas de arbitros y jugadas.
     * 
     * @param fecha La fecha de inicio del juego.
     */
    public MecanismoDeDeshacerAbstracto(Date fecha) {
        this.fechaInicio = fecha;
    }
    
    /**
     * Obtiene la fecha en que comenzó el juego o la sesion de jugadas.
     * 
     * @return La fecha de inicio.
     */
    public Date obtenerFechaInicio() {
        return this.fechaInicio;
    }
    
	/**
	 * Devuelve un arbitro nuevo con el estado incial
	 * 
	 * 
	 * @return Un arbitro
	 */
	private Arbitro crearNuevoArbitroInicial() {
		Arbitro nuevoArbitro = new Arbitro(new Tablero());
		nuevoArbitro.colocarPiezasConfiguracionInicial();
		return nuevoArbitro;
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
     * Realiza una nueva jugada y la agrega al historial.
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
