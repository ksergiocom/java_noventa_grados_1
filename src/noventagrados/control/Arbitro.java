package noventagrados.control;
import java.util.ArrayList;
import noventagrados.modelo.Tablero;
import noventagrados.modelo.Pieza;

import java.util.Objects;

import noventagrados.modelo.Celda;
import noventagrados.modelo.Jugada;

import noventagrados.util.Color;
import noventagrados.util.Coordenada;
import noventagrados.util.TipoPieza;
import noventagrados.util.Sentido;

/**
 * Árbitro se encarga de controlar el estado de la partida y realizar las acciones necesarias.
 * 
 * @author Víctor Acevedo Lorenzo
 * @author Sergiy Khudoley
 * @version 1.0
 * @since 1.0
 */
public class Arbitro {
	/**
	 * Tablero sobre el cual se realizan las jugadas.
	 * 
	 * @see noventagrados.modelo.Tablero
	 */
	private Tablero tablero;
	
	/**
	 * Número de jugadas realizadas durante la partida.
	 */
	private int contadorJugadas;
	
	/**
	 * Turno del jugador actual. Utiliza su color.
	 * 
	 * @see noventagrados.util.Color
	 */
	private Color turno;
	
	/**
	 * Caja del color negro utilizada para guardar las piezas negras que se han salido del tablero.
	 * 
	 * @see noventagrados.modelo.Caja
	 */
	private Caja cajaNegra;
	
	/**
	 * Caja del color blanco utilizada para guardar las piezas blancas que se han salido del tablero.
	 * 
	 * @see noventagrados.modelo.Caja
	 */
	private Caja cajaBlanca;

	/**
	 * El arbitro se genera con un tablero e inicializa las cajas vacias y asigna los
	 * turnos y contadores iniciales.
	 * 	
	 * @param tablero El tablero sobre el cual se desarolla la partida.
	 */
	public Arbitro(Tablero tablero) {
		this.tablero = tablero;
		this.contadorJugadas = 0;
		this.turno = null;
		this.cajaNegra = new Caja(Color.NEGRO);
		this.cajaBlanca = new Caja(Color.BLANCO);
	}

	/**
	 * Cambia el turno al otro contrincante.
	 */

	public void cambiarTurno() {
		if (this.turno == Color.BLANCO) {
			this.turno = Color.NEGRO;
		} else {
			this.turno = Color.BLANCO;
		}
	}

	/**
	 * Coloca cada pieza en su correspondiente posición del tablero, basada en las
	 * coordenadas proporcionadas. Además, establece el turno actual al color
	 * indicado.
	 * 
	 * @param piezas      Un array de piezas que se deben colocar en el tablero.
	 * @param coordenadas Un array de coordenadas correspondientes a las posiciones
	 *                    de las piezas.
	 * @param turnoActual El color que representa el turno actual.
	 */
	public void colocarPiezas(ArrayList<Pieza> piezas, ArrayList<Coordenada> coordenadas, Color turnoActual) {
		this.turno = turnoActual;
		// Vamos a considerar que las piezas y las coordenadas vienen emparejadas 1 a 1
		// en los arrays
		for (int i = 0; i < piezas.size(); i++) {
			Pieza piezaActual =  piezas.get(i);
			Coordenada coordenadaActual = coordenadas.get(i);
			this.tablero.colocar(piezaActual, coordenadaActual);
		}
	}

