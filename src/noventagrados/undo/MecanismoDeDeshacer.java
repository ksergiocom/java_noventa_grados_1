package noventagrados.undo;

import java.util.Date;

import noventagrados.control.Arbitro;

public interface MecanismoDeDeshacer {
	public Arbitro consultarArbitroActual();
	public int consultarNumeroJugadasEnHistorico();
	public void deshacerJugada();
	public void hacerJugada();
	public Date obtenerFechaInicio();
}