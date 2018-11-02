package lab4_andrescruz_stephaniemartinez;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Juego {

    Random r = new Random();
    Scanner s = new Scanner(System.in);
    int Marc1=0, Marc2=0;
    Equipos Equipo1;
    Equipos Equipo2;

    public Juego(Equipos Equipo1, Equipos Equipo2) {
        this.Equipo1 = Equipo1;
        this.Equipo2 = Equipo2;
    }

    public void Jugar() {
        boolean flag = true;
        System.out.println("Bienvenido al Juego\nEl primer jugador usa al equipo: \nEl segundo jugador usa al equipo: ");
        int turno = 0;
        int cont=0;
        int limite = 5;
        while (flag) {
            if (turno % 2 == 0) {
                System.out.println("Esta es la lista de tus Jugadores: ");
                for (int i = 0; i < Equipo1.getJugador().size(); i++) {
                    System.out.println(i + " - " + Equipo1.getJugador().get(i).getNombre());
                }
                System.out.println("Ingrese la posicion del jugador que desea usar: ");
                String pos = s.next();
                while (Posicion(pos, Equipo1)) {
                    System.out.println("Ingrese la posicion del jugador que desea usar: ");
                    pos = s.next();
                }
                int posicion=Integer.parseInt(pos);
                if (Equipo1.getJugador().get(posicion) instanceof Pateador) {
                    System.out.println("1- Atacar\n2- Pasar el balon\nIngrese que accion desea realizar: ");
                    String opc=s.next();
                    while (Numero(opc)) {                        
                    System.out.println("1- Atacar\n2- Pasar el balon\nIngrese que accion desea realizar: ");
                    opc=s.next();    
                    }
                    int option=Integer.parseInt(opc);
                    switch(option){
                        case 1:
                            double alazar=1+s.nextInt(100);
                            double probabilidad= Equipo1.getJugador().get(posicion).Ataque();
                            if (alazar<=probabilidad) {
                                Marc1++;
                                System.out.println("Gol!!!!");
                                System.out.println(Equipo1.getNombre()+" "+Marc1+" - "+Equipo2.getNombre()+" "+Marc2);
                                cont=0;
                                turno++;
                            }else{
                                System.out.println("Has fallado el tiro!!! ");
                                System.out.println(Equipo1.getNombre()+" "+Marc1+" - "+Equipo2.getNombre()+" "+Marc2);
                                cont=0;
                                turno++;
                            }
                            break;
                        case 2:
                            System.out.println("Jugadores a los que puede pasar el balon: ");
                            for (int i = 0; i < Equipo1.getJugador().size(); i++) {
                                if (Equipo1.getJugador().get(i) instanceof Tirador) {
                                    System.out.println(i+" - "+Equipo1.getJugador().get(i));
                                }
                            }
                            break;
                    }
                }else{
                
                }
            } else {
                for (int i = 0; i < Equipo2.getJugador().size(); i++) {
                    System.out.println(i + " - " + Equipo1.getJugador().get(i).getNombre());
                }
            }
        }
    }
    public boolean Numero(String temp){
        int cont = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (Character.isDigit(temp.charAt(i))) {
                cont++;
            }
        }
        if (cont == temp.length()) {
            int t=Integer.parseInt(temp);
            if (t<1||t>2) {
                return true;
            }else{
            return false;
            }
        } else {
            return true;
        }
    }
    public boolean Posicion(String temp, Equipos equipo) {
        int cont = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (Character.isDigit(temp.charAt(i))) {
                cont++;
            }
        }
        if (cont == temp.length()) {
            int t = Integer.parseInt(temp);
            if (t < 0 || t > equipo.getJugador().size() - 1) {
                return true;
            } else {
                return false;
            }

        } else {
            return true;
        }
    }
}
