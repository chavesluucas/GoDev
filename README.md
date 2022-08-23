<h1>Test GoDev 🧑‍💻</h1>

>Status: Em Desenvolvimento ⚠️

### Esse é um projeto para o desafio GoDev, a aplicação é um CRUD para cadastro de produtos e itens, ordem de vendas e itens da ordem.

## Tecnologias utilizadas

+ JAVA 11
+ Spring Boot 
+ JPA / Hibernate
+ Maven


## Campos das Entidades

### Product
+ ID
+ Description
+ value 
+ type
##### Endpoint
+ Create: POST > [url base]/api/items
+ Read: GET > [url base]/api/items || GET ID > [url base]/api/items/[id]
+ Update: PUT > [url base]/api/items
+ Delete: DELETE > [url base]/api/items/[id]

### OrderItem
+ ID
+ Order (Class)
+ Product (Class) 
+ Quantity
+ TotalValue
##### Endpoint
+ Create: POST > [url base]/api/orderItems
+ Read: GET > [url base]/api/orderItems || GET ID > [url base]/api/orderItems/[id]
+ Update: PUT > [url base]/api/orderItems
+ Delete: DELETE > [url base]/api/orderItems/[id]

### SalesOrder
+ ID
+ Number
+ Date 
+ PercentualDiscount
+ TotalValue   
##### Endpoint
+ Create: POST > [url base]/api/order
+ Read: GET > [url base]/api/order || GET ID > [url base]/api/order/[id]
+ Update: PUT > [url base]/api/order
+ Delete: DELETE > [url base]/api/order/[id]

## Como executar o projeto
### Pré requisitos

+ JAVA 11
+ IDE (de sua preferencia)
+ Banco de dados PostgreSQL

### Executando

+ Clone esse repósitório do GitHub (comando para utilizar no prompt de comando: ```git clone https://github.com/chavesluucas/GoDev.git```)
+ Crie uma database no banco de dados com o nome "testgodev"
+ Importe o projeto em sua IDE ( file > import > Existing Maven Project)
+ Entre na pasta src/main/resource e abra o arquivo application.properties, em "spring.datasource.username=postgres" altere o root para o username do seu banco de dados, e em "spring.datasource.password = admin" altere a informação de admin para a senha do seu banco de dados.
+ Rode o projeto (Caso estiver STS, recomendo rodar em "Spring Boot App")


## Bonus
 Tenho um site pessoal, que utilizo para estudo e estou desenvolvendo ele em ANGULAR, caso tenha curiosidade de me conhecer melhor ou visualizar o site, basta <a target="_blank" href="https://lucaschaves.netlify.app">clicar aqui</a>
