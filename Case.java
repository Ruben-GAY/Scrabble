public class Case{
    private int couleur;
    private boolean statut;
    private char lettre;

    /**
     * Constructeur de base
     * @param uneCouleur
     */
    public Case(int uneCouleur){
        this.couleur = uneCouleur;
        this.statut = statut;
    }

    /**
     * Getter Couleur
     * @return
     */
    public int getCouleur(){
        return this.couleur;
    }
    /**
     * Getter Lettre
     * @return
     */
    public char getLettre(){
        return this.lettre;
    }
    /**
     * Setter Lettre
     * @param let
     */
    public void setLettre(char let){
        let = this.lettre;
    }
    
    /**
     * Retourne true si la case est recouverte par une lettre 
     * @return
     */
    public boolean estRecouverte(){
        res = false;
        if (statut == true){
            res = true;
        }
        return res;
    }

    /**
     *  A REVOIR
     * toString
     */
    public String toString(){
        return lettre;
    }

}

