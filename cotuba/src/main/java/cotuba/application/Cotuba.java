package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.domain.FormatoEbook;
import cotuba.md.RenderizadorMDParaHTML;
import cotuba.plugin.Plugin;

import java.nio.file.Path;
import java.util.List;

//TODO: E SE FUTURAMENTE O CLIENTE QUISER QUE O COTUBA CONVERTA HTML PARA EPUB?
// NOSSO CODIGO VAI QUEBRAR... PQ LOGO NO MAIN ESTAMOS CONVERTENDO MD PRA HTML
// e nessa funcionalidade nova nao teremos md
//TODO: OUTRA COISA É SE TIVERMOS UMA IMPLEMENTACAO QUE CONVERTE DE MD PRA PDF DIRETO
// nao faz sentido essa implementacao receber os capitulos com conteudo html

public class Cotuba {
    private GeradorEbook geradorEbook;

    public void executa(ParametrosCotuba parametros){
        FormatoEbook formato = parametros.getFormato();
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
        Plugin.gerou(ebook);
    }
}
