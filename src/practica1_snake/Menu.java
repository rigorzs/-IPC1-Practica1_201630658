/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_snake;

/**
 *
 * @author Juan RigobertoZuñiga
 */
import java.util.Scanner;
public class Menu {
    Scanner in=new Scanner(System.in);  
    int opcion,tama,table;
    String nombre;
    public int arriba=3;
   
    public Menu(){
        System.out.println(" ");
        System.out.println("   Munu  ");
        System.out.println("1) Inicio del juego");
        System.out.println("2) Datos Estudiante");
        System.out.println("3) Historial de partidas");
        System.out.println("4) Salir");
        System.out.println("Seleccione el numero de la opcion deseada");
        opcion=in.nextInt();
        borrar();
        switch(opcion){
            case 1: 
                iniciojuego();
                borrar();
                juegotabla();
                new Menu();
                break;
            case 2:
                
                break;
            case 3:
                break;
            case 4:
                
                break;
                
        }
        
    }
    public void juegotabla(){
        String tablero[][]=new String[table][table];
        int a;
        int b;
        a=(int)(Math.random()*table);
        b=(int)(Math.random()*table);
        tablero[a][b]=" X ";
        for(int i=0;i<table;i++){   
            System.out.println("  ");
            for(int j=0;j<table;j++){
                if(tablero[i][j]!=null){
                   
                }else{tablero[i][j]="   ";}
                          
                tablero[0][j]="-@-";
                tablero[i][0]=" @ ";
                tablero[i][table-1]="@";
                tablero[table-1][j]="-@-";
                System.out.print(tablero[i][j]);
            }
          
        }System.out.println("");
        
        
    }
    
    public void animacion(){
        
    }
    public void historial(){
        
    }
    public void borrar(){
        for(int i=0;i<=60;i++){
            System.out.println("");
    }
    }
    public void iniciojuego(){
        System.out.println("Ingrese nombre de usuario");
        nombre=in.next();        
        System.out.println("ingrese rama;o del tablero maor a 10");
        table=in.nextInt();
        //condicion tama;o de tablero mayor a 10
        while(table<10){
            System.out.println("ingrese # de columnas mayor a 10");
            table=in.nextInt();
            }
            //fin condicion tama;o de mayor a 10
        System.out.println("Ingrese el tama;o de Snake deseado");
        tama=in.nextInt();
    }
   
}
