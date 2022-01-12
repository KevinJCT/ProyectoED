package validacion;

public class ValidadorExpReg implements IValidador {

    public static final String ENTERO_CON_SIGNO = "[+-]?[0-9]*";
    public static final String ENTERO_SIN_SIGNO = "[0-9]*";
    public static final String FECHA = "^([0-2][0-9]|3[0-1])(\\/)(0[1-9]|1[0-2])\\2(\\d{4})$";
    public static final String NUM_CON_COMA = "[+-]?([0-9]*[.])?[0-9]+";
    public static final String SOLO_LETRAS = "[ñÑüÜáéíóúÁÉÍÓÚA-Za-z]+";
    public static final String CADENA_TEXTO = "[ñÑáéíóúÁÉÍÓÚA-Za-z1-9].+";
    public static final String EMAIL = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
 
//    public static final String POS_JUGADOR = "/[0-]";
    
    String exprReg;

    public ValidadorExpReg(String exprReg) {
        this.exprReg = exprReg;
    }

    @Override
    public boolean validar(String dato) {
        return dato.matches(exprReg);
    }
}
