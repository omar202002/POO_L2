# Nom: Kode Ousmane                                                Prenom: Omar

## Presentation du TP
L'objectif de ce TP est le suivant:  
      * Nous devons modéliser le jeu de l'oie qui consiste à jouer à un ou plusieurs sur un plateau de 63 cases. Le jeu prend fin uniquement si un joueur arrive sur la dernière cases. Pour crééer ce jeu il a fallut d'abord creer les diffrentes cases présentées dans le jeu original. Nous acons décider de crééer un interface pour les cases afin que que le jeu soit plus extensible, c'est a dire si l'on veut ajouter de nouvelles caractéristiques aux cases. Nous avons fait de même avec la classe ClassicalBoard qui hérite de la classe abstraite Board . Pour que le jeu continue de tourner il est nécéssaire qu'il y ait au moins un joueur qui soit présent.

## Generation de la documentation
Vous devrez d'abord vous placer dans le dossier tp8. Pour générer la documentation de toutes les classes, il faudra exécuter la commande suivante:  
``` ···/tp8$ javadoc -classpath src -d docs -subpackages goosegame ```

## Compilation
Vous devrez d'abord vous placer dans le dossier tp8. Par exemple pour exécuter toutes les classes du package goosegame il faut exécuter la commande suivante:  
``` ···/tp8$ javac -classpath src -d classes src/goosegame/*.java ```

## Compilation des tests
Vous devrez d'abord vous placer dans le dossier tp8. Pour compiler les tests du package goosegame il faut exécuter la ligne suivante:  
``` ···/tp8$ javac -classpath test4poo.jar test/goosegame/*.java ```

## Execution des test
Vous devrez d'abord vous placer dans le dossier tp8. Par exemple pour exécuter le fichier BoardTest.java vous devrez exécuter avec cette ligne:
``` ···/tp8$ java -jar test4poo.jar goosegame.BoardTest ```

## Execution du programme
Vous devrez d'abord vous placer dans le dossier tp8. Pour exécuter le fichier GameMain.java vous devrez exécuter la commande suivante:  
``` ···/tp8$ java -classpath classes displayer.GameMain 3 ```  
Cela affichera les comportemnts pour 3 joueurs sur le plateau lorsqu'ils se déplaceront.


## Creation d'un jar executable
Pour creer un jar pour la classe GameMain.java il faut éxecuter la commande suivante:  
``` .../tp8$ jar cvfe oie.jar goosegame.GameMain -C classes goosegame```  

## Execution du fichier jar
Pour exécuter le jar pour la classe GameMain.java il faut éxecuter la commande suivante:  
``` .../tp8$ java -jar oie.jar ```  
