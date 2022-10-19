package cotuba.web.application;

import cotuba.application.Cotuba;
import cotuba.application.ParametrosCotuba;
import cotuba.domain.FormatoEbook;
import cotuba.web.domain.Capitulo;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Service
public class GeracaoDeLivros {
    public Path geraLivros(List<Capitulo> capitulos, FormatoEbook formato){
        MDsDoBandoDeDados mDsDoBandoDeDados = new MDsDoBandoDeDados(capitulos);
        Cotuba cotuba = new Cotuba();
        ParametrosCotuba parametros = new ParametrosCotubaWeb(mDsDoBandoDeDados, formato);
        cotuba.executa(parametros);
        return parametros.getArquivoDeSaida();
    }
}
