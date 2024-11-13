package noventagrados.modelo;

/**
 *  Creamos una clase Jugada la cuál será tipo record, y tendrá dos atributos, celda origen y celda destino, 
 *  ambos de tipo Celda
 *  
 * @author Sergio Sergiy Khudoley
 * @author Víctor Acevedo Lorenzo
 * @version 1.0
 * @since 1.0
 */

/**
 * Dado que la clase es tipo record se genera automáticamente un constructor. El
 * constructor requiere de dos parámetros, celda origen y celda destino y
 * devuelve una instancia de tipo record con sus propios atributos de origen y
 * destino definidos
 * 
 * @param origen La celda de origen
 * @param destino La celda de destino
 * @return Devuelve un objeto de tipo jugada con unos atributos origen y
 *         destino definidos
 */
public record Jugada(Celda origen, Celda destino) {

	/**
	 * Creamos un método llamado aTexo que nos devuelve una cadena tipo string con
	 * las coordenadas de las celdas de origen y de destino
	 * 
	 * @return String Cadena de texto que indica la coordedana de la celda de origen
	 *         y de destino
	 */

	public String aTexto() {
		// return "" + this.origen() + "-" + this.destino();
		return this.origen().consultarCoordenada().aTexto() + "-" + this.destino().consultarCoordenada().aTexto();
	}
}
