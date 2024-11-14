package noventagrados.modelo;

import java.util.Arrays;

import noventagrados.util.Coordenada;

/**
 * El tablero son Celdas dispuestas en una configuración de 7x7.
 * 
 * Usamos un array de celdas teniendo en cuenta que la coordenada [0,0] se encuentra en la esquina superior izuiqerda
 * y es un array de filas (es decir la coordenada superior derecha es [0,6]
 * 
 * @author Víctor Acevedo Lorenzo
 * @author Sergiy Khudoley
 * @version 1.0
 * @since 1.0
 * 
 */
public class Tablero {
	/**
	 * El tablero será una matriz de celdas. Lo implementamos como un array de arrays de celdas
	 * 
	 * @see noventagrados.modelo.Celda
	 */
	private Celda[][] tablero;

	/**
	 * Inicializa un tablero con 49 celdas vacías.
	 */
	public Tablero() {
		this.tablero = new Celda[7][7];
		// Vamos a meter una celda en cada uno (Esto esta duplicado)
		for (int i = 0; i < this.tablero.length; i++) {
			for (int j = 0; j < this.tablero[i].length; j++) {
				this.tablero[i][j] = new Celda(new Coordenada(i, j));
			}
		}
	}

	/**
	 * Devuelve una cadena tipo string que
	 * mostrará un dibujo que representará el tablero , indicando las celdas que
	 * tienen fichas, con color y tipo de ficha y las celdas que no tienen fichas
	 * con dos guiones "--".
	 * 
	 * @return string Cadena que representa el tablero
	 * 
	 */
	public String aTexto() {
		String result = "";

		for (int i = 0; i < this.tablero.length; i++) {
			result += i + " "; // Agregar índice de fila al inicio de cada línea
			for (int j = 0; j < this.tablero[i].length; j++) {
				Celda celdaActual = this.tablero[i][j];
				Pieza piezaActual = celdaActual.consultarPieza(); // se crea clon profundo
				// En caso de que no tenga pieza en la celda
				if (piezaActual == null) {
					result += "-- ";
				} else {
					// En caso de que haya una pieza, añadir su tipo y color
					result += piezaActual.aTexto() + " ";
				}
			}
			result += "\n"; // Nueva línea al final de cada fila
		}

		// Al final, añadir los índices de las columnas
		result += "   0  1  2  3  4  5  6";

		return result;
	}

	/**
	 * Devuelve el clon en profundidad del tablero.
	 * 
	 * @return clonTablero Clon en profundidad del tablero
	 */

	public Tablero clonar() {
		Tablero clonTablero = new Tablero();

		// Recorrer el tablero para clonar cada celda y pieza
		for (int i = 0; i < this.tablero.length; i++) {
			for (int j = 0; j < this.tablero[i].length; j++) {
				// Clonar cada celda
				clonTablero.tablero[i][j] = this.tablero[i][j].clonar();
			}
		}
		return clonTablero;
	}

	/**
	 * Coloca una pieza en una celda específica del tablero, indicada por su
	 * coordenada. Si la pieza es nula o la coordenada está fuera de los límites del
	 * tablero, no se realiza ninguna acción.
	 * 
	 * @param pieza      La pieza a colocar en la celda.
	 * @param coordenada La coordenada de la celda donde se colocará la pieza.
	 */

	public void colocar(Pieza pieza, Coordenada coordenada) {
		// Comprobaciones, clausula de guarda
		if (pieza == null || this.estaEnTablero(coordenada) == false)
			return;

		Celda celdaActual = this.obtenerCelda(coordenada);

		celdaActual.colocar(pieza);
	}

	/**
	 * Devuelve un clon en profundidad de la
	 * celda cuya coordenada se haya pasado como parámetro. Si la coordenada no está
	 * en el tablero devuelve un valor null.
	 * 
	 * @param coordenada      La coordenada de la celda que se quiere clonar
	 * @return celdaConsultada El clon en profundidad de la celda clonada
	 */

