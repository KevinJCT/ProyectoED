package validacion;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EsFecha implements IValidador {

    @Override
    public boolean validar(String fecha) {
        boolean fechaCorrecta = false;
        try {
            //dd/mm/yyyy
            //0123456789
            String regex = "^([0-2][0-9]|3[0-1])(\\/)(0[1-9]|1[0-2])\\2(\\d{4})$";
            int diaUser = Integer.parseInt(fecha.substring(0, 2));
            int mesUser = Integer.parseInt(fecha.substring(3, 5));
            int anhoUser = Integer.parseInt(fecha.substring(6, 10));

            SimpleDateFormat fechaSystem = new SimpleDateFormat("dd/MM/yyyy");
            String fechaSystemString = fechaSystem.format(new Date());
            int diaSystem = Integer.parseInt(fechaSystemString.substring(0, 2));
            int mesSystem = Integer.parseInt(fechaSystemString.substring(3, 5));
            int anhoSystem = Integer.parseInt(fechaSystemString.substring(6, 10));

            //@felix: qué tal cuando cambiamos de año?
            if (diaUser >= diaSystem) {
                if (mesUser >= mesSystem) {
                    if (anhoUser >= anhoSystem) {
                        fechaCorrecta = fecha.matches(regex);
                    }
                }
            }
        } catch (Exception e) {
            fechaCorrecta = false;
        }

        return fechaCorrecta;
    }

}
