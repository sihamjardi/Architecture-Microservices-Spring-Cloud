# Architecture Microservices : Orchestration de microservices avec Spring Cloud: Eureka, Gateway et OpenFeign

## Contexte et Architecture

**Objectif de l’étape**

•Comprendre ce qu’apporte Spring Cloud dans une architecture microservices.

•Situer le rôle d’Eureka (découverte de services) et de la Gateway (point d’entrée et routage).

•Visualiser le flux complet d’une requête entre client, Gateway, Eureka, Load Balancer et microservices.

---

## Étape — Créer le Eureka Server

**Spring Initializr “Eureka Server”**

<img width="884" height="493" alt="Capture d&#39;écran 2025-12-01 093018" src="https://github.com/user-attachments/assets/8b488e76-6708-4df5-bf0b-5e8d3f080c2c" />

**Lancement du serveur Eureka http://localhost:8761/**

<img width="959" height="483" alt="Capture d&#39;écran 2025-12-01 093947" src="https://github.com/user-attachments/assets/d83660d3-427b-4304-89db-09757b04782a" />

<img width="924" height="504" alt="Capture d&#39;écran 2025-12-01 093541" src="https://github.com/user-attachments/assets/a93d1357-5327-426f-be38-2361ac76de61" />

---

## Étape — Créer le microservice “Client”

**Spring Initializr “Client”**

<img width="923" height="498" alt="Capture d&#39;écran 2025-12-01 094000" src="https://github.com/user-attachments/assets/512bbf4b-826a-4d4d-86f1-0575007f06e6" />


**Endpoints:**

***http://localhost:8088/clients***

<img width="923" height="471" alt="Capture d&#39;écran 2025-12-01 095814" src="https://github.com/user-attachments/assets/a46dd1e5-c772-49ef-a94c-8e4fc4ed5b61" />


***http://localhost:8088/client/1***

<img width="920" height="304" alt="image" src="https://github.com/user-attachments/assets/74cc5b04-b573-48dc-ae9b-38fa0bfe287e" />


<img width="960" height="459" alt="Capture d&#39;écran 2025-12-01 094547" src="https://github.com/user-attachments/assets/d0599e98-6add-4263-9392-df593bdce377" />

**Vérification Eureka (http://localhost:8761/): SERVICE-CLIENT apparaît**
<img width="921" height="503" alt="Capture d&#39;écran 2025-12-01 094748" src="https://github.com/user-attachments/assets/3ae02275-6d2a-4067-a1ac-807a37ddb374" />


<img width="922" height="407" alt="Capture d&#39;écran 2025-12-01 122748" src="https://github.com/user-attachments/assets/09f11da9-e495-4c12-88e3-9a3e097f78d6" />

---

## Étape — Créer la Gateway (config statique)

**Spring Initializr “GateWay”**

<img width="927" height="505" alt="Capture d&#39;écran 2025-12-01 094856" src="https://github.com/user-attachments/assets/e47afe3b-39fc-4549-8738-2c85a4f31e43" />

**Test**

***http://localhost:8888/clients***

<img width="923" height="471" alt="Capture d&#39;écran 2025-12-01 095814" src="https://github.com/user-attachments/assets/ee6beab2-f499-4ced-a561-c4fdd98676a8" />

***http://localhost:8888/client/1***

<img width="926" height="392" alt="Capture d&#39;écran 2025-12-01 095824" src="https://github.com/user-attachments/assets/6db7ff89-b361-415e-93e3-39f6cdf04c8d" />


---

## Étape — Gateway avec Eureka (routage par nom de service)


**Vérification Eureka (http://localhost:8761/): SERVICE-CLIENT et GATEWAY apparaissent.**

<img width="918" height="327" alt="Capture d&#39;écran 2025-12-01 20025511" src="https://github.com/user-attachments/assets/b0e08567-8b8d-481d-8d74-fd8bd2879580" />

**http://localhost:8888/SERVICE-CLIENT/clients**

<img width="922" height="407" alt="Capture d&#39;écran 2025-12-01 122748" src="https://github.com/user-attachments/assets/bbfa4678-459f-495b-9557-991c104c6874" />

---

## Étape — 2e microservice “SERVICE-VOITURE”

**Spring Initializr “service-voiture”**

<img width="924" height="488" alt="Capture d&#39;écran 2025-12-01 123043" src="https://github.com/user-attachments/assets/ccc4049c-b6bd-4ace-b2d9-645375b234c0" />

**Architecture Feign et diagramme de classes.**

<img width="1290" height="690" alt="image" src="https://github.com/user-attachments/assets/075dc92f-5083-4f09-8eea-dc4ed58c3286" />

<img width="348" height="104" alt="image" src="https://github.com/user-attachments/assets/dca1f07f-b96d-489a-9ce7-523a78eac0aa" />

**Démarrer Eureka, SERVICE-CLIENT, SERVICE-VOITURE**

<img width="922" height="505" alt="Capture d&#39;écran 2025-12-01 213837" src="https://github.com/user-attachments/assets/5a17af56-4ea2-4fc6-96ac-137ba06847c7" />

**Ouvrir: http://localhost:8089/voitures**

<img width="927" height="485" alt="Capture d&#39;écran 2025-12-01 213909" src="https://github.com/user-attachments/assets/e003eaef-3504-48f5-bb56-f9ea6e603b44" />


---

## Auteur

**Nom :** JARDI Siham
**Cours :** Architecture Microservices : Conception, Déploiement et Orchestration
**Date :** Decembre 2025
**Encadré par :** Pr.Mohamed LACHGHAR







