import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

//package scrabbleSAE;

public class ScrabbleMain {

    public static void main(String args[]){

    MEE mee1,mee2,mee3;
    int [] tab = {3,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2};
    int [] tab3 = {5,1,2,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2};
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
    P.place("zaaccz",8,4,'h', mee1);
    //Ut.afficherSL(P.toString());

    P.placementValide("zaaccz", 8, 9,'v', mee3);
    P.place("zaaccz",8,9,'v', mee3);
    Ut.afficherSL("");
    P.placementValide("baka", 10, 8,'h', mee3);
    P.place("baka",10,8,'h', mee3);
    Ut.afficherSL(P.toString());
    }
    
}
