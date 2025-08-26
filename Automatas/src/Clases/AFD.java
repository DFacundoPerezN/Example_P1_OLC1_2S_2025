/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author Faxx
 */
public class AFD extends Automata implements AutomataInterfaz {
    public AFD( ArrayList estados, ArrayList alfabeto, ArrayList estadosA, char estadoI, ArrayList trancisiones ){
        this.inicial = estadoI;
        this.aceptados = estadosA;
        this.estados = estados;
        this.alfabeto = alfabeto;
        this.transiciones = trancisiones;
    }
    
    public void reporte(){
        System.out.println("Hola");
    }
    public void mostrarInfo(String nombre){
        System.out.println("Reporte: \n "
            + "Nombre: "+ nombre+ "\n"
            + "Tipo: Automata FInito Determinsita \n"
            + "Estados: "+ this.estados);
    }
    
    public void validar(String entrada){
        Character estadoActual = this.inicial;
        
        for (int i = 0; i < entrada.length(); i++) {                
            char caracter = entrada.charAt(i);
            estadoActual = cambiarEstado(estadoActual, caracter);
            if(estadoActual == null){
                System.out.println("no valido");
                break;
            }
        }
        /*if (estadoValido(estadoActual)){
            System.out.println("valido");
        }
        else{
            System.out.println("no valido valido");            
        }*/
        
        System.out.println(estadoValido(estadoActual) ? "valido" : "no valido");
    }
    
    public Character cambiarEstado(Character estadoActual, Character token){
        Transicion pivote;
        for (int i = 0; i < this.transiciones.size(); i++) {
            pivote = this.transiciones.get(i);

            if((pivote.nombreEstadoPrimero == estadoActual )&& (pivote.caracter == token)){
                return pivote.nombreEstadoSiguiente;
            }
                
        }
        return null;
    }
    
    public Boolean estadoValido(Character estadoFinal){
        for (int i = 0; i< this.aceptados.size(); i++){
            Character estadoAceptado = (Character) this.aceptados.get(i);
            if(estadoFinal == estadoAceptado){
                return true;
            }
        }
        return false;
    }
}
