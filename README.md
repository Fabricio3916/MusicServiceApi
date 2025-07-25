# 🎵 MusicServiceApi

Uma API REST moderna para gerenciamento de artistas, álbuns e músicas, desenvolvida com as melhores práticas de desenvolvimento Java.

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Modelo de Dados](#modelo-de-dados)
- [Pré-requisitos](#pré-requisitos)
- [Instalação e Execução](#instalação-e-execução)
- [Endpoints da API](#endpoints-da-api)
- [Contribuição](#contribuição)
- [Licença](#licença)

## 🎯 Sobre o Projeto

O **MusicServiceApi** é uma aplicação backend que oferece um serviço completo para cadastro e gerenciamento de informações musicais. A API permite organizar dados de artistas, seus álbuns e respectivas faixas musicais de forma estruturada e eficiente.

### Funcionalidades Principais

- ✅ Cadastro e gerenciamento de artistas
- ✅ Organização de álbuns por artista
- ✅ Catalogação de músicas com informações detalhadas
- ✅ Relacionamentos estruturados entre entidades
- ✅ API RESTful com documentação completa

### 🚧 Funcionalidades em Desenvolvimento

- 🔜 **Interface Frontend** - Aplicação web moderna desenvolvida em Angular
- 🔜 **Sistema de Autenticação** - Cadastro e gerenciamento de usuários
- 🔜 **Segurança Avançada** - Implementação com Spring Security
- 🔜 **Controle de Acesso** - Autorização baseada em roles e permissões

## 🚀 Tecnologias Utilizadas

Este projeto foi desenvolvido utilizando as seguintes tecnologias e ferramentas:

- **[Java 17](https://openjdk.org/projects/jdk/17/)** - Linguagem de programação
- **[Spring Boot 3](https://spring.io/projects/spring-boot)** - Framework para desenvolvimento de aplicações Java
- **[Docker](https://www.docker.com/)** - Containerização da aplicação
- **[Flyway](https://flywaydb.org/)** - Controle de versão e migração de banco de dados
- **[Lombok](https://projectlombok.org/)** - Redução de código boilerplate
- **[JPA/Hibernate](https://hibernate.org/)** - Mapeamento objeto-relacional
- **[PostgreSQL](https://www.postgresql.org/)** - Banco de dados relacional

### 🔮 Tecnologias Futuras

- **[Angular](https://angular.io/)** - Framework frontend para interface web moderna
- **[Spring Security](https://spring.io/projects/spring-security)** - Framework de segurança e autenticação
- **[JWT](https://jwt.io/)** - Tokens para autenticação stateless
- **[Angular Material](https://material.angular.io/)** - Biblioteca de componentes UI

## 📊 Modelo de Dados

O sistema é estruturado em três entidades principais com os seguintes relacionamentos:

```
User (1) -----> (N) Playlist
Artist (1) -----> (N) Album (1) -----> (N) Music
```

*Nota: As entidades User e Playlist serão implementadas nas próximas versões.*

### Entidades

#### 🎤 Artist
- `id` - Identificador único
- `name` - Nome do artista
- `albums` - Lista de álbuns do artista

#### 💿 Album
- `id` - Identificador único
- `title` - Título do álbum
- `artist` - Artista proprietário do álbum
- `tracks` - Lista de músicas do álbum

#### 🎵 Music
- `id` - Identificador único
- `title` - Título da música
- `durationInSeconds` - Duração em segundos
- `album` - Álbum ao qual pertence
- `genre` - Gênero musical

## 📋 Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- **Java 17** ou superior
- **Maven 3.6+** (ou usar o wrapper incluído)
- **Docker** e **Docker Compose**
- **Git**

## 🔧 Instalação e Execução

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/MusicServiceApi.git
cd MusicServiceApi
```

### 2. Execute com Docker (Recomendado)

```bash
# Inicie os serviços com Docker Compose
docker-compose up -d

# A API estará disponível em http://localhost:8080
```

### 3. Execução Local (Alternativa)

```bash
# Compile o projeto
./mvnw clean compile

# Execute a aplicação
./mvnw spring-boot:run
```

### 4. Verificação

Acesse `http://localhost:8080/actuator/health` para verificar se a aplicação está funcionando.

## 🗺️ Roadmap do Projeto

### Fase Atual - Backend Core ✅
- [x] API REST completa para gerenciamento de artistas, álbuns e músicas
- [x] Modelo de dados estruturado com JPA
- [x] Containerização com Docker
- [x] Migrações de banco com Flyway

### Fase 2 - Segurança e Autenticação 🚧
- [ ] Implementação do Spring Security
- [ ] Sistema de cadastro e login de usuários
- [ ] Autenticação JWT
- [ ] Controle de acesso baseado em roles (ADMIN, USER)
- [ ] Endpoints protegidos por autenticação

### Fase 3 - Interface Frontend 🔮
- [ ] Aplicação Angular moderna e responsiva
- [ ] Integração com a API backend
- [ ] Interface para gerenciamento de músicas
- [ ] Sistema de login e cadastro
- [ ] Dashboard administrativo
- [ ] Componentes reutilizáveis com Angular Material

### Fase 4 - Funcionalidades Avançadas 💭
- [ ] Sistema de playlists personalizadas
- [ ] Busca avançada e filtros
- [ ] Favoritos e recomendações
- [ ] Upload de capas de álbuns
- [ ] Player de música integrado

### Artistas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/api/artists` | Lista todos os artistas |
| `GET` | `/api/artists/{id}` | Busca artista por ID |
| `POST` | `/api/artists` | Cria novo artista |
| `PUT` | `/api/artists/{id}` | Atualiza artista |
| `DELETE` | `/api/artists/{id}` | Remove artista |

### Álbuns

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/api/albums` | Lista todos os álbuns |
| `GET` | `/api/albums/{id}` | Busca álbum por ID |
| `POST` | `/api/albums` | Cria novo álbum |
| `PUT` | `/api/albums/{id}` | Atualiza álbum |
| `DELETE` | `/api/albums/{id}` | Remove álbum |

### Músicas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/api/music` | Lista todas as músicas |
| `GET` | `/api/music/{id}` | Busca música por ID |
| `POST` | `/api/music` | Cria nova música |
| `PUT` | `/api/music/{id}` | Atualiza música |
| `DELETE` | `/api/music/{id}` | Remove música |

### Exemplo de Requisição

```json
POST /api/artists
{
  "name": "The Beatles"
}

POST /api/albums
{
  "title": "Abbey Road",
  "artist": 1
}

POST /api/music
{
  "title": "Come Together",
  "durationInSeconds": 259,
  "album": 1,
  "genre": "Rock"
}
```

## 🤝 Contribuição

Contribuições são sempre bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---
