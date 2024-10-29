package noventagrados.modelo;

public record Jugada(Celda origen, Celda destino) {
	public String aTexto() {
		//return "" + this.origen() + "-" + this.destino();
		return this.origen().coordenada.aTexto() + "-" + this.destino().coordenada.aTexto();
	}
}