	/**
	 * Coloca las piezas correspondientes a la configuración de inicio del juego e inicializando
	 * siempre el turno para el atacante con piezas blancas.
	 */
	public void colocarPiezasConfiguracionInicial() {
	    // Crear listas para almacenar las piezas iniciales y sus coordenadas
	    ArrayList<Pieza> piezasGeneradas = new ArrayList<>();
	    ArrayList<Coordenada> coordenadasGeneradas = new ArrayList<>();

	    // Colocar la reina blanca en [0,0]
	    piezasGeneradas.add(new Pieza(TipoPieza.REINA, Color.BLANCO));
	    coordenadasGeneradas.add(new Coordenada(0, 0));

	    // Colocar los peones blancos en posiciones cercanas a la esquina superior izquierda
	    piezasGeneradas.add(new Pieza(TipoPieza.PEON, Color.BLANCO));
	    coordenadasGeneradas.add(new Coordenada(1, 0));
	    piezasGeneradas.add(new Pieza(TipoPieza.PEON, Color.BLANCO));
	    coordenadasGeneradas.add(new Coordenada(2, 0));
	    piezasGeneradas.add(new Pieza(TipoPieza.PEON, Color.BLANCO));
	    coordenadasGeneradas.add(new Coordenada(3, 0));
	    piezasGeneradas.add(new Pieza(TipoPieza.PEON, Color.BLANCO));
	    coordenadasGeneradas.add(new Coordenada(0, 1));
	    piezasGeneradas.add(new Pieza(TipoPieza.PEON, Color.BLANCO));
	    coordenadasGeneradas.add(new Coordenada(0, 2));
	    piezasGeneradas.add(new Pieza(TipoPieza.PEON, Color.BLANCO));
	    coordenadasGeneradas.add(new Coordenada(0, 3));

	    // Colocar la reina negra en [6,6]
	    piezasGeneradas.add(new Pieza(TipoPieza.REINA, Color.NEGRO));
	    coordenadasGeneradas.add(new Coordenada(6, 6));

	    // Colocar los peones negros en posiciones cercanas a la esquina inferior derecha
	    piezasGeneradas.add(new Pieza(TipoPieza.PEON, Color.NEGRO));
	    coordenadasGeneradas.add(new Coordenada(5, 6));
	    piezasGeneradas.add(new Pieza(TipoPieza.PEON, Color.NEGRO));
	    coordenadasGeneradas.add(new Coordenada(4, 6));
	    piezasGeneradas.add(new Pieza(TipoPieza.PEON, Color.NEGRO));
	    coordenadasGeneradas.add(new Coordenada(3, 6));
	    piezasGeneradas.add(new Pieza(TipoPieza.PEON, Color.NEGRO));
	    coordenadasGeneradas.add(new Coordenada(6, 5));
	    piezasGeneradas.add(new Pieza(TipoPieza.PEON, Color.NEGRO));
	    coordenadasGeneradas.add(new Coordenada(6, 4));
	    piezasGeneradas.add(new Pieza(TipoPieza.PEON, Color.NEGRO));
	    coordenadasGeneradas.add(new Coordenada(6, 3));

	    // Siempre empiezan blancas :)
	    colocarPiezas(piezasGeneradas, coordenadasGeneradas, Color.BLANCO);
	}
	

	/**
	 * Devuelve la caja del color consultado.
	 * 
	 * @param color Color de la caja que queremos que nos devuelva.
	 * 
	 * @return caja El objeto caja del color indicado.
	 */
	public Caja consultarCaja(Color color) {
		if (color == Color.BLANCO) {
			return this.cajaBlanca;
		} else {
			return this.cajaNegra;
		}
	}

	/**
	 * Devuelve un entero que indique el número de jugadas realizadas hasta el momento.
	 * 
	 * @return contadorJugadas Número de jugadas realizadas hasta el momento por el arbitro.
	 */
	public int consultarNumeroJugada() {
		return this.contadorJugadas;
	}

	/**
	 * Devuelve un clon en profundidad del tablero actual.
	 * 
	 * @return clonTablero Clon en profundidad del tablero actual.
	 */

	public Tablero consultarTablero() {
		return this.tablero.clonar();
	}

	/**
	 * Consulta el turno actual del juego y devuelve el color del jugador que puede realizar la siguiente jugada.
	 * 
	 * @return Color Color del jugador que puede realizar la siguiente jugada.
	 * 
	 */
	public Color consultarTurno() {
		return this.turno;
	}

