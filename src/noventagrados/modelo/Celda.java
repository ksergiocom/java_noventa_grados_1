package noventagrados.modelo;

import java.util.Objects;
import noventagrados.util.Color;
import noventagrados.util.Coordenada;

/**
 * Creamos una clase pública llamada celda que tendrá los atributos de clase,
 * coordenada de tipo coordenada y pieza de tipo pieza.
 * 
 * @author Víctor Acevedo Lorenzo
 * @author Sergiy Khudoley
 * @version 1.0
 * 
 */
public class Celda {
	/**
	 * Coordenada (x,y) de la celda. Son los indices de los arrays que componen el tablero
	 * 
	 * @see noventagrados.util.coordenada
	 * @see noventagrados.modelo.tablero
	 */
	private Coordenada coordenada;
	
	/**
	 * Pieza que hay en la celda, puede no existir pieza asignada a esta celda.
	 * 
	 * @see noventagrados.modelo.Pieza
	 */
	private Pieza pieza;

	/**
	 * Inicializa con una coordenada específica.
	 * 
	 * @param coordenada La coordenada que se desea asignar a la celda
	 */
	public Celda(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	/**
	 * Devuelve el clon en profundidad de la celda.
	 * 
	 * @return celdaClon Clon en profundidad de la celda
	 */
	public Celda clonar() {
		Pieza clonPieza = null;
		// Siempre tiene una coordenada, por lo cual hago el clon de ella aqui
		Coordenada clonCoordenada = new Coordenada(this.coordenada.fila(), this.coordenada.columna());

		// Existe una pieza dentro?
		if (this.pieza != null) {
			clonPieza = this.pieza.clonar();
		}

		Celda celdaClon = new Celda(clonCoordenada);
		celdaClon.colocar(clonPieza);

		return celdaClon;
	}

	/**
	 * Coloca una pieza en la celda actual.
	 * 
	 * @param pieza La pieza a colocar en la celda.
	 */
	public void colocar(Pieza pieza) {
		this.pieza = pieza;
	}

	/**
	 * Consulta el color de la pieza en esta celda.
	 * 
	 * @return Color El color de la pieza si existe, en caso de que no exista
	 *         devuelve null.
	 */
	public Color consultarColorDePieza() {
		// En caso de estar vacío se retorna null
		if (this.pieza == null)
			return null;
		// En caso de tener una pieza se retorna el color
		return this.pieza.consultarColor();
	}

	/**
	 * Consulta la coordenada de la celda.
	 * 
	 * @return coordenada consulta la coordenada de la celda.
	 */

	public Coordenada consultarCoordenada() {
		return this.coordenada;
	}

	/**
	 * Devuelve un clon en profundidad de la
	 * pieza perteneciente a la celda, devuelve null en caso de que la celda no
	 * posea una pieza.
	 * 
	 * @return clonPieza La pieza clonada, devuelve null en caso de que no hubiera
	 *         una pieza en la celda
	 */
	public Pieza consultarPieza() {
		if (this.pieza == null)
			return null;
		return this.pieza.clonar();
	}

	/**
	 * Elminia la pieza de la celda actual.
	 */

	public void eliminarPieza() {
		this.pieza = null;
	}

	/**
	 * Indica si hay o no una pieza en la celda actual.
	 * 
	 * @return boolean Devuelve true si la celda está vacía y false si contiene una
	 *         pieza
	 */

	public boolean estaVacia() {
		return this.pieza == null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(coordenada, pieza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Celda other = (Celda) obj;
		return Objects.equals(coordenada, other.coordenada) && Objects.equals(pieza, other.pieza);
	}

	@Override
	public String toString() {
		return "Celda [coordenada=" + coordenada + ", pieza=" + pieza + "]";
	}

}
