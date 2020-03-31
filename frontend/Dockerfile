# Imagem de origem
FROM node:12-buster-slim

# Diretório de trabalho(é onde a aplicação ficará dentro do container)
WORKDIR /home/node/app/frontend

# Adicionando `/home/node/app/frontend/node_modules/.bin` para o $PATH
ENV PATH /home/node/app/frontend/node_modules/.bin:$PATH

# Instalando dependências da aplicação e armazenando em cache
COPY package*.json /home/node/app/frontend/
RUN npm install

# Inicia o app
CMD ["npm", "start"]
