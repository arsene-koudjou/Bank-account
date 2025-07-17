# Bank Account Kata 🏦

## 📌 Description
Simule un compte bancaire avec dépôt, retrait et consultation d’historique.

## 🚀 Lancement local
```bash
mvn clean package
java -jar target/bank-account.jar

Swagger disponible à http://localhost:8080/swagger-ui.html

🐳 Avec Docker

docker build -t bank-account .
docker run -p 8080:8080 bank-account
