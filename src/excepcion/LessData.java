package excepcion;

/**
 * Maneja una excepcion para decir la perdida de datos.
 * @author Harrison Diaz
 */
public class LessData extends Exception{

    private static final String MESSAGE = "Se perdieron datos";

    public LessData() {
        super(MESSAGE);
    }


}
