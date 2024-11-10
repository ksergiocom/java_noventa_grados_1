package noventagrados.control;

import noventagrados.modelo.Tablero;
import noventagrados.control.TableroConsultor;
import noventagrados.modelo.Pieza;

import java.util.Objects;
import java.util.LinkedList; // LOL lo usamos como una pila

import noventagrados.modelo.Celda;
import noventagrados.modelo.Jugada;

import noventagrados.util.Color;
import noventagrados.util.Coordenada;
import noventagrados.util.TipoPieza;
import noventagrados.util.Sentido;

public class Arbitro {
	private Tablero tablero;
	private int contadorJugadas;
	private Color turno;
	private Caja cajaNegra;
	private Caja cajaBlanca;
	
	public Arbitro(Tablero tablero) {
		this.tablero = tablero;
		this.contadorJugadas = 0;
		this.turno = null;
		this.cajaNegra = new Caja(Color.NEGRO);
		this.cajaBlanca = new Caja(Color.BLANCO);
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
		if(color == Color.BLANCO) {
			return this.cajaBlanca;
		}else {
			return this.cajaNegra;
		}
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
		Color colorDevuelto = null;
		
		//Si reina llega a centro (3,3) gana ese color
		Coordenada coordenadaCentro = new Coordenada(3,3);
		Celda celdaCentral = this.tablero.consultarCelda(coordenadaCentro);
		Pieza piezaCentral = celdaCentral.consultarPieza();
		
		// Comprobamos si hay una pieza en el centro
		if(piezaCentral != null) {
			boolean piezaCentralEsReina = piezaCentral.consultarTipoPieza() == TipoPieza.REINA;
			Color colorPiezaCentral = piezaCentral.consultarColor();
			
			if(piezaCentralEsReina	&& colorPiezaCentral == Color.BLANCO) {
				colorDevuelto = Color.BLANCO;
			}
			
			if(piezaCentralEsReina	&& colorPiezaCentral == Color.NEGRO) {
				colorDevuelto = Color.NEGRO;
			}			
		}
		
		
		//Si la reina esta fuera de tablero gana el color contrario
		if(this.cajaNegra.contarPiezas(TipoPieza.REINA) > 0) colorDevuelto = Color.BLANCO;
		if(this.cajaBlanca.contarPiezas(TipoPieza.REINA) > 0) colorDevuelto = Color.NEGRO;
		
		return colorDevuelto;
	}
	
