package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.md.RenderizadorMDParaHTML;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {
    private GeradorEbook geradorEbook;

    public void executa(ParametrosCotuba parametros){
        String formato = parametros.getFormato();
        Path arquivoDeSaida = parametros.getArquivoDeSaida();
        Path diretorioDosMD = parametros.getDiretorioDosMD();

        RenderizadorMDParaHTML renderizador = new RenderizadorMDParaHTML();
        List<Capitulo> capitulos = renderizador.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setCapitulos(capitulos);
        ebook.setArquivoDeSaida(arquivoDeSaida);

        GeradorEbook geradorEbook = GeradorEbook.cria(formato);
        geradorEbook.gera(ebook);
    }
}
