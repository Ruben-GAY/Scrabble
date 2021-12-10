//package scrabbleSAE;

public class Case {
    
    private static int[] nbPointsJeton={1,3,3,2,1,4,2,4,1,8,10,1,2,1,1,3,8,1,1,1,1,4,10,10,10,10};
    private int couleur;
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
    public void setLettre (char let){
        if(Character.isUpperCase(let)==true){
            this.lettre=let;
        }
    }
    /**
    * résultat : vrai ssi la case est recouverte par une lettre
    */
    public boolean estRecouverte (){
        boolean recouverte =false;
        if(this.caseStatue==true){
            recouverte=true;
        }
        return recouverte;
    }

    public String toString(){
        return "couleur : "+couleur+", "+"statue : "+caseStatue+", " + "lettre : " +lettre;
    }
}


