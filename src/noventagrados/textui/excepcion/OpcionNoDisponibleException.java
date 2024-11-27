package noventagrados.textui.excepcion;

// No es necesario importar 'java.lang.Exception' explícitamente,
// ya que está incluido por defecto.
public class OpcionNoDisponibleException extends Exception {
    
    // Cambiamos el modificador de serialVersionUID a `static final`, como es la convención
    private static final long serialVersionUID = 1L;

    // Constructor por defecto
    public OpcionNoDisponibleException() {
        super(); // Llama al constructor por defecto de Exception
    }

    // Constructor con un mensaje personalizado
    public OpcionNoDisponibleException(String message) {
        super(message); // Llama al constructor de Exception con el mensaje
    }

    // Constructor con una causa
    public OpcionNoDisponibleException(Throwable cause) {
        super(cause); // Llama al constructor de Exception con la causa
    }

    // Constructor con mensaje y causa
    public OpcionNoDisponibleException(String message, Throwable cause) {
        super(message, cause); // Llama al constructor de Exception con mensaje y causa
    }
}
