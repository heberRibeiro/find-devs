# Dev-Find

Este projeto (10° semana Omnistack) realiza a inserção de desenvolvedores em banco de dado local a partir do 'user name' do github através do acesso de sua api. As Informações de geolocalização são inseridas manualmente ou capturadas a partir da api de geolocalização do navegador.

## Começando
Tecnologias e ferramenta para rodar o projeto será necessário:

###### Backend

* [Eclipse: Para desenvolvimento do projeto](https://www.eclipse.org/downloads/packages/)
* [Spring Boot Web Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
* [Spring Boot Data MongoDB Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-mongodb)
* [MongoDB Community Server](https://www.mongodb.com/download-center/community)
* [MongoDB Compass](https://www.mongodb.com/download-center/compass)

Dados de conexão com o banco:

| Hostname | Port | Autentication |DB | Collection |
|:--:|:--:|:--|:--:|:--|
| localhost | 27017 | None | finddevs  | dev |



###### Frontend
* [Visual Studio Code](https://code.visualstudio.com/)
* [React](https://pt-br.reactjs.org/)
* [Node.js](https://nodejs.org/en/)



## Desenvolvimento

Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:

>cd "diretorio de sua preferencia"
>
>git clone https://github.com/heberRibeiro/find-devs


## Configurações
Para executar o projeto, é necessário iniciar o banco de dados MongoDB. Caso ele tenha sido configurado como serviço, verificar o status de execução, caso contrário, abrir o Power Shel ou Prompt de Comando (usuários windows) e executar mongod para iniciar o banco. O acesso e gerenciamento pode se dar através do Mongo Compass com os dados informados acima. Não esquecer de criar um DB e uma Collection com os nomes indicados. Utilizar o Eclipse (ou ide de sua preferência) para que seja identificada as dependências necessárias para a execução do projeto Maven no backend. Além disso, será necessário abrir o frontend do projeto no VsCode (ou ide de sua preferência) para as dependências, nesse caso, foi utilizada o React como biblioteca. Executar o Backend e executar npm start para servir o Frontend.

## Build e Deploy
Caso queira executar o Build e Deploy do projeto, seguir os passos indicados neste link:
https://create-react-app.dev/docs/deployment/
