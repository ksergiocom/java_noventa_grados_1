package noventagrados.modelo;

import noventagrados.util.Color;
import noventagrados.util.Coordenada;

public class Celda {
	Coordenada coordenada;
	Pieza pieza;
	
	public Celda(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
	
	public void colocar(Pieza pieza) {
		this.pieza = pieza;
	}
	
	public Color consultarColorDePieza() {
		// En caso de estar vacío se retorna null
		if(this.pieza == null) return null;
		// En caso de tener una pieza se retorna el color
		return this.pieza.consultarColor();
	}
	
	public void eliminarPieza() {
		this.pieza = null;
	}
	
	public boolean estaVacia() {
		return this.pieza == null;
	}
}
