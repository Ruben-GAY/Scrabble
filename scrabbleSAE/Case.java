//package scrabbleSAE;

public class Case {
    
    private static int[] nbPointsJeton={1,3,3,2,1,4,2,4,1,8,10,1,2,1,1,3,8,1,1,1,1,4,10,10,10,10};
    private static int couleur;
    private boolean caseStatue; // true =recouverte  false = libre
    private char lettre;

    //-------methode---------

    /**
    * pré-requis : uneCouleur est un entier entre 1 et 5
    * action : constructeur de Case
    */
    public Case(int uneCouleur){
        if(uneCouleur>=1 && uneCouleur<=5){
            this.couleur= uneCouleur;
        }
    }
    /**
    * résultat : la couleur de this, un nombre entre 1 et 5
    */
    public int getCouleur (){
        return this.couleur;
    }
    /**
    * pré-requis : cette case est recouverte
    */
    public char getLettre (){
        if(caseStatue==true){ 
            return this.lettre;
        }
    }

    /**
    * pré-requis : let est une lettre majuscule
    */
   /* static boolean estMajuscule(char ch){
        int ascii = (int) ch;
        //[A..Z]
        if((ascii>=65 && ascii<=90) 
           //les lettres accentuées
           || (ascii>=192 && ascii<=223))
         return true;
        return false;
    }*/
    public void setLettre (char let){
        if(Character.toUpperCase(Let)==true){

        }
    }
}


