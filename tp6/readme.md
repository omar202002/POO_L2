# Nom: Kode Ousmane                                                Prenom: Omar

## Presentation du TP
Ce TP comprend deux parties:    
      * Dans la première partie (Q1 à Q3) nous devons créer une calculatrice infixée qui doit effectué des calculs de bases à savoir multiplier, additionner, soustraire et diviser.La complication de cette partie se suitue au niveau des operateurs car nous devons dénombrer tous les cinq cas d'operations possible('+'; '-'; '/'; '*'; '%'). Pour cela, nous avons créer une classe pour chacun des opérateurs qui implémenteront une interface commune. Quand aux autres méthodes comme pressClear, pressDigit ou pressDel, il n'y avait par vraiment une grande difficulté mis à part lefait de comprendre comment un chiffre un modéfier sur une calculatrice.   
      * Dans la seconde partie du TP(Q4 et Q5), nous devons créer une calculatrice post-fixée. La classe qui créer cette calculatrice possède les mêmes méthodes que celles de la calculatrice infixée. Le problème c'est qu'au niveau de la calculatrice post-fixée nous devons noter les opérandes et ensuite les opérateurs. Le signe de l'égalite permet de séparer les opérandes pour les stocker dans une pile. Pour chaque opérateurs il doit y avoir deux opérandes, le résultat final est donné quand nous avons donnés les nombre d'opérateurs corespondant au nombre de duo d'opérandes.

## Generation de la documentation
Vous devrez d'abord vous placer dans le dossier tp6.Il y aura un warning et cela est du au tag "@see" qui se trouve à la ligne 25 de la classe CalculatorView.java du package gui. Pour générer la documentation de tous les packages, il faudra exécuter la commande suivante:  
``` ···/tp6$ javadoc -classpath src -d docs -subpackages calc ```

## Compilation
Vous devrez d'abord vous placer dans le dossier tp6. Par exemple pour exécuter les classes du package battleship il faut exécuter la commande suivante:  
``` ···/tp6$ javac -classpath src -d classes src/calc/*.java ```

## Compilation des tests
Vous devrez d'abord vous placer dans le dossier tp6. Par exemplepour compiler les tests pour les méthodes du package calc il faut exécuter la ligne suivante:  
``` ···/tp6$ javac -classpath test4poo.jar test/calc/*.java ```

## Execution des test
Vous devrez d'abord vous placer dans le dossier tp6. Par exemple pour exécuter le fichier InfixedCalculator.java vous devrez exécuter avec cette ligne:
``` ···/tp6$ java -jar test4poo.jar calc.InfixedTest ```

## Execution du programme
Vous devrez d'abord vous placer dans le dossier tp6. Par exemple por exécuter le fichier InfixedMain.java vous devrez exécuter la commande suivante:  
``` ···/tp6$ java -classpath classes calc.InfixedMain ```  
Cela affichera une calculatrice.


## Creation d'un jar executable
Pour creer un jar pour la classe InfixedMain.java il faut éxecuter la commande suivante:  
``` .../tp6$ jar cvfe infixed.jar calc.InfixedMain -C classes calc```  
Pour creer un jar pour la classe PostfixedMain.java il faut éxecuter la commande suivante:  
``` .../tp6$ jar cvfe postfixed.jar calc.PostfixedMain -C classes calc```

## Execution du fichier jar
Pour exécuter le jar pour la classe InfixedMain.java il faut éxecuter la commande suivante:  
``` .../tp6$ java -jar infixed.jar ```  
Pour exécuter le jar pour la classe PostfixedMain.java il faut éxecuter la commande suivante:  
``` .../tp6$ java -jar postfixed.jar ```
