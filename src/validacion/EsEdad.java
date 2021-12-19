package validacion;

public class EsEdad implements IValidador {

    @Override
    public boolean validar(String edad) {
        boolean edadCorrecta;
        try {
            String regex = "[0-9]+";//
            if (edad.matches(regex)) {
                int valorEdad = Integer.parseInt(edad);
                if (edad.substring(0, 1).equals("0")) {
                    edadCorrecta = false;
                }
                edadCorrecta = (valorEdad > 0 && valorEdad < 65);
            } else {
                edadCorrecta = false;
            }
        } catch (Exception e) {
            edadCorrecta = false;
        }
        return edadCorrecta;
    }

}
