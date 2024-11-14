package noventagrados.util;

/**
 *  Creamos una clase Coordenada la cuál será tipo record, y tendrá dos atributos, fila y columna.
 *  
 * @author Víctor Acevedo Lorenzo
 * @author Sergiy Khudoley
 * @version 1.0
 * @since 1.0
 *
 * Dado que la clase es tipo record se genera automáticamente un constructor. El
 * constructor requiere de dos parámetros, fila y columna y devuelve una
 * instancia de tipo record con sus propios atributos de fila y columna
 * definidos.
 * 
 * @param fila    El número de fila en la que se encuentra dicha coordenada
 * @param columna El número de columna en la que se encuentra dicha coordenada
 */
public record Coordenada(int fila, int columna) {

	/**
	 * Creamos un método llamado aTexo que nos devuelve una cadena tipo
	 * string con el numero de fila y numero de columna de la coordenada.
	 * 
	 * @return String Cadena de texto que indica numero de fila y columna
	 */
	public String aTexto() {
		return "" + this.fila() + this.columna();
	}
}
