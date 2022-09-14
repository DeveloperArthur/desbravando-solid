package cotuba.application;

import cotuba.domain.Ebook;

//TODO: E se utilizassemos o pattern bridge?
public interface GeradorEPUB {
    void gera(Ebook ebook);

}
