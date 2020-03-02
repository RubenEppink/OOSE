# Introductie

Deze oefening is deel van de DEA Course aan de Hogeschool Arnhem/Nijmegen. 
Onderwerp is het bekend raken met de Lambda-expressies.

# Oefening

In deze oefening zal je een bestaande codebase moeten refactoren, waarbij uiteindelijk ook Lambda Expressies
zullen worden om de code nog leesbaarder te maken. Er zijn Unittests beschikbaar om te kunnen
verifieren dat de code nog steeds correct werkt. Na iedere refactor-slag zullen deze gerund moeten worden.

De oplossingen zijn als branch beschikbaar.

## 1 Magic Numbers
De huidige codebase bevat een Magic Number. Vervang deze door een constante. 

Run de Unittests om er zeker van te zijn dat alles nog werkt.

## 2 Remove Duplicate Code/Extract Method
Merk op dat de methodes `createMaleAdultList()` en `createFemaleAdultList()` uit `ListMaker` duplicate code bevatten. 
Deze code bevat feitelijk twee checks:

* Of een persoon ouder dan 18 is
* Of een persoon MALE/FEMALE is

Creëer voor beide checks een methode die de check uitvoert en roep deze aan vanuit `createMaleAdultList()` 
en  `createFemaleAdultList()`.

Run de Unittests om er zeker van te zijn dat alles nog werkt.

## 3 Move Method
Mogelijk heb je voorgaande twee methodes als private methodes toegevoegd aan de `ListMaker`. Dat is niet waar
ze thuishoren. Verplaats beide methodes naar de klasse waar ze thuishoren.

Run de Unittests om er zeker van te zijn dat alles nog werkt.

## 4 Remove Duplicate Code/Extract Method
Ondanks de verbeteringen bevatten `createMaleAdultList()` en `createFemaleAdultList()` nog
steeds duplicate code. Creëer een private methode, genaamd `createAdultList(List<Person> allPerson, Gender gender)`, die 
als tweede parameter de `Gender` krijgt waar een lijst voor gemaakt moet worden. Roep deze methode vervolgens vanuit
`createMaleAdultList()` en `createFemaleAdultList()` aan.

Run de Unittests om er zeker van te zijn dat alles nog werkt.

## 5 Gebruik van de forEach van de Stream API
De nieuwe methode `createAdultList()` bevat een for-loop. Vervang deze door gebruik te maken van de `forEach`  
van de Stream API. 

Run de Unittests om er zeker van te zijn dat alles nog werkt.

## 6 Toevoegen Lambda expressies voor de ouder dan 18 check
Merk op dat er nu twee checks:

* Of een persoon ouder dan 18 is
* Of een persoon `MALE`/`FEMALE` is

in de body van de `forEach` staan. Dat kan netter worden opgelost. Juist voor deze situatie heeft de Stream API
de `filter` methode. Deze methode heeft een `Predicate` als parameter, wat een Lambda-expressie is die een `boolean` 
retourneert. 

In dit onderdeel gaan we een Lambda-expressie maken die checked of een `Person` ouder dan 18 is. Deze passen we vervolgens
toe als een filter, waarmee we de `forEach` vervangen. Functioneel is het dan nog niet compleet (de tweede check ontbreekt nog) 
en ook de unittests zullen breken, maar dat wordt in de volgende oefening opgelost.

Creëer een `Predicate` die er als volgt uitziet:

``
    Predicate<Person> isAdult = (person) -> {/* Hier volgt de implementatie van de check */}
``

Deze `Predicate` is een gewone variabele en kun je toevoegen als `private` instantievariabele aan de `ListMaker` klasse.
Verwijder de `forEach` en gebruikt de Stream API met een filter (en de `isAdult` Lambda-expressie) en uiteindelijk de 
`Collectors.toList()` om een gefilterde lijst te maken die nu enkel `Person`-instanties bevat die ouder zijn dan 18.

## 7 Toevoegen Lambda expressies voor de MALE/FEMALE check
Gebruik de kennis van onderdeel 6 voor het maken van een `Predicate` die gebruikt kan worden om te bepalen of een `Person` `MALE`
of `FEMALE` is. Merk op dat deze wat lastiger gaat zijn, aangezien je in Oefening 4 de `Gender` als parameter hebt toegevoegd en
je daarmee eigenlijk twee parameters (de `Gender` en de `Person`) aan je `Predicate` moet meegeven. Dit staat de Interface van 
`Predicate` echter niet toe.

Er zijn dan ook verschillende manieren dit op te lossen. De enige eis hierbij is dat de Unittests blijven werken.
