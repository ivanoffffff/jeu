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

public class ElementInstable extends Element {

    private int TempsVie;
    
    public ElementInstable(String NomEl, int NumeroEl,int TempsVie) {
        super(NomEl, NumeroEl);
        this.TempsVie=TempsVie;
    }

    public String toString() {
        return super.toString()+"("+(TempsVie+1)+")";
    }
    
    public int getTempsVie() {
        return TempsVie;
    }
    
    public String versFichier(){
        return super.versFichier()+"/"+TempsVie;
    }

}