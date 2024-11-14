package noventagrados.modelo;

import java.util.Objects;

import noventagrados.util.Color;
import noventagrados.util.TipoPieza;

/**
 * Creamosuna clase pública llamada pieza que tendrá los atributos de clase,
 * color de tipo Color y tipoPieza de TipoPieza.
 * 
 * @author Sergio Sergiy Khudoley
 * @author Víctor Acevedo Lorenzo
 * @version 1.0
 * @since 1.0
 * 
 */

public class Pieza {

	// Atributos
	Color color;
	TipoPieza tipoPieza;

	/**
	 * Creamos el método constructor Pieza que inicializa una pieza con un color de
	 * pieza y un tipo de pieza específico
	 * 
	 * @param tipoPieza El tipo de pieza qu ese desea asignar a la pieza
	 * @param Color     El color que se desea asignar a la pieza
	 */

	public Pieza(TipoPieza tipoPieza, Color color) {
		this.color = color;
		this.tipoPieza = tipoPieza;
	}

	/**
	 * Creamos un método llamado aTexo que nos devuelve una cadena tipo string con
	 * el caracter asociado al tipo de pieza y al color de la pieza
	 * 
	 * @return String Cadena de texto que indica el caracter del tipo de pieza y del
	 *         tipo de color
	 */

	public String aTexto() {
		return "" + this.tipoPieza.toChar() + this.color.toChar();
	}

	/**
	 * Creamos el método clonar que crea y devuelve el clon en profundidad de la
	 * pieza
	 * 
	 * @return PiezaClon Clon en profundidad de la pieza
	 */

	public Pieza clonar() {
		return new Pieza(this.tipoPieza, this.color);
	}

	/**
	 * Creamos un método llamado consultarColor() que nos devuelve el color de la
	 * pieza actual
	 * 
	 * @return Color El color de la pieza actual
	 */

	public Color consultarColor() {
		return this.color;
	}
	
	/**
	 * Creamos un método llamado consultarTipoPieza() que nos devuelve el color de
	 * pieza de la pieza actual
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