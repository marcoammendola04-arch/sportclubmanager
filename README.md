# SportClubManager

Sistema Java per la gestione di un circolo sportivo, realizzato nell'ambito dell'insegnamento di **Ingegneria del Software** presso l'Università degli Studi di Parma.

## Informazioni sul progetto

- **Autore:** Marco Ammendola
- **Corso di laurea:** Ingegneria delle Tecnologie Informatiche
- **Insegnamento:** Ingegneria del Software
- **Anno accademico:** 2025–2026
- **Linguaggio:** Java

## Descrizione

Il progetto implementa un sistema per la gestione di un circolo sportivo. Il modello comprende persone (soci e amministratori) e attività (gare e corsi), utilizzando ereditarietà e composizione.

## Struttura del progetto

- `it.unipr.sportclubmanager.model`: contiene le classi del dominio (`Person`, `Member`, `Administrator`, `Activity`, `Competition`, `Course`, `Club`) e le eccezioni.
- `it.unipr.sportclubmanager.simulation`: contiene `SportClubSimulation`, la classe con il metodo `main` che esegue la simulazione.

## Scelte progettuali

- **Ereditarietà:** `Person` è la classe astratta comune a `Member` e `Administrator`. `Administrator` estende `Member`, così da ereditare le operazioni disponibili ai soci. Analogamente, `Activity` è la classe astratta comune a `Competition` e `Course`.
- **Composizione:** `Club` gestisce le collezioni di persone e attività, mentre `Activity` gestisce i soci iscritti. Le collezioni vengono esposte tramite viste non modificabili e modificate attraverso metodi dedicati.
- **Collezioni:** viene utilizzato `LinkedHashSet` per evitare duplicati e mantenere l'ordine di inserimento.
- **Relazione socio-attività:** la relazione è monodirezionale; è l'attività a conoscere i propri iscritti.
- **Incapsulamento:** la password non è esposta tramite getter; la verifica avviene attraverso `checkPassword(String)`.
- **Gestione delle eccezioni:** sono definite quattro eccezioni per gestire condizioni di errore nelle operazioni di iscrizione, cancellazione e rimozione.

## Simulazione

La classe `SportClubSimulation` esegue una simulazione articolata in cinque fasi:

1. Creazione di un amministratore, soci e attività.
2. Gestione dei soci e delle attività da parte dell'amministratore.
3. Simulazione del login di un socio.
4. Iscrizione e cancellazione di iscrizioni alle attività.
5. Generazione del report finale.

Il log di un'esecuzione è disponibile in [`simulation_log.txt`](simulation_log.txt).

## Esecuzione

Importare il progetto in Eclipse come progetto Java ed eseguire la classe `SportClubSimulation` tramite il relativo metodo `main`.

Il file `simulation_log.txt` viene generato nella cartella principale del progetto.

## Documentazione

La documentazione Javadoc è inclusa nella cartella `doc/`.