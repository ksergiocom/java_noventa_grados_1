package noventagrados.control;

import noventagrados.modelo.Tablero;

import noventagrados.util.Sentido;
import noventagrados.util.Coordenada;
import noventagrados.util.TipoPieza;
import noventagrados.util.Color;

public class TableroConsultor {
	private Tablero tablero;

	public TableroConsultor(Tablero tablero) {
		this.tablero = tablero.clonar(); // Clonamos tablero para hacer consultas
	}

	public Sentido calcularSentido(Coordenada origen, Coordenada destino) {
		int diferenciaFilas = destino.fila() - origen.fila();
		int diferenciaColumnas = destino.columna() - origen.columna();

		if (diferenciaFilas < 0 && diferenciaColumnas == 0) {
			return Sentido.VERTICAL_N;
		} else if (diferenciaFilas > 0 && diferenciaColumnas == 0) {
			return Sentido.VERTICAL_S;
		} else if (diferenciaFilas == 0 && diferenciaColumnas > 0) {
			return Sentido.HORIZONTAL_E;
		} else if (diferenciaFilas == 0 && diferenciaColumnas < 0) {
			return Sentido.HORIZONTAL_O;
		} else {
			return null; // No es un sentido válido
		}
	}

	// OJO!!! Estamos calculando solo el valor escalar "por eso hacemos valor
	// absoluto"

	public int consultarDistanciaEnHorizontal(Coordenada origen, Coordenada destino) {
		if (origen.fila() == destino.fila()) { // Verificamos si están en la misma fila
			return Math.abs(destino.columna() - origen.columna()); // Calculamos distancia entre columnas
		} else {
			return -1;
		}
	}

	public int consultarDistanciaEnVertical(Coordenada origen, Coordenada destino) {
		if (origen.columna() == destino.columna()) {// Verificamos si están en la misma columna
			return Math.abs(destino.fila() - origen.fila()); // Calculamos la distancia entre filas

		} else {
			return -1;
		}
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
