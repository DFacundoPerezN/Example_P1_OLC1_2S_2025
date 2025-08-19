/* 1. Package e importaciones */
package Analizadores;
import java_cup.runtime.*;

%%
/* 2. Configuraciones para el analisis (Opciones y Declaraciones) */
%{
    //Codigo de usuario en sintaxis java
    //Agregar clases, variables, arreglos, objetos etc...
    public class Lexema{        
            public String lexema;
            public String token;


            public Lexema(String lexema, String token){
            this.lexema = lexema;
            this.token = token;
        }
    }
%}

//Directivas
%class Scanner
%public 
%cup
%char
%column
%full
%line
%unicode
//%ignorecase
//%debug

//Inicializar el contador de yychar y fila con 1
%init{ 
    yyline = 1; 
    yychar = 1; 
%init}

//Expresiones regulares
COMMENT_1LINE = "//" .* [^\n] \n
//COMMENT_MULTLINE = "/*" [^"*/"] "*/"
NUM = [0-9]+
BLANCOS=[ \r\t]+
ID =  [a-zA-Z][a-zA-Z_0-9]*
CHAR = [a-z_0-9]
Estado = [A-Z]

//Palabras reservadas
%%
"N" {    
    return new Symbol(sym.PR_N,yyline,yychar,yytext());
}
"T" {    
    return new Symbol(sym.PR_T,yyline,yychar,yytext());
}
"I" {    
    return new Symbol(sym.PR_I,yyline,yychar,yytext());
}
"A" {    
    return new Symbol(sym.PR_A,yyline,yychar,yytext());
}

//Simbolos
"{" {    
    return new Symbol(sym.LLAV_IZQ,yyline,yychar,yytext());
} 
"}" {    
    return new Symbol(sym.LLAV_DER,yyline,yychar,yytext());
} 
"=" {    
    return new Symbol(sym.IGUAL,yyline,yychar,yytext());
} 

//Signos de puntuacion 
"," {
    return new Symbol(sym.COMA,yyline,yychar,yytext());
} 
";" {
    return new Symbol(sym.PT_COMA,yyline,yychar,yytext());
} 

\n {yychar=1 ;} //en cambio de linea reinicia la columna

{BLANCOS} {}
{COMMENT_1LINE} {}
//{COMMENTMULTI} {}
{CHAR} {
    return new Symbol(sym.CHAR,yyline,yychar, yytext());
} 
{Estado} {
    return new Symbol(sym.ESTADO,yyline,yychar, yytext());
} 
{ID} {
    //lexemas.add( new Lexema(yytext(),"Boolean",yyline,yychar));
    //System.out.println("Este es un ID: "+yytext()+ ", en la linea: "+yyline+", en la columna: "+yychar);
    return new Symbol(sym.ID,yyline,yychar, yytext());
} 


//errores
. {
    //Aqui se debe guardar los valores (yytext(), yyline, yychar ) para posteriormente generar el reporte de errores Léxicos.
    System.out.println("Este es un error lexico: "+yytext()+ ", en la linea: "+yyline+", en la columna: "+yychar);
}