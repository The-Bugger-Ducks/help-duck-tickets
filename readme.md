<h1 align="center"> 
  Microsserviço para manipulação de chamados
</h1>

Esta API, que permite o gerenciamento de chamados, foi desenvolvida visando sua utilização no projeto "Help Duck" (mais informações vide [este link](https://github.com/The-Bugger-Ducks/help-duck-documentation)).

> Aplicação desenvolvida por alunos do 3º semestre do tecnólogo em Desenvolvimento de Software Multiplataforma, na FATEC Profº Jessen Vidal - São José dos Campos, SP :rocket:

### :hammer_and_wrench: Tecnologias

As seguintes tecnologias e ferramentas foram utilizadas neste projeto: `Java, Spring, MongoDB, Docker, Insomnia, Heroku`

### :gear: Como utilizar

Para consumir esta API, é preciso seguir o passo a passo abaixo ou utilizar a URL do serviço em nuvem (através deste link: [https://help-duck-tickets.herokuapp.com/tickets/](https://help-duck-tickets.herokuapp.com/tickets/)).

- Tutorial para rodar o projeto

No arquivo `application-dev.properties`, complete a variavel "spring.data.mongodb.uri" com a URI que o mongo disponibiliza ao logar na plataforma do MongoDB (Deployment -> Database -> connect -> connect your application). Se for localhost, utilize suas credenciais no formato da URI ( mongodb://<username>:<password>@localhost/ ):

> Print do mongoDB atlas connect URI
<div align="center">

![image](https://user-images.githubusercontent.com/55204419/162738729-580b22f4-ea41-4d94-a9b2-d20c790458f7.png)
</div>

```cl
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.rpjin.mongodb.net/myFirstDatabase?retryWrites=true&w=majority
```

Para prosseguir, é preciso que todas as ferramentas necessárias estejam devidamente instaladas (Java, Git, MongoDb...). Para conferir a instalação delas, acesse [este tutorial](https://uttermost-apricot-1bb.notion.site/Instala-o-das-Ferramentas-Spring-29c3794b88b0460782f454d1c31249d8). Após os downloads, baixe ou clone este repositório pelo terminal seguindo passo a passo descrito abaixo:

```bash
# Baixe este repositório ou clone pelo Git usando o comando:
$ git clone https://github.com/The-Bugger-Ducks/help-duck-tickets.git

# Acesse a pasta do projeto
$ cd help-duck-tickets

# Espere o Maven carregar as dependências do projeto (são listadas no arquivo pom.xml)

# Execute o projeto utilizando sua IDE preferida (Eclipse, VS Code, IntelliJ, etc.)
```

O servidor inciará localmente na porta 8081. Use o Insomnia para simular requisições e respostas das rotas (pelo link [https://localhost:8081](https://localhost:8081)) ou utilize o projeto fron-end do "Help Duck" para executar as funcionalidades da aplicação (acesse o repositório por [este link](https://github.com/The-Bugger-Ducks/help-duck-web)).

## :railway_track: Rotas disponíveis
<div align="center">
  
|                                                                    Tipo | Rota                                 | Ação                            |
| ----------------------------------------------------------------------: | :----------------------------------- | :------------------------------ |
|   <hr>                                                                  | <hr>                                 | **Controle de chamados**        |
|    [![](https://img.shields.io/badge/GET-2E8B57?style=for-the-badge)]() | `/tickets/`                          | Listagem de chamados            |
|    [![](https://img.shields.io/badge/GET-2E8B57?style=for-the-badge)]() | `/tickets/{ticketId}`                | Dados de um chamado específico  |
|    [![](https://img.shields.io/badge/GET-2E8B57?style=for-the-badge)]() | `/tickets/user/{userId}`             | Chamados de um usuário comum específico |
|    [![](https://img.shields.io/badge/GET-2E8B57?style=for-the-badge)]() | `/tickets/support/{userId}`          | Chamados de um usuário suporte específico |
|    [![](https://img.shields.io/badge/GET-2E8B57?style=for-the-badge)]() | `/tickets/status/{statusToFind}`     | Chamados com um status específico |
|   [![](https://img.shields.io/badge/POST-4682B4?style=for-the-badge)]() | `/tickets/create`                    | Cadastro de chamados            |
|    [![](https://img.shields.io/badge/PUT-9370DB?style=for-the-badge)]() | `/tickets/update`                    | Alteração dos dados do chamado  |
| [![](https://img.shields.io/badge/DELETE-CD853F?style=for-the-badge)]() | `/tickets/delete/{ticketId}`         | Exclusão de chamados            |
|    [![](https://img.shields.io/badge/GET-2E8B57?style=for-the-badge)]() | `/tickets/search`                    | Busca de chamados por título e/ou suporte e/ou cliente e/ou status |
|   <hr>                                                                  | <hr>                                 | **Controle de ações do usuário**|
|    [![](https://img.shields.io/badge/PUT-9370DB?style=for-the-badge)]() | `/helpUser/reserveTicket/{ticketId}` | Reserva de chamados             |
|    [![](https://img.shields.io/badge/PUT-9370DB?style=for-the-badge)]() | `/helpUser/updateComment/{ticketId}` | Adição de comentário no chamado |
|    [![](https://img.shields.io/badge/PUT-9370DB?style=for-the-badge)]() | `/helpUser/closeTicket/{ticketId}`   | Fechamento de chamado por um usuário suporte |

</div>

### Explicação da estrutura das pastas

| Pasta                                                       | Definição                                                                       |
| ----------------------------------------------------------- | ------------------------------------------------------------------------------- |
| :open_file_folder: main/ .../                               | Arquivos com o código fonte do projeto                                          |
| :open_file_folder: main/ .../ config                        | Configuração de cors, csrf, etc                                                 |
| :open_file_folder: main/ .../ controller                    | Arquivos com os métodos de requisição das rotas                                 |
| :open_file_folder: main/ .../ entity                        | Arquivos com funções mais especificas, ex: atualizador, adicionador de links para HATEOAS, etc |
| :open_file_folder: main/ .../ enums                         | Arquivos de padronização de entrada para campos específicos no banco de dados   |
| :open_file_folder: main/ .../ interfaces                         | Arquivos que constam as interfaces criadas e utilizadas no projeto         |
| :open_file_folder: main/ .../ model                         | Arquivos que fazem a aplicação de HATEOAS e manipulação de dados                |
| :open_file_folder: main/ .../ repository                    | Arquivos para utilização de CRUD de entidades (collection - mongodb) do projeto |
| :open_file_folder: main/ .../ service                       | Arquivos que contém os serviços utilizados no projeto                           |
| :page_facing_up: main/ .../ HelpDuckTicketsApplication.java | Arquivo principal do projeto                                                    |
| :open_file_folder: main/ resources/                         | Arquivos para configurações globais do projeto (ex: credenciais em banco de dados)|
| :page_facing_up: docker-compose                             | Arquivo usado para "conteinerizar" um banco mongo local                         |
| :page_facing_up: pom.xml                                    | Arquivo usado gerenciar as dependencias do projeto com o Maven                  |

