package cotuba.cli;

import cotuba.application.ParametrosCotuba;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

//classe responsável por extrair as opções de linha de comando
class LeitorOpcoesCLI implements ParametrosCotuba {
    private Path diretorioDosMD;
    private String formato;
    private Path arquivoDeSaida;
    private boolean modoVerboso = false;

    LeitorOpcoesCLI(String[] args) {
        Options options = criaOpcoes();
        CommandLine cmd = parseDosArgumentos(args, options);
        trataDiretorioDosMD(cmd);
        trataFormato(cmd);
        trataArquivoDeSaida(cmd);
        trataModoVerboso(cmd);
    }

    private Options criaOpcoes() {
        var options = new Options();

        var opcaoDeDiretorioDosMD = new Option("d", "dir", true,
                "Diretório que contém os arquivos md. Default: diretório atual.");
        options.addOption(opcaoDeDiretorioDosMD);

        var opcaoDeFormatoDoEbook = new Option("f", "format", true,
                "Formato de saída do ebook. Pode ser: pdf ou epub. Default: pdf");
        options.addOption(opcaoDeFormatoDoEbook);

        var opcaoDeArquivoDeSaida = new Option("o", "output", true,
                "Arquivo de saída do ebook. Default: book.{formato}.");
        options.addOption(opcaoDeArquivoDeSaida);

        var opcaoModoVerboso = new Option("v", "verbose", false,
                "Habilita modo verboso.");
        options.addOption(opcaoModoVerboso);

        return options;
    }

    private CommandLine parseDosArgumentos(String[] args, Options options) {
        try {
            CommandLineParser cmdParser = new DefaultParser();
            return cmdParser.parse(options, args);
        } catch (ParseException e) {
            var ajuda = new HelpFormatter();
            ajuda.printHelp("cotuba", options);
            throw new IllegalArgumentException("Opção inválida", e);
        }
    }

    private void trataDiretorioDosMD(CommandLine cmd) {
        String nomeDoDiretorioDosMD = cmd.getOptionValue("dir");

        if (nomeDoDiretorioDosMD != null) {
            diretorioDosMD = Paths.get(nomeDoDiretorioDosMD);
            if (!Files.isDirectory(diretorioDosMD)) {
                throw new IllegalArgumentException(nomeDoDiretorioDosMD + " não é um diretório.");
            }
        } else {
            Path diretorioAtual = Paths.get("");
            diretorioDosMD = diretorioAtual;
        }
    }

    private void trataFormato(CommandLine cmd) {
        String nomeDoFormatoDoEbook = cmd.getOptionValue("format");

        if (nomeDoFormatoDoEbook != null) {
            formato = nomeDoFormatoDoEbook.toLowerCase();
        } else {
            formato = "pdf";
        }
    }

    private void trataArquivoDeSaida(CommandLine cmd) {
        try{
            String nomeDoArquivoDeSaidaDoEbook = cmd.getOptionValue("output");
            if (nomeDoArquivoDeSaidaDoEbook != null) {
                arquivoDeSaida = Paths.get(nomeDoArquivoDeSaidaDoEbook);
            } else {
                arquivoDeSaida = Paths.get("book." + formato.toLowerCase());
            }

            if (Files.isDirectory(arquivoDeSaida)) {
                // deleta arquivos do diretório recursivamente
                Files.walk(arquivoDeSaida).sorted(Comparator.reverseOrder())
                        .map(Path::toFile).forEach(File::delete);
            } else {
                Files.deleteIfExists(arquivoDeSaida);
            }
        } catch (IOException ex){
            throw new IllegalArgumentException(ex);
        }
    }

    private void trataModoVerboso(CommandLine cmd) {
        modoVerboso = cmd.hasOption("verbose");
    }

    @Override
    public Path getDiretorioDosMD() {
        return diretorioDosMD;
    }

    @Override
    public String getFormato() {
        return formato;
    }

    @Override
    public Path getArquivoDeSaida() {
        return arquivoDeSaida;
    }

    public boolean isModoVerboso() {
        return modoVerboso;
    }
}
