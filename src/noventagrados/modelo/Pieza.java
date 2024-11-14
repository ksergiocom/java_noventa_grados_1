package noventagrados.modelo;

import java.util.Objects;

import noventagrados.util.Color;
import noventagrados.util.TipoPieza;

/**
 * Piezas con las cuales se juega.
 * 
 * Existen 7 piezas para cada jugador (Color). 6 Peónes y 1 Reina.
 * 
 * @see noventagrados.util.TipoPieza
 * @see noventagrados.util.Color
 * 
 * @author Víctor Acevedo Lorenzo
 * @author Sergiy Khudoley
 * @version 1.0
 * @since 1.0
 * 
 */
public class Pieza {

	/**
	 * Color de la pieza (Blanca o Negra).
	 * 
	 * @see noventagrados.util.Color
	 */
	Color color;
	
	/**
	 * Tipo de pieza (Reina o Peon).
	 * 
	 * @see noventagrados.util.TipoPieza
	 */
	TipoPieza tipoPieza;

	/**
	 * Inicializa una pieza con un color de
	 * pieza y un tipo de pieza específico.
	 * 
	 * @param tipoPieza El tipo de pieza qu ese desea asignar a la pieza
	 * @param color     El color que se desea asignar a la pieza
	 */
	public Pieza(TipoPieza tipoPieza, Color color) {
		this.color = color;
		this.tipoPieza = tipoPieza;
	}

	/**
	 * Devuelve una cadena tipo string con
	 * el caracter asociado al tipo de pieza y al color de la pieza.
	 * 
	 * @return string Cadena de texto que indica el caracter del tipo de pieza y del
	 *         tipo de color.
	 */

	public String aTexto() {
		return "" + this.tipoPieza.toChar() + this.color.toChar();
	}

	/**
	 * Devuelve el clon en profundidad de la pieza.
	 * 
	 * @return PiezaClon Clon en profundidad de la pieza
	 */
	public Pieza clonar() {
		return new Pieza(this.tipoPieza, this.color);
	}

	/**
	 * Devuelve el color de la pieza actual.
	 * 
	 * @return Color El color de la pieza actual
	 */

	public Color consultarColor() {
		return this.color;
	}
	
	/**
	 * Devuelve el color de pieza de la pieza actual.
	 * 
	 * @return Color El tipo de pieza de la pieza actual
	 */
	public TipoPieza consultarTipoPieza() {
		return this.tipoPieza;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, tipoPieza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pieza other = (Pieza) obj;
		return color == other.color && tipoPieza == other.tipoPieza;
	}

	@Override
	public String toString() {
		return "Pieza [color=" + color + ", tipoPieza=" + tipoPieza + "]";
	}

}