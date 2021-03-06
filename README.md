# 1) Aplicação Proposta:

A prova consiste em construir uma aplicação que conte com 5 entitades, tendo o front e back end separados, utilizando uma API REST  
para fazer a comunicação entre ambas partes.

Foi criado uma aplicação "clone" do [Google Keep](keep.google.com). Tendo funcionalidades de criação de usuários, login a partir dos usuários  
criados e cada usuário seria capaz de enxergar apenas as notas criadas por si mesmos.

Links Uteis:
front end - https://github.com/oniasfilho/ufmt-drive-front
postman collection - https://github.com/oniasfilho/postman_collection

# 2) Solução Desenvolvida:


#### Informacoes para acesso da aplicacao em nuvem:
Tecnologias/Bibliotecas Utilizadas:

- Spring Framework
- JWT
- ReactJS



### Instalacao

Esse projeto precisa de [Maven](https://maven.apache.org/download.cgi) e [Java](https://www.oracle.com/java/technologies/javase-jre8-downloads.html) instalados em sua máquina para funcionar.

No banco de dados, executar os seguintes scripts:
```SQL
create table if not exists user_data
(
	id bigint generated by default as identity
		constraint user_data_pkey
			primary key,
	first_name varchar(255),
	last_name varchar(255),
	password varchar(255),
	username varchar(255),
	address_id bigint
		constraint fkr07d3wy86wr30y85ksign0j33
			references address
);

create table note
(
	id bigint generated by default as identity
		constraint note_pkey
			primary key,
	note_description varchar(255),
	note_title varchar(255),
	user_id bigint
		constraint fkqedfem6s23u04om80ue27tjfh
			references user_data
);

create table file
(
	id bigint generated by default as identity
		constraint file_pkey
			primary key,
	content_type varchar(255),
	file_name varchar(255),
	file_size varchar(255),
	user_id bigint
		constraint fkhxm2am09mg7gs5hakur4w4kx5
			references user_data
);

create table address
(
	id bigint generated by default as identity
		constraint address_pkey
			primary key,
	city varchar(255),
	state varchar(255),
	street varchar(255),
	zip_code varchar(255)
);

insert into user_data values (1,'Onias' ,'da Rocha Filho', '$2y$12$yYriNX6TSz8smC3EKJYiauGw8gHtu9Hp0MjeFKo1FIO1dSJN0Jeji', 'oniasfilho');

```


Setup da API:
Na pasta principal do projeto, executar:

```sh
$ mvn clean package install & mvn clean spring-boot:run
```
Após a execução, a API estará disponível em http://localhost/8080.

Para testar todos os endpoints da API, utilizar a [Collection do Postman](https://github.com/oniasfilho/postman_collection) que foi gerada para esse projeto, que conta com scripts pre-flight de autenticação JWT para facilitar nos testes.



Tendo feito os passos anteriores, [baixar o front-end](https://github.com/oniasfilho/ufmt-drive-front) e na pasta raiz executar o seguinte comando:

```sh
$ npm install & npm start
```

Após esses passos a aplicação estará disponivel em http://localhost:3000 onde inicialmente haverá apenas o usuário oniasfilho:123 disponivel para teste. Caso necessário, criar outro usuario via postman. Eu tentei criar uma tela de criação de usuário mas infelizmente não consegui concluir o trabalho </3

Segue alguns prints da aplicação em funcionamento:

![image](https://user-images.githubusercontent.com/19842185/135559349-e9c02d29-579b-4d35-8ed5-0033ad101e29.png)

![image](https://user-images.githubusercontent.com/19842185/135559379-6fcfafa3-5c9a-4bbb-ab5d-c12c40767aa6.png)

![image](https://user-images.githubusercontent.com/19842185/135559418-b4d36305-a574-4a12-bd8b-1a994c2c98fe.png)


