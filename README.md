# IS-Project-2022(Mentcare System)
Progetto sviluppato da:

* Riccardo Bologna VR474721

* Luigi Hu VR474722
## Introduzione
Il progetto implementa un software di gestione di informazioni dei pazienti 
nell'ambito "Mental health care".

Si è deciso di sviluppare la componente del software utilizzata dall'utente "medico", 
tramite la quale potrà gestire le prescrizioni che fornirà ai pazienti a fine trattamento.
Si assume che le liste dei pazienti e trattamenti siano già presenti nel sistema 
in quanto gestite da altri componenti(clinica/reception). 

Il trattamento viene inteso come visita dal medico durante la quale si svolge una determinata terapia, mentre
la prescrizione viene intesa come ricetta contenente medicinali/consigli 
fornita al paziente a fine trattamento.

## Requisiti

Il sistema deve essere in grado di identificare il medico per permettergli di usare le funzionalità implementate.

Una volta verificata l'identità, il medico, tramite il sistema,
tiene traccia delle informazioni dei suoi pazienti, i relativi
trattamenti e prescrizioni mediche.

-Il medico può visualizzare la lista di tutti i suoi pazienti e, per ciascuno di essi, 
i relativi dati personali con lo storico delle loro prescrizioni.

-Il medico può visualizzare sia la lista di tutti i trattamenti(passati e futuri) 
che quella dei trattamenti previsti in giornata.

-Il medico può creare delle prescrizioni riguardanti un determinato trattamento.

-Il medico può visualizzare la lista di tutte le prescrizioni emesse 
e, per ciascuna di esse, può modificarla/eliminarla a seconda delle sue esigenze.

## Scenari
1. <ins>Log-in nel sistema</ins>:

   Fasi | Descrizioni
   ------ | ------
   Inizio scenario | il medico vuole accedere al sistema per usufruire dei servizi offerti. Per accedere al sistema deve inserire le proprio credenziali. Le credenziali sono state fornite in precedenza dai gestori del sistema.
   Uso corretto| Il medico accede correttamente al sistema se le credenziali da lui inserite sono corrette. Se le credenziali sono errate, il sistema richiede di inserire nuovamente le credenziali.
   Potenziali problemi | ---
   Altre attività | ---
   Fine scenario| Il medico ha effettuato correttamente l'accesso e può usufruire dei servizi offerti dal sistema.

2. <ins>Visualizza informazioni dei pazienti</ins>:

   Fasi | Descrizioni
   ------ | ------
   Inizio scenario | Il medico vuole visualizzare le informazioni dei suoi pazienti e deve aver già fatto l'accesso al sistema. 
   Uso corretto| Il medico schiaccia il bottone "*Patients*" per visualizzare la lista di tutti i suoi pazienti. Inoltre può visualizzare in dettaglio le informazioni di un determinato paziente e le relative prescrizioni cliccando il link "*Show infos*" presente accanto ad ogni paziente.
   Potenziali problemi | La lista visualizzata potrebbe non essere aggiornata se, durante la visualizzazione, avvengono modifiche al database. Tale problema viene risolto aggiornando la pagina.
   Altre attività | Sono presenti dei bottoni che permettono la navigazione tra le pagine.
   Fine scenario| Il medico visualizza tutte le informazioni dei suoi pazienti.

3. <ins>Visualizza lista dei trattamenti</ins>:

   Fasi | Descrizioni
   ------ | ------
   Inizio scenario | Il medico vuole visualizzare la lista dei trattamenti dei suoi pazienti e deve aver già fatto l'accesso al sistema.
   Uso corretto| Il medico schiaccia il bottone "*Treatments*" per visualizzare la lista di tutti i trattamenti. Inoltre può visualizzare la lista dei trattamenti giornalieri tramite il bottone "*Show today's treatments*".
   Potenziali problemi | La lista visualizzata potrebbe non essere aggiornata se, durante la visualizzazione, avvengono modifiche al database. Tale problema viene risolto aggiornando la pagina.
   Altre attività | Sono presenti dei bottoni che permettono la navigazione tra le pagine.
   Fine scenario| Il medico visualizza la lista completa/giornaliera dei trattamenti dei suoi pazienti.

