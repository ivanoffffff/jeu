
package jeu_isotopic_256;

import java.io.IOException;
import java.util.Scanner;

/*
 Andre Léonard
 Bosq Lucas
 Cocusse Ivan
 Groupe CB
 07/01/2023
 */
public class Jeu_Isotopic_256 {

    public static void main(String[] args) throws ErreurInstruction, IOException, InterruptedException {
        
       Scanner sc= new Scanner(System.in);
       String Taillegrille="0";
       String ElmaxS="";
       String choix="";
       int Elchimiquemax=0;
       boolean init=true,dir=true,deplacementPossible=false;
       String instruction="";
       Element max=new ElementInstable("Sn",Elchimiquemax,96);
       
       System.out.println("Voulez-vous commencer une nouvelle partie(new) ou charger la précédente (charger) ? ");
       while (init){    
            try{
                choix =sc.nextLine();
                if (choix.equals("new")==false&&choix.equals("charger")==false){
                    throw new ErreurInstruction(">> Erreur. Veuillez choisir une instruction valide 'new' ou 'charger' : ");  
                }
                init=false;
            }catch (ErreurInstruction ex){
                System.out.println(ex.getMessage());
            }
        }
        init=true;
       
           
        if (choix.equals("new")){
            System.out.println("Choix de la taille de la grille : 3 (3x3), 4 (4x4) ou 5 (5x5) : ");
            while (init){    
                try{
                    Taillegrille=sc.nextLine();
                    if (Taillegrille.equals("3")==false&&Taillegrille.equals("4")==false&&Taillegrille.equals("5")==false){
                        throw new ErreurInstruction(">> Erreur. Veuillez choisir une taille de grille entre 3 et 5 : ");  
                    }
                    init=false;
                }catch (ErreurInstruction ex){
                    System.out.println(ex.getMessage());
                }
            }
            int Tgrille=Integer.parseInt(Taillegrille);

            Jouer Partie=new Jouer(Tgrille);

            System.out.println("Choix de l'élément chimique à atteindre, 1 (Etain 128) ou 2 (Nobélium 256)  : ");
            while (init==false){
                try{
                    ElmaxS=sc.nextLine();
                    if(ElmaxS.equals("1")==false&&ElmaxS.equals("2")==false){
                        throw new ErreurInstruction(">> Erreur. Veuillez choisir un des deux éléments chimiques suivants (1) pour l'Etain 128 (2) pour le Nobélium 256 : ");
                    }
                    init=true;
                }catch (ErreurInstruction ex){
                    System.out.println(ex.getMessage());
                } 
            }
            int ElmaxI=Integer.parseInt(ElmaxS);
            switch(ElmaxI){
                case 1 ->{
                    Elchimiquemax = 128;
                }
                case 2 -> {
                    Elchimiquemax = 256;
                    max=new Element("   N  ",Elchimiquemax);
                }
            }
             
            /*Test de toutes les méthodes "deplacer": Droite, Haut, Gauche, Bas
            Partie.deplacerD(); 
            Partie.afficher();
            Partie.deplacerH();
            Partie.afficher();
            Partie.deplacerG();
            Partie.afficher();
            Partie.deplacerB();
            Partie.afficher();*/
            //Partie.debuterTest(Tgrille);                
            Partie.debuter(Tgrille);

            Partie.afficher();
            while(Partie.FinPartie(max)==false){
                System.out.println("Choix de l'instruction, (Z) Haut, (S) Bas, (D) Droite, (Q) Gauche, (P) Sauvegarder : ");
                while (dir){    
                    try{
                        instruction=sc.nextLine();
                        if (instruction.equals("Z")==false&&instruction.equals("S")==false&&instruction.equals("D")==false&&instruction.equals("Q")==false&&instruction.equals("P")==false){
                            throw new ErreurInstruction(">> Erreur. Veuillez choisir une instruction valide (Z) Haut, (S) Bas, (D) Droite, (Q) Gauche, (P) Sauvegarder : ");  
                        }
                        dir=false;
                    }catch (ErreurInstruction ex){
                        System.out.println(ex.getMessage());
                    }
                }
                dir=true;
                if (instruction.compareTo("P")==0){
                    String T[] = {".",".","."," ","à"," ","b","i","e","n","t","ô","t"," ","!","   "};
                    Partie.SavePartie(Elchimiquemax);
                    System.out.print("Partie sauvegardée ");
                    for (String T1 : T) {
                        Thread.sleep(250);
                        System.out.print(T1);
                    }
                    break;
                }

                else{
                    deplacementPossible=Partie.AplDeplacementFusion(instruction);
                    if (deplacementPossible==true){
                        Partie.afficher();
                        System.out.println("Score : "+Partie.getScore());
                    }
                }
            }
        }
           
        else {
            Jouer PartieCharge=new Jouer();
            PartieCharge.debuter();
            PartieCharge.afficher();
            long NumeroElmax= PartieCharge.ChargerPartie();
            if (NumeroElmax==256)
                max=new Element("   N  ",Elchimiquemax);
            
            while(PartieCharge.FinPartie(max)==false){
                deplacementPossible=false;
                System.out.println("Choix de l'instruction, (Z) Haut, (S) Bas, (D) Droite, (Q) Gauche, (P) Sauvegarder : ");
                while (dir){
                    try{
                        instruction=sc.nextLine();
                        if (instruction.equals("Z")==false&&instruction.equals("S")==false&&instruction.equals("D")==false&&instruction.equals("Q")==false&&instruction.equals("P")==false){
                            throw new ErreurInstruction(">> Erreur. Veuillez choisir une instruction valide (Z) Haut, (S) Bas, (D) Droite, (Q) Gauche, (P) Sauvegarder : ");  
                        }
                        dir=false;
                    }catch (ErreurInstruction ex){
                        System.out.println(ex.getMessage());
                    }
                }
                dir=true;
                if (instruction.compareTo("P")==0){
                    String T[] = {".",".","."," ","à"," ","b","i","e","n","t","ô","t"," ","!","   "};
                    PartieCharge.SavePartie(Elchimiquemax);
                    System.out.print("Partie sauvegardée ");
                    for (String T1 : T) {
                        Thread.sleep(250);
                        System.out.print(T1);
                    }
                    break;
                }

                else{
                    deplacementPossible=PartieCharge.AplDeplacementFusion(instruction);
                    if (deplacementPossible==true){
                        PartieCharge.afficher();
                        deplacementPossible=false;
                        System.out.println("Score : "+PartieCharge.getScore());
                    }
                }
            }
        }
    }
}