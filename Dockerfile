# Folosim imagine oficială Node.js ca bază
FROM node:14

# Setăm directorul de lucru în container
WORKDIR /app
# Copiem fișierele de proiect în container
COPY package*.json ./
COPY package-lock.json ./
COPY . .
# Instalăm dependențele
RUN yarn install

# Construim aplicația React
RUN yarn build

# Expunem portul 3000
EXPOSE 3000

# Comanda pentru a porni aplicația React
CMD ["yarn", "start"]
