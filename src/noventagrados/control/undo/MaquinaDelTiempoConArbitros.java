package noventagrados.control.undo;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;

public class MaquinaDelTiempoConArbitros extends MecanismoDeDeshacerAbstracto {
	public MaquinaDelTiempoConArbitros(Date fecha) {
		this.fechaInicio = fecha;
	}

	@Override
	public void deshacerJugada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hacerJugada(Jugada jugada) {
		// TODO Auto-generated method stub
		
	}
}
