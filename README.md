# Application Bancaire Java

Une application bancaire simple développée en Java avec intégration PostgreSQL pour la gestion des comptes.

## 📋 Description

Ce projet implémente une application bancaire avec les fonctionnalités suivantes :
- Gestion des comptes standards
- Comptes épargne avec calcul d'intérêts
- Comptes en devise avec conversion
- Connexion à une base de données PostgreSQL
- Gestion des exceptions

## 🏗️ Structure du Projet

```
rappel/
├── Compte.java                 - Classe de base du compte
├── CompteEpargne.java         - Compte épargne avec taux d'intérêt
├── CompteDevise.java          - Compte multi-devise
├── CompteDAO.java             - Accès aux données (PostgreSQL)
├── TestCompte.java            - Classe de test principale
├── MontantNonValideException.java - Exception personnalisée
└── README.md                  - Ce fichier
```

## 🚀 Étapes d'Installation et d'Exécution

### 1. Prérequis

- **Java JDK 25** (ou version supérieure)
- **PostgreSQL** (port 5433)
- **Driver PostgreSQL** (postgresql-42.7.10.jar)

### 2. Installation de Java

```bash
# Télécharger JDK depuis https://adoptium.net/
# Installer et ajouter au PATH
# Vérifier l'installation :
java -version
javac -version
```

### 3. Configuration de la Base de Données

```sql
-- Créer la base de données
CREATE DATABASE banque;

-- Créer la table des comptes
CREATE TABLE comptes (
    id SERIAL PRIMARY KEY,
    proprietaire VARCHAR(100),
    solde DECIMAL(10,2)
);

-- Insérer des données de test
INSERT INTO comptes (proprietaire, solde) VALUES 
('Alice', 1000.00),
('Bob', 2000.00),
('Carol', 500.00);
```

### 4. Configuration de l'Application

Modifier les constantes dans `CompteDAO.java` :

```java
private static final String URL      = "jdbc:postgresql://localhost:5433/banque";
private static final String USER     = "postgres";
private static final String PASSWORD = "0000"; // Votre mot de passe
```

### 5. Compilation

```bash
# Compiler tous les fichiers Java
javac -cp postgresql-42.7.10.jar *.java
```

### 6. Création du JAR

```bash
# Créer le fichier JAR exécutable
jar cvfe banque.jar TestCompte *.class
```

### 7. Exécution

```bash
# Lancer l'application
java -cp "banque.jar;postgresql-42.7.10.jar" TestCompte
```

## 📋 Tâches Réalisées

### ✅ Phase 1: Développement des Classes Métier
- [x] Création de la classe `Compte` avec attributs de base
- [x] Implémentation des méthodes `deposer()` et `retirer()`
- [x] Gestion des exceptions avec `MontantNonValideException`
- [x] Redéfinition de `toString()` pour l'affichage

### ✅ Phase 2: Classes Spécialisées
- [x] Création de `CompteEpargne` avec taux d'intérêt
- [x] Calcul automatique des intérêts
- [x] Création de `CompteDevise` avec gestion des devises
- [x] Affichage du montant avec devise

### ✅ Phase 3: Persistance des Données
- [x] Implémentation de `CompteDAO` avec JDBC
- [x] Connexion à PostgreSQL
- [x] Méthodes CRUD (Create, Read, Update, Delete)
- [x] Gestion des exceptions SQL

### ✅ Phase 4: Tests et Validation
- [x] Création de `TestCompte` avec scénarios de test
- [x] Test des opérations bancaires de base
- [x] Test des exceptions
- [x] Test de la connexion base de données

### ✅ Phase 5: Déploiement
- [x] Configuration de l'environnement Java
- [x] Compilation du projet
- [x] Création du JAR exécutable
- [x] Tests d'exécution
- [x] Mise en place sur GitHub

## 🎯 Fonctionnalités Implémentées

### Compte Standard
- Dépôt d'argent
- Retrait d'argent avec validation
- Affichage du solde

### Compte Épargne
- Hérite des fonctionnalités du compte standard
- Calcul des intérêts automatiques
- Taux d'intérêt configurable

### Compte Devise
- Gestion multi-devise
- Affichage formaté avec devise
- Conversion potentielle (à implémenter)

### Accès Données
- Connexion sécurisée à PostgreSQL
- Requêtes SQL paramétrées
- Gestion des erreurs de connexion

## 🐛 Résolution des Problèmes

### Configuration Java
- **Problème**: `javac` non reconnu
- **Solution**: Installation JDK et configuration PATH
- **Commande**: `set PATH=C:\Program Files\Java\jdk-25.0.2\bin;%PATH%`

### Compilation et Exécution
- **Problème**: Classpath PostgreSQL
- **Solution**: Inclusion du driver dans le classpath
- **Commande**: `java -cp "banque.jar;postgresql-42.7.10.jar" TestCompte`

### Déploiement GitHub
- **Problème**: Fichiers volumineux (>100MB)
- **Solution**: Configuration .gitignore et nettoyage historique
- **Outils**: `git filter-branch` pour supprimer les gros fichiers

## 🔧 Commandes Utiles

### Développement
```bash
# Compiler
javac -cp postgresql-42.7.10.jar *.java

# Exécuter
java -cp "banque.jar;postgresql-42.7.10.jar" TestCompte

# Créer JAR
jar cvfe banque.jar TestCompte *.class
```

### Git
```bash
# Initialiser
git init
git add .
git commit -m "message"

# Push vers GitHub
git remote add origin https://github.com/wissalelkouk/rappel.git
git push -u origin main
```

## 📊 Résultats Attendus

L'application doit afficher :
```
Compte{id=1, proprietaire='Alice', solde=1000.0}
Après dépôt de 500 : Compte{id=1, proprietaire='Alice', solde=1500.0}
Après retrait de 200 : Compte{id=1, proprietaire='Alice', solde=1300.0}
CompteEpargne{id=2, proprietaire='Bob', solde=2000.0, tauxInteret=3.5, interets=70.0}
Intérêts : 70.0
CompteDevise{id=3, proprietaire='Carol', solde=500.0 EUR}
Exception capturée : Le montant à retirer doit être positif.
```

## 🚀 Améliorations Futures

- [ ] Interface graphique (JavaFX/Swing)
- [ ] Authentification des utilisateurs
- [ ] Historique des transactions
- [ ] Conversion entre devises
- [ ] Tests unitaires (JUnit)
- [ ] Documentation API (Javadoc)

## 👤 Auteur

**Wissal El Kouk** - Développeur Java

## 📅 Date

25 Février 2026
