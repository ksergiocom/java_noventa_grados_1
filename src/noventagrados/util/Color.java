package noventagrados.util;

/**
 * Creamos un enum que define dos colores blanco y negro. Cada color tiene
 * asociado un caracter, 'B' para blanco y 'N' para negro que se almacena en la
 * variable color de tipo char
 * 
 * @author Sergiy Khudoley
 * @author Víctor Acevedo Lorenzo
 * @version 1.0
 * @since 1.0
 * 
 */
public enum Color {
	/**
	 * Color blanco.
	 */
	BLANCO('B'), 
	/**
	 * Color negro.
	 */
	NEGRO('N');

	/**
	 * Letra asignada a cada color para identificarlo.
	 * Corregido respecto a la version 1.0.
	 * (El nombre correcto en el diagrama es letra, NO color)
	 */
	private final char letra;

	/**
	 * Creamos el método Color que asigna el color actual.
	 * 
	 * @param letra El caracter correspondiente al color
	 */

	private Color(char letra) {
		this.letra = letra;
	}

	/**
	 * Devuelve el color contrario al del enum seleccionado.
	 * 
	 * @return Color Devuelve el color contrario
	 * 
	 */
	public Color consultarContrario() {
		return this.letra == 'B' ? Color.NEGRO : Color.BLANCO;
	}

	/**
	 * Este método se encarga de devolver el caracter asociado con el color actual.
	 * 
	 * @return Color Devuelve la letra del color actual
	 * 
	 */

	public char toChar() {
		return this.letra;
	}
}
