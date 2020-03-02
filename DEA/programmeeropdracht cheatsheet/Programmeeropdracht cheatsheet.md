# Programmeeropdracht cheatsheet

 ![Afbeeldingsresultaat voor afkijken](https://lh3.googleusercontent.com/proxy/mCJmCZ670sgwPTnC53Y1sZR1NKdb_WIOS-5U9MMUldjw8EaUoReYIHDdP22RK2Be_iQL1XmjuImQpuKqSBONULpGul3q_zo9ULp0QBkAV0q7GgOO5ZUI4euZwD8kORxevanw7ClAO-s8QknmCI0i) 

# Algemeen

Lees het document globaal door voor de toets, om maximaal gebruik te maken.

Dit is in één keer uit de losse pols geschreven dus aub niet haten op eventuele fouten. 

Overweeg om een donatie te doen aan stichting ESD_Herkansers door je beroepsproduct te mailen naar ruben_eppink@live.nl

# 1. Maven

## 1.1 Project aanmaken met Maven

1. open command prompt
2. Navigeer naar de map waar je het project wil aanmaken door bijvoorbeeld in je command prompt het volgende te typen: `cd C:\Users\Admin\Documents\OOSE\DEA` 
3. Voer het onderstaande commando uit 

```html
mvn archetype:generate -DgroupId=ica.han.oose.dea -DartifactId=multithreading-opdracht -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```



**Belangrijk om te weten:** 

1. alles moet op de zelfde regel uitgevoerd worden in je command prompt, doe er dus geen enters tussen, dan ga je problemen krijgen. 
2. `-DgroupId=` Vul hier een relevante naam in die overeenkomt met de java package naming conventions. Dit is **NIET** je projectnaam. Gebruik geen hoofdletters.
3. `-DartifactId=` Vul hier je projectnaam in 
4. Laat de rest zoals het is.



## 1.2 Pom.xml

1. Ga naar je de map waar je het project zojuist hebt aangemaakt.

2. open je project door te dubbelklikken op het bestand genaamd `pom`, dit is een xml bestand. Dit is zeer belangrijk, hiermee configureert Intellij automatisch voor jou de hele project structuur. 

   ![image-20200218173108576](.\pom.png)

3. Wacht tot Intellij klaar is met opzetten van de project structuur en open daarna je pom bestand 

   ![image-20200218173108576](.\pom in intellij.png)

4. Vervang jou gehele pom bestand met het volgende: 

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   
   <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
     <modelVersion>4.0.0</modelVersion>
   
     <groupId>ica.han.oose.dea</groupId>
     <artifactId>programmeerOpdrachtVoorbeelden</artifactId>
     <version>1.0-SNAPSHOT</version>
   
     <name>programmeerOpdrachtVoorbeelden</name>
     <!-- FIXME change it to the project's website -->
     <url>http://www.example.com</url>
   
     <properties>
       <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
       <maven.compiler.source>13</maven.compiler.source>
       <maven.compiler.target>13</maven.compiler.target>
     </properties>
   
     <dependencies>
       <dependency>
         <groupId>org.junit.jupiter</groupId>
         <artifactId>junit-jupiter-api</artifactId>
         <version>5.6.0</version>
         <scope>test</scope>
       </dependency>
       <dependency>
         <groupId>org.junit.jupiter</groupId>
         <artifactId>junit-jupiter-engine</artifactId>
         <version>5.6.0</version>
         <scope>test</scope>
       </dependency>
     </dependencies>
   
     <build>
       <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
         <plugins>
           <plugin>
             <artifactId>maven-surefire-plugin</artifactId>
             <version>2.22.2</version>
           </plugin>
           <plugin>
             <artifactId>maven-failsafe-plugin</artifactId>
             <version>2.22.2</version>
           </plugin>
           <!-- clean lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle -->
           <plugin>
             <artifactId>maven-clean-plugin</artifactId>
             <version>3.1.0</version>
           </plugin>
           <!-- default lifecycle, jar packaging: see https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
           <plugin>
             <artifactId>maven-resources-plugin</artifactId>
             <version>3.0.2</version>
           </plugin>
           <plugin>
             <artifactId>maven-compiler-plugin</artifactId>
             <version>3.8.0</version>
           </plugin>
           <plugin>
             <artifactId>maven-surefire-plugin</artifactId>
             <version>2.22.1</version>
           </plugin>
           <plugin>
             <artifactId>maven-jar-plugin</artifactId>
             <version>3.0.2</version>
           </plugin>
           <plugin>
             <artifactId>maven-install-plugin</artifactId>
             <version>2.5.2</version>
           </plugin>
           <plugin>
             <artifactId>maven-deploy-plugin</artifactId>
             <version>2.8.2</version>
           </plugin>
           <!-- site lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#site_Lifecycle -->
           <plugin>
             <artifactId>maven-site-plugin</artifactId>
             <version>3.7.1</version>
           </plugin>
           <plugin>
             <artifactId>maven-project-info-reports-plugin</artifactId>
             <version>3.0.0</version>
           </plugin>
         </plugins>
       </pluginManagement>
     </build>
   </project>
   
   ```

   Ik heb hier de afhankelijkheid voor de laatste versie van JUnit aan toegevoegd samen met de maven surefire plugin. Mochten ze vragen om nog andere dependencies toe te voegen, zie dan H1.3. 

5. Intellij zal nu rechts onder in je scherm vragen om de wijzigingen te importeren. Je krijgt nu ook de optie 'Enable auto-import', doe dit. 

   ![image-20200218173108576](.\maven auto import.png)



**Belangrijk om te weten:**

1. In je pom bestand kan je de Java versie instellen voor de compiler, ik gebruik hier de laatste versie, namelijk 13.

   ```xml
     <properties>
       <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
       <maven.compiler.source>13</maven.compiler.source>
       <maven.compiler.target>13</maven.compiler.target>
     </properties>
   ```

   Het is erg belangrijk dat jij zowel in je pom, als in je projectinstelling aangeeft dat je één en dezelfde versie gebruikt. 

   druk op ```Ctrl + alt + s ``` en navigeer naar java compiler (Zie onderstaande afbeelding). 

![image-20200218173108576](.\java compiler.png)

Zet de java compiler naar de versie die jij hebt ingesteld in je pom bestand 

![image-20200218173108576](.\java compiler2.png)

Klik vervolgens op ```ctrl + alt + shift + s``` en navigeer naar project

Stel hier je SDK in op de hoogste versie die voor jou beschikbaar is, minimaal 1.8 (java 8), maar liever 10 of hoger. Zorg dat dit ook overeenkomt met de compiler en je pom bestand. 

![image-20200218173108576](.\project sdk.png)

Dit voorkomt een aantal foutmeldingen die erg vervelend kunnen zijn tijdens de toets. 



## 1.3 Maven dependency toevoegen 

Als je een Maven dependency moet toevoegen op de toets die nog niet in je pom bestand staat, zoals de "common-maths" library, doe dan het volgende:

1. Ga naar google.

2. google op welke library je wil hebben gevolgd door "maven dependency", dus bijvoorbeeld "common maths maven dependency".

3. klik op een link die geschikt lijkt.

4. Waarschijnlijk zie je dan iets in de richting van het volgende: 

   ```xml
   <dependency>
       <groupId>org.apache.commons</groupId>
       <artifactId>commons-math3</artifactId>
       <version>3.2</version>
   </dependency>
   ```

5. Kopieer dit en ga terug naar je pom bestand in Intellij.

6. Plaats het volgende blokje tussen de dependencies die er al in staan.

   **Voor:**  

   ```xml
     <dependencies>
       <dependency>
         <groupId>org.junit.jupiter</groupId>
         <artifactId>junit-jupiter-api</artifactId>
         <version>5.6.0</version>
         <scope>test</scope>
       </dependency>
       <dependency>
         <groupId>org.junit.jupiter</groupId>
         <artifactId>junit-jupiter-engine</artifactId>
         <version>5.6.0</version>
         <scope>test</scope>
       </dependency>
     </dependencies>
   ```

   **Na:**

   ```xml
     <dependencies>	
       <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-math3</artifactId>
        <version>3.2</version>
       </dependency>
       <dependency>
         <groupId>org.junit.jupiter</groupId>
         <artifactId>junit-jupiter-api</artifactId>
         <version>5.6.0</version>
         <scope>test</scope>
       </dependency>
       <dependency>
         <groupId>org.junit.jupiter</groupId>
         <artifactId>junit-jupiter-engine</artifactId>
         <version>5.6.0</version>
         <scope>test</scope>
       </dependency>
     </dependencies>
   ```

   Plaats ze dus **tussen** de dependencies tags:

   ```xml
   <dependencies>
       Hier tussen in plakken
   </dependencies>
   ```

## 1.4 Maven lifecycles

Als ze vragen dat je iets doet op de command line met Maven, doe het dan gewoon in Intellij. 

1. klik op het tabje Maven aan de rechterkant van je scherm

   ![image-20200218173108576](.\lifecycles.png)

Dit zal een scherm uitklappen waar je al de lifecycles van Maven ziet. Voer de gewenste lifecycle uit. Dit zal waarschijnlijk compile of test zijn.

2. Mochten ze vragen naar de command line uitvoering hier van gebruik dan het volgende format:

   ```html
   mvn "Hier naam van lifecycle"
   ```

# 2. Unit testen

Unit testen is het testen van één methode van één klasse. Integratie testen is het testen van meerdere modules die in verband staan met elkaar.

Bij het gebruik van JUnit maak je voor elke klasse die je wil testen een aparte klasse aan in de test folder. Zorg dat je mappenstructuur hetzelfde is als die van je normale klasse daarboven. Noem ze hetzelfde als de klasse, maar dan met het woord test ervoor of erachter.

![image-20200218173108576](.\mappenstructuur.png)

Mocht er tijdens het maken van een test een rood streepje onder klasse komen, druk dan op `alt + enter` wanneer je op het woord staat, het gaat dan vaak om iets wat je moet importeren. klik op `import class` en Intellij zal het dan automatisch voor jou oplossen. Dit geldt ook voor andere moment buiten het testen om. 

![image-20200218173108576](.\altenter.png)

## 2.1 JUnit algemeen

Bij het opzetten van een unit test is het belangrijk om de AAA methode aan te houden:

Arrange
Act
Assert

Met JUnit doen we dit zo:

**Arrange**

```java
public class FizzBuzzExecutorTest {
    //declareer hier je System Under Test (sut), dit is onderdeel van Arrange
    private FizzBuzzExecutor sut;

 /*@BeforeEach is zeer belangrijk, anders zal de setup en je test niet werken. 
 in de setup initialiseer je de waarde die je hier boven al had gedeclareerd. Dit is ook nog onderdeel van Arrange.
  */
    @BeforeEach
    void setup() {
        sut = new FizzBuzzExecutor();
    }
   
```

**Act en Assert** 

```java
 	//Zet boven elke test de @Test annotatie, anders weet de compiler niet dat 		het om een test gaat en zal hij hem ook niet uitvoeren.
	@Test
    void executeWithValidIntTest() {
        
//Act. Hier voer je vaak een methode uit op het object dat je in de arrange hebt geinstantieerd. die returnt iets, dit stop je in een variabele.
        String testValue = sut.execute(37);
        
//Assert. Vervolgens test je of de uitkomst van de methode gelijk is aan wat je had verwacht door bijvoorbeeld een assertEquals uit te voeren. assertEquals(actualValue, testValue)
        
        Assertions.assertEquals("37", testValue);
    }
```



## 2.2 JUnit exception test voorbeeld (assertThrows)

Misschien krijg je de vraag om een exceptie te testen met JUnit, hou dan het volgende voorbeeld aan. 

In het eerste gedeelte van de `assertThrows` geef je de naam van de klasse met daarachter `.class`. In het tweede gedeelte voer je de methode (geef eventueel parameters mee) uit die deze foutmelding zou moeten geven. 

```java
@Test
void testExpectedException() {
 //act en arrange in één
  Assertions.assertThrows(NumberFormatException.class, () -> {
    Integer.parseInt("One");
  });
}
```

## 2.3 JUnit assertTrue

Bij het testen van een methode die true of false terug geeft, dan gebruik je `assertTrue` of `assertFalse `. Zie de volgende voorbeelden:

```java
public class MyAssertTrueTest {
 //methode die kijkt of een getal even is. Geeft true terug als dat zo is.
    // dit staat normaal in een eigen klasse.
    public boolean isEvenNumber(int number){
         
        boolean result = false;
        if(number%2 == 0){
            result = true;
        }
        return result;
    }
     
    //de test om te kijken of een nummer even is met assertTrue
    @Test
    public void evenNumberTest(){
        MyAssertTrueTest asft = new MyAssertTrueTest();
        assertTrue(asft.isEvenNumber(4));
    }
}
```



Je kan dat ook gebruiken maar dan met `assertFalse`, waarbij je verwacht dat de uitkomst false is en de test dus alleen zal slagen als de uitkomst false is. 



# 3. Exceptions 

![image-20200218173108576](.\exception.jpg)

Dit is de overervingsstructuur van de exceptions in Java. Runtime exceptions zijn exceptions die niet door de compiler aangegeven worden voor het uitvoeren van je programma. Checked exceptions worden wel door je compiler aangegeven voor dat je het programma uitvoert en zal je dit moeten oplossen met een try/catch. 

## 3.1 Zelf een checked exception maken

1. Maak een nieuwe klasse aan binnen een relevante package.

2. geef hem een gepaste naam voor de foutmelding die hij moet geven.

3. extend vervolgens Exception.

4. Geef vervolgens, in de constructor, de foutmelding in de vorm van een String mee aan de `super`, in dit geval `Exception`. 

   ```java
   //zelf gemaakte exceptie die Exception extends
   public class OuchIFoundThirtySevenAndHenceMustDieException extends Exception {
   
       //Constructor waar de meegegeven foutmelding in de vorm van een string ook weer wordt doorgegeven aan de super.
       public OuchIFoundThirtySevenAndHenceMustDieException(String message){
           super(message);
       }
   
   }
   ```

   ## 3.2 throw exception

   1. Zoek het punt waar je de exceptie moet gooien, dit staat waarschijnlijk in de opdracht. In het geval van de primetester was dit wanneer het getal 37 getest werd.

   2. Omvang dit stuk met een `if` gevolgd door de conditie waarop de fout moet optreden. Bij primetester dus: `if (number== 37)` 

   3. in de `if` gooi je de exceptie als volgt:

      ```java
       public void startTesting() throws OuchIFoundThirtySevenAndHenceMustDieException {
      
              while (true) {
      
                  int number = numberUnderTest.getNumber();
      
                  if (number == 37) {
                      throw new OuchIFoundThirtySevenAndHenceMustDieException("oops I found 37");
                  }
              }
      
      ```

4. In de parameters van hou exceptie geef je dus een nuttige tekst mee die aangeeft wat er fout ging.

5. Bij het gooien van een checked exception in java moet je ook in de methode header aangeven dat hij gegooid kan worden, het gaat dan om dit specifieke deel: 

   ```java
   public void startTesting() throws OuchIFoundThirtySevenAndHenceMustDieException {
   ```

   

## 3.3 try/catch exceptions

Als je een exception gooit dan moet hij natuurlijk ook gevangen worden. In het bovenstaande geval gooi ik hem in de `startTesting()` methode. In deze methode **KAN** dus een exception optreden die gevangen moet worden. Ik vang hem dus ook op, op de positie waar ik deze methode uitvoer.

```java
    public void run() {

        try {
            startTesting();
        } catch (OuchIFoundThirtySevenAndHenceMustDieException e) {
 //hier komt de logica om je programma in een goede staat verder te laten draaien. Vaak is dit ook gewoon niks.
        }
    }
```



# 4. Refactoring

Refactoren is het aanpassen en verbeteren van code zonder de werking hier van aan te passen. Het is dan ook belangrijk dat je na elke aanpassing je de unittests uitvoert om te kijken of alles het nog doet. Wij moeten de volgende `code smells` kennen: Duplicated Code, Long Method and Large Class, Magic Number, Comments, Message Chains. 

Voor elke code smell is een standaard oplossing die je kan vinden op het internet. De pagina van de code smells staan hieronder, als je naar beneden scrollt zul je `treatment` zien staan. Daar staan vaak een aantal oplossingen die je kan toepassen.

**Duplicated Code:**  https://refactoring.guru/smells/duplicate-code 

 **Long Method:**  https://refactoring.guru/smells/long-method 

**Large Class:**  https://refactoring.guru/smells/large-class 

**Magic Number:** Dit is gewoon een hard coded getal in de code, los dit op door er een final variabele van te maken.

**Comments:**  https://refactoring.guru/smells/comments 

**Message Chains:**  https://refactoring.guru/smells/message-chains 



# 5. streams en lambda

Lambda's komen vaak voor in combinatie met een stream. Ik ga ze ook niet los behandelen, hieronder is wel een voorbeeld te vinden van hoe een implementatie van een functioneel interface doormiddel van lambda eruit ziet:

```java
MyComparator myComparator = (a1, a2) -> return a1 > a2;

boolean result = myComparator.compare(2, 5);
```



Je kan op een stream een aantal verschillende functies uitvoeren. Deze kan je verdelen in twee categorieën: functies die de stream beëindigen (terminal operations) en deze die dat niet doen (non-terminal/intermediate operations) . Onthoud vooral dat `foreach/reduce/collect` de stream beëindigen en er dus geen andere operators achteraan kunnen. 

reduce() ga ik niet behandelen, omdat het vergelijkbaar is met de sum() functie maar dan iets ingewikkelder. collect() kan je uit de context van de voorbeelden afleiden dus zal ik ook niet uitwerken.

de volgende operations zijn non-terminal en hier kan je er zoveel achter elkaar plakken als je wil. Een stream moet overigens wil eindigen in een terminal operation.

- filter()
- map()
- distinct()
- sorted()

  

## 5.1 Lijst of array omzetten naar een stream

```java
//Array omgezet naar een stream en vervolgens in een lijst gezet.
int[] nummers = {0,1,2,3,4};
List<Integer> nummerLijst = Arrays.stream(nummers)
    .filter(nummer -> nummer > 3)
    .boxed()
    .collect(Collectors.toList());

//Lijst omgezet naar een stream en weer terug naar een lijst
List<Integer> hogerDanVijfLijst = nummerLijst.stream()
    .filter(nummer -> nummer > 5)
    .collect(Collectors.toList());

//Array omzetten naar een stream en dan waar terug naar array
nummers = Arrays.stream(nummers).filter(nummer -> nummer > 3).toArray();
```

Waarom gebruik ik `boxed`? Dit komt omdat een lijst alleen objecten kan vasthouden en geen primitieve types zoals float, int etc. een int is een primitief type en Integer is de object vorm die het primitieve type int bevat. Een stream kan wel primitieve types bevatten en hier handeling mee verrichten. Wanneer je dus een array van primitieve types streamt en deze stream wil omzetten naar een lijst dan gebruik je `boxed`. `boxed` zet dus het primitieve type int om naar het object Integer zodat het in een lijst past. 



## 5.2 filteren 

Met een filter kan je de lijst filteren (NEEEEEJOH). In de parameters gebruik je een lambda om aan te geven waar elk object in de stream aan moet voldoen. In het voorbeeld stream ik dus de woorden array en ik check vervolgens voor elk woord of er een `i` in zit. Als er een i in zet dan mag het woord blijven en anders wordt hij verwijderd uit de stream.

```java
String[] woorden = {"Hoi", "Ik", "Ben", "Ruben"};

List<String> woordenMetEenI = Arrays.stream(woorden)
    .filter(woord -> woord.contains("i"))
    .collect(Collectors.toList());

```

## 5.3 map en filter (meerdere non-terminal operations)

Met map kan je een actie uitvoeren op elke waarde, een beetje vergelijkbaar met foreach dus, maar map is non terminal. In het voorbeeld map ik elk woord (waar toevallig een waarde in zit die omgezet kan worden naar een int) aan de int waarde die er bij hoort door de statische methode parseInt aan te roepen. Hieruit komt dus een lijst van Integers {1, 2, 3, 4, 5, 6}. Pas wel op, want als er een String waarde tussen zit die nog omgezet kan worden naar een int, dan gooit hij een NumberFormatException.

```java
String[] nummersAlsString = {"1", "2", "3", "4", "5", "6"};

List<Integer> nummerLijst = Arrays.stream(nummersAlsString)
    .map(woord -> Integer.parseInt(woord)).collect(Collectors.toList());
```

Stel dat ik dan ook nog wil filteren dan ziet dat er zo uit:

```java
String[] nummersAlsString = {"1", "2", "3", "4", "5", "6"};

List<Integer> nummerLijst = Arrays.stream(nummersAlsString)
    .map(woord -> Integer.parseInt(woord))
    .filter(nummer -> nummer > 2 && nummer < 5)
    .collect(Collectors.toList());
```

Hieruit komt een lijst uit van Integers {3, 4}. Zo zie je dus dat je meerdere non-terminal operations achter elkaar kan doen.

## 5.4 Distinct 

Als je ISE hebt gehad dan weet je precies wat distinct doet. Distinct zorgt er namelijk voor dat er nooit 2 gelijke waardes in één stream/lijst zitten na het uitvoeren van de operatie. Zie volgende voorbeeld:

```java
String[] nummersAlsString = {"1", "1", "1", "2", "3", "4", "4", "5", "6", "6"};

List<String> uniekeNummersAlsStringLijst = Arrays.stream(nummersAlsString)
    .distinct()
    .collect(Collectors.toList());
```

De nummerLijst zal na de distinct operatie er het volgende uit zien: {"1", "2", "3", "4", "5", "6"}. Er zullen dus geen dubbele waarde in zitten, dit werkt hetzelfde met andere datatype. 

## 5.5 Sorted

Sorted is een methode om je stream te sorteren op de natuurlijk volgorde van het datatype. Voor Integers betekent dit dus van laag naar hoog, maar voor Strings gaat het op alfabetische volgorde en dus niet van kortste naar langste woorden. Zie volgende voorbeeld: 

```java
int[] nummers = {1, 2, 4, -19, 3, 1, 99, -1};

List<Integer> gesorteerdeNummerLijst = Arrays.stream(nummers)
    .sorted()
    .boxed()
    .collect(Collectors.toList());
```

resultaat is: 
-19
-1
1
1
2
3
4
99

## 5.6 Sum & Max & Min

dit zijn alle drie terminal operations.

sum is handig voor het opsommen van een getallen lijst, maar werkt alleen als de stream uit een primitief type bestaat. Zie het volgende voorbeeld

```java
int[] nummers = {1, 2, 4, -19, 3, 1, 99, -1};

int opsommingVanNummers = Arrays.stream(nummers)
              .sum();
```

Het resultaat hiervan is 90.

Het vorige voorbeeld werkte omdat je een array van primitieve types omzet naar een stream van primitieve types. Kijk eens naar het volgende voorbeeld:

```java
 String[] nummersAlsString = {"1", "2", "3", "4", "5", "6"};

List<Integer> nummerLijst = Arrays.stream(nummersAlsString)
                .map(woord -> Integer.parseInt(woord))
    		   .collect(Collectors.toList());
        
int opsomming = nummerLijst.stream().mapToInt(Integer::intValue).sum();
```

Hier hebben we dus een **LIJST** van **INTEGERS**. Dit zijn geen primitieve types, die moeten we dus omzetten naar een int doormiddel van de map functie, voordat we de sum kunnen gebruiken.

**Max en Min** werken hetzelfde als sum, maar geven dan respectievelijk de maximale- en minimale waarde in een lijst terug. Hopelijk begrijp je dit, anders pech (door tijdsdruk niet kunnen uitwerken).

## 5.7 foreach

Een veel voorkomende fout is dat mensen denken dat de foreach iets teruggeeft, dat is dus niet zo. Je kan de resultaten van de foreach niet direct in een lijst stoppen als je hem op een stream uitvoert. **het volgende kan dus niet**: 

```java
String[] nummersAlsString = {"1", "2", "3", "4", "5", "6"};

List<Integer> nummerLijst = Arrays.stream(nummersAlsString)
   .foreach(nummer -> Integer.parseInt(nummer));
```

Je kan de actie van het omzetten wel uitvoeren in de foreach, maar het terug stoppen in een lijst is onmogelijk. 

Je kan bijvoorbeeld wel het volgende doen: 

```java
 String[] nummersAlsString = {"1", "2", "3", "4", "5", "6"};

Arrays.stream(nummersAlsString)
    .forEach(woord -> System.out.println(Integer.parseInt(woord)));
```

Elk woord zet ik om naar een nummer en print het gelijk naar de console, ik stop het dus nergens in. 

# 6. Multi-threading 

Je besturingssysteem wijst aan elk proces een stuk geheugen van je core toe (denk bij proces aan al je verschillende programma's die open staan: Discord, Spotify, Typora etc.). Deze programma's hebben vervolgens de vrijheid om dit geheugen weer op te delen en hier meerdere threads op te laten runnen. Zo kan het dus dat er twee verschillende instanties van Youtube open kunnen staan en in beide een video afgespeeld kan worden. 

Er is niet zoiets als een stop() functie op je thread. Deze was er wel, maar is verouderd. 



## 6.1 multi-threading met een lambda implementatie van Runnable

Jouw `Main(String[] args)` draait altijd op één thread. Stel dat jij een lijst van nummers wil printen, maar tegelijkertijd ook wil dat de printer aangeeft wanneer een nummer even is, zonder dat je main thread hier op moet wachten, dan kan je dit oplossen met multi-threading. Zie het volgende voorbeeld: 

```java
public class App {

    private static Runnable woordPrinter = () -> {
		System.out.println("Ik ben even");
    };

    public static void main(String[] args) {
        
        for (int i = 0; i < 200; i++) {
            System.out.println(i);
            
            if (i % 2 == 0) {
                new Thread(woordPrinter).start();
            }
        }
    }
}

```

Ik implementeer de functionele interface `Runnable` doormiddel van een lambda. Ik stop dus een functie, namelijk het printen van "ik ben even" in een variabele.

vervolgens print ik 200x een opvolgend nummer. Telkens als dit nummer even is, dan wil ik dit printen zonder dat mijn main thread hier op moet wachten. Ik maak dus een nieuwe thread aan waar ik telkens als het nodig is, de functie op uitvoer. Ik heb dus een aparte plek gecreëerd voor het uitvoeren van mijn functie, waar de main thread geen last van heeft.  

een `new Thread()` verwacht altijd een `Runnable` in zijn constructor en `.start()` om deze `Runnable` uit te voeren. 

Het resultaat is dus dat ik 200x een nummer in mijn console heb en 100x "ik ben even". Helaas gebeurt dit niet altijd in dezelfde volgorde: 

![image-20200218173108576](.\multi.png)

Ik heb dus geen controle over de volgorde, maar wel over het resultaat.

## 6.2 Multi-threading met een Runnable klasse 

In het vorige voorbeeld hebben we een instantie van `Runnable` geïmplementeerd doormiddel van een lambda en deze gaven we door aan een `new Thread()` om vervolgens deze functie uit te voeren. Je kan dit ook op een andere manier doen.

De vorige uitwerking had de beperking dat ik slechts één functie kon uitvoeren, namelijk het printen van "ik ben even". Stel dat ik een klasse heb die verschillende dingen kan printen, zie volgend voorbeeld: 

```java
public class App {

    private static Runnable evenPrinter;
    private static Runnable rubenPrinter;


    public static void main(String[] args) {
        Thread.currentThread().setName("Main thread: ");
        nummerPrinter();
    }

    private static void nummerPrinter() {
        rubenPrinter = new Woordprinter("Hoi ik ben Ruben");
        evenPrinter = new Woordprinter("ik ben even");

        for (int i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread().getName() + i);

            if (i % 2 == 0) {
                new Thread(evenPrinter, "thread 3: ").start();
            }
            new Thread(rubenPrinter, "thread 2: ").start();
        }
    }
}
```

```java
public class Woordprinter implements Runnable {

    String watMoetIkPrinten;

    public Woordprinter (String watMoetIkPrinten){
        this.watMoetIkPrinten = watMoetIkPrinten;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + watMoetIkPrinten);
    }
}
```

In het vorige voorbeeld gaf ik een functie mee aan een `Thread` van het type `Runnable`. Nu geef ik een klasse mee die ook `Runnable` is, omdat ik hem implementeer. Het tweede argument dat ik aan de `Thread` mee geef, is een naam, zodat ik hem in de console kan onderscheiden.

 In plaats van dat de `.start()` nu de functie uitvoert, gaat hij op zoek naar run() methode in de klasse die je hebt meegegeven aan de thread. 

Mijn klasse neemt ook nog een parameter die ik vervolgens gebruik om te printen, zo kan ik 200x het nummer printer, 200x "ik ben Ruben" en 100x "ik ben even", op verschillende threads. De console ziet er vervolgens zo uit:

![image-20200218173108576](.\threads.png)

Je ziet dat er geen herkenbare volgorde in zit en dit zal per executie anders zijn, maar ik kan wel garanderen wat het resultaat is.

