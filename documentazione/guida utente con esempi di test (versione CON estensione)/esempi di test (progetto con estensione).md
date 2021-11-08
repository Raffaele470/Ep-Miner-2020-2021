# GUIDA UTENTE CON ESEMPI DI TEST _(versione con estensione)_


Una volta trovati nella schermata principale del programma si potrà visualizzare il menù dove si avrà la possibilità di selezionare diverse scelte: <p>
- _Nuova scoperta_
- _Ricerca in archivio_
- _Crediti_
- _Segnala un problema_
- _GitHub_

![MENU](img/menu.png)<p><br>

- _Nuova scoperta_: permette di effettuare una nuova ricerca in modo tale da trovare Pattern Frequenti e Pattern Emergenti sfruttando una tabella Target e una tabella Background.

- _Ricerca in archivio_: permette di effettuare una ricerca consultando file presenti su disco, in cui sono memorizzate le ricerche precedenti.

- _Crediti_: permette di visualizzare i crediti, mostrando gli autori del progetto e i vari dettagli.

- _Segnala un problema_: permette di visualizzare i contatti in modo tale da poter segnalare eventuali problemi.

- _GitHub_: permette di aprire il Browser e caricare la pagina della repository del progetto presente su GitHub.<p><br>


# _NUOVA SCOPERTA_

Per effettuare una nuova scoperta basterà cliccare sul bottone _"NUOVA SCOPERTA"_:<p>
![SELEZIONE](img/selezionenuovascoperta.png)<p><br>
Nella finestra successiva si ha la possibilità di inserire i vari input o di tornare indietro nel menù.<p>
![INSERIMENTO](img/inserimentocampi.png)<p>
Una volta inseriti i dati premendo _"CONFERMA"_ si ha la possibilità di visualizzare i risultati. Nel caso in cui i dati inseriti non dovessero rispettare i vincoli indicati o dovessero esserci campi vuoti, questi dati non saranno accettati. Ci sarà quindi bisogno di modificarli per proseguire.<p><br>

# _NUOVA SCOPERTA - CASI POSSIBILI_

## Caso 1) Nuova ricerca, Tabella Target e Background esistenti, pattern frequenti e emergenti ritrovati:

 <br>

- Dopo aver selezionato _"NUOVA SCOPERTA"_ dal menù:<p>
![SELEZIONE2](img/selezionenuovascoperta.png)<p><br>


- Inserire i dati all'interno dei rispettivi campi:<p>
![INSERIMENTO1](img/daticaso1.png)<p><br>

- Dopo aver cliccato su _"CONFERMA"_ si ottiene la stampa dei risultati: <p>
![RISULTATO1](img/risultatocaso1.png)<p><br>


## Caso 2) Nuova ricerca, Tabella Target e Background non esistenti, pattern frequenti ed emergenti non ritrovati:
<br>

- Dopo aver selezionato _"NUOVA SCOPERTA"_ dal menù:<p>
![SELEZIONE2](img/selezionenuovascoperta.png)<p><br>

- Inserire i dati all'interno dei rispettivi campi (indicando nel campo tabella Target e Background, due tabelle non esistenti):<p>
![SQLCODE](img/risultatocaso2.png)<p><br>

- Dopo aver cliccato su _"CONFERMA"_ si ottiene la stampa dei risultati (che in questo caso saranno due messaggi di errore, in quanto tabelle non esistenti e quindi _frequent pattern_ e _emerging pattern_ non sono state ritrovate): <p>
![RISULTATO](img/errore1.png)<p><br>


## Caso 3) Nuova ricerca, tabella Target e Background esistenti e invertite, pattern frequenti ed emergenti ritrovati
<br>

- Dopo aver selezionato _"NUOVA SCOPERTA"_ dal menù:<p>
![SELEZIONE](img/selezionenuovascoperta.png)<p><br>


- Inseriti i dati all'interno dei rispettivi campi (invertendo tabella target e tabella background):<p>
![SELEZIONE](img/inversione.png)<p><br>


- Dopo aver cliccato su _"CONFERMA"_ si ottiene la stampa dei risultati: <p>
![RISULTATO](img/risultatoinversione.png)<p><br>


# _RICERCA IN ARCHIVIO_

Per effettuare una ricerca nell' archivio così da consultare file presenti su disco, sfruttando ricerche effettuate precedentemente, cliccare sul bottone _"RICERCA IN ARCHIVIO"_.

![SELEZIONE](img/selezionericercaarchivio.png)<p><br>

Nella finestra successiva si ha la possibilità di inserire i vari input o di tornare indietro nel menù.<p>

