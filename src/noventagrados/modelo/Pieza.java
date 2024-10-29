package noventagrados.modelo;

import java.util.Objects;

import noventagrados.util.Color;
import noventagrados.util.TipoPieza;

public class Pieza {

	// Atributos
	Color color;
	TipoPieza tipoPieza;
	
	public Pieza(TipoPieza tipoPieza, Color color) {
		this.color = color;
		this.tipoPieza = tipoPieza;
	}
	
	public String aTexto() {
		return "" + this.tipoPieza.toChar() + this.color.toChar();
	}
	
	public Pieza clonar() {
		return new Pieza(this.tipoPieza, this.color);
	}
	
	public Color consultarColor() {
		return this.color;
	}
	
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
