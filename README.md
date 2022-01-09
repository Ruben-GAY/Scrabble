# SAE Scrabble
Vous trouverez ci-joint toutes les indications nécessaires pour comprendre et utiliser le programme Scrabble que nous avons créé.

## Présentation du jeu et du projet
Nous avions pour instructions de créer en groupe une version informatisée du Scrabble.
Le Scrabble est un jeu de société composé d'un plateau, de chevalets et d'un sac rempli de jetons représentant les lettres de l'alphabet.
Le but étant de former des mots sur la grille.
Notre version digitale du jeu est moins contraignante et plus simple en comparaison de l'original.

## Présentation détaillée du programme
Notre programme contient les fichiers suivants :
- **Case** représente chaque cases de la grille du plateau de jeu. Certaines cases possèdent des bonus qui multiplient la valeur des lettres ou des mots qui seront placés dessus.
- **Plateau** correspond au plateau de jeu, formé de colonnes de lignes et de cases, où l'on pourra placer les jetons et former les mots. 
- **Joueur**, qui permet définir un joueur, son nom et son chevalet .
- **MEE** définit l'ensemble des jetons des chevalets des joueurs et du sac du jeu. Ce fichier nous permet de gérer la notion mathématique d'ensemble. 
- **ScrabbleMain** permet d'assembler tous nos fichiers et de lancer une partie de Scrabble. 
- **Scrabble** met en place la partie. Ce fichier compte les scores, gère les différentes phases de jeu,  détermine les tours de joueurs,...
- **Ut** nous permet d'accéder à la bibliothèque de fonctions et de méthodes utiles mises en place par l'IUT.

Toutes ses fichiers comportent des fonctions et des méthodes qui s'appellent les unes les autres.

## Télécharger le Scrabble
Afin de pouvoir joueur au Scrabble, il faudra télécharger les différents fichiers qui composent le jeu.
Sur la [page GitHub du groupe](https://github.com/Ruben-GAY/Scrabble) : 
- télécharger tous les fichiers du jeu **Case, Plateau, Joueur, MEE, ScrabbleMain, Scrabble** et **Ut**.
- stocker tous les fichiers téléchargés dans un dossier qui servira de répertoire pour le jeu.


## Compiler le jeu
Après avoir télécharger tous les fichiers nécessaires, pour faire une partie de Scrabble, il faudra compiler les fichiers. 
 > Il faudra auparavant vous assurer de posséder sur votre ordinateur l'environnement Oracle Java.

Ensuite : 
- Ouvrez une console/terminal qui aura pour dossier courant le répertoire du Scrabble (qui a été créé à l'étape précédente).
- Entrez dans ce terminal la commande suivante : **javac ScrabbleMain.java**
- Avec la commande précédente, le code est compilé; il ne reste plus qu'a l'exécuté à l'aide de la commande : **java ScrabbleMain**
