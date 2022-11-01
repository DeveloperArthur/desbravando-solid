package cotuba.cli;

import cotuba.application.Cotuba;

//View
public class Main {
    public static void main(String[] args) {
        boolean modoVerboso = false;

        try {
            var opcoesCLI = montaParametrosComArgumentosRecebidos(args);
            modoVerboso = opcoesCLI.isModoVerboso();

            Cotuba cotuba = new Cotuba();
            cotuba.executa(opcoesCLI);

            System.out.println("Arquivo gerado com sucesso: " + opcoesCLI.getArquivoDeSaida());
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
            if (modoVerboso) {
                ex.printStackTrace();
            }
            throw new IllegalStateException("erro");
        }
    }

    public static LeitorOpcoesCLI montaParametrosComArgumentosRecebidos(String[] args){
        return new LeitorOpcoesCLI(args);
    }
}
