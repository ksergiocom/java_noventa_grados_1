package noventagrados.control.undo;

import java.util.Date;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;

public interface MecanismoDeDeshacer {
	public Arbitro consultarArbitroActual();
	public int consultarNumeroJugadasEnHistorico();
	public void deshacerJugada();
	public void hacerJugada(Jugada jugada);
	public Date obtenerFechaInicio();
}