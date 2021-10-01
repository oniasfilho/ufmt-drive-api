# 1) Aplicação Proposta:

A prova consiste em construir uma aplicação que conte com 5 entitades, tendo o front e back end separados, utilizando uma API REST  
para fazer a comunicação entre ambas partes.

Foi criado uma aplicação "clone" do [Google Keep](keep.google.com). Tendo funcionalidades de criação de usuários, login a partir dos usuários  
criados e cada usuário seria capaz de enxergar apenas as notas criadas por si mesmos.

# 2) Solução Desenvolvida:


#### Informacoes para acesso da aplicacao em nuvem:
Tecnologias/Bibliotecas Utilizadas:

- Spring Framework
- JWT
- ReactJS



### Instalacao

Esse projeto precisa de [Maven](https://maven.apache.org/download.cgi) e [Java](https://www.oracle.com/java/technologies/javase-jre8-downloads.html) instalados em sua máquina para funcionar.


Setup da API:
Na pasta principal do projeto, executar:

```sh
$ mvn clean package install & mvn clean spring-boot:run
```
Após a execução, a API estará disponível em http://localhost/8080 onde haverá dois endpoinds, um de [teste](http://localhost/8080/ping) e o [principal](http://localhost:8080/api/IMDB).


Postman Collection: https://github.com/oniasfilho/postman_collection

Front End: https://github.com/oniasfilho/ufmt-drive-front