4. <ins>Visualizza lista delle prescrizioni</ins>:

   Fasi | Descrizioni
   ------ | ------
   Inizio scenario | Il medico vuole visualizzare la lista delle prescrizioni dei suoi pazienti e deve aver già fatto l'accesso al sistema.
   Uso corretto| Il medico schiaccia il bottone "*Prescriptions*" per visualizzare la lista di tutte le prescrizioni.
   Potenziali problemi | La lista visualizzata potrebbe non essere aggiornata se, durante la visualizzazione, avvengono modifiche al database. Tale problema viene risolto aggiornando la pagina.
   Altre attività | Sono presenti dei bottoni che permettono la navigazione tra le pagine.
   Fine scenario| Il medico visualizza la lista delle prescrizioni fornite ai suoi pazienti.

5. <ins>Creazione prescrizione</ins>:

   Fasi | Descrizioni
   ------ | ------
   Inizio scenario | Il medico vuole creare una prescrizione a un suo paziente e deve aver già fatto l'accesso al sistema.
   Uso corretto| Visualizzando la lista dei trattamenti(totali o giornalieri), il medico può creare una prescrizione cliccando al link "*New prescription*" presente accanto ad ogni trattamento. Una volta cliccato il link, il medico deve inserire i dati della prescrizione(medicinali/suggerimenti) e confermare la creazione tramite il bottone "*Send Request*".
   Potenziali problemi | ----
   Altre attività | Sono presenti dei bottoni che permettono la navigazione tra le pagine.
   Fine scenario| Il medico crea correttamente la prescrizione al suo paziente e viene, poi, indirizzato alla lista delle prescrizioni in modo da poterla visualizzare.
   
6. <ins>Modifica prescrizione</ins>: 

   Fasi | Descrizioni
   ------ | ------
   Inizio scenario | Il medico vuole modificare una prescrizione fatta a un suo paziente e deve aver già fatto l'accesso al sistema.
   Uso corretto| Visualizzando la lista delle prescrizioni il medico può modificarle cliccando al link "*Edit*" presente accanto a ciascuna di esse. Una volta cliccato il link, il medico può modificare i dati della prescrizione e confermare la modifica tramite il bottone "*Send Request*".
   Potenziali problemi | ----
   Altre attività | Sono presenti dei bottoni che permettono la navigazione tra le pagine.
   Fine scenario| Il medico modifica correttamente la prescrizione del suo paziente e viene, poi, indirizzato alla lista delle prescrizioni in modo da poter controllare il cambiamento.

7. <ins>Elimina prescrizione</ins>: 

   Fasi | Descrizioni
   ------ | ------
   Inizio scenario | Il medico vuole eliminare una prescrizione fatta a un suo paziente e deve aver già fatto l'accesso al sistema.
   Uso corretto| Durante la visualizzazione della lista delle prescrizioni il medico può eliminarne una cliccando al link "*Delete*" presente accanto a ciascuna di esse. Una volta cliccato il link, la prescrizione viene rimossa.
   Potenziali problemi | ----
   Altre attività | Sono presenti dei bottoni che permettono la navigazione tra le pagine.
   Fine scenario| Il medico elimina correttamente la prescrizione del suo paziente.

## Unit tests

Gli "*unit tests*" sono stati effettuati sulle classi che compongono il sistema:

1.<ins>Paziente</ins>:
* "*TestPatient*": Si è testato che tutti i metodi della classe "Patient" funzionino correttamente.

2.<ins>Prescrizione</ins>:
* "*TestPrescription*": Si è testato che tutti i metodi della classe "Prescription" funzionino correttamente.
* "*TestPrescriptionWithPatientAndTreatment*": Si è testato che tutti i metodi della classe "PrescriptionWithPatientAndTreatment" funzionino correttamente.

