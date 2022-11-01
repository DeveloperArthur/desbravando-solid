package br.com.cognito.estatisticas;

import com.google.common.collect.*;
import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.plugin.AoFinalizarGeracao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.text.Normalizer;

public class CalculadoraDeEstatisticas implements AoFinalizarGeracao {

    @Override
    public void aposGeracao(Ebook ebook) {
        Multiset<String> multiset = HashMultiset.create();

        for (Capitulo capitulo : ebook.capitulos()){
            String html = capitulo.conteudoHTML();
            Document doc = Jsoup.parse(html);
            String textoDoCapitulo = doc.body().text();

            String textoDoCapituloSemPontuacao = textoDoCapitulo.replaceAll("\\p{Punct}", " ");

            String decomposta = Normalizer.normalize(textoDoCapituloSemPontuacao, Normalizer.Form.NFD);
            String textoDoCapituloSemAcentos = decomposta.replaceAll("[^\\p{ASCII}]", "");

            String[] palavras = textoDoCapituloSemAcentos.split("\\s+");
            for (String palavra : palavras){
                String emMaiusculas = palavra.toUpperCase();
                multiset.add(emMaiusculas);
            }
        }

        multiset.stream().distinct().forEach(palavra -> { System.out.println(palavra + ": " + multiset.count(palavra)); });
    }
}
