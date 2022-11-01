package domain.unit;

import cotuba.domain.Capitulo;
import cotuba.domain.builder.CapituloBuilder;
import org.junit.Assert;
import org.junit.Test;

public class CapituloBuilderTest {

    @Test
    public void deveCriarCapituloCorretamente(){
        CapituloBuilder capituloBuilder = new CapituloBuilder();
        Capitulo capitulo = capituloBuilder
                .comConteudoHTML("<h1>ola</h1>")
                .comTitulo("Titulo teste!")
                .constroi();

        Assert.assertEquals("<h1>ola</h1>", capitulo.conteudoHTML());
        Assert.assertEquals("Titulo teste!", capitulo.titulo());
    }
}