	/**
	 * Devuelve el turno del ganador actual o null si no hay ganador.
	 * 
	 * @return colorDevuelto Color del ganador actual o null en caso de que no haya
	 *         ganador o haya empate.
	 */
	public Color consultarTurnoGanador() {
		Color colorDevuelto = null;

		// Si reina llega a centro (3,3) gana ese color
		Coordenada coordenadaCentro = new Coordenada(3, 3);
		Celda celdaCentral = this.tablero.obtenerCelda(coordenadaCentro);
		Pieza piezaCentral = celdaCentral.consultarPieza();

		// Comprobamos si hay una pieza en el centro
		if (piezaCentral != null) {
			boolean piezaCentralEsReina = piezaCentral.consultarTipoPieza() == TipoPieza.REINA;
			Color colorPiezaCentral = piezaCentral.consultarColor();

			if (piezaCentralEsReina && colorPiezaCentral == Color.BLANCO) {
				colorDevuelto = Color.BLANCO;
			}

			if (piezaCentralEsReina && colorPiezaCentral == Color.NEGRO) {
				colorDevuelto = Color.NEGRO;
			}
		}

		// Si la reina esta fuera de tablero gana el color contrario
		if (this.cajaBlanca.contarPiezas(TipoPieza.REINA) > 0 && this.cajaNegra.contarPiezas(TipoPieza.REINA) > 0)
			colorDevuelto = null;
		else if (this.cajaNegra.contarPiezas(TipoPieza.REINA) > 0)
			colorDevuelto = Color.BLANCO;
		else if (this.cajaBlanca.contarPiezas(TipoPieza.REINA) > 0)
			colorDevuelto = Color.NEGRO;

		return colorDevuelto;
	}

	/**
	 * Mueve la pieza desde la celda de origen hasta la celda de destino y empuja las piezas
	 * que vaya encontrando por el camino. Además incrementa el contador de jugadas.
	 * 
	 * @param jugada Jugada con la celda de origen y la celda de destino.
	 */
	public void empujar(Jugada jugada) {
		mover(jugada.origen().consultarCoordenada(), jugada.destino().consultarCoordenada());
		this.contadorJugadas++;

		// Dejamos otra implementación posible de forma iterativa (usa un LinkedList a modo de pila)
		
		// Version iterativa usando una pila FIFO para recoger y colocar las piezas
		//		TableroConsultor consultor = new TableroConsultor(this.tablero);
		//		LinkedList<Pieza> almacenPiezas = new LinkedList<Pieza>();
		//		Celda celdaOrigen = jugada.origen();
		//		Celda celdaDestino = jugada.destino();		
		//		Sentido sentido = consultor.calcularSentido(celdaOrigen.consultarCoordenada(), celdaDestino.consultarCoordenada());
		//
		//		Celda celdaIterada = this.tablero.consultarCelda(celdaOrigen.consultarCoordenada());
		//		do {
		//			Pieza piezaCeldaIterada = celdaIterada.consultarPieza();
		//			// ¿Tiene una pieza esta celda?
		//			if(piezaCeldaIterada!=null) {
		//				// Creamos una pieza para moverla a la pila y trabajar con ella
		//				Pieza piezaClonada = new Pieza(piezaCeldaIterada.consultarTipoPieza(), piezaCeldaIterada.consultarColor());
		//				// La guardamos en la pila FIFO
		//				almacenPiezas.add(piezaClonada);
		//				// Quitamos de la celda original la pieza original
		//				celdaIterada.eliminarPieza();
		//			}
		//			// Ahora buscamos la siguiente coordenada
		//			Coordenada siguienteCoordenada = new Coordenada(
		//					celdaIterada.consultarCoordenada().fila() + sentido.consultarDesplazamientoEnFilas(),
		//					celdaIterada.consultarCoordenada().columna() + sentido.consultarDesplazamientoEnColumnas()
		//					);
		//			// Especificamos cual es la siguiente celda par ala proxima iteracion
		//			celdaIterada = this.tablero.consultarCelda(siguienteCoordenada);
		//		}while(celdaIterada.consultarCoordenada().fila() != celdaDestino.consultarCoordenada().fila() && celdaIterada.consultarCoordenada().columna() != celdaDestino.consultarCoordenada().columna());
		//		
		//		// Ahora celdaIterada es la celda de destino. Hemos llegado tío
		//		// Ahora miramos las celdas a partir de la celda de destino y
		//		// Si está llena sacamos la pieza y la metemos en la pila 
		//		// Metemos en la celda la pieza de la pila
		//		
		//		// Celda iterada es celda destino ahora mismo
		//		while(celdaIterada != null && this.tablero.estaEnTablero(celdaIterada.consultarCoordenada())) {
		//			Pieza piezaCeldaIterada = celdaIterada.consultarPieza();
		//			if(piezaCeldaIterada!=null) {
		//				// Creamos una pieza para moverla a la pila y trabajar con ella
		//				Pieza piezaClonada = new Pieza(piezaCeldaIterada.consultarTipoPieza(), piezaCeldaIterada.consultarColor());
		//				// La guardamos en la pila FIFO
		//				almacenPiezas.add(piezaClonada);
		//				// Quitamos de la celda original la pieza original
		//				celdaIterada.eliminarPieza();
		//			}
		//			// Sacamos el primer elemento de almacenPiezas (nuestro FIFO)
		//			celdaIterada.colocar(almacenPiezas.poll());
		//			Coordenada siguienteCoordenada = new Coordenada(
		//					celdaIterada.consultarCoordenada().fila() + sentido.consultarDesplazamientoEnFilas(),
		//					celdaIterada.consultarCoordenada().columna() + sentido.consultarDesplazamientoEnColumnas()
		//					);
		//			// Especificamos cual es la siguiente celda par ala proxima iteracion
		//			celdaIterada = this.tablero.consultarCelda(siguienteCoordenada);
		//		}
		//		
		//		// Aqui ya estaríamos fuera del tablero, así que el resto lo tiramos a la caja respectiva
		//		// Mientras la 
		//		while(!almacenPiezas.isEmpty()) {
		//			Pieza piezaSacada = almacenPiezas.poll();
		//			if(piezaSacada.consultarColor() == Color.BLANCO) {
		//				this.cajaBlanca.añadir(piezaSacada);
		//			}else {
		//				this.cajaNegra.añadir(piezaSacada);
		//			}
		//		}
		//		
		//		return;
	}

