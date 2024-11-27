package noventagrados.control;
import java.util.ArrayList;
import java.util.Objects;
import noventagrados.modelo.Celda;
import noventagrados.modelo.Pieza;
import noventagrados.modelo.Tablero;
import noventagrados.util.Sentido;
import noventagrados.util.Coordenada;
import noventagrados.util.TipoPieza;
import noventagrados.util.Color;

/**
 * Clase de utilidad para realizar consultas sobre un tablero.
 * 
 * @author Víctor Acevedo Lorenzo
 * @author Sergiy Khudoley
 * @version 1.0
 * @since 1.0
 * 
 */
public class TableroConsultor<T extends Tablero> {
	/**
	 * Tablero sobre el cual se realizan las consultas.
	 * 
	 * @see noventagrados.modelo.tablero
	 */
	private Tablero tablero;

	/**
	 * Consultor recibe un tablero sobre el cual realizará todas las consultas.
	 * 
	 * @param tablero Tablero a consultar
	 */
	public TableroConsultor(T tablero) {
		// Crear una nueva instancia de Tablero sin usar el método clonar()
		this.tablero = tablero;
	}

	/**
	 * Determina la dirección (sentido) entre
	 * dos coordenadas. El métod devuelve un valor de tipo sentido que indica la
	 * dirección del movimiento (norte, sur, este u oeste).
	 * 
	 * @param origen  La coordenada de origen desde la cual se realiza el
	 *                movimiento.
	 * @param destino La coordenada de destino a donde se realiza el movimiento.
	 * @return sentido El sentido de movimiento o null si el movimiento no es válido
	 */
	public Sentido calcularSentido(Coordenada origen, Coordenada destino) {
		int diferenciaFilas = destino.fila() - origen.fila();
		int diferenciaColumnas = destino.columna() - origen.columna();

		Sentido sentido = null; // Variable para almacenar el sentido

		if (diferenciaFilas < 0 && diferenciaColumnas == 0) {
			sentido = Sentido.VERTICAL_N;
		} else if (diferenciaFilas > 0 && diferenciaColumnas == 0) {
			sentido = Sentido.VERTICAL_S;
		} else if (diferenciaFilas == 0 && diferenciaColumnas > 0) {
			sentido = Sentido.HORIZONTAL_E;
		} else if (diferenciaFilas == 0 && diferenciaColumnas < 0) {
			sentido = Sentido.HORIZONTAL_O;
		}

		return sentido; // Solo un return
	}

	// OJO!!! Estamos calculando solo el valor escalar "por eso hacemos valor
	// absoluto"

	/**
	 * Calcula la distancia horizontal "columnas" entre dos coordenadas
	 * que estén en la misma fila, en caso de que las coordenadas no estén en la
	 * misma fila devolverá -1.
	 * 
	 * @param origen  La coordenada de origen
	 * @param destino La coordenada de destino.
	 * @return distancia La distancia en columnas entre las coordenadas, o -1 si no estaban en
	 *         la misma fila
	 */
	public int consultarDistanciaEnHorizontal(Coordenada origen, Coordenada destino) {
		if (origen.fila() == destino.fila()) { // Verificamos si están en la misma fila
			return Math.abs(destino.columna() - origen.columna()); // Calculamos distancia entre columnas
		} else {
			return -1;
		}
	}

	/**
	 * Calcula la distancia vertical "filas" entre dos coordenadas que
	 * estén en la misma columna, en caso de que las coordenadas no estén en la
	 * misma columna devolverá -1.
	 * 
	 * @param origen  La coordenada de origen
	 * @param destino La coordenada de destino.
	 * @return distancia La distancia en filas entre las coordenadas, o -1 si no estaban en la
	 *         misma columna
	 */
	public int consultarDistanciaEnVertical(Coordenada origen, Coordenada destino) {
		if (origen.columna() == destino.columna()) {// Verificamos si están en la misma columna
			return Math.abs(destino.fila() - origen.fila()); // Calculamos la distancia entre filas

		} else {
			return -1;
		}
	}

	/**
	 * Devuelve el número de piezas del tipo y color
	 * indicado sobre el tablero.
	 * 
	 * @param tipoPieza El tipo de pieza que se está buscando
	 * @param color     El color de las piezas que se están buscando
	 * @return numPiezas El número total de piezas del tipo y color especificados en el
	 *         tablero.
	 */
	public int consultarNumeroPiezas(TipoPieza tipoPieza, Color color) {
	    int numPiezas = 0;

	    // Consultar todas las celdas como una lista
	    ArrayList<Celda> listaCeldasTablero = this.tablero.consultarCeldas();

	    // Iterar sobre todas las celdas
	    for (Celda celdaIterada : listaCeldasTablero) {
	        if (celdaIterada.consultarColorDePieza() == color
	                && celdaIterada.consultarPieza() != null // Evitar NullPointerException
	                && celdaIterada.consultarPieza().consultarTipoPieza() == tipoPieza) {
	            numPiezas++;
	        }
	    }

	    return numPiezas;
	}

