package noventagrados.control.undo;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Tablero;

abstract public class MecanismoDeDeshacerAbstracto implements MecanismoDeDeshacer {
	// Atributos
    protected Date fechaInicio;
    protected List<Arbitro> arbitros;
    protected List<Jugada> jugadas;
    
    // Metodos concretos
    public MecanismoDeDeshacerAbstracto(Date fecha) {
        this.fechaInicio = fecha;
        this.jugadas = new ArrayList<Jugada>();
        this.arbitros = new ArrayList<Arbitro>();
    }
    
    
    public Date obtenerFechaInicio() {
    	return this.fechaInicio;
    }
    
    // Metodos abstractos a implementar en cada clase concreta
    public abstract int consultarNumeroJugadasEnHistorico();
    public abstract void deshacerJugada();
    public abstract void hacerJugada(Jugada jugada);
    public abstract Arbitro consultarArbitroActual();
}
