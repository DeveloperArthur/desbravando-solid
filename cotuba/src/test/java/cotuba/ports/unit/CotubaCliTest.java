package cotuba.ports.integration;

import cotuba.application.Cotuba;
import cotuba.application.ParametrosCotuba;
import cotuba.cli.LeitorOpcoesCLI;
import cotuba.cli.Main;
import cotuba.domain.FormatoEbook;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CotubaCliTest {
    //chamar o main, passando os args, n deixa chamar o cotuba , conferir se os dados foram passados corretamente

    @Test
    public void deveReceberArgumentosEChamarCotubaPassandoParametrosCorretamente(){
        String[] argumentos = new String[4];
        argumentos[0] = "-d";
        argumentos[1] = "./livro-exemplo";
        argumentos[2] = "-f";
        argumentos[3] = "epub";

        Cotuba cotuba = mock(Cotuba.class);
        //ArgumentCaptor<ParametrosCotuba> valorCapturado = ArgumentCaptor.forClass(ParametrosCotuba.class);
        //doNothing().when(cotuba).executa(valorCapturado.capture());

        ParametrosCotuba parametrosCotuba = new LeitorOpcoesCLI(argumentos);
        //doCallRealMethod().when(cotuba).executa(parametrosCotuba);

        Mockito.doCallRealMethod().when(cotuba).executa(parametrosCotuba);
        Main.main(argumentos);

        //doAnswer(new Answer() {
            //@Override
            //public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
            //    System.out.println("::::::");
            //    Main.main(argumentos);
            //    return null;
            //}
        //}).when(cotuba).executa(parametrosCotuba);

        //System.out.println(valorCapturado.capture());

        //assertEquals(FormatoEbook.EPUB, valorCapturado.capture().getFormato());
        //assertEquals(Paths.get("./livro-exemplo"), valorCapturado.capture().getDiretorioDosMD());
        //assertEquals(Paths.get("book.epub"), valorCapturado.capture().getArquivoDeSaida());


        //doAnswer((i) -> {
        //    assertEquals(FormatoEbook.EPUB, valorCapturado.capture().getFormato());
        //    assertEquals(Paths.get("./livro-exemplo"), valorCapturado.capture().getDiretorioDosMD());
        //    assertEquals(Paths.get("book.epub"), valorCapturado.capture().getArquivoDeSaida());
        //    return null;
        //}).when(cotuba).executa(any());


    }

    @Test
    public void naoDeveGerarEbookCasoCliNaoPasseArgs(){
        assertThrows(IllegalStateException.class, () -> {
            Main.main(null);
        });
    }

    @Test
    void test_mockito_void() {
        Employee emp = mock(Employee.class);

        doAnswer((i) -> {
            System.out.println(i);
            System.out.println("Employee setName Argument = " + i.getArgument(0));
            assertEquals("Pankaj", i.getArgument(0));
            return null;
        }).doCallRealMethod().when(emp).setName(anyString());

        emp.setName("Pankaj");
        assertEquals("Pankaj", emp.getName());
    }

    private class Employee {
        private String name;

        public void setName(String name) {
            System.out.println("nem passou");
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}