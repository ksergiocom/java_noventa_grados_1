package noventagrados.modelo;

public record Jugada(Celda origen, Celda destino) {
	public String aTexto() {
		//return "" + this.origen() + "-" + this.destino();
		return this.origen().consultarCoordenada().aTexto() + "-" + this.destino().consultarCoordenada().aTexto();
	}
}
