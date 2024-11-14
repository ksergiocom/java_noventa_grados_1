package noventagrados.util;

/**
 * Creamos un enum que define dos tipos de pieza Peón y Reina. Cada tipo de
 * pieza tiene asociado un caracter, 'P' para peón y 'R' para reina que se
 * almacena en la variable caracter de tipo char.
 * 
 * @author Víctor Acevedo Lorenzo
 * @author Sergiy Khudoley
 * @version 1.0
 * @since 1.0
 * 
 */

public enum TipoPieza {
	/**
	 * Tipo de pieza peón. Soy un peón.......
	 */
	PEON('P'),
	/**
	 * Tipo de pieza reina. Esta es la importante para determinar el fin de la partida
	 */
	REINA('R');

	/**
	 * Guarda un caracter para identificar facilmente el tipo de pieza.
	 */
	private char caracter;

	/**
	 * Creamos el método Tipo.Pieza que asigna el tipo de la pieza.              	
	 * @param caracter El caracter correspondiente al tipo de pieza
	 */
	private TipoPieza(char caracter) {
		this.caracter = caracter;
	}
	
	/**
	 * Este método se encarga de devolver el caracter asociado con el tipo de pieza actual actual.
	 * 
	 * @return caracter Devuelve la letra asociada al tipo de pieza actual
	 * 
	 */
	public char toChar() {
		return this.caracter;
	}
}
