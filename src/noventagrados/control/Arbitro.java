package noventagrados.control;

import noventagrados.modelo.Tablero;
import noventagrados.modelo.Pieza;

import java.util.Objects;

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
		
		//System.out.println(this.tablero.aTexto());
		
		return;
	}
	
	/**
	 * Una funcion que genera las piezas y coordenadas iniciale y las coloca en su posicoin inicial
	 * Esto está pendiente de reducir y simplificar
	 * 
	 */
	public void colocarPiezasConfiguracionInicial() {
	    // Array para almacenar las piezas iniciales: 6 peones blancos, 6 peones negros, 1 reina blanca, 1 reina negra
	    Pieza[] piezasGeneradas = new Pieza[14];
	    // Array para las coordenadas de las piezas
	    Coordenada[] coordenadasGeneradas = new Coordenada[14];

	    // Colocar la reina blanca en [0,0]
	    piezasGeneradas[0] = new Pieza(TipoPieza.REINA, Color.BLANCO);
	    coordenadasGeneradas[0] = new Coordenada(0, 0);

	    // Colocar los peones blancos en posiciones cercanas a la esquina superior izquierda
	    piezasGeneradas[1] = new Pieza(TipoPieza.PEON, Color.BLANCO);
	    coordenadasGeneradas[1] = new Coordenada(1, 0);
	    piezasGeneradas[2] = new Pieza(TipoPieza.PEON, Color.BLANCO);
	    coordenadasGeneradas[2] = new Coordenada(2, 0);
	    piezasGeneradas[3] = new Pieza(TipoPieza.PEON, Color.BLANCO);
	    coordenadasGeneradas[3] = new Coordenada(3, 0);
	    piezasGeneradas[4] = new Pieza(TipoPieza.PEON, Color.BLANCO);
	    coordenadasGeneradas[4] = new Coordenada(0, 1);
	    piezasGeneradas[5] = new Pieza(TipoPieza.PEON, Color.BLANCO);
	    coordenadasGeneradas[5] = new Coordenada(0, 2);
	    piezasGeneradas[6] = new Pieza(TipoPieza.PEON, Color.BLANCO);
	    coordenadasGeneradas[6] = new Coordenada(0, 3);

	    // Colocar la reina negra en [6,6]
	    piezasGeneradas[7] = new Pieza(TipoPieza.REINA, Color.NEGRO);
	    coordenadasGeneradas[7] = new Coordenada(6, 6);

	    // Colocar los peones negros en posiciones cercanas a la esquina inferior derecha
	    piezasGeneradas[8] = new Pieza(TipoPieza.PEON, Color.NEGRO);
	    coordenadasGeneradas[8] = new Coordenada(5, 6);
	    piezasGeneradas[9] = new Pieza(TipoPieza.PEON, Color.NEGRO);
	    coordenadasGeneradas[9] = new Coordenada(4, 6);
	    piezasGeneradas[10] = new Pieza(TipoPieza.PEON, Color.NEGRO);
	    coordenadasGeneradas[10] = new Coordenada(3, 6);
	    piezasGeneradas[11] = new Pieza(TipoPieza.PEON, Color.NEGRO);
	    coordenadasGeneradas[11] = new Coordenada(6, 5);
	    piezasGeneradas[12] = new Pieza(TipoPieza.PEON, Color.NEGRO);
	    coordenadasGeneradas[12] = new Coordenada(6, 4);
	    piezasGeneradas[13] = new Pieza(TipoPieza.PEON, Color.NEGRO);
	    coordenadasGeneradas[13] = new Coordenada(6, 3);
	    
	    // Siempre empiezan blancas :)
	    colocarPiezas(piezasGeneradas, coordenadasGeneradas, Color.BLANCO);
	}

	
	public Caja consultarCaja(Color color) {
		// Implementacion Dummy
		return new Caja(Color.BLANCO);
	}
	
	public int consultarNumeroJugada() {
		return this.contadorJugadas;
	}
	
	public Tablero consultarTablero() {
		return this.tablero.clonar();
	}
	
	public Color consultarTurno() {
		return this.turno;
	}
	
	public Color consultarTurnoGanador() {
		return this.turno;
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

	@Override
	public int hashCode() {
		return Objects.hash(contadorJugadas, tablero, turno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arbitro other = (Arbitro) obj;
		return contadorJugadas == other.contadorJugadas && Objects.equals(tablero, other.tablero)
				&& turno == other.turno;
	}

	@Override
	public String toString() {
		return "Arbitro [tablero=" + tablero + ", contadorJugadas=" + contadorJugadas + ", turno=" + turno + "]";
	}
	
	// Pendiente toString()
}
