# distributed-sistems-assessment
Atividade para cadeira de Sistemas distribuídos

### Estrutura do crud

```
src
---main
-----java/be/com/musicas
-------builder
-------controller
-------domain
-------dto
-------service
-------repository
-------MusicasApplication
-----resources
```

### Para fazer uso desse repositório
(Obs.: Os seguintes comandos foram executados no linux)

> É necessário ter:
- maven 3.8.1 ou superior
- alguma versão do jdk 11
- docker, docker-compose

### Para executar

Empacotamos a aplicação:

```
./mvnw package
```

Executamos o docker-compose:

```
docker-compose up
```

### O que acontece no docker-compose desse repositório?

- define dois serviços: web e postgres
- o postgres tem as definições do banco de dados, usuário, senha e schema
- o web monta uma imagem Dockerfile e define variáveis para acessar o postgres
- posgres expõe a porta 5432 e o web expõe a porta 8080
- postgres e web são adicionados a network crud para permitir a comunicação entre containers