package noventagrados.util;

/**
 * Creamos un enum que define dos colores blanco y negro. Cada color tiene
 * asociado un caracter, 'B' para blanco y 'N' para negro que se almacena en la
 * variable color de tipo char
 * 
 * @author Sergio Sergiy Khudoley
 * @author Víctor Acevedo Lorenzo
 * @version 1.0
 * @since 1.0
 * 
 */

public enum Color {
	BLANCO('B'), NEGRO('N');

	private final char color;

	/**
	 * Creamos el método Color que asigna el color actual
	 * 
	 * @param letra El caracter correspondiente al color
	 */

	private Color(char letra) {
		this.color = letra;
	}

	/**
	 * Este método se encarga de devolver el color contrario al que tenemos
	 * actualmente
	 * 
	 * @return Color Devuelve el color contrario
	 * 
	 */
	public Color consultarContrario() {
		return this.color == 'B' ? Color.NEGRO : Color.BLANCO;
	}

	/**
	 * Este método se encarga de devolver el caracter asociado con el color actual
	 * 
	 * @return Color Devuelve la letra del color actual
	 * 
	 */

	public char toChar() {
		return this.color;
	}
}
