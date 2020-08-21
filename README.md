# Introdução
API para realizar a conversão entre moedas.

#Tecnologias
- Java 8
- Spring Boot 2.3.3
- Maven 3.5.3
- Feign 2.2.4
- Hibernate Validator 6.1.6

# Execução

Execute o comando no diretório raiz da aplicação:

    mvn spring-boot:run

# API

### Converter Moeda

>**POST**  -> localhost:8080/converter/

    {
    	"userId":1,
    "fromCurrency":"TRY",
    "toCurrency":"USD",
    "amount":200.00
    }

### Consultar conversões realizadas por um usuário

>**GET** -> localhost:8080/converter/{id}/

### Consultar moedas suportadas

>**GET** -> localhost:8080/converter/currencies/
