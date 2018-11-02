package lab4_andrescruz_stephaniemartinez;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Juego {
    Random r=new Random();
    Scanner s=new Scanner(System.in);
    int Marc1,Marc2;
    Equipo Equipo1;
    Equipo Equipo2;

    public Juego(Equipo Equipo1, Equipo Equipo2) {
        this.Equipo1 = Equipo1;
        this.Equipo2 = Equipo2;
    }
    public void Jugar(){
    boolean flag=true;
        System.out.println("Bienvenido al Juego\nEl primer jugador usa al equipo: \nEl segundo jugador usa al equipo: ");
        int turno=0;
        int limite=5;
        while (flag) {            
            if (turno%2==0) {
                System.out.println("Ingrese con que jugador desea comenzar: ");
                for (int i = 0; i < 10; i++) {
                    
                }
            }else{
            
            }
        }
    }
}
