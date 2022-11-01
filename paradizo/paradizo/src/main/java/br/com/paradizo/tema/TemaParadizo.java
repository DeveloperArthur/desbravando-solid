package br.com.paradizo.tema;

import cotuba.domain.Ebook;
import cotuba.plugin.AoRenderizarHTML;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

//SERVICE PROVIDER
public class TemaParadizo implements AoRenderizarHTML {

    private String cssDoTema(){
        return FileUtils.getResourceContents("/tema.css");
    }

    private String aplicaTema(String html){
        Document doc = Jsoup.parse(html);
        String css = cssDoTema();
        doc.select("head")
                .append("<style>"+css+"</style>");
        return doc.html();
    }

    @Override
    public String aposRenderizacao(String html) {
        String htmlComTema = aplicaTema(html);
        return htmlComTema;
    }
}
