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
        if(max>=0){
            this.tabFreq=new int[max];
        }
        
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
        this.tabFreq=e.tabFreq;
        this.nbToEx=e.nbToEx;
    }

    /*
    public int getNbToEx(){
        //question par rapport au get
        int compteur = 0;
        for(int i=0;i<this.tabFreq.length;i++){
            compteur=compteur+this.tabFreq[i];
        }
        this.nbToEx=compteur;
        return this.nbToEx;
    }
    */

    //-----------methode-------------
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
        if(i>=0 && i<this.tabFreq.length){
            this.tabFreq[i]++;
        }
        else{
            Ut.afficherSL("impossible");
        }
    }
    /**
    * pré-requis : 0 <= i < tabFreq.length
    * action/résultat : retire un exemplaire de i de this s’il en existe,
    * et retourne vrai ssi cette action a pu être effectuée
    */
    public boolean retire (int i) {
        boolean retire = false;
        if(i>=0 && i<this.tabFreq.length && this.tabFreq[i]>0){
            this.tabFreq[i]--;
            retire = true;
        }
        return retire;
    }
    /**
    * pré-requis : this est non vide
    * action/résultat : retire de this un exemplaire choisi aléatoirement
    * et le retourne
    */
    public int retireAleat () {
        int[] tab=new int[this.tabFreq.length]; // Création d'un tableau qui va stocker les indexes des valeurs de this >0
        int indexTabAjoute=0;
        int alea=0;
        if(this.estVide()==false){
            for(int i =0;i<this.tabFreq.length;i++){
                if(this.tabFreq[i]>0){
                    tab[indexTabAjoute]=i;
                    
                    indexTabAjoute++;
                    
                }
            }
            alea=Ut.randomMinMax(0, indexTabAjoute-1);
            this.tabFreq[tab[alea]]--;


        }
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
        if(k>0){ //k>=0
            for(int i=0;i<k;i++){
                if(this.estVide()==false){
                    alea=this.retireAleat();
                    e.ajoute(alea);
                }
            }
        }
    }
    /**
    * pré-requis : tabFreq.length <= v.length
    * résultat : retourne la somme des valeurs des exemplaires des
    * éléments de this, la valeur d’un exemplaire d’un élément i
    * de this étant égale à v[i]
    */
    public String toString(){
        String retourne="[";
        for(int i =0;i<this.tabFreq.length-1;i++){
            retourne = retourne+this.tabFreq[i]+",";
        }
        retourne=retourne+this.tabFreq[this.tabFreq.length-1]+"]";
        return retourne;
    }
    /**
    * pré-requis : tabFreq.length <= v.length
    * résultat : retourne la somme des valeurs des exemplaires des
    * éléments de this, la valeur d’un exemplaire d’un élément i
    * de this étant égale à v[i]
    */
    /*
    public int sommeValeurs (int[] v){
        int sommeV=0;
        Plateau Plat =new Plateau(); 
        if(this.tabFreq.length<=v.length){
            for(int i=0;i<this.tabFreq.length;i++){
                if(this.tabFreq[i]>0){
                    v[i]=this.tabFreq[i]*Plat.getNbPointsJeton()[i];
                }
            }
        }
        for(int i=0;i<v.length;i++){
            if(v[i]>0){
                sommeV=sommeV+v[i];
            }
        }
        return sommeV;
    }
    */
    /**
    * pré-requis : tabFreq.length <= v.length
    * résultat : retourne la somme des valeurs des exemplaires des
    * éléments de this, la valeur d’un exemplaire d’un élément i
    * de this étant égale à v[i]
    */
    public int sommeValeurs (int[] v){
        int sommeV=0;
        if(this.tabFreq.length<=v.length){
            for(int i=0;i<this.tabFreq.length;i++){
                if(this.tabFreq[i]>0){
                    sommeV = sommeV + this.tabFreq[i]*v[i];
                }
            }
        }
        return sommeV;
    }
    
}
