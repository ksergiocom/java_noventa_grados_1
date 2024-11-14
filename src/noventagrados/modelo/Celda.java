package noventagrados.modelo;

import java.util.Objects;
import noventagrados.util.Color;
import noventagrados.util.Coordenada;

/**
 * Creamos una clase pública llamada celda que tendrá los atributos de clase,
 * coordenada de tipo coordenada y pieza de tipo pieza.
 * 
 * @author Sergio Sergiy Khudoley
 * @author Víctor Acevedo Lorenzo
 * @version 1.0
 * @since 1.0
 * 
 */

public class Celda {
	private Coordenada coordenada;
	private Pieza pieza;

	/**
	 * Creamos el método constructor Celda que inicializa una celda con una
	 * coordenada específica.
	 * 
	 * @param Coordenada La coordenada que se desea asignar a la celda
	 */

	public Celda(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	/**
	 * Creamos el método clonar que crea y devuelve el clon en profundidad de la
	 * celda 
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
	 * Creamos el método colocar que coloca una pieza en la celda.
	 * 
	 * @param pieza La pieza a colocar en la celda.
	 */

	public void colocar(Pieza pieza) {
		this.pieza = pieza;
	}

	/**
	 * Creamos el método consultarColorDePieza que consulta el color de la pieza en
	 * esta celda.
	 * 
	 * @return Color El color de la pieza si existe, en caso de que no exista
	 *         devuelve null
	 */

	public Color consultarColorDePieza() {
		// En caso de estar vacío se retorna null
		if (this.pieza == null)
			return null;
		// En caso de tener una pieza se retorna el color
		return this.pieza.consultarColor();
	}

	/**
	 * Creamos el método consultarCoordena que consulta la coordenada de la celda
	 * 
	 * @return consultarCoordenada consulta la coordenada de la celda
	 */

	public Coordenada consultarCoordenada() {
		return this.coordenada;
	}

	/**
	 * Creamos el método consultarPieza que devuelve un clon en profundidad de la
	 * pieza perteneciente a la celda, devuelve null en caso de que la celda no
	 * posea una pieza
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
	 * Creamos el método eliminarPieza que elminia la pieza de la celda colocando un
	 * null en la variable de clase celda
	 */

	public void eliminarPieza() {
		this.pieza = null;
	}

	/**
	 * Creamos el método estaVacia que nos indica si hay o no una pieza en la celda
	 * en cuestión
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
