package cotuba.plugin.integration;

import cotuba.application.Cotuba;
import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.plugin.AoFinalizarGeracao;
import cotuba.plugin.AoRenderizarHTML;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static cotuba.Util.getParametrosCotubaMock;

public class PluginTest {
    public static Boolean PLUGIN_AoFinalizarGeracao_FOI_INVOCADO = false;
    public static Boolean PLUGIN_AoRenderizarHTML_FOI_INVOCADO = false;

    @Test
    public void deveExecutarPluginsComSucesso(){
        Cotuba cotuba = new Cotuba();
        cotuba.executa(getParametrosCotubaMock());

        Assertions.assertTrue(PLUGIN_AoFinalizarGeracao_FOI_INVOCADO);
        Assertions.assertTrue(PLUGIN_AoRenderizarHTML_FOI_INVOCADO);
    }

    public static class PluginTestAoFinalizarGeracao implements AoFinalizarGeracao {
        @Override
        public void aposGeracao(Ebook ebook) {
            PLUGIN_AoFinalizarGeracao_FOI_INVOCADO = true;
            for (Capitulo capitulo : ebook.capitulos()){
                System.out.println(capitulo.titulo());
            }
        }
    }

    public static class PluginTestAoRenderizarHTML implements AoRenderizarHTML {
        @Override
        public String aposRenderizacao(String html) {
            PLUGIN_AoRenderizarHTML_FOI_INVOCADO = true;
            return html;
        }
    }
}