package lab4_andrescruz_stephaniemartinez;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Juego {

    Random r = new Random();
    Scanner s = new Scanner(System.in);
    int Marc1 = 0, Marc2 = 0;

    public void Jugar(Equipos Equipo1,Equipos Equipo2) {
        boolean flag = true;
        boolean flag2 = true;
        System.out.println("Bienvenido al Juego\nEl primer jugador usa al equipo: \nEl segundo jugador usa al equipo: ");
        int turno = 0;
        int cont = 0;
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
                int posicion = Integer.parseInt(pos);
                while (flag2) {
                    String opc;
                    if (cont < 5) {
                        System.out.println("1- Atacar\n2- Pasar el balon\nIngrese que accion desea realizar: ");
                        opc = s.next();
                        while (Numero(opc)) {
                            System.out.println("1- Atacar\n2- Pasar el balon\nIngrese que accion desea realizar: ");
                            opc = s.next();
                        }
                    } else {
                        System.out.println("Llego a su limite de pases, se ejecutara un tiro automaticamente..");
                        opc = "1";
                    }
                    int option = Integer.parseInt(opc);
                    if (Equipo1.getJugador().get(posicion) instanceof Pateador) {
                        switch (option) {
                            case 1:
                                double alazar = 1 + s.nextInt(100);
                                double probabilidad = Equipo1.getJugador().get(posicion).Ataque(true);
                                if (alazar <= probabilidad) {
                                    Marc1++;
                                    System.out.println("Gol!!!!");
                                    System.out.println(Equipo1.getNombre() + " " + Marc1 + " - " + Equipo2.getNombre() + " " + Marc2);
                                    cont = 0;
                                    turno++;
                                    flag2 = false;
                                } else {
                                    System.out.println("Has fallado el tiro!!! ");
                                    System.out.println(Equipo1.getNombre() + " " + Marc1 + " - " + Equipo2.getNombre() + " " + Marc2);
                                    cont = 0;
                                    turno++;
                                    flag2 = false;
                                }
                                break;
                            case 2:
                                System.out.println("Jugadores a los que puede pasar el balon: ");
                                for (int i = 0; i < Equipo1.getJugador().size(); i++) {
                                    if (Equipo1.getJugador().get(i) instanceof Tirador) {
                                        System.out.println(i + " - " + Equipo1.getJugador().get(i));
                                    }
                                }
                                System.out.println("Ingrese la posicion del jugador para hacer el pase: ");
                                String pas = s.next();
                                while (PosicionPase1(pas, Equipo1)) {
                                    System.out.println("Ingrese la posicion del jugador para hacer el pase: ");
                                    pas = s.next();
                                }
                                posicion = Integer.parseInt(pas);
                                break;
                        }
                    } else {
                        switch (option) {
                            case 1:
                                System.out.println("1- Tiro de 3\n2- Tiro de 2\nIngrese que tipo de tiro desea ejecutar: ");
                                String tiro = s.next();
                                while (Numero(tiro)) {
                                    System.out.println("1- Tiro de 3\n2- Tiro de 2\nIngrese que tipo de tiro desea ejecutar: ");
                                    tiro = s.next();
                                }
                                int tir = Integer.parseInt(tiro);
                                boolean condicion;
                                if (tir == 1) {
                                    condicion = true;
                                } else {
                                    condicion = false;
                                }
                                double alazar = 1 + s.nextInt(100);
                                double probabilidad = Equipo1.getJugador().get(posicion).Ataque(condicion);
                                if (alazar <= probabilidad) {
                                    if (condicion) {
                                    Marc1+=3;    
                                    }else{
                                    Marc1+=2;
                                    }
                                    System.out.println("Gol!!!!");
                                    System.out.println(Equipo1.getNombre() + " " + Marc1 + " - " + Equipo2.getNombre() + " " + Marc2);
                                    cont = 0;
                                    turno++;
                                    flag2 = false;
                                } else {
                                    System.out.println("Has fallado el tiro!!! ");
                                    System.out.println(Equipo1.getNombre() + " " + Marc1 + " - " + Equipo2.getNombre() + " " + Marc2);
                                    cont = 0;
                                    turno++;
                                    flag2 = false;
                                }
                                break;
                            case 2:
                                System.out.println("Jugadores a los que puede pasar el balon: ");
                                for (int i = 0; i < Equipo1.getJugador().size(); i++) {
                                    if (Equipo1.getJugador().get(i) instanceof Pateador) {
                                        System.out.println(i + " - " + Equipo1.getJugador().get(i));
                                    }
                                }
                                System.out.println("Ingrese la posicion del jugador para hacer el pase: ");
                                String pas = s.next();
                                while (PosicionPase2(pas, Equipo1)) {
                                    System.out.println("Ingrese la posicion del jugador para hacer el pase: ");
                                    pas = s.next();
                                }
                                posicion = Integer.parseInt(pas);
                                break;
                        }
                    }
                }
            } else {
                System.out.println("Esta es la lista de tus Jugadores: ");
                for (int i = 0; i < Equipo2.getJugador().size(); i++) {
                    System.out.println(i + " - " + Equipo2.getJugador().get(i).getNombre());
                }
                System.out.println("Ingrese la posicion del jugador que desea usar: ");
                String pos = s.next();
                while (Posicion(pos, Equipo2)) {
                    System.out.println("Ingrese la posicion del jugador que desea usar: ");
                    pos = s.next();
                }
                int posicion = Integer.parseInt(pos);
                while (flag2) {
                    String opc;
                    if (cont < 5) {
                        System.out.println("1- Atacar\n2- Pasar el balon\nIngrese que accion desea realizar: ");
                        opc = s.next();
                        while (Numero(opc)) {
                            System.out.println("1- Atacar\n2- Pasar el balon\nIngrese que accion desea realizar: ");
                            opc = s.next();
                        }
                    } else {
                        System.out.println("Llego a su limite de pases, se ejecutara un tiro automaticamente..");
                        opc = "1";
                    }
                    int option = Integer.parseInt(opc);
                    if (Equipo2.getJugador().get(posicion) instanceof Pateador) {
                        switch (option) {
                            case 1:
                                double alazar = 1 + s.nextInt(100);
                                double probabilidad = Equipo2.getJugador().get(posicion).Ataque(true);
                                if (alazar <= probabilidad) {
                                    Marc2++;
                                    System.out.println("Gol!!!!");
                                    System.out.println(Equipo1.getNombre() + " " + Marc1 + " - " + Equipo2.getNombre() + " " + Marc2);
                                    cont = 0;
                                    turno++;
                                    flag2 = false;
                                } else {
                                    System.out.println("Has fallado el tiro!!! ");
                                    System.out.println(Equipo1.getNombre() + " " + Marc1 + " - " + Equipo2.getNombre() + " " + Marc2);
                                    cont = 0;
                                    turno++;
                                    flag2 = false;
                                }
                                break;
                            case 2:
                                System.out.println("Jugadores a los que puede pasar el balon: ");
                                for (int i = 0; i < Equipo2.getJugador().size(); i++) {
                                    if (Equipo2.getJugador().get(i) instanceof Tirador) {
                                        System.out.println(i + " - " + Equipo2.getJugador().get(i));
                                    }
                                }
                                System.out.println("Ingrese la posicion del jugador para hacer el pase: ");
                                String pas = s.next();
                                while (PosicionPase1(pas, Equipo2)) {
                                    System.out.println("Ingrese la posicion del jugador para hacer el pase: ");
                                    pas = s.next();
                                }
                                posicion = Integer.parseInt(pas);
                                break;
                        }
                    } else {
                        switch (option) {
                            case 1:
                                System.out.println("1- Tiro de 3\n2- Tiro de 2\nIngrese que tipo de tiro desea ejecutar: ");
                                String tiro = s.next();
                                while (Numero(tiro)) {
                                    System.out.println("1- Tiro de 3\n2- Tiro de 2\nIngrese que tipo de tiro desea ejecutar: ");
                                    tiro = s.next();
                                }
                                int tir = Integer.parseInt(tiro);
                                boolean condicion;
                                if (tir == 1) {
                                    condicion = true;
                                } else {
                                    condicion = false;
                                }
                                double alazar = 1 + s.nextInt(100);
                                double probabilidad = Equipo2.getJugador().get(posicion).Ataque(condicion);
                                if (alazar <= probabilidad) {
                                    if (condicion) {
                                    Marc2+=3;    
                                    }else{
                                    Marc2+=2;
                                    }
                                    System.out.println("Gol!!!!");
                                    System.out.println(Equipo1.getNombre() + " " + Marc1 + " - " + Equipo2.getNombre() + " " + Marc2);
                                    cont = 0;
                                    turno++;
                                    flag2 = false;
                                } else {
                                    System.out.println("Has fallado el tiro!!! ");
                                    System.out.println(Equipo1.getNombre() + " " + Marc1 + " - " + Equipo2.getNombre() + " " + Marc2);
                                    cont = 0;
                                    turno++;
                                    flag2 = false;
                                }
                                break;
                            case 2:
                                System.out.println("Jugadores a los que puede pasar el balon: ");
                                for (int i = 0; i < Equipo2.getJugador().size(); i++) {
                                    if (Equipo2.getJugador().get(i) instanceof Pateador) {
                                        System.out.println(i + " - " + Equipo2.getJugador().get(i));
                                    }
                                }
                                System.out.println("Ingrese la posicion del jugador para hacer el pase: ");
                                String pas = s.next();
                                while (PosicionPase2(pas, Equipo2)) {
                                    System.out.println("Ingrese la posicion del jugador para hacer el pase: ");
                                    pas = s.next();
                                }
                                posicion = Integer.parseInt(pas);
                                break;
                        }
                    }
                }
            }
            if (Marc1>=11) {
                System.out.println("Ha ganado "+Equipo1.getNombre());
                flag=false;
                Marc1=0;
                Marc2=0;
            }
            if (Marc2>=11) {
                System.out.println("Ha ganado "+Equipo2.getNombre());
                flag=false;
                Marc1=0;
                Marc2=0;
            }
        }
    }

    public boolean Numero(String temp) {
        int cont = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (Character.isDigit(temp.charAt(i))) {
                cont++;
            }
        }
        if (cont == temp.length()) {
            int t = Integer.parseInt(temp);
            if (t < 1 || t > 2) {
                return true;
            } else {
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

    public boolean PosicionPase1(String temp, Equipos equipo) {
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
                if (equipo.getJugador().get(t) instanceof Tirador) {
                    return false;
                } else {
                    return true;
                }
            }

        } else {
            return true;
        }
    }

    public boolean PosicionPase2(String temp, Equipos equipo) {
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
                if (equipo.getJugador().get(t) instanceof Pateador) {
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            return true;
        }
    }
}
