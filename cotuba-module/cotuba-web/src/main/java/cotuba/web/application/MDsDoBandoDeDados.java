package cotuba.web.application;

import cotuba.application.RepositorioDeMDs;
import cotuba.web.domain.Capitulo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MDsDoBandoDeDados implements RepositorioDeMDs {
    private final List<Capitulo> capitulos;

    public MDsDoBandoDeDados(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    @Override
    public List<String> obtemMDsDosCapitulos() {
        return capitulos.stream()
                .map(capitulo -> "# " +capitulo.getNome() + "\n"
                    + capitulo.getMarkdown())
                .toList();
    }
}
