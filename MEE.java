public class MEE {
    
    private static int[] nbPointsJeton = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 10, 1, 2, 1, 1, 3, 8, 1, 1, 1, 1, 4, 10, 10, 10, 10};

    private int[] tabFreq;
    private int nbTotEx;

    /**
     * Constructeur de base
     * @param max
     */
    public MEE(int max){
        //if (max >= 0){
            this.tabFreq = tabFreq[max];
            this.nbTotEx = nbTotEx;
        //} 
    }

    /**
     * Constructeur
     * à partir d'un tableau
     * @param tab
     */
    public MEE(int[] tab){
        for (int i = 0; i < tab.length; i++){
            this.tabFreq[i] = tab[i];
        }
        this.nbTotEx = nbTotEx;

        //les éléments de tab doivent être nuls ou positifs
      
        /*
        boolean positif;
        for (int i = 0; i < tab.length ; i++){
            if (tab[i] < 0){
                positif = true;
            }
        */
    }

    /**
     * Constructeur
     * par copie
     * @param e
     */
    public MEE(MEE e){
        this(e.tabFreq, e.nbTotEx);
    }




    //
    // Méthodes
    //



    /**
     * Retourne true si le tableau est vide
     * @return
     */
    public boolean estVide(){
        return nbTotEx==0;
    }

    /**
     * Ajoute un exemplaire de i à l'instance
     * @param i
     */
    public void ajoute(int i){
        tabFreq[i]++; 
    }

    /**
     * Retire un exemplaire de i si il existe;
     * le retourne si il existe
     * @param i
     * @return
     */
    public boolean retire(int i){
        boolean res = false;
        if (tabFreq[i] > 0){
            tabFreq[i]--;
            res = true;
        } 
        return res;
    }

    /**
     * Retire de l'instance un exemplaire choisi aléatoirement et le retourne
     * @return
     */
    public int retireAlea(){
        int alea = Ut.randomMinMax(0, tabFreq.length-1);
        return tabFreq[alea]--;
    }
    /**
     *  A REVOIR
     * Transfère un exemplaire de i de l'instance vers e s'il en existe;
     * retourne vrai si l'action a pu être effectué
     * @param e
     * @param i
     * @return
     */
    public boolean transfere(MEE e, int i){
        e.ajoute(i);
        return true;
    }
    /**
     * A REVOIR
     * Transfère k exemplaire choisis aléatoirement de l'instance vers e dans la limite du contenu de l'instance
     * @param e
     * @param k
     * @return
     */
    public int transfereAlea(MEE e, int k){
        int alea = Ut.randomMinMax(0, e.tabFreq.length-1);
        return e.tabFreq[alea]+k;
    }

    /**
     * Retourne la somme des valeurs des exemplaires des élements de l'instance;
     * La valeur d'un exemplaire d'un éléments i de this étant égale à v[i]
     * @param v
     * @return
     */
    public int sommeValeurs(int[] v){
        int somme = 0;
        for (int i = 0; i < v.length; i++){
            somme += v[i];
        }
        return somme;
    }
}
