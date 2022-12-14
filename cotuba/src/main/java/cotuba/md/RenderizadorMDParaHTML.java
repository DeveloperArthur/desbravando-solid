package cotuba.md;

import cotuba.domain.Capitulo;
import cotuba.domain.builder.CapituloBuilder;
import cotuba.plugin.AoRenderizarHTML;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.List;
import java.util.stream.Stream;

public class RenderizadorMDParaHTML {

    public List<Capitulo> renderiza(Path diretorioDosMD){
        return obtemArquivosMD(diretorioDosMD).stream()
                .map(arquivoMD -> {
                    CapituloBuilder capituloBuilder = new CapituloBuilder();
                    Node document = parseDoMD(arquivoMD, capituloBuilder);
                    renderizaParaHTML(arquivoMD, capituloBuilder, document);
                    Capitulo capitulo = capituloBuilder.constroi();
                    return capitulo;
                }).toList();
    }

    private List<Path> obtemArquivosMD(Path diretorioDosMD) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.md");
        try (Stream<Path> arquivosMD = Files.list(diretorioDosMD)) {
            return arquivosMD
                    .filter(matcher::matches)
                    .sorted()
                    .toList();
        } catch (IOException ex) {
            throw new IllegalStateException("Erro tentando encontrar arquivos .md em " + diretorioDosMD.toAbsolutePath(), ex);
        }
    }

    private Node parseDoMD(Path arquivoMD, CapituloBuilder capituloBuilder) {
        try {
            Parser parser = Parser.builder().build();
            Node document = null;
            document = parser.parseReader(Files.newBufferedReader(arquivoMD));
            document.accept(new DescobridorDeHeadings(capituloBuilder));
            return document;
        } catch (Exception ex) {
            throw new IllegalStateException("Erro ao fazer parse do arquivo " + arquivoMD, ex);
        }
    }

    private void renderizaParaHTML(Path arquivoMD, CapituloBuilder capituloBuilder, Node document) {
        try {
            HtmlRenderer renderer = HtmlRenderer.builder().build();
            String html = renderer.render(document);
            String htmlModificado = AoRenderizarHTML.renderizou(html);
            capituloBuilder.comConteudoHTML(htmlModificado);
        } catch (Exception ex) {
            throw new IllegalStateException("Erro ao renderizar para HTML o arquivo " + arquivoMD, ex);
        }
    }

}
