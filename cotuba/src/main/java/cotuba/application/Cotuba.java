package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.domain.FormatoEbook;
import cotuba.md.RenderizadorMDParaHTML;
import cotuba.plugin.AoFinalizarGeracao;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {
    private GeradorEbook geradorEbook;

    public void executa(ParametrosCotuba parametros){
        FormatoEbook formato = parametros.getFormato();
        Path arquivoDeSaida = parametros.getArquivoDeSaida();
        Path diretorioDosMD = parametros.getDiretorioDosMD();

        RenderizadorMDParaHTML renderizador = new RenderizadorMDParaHTML();
        List<Capitulo> capitulos = renderizador.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook(formato, arquivoDeSaida, capitulos);

        GeradorEbook geradorEbook = GeradorEbook.cria(formato);
        geradorEbook.gera(ebook);
        AoFinalizarGeracao.gerou(ebook);
    }
}