3.<ins>Trattamento</ins>:
* "*TestTreatment*": Si è testato che tutti i metodi della classe "Treatment" funzionino correttamente.
* "*TestTreatmentWithPatient*": Si è testato che tutti i metodi della classe "TreatmentWithPatient" funzionino correttamente.

Il coverage degli "*unit tests*" risulta essere:

![coverage](./images/coverage1.png)
## Acceptance tests

Gli "*acceptance tests*" sono stati implementati in selenium usando il metodo dei PageObject per facilitarne la comprensione.
Sono stati implementati casi di test per ogni scenario per verificare che tutte le funzionalità sviluppate 
funzionino correttamente.

I casi di test da noi implementati sono:

1.<ins>Log-in nel sistema</ins>:
* "*TestValidLogin*": Si è testato un accesso valido al sistema tramite l'inserimento 
di credenziali corrette (Username: admin, Password: admin). 
* "*TestInvalidLogin*": Si è testato un accesso invalido al sistema tramite l'inserimento
  di credenziali errate seguito da un accesso valido con inserimento di credenziali corrette. 

2.<ins>Visualizza informazioni dei pazienti</ins>: 
* "*TestHomePatientsButton*": Dopo aver effettuato il log-in, si è testato il corretto indirizzamento alla lista
dei pazienti.
* "*TestShowInfoPatients*": Oltre alle verifiche del precedente test, si è testata la corretta 
visualizzazione della lista dei pazienti. Inoltre si è verificata la corretta visualizzazione 
dei dati del primo paziente.

3.<ins>Visualizza lista dei trattamenti</ins>:
* "*TestHomeTreatmentsButton*": Dopo aver effettuato il log-in, si è testato il corretto indirizzamento alla lista
  dei trattamenti.
* "*TestShowTreatments*": Oltre alle verifiche del precedente test, si è testata la corretta
  visualizzazione della lista completa dei trattamenti.
* "*TestShowDailyTreatments*": Oltre alle verifiche effettuate nel precedente test, si è testato il corretto
indirizzamento e visualizzazione della lista dei trattamenti previsti in giornata.

4.<ins>Visualizza lista delle prescrizioni</ins>:
* "*TestHomePrescritionsButton*": Dopo aver effettuato il log-in, si è testato il corretto indirizzamento alla lista
   delle prescrizioni.

5.<ins>Creazione prescrizione</ins>:
* "*TestCreatePrescriptionsByTreatmentsList*": Dopo aver verificato la visualizzazione della lista completa 
dei trattamenti, si è testata la corretta creazione di una prescrizione relativa al primo trattamento della lista.
* "*TestCreatePrescriptionsByDailyTreatmentsList*": Dopo aver verificato la visualizzazione della lista dei trattamenti
previsti in giornata, si è testata la corretta creazione di una prescrizione relativa al primo trattamento della lista.

6.<ins>Modifica prescrizione</ins>:
* "*TestEditPrescription*": Dopo aver verificato la corretta visualizzazione della lista delle prescrizioni, 
si è testata una modifica alla prima di esse.

7.<ins>Elimina prescrizione</ins>:
* "*TestDeletePrescription*":  Dopo aver verificato la corretta visualizzazione della lista delle prescrizioni,
  si è testata la corretta eliminazione del primo record.

In tutti i casi di test si è verificata la corretta navigazione tra le pagine tramite l'uso dei bottoni/link.

Tutti i test passano con successo se eseguiti singolarmente. Al contrario, se eseguiti tutti insieme in blocco,
alcuni test falliscono in quanto, modificando la repository, creano inconsistenze con gli altri. 

Il coverage degli "*acceptance tests*" risulta essere:

![coverage](./images/coverage.png)

Il coverage testing dei metodi dell'AppController risulta essere dell'80% a causa del problema sopra citato.


