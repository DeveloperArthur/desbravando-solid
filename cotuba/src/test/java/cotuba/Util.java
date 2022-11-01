package cotuba;

import cotuba.application.ParametrosCotuba;
import cotuba.domain.FormatoEbook;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Util {
    public static String DIRETORIO_DOS_MD = "./livro-exemplo";

    public static ParametrosCotubaTest getParametrosCotubaMock(){
        return new ParametrosCotubaTest();
    }

    public static class ParametrosCotubaTest implements ParametrosCotuba {
        @Override
        public Path getDiretorioDosMD() {
            return Paths.get(DIRETORIO_DOS_MD);
        }

        @Override
        public FormatoEbook getFormato() {
            return FormatoEbook.PDF;
        }

        @Override
        public Path getArquivoDeSaida() {
            return Paths.get("book." + FormatoEbook.PDF.name().toLowerCase());
        }
    }
}
