
public class Joueur {
    private String nom;
    private MEE chevalet;
    private int score;    

    public Joueur(String nom){
        this.nom = nom;
        this.chevalet=new MEE(26);
        this.score=score;
    }

    public boolean capeloDico(String mot){
        boolean valide = true;
        int i =0;
        while(valide==true && i<mot.length()){
            //Ut.afficherSL(mot.charAt(i)+"valide MAJ ?"+Character.isUpperCase(mot.charAt(i)));
            if(!Character.isUpperCase(mot.charAt(i))){
                valide = false;
            }
            i++;
        }
        if(valide==true){
            Ut.afficher("le mot :"+mot+" est-il valide (true ou false) ?");
            valide = Ut.saisirBooleen();
        }
        else{
            Ut.afficherSL("Le mot doit etre saisie en majuscule");
        }
        return valide;
    } 

    public int getScore(){
        return this.score;
    }
    
    public String getNom(){
        return this.nom;
    }

    public MEE getChevalet() {
        return this.chevalet;
    }


    public void ajouteScore(int nb){
        this.score=this.score+nb;
    }

    /**
    * pré-requis : nbPointsJet indique le nombre de points rapportés par
    * chaque jeton/lettre
    * résultat : le nombre de points total sur le chevalet de ce joueur
    * suggestion : bien relire la classe MEE !
    */
    public int nbPointsChevalet (int[] nbPointsJet){
        int somme= 0;
        for(int i =0;i<this.chevalet.getTabFreq().length;i++){
            if(this.chevalet.getTabFreq()[i]>0){
                somme+=this.chevalet.getTabFreq()[i]*nbPointsJet[i];
            }
        }
        return somme;
    }
    /**
    * pré-requis : les éléments de s sont inférieurs à 26
    * action : simule la prise de nbJetons jetons par this dans le sac s,
    * dans la limite de son contenu.
    */
    public void prendJetons (MEE s, int nbJetons) {
        int nbJ = nbJetons;
        int totS=s.getNbToEx();
        int totChe=this.chevalet.getNbToEx();
        if(s.getNbToEx()>=nbJ){ // cas où le sac peut donner le nombre de jeton demandé
            for(int i=0; i<7-totChe; i++){
                this.chevalet.ajoute(s.retireAleat());
            }
        }
        else{                  // cas où le sac peut ne donner pas le nombre de jeton demandé
            for(int i=0; i<totS; i++){ 
                this.chevalet.ajoute(s.retireAleat());
            }
        }
    }
    /**
    * pré-requis : les éléments de s sont inférieurs à 26
    * et nbPointsJet.length >= 26
    * action : simule le coup de this : this choisit de passer son tour,
    * d’échanger des jetons ou de placer un mot
    * résultat : -1 si this a passé son tour, 1 si son chevalet est vide,
    * et 0 sinon
    */
    
    public int joue(Plateau p, MEE s, int[] nbPointsJet) {
        int resultat = 0;
        int action;
        //Ut.afficherSL("A vous de jouez ! ");
        Ut.afficherSL("Pour passer son tour, cliquez : 1 ");
        Ut.afficherSL("Pour passer votre tour et echanger des jetons, cliquez : 2 ");
        Ut.afficherSL("Pour placer un mot, cliquez : 3 ");
        Ut.afficherSL(this.chevalet.toString());
        Ut.afficher("saisir valeur entre 1 et 3 : ");
        action = Ut.saisirEntier();
        Ut.afficherSL(p.toString());

        switch(action){
            case 1:
                resultat=-1;
                Ut.afficherSL("Vous passez votre tour");
                break;
            
            case 2:
                this.echangeJetons(s);
                resultat=0;
                break;

            case 3:
                //Ut.afficherSL(p.toString());
                if(joueMot(p, s, nbPointsJet)){

                    this.prendJetons(s, 7-this.chevalet.getNbToEx());
                    if (this.chevalet.estVide()) {
                        resultat = 1;
                    }
                    else{ 
                        //this.prendJetons(s, 7-this.chevalet.getNbToEx());
                        resultat=0;
                    }

                }
                else{Ut.afficherSL("Placement invalide du mot");resultat=0;}
                break;
        }
        return resultat;
    }

    //-------Placement d’un mot----------

