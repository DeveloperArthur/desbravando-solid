package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.epub.GeradorEPUBComEpublib;
import cotuba.pdf.GeradorPDFImplComIText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.List;

@Component
public class Cotuba {
    private GeradorEbook geradorEbook;
    private final RenderizadorMDParaHTML renderizador;

    public Cotuba(RenderizadorMDParaHTML renderizador) {
        this.renderizador = renderizador;
    }

    public void executa(ParametrosCotuba parametros){
        String formato = parametros.getFormato();
        Path arquivoDeSaida = parametros.getArquivoDeSaida();
        Path diretorioDosMD = parametros.getDiretorioDosMD();

        List<Capitulo> capitulos = renderizador.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setCapitulos(capitulos);
        ebook.setArquivoDeSaida(arquivoDeSaida);

        if ("pdf".equals(formato)) {
            geradorEbook = new GeradorPDFImplComIText();
        } else if ("epub".equals(formato)) {
            geradorEbook = new GeradorEPUBComEpublib();
        } else {
            throw new IllegalArgumentException("Formato do ebook inválido: " + formato);
        }

        geradorEbook.gera(ebook);
    }
}
