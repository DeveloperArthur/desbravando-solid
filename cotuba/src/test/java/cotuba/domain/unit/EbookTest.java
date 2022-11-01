package cotuba.tests.unit;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.domain.FormatoEbook;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EbookTest {

    @Test
    public void deveRetornarUltimoCapitulo(){
        List<Capitulo> capitulos = new ArrayList<>();
        Capitulo primeiroCapitulo = new Capitulo("Para que serve OO?", "<h1>hello world</h1>");
        Capitulo segundoCapitulo = new Capitulo("S.O.L.I.D.", "<h1>hello world</h1>");
        Capitulo ultimoCapitulo = new Capitulo("Referências", "<h1>hello world</h1>");

        capitulos.add(primeiroCapitulo);
        capitulos.add(segundoCapitulo);
        capitulos.add(ultimoCapitulo);

        Ebook ebook = new Ebook(FormatoEbook.PDF, null, capitulos);

        boolean temQueSerFalse = ebook.ultimoCapitulo(primeiroCapitulo);
        boolean temQueSerFalseTambem = ebook.ultimoCapitulo(segundoCapitulo);
        boolean temQueSerTrue = ebook.ultimoCapitulo(ultimoCapitulo);

        assertFalse(temQueSerFalse);
        assertFalse(temQueSerFalseTambem);
        assertTrue(temQueSerTrue);
    }
}
