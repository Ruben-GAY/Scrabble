public class Scrabble {
    private Joueur[] joueurs;
    private int numJoueur; // joueur courant (entre 0 et joueurs.length-1)
    private Plateau plateau;
    private MEE sac;
    private static int[] nbPointsJeton={1,3,3,2,1,4,2,4,1,8,10,1,2,1,1,3,8,1,1,1,1,4,10,10,10,10};

    public Scrabble(String[] tabJ,int[] s){
        this.joueurs=new Joueur[tabJ.length];
        for(int i = 0;i<tabJ.length;i++){
            this.joueurs[i]=new Joueur(tabJ[i]);
        }
        this.numJoueur=numJoueur;
        this.plateau=new Plateau();
        this.sac=new MEE(s);
    }

    public void setNumJoueur(int J){
        this.numJoueur=J;
    }

    

    public String toString(){
        String affiche;
        affiche="A "+joueurs[this.numJoueur].getNom()+"\n"+plateau.toString();
        return affiche;
    }

    public void partie(int totJ){
        int tourP=0;
        //int tourJ=0;
        //int scoreGagnant=0;
        int[] gagnant = new int[totJ];
        int parcoursGagnant=0;
        boolean fini = false;

        //---------distribution initiale des jetons aux joueurs-------
        for(int i=0;i<totJ;i++){
            joueurs[i].prendJetons(this.sac,7);
        }
        
        //tourJ=Ut.randomMinMax(0,totJ-1);
        setNumJoueur(Ut.randomMinMax(0,totJ-1));
        //Ut.afficherSL("Joueur qui commence :"+joueurs[this.numJoueur].getNom());

        while(!this.sac.estVide() && /*this.joueurs[numJoueur].getChevalet().estVide()*/fini==false && tourP<totJ){
            Ut.afficherSL("\n"+"Au tour de:"+joueurs[this.numJoueur].getNom());
            switch(joueurs[this.numJoueur].joue(this.plateau,this.sac,this.nbPointsJeton)){
                case(-1):
                    tourP++;
                    break;

                case(1):
                    gagnant[0]=0;
                    for(int i=1;i<totJ;i++){
                        if(joueurs[i].getScore()>joueurs[gagnant[0]].getScore()){
                            gagnant[parcoursGagnant]=i;
                        }
                        else if(joueurs[i].getScore()==joueurs[gagnant[0]].getScore()){
                            parcoursGagnant++;
                            gagnant[parcoursGagnant]=i;
                        }
                    }
                    Ut.afficherSL("La partie est termine !");
                    for(int i=0;i<=parcoursGagnant;i++){
                         Ut.afficherSL("Felicitation !"+joueurs[gagnant[i]].getNom()+" avec un score de "+joueurs[gagnant[i]].getScore());
                    }
                    fini =true;
                    break;

                case(0):
                    break;   
            }
            if(this.numJoueur==totJ-1){
                setNumJoueur(0);
            }
            else{
                setNumJoueur(this.numJoueur+1);
            } 
        }
        if(tourP==totJ){
            gagnant[0]=0;
            for(int i=1;i<totJ;i++){
                if(joueurs[i].getScore()>joueurs[gagnant[0]].getScore()){
                    gagnant[parcoursGagnant]=i;
                }
                else if(joueurs[i].getScore()==joueurs[gagnant[0]].getScore()){
                    parcoursGagnant++;
                    gagnant[parcoursGagnant]=i;
                }
            }
            Ut.afficherSL("La partie est termine !");
            for(int i=0;i<=parcoursGagnant;i++){
                Ut.afficherSL("Felicitation !"+joueurs[gagnant[i]].getNom()+" avec un score de "+joueurs[gagnant[i]].getScore());
            }
        }
        Ut.afficherSL("\n"+plateau.toString());
    }
    
}
