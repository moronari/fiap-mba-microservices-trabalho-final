
# Trabalho Final de Microserviços

## Inicialização do projeto

```sh
mvn clean install
```

## Executar a aplicação spring

```sh
mvn spring-boot:run
```

## Dockerização

```sh
./mvnw install dockerfile:build
```

## Execução de duas instâncias da aplicação em portas distintas

Portas 8080 e 9090 recebendo instâncias da mesma aplicação
```sh
docker run -p 8080:8080 -t springio/trabalho-final
docker run -p 9090:8080 -t springio/trabalho-final
```

## Documentação Swagger da API

Endpoint da documentação
```url
http://localhost:8080/swagger-ui.html
```

## Statistic API

### Transactions - Insere dados na aplicação via endpoint da API
```sh
curl -X POST \
  http://localhost:8080/transactions \
  -H 'content-type: application/json' \
  -d '{ 
	"timestamp": 1556579512,
	"amount": 200.22 
      }' 
```

### Statistics - Retorna estatísticas das transações em memória (últimos 60 segundos)
```sh
curl -X GET \
  http://localhost:8090/statistics \
  -H 'content-type: application/json'
```
