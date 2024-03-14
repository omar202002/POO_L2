# Nom: Kode Ousmane                                                Prenom: Omar

## Presentation du TP
L'objectif de ce TP est le suivant:  
      * Ce TP nous introduit à la notion d'héritage. Dans le TP nous avons des classes qui se ressemblent à l'exception  de quelques méthodes. Donc au lieu de réécrire ces méthodes communes , il suffit juste de faire un héritage.
      * D'abord dans ce TP nous devons construire des afficheurs lumineux qui ont bien évidemment pour but d'afficher un certain message. Nous devons créer quatre afficheurs lumineux en dehors de celui qui est déja donné. Chaque afficheur à sa propre manière d'afficher un message. Par exemple la classe UpperCaseDisplayer affiche les charactères du message en majuscules.

## Generation de la documentation
Vous devrez d'abord vous placer dans le dossier tp7. Pour générer la documentation de toutes les classes, il faudra exécuter la commande suivante:  
``` ···/tp7$ javadoc -classpath src -d docs -subpackages displayer ```

## Compilation
Vous devrez d'abord vous placer dans le dossier tp7. Par exemple pour exécuter toutes les classes du package displayer il faut exécuter la commande suivante:  
``` ···/tp7$ javac -classpath src -d classes src/displayer/*.java ```

## Compilation des tests
Vous devrez d'abord vous placer dans le dossier tp7. Pour compiler les tests du package displayer il faut exécuter la ligne suivante:  
``` ···/tp7$ javac -classpath test4poo.jar test/displayer/*.java ```

## Execution des test
Vous devrez d'abord vous placer dans le dossier tp7. Par exemple pour exécuter le fichier UpperCaseDisplayerTest.java vous devrez exécuter avec cette ligne:
``` ···/tp7$ java -jar test4poo.jar displayer.UpperCaseDisplayerTest ```

## Execution du programme
Vous devrez d'abord vous placer dans le dossier tp6. Pour exécuter le fichier DisplayerMain.java vous devrez exécuter la commande suivante:  
``` ···/tp6$ java -classpath classes displayer.DisplayerMain ```  
Cela affichera le comportement de l'affichage d'un message pour chaque afficheur créé.


## Creation d'un jar executable
Pour creer un jar pour la classe DisplayerMain.java il faut éxecuter la commande suivante:  
``` .../tp7$ jar cvfe displayer.jar displayer.DisplayerMain -C classes displayer```  

## Execution du fichier jar
Pour exécuter le jar pour la classe DisplayerMain.java il faut éxecuter la commande suivante:  
``` .../tp6$ java -jar displayer.jar ```  
