/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Faxx
 */
public class TransicionPila extends Transicion{
    char simboloIntroducido;
    char simboloExtraido;
    
    public TransicionPila (char carac, char nombreEstado, char nombreSiguiente, char sIntro, char sExt ){
        super(carac, nombreEstado, nombreSiguiente);
        this.simboloExtraido = sExt;
        this.simboloIntroducido = sIntro;
    }
}
