## SOLID



**Single responsibility principle**
Klasse/module/methode heeft maar één verantwoordelijkheid. Maakt functionaliteit wijzigen makkelijker. 

high cohesion = srp

low cohesion != srp

ook bekend als:

- DRY
- curly's law
- once and only once
- single point of truth

**open closed principle**
open for modification but closed for modification.

methode veranderen door code aan te passen = closed
inheritance = open
nieuwe methode/gedrag toevoegen = open

nieuwe klasse extends oude klasse, in nieuwe klasse komt oude gedrag + nieuw gedrag.

**liskov substitution principle**
override methods in een derived class mag meer accepteren als pre conditie, maar niet minder
override methods in een derived class mag minder teruggeven als postconditie, maar niet meer

Als een methode een zij-effect heeft, moet de overrided method hetzelfde zij-effect hebben. (hetzelfde of minder)

**interface segregation principle**
Als je een interface implementeert, dan moet je alle methodes gebruiken. Splits de interface anders op. 

**dependency inversion principle**



state invariant





