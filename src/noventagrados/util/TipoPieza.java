package noventagrados.util;

/**
 * Creamos un enum que define dos tipos de pieza Peón y Reina. Cada tipo de
 * pieza tiene asociado un caracter, 'P' para peón y 'R' para reina que se
 * almacena en la variable caracter de tipo char
 * 
 * @author Sergio Sergiy Khudoley
 * @author Víctor Acevedo Lorenzo
 * @version 1.0
 * @since 1.0
 * 
 */

public enum TipoPieza {
	PEON('P'), REINA('R');

	private char caracter;

	/**
	 * Creamos el método Tipo.Pieza que asigna el tipo de la pieza                	
	 * @param caracter El caracter correspondiente al tipo de pieza
	 */

	
	private TipoPieza(char caracter) {
		this.caracter = caracter;
	}
	
	/**
	 * Este método se encarga de devolver el caracter asociado con el tipo de pieza actual actual
	 * 
	 * @return caracter Devuelve la letra asociada al tipo de pieza actual
	 * 
	 */

	public char toChar() {
		return this.caracter;
	}
}
