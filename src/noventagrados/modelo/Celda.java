package noventagrados.modelo;

import java.util.Objects;

import noventagrados.util.Color;
import noventagrados.util.Coordenada;

public class Celda {
	private Coordenada coordenada;
	private Pieza pieza;
	
	public Celda(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
	
	public Celda clonar() {
		Pieza clonPieza = null;
		// Siempre tiene una coordenada, por lo cual hago el clone de ella aqui
		Coordenada clonCoordenada = new Coordenada(this.coordenada.fila(), this.coordenada.columna());
		
		// Existe una pieza dentro?
		if(this.pieza != null) {
			clonPieza= this.pieza.clonar();
		}
		
		Celda celdaClon = new Celda(clonCoordenada);
		celdaClon.colocar(clonPieza);
		
		return celdaClon;
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
	
	public Coordenada consultarCoordenada() {
		return this.coordenada;
	}
	
	public Pieza consultarPieza() {
		return this.pieza;
	}
	
	public void eliminarPieza() {
		this.pieza = null;
	}
	
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