	public void empujar(Jugada jugada) {
		TableroConsultor consultor = new TableroConsultor(this.tablero);
		LinkedList<Pieza> almacenPiezas = new LinkedList<Pieza>();
		Celda celdaOrigen = jugada.origen();
		Celda celdaDestino = jugada.destino();		
		Sentido sentido = consultor.calcularSentido(celdaOrigen.consultarCoordenada(), celdaDestino.consultarCoordenada());

		Celda celdaIterada = this.tablero.consultarCelda(celdaOrigen.consultarCoordenada());
		do {
			Pieza piezaCeldaIterada = celdaIterada.consultarPieza();
			// ¿Tiene una pieza esta celda?
			if(piezaCeldaIterada!=null) {
				// Creamos una pieza para moverla a la pila y trabajar con ella
				Pieza piezaClonada = new Pieza(piezaCeldaIterada.consultarTipoPieza(), piezaCeldaIterada.consultarColor());
				// La guardamos en la pila FIFO
				almacenPiezas.add(piezaClonada);
				// Quitamos de la celda original la pieza original
				celdaIterada.eliminarPieza();
			}
			// Ahora buscamos la siguiente coordenada
			Coordenada siguienteCoordenada = new Coordenada(
					celdaIterada.consultarCoordenada().fila() + sentido.consultarDesplazamientoEnFilas(),
					celdaIterada.consultarCoordenada().columna() + sentido.consultarDesplazamientoEnColumnas()
					);
			// Especificamos cual es la siguiente celda par ala proxima iteracion
			celdaIterada = this.tablero.consultarCelda(siguienteCoordenada);
		}while(celdaIterada.consultarCoordenada().fila() != celdaDestino.consultarCoordenada().fila() && celdaIterada.consultarCoordenada().columna() != celdaDestino.consultarCoordenada().columna());
		
		// Ahora celdaIterada es la celda de destino. Hemos llegado tío
		// Ahora miramos las celdas a partir de la celda de destino y
		// Si está llena sacamos la pieza y la metemos en la pila 
		// Metemos en la celda la pieza de la pila
		
		// Celda iterada es celda destino ahora mismo
		while(celdaIterada != null && this.tablero.estaEnTablero(celdaIterada.consultarCoordenada())) {
			Pieza piezaCeldaIterada = celdaIterada.consultarPieza();
			if(piezaCeldaIterada!=null) {
				// Creamos una pieza para moverla a la pila y trabajar con ella
				Pieza piezaClonada = new Pieza(piezaCeldaIterada.consultarTipoPieza(), piezaCeldaIterada.consultarColor());
				// La guardamos en la pila FIFO
				almacenPiezas.add(piezaClonada);
				// Quitamos de la celda original la pieza original
				celdaIterada.eliminarPieza();
			}
			// Sacamos el primer elemento de almacenPiezas (nuestro FIFO)
			celdaIterada.colocar(almacenPiezas.poll());
			Coordenada siguienteCoordenada = new Coordenada(
					celdaIterada.consultarCoordenada().fila() + sentido.consultarDesplazamientoEnFilas(),
					celdaIterada.consultarCoordenada().columna() + sentido.consultarDesplazamientoEnColumnas()
					);
			// Especificamos cual es la siguiente celda par ala proxima iteracion
			celdaIterada = this.tablero.consultarCelda(siguienteCoordenada);
		}
		
		// Aqui ya estaríamos fuera del tablero, así que el resto lo tiramos a la caja respectiva
		// Mientras la 
		while(!almacenPiezas.isEmpty()) {
			Pieza piezaSacada = almacenPiezas.poll();
			if(piezaSacada.consultarColor() == Color.BLANCO) {
				this.cajaBlanca.añadir(piezaSacada);
			}else {
				this.cajaNegra.añadir(piezaSacada);
			}
		}
		
		return;
	}
	
	public boolean esMovimientoLegal(Jugada jugada) {
		boolean jugadaLegal = true;
		
		// Si la coordenda de destino no esta en tablero, entonces es ilegal
		if(!this.tablero.estaEnTablero(jugada.destino().consultarCoordenada())) jugadaLegal = false;
		
		// Datos para comprobar si es legal
		// Necesitas el TableroConsultor para el sentido
		TableroConsultor consultor = new TableroConsultor(this.tablero);
		Sentido sentido = consultor.calcularSentido(jugada.origen().consultarCoordenada(), jugada.destino().consultarCoordenada());
		int distancia;
		int numPiezas;
		
		// Horizontales
		if(sentido == Sentido.HORIZONTAL_E || sentido == Sentido.HORIZONTAL_O) {
			distancia = consultor.consultarDistanciaEnHorizontal(jugada.origen().consultarCoordenada(), jugada.destino().consultarCoordenada());
			numPiezas = consultor.consultarNumeroPiezasEnVertical(jugada.origen().consultarCoordenada());
			if(distancia != numPiezas) jugadaLegal = false;
		}
		// Verticales
		else {
			distancia = consultor.consultarDistanciaEnVertical(jugada.origen().consultarCoordenada(), jugada.destino().consultarCoordenada());
			numPiezas = consultor.consultarNumeroPiezasEnHorizontal(jugada.origen().consultarCoordenada());
			if(distancia != numPiezas) jugadaLegal = false;			
		}
		
		return jugadaLegal;
	}
	
	public boolean estaFinalizadaPartida() {
		return this.consultarTurnoGanador() != null;
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
	
}
