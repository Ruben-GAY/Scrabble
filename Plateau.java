import javax.swing.DefaultBoundedRangeModel;

public class Plateau {
    private Case[][] g;

    public Plateau(){
        int[][] plat={{5,1,1,2,1,1,1,5,1,1,1,2,1,1,5},
                      {1,4,1,1,1,3,1,1,1,3,1,1,1,4,1},
                      {1,1,4,1,1,1,2,1,2,1,1,1,4,1,1},
                      {2,1,1,4,1,1,1,2,1,1,1,4,1,1,2},
                      {1,1,1,1,4,1,1,1,1,1,4,1,1,1,1},
                      {1,3,1,1,1,3,1,1,1,3,1,1,1,3,1},
                      {1,1,2,1,1,1,2,1,2,1,1,1,2,1,1},
                      {5,1,1,2,1,1,1,4,1,1,1,2,1,1,5},
                      {1,1,2,1,1,1,2,1,2,1,1,1,2,1,1},
                      {1,3,1,1,1,3,1,1,1,3,1,1,1,3,1},
                      {1,1,1,1,4,1,1,1,1,1,4,1,1,1,1},
                      {2,1,1,4,1,1,1,2,1,1,1,4,1,1,2},
                      {1,1,4,1,1,1,2,1,2,1,1,1,4,1,1},
                      {1,4,1,1,1,3,1,1,1,3,1,1,1,4,1},
                      {5,1,1,2,1,1,1,5,1,1,1,2,1,1,5}};

        this.g= new Case[plat.length][plat.length];
        for(int i=0;i<plat.length;i++){
            for(int j=0;j<plat[i].length;j++){
                this.g[i][j] = new Case(plat[i][j]);
            }
        }
        
                   
    }
    
    public Plateau (Case[][] plateau) {
        this.g = plateau;
        }

    public String toString(){
        String affiche="  |";
        String[] tabLettre = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
        for(int i = 1;i<=tabLettre.length;i++){
            if(i<=9){
                affiche+=i+" |"; 
            }
            else{
            affiche+=i+"|";
            }
        
        }       
        for(int i=0;i<this.g.length;i++){
            for(int j=0;j<this.g[i].length;j++){
                if(j==0){
                    //affiche+=("\n"+"   --------------------------------------------");
                    affiche+="\n"+tabLettre[i]+" |";
                }             
                if(g[i][j].estRecouverte()==true){
                    affiche+=g[i][j].getLettre()+" |";
                }
                else if(this.g[i][j].estRecouverte()==false && this.g[i][j].getCouleur()>1){
                    affiche+=g[i][j].getCouleur()+" |";
                }
                else{
                    affiche+="  |";                  
                }
            } 
        }
        return affiche;
    }


    /*
    * pré-requis : le mot est écrit en minuscule
    * résultat : retourne vrai si le mot est dans le chevalet, faux sinon
    *commentaire : l'ensemble copie permet, dans le cas où mot contiendrait une lettre en double mais que le chevalet
    *en contiendrait qu'un examplaire, de ne pas valider le mot
    */
    public boolean CoherenceMot(String mot,MEE e,int numLig,int numCol,Character sens){
        boolean verif  = true;
        int i=0;
        MEE copie= new MEE(e);
        switch(sens){
            case 'h' :
                while(verif && i <mot.length()){
                    if(copie.getTabFreq()[Ut.alphaToIndex(mot.charAt(i))]>0 || Character.toUpperCase(mot.charAt(i))==this.g[numLig][numCol+i].getLettre()){
                        copie.retire(Ut.alphaToIndex(mot.charAt(i)));
                    }
                    else{
                        verif = false;
                    }
                    i++;
            }
            case 'v' :
                while(verif && i <mot.length()){
                    if(copie.getTabFreq()[Ut.alphaToIndex(mot.charAt(i))]>0 || Character.toUpperCase(mot.charAt(i))==this.g[numLig+i][numCol].getLettre()){
                        copie.retire(Ut.alphaToIndex(mot.charAt(i)));
                    }
                    else{
                        verif = false;
                    }
                    i++;
            }

        }
        //Ut.afficherSL("cherenceMot : "+verif);
        return verif;
    }
    
