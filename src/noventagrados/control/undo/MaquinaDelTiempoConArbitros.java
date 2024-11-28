package noventagrados.control.undo;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Tablero;
/**
 * Creamos una clase pública llamada MaquinaDelTiempoConÁrbitro que hereda de 
 * MecanismosDeDeshacerAbstracto
 * 
 * @author Víctor Acevedo Lorenzo
 * @author Sergiy Khudoley
 * @version 1.0
 * @since 1.0
 * 
 */
public class MaquinaDelTiempoConArbitros extends MecanismoDeDeshacerAbstracto {
	
	/**
	 * Creamos método constructor que inicializa una MáquinaDelTiempoConÁrbitros pasando el
	 * parámetro fecha al constructor de la clase padre
	 * 
	 * @param fecha
	 */
	public MaquinaDelTiempoConArbitros(Date fecha) {
		super(fecha);
	}

	/**
	 */
	@Override
	public void deshacerJugada() {
		//removemos el ultimo arbitro
		// Solo si existe y tiene algún elemento
		if(this.arbitros != null && this.arbitros.size()>0) {
			this.arbitros.removeLast();	
		}
	}

	@Override
	public void hacerJugada(Jugada jugada) {
		Arbitro clonUltimoArbitro;
		// Cogemos un clon del ultimo arbitro guardado
		// Si existe algun arbitro guardado, devolver el último.
		if(this.arbitros != null && this.arbitros.size()>0) {
			clonUltimoArbitro = this.arbitros.getLast().clonar();	
		}
		// Sí NO hay arbitros guardados devolvemos un arbitro nuevo en su configuracion incial.
		else {
			Arbitro nuevoArbitro = new Arbitro(new Tablero());
			nuevoArbitro.colocarPiezasConfiguracionInicial();
			clonUltimoArbitro = nuevoArbitro;
		}
		// Realizamos la jugada
		clonUltimoArbitro.empujar(jugada);
		clonUltimoArbitro.cambiarTurno();
		// guardamos el nuevo arbitro como el ultimo
		this.arbitros.addLast(clonUltimoArbitro);
	}

	@Override
	public Arbitro consultarArbitroActual() {
		// Si existe algun arbitro guardado, devolver el último.
		if(this.arbitros != null && this.arbitros.size()>0) {
			return this.arbitros.getLast().clonar();	
		}
		// Sí NO hay arbitros guardados devolvemos un arbitro nuevo en su configuracion incial.
		else {
			Arbitro nuevoArbitro = new Arbitro(new Tablero());
			nuevoArbitro.colocarPiezasConfiguracionInicial();
			return nuevoArbitro;
		}
	}
	
	/**
	 * 
	 */
	@Override
	public int consultarNumeroJugadasEnHistorico() {
		return this.arbitros.size();
	}
	
	
}
