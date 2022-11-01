package cotuba.ports.integration;

import cotuba.cli.LeitorOpcoesCLI;
import cotuba.cli.Main;
import cotuba.domain.FormatoEbook;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class CotubaCliTest {

    @Test
    public void deveMontarParametrosComArgumentosRecebidosCorretamente(){
        String[] argumentos = new String[4];
        argumentos[0] = "-d";
        argumentos[1] = "./livro-exemplo";
        argumentos[2] = "-f";
        argumentos[3] = "epub";

        LeitorOpcoesCLI parametrosCotuba = Main.montaParametrosComArgumentosRecebidos(argumentos);

        assertEquals(FormatoEbook.EPUB, parametrosCotuba.getFormato());
        assertEquals(Paths.get("book.epub"), parametrosCotuba.getArquivoDeSaida());
        assertEquals(Paths.get("./livro-exemplo"), parametrosCotuba.getDiretorioDosMD());
    }

    @Test
    public void naoDeveGerarEbookCasoCliNaoPasseArgs(){
        assertThrows(IllegalStateException.class, () -> {
            Main.main(null);
        });
    }
}