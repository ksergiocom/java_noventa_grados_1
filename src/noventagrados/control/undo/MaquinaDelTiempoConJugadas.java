package noventagrados.control.undo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Tablero;

/**
 * Creamos una clase pública llamada MaquinaDelTiempoConJugadas que hereda de 
 * MecanismosDeDeshacerAbstracto
 * 
 * @author Víctor Acevedo Lorenzo
 * @author Sergiy Khudoley
 * @version 1.0
 * @since 1.0
 * 
 */

public class MaquinaDelTiempoConJugadas extends MecanismoDeDeshacerAbstracto {

	/**
	 * Creamos método constructor que inicializa una MáquinaDelTiempoConJugadas pasando el
	 * parámetro fecha al constructor de la clase padre
	 * 
	 * @param fecha Fecha de inicio de la partida
	 */
	
	public MaquinaDelTiempoConJugadas(Date fecha) {
		super(fecha);
	}

	/**
	 * Deshacer la ultima jugada realizada.
	 */
	@Override
	public void deshacerJugada() {
		// Solo si existe y tiene algún elemento
		if(this.jugadas != null && this.jugadas.size()>0) {
			this.jugadas.removeLast();			
		}
	}

	/**
	 * Guardar una jugada como la ultima jugada realizada.
	 */
	@Override
	public void hacerJugada(Jugada jugada) {
		this.jugadas.addLast(jugada);
	}


	/**
	 * Consulta el estado actual del árbitro reconstruyendolo desde la posición inicial.
	 * Y crea un nuevo árbitro con la configuración inicial del tablero,
	 * aplica todas las jugadas realizadas desde el historial y devuelve el arbitro con el estado final.
	 * 
	 * @return Un arbitro con el estado actualizado después de aplicar todas las jugadas realizadas.
	 */
	
	@Override
	public Arbitro consultarArbitroActual() {
		// Creamos un nuevo arbitro
		Arbitro nuevoArbitro = new Arbitro(new Tablero());
		// Posición inicial de todas las piezas
		nuevoArbitro.colocarPiezasConfiguracionInicial();
		// Le aplicamos todas las jugadas realizadas
		for(Jugada jugada: this.jugadas) {
			nuevoArbitro.empujar(jugada);
			nuevoArbitro.cambiarTurno();
		}
		// Devolvemos el arbitro con el estado final
		return nuevoArbitro;
	}
	
    /**
     * Consulta el numero de jugadas almacenados en el historial.
     * 
     * @return El numero de jugadas almacenadas en el historial.
     */
	
	@Override
	public int consultarNumeroJugadasEnHistorico() {
		return this.jugadas.size();
	}
	
}
