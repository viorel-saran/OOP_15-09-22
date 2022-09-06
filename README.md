# TicketMasterEventsApp

## Indice
1. [Introduzione](#Introduzione)
2. [UML](#UML)
3. [Rotte](#Rotte)
4. [Test](#Test)
5. [Autori](#Autori)

## Introduzione
L'applicazione TicketMasterEventsApp permette all'utente di filtrare e vedere statistiche su eventi situati in europa.  
Nell'uso dell'applicazione si ricorre all'utilizzo di rotte che consentono la visualizzazione di statistiche e la filtrazione degli eventi scaricati dall'api di Ticketmaster.
Alla chiamata di qualsiasi rotta vengono scaricati i primi 200 eventi per ogni stato europeo presente nell'api sui quali vengono calcolate le statistiche e applicati i filtri per genere, paese o entrambi.

## UML
#### Diagramma dei casi d'uso
![UML Diagramma dei casi d'uso]()

#### Diagramma delle classi
![UML Diagramma delle classi TicketMaster]()

###### Package model
![Diagramma delle classi package model]()

###### Package service
![Diagramma delle classi package service]()

###### Package utils
![Diagramma delle classi package utils stats filter]()

###### Package controller
![Diagramma delle classi package controller]()

###### Package exception
![Diagramma delle classi package exception]()


#### Diagramma delle sequenze
###### /StatsEvents
![Diagramma delle sequenze Promoter]()

###### /FilterByCountry/{paese}
![Diagramma delle sequenze statsReg]()

###### /FilterByGenre/{genere}
![Diagramma delle sequenze statsPromoter]()

###### /FilterByGenreAndCountry
![Diagramma delle sequenze statsPromoter]()

## Rotte
L'utente può effettuare le richieste tramite Postman al seguente indirizzo
```
localhost:8080
```
Le rotte disponibili sono le seguenti:

N° | Tipo | Rotta | Descrizione
----- | ------------ | -------------------- | ----------------------
[1](#1) | ` GET ` | `/StatsEvents` | *restituisce un JSONArray composto da JSONObject al cui interno viene specificato: 1. numero totale di eventi scaricati; 2.  numero di eventi raggruppati per genere; 3. numero minimo/massimo/medio di eventi mensili.*
[2](#2) | ` GET ` | `/FilterByCountry/{paese}` | *restituisce un JSONArray con all'interno gli eventi filtrati per paese e convertiti in JSONObject. In particolare ritorna gli attributi degli oggetti istanziati che sono: 1. nome dell'evento; 2. genere; 3. data dell'evento; 4. paese dell'evento; 5. countryCode.*
[3](#3) | ` GET ` | `FilterByGenre/{genere}` | *restituisce un JSONArray con all'interno gli eventi filtrati per genere e convertiti in JSONObject.*
[4](#4) | ` POST ` | `/FilterByGenreAndCountry` | *restituisce un JSONArray con all'interno gli eventi filtrati per genere e paese e poi convertiti in JSONObject, ma filtrate attraverso dei parametri specificati dall'utente nel body della richiesta.*

### 1. GET /StatsEvents
Questa rotta restituisce statistiche per numero totale di eventi scaricati, numero di eventi raggruppati per genere e numero minimo/massimo/medio di eventi mensili.

#### Esempio risultato chiamata su postman
![Rotta StatsEvents (1)]( )


### 2. GET /FilterByCountry/{paese}
Restituisce gli eventi per il paese inserito nella rotta.

#### Eccezioni che può generare la chiamata

-Nel caso in cui l'utente dovesse inserire un paese tale per cui non ci sono eventi, viene lanciata l'eccezione ***NoEventsFoundException*** che stampa il seguente messaggio:

```
Errore:
Nessuno evento trovato per parametro di ricerca...
```

- Nel caso in cui l'utente dovesse inserire un paese errato o non presente nella lista degli stati europei permessi dall'api, viene lanciata l'eccezione ***NoCountryFoundException*** che stampa il seguente messaggio:
```
Errore:
E' necessario inserire un paese europeo valido in lingua italiana...
```


#### Risultato chiamata su Postman
![response rotta FilterByCountry/{paese}]()


### 3. GET /FilterByGenre/{genere}
Restituisce gli eventi per il genere inserito nella rotta.

#### Eccezioni che può generare la chiamata

-Nel caso in cui l'utente dovesse inserire un genere tale per cui non ci sono eventi, viene lanciata l'eccezione ***NoEventsFoundException*** che stampa il seguente messaggio:
```
Errore:
Nessuno evento trovato per parametro di ricerca...
```

- Nel caso in cui l'utente dovesse inserire un genere errato, viene lanciata l'eccezione ***NoGenreFoundException*** che stampa il seguente messaggio:
```
Errore:
I generi consentiti sono: 

film,
arte,
teatro,
sport,
musica,
arte e teatro,
altro
```                                                                       

#### Risultato chiamata su postman
![Rotta FilterByGenre/{genere}]()

### 4. POST /FilterByGenreAndCountry
Questa è una chiamata di tipo **POST**, che restituisce gli eventi filtrati per genere e paese, passando come **parametri il genere e il paese** nel body.

#### Modello del Body
```
{
       "filtri": [
        {
            "genere": "arte",
            "paese": "italia"
        },
        {
            "genere": "musica",
            "paese": "francia"
        },
    ]
}
```

#### Risultato chiamata su postman
![Rotta FilterByGenreAndCountry]()

#### Eccezioni che può generare la chiamata

-Nel caso in cui l'utente dovesse inserire filtri tale per cui non ci sono eventi, viene lanciata l'eccezione ***NoEventsFoundException*** che stampa il seguente messaggio:
```
Errore:
Nessuno evento trovato per parametro di ricerca...
```

- Nel caso in cui l'utente dovesse inserire un genere errato, viene lanciata l'eccezione ***NoGenreFoundException*** che stampa il seguente messaggio:
```
Errore:
I generi consentiti sono: 

film,
arte,
teatro,
sport,
musica,
arte e teatro,
altro
```   

- Nel caso in cui l'utente dovesse inserire un paese errato o non presente nella lista degli stati europei permessi dall'api, viene lanciata l'eccezione ***NoCountryFoundException*** che stampa il seguente messaggio:
```
Errore:
E' necessario inserire un paese europeo valido in lingua italiana...
```

 - Se l'utente dovesse inserire un body vuoto, viene fatta partire l'eccezione ***NoBodyException***, con il seguente messaggio:
```
Errore:
 E' necessario inserire un body valido nella richiesta:
 {
    "filtri":[
        {
            "paese": "italia"
            "genere": "musica"
        },
        {
            "paese": "germania"
            "genere": "arte"
        },
    ]
}
```

 - Se l'utente dovesse inserire un body con uno o piu' paramentri mancanti viene fatta partire l'eccezione ***EmptyFieldException***, con il seguente messaggio:
```
Errore:
 mancanza del parametro (parametro mancante) nel body della richiesta.
 Si richiede di compilare il body come di seguito:
 {
    "filtri":[
        {
            "paese": "italia"
            "genere": "musica"
        },
        {
            "paese": "germania"
            "genere": "arte"
        },
    ]
}
```

## Test

>Nel programma vengono effettuati i seguenti test:
                             
-**Test 1**
Verifica che l'eccezione NoGenreFoundException sia lanciata correttamente

-**Test 2**
Verifica che l'eccezione NoCountryFoundException sia lanciata correttamente

-**Test 3**
Verifica che l'eccezione NoEventsFoundException sia lanciata correttamente

-**Test 4**
Verifica se il download dei dati ed istanziamento di questi non da esito nullo


## Autori
Il progetto è stato realizzato da:
1. Luca Marziliano
2. Viorel Saran

Entrambi hanno contribuito al 50% ciascuno nella realizzazione di questo progetto.
