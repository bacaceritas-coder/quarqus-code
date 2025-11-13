# 🧩 Quarkus Kafka Pipeline

A simple data pipeline built with **Quarkus**, **Kafka**, and **PostgreSQL**.  
This project demonstrates how to:
- Consume data from a Kafka topic
- Process and store the data in PostgreSQL
- Optionally publish the transformed result to another Kafka topic

---

## ⚙️ Tech Stack
- **Java 17**
- **Quarkus 3.x**
- **Apache Kafka**
- **PostgreSQL**
- **Docker & Docker Compose**

---

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

---
## 🚀 Getting Started
## Running docker

you can open docker-compose.yml in terminal and run
```shell script
  docker compose up -d
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
  ./mvnw clean quarkus:dev
```
## Add data to topic with KAFKA-UI

go to browser and aksess the kafka ui 
``` script
  http://localhost:8082/ui
```
- If the input-topic and output-topic do not exist yet:

``` script
1. Go to Topics → Create Topic
2. Fill in the following details:
   - Topic name: input-topic
   - Partitions: 1
   - Replication Factor: 1
   
3. Click Create topic
4. Repeat the same steps to create the output-topic.
```
- Send (produce) data to the input-topic:
```script
1. Open the topic you created:
   -  Go to Topics → input-topic
2. Select the Messages tab
3. In the top-right corner, click the Produce message button
4. In the Value field, enter: Apple,3,1000
5. Klick Produce Message 
```

