package noventagrados.util;

public enum Color {
	BLANCO('B'),
	NEGRO('N');
	
	private final char color;
	
	private Color(char letra) {
		this.color = letra;
	}
	
	public Color consultarContrario() {
		return this.color == 'B' ? Color.NEGRO : Color.BLANCO;
	}
	
	public char toChar() {
		return this.color;
	}
}
