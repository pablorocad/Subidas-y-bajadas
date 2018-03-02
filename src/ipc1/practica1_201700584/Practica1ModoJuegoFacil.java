
package ipc1.practica1_201700584;
import java.util.Scanner;
import java.util.Random;
//Libreria Random

public class Practica1ModoJuegoFacil {
    
    Practica1DificultadJuego dif = new Practica1DificultadJuego();
    Practica1ParametrosIniciales par = new Practica1ParametrosIniciales();
    //Llamamos a las clases para evaluar jugadores, subidas y bajadas
    
    Scanner entrada = new Scanner(System.in);
    Random aleatorio = new Random();
    
    int NumeroSubidas = par.$Subidas;
    int NumeroBajadas = par.$Bajadas;
    
    int[] subida = new int[NumeroSubidas];
    int[] bajada = new int[NumeroBajadas];
    
    int[][] Casilla = new int[5][8];
    String[][] SubyBaj = new String[5][8];
    String[][] Jugadores = new String[5][8];
    
    int ContP1 = 0, ContP2 = 0, ContP3 = 0, Dado;
    int CasillaP1 = 0, CasillaP2 = 0, CasillaP3 = 0;
    int fil, col, GameOver=0;
    
    public void ModoJuegoFacil(){
        
 
        NumeraciónCasillas();

        System.out.println("Tablero actual: ");
        //Mostramos el tablero vacio, solo con subidas y bajadas y la casilla final
        for(fil = 0; fil < 8; fil++){
            for(col = 0; col < 5; col++){
                Jugadores[col][fil] = "|_|";
            } 
        }
        Jugadores[0][0] = "|$|";
        SubidasyBajadas();
        
        for(fil = 0; fil < 8; fil++){
            System.out.println("");
            for(col = 0; col < 5; col++){
                System.out.print(Jugadores[col][fil] + " ");
            }
        }

        if(par.$NumJugadores == 2){
            do{
                //Llevamos un contador por jugador para saber a de quien es el turno de jugar

                if(ContP1 == ContP2){
                //Llamamos al metodo que contiene la jugabilidad del jugador 1
                   JugadorUno();
                }
                else if(ContP1 > ContP2){
                //Llamamos al metodo que contiene la jugabilidad del jugador 2
                    JugadorDos();
                }

            }while(GameOver != 1);
            //Repetira los turnos hasta que alguno de los jugadores llegue a la casilla 40 o mas
        }
        
    }
     
    public void JugadorUno(){
        
        //Aqui evaluara en donde se encuentra el jugador y dejara en blanco la casilla para luego moverlo
        for(fil = 0; fil < 8; fil++){
            for(col = 0; col < 5; col++){
                if(CasillaP1 != CasillaP2){
                    if(CasillaP1 == Casilla[col][fil]){
                        Jugadores[col][fil] = "|_|";
                    }    
                }
            } 
        }
        System.out.println("");
        System.out.println("Turno del jugador 1");
        System.out.println("Presione enter para tirar dado");
        entrada.nextLine();
        Dado = aleatorio.nextInt(7);
        
        while(Dado == 0){
            Dado = aleatorio.nextInt(7);
        }
        
        System.out.println("El dado cayo en: " + Dado);
        System.out.println("Presione enter para moverse en el tablero");
        entrada.nextLine();
        CasillaP1 = CasillaP1 + Dado;

        System.out.println("Tablero Actual:");
        
        for(fil = 0; fil < 8; fil++){
            System.out.println("");
            
            for(col = 0; col < 5; col++){
                
                if(CasillaP1 == Casilla[col][fil]){
                    Jugadores[col][fil] = "|" + par.P1 + "|";
                }
                
                System.out.print(Jugadores[col][fil] + " ");
            }
        }ContP1++;
        
        if(CasillaP1 >= 40){
            System.out.println("");
            System.out.println("El jugador 1 es el ganador!!");
            System.out.println("Presione enter para salir de la partida");
            entrada.nextLine();
            GameOver = 1;
        } else {
        }
    }
    
