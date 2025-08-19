package automatas;

import java.io.BufferedReader;
import java.io.StringReader;
import Analizadores.Parser;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Faxx
 */
public class Automatas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String estados = "N = {S, Q, B, C};";
        String alfa = "T = {0, 1};";
        String inicial = " I = {S}; ";
        String acep = "A = {B,C};";
        String afd = estados + alfa + inicial + acep;
        Analizadores.Scanner lexico  = new Analizadores.Scanner(new BufferedReader( new StringReader(afd)));
        Parser sintactico =new Parser(lexico);
        
        String consola;
        try {
            sintactico.parse();
        }catch (Exception ex) {
            //Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error fatal en compilacion de entrada.");
            consola = "//Error sintactico no deja compilar el archivo";
        }
    }
    
}
