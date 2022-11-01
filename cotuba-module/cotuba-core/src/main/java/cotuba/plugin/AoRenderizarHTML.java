package cotuba.plugin;

import java.util.ServiceLoader;

//SERVICE PROVIDER INTERFACE
public interface AoRenderizarHTML {
    String aposRenderizacao(String html);

    static String renderizou(String html){
        String htmlModificado = html;
        for (AoRenderizarHTML plugin: ServiceLoader.load(AoRenderizarHTML.class)) {
            htmlModificado = plugin.aposRenderizacao(html);
        }
        return htmlModificado;
    }
}