![INSERIMENTO](img/inserimentocampi.png)<p>
Una volta inseriti i dati premendo _"CONFERMA"_ verranno visualizzati i risultati. Nel caso in cui i dati inseriti non dovessero rispettare i vincoli indicati o dovessero esserci campi vuoti, questi dati non saranno accettati. Quindi sarà necessario modificarli per proseguire.<p><br>


# _RICERCA IN ARCHIVIO - CASI POSSIBILI_





## Caso 1) Ricerca in archivio, Tabella Target e Background esistenti, pattern frequenti ed emergenti ritrovati:
<br>

- Dopo aver selezionato _RICERCA IN ARCHIVIO_ dal menù:<p>
![SELEZIONE](img/selezionericercaarchivio.png)<p><br>

- Inseriti i dati all'interno dei rispettivi campi:<p>
![INSERIMENTO](img/daticaso1.png)<p><br>


- Dopo aver cliccato su _"CONFERMA"_ si ottiene la stampa dei risultati: <p>
![RISULTATO](img/risultatocaso1.png)<p><br>

## Caso 2) Ricerca in archivio, Tabella Target non esistente e tabella Background non esistente, pattern frequenti ed emergenti non ritrovati:
<br>

- Dopo aver selezionato _RICERCA IN ARCHIVIO_ dal menù:<p>
![SELEZIONE](img/selezionericercaarchivio.png)<p><br>

- Inseriti i dati all'interno dei rispettivi campi (indicando nel campo tabella Target e Background, due tabelle non esistenti):<p>
![RISULTATO](img/risultatocaso2.png)<p><br>

- Dopo aver cliccato su _"CONFERMA"_ si ottiene la stampa dei risultati (che in questo caso saranno due messaggi di errore in quanto non sono stati trovati i file) <p>
![RISULTATO](img/errore1.png)<p><br>

## Caso 3) Ricerca in archivio, tabella Target e Background esistenti, pattern frequenti ritrovati e pattern emergenti non ritrovati
<br>

- Dopo aver selezionato _RICERCA IN ARCHIVIO_ dal menù:<p>
![SELEZIONE](img/selezionericercaarchivio.png)<p><br>

- Inseriti i dati all'interno dei rispettivi campi (indicando nel campo del grow rate un valore che non sia mai stato cercato):<p>
![INSERIMENTO](img/casogrowratetroppo.png)<p><br>

- Dopo aver cliccato su _"CONFERMA"_ si ottiene la stampa dei risultati (in questo caso avremo la stampa dei frequent pattern e il messaggio di errore per gli emerging pattern in quanto non trovati) <p>
![RISULTATO](img/frequenttrovatinoemerging.png)<p><br>


# _CREDITI_ 

Per visualizzare i crediti, e quindi per visualizzare chi ha contribuito al progetto e i dettagli di esso, basterà cliccare dal menù sulla voce _"CREDITI"_<p>
![CREDITI](img/crediti.png)<p><br>

Dopo aver cliccato, si otterrà la pagina relativa ai crediti:<p>
![RISULTATO](img/risultatocrediti.png)<p><br>


# _SEGNALA UN PROBLEMA_

Per visualizzare i contatti di coloro che hanno realizzato il progetto così da poter inviare una segnalazione basterà cliccare dal menù sulla voce _"SEGNALA UN PROBLEMA"_:<p>
![SEGNALA](img/segnalaproblema.png)<p><br>

Dopo aver cliccato, si otterrà la pagina per segnalare un problema:<p>
![RISULTATO](img/risultatosegnalazione.png)<p><br>


# _GITHUB_

Per aprire il browser e visualizzare la pagina di GitHub dove è presente la repository del progetto basterà semplicemente sulla voce _"GitHub"_ in basso a destra.<p>
![GITHUB](img/github.png)<p>

Dopodichè si aprirà il browser predefinito con la relativa pagina.<br>

---

# <br>_INFORMAZIONI UTILI_

Si ricorda che bisogna __prima__ avviare il main del __MultiServer__ (server/src/server/Multiserver) e successivamente il main di __HelloApplication__ _(gui/src/main/java/com.example.gui/HelloApplication)_<p><br>

Per uscire dall'applicazione basterà premere sulla _X_ in alto a destra.<p>

Questa è una guida realizzata per il progetto _"EP MINER"_ (versione con estensione).
L' obiettivo di questa guida è quella di fornire delle istruzioni chiare e precise per far si che l'utente possa utilizzare il sistema correttamente.<p>

Realizzato da: Raffaele Di Anna, Alessandro Carella, Alessandro Congedo.

---

Progetto: _EP MINER_ 2020-2021 Corso: Metodi Avanzati Di Programmazione




