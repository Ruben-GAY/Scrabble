
public class Joueur {
    private String nom;
    private MEE chevalet;
    private int score;    

    public Joueur(String nom){
        this.nom = nom;
        this.chevalet=chevalet;
        this.score=score;
    }

    public int getScore(){
        return this.score;
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
        /*
        for(int i=0; i<=nbJetons; i++){
            this.chevalet.ajoute(s.retireAleat());
        }
        */
        this.chevalet.transfereAleat(s,nbJetons); //2eme façon de faire
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
        int echange;
        char lettre;
        Ut.afficherSL("A vous de jouez ! ");
        Ut.afficherSL("Pour passez son tour, cliquez : 1 ");
        Ut.afficherSL("Pour passez votre tour et echanger des jetons, cliquez : 2 ");
        Ut.afficherSL("Pour placez un mot, cliquez : 3 ");
        action = Ut.saisirEntier();

        switch(action){
            case 1:
                resultat=-1;
                break;
            
            case 2:
                /*
                Ut.afficher("Saisir le nombre de jeton voulant etre echange(entre 1 et 7): ");
                echange = Ut.saisirEntier();
                for(int i=0;i<echange;i++){
                    Ut.afficher("Saisir la lettre voulant etre echange en minuscule :");
                    lettre = Ut.saisirCaractere();


                }
                */
                this.echangeJetons(s);
                break;

            case 3:
                if(joueMot(p, s, nbPointsJet)){
                    if (this.chevalet.estVide()) {
                    resultat = 1;
                    }
                }
                else{Ut.afficher("Placement invalide du Mot");}
                break;
        }


        return resultat;
    }
    
}
