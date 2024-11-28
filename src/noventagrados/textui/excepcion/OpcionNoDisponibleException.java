package noventagrados.textui.excepcion;

// No es necesario importar 'java.lang.Exception' explícitamente,
// ya que está incluido por defecto.

/**
 * * Clase de excepción personalizada que indica que una opción seleccionada no está disponible.
 * 
 * @author <a href="val1002@alu.ubu.es">Víctor Acevedo Lorenzo</a>
 * @author <a href="skx1024@alu.ubu.es">Sergiy Khoudoley</a>
 * @version 1.0
 * @since 1.0
 */
public class OpcionNoDisponibleException extends Exception {
    
    /**
     * Identificador único para la serialización de la clase.
     */
    // Cambiamos el modificador de serialVersionUID a `static final`, como es la convención
    private static final long serialVersionUID = 1L;


    /**
     * Constructor por defecto para la excepción.
     * Llama al constructor por defecto.
     */
    
    // Constructor por defecto
    public OpcionNoDisponibleException() {
        super(); // Llama al constructor por defecto de Exception
    }
    
    /**
     * Constructor que acepta un mensaje personalizado para describir la excepción.
     * 
     * @param message El mensaje que describe la causa de la excepción.
     */

    // Constructor con un mensaje personalizado
    public OpcionNoDisponibleException(String message) {
        super(message); // Llama al constructor de Exception con el mensaje
    }
    
    /**
     * Constructor que acepta una causa para la excepción.
     * 
     * @param cause La causa subyacente de esta excepción, que puede ser recuperada más tarde.
     */

    // Constructor con una causa
    public OpcionNoDisponibleException(Throwable cause) {
        super(cause); // Llama al constructor de Exception con la causa
    }
    

    /**
     * Constructor que acepta un mensaje personalizado y una causa para la excepción.
     * 
     * @param message El mensaje que describe la causa de la excepción.
     * @param cause   La causa subyacente de esta excepción.
     */

    // Constructor con mensaje y causa
    public OpcionNoDisponibleException(String message, Throwable cause) {
        super(message, cause); // Llama al constructor de Exception con mensaje y causa
    }
}
