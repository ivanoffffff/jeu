/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeu_isotopic_256;

/*
 Andre Léonard
 Bosq Lucas
 Cocusse Ivan
 Groupe CB
 07/01/2023
 */

public class Element {
    
    private String NomEl;
    private long NumeroEl;
    //private int TempsVie;

    public Element(String NomEl, long NumeroEl) {
        this.NomEl = NomEl;
        this.NumeroEl = NumeroEl;
    }
    
    public Element(String NomEl){
        this.NomEl=NomEl;
    }

    public String toString() {
        if (NomEl.equals("         ")==true){
            return NomEl;}
        else 
            return NomEl + NumeroEl ;
    }

    public String getNomEl() {
        return NomEl;
    }

    public long getNumeroEl() {
        return NumeroEl;
    }
    
    
    public int getTempsVie() {
        return 0;
    }
    
    public String versFichier(){
        if (NomEl.equals("         ")==true){
            return System.lineSeparator()+NomEl;
        }
        return System.lineSeparator()+NomEl+"/"+ NumeroEl;  
    }
}