	/**
	 * Comprueba si la jugada que pasemos por parámetro es legal o
	 * no.
	 * 
	 * @param jugada Juagada con las celdas de origen y de destino
	 * 
	 * @return jugadaLegal Devuelve True si la jugada es legal y False si la jugada
	 *         no es legal.
	 */
	public boolean esMovimientoLegal(Jugada jugada) {
		boolean jugadaLegal = true;

		// Si la coordenda de destino no esta en tablero, entonces es ilegal
		if (!this.tablero.estaEnTablero(jugada.destino().consultarCoordenada()))
			jugadaLegal = false;

		// Coger la celda de origen, comprobar la pieza y si es del color del turno
		// entonces ok, si no es ilegal
		if (jugada.origen().consultarColorDePieza() != this.turno)
			jugadaLegal = false;

		// Turnos pares son Negras
		if (this.turno == Color.BLANCO && this.contadorJugadas % 2 == 1)
			jugadaLegal = false;

		// Datos para comprobar si es legal
		// Necesitas el TableroConsultor para el sentido
		TableroConsultor consultor = new TableroConsultor(this.tablero);
		Sentido sentido = consultor.calcularSentido(jugada.origen().consultarCoordenada(),
				jugada.destino().consultarCoordenada());
		int distancia;
		int numPiezas;

		// Horizontales
		if (sentido == Sentido.HORIZONTAL_E || sentido == Sentido.HORIZONTAL_O) {
			distancia = consultor.consultarDistanciaEnHorizontal(jugada.origen().consultarCoordenada(),
					jugada.destino().consultarCoordenada());
			numPiezas = consultor.consultarNumeroPiezasEnVertical(jugada.origen().consultarCoordenada());
			if (distancia != numPiezas)
				jugadaLegal = false;
		}
		// Verticales
		else {
			distancia = consultor.consultarDistanciaEnVertical(jugada.origen().consultarCoordenada(),
					jugada.destino().consultarCoordenada());
			numPiezas = consultor.consultarNumeroPiezasEnHorizontal(jugada.origen().consultarCoordenada());
			if (distancia != numPiezas)
				jugadaLegal = false;
		}

		return jugadaLegal;
	}

