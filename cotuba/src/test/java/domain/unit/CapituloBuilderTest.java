package domain.unit;

import cotuba.domain.Capitulo;
import cotuba.domain.builder.CapituloBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CapituloBuilderTest {

    @Test
    public void deveCriarCapituloCorretamente(){
        CapituloBuilder capituloBuilder = new CapituloBuilder();
        Capitulo capitulo = capituloBuilder
                .comConteudoHTML("<h1>ola</h1>")
                .comTitulo("Titulo teste!")
                .constroi();

        assertEquals("<h1>ola</h1>", capitulo.conteudoHTML());
        assertEquals("Titulo teste!", capitulo.titulo());
    }
}
