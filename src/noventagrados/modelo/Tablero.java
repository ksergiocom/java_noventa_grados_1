package noventagrados.modelo;
import java.util.ArrayList;
import java.util.Objects;

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
	private ArrayList<ArrayList<Celda>> tablero;

    /**
     * Inicializa un tablero con 49 celdas vacías (7x7).
     */
    public Tablero() {
        this.tablero = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            ArrayList<Celda> fila = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                fila.add(new Celda(new Coordenada(i, j))); // Crear una nueva celda
            }
            this.tablero.add(fila);
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
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.tablero.size(); i++) {
            result.append(i).append(" "); // Índice de la fila
            for (Celda celdaActual : this.tablero.get(i)) {
                Pieza piezaActual = celdaActual.consultarPieza();
                if (piezaActual == null) {
                    result.append("-- ");
                } else {
                    result.append(piezaActual.aTexto()).append(" ");
                }
            }
            result.append("\n");
        }

        result.append("   0  1  2  3  4  5  6"); // Índices de columna
        return result.toString();
    }

	/**
	 * Devuelve el clon en profundidad del tablero.
	 * 
	 * @return clonTablero Clon en profundidad del tablero
	 */

    public Tablero clonar() {
        Tablero clonTablero = new Tablero();

        for (int i = 0; i < this.tablero.size(); i++) {
            for (int j = 0; j < this.tablero.get(i).size(); j++) {
                clonTablero.tablero.get(i).set(j, this.tablero.get(i).get(j).clonar());
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

        Celda celdaConsultada = this.tablero.get(coordenada.fila()).get(coordenada.columna());

		return celdaConsultada.clonar();

	}

	/**
	 * Devuelve un array "aplanado" de una
	 * dimensión con todas las celdas del tablero. Cada celda se clona antes de
	 * agregarse al array.
	 * 
	 * @return arrayCeldas Un array unidimensional con todas las celdas del tablero.
	 */
    public ArrayList<Celda> consultarCeldas() {
        ArrayList<Celda> listaCeldas = new ArrayList<>();

        for (ArrayList<Celda> fila : this.tablero) {
            for (Celda celda : fila) {
                listaCeldas.add(celda.clonar()); // Clonar y añadir a la lista
            }
        }

        return listaCeldas;
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
        return this.tablero.get(coordenada.fila()).get(coordenada.columna());
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
		Tablero other = (Tablero) obj;
		return Objects.equals(tablero, other.tablero);
	}
	@Override
	public String toString() {
		return "Tablero [tablero=" + tablero + "]";
	}


}
