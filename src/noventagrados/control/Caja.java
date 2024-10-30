package noventagrados.control;

import java.util.Arrays;
import java.util.Objects;

import noventagrados.modelo.Pieza;
import noventagrados.util.Color;
import noventagrados.util.TipoPieza;

public class Caja {
	
	private Color color;
	private Pieza[] piezas; // Implementación con un array estatico de tamaño 7
	
//	// DEBUGGGGGGGGGGGGGGGGGGGGG
//	static public void main(String[] args) {
//		// Creo caja
//		Caja nuevaCaja = new Caja(Color.BLANCO);
//		// Creo una pieza para agregar a la caja
//		Pieza nuevaPieza = new Pieza(TipoPieza.PEON, Color.BLANCO);
//		nuevaCaja.añadir();
//	}
	
	
	public Caja(Color color) {
		this.color = color;
		// Array vacío
		this.piezas = new Pieza[7];
	}
	
	public void añadir(Pieza pieza) {
		// Si no es del color de la caja, salirse
		if(this.color != pieza.consultarColor()) return;
				
		// Voy a buscar el primer elemento vacio en el array de piezas y allí lo inserto
		int idx = 0;
		while(this.piezas[idx] != null) {
			idx++;
		}
		
		
		// Inserto la pieza en la ultima posición NO vacia
		this.piezas[idx] = pieza;
	}
	
	public Color consultarColor() {
		return this.color;
	}
	
	/**
	 * El método consultarPiezas devuelve un devuelve un array de una dimensión, con clones en
	 * profundidad de todas las piezas en la caja.
	 * 
	 * @return Pieza[]
	 */
	public Pieza[] consultarPiezas() {
		Pieza[] clonPiezas = new Pieza[7];
		// Clonar todos los objetos del array de piezas
		for(int i=0; i<this.piezas.length; i++) {
			if(this.piezas[i] != null) {
				clonPiezas[i] = this.piezas[i].clonar();				
			}
		}
		
		return clonPiezas;
	}
	
	/**
	 * devuelve el número total de piezas contenidas.
	 */
	public int contarPiezas() {
		int numPiezas=0;
		// Voy a usar numPiezas también como un contador JA JA!
		while(this.piezas[numPiezas] != null) {
			numPiezas++;
		}
		return numPiezas;
	}
	
	/**
	 * devuelve el número total de piezas contenidas de un determinado tipo
	 */
	public int contarPiezas(TipoPieza tipoPieza) {
		int numPiezas=0;

		for(int i=0; i<this.piezas.length; i++) {
			// Comprobar si existe la pieza y si su tipo es igual al tipo proporcionado
			if(this.piezas[i] != null && this.piezas[i].consultarTipoPieza() == tipoPieza) {
				numPiezas++;
			}
		}
		
		return numPiezas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(piezas);
		result = prime * result + Objects.hash(color);
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
		Caja other = (Caja) obj;
		return color == other.color && Arrays.equals(piezas, other.piezas);
	}

	@Override
	public String toString() {
		return "Caja [color=" + color + ", piezas=" + Arrays.toString(piezas) + "]";
	}

	
}
