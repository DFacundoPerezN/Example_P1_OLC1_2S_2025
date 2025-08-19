/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Faxx
 */
public class AFD extends Automata implements AutomataInterfaz {
    public AFD( char[] estados, char[] alfabeto, char[] estadosA, char estadoI ){
        this.inicial = estadoI;
        this.aceptados = estadosA;
        this.estados = estados;
        this.alfabeto = alfabeto;
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
}
