package utilitario;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Utilitario {
    static NumberFormat formatoMoeda = new DecimalFormat("R$ #,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    public static String doubleToString(Double valor) {
        return formatoMoeda.format(valor);
    }
}
