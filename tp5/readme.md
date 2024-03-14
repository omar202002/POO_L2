# Nom: Kode Ousmane                                                Prenom: Omar

## Presentation du TP
Ce TP comprend deux exercices:    
      * Le premier exercice nous introduit aux fichier jar et exécutables. Le but de cet exercice est d'apprendre comment créer et exécuter un fichier JAR. Il y a deux manières de creer un finchier jar en fonction de la ligne de commande tappée. Le fichier JAR sera créer à partir de la classe Main du package qu'on aura choisi. Il ne faudra pas oublier de compiler d'abord les packages dont on a besoin.  
      * Dans Le second exercice nous devons modéliser un jeu de bataille navale. La classe Sea qui represente la mer dans le jeu contient plusieurs cellules(Cell) définies à sa contruction et chaque cellule peut contenir une unité d'un bateau. Quand le plateau de jeu s'affichera, vous remarquerez que pour preciser la position on l'on veut tirer, il faudra inserer une lettre de l'alphabet français ainsi qu'un chiffre. Ce qui signifie qu'il y a 26 valeurs possible pour le premier choix. Si la position donnée n'est pas valide ou si il n'y a pas de place pour déposer un bateau, il y aura une exception en fonction du cas. Le jeu se termine quand tous les bateaux sont détruits.

## Generation de la documentation
Vous devrez d'abord vous placer dans le dossier tp5. Pour générer la documentation de tous les packages, il faudra exécuter la commande suivante:  
``` ···/tp5$ javadoc -classpath src -d docs -subpackages battleship io tv ```

## Compilation
Vous devrez d'abord vous placer dans le dossier tp5. Par exemple pour exécuter les classes du package battleship il faut exécuter la commande suivante:  
``` ···/tp5$ javac -classpath src -d classes src/battleship/*.java ```

## Compilation des tests
Vous devrez d'abord vous placer dans le dossier tp5. Par exemplepour compiler les tests pour les méthodes du package battleship il faut exécuter la ligne suivante:  
``` ···/tp5$ javac -classpath test4poo.jar test/battleship/*.java ```

## Execution des test
Vous devrez d'abord vous placer dans le dossier tp5. Par exemple pour exécuter le fichier SeaTest.java vous devrez exécuter avec cette ligne:
``` ···/tp5$ java -jar test4poo.jar battleship.SeaTest ```

## Execution du programme
Vous devrez d'abord vous placer dans le dossier tp5. Par exemple por exécuter le fichier ThirdBattleShipMain.java vous devrez exécuter la commande suivante:  
``` ···/tp5$ java -classpath classes battleship.ThirdBattleShipMain ```  
Cela affichera un seul plateau du point de vue du défenseur et un second plateaudu point point de vue de l'attaquant qui va changer au cours du jeu.


## Creation d'un jar executable
Pour creer un jar pour la classe SecondBattleShipMain.java il faut éxecuter la commande suivante:  
``` .../tp5$ jar cvfe SecondBattleShipMainBis.jar battleship.SecondBattleShipMain -C classes . ```  
Pour creer un jar pour la classe ThirdBattleShipMain.java il faut éxecuter la commande suivante:  
``` .../tp5$ jar cvfe ThirdBattleShipMainBis.jar battleship.ThirdBattleShipMain -C classes . ```

## Execution du fichier jar
Pour exécuter le jar pour la classe SecondBattleShipMain.java il faut éxecuter la commande suivante:  
``` .../tp5$ java -jar SecondBattleShipMainBis.jar ```  
Pour exécuter le jar pour la classe ThirdBattleShipMain.java il faut éxecuter la commande suivante:  
``` .../tp5$ java -jar ThirdBattleShipMainBis.jar ```
