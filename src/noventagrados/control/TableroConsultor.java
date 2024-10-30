package noventagrados.control;

import noventagrados.modelo.Tablero;

import noventagrados.util.Sentido;
import noventagrados.util.Coordenada;
import noventagrados.util.TipoPieza;
import noventagrados.util.Color;

public class TableroConsultor {
	private Tablero tablero;
	
	public TableroConsultor(Tablero tablero) {
		// Pass
	}
	
	public Sentido calcularSentido(Coordenada origen, Coordenada destino) {
		// Pass
		return Sentido.HORIZONTAL_E;
	}
	
	public int calcularDistanciaEnHorizontal(Coordenada origen, Coordenada destino) {
		return 1;
	}
	
	public int calcularDistanciaEnVertical(Coordenada origen, Coordenada destino) {
		return 1;
	}
	
	public int calcularNumeroPiezas(TipoPieza tipoPieza, Color color) {
		return 1;
	}
	
	public int calcularNumeroPiezasEnHorizontal(Coordenada coordenada) {
		return 1;
	}
	
	public int calcularNumeroPiezasEnVertical(Coordenada coordenada) {
		return 1;
	}
	
	public boolean estaReinaEnElCentro(Color color) {
		return false;
	}
	
	public boolean hayReina(Color color) {
		return false;
	}
	
	// Falta el toString()
}
