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
    int opcion,tama,fila,columna;
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
        
        switch(opcion){
            case 1: 
               
                System.out.println("Ingrese nombre de usuario");
                nombre=in.next();        
                System.out.println("ingrese # de columnas mayor a 10");
                columna=in.nextInt();
                //condicion para que ingrese # de colunas mayor a 10
                 while(columna<10){
                    System.out.println("ingrese # de columnas mayor a 10");
                    columna=in.nextInt();
                }
                //fin condicion para que ingrese # de colunas mayor a 10
                System.out.println("Ingrese # de filas mayor a 10");
                fila=in.nextInt();
                //condicion para que ingrese # de filas mayor a 10
                while(fila<10){
                    System.out.println("ingrese # de filas1 mayor a 10");
                    fila=in.nextInt();
                }
                //fin condicion para que ingrese # de filas mayor a 10
                System.out.println("Ingrese el tama;o de Snake deseado");
                tama=in.nextInt();
                
                juego();
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
    public void juego(){
        String tablero[][]=new String[fila][columna];
        
        int a;
        int b;
        a=(int)(Math.random()*fila);
        b=(int)(Math.random()*columna);
        tablero[a][b]=" X ";
        
        for(int i=0;i<fila;i++){   
            System.out.println("  ");
            for(int j=0;j<columna;j++){
                if(tablero[i][j]!=null){
                   
                }else{tablero[i][j]="   ";}
                          
                tablero[0][j]="-@-";
                tablero[i][0]=" @ ";
                tablero[i][columna-1]="@";
                tablero[fila-1][j]="-@-";
                System.out.print(tablero[i][j]);
            }
          
        }System.out.println("");
        
        
    }
    
    public void animacion(){
        
    }
    public void historial(){
        
    }
    public void comida(){
        
    }
   
}
