package cotuba.plugin;

import cotuba.domain.Ebook;
import java.util.ServiceLoader;

//SERVICE PROVIDER INTERFACE
public interface AoFinalizarGeracao {
    void aposGeracao(EbookSoParaLeitura ebook);

    static void gerou(EbookSoParaLeitura ebook){
        ServiceLoader.load(AoFinalizarGeracao.class).forEach(plugin -> {
            plugin.aposGeracao(ebook);
        });
    }
}