    public void JugadorDos(){
        
        //Aqui evaluara en donde se encuentra el jugador y dejara en blanco la casilla para luego moverlo
        for(fil = 0; fil < 8; fil++){
            for(col = 0; col < 5; col++){
                if(CasillaP2 != CasillaP1){
                    if(CasillaP2 == Casilla[col][fil]){
                        Jugadores[col][fil] = "|_|";
                    }    
                }
            } 
        }
        
        System.out.println("");
        System.out.println("Turno del jugador 2");
        System.out.println("Presione enter para tirar dado");
        entrada.nextLine();
        Dado = aleatorio.nextInt(7);
        
        while(Dado == 0){
            Dado = aleatorio.nextInt(7);
        }
        
        System.out.println("El dado cayo en: " + Dado);
        System.out.println("Presione enter para moverse en el tablero");
        entrada.nextLine();
        CasillaP2 = CasillaP2 + Dado;

        System.out.println("Tablero Actual:");
        
        for(fil = 0; fil < 8; fil++){
            System.out.println("");
            
            for(col = 0; col < 5; col++){

                if(CasillaP2 == Casilla[col][fil]){
                    Jugadores[col][fil] = "|" + par.P2 + "|";
                }
                System.out.print(Jugadores[col][fil] + " ");
            }
        }ContP2++;    
        
        if(CasillaP2 >= 40){
            System.out.println("");
            System.out.println("El jugador 2 es el ganador!!");
            System.out.println("Presione enter para salir de la partida");
            entrada.nextLine();
            GameOver = 1;
        }
    }
    
    public void SubidasyBajadas(){
        
        for(col = 0; col < NumeroSubidas; col++){
            subida[col] = aleatorio.nextInt(40);
            
            while(subida[col] == 0){
                subida[col] = aleatorio.nextInt(40);
            }
            
            
        }
        
        for(int u = 0; u < NumeroSubidas; u++){
            for(fil=0; fil < 8; fil++){
                for(col=0; col < 5; col++){
                
                    if(subida[u] == Casilla[col][fil]){
                        Jugadores[col][fil] = "|+|";
                        
                    }
                }  
            }
        }
        
        for(col = 0; col < NumeroBajadas; col++){
            bajada[col] = aleatorio.nextInt(40);
            
            if(bajada[col] == 0){
                bajada[col] = aleatorio.nextInt(40);
            }
        }
        
        for(int u = 0; u < NumeroBajadas; u++){
            for(fil=0; fil < 8; fil++){
                for(col=0; col < 5; col++){
                
                    if(bajada[u] == Casilla[col][fil]){
                        Jugadores[col][fil] = "|-|";
                        
                    }
                }  
            }
        }
        
    }
    
    public void NumeraciónCasillas(){
        
        int i = 1;
        int F;
        
        //Nombraremos cada casilla con un numero desde abajo hasta arriba
        for(F = 0; F < 5; F++){  
            Casilla[F][7] = F + 1; 
        }
        
        for(F = 4; F >= 0; F--){  
            Casilla[F][6] = 5 + i;
            i++;     
        }
        
        for(F = 0; F < 5; F++){  
            Casilla[F][5] = 5 + i;
            i++;     
        }
        
        for(F = 4; F >= 0; F--){  
            Casilla[F][4] = 5 + i;
            i++;    
        }
        
        for(F = 0; F < 5; F++){  
            Casilla[F][3] = 5 + i;
            i++;     
        }
        
        for(F = 4; F >= 0; F--){  
            Casilla[F][2] = 5 + i;
            i++;     
        }
        
        for(F = 0; F < 5; F++){  
            Casilla[F][1] = 5 + i;
            i++;     
        }
        
        for(F = 4; F >= 0; F--){  
            Casilla[F][0] = 5 + i;
            i++;     
        }   
        
//        for(int aj = 0; aj < 8; aj++){
//            System.out.println("");
//            for(int y = 0; y < 5; y++){
//                System.out.print(Casilla[y][aj] + "  ");
//            }
//        }
//        entrada.nextLine();
    }
    
}
