package noventagrados.control;

import java.util.Objects;

import noventagrados.modelo.Celda;
import noventagrados.modelo.Pieza;
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

		// SOLO 1 RETURN SO BRUTO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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

	/**
	 * El método consultarNumeroPiezas retorna el número de piezas del tipo y color
	 * indicado sobre el tablero.
	 * 
	 * @param tipoPieza
	 * @param color
	 * @return int (numero de piezas)
	 */
	public int calcularNumeroPiezas(TipoPieza tipoPieza, Color color) {
		int numPiezas = 0;
		/*
		 * El tablero tiene un método para recorrer todas las celdas Iteramos todas las
		 * celdas y si son del tipo y color entonces sumamos el contador.
		 */
		// Esto lo hago por claridad
		Celda[] arrayCeldasTablero = this.tablero.consultarCeldas();
		// No se usar un foreach todavía
		for(int i=0; i<arrayCeldasTablero.length; i++) {
			Celda celdaIterada = arrayCeldasTablero[i];
			// Eh! Me has metido un metodo consultarColorDePieza pero no un metodo ConsultarTipoPieza!!!!!!!!!
			if(celdaIterada.consultarColorDePieza()==color && celdaIterada.consultarPieza().consultarTipoPieza() == tipoPieza) {
				numPiezas++;
			}
		}

		// SOY GILIPOLLAS, lo voy a dejar aquí para nunca olvidarlo
		//		/* Voy a iterar todas las celdas posibles. Vamos a utilizar los metodos de consultar columnas y filas
		//		 * para sacar el máximo de coordenadas por si cambiamos de tamñao de tablero.
		//		 */
		//		int numFilas = this.tablero.consultarNumeroFilas();
		//		int numColumnas = this.tablero.consultarNumeroColumnas();
		//		
		//		for(int i=0; i<numFilas; i++) {
		//			for(int j=0; j<numColumnas; j++) {
		//				this.tablero.consult
		//			}
		//		}

		return numPiezas;
	}

	/**
	 * El método consultarNumeroPiezasEnHorizontal retorna el número de piezas contenidas en la 
	 * misma horizontal de la coordenada dada, incluyendo a la pieza en dicha coordenada, si existe,
	 * y con independencia del color de las piezas.
	 * 
	 * @param coordenada
	 * @return int
	 */
	public int calcularNumeroPiezasEnHorizontal(Coordenada coordenada) {
		int numPiezas = 0;
		// Primero comprobamos si la coordenada es válida
		if(!this.tablero.estaEnTablero(coordenada)) return numPiezas;
		
		// En caso de que esté dentro del tablero. Busco el tamaño de la fila (será el n de columnas, porque
		// presupongo que es cuadrada, todas las filas son del mismo tamaño.
		int tamañoFila = this.tablero.consultarNumeroColumnas();
		
		// Itero las celdas de la fila y compruebo si tiene una pieza
		for(int i=0; i<tamañoFila; i++) {
			Coordenada coordeanadaAIterar = new Coordenada(coordenada.fila(), i);
			Celda celdaIterada = this.tablero.consultarCelda(coordeanadaAIterar);
			if(celdaIterada.consultarPieza() != null) numPiezas++;
		}
		
		return numPiezas;
	}

	/**
	 * El método consultarNumeroPiezasEnHorizontal retorna el número de piezas contenidas en la 
	 * misma horizontal de la coordenada dada, incluyendo a la pieza en dicha coordenada, si existe,
	 * y con independencia del color de las piezas.
	 * 
	 * @param coordenada
	 * @return int
	 */
	public int calcularNumeroPiezasEnVertical(Coordenada coordenada) {
		int numPiezas = 0;
		// Primero comprobamos si la coordenada es válida
		if(!this.tablero.estaEnTablero(coordenada)) return numPiezas;
		
		// En caso de que esté dentro del tablero. Busco el tamaño de la columna (será el n de filas, porque
		// presupongo que es cuadrada, todas las columnas son del mismo tamaño.
		int tamanoColumna = this.tablero.consultarNumeroColumnas();
		
		// Itero las celdas de la fila y compruebo si tiene una pieza
		for(int i=0; i<tamanoColumna; i++) {
			Coordenada coordeanadaAIterar = new Coordenada(i, coordenada.columna());
			Celda celdaIterada = this.tablero.consultarCelda(coordeanadaAIterar);
			if(celdaIterada.consultarPieza() != null) numPiezas++;
		}
		
		return numPiezas;
	}

	/**
	 * Consulta si la reina del color indicado ocupa la celda central.
	 * 
	 * @param color
	 * @return boolean
	 */
	public boolean estaReinaEnElCentro(Color color) {
		// Vamos a hardcodear el centro a (3,3)
		Coordenada coordenadaCentro = new Coordenada(3,3);
		Celda celdaCentro = this.tablero.consultarCelda(coordenadaCentro);
		
		// NO QUIERO FORMATEAR ESTO! SE VE MEJOR ASí!!!!!!!!
		if(
				celdaCentro.consultarPieza() != null &&
				celdaCentro.consultarPieza().consultarTipoPieza() == TipoPieza.REINA &&
				celdaCentro.consultarColorDePieza() == color
				) {
			return true;
		}
		
		// Si no coincide todo eso es que no está
		return false;
	}

	/**
	 * Comprueba si la reina del color indicado está todavía sobre el tablero.
	 * 
	 * @param color
	 * @return boolean
	 */
	public boolean hayReina(Color color) {
		// Buscamos todas las celdas
		Celda[] celdasTablero = this.tablero.consultarCeldas();
		
		// Iteramos cada celda para comprobar su pieza
		for(int i=0; i<celdasTablero.length; i++) {
			// Por claridad lo vamos haciendo pasito a pasito
			Celda celdaIterada = celdasTablero[i];
			Pieza piezaDeLaCelda = celdaIterada.consultarPieza();
			
			// NO PIENSO FORMATEAR ESTO!!!!!!!!!! PORQUE SE VE MEJOR ASÍ!
			// Si es la reina salirse con true
			if(
				piezaDeLaCelda != null &&
				piezaDeLaCelda.consultarTipoPieza() == TipoPieza.REINA &&
				piezaDeLaCelda.consultarColor() == color
					) {
				return true;
			}
			
		}
		
		// Si no se ha encontrado es que false
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tablero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableroConsultor other = (TableroConsultor) obj;
		return Objects.equals(tablero, other.tablero);
	}

	@Override
	public String toString() {
		return "TableroConsultor [tablero=" + tablero + "]";
	}

	
}
