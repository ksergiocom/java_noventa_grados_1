package noventagrados.control.undo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;

public class MaquinaDelTiempoConJugadas extends MecanismoDeDeshacerAbstracto {
	public MaquinaDelTiempoConJugadas(Date fecha) {
		super();
        this.jugadas = new ArrayList<>();
	}
	/**
	 * Remueve la ultima jugada realizada de nuestro historico de jugadas.
	 */
	@Override
	public void deshacerJugada() {		
		this.jugadas.removeLast();
	}

	/**
	 * Agrega la jugada en la ultima posicion de nuestro historico de jugadas.
	 */
	@Override
	public void hacerJugada(Jugada jugada) {
		this.jugadas.addLast(jugada);
	}
	
	
}
