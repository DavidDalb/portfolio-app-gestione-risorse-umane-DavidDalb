Applicazione di Gestione Risorse Umane (HR)
-------------------------------------------------------------------

Questo progetto è un'applicazione web dimostrativa per la gestione del personale, realizzata con un architettura Spring Boot completa.

L'applicazione dimostra la gestione delle operazioni essenziali: Creazione, Lettura e Eliminazione (C-R-D).
N.B* La funzionalità Modifica (Update) è stata intenzionalmente omessa
in questa versione per concentrarsi sulla prossima fase di implementazione pianificata.

 Note sul Progetto:
L'applicazione è configurata per la testabilità immediata (Zero Setup) e per una facile espansione:

Database Autonomo: Utilizzo di H2 in-memory. Non è richiesta alcuna installazione o configurazione di database esterni.

Caricamento Dati: I dati di test vengono popolati automaticamente all'avvio dell'applicazione tramite CommandLineRunner.

Architettura Modulare: La struttura a Controller, Service e Repository è predisposta per l'aggiunta di nuove funzionalità, inclusa la logica di Update.


Stack Tecnologico
--------------------------------------------------------------------
Il progetto è costruito utilizzando il seguente stack:

Backend Framework: Spring Boot (per l'avvio e la configurazione rapida) e Spring MVC (per la gestione delle richieste web).

Linguaggio: Java.

Persistenza: Spring Data JPA e Hibernate (ORM) per la mappatura e la gestione dei dati.

Frontend: HTML5 e Thymeleaf (per il rendering dinamico delle viste).

Database: H2 Database (in-memory) per la testabilità immediata.
N.B* Il progetto è stato originariamente sviluppato su ambiente MySQL e adattato in fine 
(per testabilità rapida) su H2.

Come Avviare e Testare 
-------------------------------------------------------------------

L'applicazione è pronta per l'esecuzione in un solo passaggio.

1. Clona il Repository:
- git clone https://github.com/DavidDalb/portfolio-app-gestione-risorse-umane-DavidDalb.git
- Avvia il metodo main nella classe PortFolioAppGestioneRisorseUmaneApplication dal tuo IDE.

2. Test Funzionali (C-R-D) ('U' in futuri update)
- Apri il browser a: http://localhost:8080/dipendenti/
La pagina iniziale mostrerà i dipendenti precaricati.

Esegui le Operazioni C-R-D:

Crea: Aggiungi un nuovo dipendente.

Elimina: Rimuovi un dipendente

Visualizza dettagli: visualizza dati del dipendente selezionato

Possibilità di spostarsi in:
Lista dipartimenti: visualizza lista dipartimenti

N.B* Operazioni C-R-D Disponibili anche per i dipartimenti.

-------------------------------------------------------------------

- Dettagli Tecnici:
Database Attivo: H2
L'applicazione utilizza H2 in-memory.

Per ispezionare il database H2 (opzionale):

Vai a: http://localhost:8080/h2-console

Connettiti:

JDBC URL: jdbc:h2:mem:hr_db

User: sa

Password: password
