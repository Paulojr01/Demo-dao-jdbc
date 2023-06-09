package LimpaConsole;

import java.io.IOException;

public class Limpa {
    public static void Console() throws InterruptedException, IOException, IOException {

        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            new ProcessBuilder("clear").inheritIO().start().waitFor();
    }
}

