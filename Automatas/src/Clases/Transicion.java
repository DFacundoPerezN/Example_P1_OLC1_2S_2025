/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Faxx
 */
public class Transicion {
    char caracter;
    char nombreEstadoPrimero;
    char nombreEstadoSiguiente;
    
    public Transicion( char c, char nombreEstado, char nombreSiguiente){
        this.caracter = c;
        this.nombreEstadoPrimero = nombreEstado;
        this.nombreEstadoSiguiente = nombreSiguiente;
    }
}
