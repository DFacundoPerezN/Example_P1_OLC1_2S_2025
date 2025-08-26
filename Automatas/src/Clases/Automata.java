/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.List;
import java.util.ArrayList;
//Es la clase padre, donde definimos los atributos que usaran las clases hijos
public class Automata {
    public ArrayList estados;
    public ArrayList alfabeto;
    
    public char inicial;
    public ArrayList aceptados;
    public ArrayList<Transicion> transiciones;
}