	public Celda consultarCelda(Coordenada coordenada) {
		if (!this.estaEnTablero(coordenada))
			return null;

		Celda celdaConsultada = this.tablero[coordenada.fila()][coordenada.columna()];

		return celdaConsultada.clonar();

	}

	/**
	 * Devuelve un array "aplanado" de una
	 * dimensión con todas las celdas del tablero. Cada celda se clona antes de
	 * agregarse al array.
	 * 
	 * @return arrayCeldas Un array unidimensional con todas las celdas del tablero.
	 */
	public Celda[] consultarCeldas() {
		Celda[] arrayCeldas = new Celda[7 * 7]; // Siempre considero que es de 7x7

		for (int i = 0; i < this.tablero.length; i++) {
			for (int j = 0; j < this.tablero[i].length; j++) {
				// Voy a usar la combinacion de los dos para crear un indice plano
				// i+j*7 (7 es el array length del interior)
				int idx = i + j * this.tablero[i].length; // Todos son de 7 en realidad
				arrayCeldas[idx] = this.tablero[j][i].clonar();
			}
		}

		return arrayCeldas;
	}

	/**
	 * Devuelve el número de columnas
	 * del tablero.
	 * 
	 * @return 7 El número de columnas del tablero
	 */

	public int consultarNumeroColumnas() {
		// Hardcodeado LOL
		return 7;
	}

	/**
	 * Devuelve el número de filas del
	 * tablero.
	 * 
	 * @return 7 El número de filas del tablero
	 */

	public int consultarNumeroFilas() {
		// Hardcodeado LOL
		return 7;
	}

	/**
	 * Elimina la pieza que se encuentre en la
	 * celda cuyas coordenadas hayamos introducido por parámetro.
	 * 
	 * @param coordenada Coordenada de la celda cuya pieza queremos eliminar
	 */

	public void eliminarPieza(Coordenada coordenada) {
		// Si NO esta en el tablero no hacer nada
		if (this.estaEnTablero(coordenada) == false)
			return;

		this.obtenerCelda(coordenada).eliminarPieza();
	}

	/**
	 * Comprueba si una coordenada está dentro el tablero.
	 * 
	 * @param coordenada Coordenada que queremos comprobar si está dentro del
	 *                   tablero
	 * @return estaDentro Variable booleana que nos devuelve true si la coordenada
	 *         está dentro del tablero y false si no lo está
	 */

	public boolean estaEnTablero(Coordenada coordenada) {
		boolean estaDentro = true;

		// Lo hago así porque me resulta más claro de leer.
		if (coordenada == null)
			return false;

		// idxMaximo = length - 1. Por eso si es igual o mayor está fuera. DISLEXIA
		if (coordenada.fila() >= this.consultarNumeroFilas())
			estaDentro = false;
		if (coordenada.columna() >= this.consultarNumeroColumnas())
			estaDentro = false;
		if (coordenada.fila() < 0)
			estaDentro = false;
		if (coordenada.columna() < 0)
			estaDentro = false;

		// Aqui hubiera hecho varios returns para no ir comprobando todos los casos,
		// sino simplemente salirme cuando llegara
		// cualquiera de los casos que resultan falsos. Una vez comprobados no
		// necesitaria seguir...
		// Pero como no me dejais.... pues eso....

		return estaDentro;
	}

	/**
	 * Devuelve la celda ubicada en la coordenada
	 * especificada como parámetro si está dentro de los límites del tablero.
	 * 
	 * @param coordenada La coordenada de la celda a obtener.
	 * @return celda La celda en la posición especificada, o null si la coordenada
	 *         está fuera de los límites del tablero.
	 */
	public Celda obtenerCelda(Coordenada coordenada) {
		if (!this.estaEnTablero(coordenada))
			return null;
		return this.tablero[coordenada.fila()][coordenada.columna()]; // Devolvemos la referencia de la celda
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(tablero);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tablero other = (Tablero) obj;
		return Arrays.deepEquals(tablero, other.tablero);
	}

	@Override
	public String toString() {
		return "Tablero [tablero=" + Arrays.toString(tablero) + "]";
	}

}
