package noventagrados.util;

public record Coordenada(int fila, int columna) {
	public String aTexto() {
		return "" + this.fila() + this.columna();
	}
}
