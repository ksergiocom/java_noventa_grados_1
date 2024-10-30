package noventagrados.control;

import noventagrados.modelo.Tablero;
import noventagrados.modelo.Pieza;
import noventagrados.modelo.Jugada;

import noventagrados.util.Color;
import noventagrados.util.Coordenada;
import noventagrados.util.TipoPieza;

public class Arbitro {
	private Tablero tablero;
	private int contadorJugadas;
	private Color turno;
	
	public Arbitro(Tablero tablero) {
		this.tablero = tablero;
		this.contadorJugadas = 0;
		this.turno = null;
	}
	
	public void cambiarTurno() {
		if(this.turno == Color.BLANCO) this.turno = Color.NEGRO;
		if(this.turno == Color.NEGRO) this.turno = Color.BLANCO;
	}
	
	public void colocarPiezas(Pieza[] piezas, Coordenada[] coordenadas, Color turnoActual) {
		this.turno = turnoActual;
		// Vamos a considerar que las piezas y las coordenadas vienen emparejadas 1 a 1 en los arrays
		for(int i=0; i<piezas.length; i++) {
			Pieza piezaActual = piezas[i];
			Coordenada coordenadaActual = coordenadas[i];
			this.tablero.colocar(piezaActual, coordenadaActual);
		}
		
		return;
	}
	
	public void colocarPiezasConfiguracionInicla() {
		// LOL!!!!!!!!!! luego lo refactorizo si me siento con ganas
		
		// Colocar las piezas en la distribucion en la que vienen al principio de la partida
		// [0,0] Reina blanca
		Pieza piezaReinaBlanca = new Pieza(TipoPieza.REINA, Color.BLANCO);
		Coordenada coordenadaReinaBlanca = new Coordenada(0,0);

		// [1,0] [2,0] [3,0] [0,1] [0,2] [0,3] Peones blancos
		Pieza piezaPeonBlanco1 = new Pieza(TipoPieza.PEON, Color.BLANCO);
		Pieza piezaPeonBlanco2 = new Pieza(TipoPieza.PEON, Color.BLANCO);
		Pieza piezaPeonBlanco3 = new Pieza(TipoPieza.PEON, Color.BLANCO);
		Pieza piezaPeonBlanco4 = new Pieza(TipoPieza.PEON, Color.BLANCO);
		Pieza piezaPeonBlanco5 = new Pieza(TipoPieza.PEON, Color.BLANCO);
		Pieza piezaPeonB = new Pieza(TipoPieza.PEON, Color.BLANCO);
		Coordenada coordenadaPeonBlanco1 = new Coordenada(0,)
		
		
		// [6,6] Reina negra
		// [6,6] [5,6] [4,6] [3,6] [6,5] [6,4] [6,3] Peones negros
		
		
		
		return;
	}
	
	public Caja consultarCaja(Color color) {
		// Implementacion Dummy
		return new Caja(Color.BLANCO);
	}
	
	public int consultarNumeroJugada() {
		return this.contadorJugadas;
	}
	
	public Tablero consultarTablero() {
		return this.tablero;
	}
	
	public Color consultarTurno() {
		return this.turno;
	}
	
	public Color consultarTurnoGanador() {
		return this.colorTurno;
	}
	
	public void empujar(Jugada jugada) {
		return;
	}
	
	public boolean esMovimientoLegal(Jugada jugada) {
		return false;
	}
	
	public boolean estaFinalizadaPartida() {
		return false;
	}
	
	// Pendiente toString()
}
