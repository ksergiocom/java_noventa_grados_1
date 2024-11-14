package noventagrados.control;

import noventagrados.modelo.Pieza;
import noventagrados.util.Color;
import noventagrados.util.TipoPieza;

// Vamos a usar ArraysLists :)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Es un contenedor que almacenará las piezas que se salen del tablero para un determinado color.
 * 
 * Contiene la lógica necesaria para agregar y contar las piezas que contiene.
 * 
 * @author Víctor Acevedo Lorenzo
 * @author Sergiy Khudoley
 * @version 1.0
 * @since 1.0
 * 
 */
public class Caja {
	/**
	 * El color de la caja actual.
	 * 
	 * @see noventagrados.util.Color
	 */
	private Color color;
	
	/**
	 * Piezas contenidas en la caja.
	 * 
	 * @see noventagrados.modelo.Pieza
	 */
	private Pieza[] piezas;

	/**
	 * Inicializa una caja con un color específico y
	 * un array para almacenará las piezas.
	 * 
	 * Inicializamos el array con 7 piezas, ya
	 * que solo habrá siete piezas de cada color.
	 * 
	 * @param color El color de la caja.
	 */
	public Caja(Color color) {
		this.color = color;
		this.piezas = new Pieza[7];
	}

	/**
	 * Añade la pieza que indiquemos como parámetro a la caja unicamente cuando el color de la pieza coincida con el
	 * color de la caja.
	 * 
	 * @param pieza La pieza que se desea añadir a la caja.
	 */
	public void añadir(Pieza pieza) {
		// Comprobación de si el color de la pieza a añadir es igual al color de la caja
		if (pieza.consultarColor() != this.color)
			return;

		// Iteramos el array de piezas
		for (int i = 0; i < this.piezas.length; i++) {
			// Si te encuentras un elemento vacio en el array inserta ahí la pieza y salte
			if (this.piezas[i] == null) {
				this.piezas[i] = pieza;
				return;
			}
		}
	}

	/**
	 * Devuelve un clon en profundidad de la caja.
	 * 
	 * @return cajaClonada Clon en profundidad de la caja.
	 */

	public Caja clonar() {
		// Crear una nueva caja con el mismo color
		Caja cajaClonada = new Caja(this.color);

		// Hacer un clon profundo de cada pieza
		for (int i = 0; i < this.piezas.length; i++) {
			// Si hay una pieza en la caja original, clonarla
			if (this.piezas[i] != null) {
				// Clonamos la pieza y la agregamos a la caja clonada
				cajaClonada.añadir(this.piezas[i].clonar()); // Asumimos que Pieza tiene un método clonar()
			}
		}

		return cajaClonada;
	}

	/**
	 * Devuelve el color de la caja.
	 * 
	 * @return color El color de la caja actual
	 */

	public Color consultarColor() {
		return this.color;
	}

	/**
	 * Devuelve un array de una dimensión,
	 * con clones en profundidad de todas las piezas en la caja.
	 * 
	 * @return piezasArray Array de una dimensión con los clones en
	 *         profundidad de las piezas de las cajas
	 */
	public Pieza[] consultarPiezas() {
		// Usar ArrayList para almacenar piezas
		ArrayList<Pieza> piezasList = new ArrayList<>();

		// Un forEach de Java! :)
		for (Pieza pieza : this.piezas) {
			// Si es una pieza valida agregarla
			if (pieza != null) {
				piezasList.add(pieza);
			}
		}

		// Convertirlo a un array
		Pieza[] piezasArray = new Pieza[piezasList.size()];
		piezasList.toArray(piezasArray);

		return piezasArray;
	}

	/**
	 * Devuelve el número total de piezas almacenadas en la caja.
	 * 
	 * @return numPiezas Devuelve un entero correspondiente con el número de piezas
	 *         en la caja.
	 */
	public int contarPiezas() {
		int numPiezas = 0;
		for (Pieza pieza : this.piezas) {
			if (pieza != null)
				numPiezas++;
		}
		return numPiezas;
	}

	/**
	 * Devuelve el número de piezas de un tipo específico almacenadas en la caja.
	 * 
	 * @param tipoPieza El tipo de pieza que deseamos contar.
	 * 
	 * @return numPiezas Devuelve un entero con el número de piezas del tipo especificado en la caja.
	 */

	public int contarPiezas(TipoPieza tipoPieza) {
		int numPiezas = 0;
		for (Pieza pieza : this.piezas) {
			if (pieza != null && pieza.consultarTipoPieza() == tipoPieza)
				numPiezas++;
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
