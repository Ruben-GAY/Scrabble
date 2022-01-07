import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

//package scrabbleSAE;

public class ScrabbleMain {

    public static void main(String args[]){

    MEE mee1,mee2,mee3;
    int [] tab = {3,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2};
    int [] tab3 = {12,4,4,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2};
    int [] v ={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    mee1= new MEE(tab);
    mee2=new MEE(mee1);
    mee3=new MEE(tab3);
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
    
    Plateau P;
    P=new Plateau();
    //Ut.afficherSL(P.toString());
    
    //Ut.afficherSL(P.placementValide("zaaccz", 8, 4,'h', mee1));
    //P.place("zaaccz", 4, 8,'v', mee1);
    //Ut.afficher(P.toString());
    Ut.afficherSL("mot : zaaccz");
    Ut.afficherSL(mee1.toString());
    P.placementValide("zaaccz", 8, 4,'h', mee1);
    P.place("zaaccz",8,4,'h', mee1);
    Ut.afficherSL(mee1.toString());
    System.out.println();
    
    //Ut.afficherSL(P.toString());
    Ut.afficherSL("mot : zaaccz");
    Ut.afficherSL(mee3.toString());
    P.placementValide("zaaccz", 8, 9,'v', mee3);
    P.place("zaaccz",8,9,'v', mee3);
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
    
    
    Ut.afficherSL(P.toString());
    }
    
}