    /*
    *pré-requis : mot en minuscule
    *résultat : renvoie vrai si pour chaque case recouverte par un jeton de la zone de placement du mot, la lettre du
    *jeton est la même que celle du mot à placer dans cette case et il faut aussi que la zone contient au moins une case
    *découverte et une case non découverte, faux sinon
    */
    public boolean zoneValide(char sens,String mot,int numLig,int numCol){
        boolean nonRecouverte = false;
        boolean condition = false;
        boolean verif = false;
        int i=0;

        switch(sens){
            case'h':
                while(i<mot.length()){
                    //Ut.afficherSL("i : "+i+"lettreMot : "+mot.charAt(i)+", case recouverte ?"+this.g[numLig][numCol+i].estRecouverte());
                    if(this.g[numLig][numCol+i].estRecouverte()==false){
                        nonRecouverte=true;                    
                    }
                    else if(this.g[numLig][numCol+i].estRecouverte()==true && this.g[numLig][numCol+i].getLettre()==Character.toUpperCase(mot.charAt(i))){
                        verif = true;
                    }
                    else if(this.g[numLig][numCol+i].estRecouverte()==true && this.g[numLig][numCol+i].getLettre()!=Character.toUpperCase(mot.charAt(i))){
                        verif = false;
                        break;
                    }
                    
                    i++;
                }
                break;
            case'v':
                while(i<mot.length()){
                    //Ut.afficherSL("i : "+i+"lettreMot : "+mot.charAt(i)+", case recouverte ?"+this.g[numLig+i][numCol].estRecouverte());
                    if(this.g[numLig+i][numCol].estRecouverte()==false){
                        nonRecouverte=true;
                    } 
                    else if(this.g[numLig+i][numCol].estRecouverte()==true && this.g[numLig+i][numCol].getLettre()==Character.toUpperCase(mot.charAt(i))){
                        verif = true;
                    }
                    else if(this.g[numLig+i][numCol].estRecouverte()==true && this.g[numLig+i][numCol].getLettre()!=Character.toUpperCase(mot.charAt(i))){
                        verif = false;
                        break;
                    }
                    
                    i++;
                }
                break;
        }
        
        //Ut.afficherSL("nonRecouverte : "+nonRecouverte);
        //Ut.afficherSL("verif : "+verif);
        
        if(nonRecouverte==true && verif==true){
            condition=true;
        }
        //Ut.afficherSL("zone Valide : "+verif);
        return condition;
        
    }
    
    /*
    * pré-réquis : sens en miniuscule
    * résultat  : retourne vrai si la zone est ni précédé ni suivie d'une lettre, faux sinon 
    */
    public boolean libreMot(char sens,String mot,int numLig,int numCol){
        boolean verif = false;
        switch(sens){
            case 'h':
                if(numCol+mot.length()<this.g.length){
                    if((numCol==0 || this.g[numLig][numCol-1].estRecouverte()==false) 
                      &&
                      ((numCol+mot.length()==this.g.length-1 || this.g[numLig][numCol+mot.length()].estRecouverte()==false))){
                        verif = true;
                    }
                }
                break;
            case 'v':
                if(numLig+mot.length()<this.g.length){
                    if((numLig == 0 || this.g[numLig-1][numCol].estRecouverte()==false ) 
                      &&
                      (numLig+mot.length()==this.g.length-1  || this.g[numLig+mot.length()][numCol].estRecouverte()==false)){
                        verif = true;
                    }
                }
            break;

        }
        //Ut.afficherSL("libreMot :"+verif);
        return verif;
    }
    
    /**
    * pré-requis : mot est un mot accepté par CapeloDico,
    * 0 <= numLig <= 14, 0 <= numCol <= 14, sens est un élément
    * de {’h’,’v’} et l’entier maximum prévu pour e est au moins 25
    * résultat : retourne vrai ssi le placement de mot sur this à partir
    * de la case (numLig, numCol) dans le sens donné par sens à l’aide
    * des jetons de e est valide.
    */
    public boolean placementValide(String mot, int numLig, int numCol,char sens, MEE e) {
        //boolean debut = true;
        boolean valide = false;

        //-----cas où le plateau est vide-------
        if(this.g[(this.g.length/2)][(this.g.length/2)].estRecouverte()==false && mot.length()>=2 ){
            //Ut.afficherSL("ici");
            switch(sens){
                case 'h':
                    if(numCol-1 + mot.length()<(15) &&
                       numCol-1 + mot.length()>=(7)&& 
                       numLig-1==7 &&
                       CoherenceMot(mot, e,numLig-1,numCol-1,sens)){
                       valide = true;                       
                    }
                    break;
                case 'v':
                    if(numLig-1 + mot.length()<(15) &&
                       numLig-1 + mot.length()>=(7)&&
                       numCol-1==7 && 
                       CoherenceMot(mot, e,numLig-1,numCol-1,sens)){
                       valide = true;                 
                    }
                    break;
            }
        }
        //-----cas où le plateau n’est pas vide------
        if(this.g[(this.g.length/2)][(this.g.length/2)].estRecouverte()==true){

            if(CoherenceMot(mot, e,numLig-1,numCol-1,sens)==true && libreMot(sens, mot, numLig-1, numCol-1)==true && zoneValide(sens, mot, numLig-1, numCol-1)==true ){
                valide =true;
            }            
        }
        Ut.afficherSL("placementValide : "+valide);
        return valide;
    }
    
