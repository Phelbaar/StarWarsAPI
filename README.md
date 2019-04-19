# StarWarsAPI
New Version


LE MASNE DE CHERMONT Guénolé


##Projet Android semestre 2 : Réalisation d'une application listant les planètes de Star Wars et leurs descriptifs.

##Description : 

Cette application affiche les planètes de l'univers de Star Wars et permet d'afficher meur descrptif une fois que l'on a cliqué sur le nom de la planète.

##Subtilités du programme : 

 - 3 écrans, 3 activités
 - Affichage d'une liste dans une RecyclerView
 - Appel rest API avec Retrofit
 - Affichage du détail d'un item de la liste
 - Architecture MVC
 - Notifications push
 - GitFlow


##Fonctionnalités : 

-###Écran d'accueil

Le premier écran comporte le nom de l'appli, une toolbar et un bouton start

-###Deuxième écran

Le deuxième écran affiche un loader le temps que l'application se connecte à l'API rest, puis affiche la liste des planètes que récupère Retrofit dans une RecyclerView.

-###Troisième écran

Le troisième écran affiche le descriptif de la planète cliquée précédemment : 
  - Nom
  - Climat
  - Gravité sur une échelle de 0 à 1
  - Terrain
  - Période de rotation
  - Période orbitale
  - Diamètre
  - Surface d'eau sur la planète
  - Population
  - Date de création
  - Date d'édition
  - Url qui a permis d'accéder au descriptif de la planète


