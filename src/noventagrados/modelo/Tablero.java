package noventagrados.modelo;

import java.util.Arrays;

import noventagrados.util.Coordenada;

public class Tablero {
	private Celda[][] tablero;
	
	public Tablero() {
		this.tablero = new Celda[7][7];
		// Vamos a meter una celda en cada uno (Esto esta duplicado)
		for(int i=0; i<this.tablero.length; i++) {
			for(int j=0; j<this.tablero[i].length; j++) {
				this.tablero[i][j] = new Celda(new Coordenada(i, j));
			}
		}
	}
	
	/**
	 * Vaya horror de implementacion, pero funciona!
	 * 
	 * @return
	 */
	public String aTexto() {
	    String result = "";

	    for (int i = 0; i < this.tablero.length; i++) {
	        result += i + " ";  // Agregar índice de fila al inicio de cada línea
	        for (int j = 0; j < this.tablero[i].length; j++) {
	            Celda celdaActual = this.tablero[i][j];
	            Pieza piezaActual = celdaActual.consultarPieza();
	            // En caso de que no tenga pieza en la celda
	            if (piezaActual == null) {
	                result += "-- ";
	            } else {
	                // En caso de que haya una pieza, añadir su tipo y color
	                result += piezaActual.aTexto() + " ";
	            }
	        }
	        result += "\n"; // Nueva línea al final de cada fila
	    }

	    // Al final, añadir los índices de las columnas
	    result += "   0  1  2  3  4  5  6";

	    return result;
	}

	
	public Tablero clonar() {
	    Tablero clonTablero = new Tablero();
	    
	    // Recorrer el tablero para clonar cada celda y pieza
	    for (int i = 0; i < this.tablero.length; i++) {
	        for (int j = 0; j < this.tablero[i].length; j++) {
	            // Clonar cada celda
	        	clonTablero.tablero[i][j] = this.tablero[i][j].clonar();
	        }
	    }
	    return clonTablero;
	}
	
	public void colocar(Pieza pieza, Coordenada coordenada) {
		// Comprobaciones, clausula de guarda
		if(pieza == null || this.estaEnTablero(coordenada) == false) return;
		
		Celda celdaActual = this.consultarCelda(coordenada);
		
		celdaActual.colocar(pieza);
	}
	
	public Celda consultarCelda(Coordenada coordenada) {
		if(!this.estaEnTablero(coordenada)) return null;
		
		Celda celdaConsultada = this.tablero[coordenada.fila()][coordenada.columna()];
		
		return celdaConsultada.clonar();
		
	}
	
	/**
	 * Devolvemos un array de todas las celdas en un array "aplanado" de una dimensión
	 * 
	 * @return Celda[]
	 */
	public Celda[] consultarCeldas() {
		Celda[] arrayCeldas = new Celda[7*7]; // Siempre considero que es de 7x7
		
		for(int i=0; i<this.tablero.length; i++) {
			for(int j=0; j<this.tablero[i].length; j++) {
				// Voy a usar la combinacion de los dos para crear un indice plano
				// i+j*7 (7 es el array length del interior)
				int idx = i + j * this.tablero[i].length; // Todos son de 7 en realidad
				arrayCeldas[idx] = this.tablero[i][j];
			}
		}
		
		return arrayCeldas;
	}
	
	public int consultarNumeroColumnas() {
		// Hardcodeado LOL
		return 7;
	}
	
	public int consultarNumeroFilas() {
		// Hardcodeado LOL
		return 7;
	}
	
	public void eliminarPieza(Coordenada coordenada) {
		// Si NO esta en el tablero no hacer nada
		if(this.estaEnTablero(coordenada) == false) return;
		
		this.consultarCelda(coordenada).eliminarPieza();
	}
	
	public boolean estaEnTablero(Coordenada coordenada) {
		boolean estaDentro = true;
		
		// Lo hago así porque me resulta más claro de leer.
		if(coordenada == null) return false; 
		
		// idxMaximo = length - 1. Por eso si es igual o mayor está fuera. DISLEXIA
		if(coordenada.fila()>=this.consultarNumeroFilas()) estaDentro = false; 
		if(coordenada.columna()>=this.consultarNumeroColumnas()) estaDentro = false; 
		if(coordenada.fila()<0) estaDentro = false;
		if(coordenada.columna()<0) estaDentro = false;
		
		// Aqui hubiera hecho varios returns para no ir comprobando todos los casos, sino simplemente salirme cuando llegara 
		// cualquiera de los casos que resultan falsos. Una vez comprobados no necesitaria seguir...
		// Pero como no me dejais.... pues eso....
		
		return estaDentro; 
	}
	
	Celda obtenerCelda(Coordenada coordenada) {
		// Si no esta en el tablero devuelve un null
		if(this.estaEnTablero(coordenada) == false) return null;
		
		// Requiere un deep clone. Por lo cual hay que generar un nuevo objeto Celda
		Celda celda = this.tablero[coordenada.fila()][coordenada.columna()];
		return celda.clonar();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(tablero);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tablero other = (Tablero) obj;
		return Arrays.deepEquals(tablero, other.tablero);
	}

	@Override
	public String toString() {
		return "Tablero [tablero=" + Arrays.toString(tablero) + "]";
	}
	
	
}
