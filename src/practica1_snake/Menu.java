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
    int opcion,tama,table,cuerpo[][]=new int[300][2],n=1,x,y,mitad,tct,puntos,punteo,pnt;
    int cont=1,a=0,b=0;
    String nombre;
    String movimiento;
    String tablero[][]; 
    String historia[][]=new String[6][5];
    String cualquiera;
    public int arriba=3;  
    public void menu(){
        borrar();
        Inicio();
        switch(opcion){
            case 1: 
                iniciojuego();
                guardarposicion();
                borrar();
                comida();
                //movimientos
                while(tct!=5){ 
                   borrar();
                   juegotabla();
                   System.out.println("");
                   teclas();
                   guardarposicion();
                  try{
                       juegotabla();
                       
                   }
                   catch(ArrayIndexOutOfBoundsException e){
                       
                       gameover();
                       menu();
                   }
                           
                }
                if(cont==6){
                    cont=1;
                }else{historial();cont++;}
                //finmovimientos
                tct=1;
                exit();
                 menu();
                break;
            case 2:
                animacion();
                menu();
                break;
            case 3:
                imphisto();
                System.out.println("\033[32m ingrese cualquier dato para contunuar");
                cualquiera=in.next();
                menu();
                break;
            case 4:
                
                break;
                
        }    
    }
    public void juegotabla(){
        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        System.out.println("| Nombre: "+nombre+"    Tama;o: "+tama+"       ");
        System.out.println("| Puntaje: "+puntos+"                          ");
        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        for(int i=0;i<(table+1);i++){   
            System.out.println(" ");
            for(int j=0;j<(table+1);j++){
                if(tablero[i][j]!=null){                    
                }else{tablero[i][j]=" ";}
       
                tablero[0][j]="\033[36m@";
                tablero[i][0]="\033[36m@";
                tablero[i][table]="\033[36m@";
                tablero[table][j]="\033[36m@";
                if (i==cuerpo[n][1] && j==cuerpo[n][0]){
                    tablero[(cuerpo[n][1])][(cuerpo[n][0])]="\033[32m?";
                    tablero[(cuerpo[n+1][1])][(cuerpo[n+1][0])]="\033[32m?";
                    tablero[(cuerpo[n-1][1])][(cuerpo[n-1][0])]="\033[32m?";
                    tablero[(cuerpo[n+2][1])][(cuerpo[n+2][0])]="\033[32m?";
                    
                }else{tablero[(cuerpo[n][1])][(cuerpo[n][0])]=" ";}
                if(a==cuerpo[n][1] && b==cuerpo[n][0]){
                tama++;
                tablero[a][b]=" ";
                puntos=puntos+punteo;
                punteo=0;
                comida();
                }
                
                System.out.print(tablero[i][j]);
            } 
        }
        System.out.println("");
        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        System.out.println("");
        System.out.println("fruto: ("+a+","+b+") Punteo "+pnt);
        System.out.println("");
        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
    }
    public void animacion(){
        borrar();
        System.out.println("\033[33m@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("\033[33m@@                                  @@");
        System.out.println("\033[33m@@                                  @@");
        System.out.println("\033[33m@@  Nombre:                         @@");
        System.out.println("\033[33m@@     Juan Rigoberto Zuñiga        @@");
        System.out.println("\033[33m@@  Carne:                          @@");
        System.out.println("\033[33m@@     201630658                    @@");
        System.out.println("\033[33m@@                                  @@");
        System.out.println("\033[33m@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("");
        System.out.println("ingese cualquier letra para continuar");
        cualquiera=in.next();       
    }
    public void historial(){
        historia[0][0]="JUGADOR:  #";
        historia[0][1]="PUNTEO: #";
        historia[0][2]="TAMA;O TABLERO: #";
        historia[0][3]="SNAKE INICIAL: #";
        historia[cont][0]=nombre+"     ";
        String h=String.valueOf("      "+puntos+"  ");
        historia[cont][1]=h;
        String i=String.valueOf("      "+table+"  ");
        historia[cont][2]="    x"+i;
        String j=String.valueOf("      "+tama+"  ");
        historia[cont][3]=j;
    }
    public void borrar(){
        for(int i=0;i<=60;i++){
            System.out.println("");
    }
    }
    public void iniciojuego(){
        n=1;
        x=0;
        y=0;
        mitad=0;
        tct=1;
        puntos=0;
        System.out.println("Ingrese nombre de usuario");
        nombre=in.next();        
        System.out.println("ingrese tama;o del tablero mayor a 10");
        table=in.nextInt();
        tablero=new String[(table+1)][(table+1)];
        mitad=table/2;
        x=mitad;
        y=mitad;
        //condicion tama;o de tablero mayor a 10
        while(table<10){
            System.out.println("ingrese tama;o de de tablero mayor a 10");
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
        if(n==(tama+1)) n=1;
    }
    public void comida(){
        a=(int)(Math.random()*table-2);
        b=(int)(Math.random()*table-2);
        if(a==0){
            a=(int)(Math.random()*table-2);
        }
        if(b==0){
            b=(int)(Math.random()*table-2);
        }
        tablero[a][b]="\033[33m%";
        punteo=(Math.abs((table/2)-b));
        pnt=punteo;
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
                   if(tct==1){
                       if(tct!=2)y--;
                   }
                   if(tct==2){
                       if(tct!=1)y++;
                   }
                   if(tct==3){
                       if(tct!=4)x--;
                   }
                   if(tct==4){
                       if(tct!=3)x++;
                   }
                   //teclas        
    }
    public void Inicio(){
        System.out.println("\033[32m##################################");
        System.out.println("\033[32m###################################");
        System.out.println("###            Munu            ");
        System.out.println("\033[32m#####################################");
        System.out.println("###  1) Inicio del juego       ");
        System.out.println("\033[32m#######################################");
        System.out.println("###  2) Datos Estudiante       ");
        System.out.println("\033[32m#########################################");
        System.out.println("###  3) Historial de partidas  ");
        System.out.println("\033[32m###########################################");
        System.out.println("###  4) Salir                  ");
        System.out.println("\033[32m#############################################");
        System.out.println("\033[32m##############################################");
        System.out.println("# Seleccione el numero de la opcion deseada ");
        System.out.println("\033[32m################################################");
        opcion=in.nextInt();
        borrar();
    }
    public void imphisto(){
     for(int i=0;i<6;i++){   
            System.out.println(" ");
            for(int j=0;j<4;j++){
                 if(historia[i][j]!=null){                    
                }else{historia[i][j]=" ";}
                System.out.print(historia[i][j]);
            } 
        }
    }
    public void gameover(){
        borrar();
        System.out.println("\033[33m@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("\033[33m@@                              @@");
        System.out.println("\033[33m@@                              @@");
        System.out.println("\033[33m@@                              @@");
        System.out.println("\033[33m@@         GAME OVER :(         @@");
        System.out.println("\033[33m@@                              @@");
        System.out.println("\033[33m@@                              @@");
        System.out.println("\033[33m@@                              @@");
        System.out.println("\033[33m@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("");
         tablero=new String[0][0];
        for(int i=0;i<100;i++){
            cuerpo[i][0]=0;
            cuerpo[i][1]=0;
        }
        System.out.println("ingese cualquier letra para continuar");
        cualquiera=in.next();
    }
    public void exit(){
         borrar();
        System.out.println("\033[33m@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("\033[33m@@                                  ");
        System.out.println("\033[33m@@                                  ");
        System.out.println("\033[33m@@  Numbre:                         ");
        System.out.println("\033[33m@@       "+nombre+"                 ");
        System.out.println("\033[33m@@  Punteo:                         ");
        System.out.println("\033[33m@@       "+puntos+"                 ");
        System.out.println("\033[33m@@                                  ");
        System.out.println("\033[33m@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("");
        tablero=new String[0][0];
        for(int i=0;i<100;i++){
            cuerpo[i][0]=0;
            cuerpo[i][1]=0;
        }
        System.out.println("ingese cualquier letra para continuar");
        cualquiera=in.next();
    }
}