	/**
	 * Devuelve el número de piezas contenidas en la misma horizontal de la coordenada dada, incluyendo a la
	 * pieza en dicha coordenada, si existe, y con independencia del color de las piezas.
	 * 
	 * @param coordenada La coordenada cuya horizontal revisamos.
	 * 
	 * @return numPiezas El número total de piezas en la misma fila (horizontal) de
	 *         la coordenada, incluyendo la pieza en la coordenada dada si existe.
	 */
	public int consultarNumeroPiezasEnHorizontal(Coordenada coordenada) {
		int numPiezas = 0;
		// Primero comprobamos si la coordenada es válida
		if (!this.tablero.estaEnTablero(coordenada))
			return numPiezas;

		// En caso de que esté dentro del tablero. Busco el tamaño de la fila (será el n
		// de columnas, porque
		// presupongo que es cuadrada, todas las filas son del mismo tamaño.
		int tamañoFila = this.tablero.consultarNumeroColumnas();

		// Itero las celdas de la fila y compruebo si tiene una pieza
		for (int i = 0; i < tamañoFila; i++) {
			Coordenada coordeanadaAIterar = new Coordenada(coordenada.fila(), i);
			Celda celdaIterada = this.tablero.consultarCelda(coordeanadaAIterar);
			if (celdaIterada.consultarPieza() != null)
				numPiezas++;
		}

		return numPiezas;
	}

	/**
	 * El método consultarNumeroPiezasEnVertical retorna el número de piezas
	 * contenidas en la misma vertical de la coordenada dada, incluyendo a la pieza
	 * en dicha coordenada, si existe, y con independencia del color de las piezas.
	 * 
	 * @param coordenada La coordenada cuya vertical revisamos
	 * @return numPiezas El número total de piezas en la misma columna (vertical) de
	 *         la coordenada, incluyendo la pieza en la coordenada dada si existe.
	 */

	public int consultarNumeroPiezasEnVertical(Coordenada coordenada) {
		int numPiezas = 0;

		// Primero comprobamos si la coordenada es válida
		if (!this.tablero.estaEnTablero(coordenada))
			return numPiezas;

		// En caso de que esté dentro del tablero. Busco el tamaño de la columna (será
		// el n de filas, porque
		// presupongo que es cuadrada, todas las columnas son del mismo tamaño.
		int tamanoColumna = this.tablero.consultarNumeroColumnas();

		// Itero las celdas de la fila y compruebo si tiene una pieza
		for (int i = 0; i < tamanoColumna; i++) {
			Coordenada coordeanadaAIterar = new Coordenada(i, coordenada.columna());
			Celda celdaIterada = this.tablero.consultarCelda(coordeanadaAIterar);
//			System.out.println(celdaIterada);
			if (celdaIterada.consultarPieza() != null) {
				numPiezas++;
			}

		}

		return numPiezas;
	}

	/**
	 * Consulta si la reina del color indicado ocupa la celda central.
	 * 
	 * @param color Color de la reina que se quiere verificar.
	 * @return boolean Devuelve si la reina esta en el centro.
	 */
	public boolean estaReinaEnElCentro(Color color) {
		// Vamos a hardcodear el centro a (3,3)
		Coordenada coordenadaCentro = new Coordenada(3, 3);
		Celda celdaCentro = this.tablero.consultarCelda(coordenadaCentro);

		// NO QUIERO FORMATEAR ESTO! SE VE MEJOR ASí!!!!!!!!
		if (celdaCentro.consultarPieza() != null && celdaCentro.consultarPieza().consultarTipoPieza() == TipoPieza.REINA
				&& celdaCentro.consultarColorDePieza() == color) {
			return true;
		}

		// Si no coincide todo eso es que no está
		return false;
	}

	/**
	 * Comprueba si la reina del color indicado está todavía sobre el tablero.
	 * @param color El color de la reina que se está buscando.
	 * @return boolean Devuelve true si la reina del color indicado está en el tablero.
	 */
	public boolean hayReina(Color color) {
	    ArrayList<Celda> celdasTablero = this.tablero.consultarCeldas();

	    // Iteramos cada celda para comprobar su pieza
	    for (Celda celdaIterada : celdasTablero) { // Usamos un bucle for-each para recorrer la lista
	        Pieza piezaDeLaCelda = celdaIterada.consultarPieza();

	        // Comprobamos si la pieza es una reina del color especificado
	        if (piezaDeLaCelda != null && piezaDeLaCelda.consultarTipoPieza() == TipoPieza.REINA
	                && piezaDeLaCelda.consultarColor() == color) {
	            return true;
	        }
	    }

	    // Si no se ha encontrado es que no hay reina del color especificado
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
