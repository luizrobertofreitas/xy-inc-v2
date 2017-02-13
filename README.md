# REST Backend App #

O objetivo desta aplicação é facilitar a vida do desenvolvedor de aplicações Front End/Mobile.

Seguem abaixo algumas considerações para execução da aplicação:

### Tecnologias empregadas ###

* Java 8
* Maven: http://maven.apache.org/download.cgi
* MongoDB 3.2.10: http://www.mongodb.org/downloads
* Spring Boot
* Thymeleaf

### Breve descrição sobre a arquitetura ###

1. MongoDB: O Mongo DB foi escolhido pela sua estrutura de armazenamento atender o requisito de flexibilidade de estrutura de dados (schemaless).

2. Spring Boot: Simplesmente por ser "Spring"!! Ahh... não! Tem motivos! O Core do Spring, por si só, já provê a implementação de todos os conceitos de IoC e Dependency Injection. Entretanto, faz parte do seleto grupo que provê frameworks para acesso a banco de dados NoSQL (Spring Data), REST API Support (Spring REST) e até a implementação da Maturidade 5 do REST (Spring HATEOAS).

3. Maven: Ferramenta de build muito utilizada pelos desenvolvedores ao redor do mundo. Possui um repositório remoto com muitas bibliotecas de inúmeros frameworks, sem contar a facilidade na declaração das dependências dentro do projeto.

4. Thymeleaf: É um mecanismo server-side renderização de páginas através de templates. É algo muito interessante que venho estudando como alternativa ao JSP "puro". Possui muitos recursos facilitados para chamada de métodos, criação de URLs, etc.

### Sobre a aplicação ###

A aplicação possui seguintes endpoins

* GET: http://localhost:8081/v1/{collectionName}
* GET: http://localhost:8081/v1/{collectionName}/{id}
* POST: http://localhost:8081/v1/{collectionName}
* PUT: http://localhost:8081/v1/{collectionName}
* DELETE: http://localhost:8081/v1/{collectionName}/{id}

Observação sobre os campos:

* collectionName: é o nome do modelo definido pelo usuário, ex: "products"
* id: é a identificação do documento inserido na coleção {collectionName} dentro do Mongo DB

A aplicação está preparada para inserir quaisquer coleções e estruturas através da API REST. Isto significa que, se o usuário não incluir a coleção e a estrutura desta coleção através da interface Web, e tentar fazer uma requisição POST na API REST, a coleção será criada e a informação enviada será inserida.

Wow!! Mas se o usuário, sem querer incluir registros numa coleção com nome errado e precisar apagar? Ele poderá utilizar a interface web para listar as coleções e excluir / criar coleções e listar seus documentos. Segue o link:

* User UI: http://localhost:8081/

Acesse a aplicação através do link acima e, ao renderizar a página, basta clicar no link: ***Modelos*** no header da aplicação.


## Passos para executar ##

1. Realize a instalação do MongoDB: http://docs.mongodb.org/manual/installation/

3. Realize a instalação do Maven: http://maven.apache.org/download.cgi

4. Faça o download dos fontes desta aplicação

5. A porta definida do servidor Tomcat embutido é a ***8081***. Caso queira alterar, basta editar o arquivo em: src/main/resources/application.properties e alterar a seguinte chave/valor:

    ```
    server.port = 8081
    ```

6. Para configurar a conexão entre a aplicação e o MongoDB basta editar o arquivo em: src/main/resources/application.properties e alterar os valores (abaixo estão os valores default):

    ```
    spring.data.mongodb.host=localhost
    spring.data.mongodb.port=27017
    spring.data.mongodb.repositories.enabled=true
    spring.data.mongodb.database=xy-inc-v2
    ```

7. Para executar o projeto, basta entrar na pasta do projeto e executar o seguite commando:

    ```
    mvn spring-boot:run
    ```

8. Para acessar a interface Web ou utilizar a API REST, basta utilizar os links mencionados anteriormente.
