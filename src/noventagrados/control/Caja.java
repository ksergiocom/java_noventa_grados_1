package noventagrados.control;

import noventagrados.modelo.Pieza;
import noventagrados.util.Color;
import noventagrados.util.TipoPieza;

// Vamos a usar ArraysLists :)
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Objects;

/**
 * Es un contenedor que almacenará las piezas que se salen del tablero para un determinado color.
 * 
 * Contiene la lógica necesaria para agregar y contar las piezas que contiene.
 * 
 * @author <a href="val1002@alu.ubu.es">Víctor Acevedo Lorenzo</a>
 * @author <a href="skx1024@alu.ubu.es">Sergiy Khoudoley</a>
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
	 * Constante para definir las dimensiones de nuestro tablero.
	 */
	private final int MAX_TAMANO = 7;
	
	/**
	 * Piezas contenidas en la caja.
	 * 
	 * @see noventagrados.modelo.Pieza
	 */
	private List<Pieza> piezas;

	/**
	 * Inicializa una caja con un color específico y
	 * un array para almacenará las piezas.
	 * 
	 * @param color El color de la caja.
	 */
	public Caja(Color color) {
		this.color = color;
		this.piezas = new ArrayList<>();
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
		// Si ha llegado al tamaño máximo elementos no añadir
		if(this.piezas.size() == MAX_TAMANO) return;
		
		//Ya no es necesario el bucle for, estamos en arraylists
        this.piezas.add(pieza);

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
        for (Pieza pieza : this.piezas) {
            if (pieza != null) {
                // Clonamos la pieza y la agregamos a la caja clonada
                cajaClonada.añadir(pieza.clonar()); // Asumimos que Pieza tiene un método clonar()
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
	 * Devuelve una lista de una dimensión,
	 * con clones en profundidad de todas las piezas en la caja.
	 * 
	 * @return piezasList lista de una dimensión con los clones en
	 *         profundidad de las piezas de las cajas
	 */
	public List<Pieza> consultarPiezas() {
	    // Crear un ArrayList para almacenar las piezas válidas
	    ArrayList<Pieza> piezasList = new ArrayList<>();

	    // Iterar sobre las piezas existentes
	    for (Pieza pieza : this.piezas) {
	        // Si la pieza no es nula, agregarla al ArrayList
	        if (pieza != null) {
	            piezasList.add(pieza);
	        }
	    }

	    // Retornar el ArrayList directamente
	    return piezasList;
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
		return Objects.hash(color, piezas);
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
		return color == other.color && Objects.equals(piezas, other.piezas);
	}

	@Override
	public String toString() {
		return "Caja [color=" + color + ", piezas=" + piezas + "]";
	}


	

}
