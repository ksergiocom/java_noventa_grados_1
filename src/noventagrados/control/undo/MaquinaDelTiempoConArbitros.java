package noventagrados.control.undo;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Tablero;
/**
 * Creamos una clase pública llamada MaquinaDelTiempoConÁrbitro que hereda de 
 * MecanismosDeDeshacerAbstracto.
 * 
 * @author <a href="val1002@alu.ubu.es">Víctor Acevedo Lorenzo</a>
 * @author <a href="skx1024@alu.ubu.es">Sergiy Khoudoley</a>
 * @version 1.0
 * @since 1.0
 * 
 */
public class MaquinaDelTiempoConArbitros extends MecanismoDeDeshacerAbstracto {
    /**
     * Lista de arbitros que pueden estar asociados al proceso de jugadas.
     */
	private List<Arbitro> arbitros;
	
	/**
	 * Creamos método constructor que inicializa una MáquinaDelTiempoConÁrbitros pasando el
	 * parámetro fecha al constructor de la clase padre.
	 * 
	 * @param fecha Fecha de inicio de la partida
	 */
	public MaquinaDelTiempoConArbitros(Date fecha) {
		super(fecha);
		this.arbitros = new ArrayList<Arbitro>();
	}

	 /**
     * Deshace la última jugada realizada, eliminando el último estado del árbitro guardado.
     * Si no hay árbitros guardados, no realiza ninguna acción.
     */

	
	@Override
	public void deshacerJugada() {
		//removemos el ultimo arbitro
		// Solo si existe y tiene algún elemento
		if(this.arbitros != null && this.arbitros.size()>0) {
			this.arbitros.removeLast();	
		}
	}

	
    /**
     * Realiza una nueva jugada y actualiza el estado del árbitro. 
     * Si no hay árbitros guardados, se crea un nuevo árbitro con la configuración inicial.
     * 
     * @param jugada La jugada a realizar.
     */
	
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
			clonUltimoArbitro = crearNuevoArbitroInicial();
		}
		// Realizamos la jugada
		clonUltimoArbitro.empujar(jugada);
		clonUltimoArbitro.cambiarTurno();
		// guardamos el nuevo arbitro como el ultimo
		this.arbitros.addLast(clonUltimoArbitro);
	}

    /**
     * Consulta el arbitro actual desde el historial.
     * Si no hay árbitros guardados, devuelve un nuevo árbitro en su configuración inicial.
     * 
     * @return El árbitro actual o un nuevo árbitro en configuración inicial si el historial está vacío.
     */	
	
	@Override
	public Arbitro consultarArbitroActual() {
		// Si existe algun arbitro guardado, devolver el último.
		if(this.arbitros != null && this.arbitros.size()>0) {
			return this.arbitros.getLast().clonar();	
		}
		// Sí NO hay arbitros guardados devolvemos un arbitro nuevo en su configuracion incial.
		else {
			return crearNuevoArbitroInicial();
		}
	}
	
    /**
     * Consulta el numero de estados del árbitro almacenados en el historial.
     * 
     * @return El numero de arbitros almacenados en el historial.
     */
	
	@Override
	public int consultarNumeroJugadasEnHistorico() {
		return this.arbitros.size();
	}
	
}
