package cotuba.epub;

import cotuba.domain.Ebook;

//TODO: E se utilizassemos o pattern bridge?
public interface GeradorEPUB {
    void gera(Ebook ebook);

    static GeradorEPUB cria(){
        return new GeradorEPUBComEpublib();
    }
}
