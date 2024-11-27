package noventagrados.control.undo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Tablero;

public class MaquinaDelTiempoConJugadas extends MecanismoDeDeshacerAbstracto {
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
	 * Jugardar una jugada como la ultima jugada realizada.
	 */
	@Override
	public void hacerJugada(Jugada jugada) {
		this.jugadas.addLast(jugada);
	}

	/**
	 * Devolvemos un clon del arbitro con el estado tras realizar todas las jugadas.
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
	
	@Override
	public int consultarNumeroJugadasEnHistorico() {
		return this.jugadas.size();
	}
	
}
