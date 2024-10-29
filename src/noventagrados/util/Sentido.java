package noventagrados.util;

public enum Sentido {
	VERTICAL_N(-1,0),
	VERTICAL_S(+1,0),
	HORIZONTAL_E(0,+1),
	HORIZONTAL_O(0,-1);
	
	private int desplazamientoEnFilas;
	private int desplazamientoEnColumnas;
	
	private Sentido(int desplazamientoEnFilas, int desplazamientoEnColumnas) {
		this.desplazamientoEnFilas = desplazamientoEnFilas;
		this.desplazamientoEnColumnas = desplazamientoEnColumnas;
	}
	
	public int consultarDesplazamientoEnFilas() {
		return this.desplazamientoEnFilas;
	}
	
	public int consultarDesplazamientoEnColumnas() {
		return this.desplazamientoEnColumnas;
	}
}
