# Introductie

Deze oefening is deel van de DEA Course aan de Hogeschool Arnhem/Nijmegen. Onderwerp is het bekend 
raken met het Http-protocol in een simpele Java-server.

Web servers, gebruikt op het internet zijn feitelijk server-software die voldoen aan het Http-protocol.
Het Http-protocol, zoals ook alle andere internet protocols, is gespecificeerd in een *Request for Comments* 
(RFC). De RFC voor Http kan hier gevonden worden: [https://tools.ietf.org/html/rfc7230](ttps://tools.ietf.org/html/rfc7230).

# Oefeningen
Bekijk de startcode in de master-branch. De server is op te starten via de main-methode van de `HttpServer`
klasse. Zorg ervoor dat je de startcode op een plaats (directory) zet waar geen spaties in voorkomen.

Voer de main-methode uit. De Server is nu opgestart. Navigeer via je browser naar [http://localhost:8383/index.html](http://localhost:8383/index.html) om te zien wat de server teruggeeft. Mocht je een Connection-error krijgen in de log van IntelliJ bij het gebruiken van Chrome, probeer dan Edge of Firefox te gebruiken. 

## 1) Afhandelen meerdere requests
Bekijk de startcode in de klasse `HttpServer` en probeer te begrijpen op welk moment de server wacht op Connecties van
een client. Gebruik Google met de zoektermen *java server socket* om je analyse te ondersteunen.

Wat opvalt is dat je Server momenteel maar één Http-request kan afhandelen. Pas dit aan zodat het mogelijk wordt 
om meerdere Http-requests af te handelen.

* Gebruik je kennis van multithreading om de `HttpServer` klasse zo aan te passen dat ieder Http-request op 
een eigen `Thread` wordt afgehandeld. 
* Pas de server zodanig aan dat de `Threads` in een oneindige lus worden opgestart. Op deze manier wordt de server 
niet meer afgesloten na een Http-request.

## 2) Correct afhandelen van het Http-request
Bekijk de klasse `ConnectionHandler`. Hierin kun je zien dat de server momenteel niks doet met de inhoud van het 
Http-request en altijd dezelfde inhoud en status retourneert. Je kunt dit testen door het wijzigen van een deel van 
URL in je browser. ook de URL [http://localhost:8383/what-a-terribly-bigoted-server.html](http://localhost:8383/what-a-terribly-bigoted-server.html) zal precies dezelfde content
retourneren. In dit onderdeel zul je dit gaan verbeteren.

### 2.1) Toevoegen van een _index.html_
De inhoud van de response staat nu nog hard-coded in de `ConnectionHandler`. We gaan deze inhoud verplaatsen naar een 
_index.html_, die we hierna zullen inlezen en retourneren via het response.

* Creëer de map _src/main/resources_. Dit is de default plaats binnen een Maven project om extra bestanden te plaatsen.
Hierbij kun je denken aan plaatjes, configuratiebestanden of html-bestanden.
* Voeg in deze nieuwe map een submap _pages/_ toe en plaats hierin een _index.html_ met de volgende content

```html
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Simple Http Server</title>
</head>
<body>
<h1>Hi DEA folks!</h1>
<p>This is a simple line in html.</p>
</body>
</html>
```

### 2.2) Retourneer _index.html_
Pas de `ConnectionHandler` zodanig aan dat voor de body van het HTTP-request de file _index.html_ wordt gebruikt.
* Gebruik voor het inlezen van een bestand de onderstaande methode. 
* Plaats deze in een aparte klasse genaamd `HtmlPageReader.
* Merk op dat onderstaande methode verwacht dat het html-bestand in de map _pages/_ staat.
* Gebruik deze methode om nu de inhoud van _index.html_ te retourneren. De constante `HTTP_BODY` uit `ConnectionHandler`
kun je nu verwijderen.

```java
public class HtmlPageReader {
    public String readFile(String filename) {
        var fullFileName = "pages/".concat(filename);
        try {
            ClassLoader classLoader = getClass().getClassLoader();

            var file = new File(classLoader.getResource(fullFileName).getFile()).toPath();

            var fileAsString = new String(Files.readAllBytes(file));

            return fileAsString;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```

### 2.3) Aanpassen _index.html_ en de Http-header
Voeg nu wat extra inhoud toe aan je _index.html_, herstart je server en bekijk het resultaat. De inhoud zal nu 
niet meer volledig gerenderd worden. Dit komt omdat de _content-length_ in de Http-header niet meer correct is.
* Voeg aan de klasse `HtmlPageReader` een methode toe die op de correcte _content-length_ kan bepalen van een 
gegeven bestand. Bekijk de [RFC](https://tools.ietf.org/html/rfc7230) om te begrijpen hoe de _content-length_ moeten worden berekend.
* Gebruik de nieuwe methode om programmatisch een correcte Http-header te genereren.

### 2.4) Toevoegen correcte datum in de Http-header
Voeg ook een automatisch bepaalde datum aan het _Date_ veld van de Http-header toe. Gebruik hierbij weer de [RFC](https://tools.ietf.org/html/rfc7230)
om te bepalen welk formaat deze moet hebben.

### 2.5) Retourneer van het correcte bestand
We gaan nu de afhandeling van de aangevraagde resource (bestand) verwerken. Merk op dat de Server nu altijd 
dezelfde _index.html_ teruggeeft, los van de url van het daarwerkelijke request. Voeg de functionaliteit toe die 
ervoor zorgt 

* De eerste regel van een Http-request, de start-line, bevat de Http-methode (in dit geval: GET), de _request-target_ 
(in dit geval het html-bestand) en de versie van het Http Protocol. Bekijk de [RFC](https://tools.ietf.org/html/rfc7230) voor meer informatie over de 
start-line.
* Zorg ervoor dat de `ConnectionHandler` van het Http-request, de start-line gebruikt om te achterhalen welke _html_ 
pagina geretourneert moet worden.
* Voeg een tweede pagina, bijvoorbeeld _about.html_ toe en test of deze geretourneert wordt door naar 
[http://localhost:8383/about.html]() te navigeren.
* Merk op dat het nu enkel mogelijk moet zijn bestaande pagina's op te vragen, de happy-flow. 

### 2.6) Afhandelen van niet-bestaande pagina's
Momenteel wordt nog standaard de Http statuscode 200 geretourneerd. Zorg ervoor dat de `ConnectionHandler` de een 
correcte statuscode retourneert indien de _request-target_ niet bestaat.

* Zorg ervoor dat de relevante methodes uit `HtmlPageReader` een _Exception_ gooien indien er een Html pagina geladen
moet worden die niet bestaat.
* Gebruik deze exceptie in de `ConnectionHandler` om zowel de juiste Http-Header, als Body te retourneren.

# Extra uitdaging
* Verbeter de foutafhandeling. Momenteel wordt enkel onderscheid gemaakt tussen 404 en 200. Voeg ook, op een correcte
en zinnig manier ondersteuning voor de colgende foutcode's toe:
    * 500 INTERNAL SERVER ERROR
    * 501 NOT IMPLEMENTED
    * 505 HTTP VERSION NOT SUPPORTED
    
* Het Http-protocol kent meer methodes dan enkel de *GET*. Lees de [RFC](https://tools.ietf.org/html/rfc7230) voor meer informatie en implementeer ook de
methode *HEAD*.









 


