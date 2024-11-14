package noventagrados.modelo;

/**
 *  Jugadas realizada con la celda de origen y la celda de destino. 
 *  
 *  Se utiliza sobre el Árbitro para comprobar la legalidad y realizar movimientos de las piezas.
 *  
 *  @see noventagrados.control.Arbitro
 *  
 * @author Víctor Acevedo Lorenzo
 * @author Sergiy Khudoley
 * @version 1.0
 * 
 * @param origen Celda de origen.
 * @param destino Celda de destino.
 */
public record Jugada(Celda origen, Celda destino) {

	/**
	 * Devuelve una cadena tipo string con
	 * las coordenadas de las celdas de origen y de destino.
	 * 
	 * @return String Cadena de texto que indica la coordedana de la celda de origen
	 *         y de destino
	 */
	public String aTexto() {
		// return "" + this.origen() + "-" + this.destino();
		return this.origen().consultarCoordenada().aTexto() + "-" + this.destino().consultarCoordenada().aTexto();
	}
}
