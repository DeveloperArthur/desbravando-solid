package ports.integration;

import cotuba.cli.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CotubaCliTest {
    //chamar o main, passando os args, n deixa chamar o cotuba , conferir se os dados foram passados corretamente

    public void deveReceberArgumentosEChamarCotubaCorretamente(){

    }

    @Test
    public void naoDeveGerarEbookCasoCliNaoPasseArgs(){
        assertThrows(IllegalStateException.class, () -> {
            Main.main(null);
        });
    }
}
