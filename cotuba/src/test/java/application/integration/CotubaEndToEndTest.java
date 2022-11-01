package application.integration;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import cotuba.application.Cotuba;
import cotuba.application.ParametrosCotuba;
import cotuba.domain.FormatoEbook;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CotubaEndToEndTest {

    @Test
    public void deveGerarPDFComBaseNoMDDeTeste() throws IOException {
        //Deletando book.pdf
        File file = new File("./book.pdf");
        if (file.delete()){}

        Cotuba cotuba = new Cotuba();
        cotuba.executa(new ParametrosCotubaTest());

        Assert.assertTrue(file.exists());
        Assert.assertEquals("book.pdf", file.getName());
        Assert.assertEquals(5, numeroDePaginasDoPDF(file));
    }
    public static class ParametrosCotubaTest implements ParametrosCotuba {
        @Override
        public Path getDiretorioDosMD() {
            return Paths.get("./livro-exemplo");
        }

        @Override
        public FormatoEbook getFormato() {
            return FormatoEbook.PDF;
        }

        @Override
        public Path getArquivoDeSaida() {
            return Paths.get("book." + FormatoEbook.PDF.name().toLowerCase());
        }
    }
    private int numeroDePaginasDoPDF(File file) throws IOException {
        return new PdfDocument(new PdfReader(file)).getNumberOfPages();
    }
}