	/**
	 * Comprueba si se da cualquiera de las condiciones de finalización actualmente.
	 * 
	 * Se comprueba si alguna reina alcanza el centro o alguna de ellas se ha salido del tablero y está en alguna caja.
	 * 
	 * @return estaTerminada Devuelve true si la partida ha terminado y false si la
	 *         partida continúa.
	 */
	public boolean estaFinalizadaPartida() {
		boolean estaTerminada = false;

		// Se finaliza si hay reina en el centro o hay alguna reina en cualquiera de las
		// dos cajas
		TableroConsultor consultor = new TableroConsultor(this.tablero);

		if (!consultor.hayReina(Color.BLANCO) || !consultor.hayReina(Color.NEGRO))
			estaTerminada = true;

		if (consultor.estaReinaEnElCentro(Color.BLANCO) || consultor.estaReinaEnElCentro(Color.NEGRO))
			estaTerminada = true;

		return estaTerminada;
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

	/**
	 * Mueve una pieza desde una celda con la coordenada de origen hacia la coordenada de destino. En caso de que 
	 * exista alguna pieza por el camino la mueve con UNA coordenada de destino más allá sobre el sentido aplicado.
	 * 
	 * Si la pieza se sale del tablero se asignará a la caja del color correspondiente.
	 * 
	 * @param origen Coordenada de origen del movimiento
	 * @param destino Coordenada de destino del movimiento
	 */
	private void mover(Coordenada origen, Coordenada destino) {
		// Util para determinar el movimiento
		TableroConsultor consultor = new TableroConsultor(this.tablero);

		// Calcular el sentido del movimiento basado en origen y destino
		Sentido sentido = consultor.calcularSentido(origen, destino);

		// Definir la siguiente coordenada en la dirección del sentido
		Coordenada siguienteCoordenada = new Coordenada(origen.fila() + sentido.consultarDesplazamientoEnFilas(),
				origen.columna() + sentido.consultarDesplazamientoEnColumnas());

		Celda celdaOrigen = this.tablero.obtenerCelda(origen);

		// Clonar y eliminar la pieza de la celda de origen
		Pieza piezaClonada = celdaOrigen.consultarPieza();
		celdaOrigen.eliminarPieza();

		// Comprobar si la siguiente coordenada está fuera del tablero
		if (!this.tablero.estaEnTablero(siguienteCoordenada)) {
			// Si está fuera, añadir a la caja correspondiente y terminar
			if (piezaClonada.consultarColor() == Color.BLANCO) {
				this.cajaBlanca.añadir(piezaClonada);
			} else {
				this.cajaNegra.añadir(piezaClonada);
			}
			return;
		}

		Celda celdaSiguiente = this.tablero.obtenerCelda(siguienteCoordenada);

		// Si la celda siguiente no está vacía, empujar la pieza que está allí
		if (!celdaSiguiente.estaVacia()) {
			// Empuja la pieza en `celdaSiguiente` a la siguiente posición en el mismo
			// sentido
			mover(celdaSiguiente.consultarCoordenada(),
					new Coordenada(siguienteCoordenada.fila() + sentido.consultarDesplazamientoEnFilas(),
							siguienteCoordenada.columna() + sentido.consultarDesplazamientoEnColumnas()));
		}

		// Colocar la pieza clonada en la celda siguiente
		celdaSiguiente.colocar(piezaClonada);

		// Condición de parada: si hemos alcanzado el destino, terminamos
		if (siguienteCoordenada.equals(destino)) {
			return;
		}

		// Llamada recursiva para avanzar hacia el destino
		mover(siguienteCoordenada, destino);
	}

}
