package noventagrados.util;

/**
 * Creamos la clase Sentido de tipo enum que define 4 direcciones o sentidos
 * diferentes. La clase sentido tiene dos variables de clase,
 * desplazamientoEnFilas y desplazamientoEnColumnas, que representan el cambio
 * en las filas y en las columnas, respectivamente, al moverse en una dirección
 * específica.
 * 
 * @author Sergio Sergiy Khudoley
 * @author Víctor Acevedo Lorenzo
 * @version 1.0
 * @since 1.0
 * 
 */

public enum Sentido {
	VERTICAL_N(-1, 0), VERTICAL_S(+1, 0), HORIZONTAL_E(0, +1), HORIZONTAL_O(0, -1);

	private int desplazamientoEnFilas;
	private int desplazamientoEnColumnas;

	/**
	 * Método que asigna los valores de desplazamiento en filas y columnas para una
	 * direccion.
	 * 
	 * @param desplazamientoEnFilas    El desplazamiento en filas asociado al
	 *                                 sentido.
	 * @param desplazamientoEnColumnas El desplazamiento en columnas asociado al
	 *                                 sentido.
	 */

	private Sentido(int desplazamientoEnFilas, int desplazamientoEnColumnas) {
		this.desplazamientoEnFilas = desplazamientoEnFilas;
		this.desplazamientoEnColumnas = desplazamientoEnColumnas;
	}

	/**
	 * Este método se encarga de devolver el entero correspondiene con el
	 * desplazamiento en filas asociado al sentido actual
	 * 
	 * @return desplazamientoEnFilas El valor de desplazamiento en filas para este sentido.
	 * 
	 */

	public int consultarDesplazamientoEnFilas() {
		return this.desplazamientoEnFilas;
	}
	

	/**
	 * Este método se encarga de devolver el entero correspondiene con el
	 * desplazamiento en columans asociado al sentido actual
	 * 
	 * @return desplazamientoEnColumnas El valor de desplazamiento en columnas para este sentido.
	 * 
	 */


	public int consultarDesplazamientoEnColumnas() {
		return this.desplazamientoEnColumnas;
	}
}
