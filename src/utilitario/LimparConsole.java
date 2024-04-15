package utilitario;

import java.io.IOException;

public class LimparConsole {

    public static void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao limpar a tela do console: " + e.getMessage());
        }
    }
}
