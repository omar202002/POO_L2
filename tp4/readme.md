# Nom: Kode Ousmane                                                Prenom: Omar

## Presentation du TP
Ce TP comprend deux exercices:  
      * L'objectif du premier exercice est de nous introduire à la notion des paqutages et de la façon dont on doit compiler et exécuter lorsqu'on se trouve dans un paquetage
      * Le duxième exercice , nous devons appliquer ce que l'on a appris dans le premier (paquetage, compilation,execution..) pour modeliser une station de service.

## Generation de la documentation
Vous devrez d'abord vous placer dans le dossier tp4.
``` ···/tp4$ javadoc -classpath src -d docs subpackages vlille ```

## Compilation
Vous devrez d'abord vous placer dans le dossier tp4.  
``` ···/tp4$ javac -classpath src -d classes src/vlille/*.java ```

## Compilation des tests
Vous devrez d'abord vous placer dans le dossier tp4.  
``` ···/tp4$ javac -classpath test4poo.jar test/vlille/*.java ```

## Execution des test
Vous devrez d'abord vous placer dans le dossier tp4. Par exemple pour exécuter la fichier BikeStationTest.java vous devrez exécuter avec cette ligne:
``` ···/tp4$ java -jar test4poo.jar vlille.BikeStationTest ```

## Execution du programme
Vous devrez d'abord vous placer dans le dossier tp4.
``` ···/tp4$ java -classpath classes vlille.BikeStationMain ```    
``` ···/tp4$ java -classpath classes vlille.BikeStationMain 0```    
``` ···/tp4$ java -classpath classes vlille.BikeStationMain 5```

## Creation d'un jar executable
``` .../tp4$ jar cvfe appli.jar vlille.BikeStationMain -C classes . ```
``` .../tp4$ jar cvfm appli.jar manifest-tp4 -C classes .

## Execution du fichier jar
``` .../tp4$ java -jar appli.jar ```
