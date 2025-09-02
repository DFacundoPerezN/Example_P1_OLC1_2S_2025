/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import java.util.Stack;

public class AutomataPila extends Automata implements AutomataInterfaz {
    
    public ArrayList<TransicionPila> transicionesPila;
    public ArrayList<Character> simbolosPila;//P = {1,0}
    
    Stack<Character> pilaSimbolos = new Stack<>();
    int indexCadena; //Apuntador de la poscion de la cadena entrada 
    
    public void reporte(){
        String salida = "digraph AP { ";
        System.out.println("Reporte: ");
    }
    public void mostrarInfo(String name){
        System.out.println("Hola");
    }
    
    public void validar(String cadena){
        Character estadoActual = this.inicial;
        
        indexCadena = 0;
        while( indexCadena < cadena.length()){ //aabb
            System.out.println("-----------------");
            char caracter = cadena.charAt(indexCadena);
            estadoActual = cambiarEstado(estadoActual, caracter);
            if(estadoActual == null){
                System.out.println("no valido: la transicion no efectua");
                break;
            }
        }
        if(this.pilaSimbolos.empty()){
            System.out.println("no valido: la pila no esta vacia al final");
        }
        
        System.out.println(estadoValido(estadoActual) ? "valido" : "no valido");
    }
    
    private Character cambiarEstado(Character estadoActual, Character token){
        TransicionPila transicionPivote;
        for (int i = 0; i < this.transicionesPila.size(); i++) {
            transicionPivote = this.transicionesPila.get(i);
            
            if(transicionPivote.nombreEstadoPrimero == estadoActual ){
                System.out.println("Estado Actual: " + estadoActual);
                if (transicionPivote.caracter == token){
                    //extraer simbolo de pila
                    if (!sacarSimboloPila(transicionPivote)){
                       return null;
                    }
                    //ingresar simbolo de pila TransicionPila.SimboloI
                    meterSimboloPila(transicionPivote.simboloIntroducido);
                    //avanzamos al siguiente token 
                    this.indexCadena++;
                    return transicionPivote.nombreEstadoSiguiente;
                } else if(transicionPivote.caracter == '$'){
                    //extraer simbolo de pila
                    if (!sacarSimboloPila(transicionPivote)){
                       return null;
                    }
                    //ingresar simbolo de pila TransicionPila.SimboloI
                    meterSimboloPila(transicionPivote.simboloIntroducido);
                    return transicionPivote.nombreEstadoSiguiente;                    
                }
            }     
        }
        return null;
    }
    
    private Boolean sacarSimboloPila(TransicionPila transicionP){
        if ( transicionP.simboloExtraido != '$'){ // Si el simbolo no es el de vacio 
            if (transicionP.simboloExtraido == this.pilaSimbolos.peek()){
                //Si el simbolo del tope es el requerido por la transicion
                this.pilaSimbolos.pop(); //quita el simbolo de hasta arriba
                return true;
            } else{
                System.out.println("Simbolo de extracción no concuerda con "+this.pilaSimbolos.peek());
                return false;
            }
        } 
        return true;
    }
    
    private void meterSimboloPila(Character simboloIntroducido){
        if ( simboloIntroducido != '$'){ // Si el simbolo no es el de vacio 
            this.pilaSimbolos.push(simboloIntroducido);
        }
    }
    
    private Boolean estadoValido(Character estadoFinal){
        for (int i = 0; i< this.aceptados.size(); i++){
            Character estadoAceptado = (Character) this.aceptados.get(i);
            if(estadoFinal == estadoAceptado){
                return true;
            }
        }
        return false;
    }
}