    /**
    * pré-requis : le placement de mot sur this à partir de la case
    * (numLig, numCol) dans le sens donné par sens est valide
    * résultat : retourne le nombre de points rapportés par ce placement, le
    * nombre de points de chaque jeton étant donné par le tableau nbPointsJet.
    */
    public int nbPointsPlacement(String mot, int numLig, int numCol,char sens, int[] nbPointsJet) {
        int nbPoints =0;
        int motDouble = 0;
        int motTriple = 0;
        switch(sens){
            case 'h':
                for(int i=0;i<mot.length();i++){
                    //Ut.afficherSL("nbPoints  avant coup : "+nbPoints); test
                    switch(this.g[numLig-1][numCol-1+i].getCouleur()){
                        case 2:                           
                            nbPoints+=nbPointsJet[Ut.alphaToIndex(mot.charAt(i))]*2;
                            break;
                        case 3:
                            nbPoints+=nbPointsJet[Ut.alphaToIndex(mot.charAt(i))]*3;
                            break;
                        case 4:
                            nbPoints+=nbPointsJet[Ut.alphaToIndex(mot.charAt(i))];
                            motDouble++;
                            break;
                        case 5:
                            nbPoints+=nbPointsJet[Ut.alphaToIndex(mot.charAt(i))];
                            motTriple++;
                            break;
                        default:
                            nbPoints+=nbPointsJet[Ut.alphaToIndex(mot.charAt(i))];
                            break;

                    }
                    /*test
                    Ut.afficherSL("lettre : "+mot.charAt(i)+", valeur lettre :"+nbPointsJet[Ut.alphaToIndex(mot.charAt(i))]+
                    ",coef couleur"+this.g[numLig-1][numCol-1+i].getCouleur()+"coordonne : "+numLig+" "+numCol+"-1+"+i+", nbPoints : "+nbPoints);
                    */
                }
            break;
            case 'v':
                for(int i=0;i<mot.length();i++){
                    //Ut.afficherSL(" nbPoints  avant coup: "+nbPoints); test
                    switch(this.g[numLig-1+i][numCol-1].getCouleur()){
                        case 2:
                            nbPoints+=nbPointsJet[Ut.alphaToIndex(mot.charAt(i))]*2;
                            break;
                        case 3:
                            nbPoints+=nbPointsJet[Ut.alphaToIndex(mot.charAt(i))]*3;
                            break;
                        case 4:
                            nbPoints+=nbPointsJet[Ut.alphaToIndex(mot.charAt(i))];
                            motDouble++;
                            break;
                        case 5:
                            nbPoints+=nbPointsJet[Ut.alphaToIndex(mot.charAt(i))];
                            motTriple++;
                            break;
                        default:
                            nbPoints+=nbPointsJet[Ut.alphaToIndex(mot.charAt(i))];
                        break;
                    }
                    /*
                    Ut.afficherSL("lettre : "+mot.charAt(i)+"valeur lettre :"+nbPointsJet[Ut.alphaToIndex(mot.charAt(i))]+
                    ", coef couleur"+this.g[numLig+i-1][numCol-1].getCouleur()+this.g[numLig-1][numCol-1+i].getCouleur()+"coordonne : "+numLig+this.g[numLig-1][numCol-1+i].getCouleur()+"coordonne : "+numLig+" "+numCol+"-1+"+i+" "+numCol+" nbPoints : "+nbPoints);
                    */
                }             
            break;
        }
        if(motDouble>0){
            nbPoints=nbPoints*2*motDouble;
        }
        else if(motTriple>0){
            nbPoints=nbPoints*3*motTriple;
        }
        else if(mot.length()==7){
            nbPoints+=50;
        }
        return nbPoints;

    }

    /**
    * pré-requis : le placement de mot sur this à partir de la case
    * (numLig, numCol) dans le sens donné par sens à l’aide des
    * jetons de e est valide.
    * action/résultat : effectue ce placement et retourne le
    * nombre de jetons retirés de e.
    * précisions: le placement de l'index se fait en fonction de 
    * l'indice se fait par rapport aux coordonnés de l'affichage du plateau
    * c'est à dire que quand l'utilisateur placera son mot à la ligne 8
    * et la colonne 4, en réalité se placera à l'indice 7 et 3 du tableau 
    * à deux dimensions(case [][] g)
    */
    public int place(String mot, int numLig, int numCol, char sens, MEE e){
        String motMinus = mot.toLowerCase(); // on convertit le mot minuscule pour être sûr de ne pas davoir d'erreur
        int compteur=0;
        //Ut.afficherSL(e.toString());//test pour voir si le chevalet se vide correctement au placement du mot
        switch(sens){
            case 'h':
                for(int i=0;i<motMinus.length();i++){
                    if(this.g[numLig-1][numCol-1+i].estRecouverte()==false){
                        this.g[numLig-1][numCol-1+i].setLettre(motMinus.charAt(i));
                        compteur++;
                        e.retire(Ut.alphaToIndex(motMinus.charAt(i)));
                    }
                }
                break;
            case 'v':
                for(int i=0;i<motMinus.length();i++){
                    if(this.g[numLig-1+i][numCol-1].estRecouverte()==false){
                        this.g[numLig-1+i][numCol-1].setLettre(motMinus.charAt(i));
                        compteur++;
                        e.retire(Ut.alphaToIndex(mot.charAt(i)));
                        //Ut.afficher(e.toString());
                        
                    }
                }
                break;
        }
        //Ut.afficherSL(e.toString());//test pour voir si le chevalet se vide correctement au placement du mot
        
        return compteur;
        
    }
}

