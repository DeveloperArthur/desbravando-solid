package cotuba.application;

import cotuba.domain.Ebook;
import cotuba.epub.GeradorEPUB;
import cotuba.pdf.GeradorPDF;

public interface GeradorEbook {
    void gera(Ebook ebook);

    static GeradorEbook cria(String formato){
        GeradorEbook geradorEbook;
        if ("pdf".equals(formato)) {
            geradorEbook = new GeradorPDF();
        } else if ("epub".equals(formato)) {
            geradorEbook = new GeradorEPUB();
        } else {
            throw new IllegalArgumentException("Formato do ebook inválido: " + formato);
        }
        return geradorEbook;
    }
}
