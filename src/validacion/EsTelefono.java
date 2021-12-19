package validacion;

public class EsTelefono implements IValidador {

    @Override
    public boolean validar(String telefono) {
        boolean telefonoCorrecto = false;
        try {
            String regex = "[0-9]+";
            if (telefono.length() > 8 && telefono.length() <= 10) {

                int primerDigito = Integer.parseInt(telefono.substring(0, 1));
                if (primerDigito == 0) {
                    int[] codigoTelfFijo = {2, 3, 4, 5, 6, 7};
                    int segundoDigito = Integer.parseInt(telefono.substring(1, 2));
                    int tercerDigito = Integer.parseInt(telefono.substring(2, 3));
                    if (segundoDigito == 9) {
                        telefonoCorrecto = telefono.matches(regex);
                    } else {
                        for (int i = 0; i < codigoTelfFijo.length; i++) {
                            if (segundoDigito == codigoTelfFijo[i] && tercerDigito == 2) {
                                telefonoCorrecto = telefono.matches(regex);
                                break;
                            }
                        }
                    }

                }
            } else {
                telefonoCorrecto = false;
            }
        } catch (Exception e) {
            telefonoCorrecto = false;
        }
        return telefonoCorrecto;

    }

}
