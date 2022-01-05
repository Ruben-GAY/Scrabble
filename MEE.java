//package scrabbleSAE;

public class MEE {
    private int [] tabFreq;//={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private int nbToEx;

    //----------constructeur-------------
    /**
    * pré-requis : max >= 0
    * action : crée un multi-ensemble vide dont les éléments seront
    * inférieurs à max
    */
    public MEE (int max){
            this.tabFreq=new int[max];
    }

    /**
    * pré-requis : les éléments de tab sont positifs ou nuls
    * action : crée un multi-ensemble dont le tableau de fréquences est
    *. une copie de tab
    */
    public MEE(int[] tab){
        this.tabFreq = new int[tab.length];
        for(int i = 0; i<tab.length; i++){
            this.tabFreq[i]=tab[i];
        }
    }
    /**
    * constructeur par copie
    */
    public MEE(MEE e){
        
        this.nbToEx=e.nbToEx;
        this.tabFreq=new int[e.getTabFreq().length];
        for(int i =0;i<e.getTabFreq().length;i++){
            this.tabFreq[i]=e.tabFreq[i];
        }
    }

    public int getNbToEx(){
        int compteur = 0;
        for(int i=0;i<this.tabFreq.length;i++){
            compteur=compteur+this.tabFreq[i];
        }
        this.nbToEx=compteur;
        return this.nbToEx;
    }

    //-----------methode-------------
    public int[] getTabFreq(){
        return this.tabFreq;
    }
    /**
    * résultat : vrai ssi cet ensemble est vide
    */
    public boolean estVide (){
        boolean verif = true;
        if(this.getNbToEx()>0){
            verif = false;
        }
        return verif;
    }

    /**
    * pré-requis : 0 <= i < tabFreq.length
    * action : ajoute un exemplaire de i à this
    */
    public void ajoute(int i){
        this.tabFreq[i]++;
    }

    /**
    * pré-requis : 0 <= i < tabFreq.length
    * action/résultat : retire un exemplaire de i de this s’il en existe,
    * et retourne vrai ssi cette action a pu être effectuée
    */
    public boolean retire (int i) {
        boolean retire = false;
        this.tabFreq[i]--;
        retire = true;
        return retire;
    }
    /**
    * pré-requis : this est non vide
    * action/résultat : retire de this un exemplaire choisi aléatoirement
    * et le retourne
    */
    public int retireAleat () {
        int[] tab=new int[this.tabFreq.length];
        int indexTabAjoute=0;
        int alea=0;
        for(int i =0;i<this.tabFreq.length;i++){
            if(this.tabFreq[i]>0){
                tab[indexTabAjoute]=i; 
                indexTabAjoute++;                    
                }
            }
            alea=Ut.randomMinMax(0, indexTabAjoute-1);
            this.tabFreq[tab[alea]]--;

        return tab[alea]; // retire vaut 0 si on décide de retirer à un chevalet/sac vide
    }
    /**
    * pré-requis : 0 <= i < tabFreq.length
    * action/résultat : transfère un exemplaire de i de this vers e s’il
    * en existe, et retourne vrai ssi cette action a pu être effectuée
    */
    public boolean transfere (MEE e, int i) {
        boolean verif =false;
        if(i>=0 && i<this.tabFreq.length && this.tabFreq[i]>0){
            e.tabFreq[i]++;
            this.tabFreq[i]--;
            verif=true;
        }
        return verif;
    }
    /** pré-requis : k >= 0
    * action : tranfère k exemplaires choisis aléatoirement de this vers e
    * dans la limite du contenu de this
    */
    public void transfereAleat (MEE e, int k) {
        //question prof par rapport a k
        int alea;
        for(int i=0;i<k;i++){
            if(this.estVide()==false){
                alea=this.retireAleat();
                e.ajoute(alea);
            }
        }
    }

    /**
    * pré-requis : tabFreq.length <= v.length
    * résultat : retourne la somme des valeurs des exemplaires des
    * éléments de this, la valeur d’un exemplaire d’un élément i
    * de this étant égale à v[i]
    */
    public int sommeValeurs (int[] v){
        int sommeV=0;
        for(int i=0;i<this.tabFreq.length;i++){
            if(this.tabFreq[i]>0){
                sommeV = sommeV + this.tabFreq[i]*v[i];
            }
        }
        return sommeV;
    }

    //sert à tester la classe MEE
    
    public String toString(){
        String retourne="[";
        for(int i =0;i<this.tabFreq.length-1;i++){
            retourne = retourne+this.tabFreq[i]+",";
        }
        retourne=retourne+this.tabFreq[this.tabFreq.length-1]+"]";
        return retourne;
    }
    
    
    
}
