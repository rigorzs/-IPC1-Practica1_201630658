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
    int opcion,tama,table,cuerpo[][]=new int[300][2],n=1,x,y,mitad,tct,puntos=0;
    int cont=0;
    String nombre;
    String movimiento;
    String tablero[][];
    public int arriba=3;  
    public Menu(){
        Inicio();
        switch(opcion){
            case 1: 
                iniciojuego();
                guardarposicion();
                borrar();
                //movimientos
                while(tct!=5){ 
                   borrar();
                   juegotabla();
                   System.out.println("");
                   teclas(); 
                   guardarposicion();
                }
                
                //finmovimientos
                new Menu();
                break;
            case 2:
                
                break;
            case 3:
                historial();
                break;
            case 4:
                
                break;
                
        }    
    }
    public void juegotabla(){
        System.out.println("Nombre: "+nombre+"    Tama;o: "+tama);
        System.out.println("Puntaje: "+puntos);
        for(int i=0;i<(table+1);i++){   
            System.out.println(" ");
            for(int j=0;j<(table+1);j++){
                if(tablero[i][j]!=null){                    
                }else{tablero[i][j]=" ";}
                if("?".equals(tablero[i][j])){
                    tablero[i][j]=" ";
                            
                }
                tablero[0][j]="@";
                tablero[i][0]="@";
                tablero[i][table]="@";
                tablero[table][j]="@";
                tablero[(cuerpo[n][1])][(cuerpo[n][0])]="?";
                
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
        System.out.println("ingrese rama;o del tablero mayor a 10");
        table=in.nextInt();
        tablero=new String[(table+1)][(table+1)];
        mitad=table/2;
        x=mitad;
        y=mitad;
        //condicion tama;o de tablero mayor a 10
        while(table<10){
            System.out.println("ingrese # de columnas mayor a 10");
            table=in.nextInt();
            mitad=table/2;
            tablero=new String[(table+1)][(table+1)];
            x=mitad;
            y=mitad;
            }
            //fin condicion tama;o de mayor a 10
        System.out.println("Ingrese el tama;o de Snake deseado");
        tama=in.nextInt();
    }
    public void guardarposicion(){
        cuerpo[n][0]=x;
        cuerpo[n][1]=y;
        n++;
        if(n==tama) n=1;
    }
    public void comida(){
        int a;
        int b;
        a=(int)(Math.random()*table);
        b=(int)(Math.random()*table);
    }
    public void teclas(){
        System.out.println("Ingrese su movimiento, W = Arriba, A = Izquierda, S = Abajo, D = Derecha, E = Salir ");
            movimiento=in.next();
            System.out.println(movimiento);
                   if ("w".equals(movimiento) || "W".equals(movimiento)){
                       tct=1;
                   }
                   if ("S".equals(movimiento) || "s".equals(movimiento)){
                       tct=2;
                   }
                   if ("A".equals(movimiento) || "a".equals(movimiento)){
                       tct=3;   
                   }
                   if ("d".equals(movimiento) || "D".equals(movimiento)){
                      tct=4;
                   }
                   if("e".equals(movimiento) || "E".equals(movimiento)){
                       tct=5;
                   }
                   if(tct==1)y--;
                   if(tct==2)y++;
                   if(tct==3)x--;
                   if(tct==4)x++;
                   //teclas        
    }
    public void Inicio(){
        System.out.println(" ");
        System.out.println("   Munu  ");
        System.out.println("1) Inicio del juego");
        System.out.println("2) Datos Estudiante");
        System.out.println("3) Historial de partidas");
        System.out.println("4) Salir");
        System.out.println("Seleccione el numero de la opcion deseada");
        opcion=in.nextInt();
        borrar();
    }
}
