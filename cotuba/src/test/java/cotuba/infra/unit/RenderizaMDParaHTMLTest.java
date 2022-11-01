package cotuba.infra.unit;

import cotuba.domain.Capitulo;
import cotuba.md.RenderizadorMDParaHTML;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RenderizaMDParaHTMLTest {

    @Test
    public void deveRetornarCorretamenteListaDeCapitulos(){
        List<Capitulo> capitulos = new RenderizadorMDParaHTML().renderiza(Paths.get("./livro-exemplo"));

        String conteudoHTMLDoPrimeiroCapitulo = "<h1>Para que serve OO?</h1>\n" +
                "<h2>Modelagem e Dependências</h2>\n" +
                "<p>Você aprendeu Orientação a Objetos.</p>\n" +
                "<p>Entendeu classes, objetos, atributos, métodos, herança, polimorfismo, interfaces.</p>\n" +
                "<p>Aprendeu algumas soluções comuns para problemas recorrentes estudando alguns <em>Design Patterns</em>.</p>\n" +
                "<p>Mas como e quando usar OO?</p>\n" +
                "<p>Sem dúvida, a resposta tem a ver com organizar e facilitar a mudança do código no médio/longo prazo.</p>\n" +
                "<p>Mas, para Martin (2005), há duas abordagens complementares no uso de OO:</p>\n" +
                "<ul>\n" +
                "<li>criar um <strong>modelo</strong> do mundo real</li>\n" +
                "<li>gerenciar as <strong>dependências</strong> do seu código</li>\n" +
                "</ul>\n" +
                "<blockquote>\n" +
                "<p><em>These principles expose the dependency management aspects of OOD as opposed to the conceptualization and modeling aspects. This is not to say that OO is a poor tool for conceptualization of the problem space, or that it is not a good venue for creating models. Certainly many people get value out of these aspects of OO. The principles, however, focus very tightly on dependency management.</em></p>\n" +
                "<p>(MARTIN, 2005)</p>\n" +
                "</blockquote>\n" +
                "<p>OO é uma ótima ferramenta para representar, em código, os conceitos do problema que estamos resolvendo. É importante selecionar entidades de negócio e criar um modelo de domínio que as &quot;traduza&quot; para uma linguagem de programação.</p>\n" +
                "<p>Um bom <em>domain model</em> é o foco de metodologias e técnicas como:</p>\n" +
                "<ul>\n" +
                "<li>Feature-Driven Development</li>\n" +
                "<li>Card-Responsibility-Collaboration (CRC)</li>\n" +
                "<li><strong>Domain-Driven Design</strong></li>\n" +
                "</ul>\n" +
                "<p>Mas OO também é uma ótima maneira de evitar código &quot;amarrado&quot; demais, controlando as dependências e minimizando o acoplamento. Um código OO bem modelado, com as dependências administradas com cuidado, leva a mais flexibilidade, robustez e possibilidade de reuso.</p>\n" +
                "<p>Dependências bem gerenciadas são o foco de técnicas como:</p>\n" +
                "<ul>\n" +
                "<li>General Responsibility Assignment So ware Principles (GRASP)</li>\n" +
                "<li>Design Patterns</li>\n" +
                "<li>Dependency Injection</li>\n" +
                "<li><strong>Princípios SOLID</strong>.</li>\n" +
                "</ul>\n" +
                "<p>Nosso foco nesse curso é aprofundar no estudo dos princípios SOLID, usando OO como uma maneira de gerenciar as dependências do nosso código.</p>\n";


        String conteudoHTMLDoSegundoCapitulo = "<h1>S.O.L.I.D.</h1>\n" +
                "<h2>Os dez (ou onze) mandamentos de Orientação a Objetos</h2>\n" +
                "<p>Robert Cecil Martin, o famoso Uncle Bob, listou os seus 10 (na verdade, 11) mandamentos da Programação Orientada a Objetos, no grupo Usenet <em>comp.object</em> (MARTIN, 1995):</p>\n" +
                "<blockquote>\n" +
                "<p><em>If I had to write commandments, these would be candidates.</em></p>\n" +
                "<p>1.<em>Software entities (classes, modules, etc) should be open for extension, but closed for modification.  (The open/closed principle -- Bertrand Meyer)</em></p>\n" +
                "<p>2.<em>Derived classes must usable through the base class interface without the need for the user to know the difference.  (The Liskov Substitution Principle)</em></p>\n" +
                "<p>3.<em>Details should depend upon abstractions.  Abstractions should not depend upon details.  (Principle of Dependency Inversion)</em></p>\n" +
                "<p>4.<em>The granule of reuse is the same as the granule of release. Only components that are released through a tracking system can be effectively reused.</em></p>\n" +
                "<p><em>5.Classes within a released component should share common closure. That is, if one needs to be changed, they all are likely to need to be changed.  What affects one, affects all.</em></p>\n" +
                "<p>6.<em>Classes within a released component should be reused together. That is, it is impossible to separate the components from each other in order to reuse less than the total.</em></p>\n" +
                "<p>7.<em>The dependency structure for released components must be a DAG. There can be no cycles.</em></p>\n" +
                "<p>8.<em>Dependencies between released components must run in the direction of stability. The dependee must be more stable than the depender.</em></p>\n" +
                "<p>9.<em>The more stable a released component is, the more it must consist of abstract classes. A completely stable component should consist of nothing but abstract classes.</em></p>\n" +
                "<p>10.<em>Where possible, use proven patterns to solve design problems.</em></p>\n" +
                "<p>11.<em>When crossing between two different paradigms, build an interface layer that separates the two. Don't pollute one side with the paradigm of the other.</em></p>\n" +
                "</blockquote>\n" +
                "<h2>Os Princípios de Orientação a Objetos</h2>\n" +
                "<p>Em 1996, fez uma série de artigos na revista <em>C++ Report</em> sobre o que chamou de <strong>princípios</strong>:</p>\n" +
                "<ul>\n" +
                "<li><em>Open-Closed Principle</em> (MARTIN, 1996a)</li>\n" +
                "<li><em>Liskov Substitution Principle</em> (MARTIN, 1996b)</li>\n" +
                "<li><em>Dependency Inversion Principle</em> (MARTIN, 1996c)</li>\n" +
                "<li><em>Interface Segregation Principle</em> (MARTIN, 1996d)</li>\n" +
                "<li><em>Granularity</em> (MARTIN, 1996e)</li>\n" +
                "<li><em>Stability</em> (MARTIN, 1997)</li>\n" +
                "</ul>\n" +
                "<p>O foco desses princípios é nas dependências entre objetos e componentes/módulos.</p>\n" +
                "<p>Em (Martin, 2002), Uncle Bob descreve o <em>Single Responsibility Principle</em>, reordenando os princípios e cunhando o acrônimo <strong>S.O.L.I.D</strong>.</p>\n" +
                "<p>Uma versão atualizada desses princípios foi lançada em C# (MARTIN, 2006).</p>\n" +
                "<p>Uncle Bob indica (MARTIN, 2009) que os princípios não são <em>check lists</em>, nem leis ou regras. São bons conselhos vindos do senso comum de gente experiente, coletados em projetos reais ao longo do tempo. Não significa que sempre funcionam ou que sempre devem ser seguidos.</p>\n" +
                "<h2>Princípios de classes</h2>\n" +
                "<p>Os 5 princípios S.O.L.I.D. são focados em modelagem de classes:</p>\n" +
                "<ul>\n" +
                "<li><em><strong>S</strong>ingle Responsibility Principle</em>: <strong>Uma classe deve ter um, e apenas um, motivo para ser mudada</strong>.</li>\n" +
                "<li><em><strong>O</strong>pen/Closed Principle</em>: <strong>Deve ser possível extender o comportamento de uma classe sem modificá-la</strong>.</li>\n" +
                "<li><em><strong>L</strong>iskov Substitution Principle</em>: <strong>Classes derivadas devem ser substituíveis pelas classes base</strong>.</li>\n" +
                "<li><em><strong>I</strong>nterface Segregation Principle</em>: <strong>Uma classe deve ter um, e apenas um, motivo para ser mudada</strong>.</li>\n" +
                "<li><em><strong>D</strong>ependency Inversion Principle</em>: <strong>Dependa de abstrações, não de classes concretas</strong>.</li>\n" +
                "</ul>\n";

        String conteudoHTMLDoTerceiroCapitulo = "<h1>Referências</h1>\n" +
                "<p>MARTIN, Robert Cecil. <em>The Principles of OOD</em>. 2005. Em: <a href=\"http://butunclebob.com/ArticleS.UncleBob.PrinciplesOfOod\">http://butunclebob.com/ArticleS.UncleBob.PrinciplesOfOod</a>.</p>\n" +
                "<p>MARTIN, Robert Cecil. <em>The Ten Commandments of OO Programming</em>. 1995. Em: <a href=\"https://groups.google.com/forum/?hl=en#!topic/comp.object/WICPDcXAMG8\">https://groups.google.com/forum/?hl=en#!topic/comp.object/WICPDcXAMG8</a>.</p>\n" +
                "<p>MARTIN, Robert Cecil. <em>The Open-Closed Principle</em>. The C++ Report, Jan. 1996a. Em: <a href=\"https://drive.google.com/file/d/0BwhCYaYDn8EgN2M5MTkwM2EtNWFkZC00ZTI3LWFjZTUtNTFhZGZiYmUzODc1/view\">https://drive.google.com/file/d/0BwhCYaYDn8EgN2M5MTkwM2EtNWFkZC00ZTI3LWFjZTUtNTFhZGZiYmUzODc1/view</a>.</p>\n" +
                "<p>MARTIN, Robert Cecil. <em>The Liskov Substitution Principle</em>. The C++ Report, Mar. 1996b. Em: <a href=\"https://drive.google.com/file/d/0BwhCYaYDn8EgNzAzZjA5ZmItNjU3NS00MzQ5LTkwYjMtMDJhNDU5ZTM0MTlh/view\">https://drive.google.com/file/d/0BwhCYaYDn8EgNzAzZjA5ZmItNjU3NS00MzQ5LTkwYjMtMDJhNDU5ZTM0MTlh/view</a>.</p>\n" +
                "<p>MARTIN, Robert Cecil. <em>The Dependency Inversion Principle</em>. The C++ Report, Jun. 1996c. Em: <a href=\"https://drive.google.com/file/d/0BwhCYaYDn8EgMjdlMWIzNGUtZTQ0NC00ZjQ5LTkwYzQtZjRhMDRlNTQ3ZGMz/view\">https://drive.google.com/file/d/0BwhCYaYDn8EgMjdlMWIzNGUtZTQ0NC00ZjQ5LTkwYzQtZjRhMDRlNTQ3ZGMz/view</a>.</p>\n" +
                "<p>MARTIN, Robert Cecil. <em>The Interface Segregation Principle</em>. The C++ Report, Aug. 1996d. Em: <a href=\"https://drive.google.com/file/d/0BwhCYaYDn8EgOTViYjJhYzMtMzYxMC00MzFjLWJjMzYtOGJiMDc5N2JkYmJi/view\">https://drive.google.com/file/d/0BwhCYaYDn8EgOTViYjJhYzMtMzYxMC00MzFjLWJjMzYtOGJiMDc5N2JkYmJi/view</a>.</p>\n" +
                "<p>MARTIN, Robert Cecil. <em>Granularity</em>. The C++ Report, Nov. 1996e. Em: <a href=\"https://drive.google.com/file/d/0BwhCYaYDn8EgOGM2ZGFhNmYtNmE4ZS00OGY5LWFkZTYtMjE0ZGNjODQ0MjEx/view\">https://drive.google.com/file/d/0BwhCYaYDn8EgOGM2ZGFhNmYtNmE4ZS00OGY5LWFkZTYtMjE0ZGNjODQ0MjEx/view</a>.</p>\n" +
                "<p>MARTIN, Robert Cecil. <em>Stability</em>. The C++ Report, Jan. 1997. Em: <a href=\"https://drive.google.com/file/d/0BwhCYaYDn8EgZjI3OTU4ZTAtYmM4Mi00MWMyLTgxN2YtMzk5YTY1NTViNTBh/view\">https://drive.google.com/file/d/0BwhCYaYDn8EgZjI3OTU4ZTAtYmM4Mi00MWMyLTgxN2YtMzk5YTY1NTViNTBh/view</a>.</p>\n" +
                "<p>MARTIN, Robert Cecil. <em>Agile Software Development: Principles, Patterns, and Practices</em>. Prentice Hall, 2002. 529 p. Em: <a href=\"https://www.amazon.com.br/Software-Development-Principles-Patterns-Practices/dp/0135974445\">https://www.amazon.com.br/Software-Development-Principles-Patterns-Practices/dp/0135974445</a>.</p>\n" +
                "<p>MARTIN, Robert Cecil. <em>Agile Principles, Patterns, and Practices in C#</em>. Prentice Hall, 2006. 732 p. Em: <a href=\"https://www.amazon.com.br/Agile-Principles-Patterns-Practices-C/dp/0131857258\">https://www.amazon.com.br/Agile-Principles-Patterns-Practices-C/dp/0131857258</a>.</p>\n" +
                "<p>MARTIN, Robert Cecil. <em>Getting a SOLID start.</em>. 2009. Em: <a href=\"https://sites.google.com/site/unclebobconsultingllc/getting-a-solid-start\">https://sites.google.com/site/unclebobconsultingllc/getting-a-solid-start</a>.</p>\n";

        assertEquals("Para que serve OO?", capitulos.get(0).titulo());
        assertEquals(conteudoHTMLDoPrimeiroCapitulo, capitulos.get(0).conteudoHTML());

        assertEquals("S.O.L.I.D.", capitulos.get(1).titulo());
        assertEquals(conteudoHTMLDoSegundoCapitulo, capitulos.get(1).conteudoHTML());

        assertEquals("Referências", capitulos.get(2).titulo());
        assertEquals(conteudoHTMLDoTerceiroCapitulo, capitulos.get(2).conteudoHTML());
    }
}
