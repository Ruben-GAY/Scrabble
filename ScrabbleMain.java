import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

//package scrabbleSAE;

public class ScrabbleMain {

    private static int[] nbPointsJeton={1,3,3,2,1,4,2,4,1,8,10,1,2,1,1,3,8,1,1,1,1,4,10,10,10,10};
    public static void main(String args[]){

    MEE mee1,mee2,mee3,mee4;
    int [] tab = {3,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2};
    int [] tab3 = {12,4,4,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2};
    int [] tab4 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int [] sac ={3,1,2,3,2,5,1,1,4,5,2,2,3,3,6,5,3,4,1,1,2,2,2,1,1,1};
    mee1= new MEE(tab);
    mee2=new MEE(mee1);
    mee3=new MEE(tab3);
    mee4 = new MEE(sac);
    //Ut.afficherSL(mee1.getNbToEx());

    //Ut.afficherSL(mee1.estVide());
    //mee1.retireAleat();
    /*
    Ut.afficherSL(mee1.toString());
    Ut.afficherSL(mee3.toString());
    mee1.transfereAleat(mee3, 1);
    Ut.afficherSL(mee1.toString());
    Ut.afficherSL(mee3.toString());
    */
    //Ut.afficherSL(mee1.sommeValeurs(v));
    // ------- test case----------
    //Case c1=new Case(3);
    
    //System.out.println(c1.estRecouverte());
    /*
    Plateau P;
    P=new Plateau();
    */

    //--------test placement valide et place dans Classe
    /*
    Ut.afficherSL("mot : zaaccz");
    Ut.afficherSL(mee1.toString());
    P.placementValide("zaaccz", 8, 8,'h', mee1);
    P.place("zaaccz",8,8,'h', mee1);
    Ut.afficherSL(mee1.toString());
    System.out.println();
    
    Ut.afficherSL("mot : zaaccz");
    Ut.afficherSL(mee3.toString());
    P.placementValide("zaaccz", 8, 8,'v', mee3);
    P.place("zaaccz",8,8,'v', mee3);
    Ut.afficherSL(mee3.toString());
    System.out.println();
    
    
    Ut.afficherSL("mot : bak");
    Ut.afficherSL(mee3.toString());
    P.placementValide("bak", 10, 8,'h', mee3);
    P.place("bak",10,8,'h', mee3);
    Ut.afficherSL(mee3.toString());
    System.out.println();

    
    Ut.afficherSL("cabaa test");
    Ut.afficherSL(mee3.toString());
    P.placementValide("cabaaa", 7, 6,'v', mee3);
    P.place("cabaaa",7,6,'v', mee3);
    Ut.afficherSL(mee3.toString());
    Ut.afficherSL("");

    Ut.afficherSL("abbak");
    Ut.afficherSL(mee3.toString());
    P.placementValide("abbak", 10, 6,'h', mee3);
    P.place("abbak",10,6,'h', mee3);
    Ut.afficherSL(mee3.toString());
    Ut.afficherSL("");
    */

    //------ test joueur--------

    /*
    Joueur j1 = new Joueur("Steph");
    j1.prendJetons(mee4, 7);
    j1.joue(P,mee4, nbPointsJeton);
    
    j1.joue(P,mee4, nbPointsJeton);
    j1.joue(P,mee4, nbPointsJeton);
    j1.joue(P,mee4, nbPointsJeton);
    j1.joue(P,mee4, nbPointsJeton);
    j1.joue(P,mee4, nbPointsJeton); 
    j1.joue(P,mee4, nbPointsJeton);    
    Ut.afficherSL(P.toString());
    */
    int nbrJoueur;
    String nomJoueur;
    Ut.afficher("saisir nombre de joueur : ");
    nbrJoueur = Ut.saisirEntier();

    String[] tabJ=new String[nbrJoueur];

    for(int i=0;i<nbrJoueur;i++){
        Ut.afficher("saisir nom du joueur "+i+" : ");
        nomJoueur=Ut.saisirChaine();
        tabJ[i]=nomJoueur;

    }
    Scrabble partie= new Scrabble(tabJ,sac);
    partie.partie(nbrJoueur);
    }
    
}
