# Architecture Microservices avec RestTemplate

Ce projet est une démonstration d'une architecture microservices utilisant Spring Boot, Eureka Server, et RestTemplate pour la communication entre services.



## 🚀 Présentation
Cette application démontre une architecture microservices avec :
- Service Client : Gestion des clients
- Service Voiture : Gestion des véhicules
- Eureka Server : Découverte de services
- API Gateway : Point d'entrée unique pour les clients

## 🏗️ Architecture
```
┌─────────────────┐     ┌───────────────────┐     ┌──────────────────┐
│                 │     │                   │     │                  │
│  Client Web/App │ ◄──►│   API Gateway     │◄───►│  Eureka Server   │
│                 │     │   (Spring Cloud)  │     │   (8761)         │
└─────────────────┘     └────────┬──────────┘     └──────────────────┘
                                 │
                     ┌────────────┴────────────┐
                     │                         │
           ┌─────────▼──────┐      ┌──────────▼─────────┐
           │                │      │                    │
           │ Service Client │◄────►│ Service Voiture    │
           │ (8081)         │      │ (8082)             │
           └────────────────┘      └────────────────────┘
```

## 📋 Prérequis
- Java 17 ou supérieur
- Maven 3.6 ou supérieur
- IDE (IntelliJ, Eclipse, VS Code)

## 🛠️ Installation

1. **Cloner le dépôt** :
   ```bash
   git clone [URL_DU_DEPOT]
   cd "Architecture Micro-services avec RestTemplate"
   ```

2. **Construire tous les projets** :
   ```bash
   mvn clean install
   ```

## 🚀 Démarrage des services

### 1. Démarrer Eureka Server
```bash
cd eureka-server
mvn spring-boot:run
```

### 2. Démarrer le Service Client
```bash
cd ../client-service
mvn spring-boot:run
```

### 3. Démarrer le Service Voiture
```bash
cd ../voiture-service
mvn spring-boot:run
```

### 4. Démarrer l'API Gateway
```bash
cd ../gateway
mvn spring-boot:run
```

## 🌐 Accès aux services

- **Eureka Dashboard** : http://localhost:8761
- **Service Client** : http://localhost:8081
- **Service Voiture** : http://localhost:8082
- **API Gateway** : http://localhost:8888

## 📚 API Documentation

### Service Client
- `GET /api/client` - Récupérer tous les clients
- `GET /api/client/{id}` - Récupérer un client par ID
- `POST /api/client` - Créer un nouveau client

### Service Voiture
- `GET /api/car` - Récupérer toutes les voitures avec détails clients
- `GET /api/car/{id}` - Récupérer une voiture par ID avec détails client

## 🧪 Tests

### Exécuter les tests unitaires
```bash
# Pour un service spécifique
cd client-service
mvn test

# Pour tous les services
mvn -f "pom.xml" test
```

### Tester avec cURL
```bash
# Créer un client
curl -X POST -H "Content-Type: application/json" -d "{\"nom\":\"Dupont\",\"prenom\":\"Jean\"}" http://localhost:8081/api/client

# Récupérer tous les clients
curl http://localhost:8081/api/client
```

## 🛠️ Technologies utilisées

- **Spring Boot** : Cadre d'application
- **Spring Cloud** : Pour les fonctionnalités cloud
- **Eureka** : Découverte de services
- **RestTemplate** : Communication HTTP entre services
- **Maven** : Gestion des dépendances
- **H2 Database** : Base de données en mémoire (par défaut)
<img width="1366" height="728" alt="Eureka - Google Chrome 12_01_2026 02_17_47" src="https://github.com/user-attachments/assets/efec171e-9085-4477-bbf7-847855fd6795" />
<img width="1366" height="728" alt="Eureka - Google Chrome 12_01_2026 02_22_07" src="https://github.com/user-attachments/assets/2ca94508-8a52-4b3f-a68d-42b5531a3577" />

<img width="1366" height="728" alt="Eureka - Google Chrome 12_01_2026 02_22_07" src="https://github.com/user-attachments/assets/9c1c30a9-b0b4-4b7b-92d2-60d6c130eb" />
