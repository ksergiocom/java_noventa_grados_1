package noventagrados.util;

public enum TipoPieza {
	PEON('P'),
	REINA('R');
	
	private char caracter;
	
	private TipoPieza(char caracter) {
		this.caracter = caracter;
	}
	
	public char toChar() {
		return this.caracter;
	}
}
