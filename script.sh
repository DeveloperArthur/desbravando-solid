#manualmente gerar jar do tema-paradizo e do cotuba
#excluir ebooks, libs e .sh do cotuba

echo 'deszipando a pasta que contem JAR do cotuba'
cd /Users/arthurdossantosalmeida/projetos/solid-na-pratica/cotuba
unzip -o target/cotuba-*-distribution.zip -d /Users/arthurdossantosalmeida/projetos/solid-na-pratica

echo 'copiando JAR do tema-paradizo para a pasta libs do cotuba'
cd /Users/arthurdossantosalmeida/projetos/paradizo/paradizo
cp target/tema-paradizo-0.0.1-SNAPSHOT.jar /Users/arthurdossantosalmeida/projetos/solid-na-pratica/libs

echo 'copiando JAR do cognito para a pasta libs do cotuba'
cd /Users/arthurdossantosalmeida/projetos/cognito/estatisticas-ebook
cp target/estatisticas-ebook-0.0.1-SNAPSHOT.jar /Users/arthurdossantosalmeida/projetos/solid-na-pratica/libs

echo 'copiando dependencia do Jsoup para a pasta libs do cotuba'
cp ~/.m2/repository/org/jsoup/jsoup/1.11.2/jsoup-1.11.2.jar /Users/arthurdossantosalmeida/projetos/solid-na-pratica/libs

echo 'copiando dependencia do Guava para a pasta libs do cotuba'
cp ~/.m2/repository/com/google/guava/guava/31.0.1-jre/guava-31.0.1-jre.jar /Users/arthurdossantosalmeida/projetos/solid-na-pratica/libs

echo 'executando cotuba'
cd /Users/arthurdossantosalmeida/projetos/solid-na-pratica
./cotuba.sh -d ./cotuba/livro-exemplo -f pdf
