# Práticas

* O projeto de referência deve ser clonado do  endereço `https://gitlab.com/vinnyvoffice/jwptf02-week3.git`
* O projeto das práticas deve ser criado localmente
* O projeto das práticas deve configurado para usar o seu repositório remoto no gitlab ou github
* O projeto das práticas deve ser configurado para usar o heroku como ambiente de entrega
* A codificação deve ser feita usando Eclipse JEE ou outra IDE java com suporte a Tomcat 9, Java 8 e Maven 3
* A entrega de cada prática deve ser feita na respectiva atividade do Google Classroom informando a url da tag no repositório remoto git mais o endereço da aplicação no heroku

## prática 09 (31)

* definindo autenticação e autorização com Spring Security

### Itens

*  3101 protegendo acesso à aplicação usando a dependência starter security sem configurações
*  3102 protegendo acesso à aplicação usando arquivo de propriedades
*  3103 protegendo acesso à aplicação usando classe de configuração e repositório em memória
*  3104 protegendo acesso apenas ao endereço /protected usando anotação no respectivo método
*  3105 autorizando acesso aos endereços `/api/curators/*` apenas para usuários com papel curator usando classe de configuração
*  3106 respondendo o id, o nome e os papéis do usuário no endpoint `/api/me`

## prática 10 (32)

* criando serviços com o suporte a REST
* validando os dados de entrada dos serviços REST com o suporte à validação de beans

### Itens

*  3201 criando e acessando o endpoint para consulta de filmes    `GET    /movies` (@RequestParam optional)
*  3202 criando e acessando o endpoint para criação de um filme   `POST   /movies` com payload de requisição e status 201 para sucesso(@RequestBody,@ResponseStatus)
*  3203 criando e acessando o endpoint para remoção de um filme   `DELETE /movies/:id` com variável de caminho (@PathVariable)
*  3204 criando e acessando o endpoint para alteração de um filme  `PUT   /movies/:id` com rejeite de id desconhecido (Exception)
*  3205 criando e acessando o endpoint para consulta de um filme   `GET   /movies/:id` com status 404 para falha devido a filme não encontrado (ResponseEntity)
*  3206 respondendo conteúdo personalizado quando ocorre status 400 nos endpoints criação e alteração (@ExceptionHandler)
*  3207 validando a entrada do endpoint para criação de um filme com validadores padrão
*  3208 validando entrada de endpoint alteração de um filme com validador personalizado

## prática 11 (33)

*  separando responsabilidades com o suporte a injeção de dependências
*  alterando as configurações com o suporte a propriedades e perfis
*  lendo arquivos com o suporte a recursos
* facilitando a codificação e a publicação da aplicação com as ferramentas devtools e actuator

### Itens

*  3301 injetando instância única com escopo `singleton` (InMemoryMovieRepository,@Repository,@Autowired)
*  3302 injetando instâncias distintas com escopo `prototype` (@Scope,ConfigurableBeanFactory.SCOPE_PROTOTYPE)
*  3303 carregando conteúdo de arquivo texto com classes de recurso do Spring
*  3304 carregando propriedade com a anotação `@Value`
*  3305 carregando propriedades com o mesmo prefixo com `@ConfigurationProperties`
*  3306 modificando classes com `devtools` habilitado
*  3307 alterando conteúdo de resposta REST com `live reload` habilitado
*  3308 definindo configurações de desenvolvimento com profile `dev`
*  3309 definindo configurações de produção com profile `prod`
*  3310 definindo comuns configurações com profile padrão
*  3311 consultando informações da aplicação com endpoint `/info`
*  3312 configurando informações para o endpoint `/info`
*  3313 consultando a saúde da aplicação com `/health`
*  3314 configurando informações para o endpoint `/health`
*  3315 consultando os componentes gerenciados com `/beans`
*  3316 consultando as requisições http com `/httptrace`
*  3317 consultando as informações de ambiente no endpoint `/env`
*  3318 sobrescrevendo propriedades via linha de comando (server.port, server.servlet.context-path, logging.level.root)
*  3319 criando um novo projeto spring boot via linha de comando

## prática 12 (34)

* testando componentes com o suporte a testes automatizados

### Itens

*  3401 escrevendo testes automatizados para configuradores
*  3402 escrevendo testes automatizados para serialização e deserialização JSON
*  3403 escrevendo testes automatizados para serviços
*  3404 escrevendo testes automatizados para clientes REST
*  3405 escrevendo testes automatizados para controladores REST
*  3406 escrevendo testes automatizados para repositórios em memória
*  3407 escrevendo testes automatizados para repositórios spring jdbc
