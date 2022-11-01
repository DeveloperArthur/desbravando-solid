package cotuba.application.integration;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import cotuba.application.Cotuba;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static cotuba.Util.getParametrosCotubaMock;
import static org.junit.jupiter.api.Assertions.*;

public class CotubaApplicationToAdapterTest {

    @Test
    public void deveGerarPDFComBaseNoMDDeTeste() throws IOException {
        //Deletando book.pdf
        File file = new File("./book.pdf");
        if (file.delete()){}

        Cotuba cotuba = new Cotuba();
        cotuba.executa(getParametrosCotubaMock());

        assertTrue(file.exists());
        assertEquals("book.pdf", file.getName());
        assertEquals(5, numeroDePaginasDoPDF(file));
    }


    private int numeroDePaginasDoPDF(File file) throws IOException {
        return new PdfDocument(new PdfReader(file)).getNumberOfPages();
    }
}
