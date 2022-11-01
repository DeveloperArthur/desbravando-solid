package cotuba.tests.integration;

import cotuba.domain.Ebook;
import cotuba.plugin.AoFinalizarGeracao;
import cotuba.plugin.AoRenderizarHTML;

public class PluginTest {
    //criar um plugin, ver se vai - como testar service loader api?

    public void deveExecutarPluginAoFinalizarGeracao(){

    }

    public void deveExecutarPluginAoRenderizarHTML(){

    }

    public class PluginTestAoFinalizarGeracao implements AoFinalizarGeracao {

        @Override
        public void aposGeracao(Ebook ebook) {

        }
    }

    public class PluginTestAoRenderizarHTML implements AoRenderizarHTML {

        @Override
        public String aposRenderizacao(String html) {
            return null;
        }
    }
}