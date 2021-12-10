//package scrabbleSAE;

public class MEE {
    private int [] tabFreq;//={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private int nbToEx;

    //----------constructeur-------------
    //question pre requis
    public MEE (int max){
        //question max?
        this.tabFreq=new int[max];
        this.nbToEx=getNbToEx();
    }

    public MEE(int[] tab){
        this.tabFreq = new int[tab.length];
        this.nbToEx=getNbToEx();
        for(int i = 0; i<tab.length; i++){
            this.tabFreq[i]=tab[i];
        }
    }
    public MEE(MEE e){
        //question par rapport a copie
        this.tabFreq=e.tabFreq;
        this.nbToEx=getNbToEx();
    }


    public int getNbToEx(){
        //question par rapport au get
        int compteur = 0;
        for(int i=0;i<this.tabFreq.length;i++){
            compteur=compteur+this.tabFreq[i];
        }
        this.nbToEx=compteur;
        return this.nbToEx;
    }

    //-----------methode-------------
    public boolean estVide (){
        boolean verif = true;
        if(this.getNbToEx()>0){
            verif = false;
        }
        return verif;
    }
    public void ajoute(int i){
        if(i>=0 && i<this.tabFreq.length){
            this.tabFreq[i]++;
        }
        else{
            Ut.afficherSL("impossible");
        }
    }
    public boolean retire (int i) {
        boolean retire = false;
        if(i>=0 && i<26 && this.tabFreq[i]>0){
            this.tabFreq[i]--;
            retire = true;
        }
        return retire;
    }
    public int retireAleat () {
        int[] tab=new int[this.tabFreq.length];
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
    public boolean transfere (MEE e, int i) {
        boolean verif =false;
        if(i>=0 && i<this.tabFreq.length && this.tabFreq[i]>0){
            e.tabFreq[i]++;
            this.tabFreq[i]--;
            verif=true;
        }
        return verif;
    }
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
}
