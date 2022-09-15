package cotuba.domain;

import cotuba.application.GeradorEbook;
import cotuba.epub.GeradorEPUB;
import cotuba.pdf.GeradorPDF;

public enum FormatoEbook {
    PDF(new GeradorPDF()),
    EPUB(new GeradorEPUB());

    private GeradorEbook geradorEbook;

    FormatoEbook(GeradorEbook geradorEbook) {
        this.geradorEbook = geradorEbook;
    }

    public GeradorEbook getGeradorEbook() {
        return geradorEbook;
    }
}