    /** pré-requis : les éléments de s sont inférieurs à 26
    * et nbPointsJet.length >= 26
    * action : simule le placement d’un mot de this :
    * a) le mot, sa position sur le plateau et sa direction, sont saisis
    * au clavier
    * b) vérifie si le mot est valide
    * c) si le coup est valide, le mot est placé sur le plateau
    * résultat : vrai ssi ce coup est valide, c’est-à-dire accepté par
    * CapeloDico et satisfaisant les règles détaillées plus haut
    * stratégie : utilise la méthode joueMotAux
    */
    public boolean joueMot(Plateau p, MEE s, int[] nbPointsJet) {
    boolean joue = false;
    String mot;
    String motMinus;
    int numLig;
    int numCol;
    char sens;
    Ut.afficher("saisir le mot en MAJUSCULE : ");
    mot=Ut.saisirChaine();
    motMinus=mot.toLowerCase();
    Ut.afficherSL("");

    Ut.afficher("saisir coordonnee de la ligne : ");
    numLig=Ut.saisirEntier();
    Ut.afficherSL("");

    Ut.afficher("saisir coordonnee de la colonne : ");
    numCol=Ut.saisirEntier();
    Ut.afficherSL("");

    Ut.afficher("saisir sens (h ou v) : ");
    sens=Ut.saisirCaractere();
    Ut.afficherSL("");
    
    if(p.placementValide(motMinus, numLig, numCol, sens, this.chevalet)==true && capeloDico(mot)==true){
        this.ajouteScore(p.nbPointsPlacement(motMinus, numLig, numCol, sens, nbPointsJet));
        p.place(motMinus, numLig, numCol, sens, chevalet);//place met déjà le mot en minus
        Ut.afficherSL("score de "+this.nom+" : "+this.getScore());
        joue=true;
    }

    return joue;
    }

    /** pré-requis : cf. joueMot et le placement de mot à partir de la case
    * (numLig, numCol) dans le sens donné par sens est valide
    * action : simule le placement d’un mot de this
    */
    public void joueMotAux(Plateau p, MEE s, int[] nbPointsJet, String mot,int numLig, int numCol, char sens) {
        if(p.placementValide(mot, numLig, numCol, sens, this.chevalet)==true && capeloDico(mot)==true){
            this.ajouteScore(p.nbPointsPlacement(mot, numLig, numCol, sens, nbPointsJet));
            p.place(mot, numLig, numCol, sens, chevalet);
            Ut.afficherSL(this.getScore());
        }
    }

    //--------Echange de lettres----------

    /**
    * pré-requis : sac peut contenir des entiers de 0 à 25
    * action : simule l’échange de jetons de ce joueur :
    * - saisie de la suite de lettres du chevalet à échanger
    * en vérifiant que la suite soit correcte
    * - échange de jetons entre le chevalet du joueur et le sac
    * stratégie : appelle les méthodes estCorrectPourEchange et echangeJetonsAux
    */
    public void echangeJetons(MEE sac) {

        Ut.afficher("saisir la suite de lettre en MAJUSCULE voulant etre echangee : ");
        String lettreEchange =Ut.saisirChaine();
        while(!estCorrectPourEchange(lettreEchange)){
            Ut.afficher("La suite de lettre saisie est incorrecte, reessayez : ");
            lettreEchange =Ut.saisirChaine();
        }
        echangeJetonsAux(sac, lettreEchange);
        Ut.afficherSL("L'echange a ete fait ! Votre nouveau chevalet :"+"\n"+this.chevalet.toString());

        
    }

    /** résultat : vrai ssi les caractères de mot correspondent tous à des
    * lettres majuscules et l’ensemble de ces caractères est un
    * sous-ensemble des jetons du chevalet de this
    */
    public boolean estCorrectPourEchange (String mot) {
        String motMinus = mot.toLowerCase();
        boolean verif = true;
        int i=0;
        while(verif && i <mot.length()){
            if(this.chevalet.getTabFreq()[Ut.alphaToIndex(motMinus.charAt(i))]<=0 || !Character.isUpperCase(mot.charAt(i))){
                verif =false;
            }
            i++;
        }
        return verif;
    }

    /** pré-requis : sac peut contenir des entiers de 0 à 25 et ensJetons
    * est un ensemble de jetons correct pour l’échange
    * action : simule l’échange de jetons de ensJetons avec des
    * jetons du sac tirés aléatoirement.
    */
    public void echangeJetonsAux(MEE sac, String ensJetons) {
        String motMinus = ensJetons.toLowerCase();
        int i=0;
        while(i<motMinus.length() && i<sac.getNbToEx()){
            this.chevalet.transfere(sac,Ut.alphaToIndex(motMinus.charAt(i)));
            i++;
        }
        sac.transfereAleat(this.chevalet,motMinus.length());

    }
}
