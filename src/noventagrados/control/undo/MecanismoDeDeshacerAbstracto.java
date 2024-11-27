package noventagrados.control.undo;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;

abstract public class MecanismoDeDeshacerAbstracto implements MecanismoDeDeshacer {
	// Atributos
    protected Date fechaInicio;
    protected List<Arbitro> arbitros;
    protected List<Jugada> jugadas;
    
    // Metodos concretos
    public MecanismoDeDeshacerAbstracto() {
        this.fechaInicio = new Date();
    }
    
    public int consultarNumeroJugadasEnHistorico() {
    	return this.jugadas.size();
    }
    
    public Date obtenerFechaInicio() {
    	return this.fechaInicio;
    }
    
    public Arbitro consultarArbitroActual() {
    	Arbitro ultimoArbitroGuardado = this.arbitros.getLast();
    	
    	return ultimoArbitroGuardado.clonar();
    };
    
    // Metodos abstractos a implementar en cada clase concreta
    public abstract void deshacerJugada();
    public abstract void hacerJugada(Jugada jugada);
}
