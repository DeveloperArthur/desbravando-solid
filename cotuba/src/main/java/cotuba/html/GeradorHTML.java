package cotuba.html;

import cotuba.application.GeradorEbook;
import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Normalizer;

public class GeradorHTML implements GeradorEbook {

    @Override
    public void gera(Ebook ebook) {
        Path arquivoDeSaida = ebook.arquivoDeSaida();
        try {
            Path diretorioDoHTML = Files.createDirectory(arquivoDeSaida);
            int i = 1;
            for (Capitulo capitulo: ebook.capitulos()) {
                String nomeDoArquivoHTMLDoCapitulo = obtemNomeDoArquivoHTMLDoCapitulo(i, capitulo);
                Path arquivoHTMLDoCapitulo = diretorioDoHTML.resolve(nomeDoArquivoHTMLDoCapitulo);
                String html = """
                    <!DOCTYPE html>
                    <html lang="pt-BR">
                        <head>
                            <meta charset="UTF-8">
                            <title>%s</title>
                        </head>
                        <body>
                            %s
                        </body>
                    </html>
                    """.formatted(capitulo.titulo(), capitulo.conteudoHTML());
                Files.writeString(arquivoHTMLDoCapitulo, html, StandardCharsets.UTF_8);
                i++;
            }
        } catch (IOException ex) {
            throw new IllegalArgumentException("Erro ao criar HTML: "+arquivoDeSaida.toAbsolutePath(), ex);
        }
    }

    private String obtemNomeDoArquivoHTMLDoCapitulo(int i, Capitulo capitulo) {
        String nomeArquivoHTMLCapitulo = i + "-" + removeAcentos(capitulo.titulo().toLowerCase())
                .replaceAll("[^\\w]", "")
                + ".html";
        return nomeArquivoHTMLCapitulo;
    }

    //Será que remover acentos é responsabilidade do GeradorHTML?
    private String removeAcentos(String texto) {
        return Normalizer
                .normalize(texto, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]" ,"");
    }
}
