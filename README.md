# Cafeteria Management System

## Projektübersicht

Das **Cafeteria Management System** ist eine vollständige Anwendung, die speziell für die Verwaltung einer Universitätsklinikum-Cafeteria entwickelt wurde. Es kombiniert moderne Technologien mit bewährten Software-Entwicklungsmethoden wie **Domain-Driven Design (DDD)**, um Bestellungen, Zahlungen und Bestände effizient zu verwalten. Die Anwendung bietet eine benutzerfreundliche Oberfläche, Echtzeit-Updates und eine sichere Authentifizierungslösung.

---

## Features

1. **Produktmanagement**:
   - Hinzufügen, Aktualisieren und Entfernen von Produkten.
   - Echtzeit-Bestandsverfolgung.

2. **Bestell- und Zahlungsverwaltung**:
   - Erstellung, Bearbeitung und Überwachung von Bestellungen.
   - Integration von Zahlungsoptionen und -methoden.

3. **Benutzerverwaltung**:
   - SSO (Single Sign-On) via OAuth2 für nahtlose und sichere Authentifizierung.
   - Rollenbasierte Zugriffssteuerung (z.B. Admin, Kunde).

4. **Echtzeit-Updates**:
   - Verwendung von **MQTT** (Mosquitto Broker) für Nachrichtenübermittlung, um Bestandsdaten und andere wichtige Informationen in Echtzeit zu aktualisieren.

5. **Skalierbare Architektur**:
   - Aufbau auf Basis von **Spring Boot**, **JPA**, und **PostgreSQL**.
   - Einhaltung von DDD-Prinzipien mit Bounded Contexts.

6. **Moderne Benutzeroberfläche**:
   - Implementiert mit **Thymeleaf**, **HTML**, **CSS** und **JavaScript**.

---

## Technologiestack

### Backend
- **Spring Boot**: Hauptframework für die Implementierung von Services und Geschäftslogik.
- **JPA (Hibernate)**: Datenpersistenz mit PostgreSQL als Datenbank.
- **Logback**: Logging-Framework für Anwendungsprotokollierung.

### Frontend
- **Thymeleaf**: Template-Engine für serverseitig gerenderte HTML-Seiten.
- **HTML, CSS, JavaScript**: Für responsive und interaktive Benutzeroberflächen.

### Kommunikation
- **MQTT**: Kommunikation über den Mosquitto-Broker, insbesondere für Echtzeit-Bestandsupdates.

### Sicherheit
- **OAuth2**: Ermöglicht die Benutzeranmeldung über externe Anbieter wie GitHub.

---

## Projektstruktur

- **domain**: Geschäftslogik und Domain-Entities (z.B. `Order`, `Product`, `Payment`).
- **repository**: JPA-Repositories für die Datenbankzugriffe.
- **service**: Serviceklassen zur Implementierung der Geschäftslogik.
- **controller**: REST-Controller für die API-Endpunkte.
- **mqtt**: MQTT-Kommunikation für Echtzeit-Nachrichten.
- **ui**: HTML, CSS, JS-Dateien für die Benutzeroberfläche.

---

## Installation und Ausführung

### Voraussetzungen
- **Java 17** oder höher
- **Maven**
- **PostgreSQL** (lokale Instanz)
- **Mosquitto** (MQTT-Broker)

### Setup

1. **Datenbank konfigurieren**:  
   Bearbeiten Sie die Datei `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/cafeteria
   spring.datasource.username=<USERNAME>
   spring.datasource.password=<PASSWORD>
   spring.jpa.hibernate.ddl-auto=update
## MQTT konfigurieren

Ergänzen Sie die Konfiguration in `application.properties`:

```properties
mqtt.url=mqtt://<BROKER_URL>:1883
mqtt.clientIdPublisher=clientIdPublisher
mqtt.clientIdSubscriber=clientIdSubscriber
mqtt.topic=inventory/update
