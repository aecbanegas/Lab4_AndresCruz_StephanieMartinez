package lab4_andrescruz_stephaniemartinez;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Random;

public class Lab4_AndresCruz_StephanieMartinez {

    static Scanner s = new Scanner(System.in);
    static Random r=new Random();
    static int Marc1 = 0, Marc2 = 0;
    static ArrayList<Equipos> equipos = new ArrayList();
    static ArrayList<Jugador> jugador = new ArrayList();

    public static void main(String[] args) {
        int opcion_menu = 0, contpat = 0, contti = 0;
        while (opcion_menu != 4) {
            System.out.println("1.- Equipos\n2.- Jugadores\n3.- Juego\n4.- Salir");
            System.out.print("  Ingrese una opción: ");
            opcion_menu = s.nextInt();
            if (opcion_menu == 1) {
                System.out.println("--------------------------------");
                System.out.println("1.- Creación de equipos\n2.- Eliminar equipos\n3.- Modificar equipos");
                System.out.print("  Ingrese una opción: ");
                {
                    int opcion_equipo = s.nextInt();
                    if (opcion_equipo == 1) {
                        System.out.println("--------------------------------");
                        Creacion();
                    }
                    if (opcion_equipo == 2) {
                        System.out.println("--------------------------------");
                        for (int i = 0; i < equipos.size(); i++) {
                            System.out.println(i + " - " + equipos.get(i));
                        }
                        System.out.print("Ingrese el equipo que desea eliminar: ");
                        int pos = s.nextInt();
                        equipos.remove(pos);
                    }
                    if (opcion_equipo == 3) {
                        System.out.println("--------------------------------");
                        Modificacion();
                    }
                }
                System.out.println("--------------------------------");
            }
            if (opcion_menu == 2) {
                System.out.println("--------------------------------");
                System.out.println("1.- Creación de jugadores\n2.- Eliminar jugadores\n3.- Modificar jugadores");
                System.out.print("  Ingrese una ocpción: ");
                int opcion_jugadores = s.nextInt();
                if (opcion_jugadores == 1) {
                    System.out.println("--------------------------------");
                    System.out.print("Ingrese una 'p' si quiere crear un pateador o una 't' si quiere crear un tirador: ");
                    char jugs = s.next().charAt(0);
                    if (jugs == 'p' || jugs == 'P') {
                        CreacionJugadores(contpat, contti, jugs);
                        contpat++;
                    } else if (jugs == 't' || jugs == 'T') {
                        CreacionJugadores(contpat, contti, jugs);
                        contti++;
                    }

                }
                if (opcion_jugadores == 2) {
                    System.out.println("--------------------------------");
                    for (int i = 0; i < jugador.size(); i++) {
                        System.out.println(i + " - " + jugador.get(i));
                    }
                    System.out.print("Ingrese el jugaodr que desea eliminar: ");
                    int pos = s.nextInt();
                    jugador.remove(pos);
                }
                if (opcion_jugadores == 3) {
                    System.out.println("--------------------------------");
                    ModificacionJugadores();
                }
                System.out.println("--------------------------------");
            }
            if (opcion_menu == 3) {
                System.out.println("--------------------------------");
                for (int i = 0; i < equipos.size(); i++) {
                    System.out.println(i + " - " + equipos.get(i));
                }
                System.out.print("Jugador 1 ingrese el equipo con el que desea jugar: ");
                int jugador1 = s.nextInt();
                System.out.print("Jugador 2 ingrese el equipo con el que desea jugar: ");
                int jugador2 = s.nextInt();
                Jugar(equipos.get(jugador1),equipos.get(jugador2));
            }
        }
    }
    
    
    static public void Jugar(Equipos Equipo1,Equipos Equipo2) {
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
                                    int goles=Equipo1.getJugador().get(posicion).getGoles()+1;
                                    Equipo1.getJugador().get(posicion).setGoles(goles);
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
                                    int goles=Equipo1.getJugador().get(posicion).getGoles()+3;
                                    Equipo1.getJugador().get(posicion).setGoles(goles);
                                    }else{
                                    Marc1+=2;
                                    int goles=Equipo1.getJugador().get(posicion).getGoles()+2;
                                    Equipo1.getJugador().get(posicion).setGoles(goles);
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
                                    int goles=Equipo2.getJugador().get(posicion).getGoles()+1;
                                    Equipo2.getJugador().get(posicion).setGoles(goles);
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
                                    int goles=Equipo2.getJugador().get(posicion).getGoles()+3;
                                    Equipo2.getJugador().get(posicion).setGoles(goles);
                                    }else{
                                    Marc2+=2;
                                    int goles=Equipo2.getJugador().get(posicion).getGoles()+2;
                                    Equipo2.getJugador().get(posicion).setGoles(goles);
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
        goleadores(Equipo1,Equipo2);
    }

    static public boolean Numero(String temp) {
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

    static public boolean Posicion(String temp, Equipos equipo) {
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

    static public boolean PosicionPase1(String temp, Equipos equipo) {
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

    static public boolean PosicionPase2(String temp, Equipos equipo) {
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
    
    static public void goleadores(Equipos e1,Equipos e2){
        ArrayList<Jugador>temporal= new ArrayList();
        for (int i = 0; i < e1.getJugador().size(); i++) {
            temporal.add(e1.getJugador().get(i));
        }
        for (int i = 0; i < e2.getJugador().size(); i++) {
            temporal.add(e2.getJugador().get(i));
        }
        ArrayList<Integer>temp= new ArrayList();
        for (int i = 0; i < temporal.size(); i++) {
            temp.add(temporal.get(i).getGoles());
        }
        Collections.sort(temp);
        ArrayList<Integer>index= new ArrayList();
        for (int i = temp.size()-1; i > 0; i--) {
            for (int j = 0; j < temporal.size(); j++) {
                if (temporal.get(j).getGoles()==temp.get(i)) {
                    index.add(j);
                    break;
                }
            }
        }
        for (int i = 0; i < index.size(); i++) {
            System.out.println((i+1)+". "+temporal.get(index.get(i)).getNombre()+" -Goles:  "+ temporal.get(index.get(i)).getGoles());
        }
    }

    
    static void Creacion() {
        System.out.print("Ingrese el nombre del equipo: ");
        String nombre = s.next();
        System.out.print("Ingrese el estadio: ");
        String estadio = s.next();
        System.out.print("Ingrese el pais: ");
        String pais = s.next();
        System.out.print("Ingrese el nombre del entrenador: ");
        String entrenador = s.next();
        System.out.print("Ingrese el nombre del dueño: ");
        String dueno = s.next();
        System.out.print("Ingrese el nombre de la mascota: ");
        String mascota = s.next();
        System.out.print("Ingrese la fecha de creación del equipo: ");
        String fecha = s.next();
        System.out.print("Ingrese el color: ");
        String color = s.next();
        equipos.add(new Equipos(nombre, estadio, pais, entrenador, dueno, mascota, fecha, color));
    }

    static void Modificacion() {
        System.out.print("Ingrese el equipo que desea modificar: ");
        int pos = s.nextInt();
        System.out.print("Ingrese el nombre del equipo: ");
        String nombre = s.next();
        equipos.get(pos).setNombre(nombre);
        System.out.print("Ingrese el estadio: ");
        String estadio = s.next();
        equipos.get(pos).setEstadio(estadio);
        System.out.print("Ingrese el pais: ");
        String pais = s.next();
        equipos.get(pos).setPais(pais);
        System.out.print("Ingrese el nombre del entrenador: ");
        String entrenador = s.next();
        equipos.get(pos).setNombre_entrenador(entrenador);
        System.out.print("Ingrese el nombre del dueño: ");
        String dueno = s.next();
        equipos.get(pos).setNombre_dueno(nombre);
        System.out.print("Ingrese el nombre de la mascota: ");
        String mascota = s.next();
        equipos.get(pos).setNombre_masc(nombre);
        System.out.print("Ingrese la fecha de creación del equipo: ");
        String fecha = s.next();
        equipos.get(pos).setFecha(fecha);
        System.out.print("Ingrese el color: ");
        String color = s.next();
        equipos.get(pos).setColor(color);
    }

    static void CreacionJugadores(int contpat, int contti, char jugs) {
        System.out.print("Ingrese la posición del equipo a la que le desea agregar los jugadores: ");
        int pos = s.nextInt();
        if (contpat < 3) {
            if (jugs == 'p' || jugs == 'P') {
                System.out.print("Ingrese el nombre del jugador: ");
                String nombre = s.next();
                System.out.print("Ingrese el apodo del jugador: ");
                String apodo = s.next();
                System.out.print("Ingrese el número de camisa que tiene el jugador: ");
                int num = s.nextInt();
                System.out.print("Ingrese el equipo de football favorito del jugador: ");
                String nombre_foot = s.next();
                System.out.print("Ingrese el equipo de basketball favorito del jugador: ");
                String nombre_basket = s.next();
                System.out.print("Ingrese el jugador favorito: ");
                String jug = s.next();
                System.out.print("Ingrese 1.- si el jugador es mayor de edad o ingrese 2.- si el jugador es menor de edad: ");
                int op = s.nextInt();
                boolean mayor = false;
                switch (op) {
                    case 1:
                        mayor = true;
                        break;
                    case 2:
                        mayor = false;
                        break;
                    default:
                        System.out.println("El número que ha ingresado no es válido.");
                        break;
                }
                System.out.print("Ingrese el año de nacimiento: ");
                int nacimiento = s.nextInt();
                System.out.print("Ingrese el número de estrellas que tiene el jugador: ");
                int estrellas = s.nextInt();
                while (estrellas < 1 || estrellas > 5) {
                    System.out.println("El número de estrellas que ha ingresado no es válido, por favor ingrese un número del 1 - 5.");
                    System.out.print("Ingrese el número de estrellas que tiene el jugador: ");
                    estrellas = s.nextInt();
                }
                System.out.print("Ingrese la habilidad: ");
                int habilidad = s.nextInt();
                while (habilidad < 1 || habilidad > 100) {
                    System.out.println("El número que ha ingresado no es válido");
                    System.out.print("Ingrese la habilidad: ");
                    habilidad = s.nextInt();
                }
                System.out.print("Ingrese la fuerza del jugador: ");
                int fuerza = s.nextInt();
                while (fuerza < 1 || fuerza > 100) {
                    System.out.println("El número que ha ingresado no es válido");
                    System.out.print("Ingrese la fuerza del jugador: ");
                    fuerza = s.nextInt();
                }
                System.out.print("Ingrese la habilidad de regate del jugador: ");
                int regate = s.nextInt();
                while (regate < 1 || regate > 100) {
                    System.out.println("El número que ha ingresado no es válido");
                    System.out.print("Ingrese la habilidad de regate del jugador: ");
                    regate = s.nextInt();
                }
                equipos.get(pos).getJugador().add(new Pateador(habilidad, fuerza, regate, estrellas, nombre, apodo, num, nombre_foot, nombre_basket, jug, mayor, nacimiento));
            }
        } else {
            System.out.println("Ya no se pueden agregar más pateadores.");
        }
        if (contti < 2) {
            if (jugs == 't' || jugs == 'T') {
                System.out.print("Ingrese el nombre del jugador: ");
                String nombre = s.next();
                System.out.print("Ingrese el apodo del jugador: ");
                String apodo = s.next();
                System.out.print("Ingrese el número de camisa que tiene el jugador: ");
                int num = s.nextInt();
                System.out.print("Ingrese el equipo de football favorito del jugador: ");
                String nombre_foot = s.next();
                System.out.print("Ingrese el equipo de basketball favorito del jugador: ");
                String nombre_basket = s.next();
                System.out.print("Ingrese el jugador favorito: ");
                String jug = s.next();
                System.out.print("Ingrese 1.- si el jugador es mayor de edad o ingrese 2.- si el jugador es menor de edad: ");
                int op = s.nextInt();
                boolean mayor = false;
                switch (op) {
                    case 1:
                        mayor = true;
                        break;
                    case 2:
                        mayor = false;
                        break;
                    default:
                        System.out.println("El número que ha ingresado no es válido.");
                        break;
                }
                System.out.print("Ingrese el año de nacimiento: ");
                int nacimiento = s.nextInt();
                System.out.print("Ingrese el número de estrellas que tiene el jugador: ");
                int estrellas = s.nextInt();
                while (estrellas < 1 || estrellas > 5) {
                    System.out.println("El número de estrellas que ha ingresado no es válido, por favor ingrese un número del 1 - 5.");
                    System.out.print("Ingrese el número de estrellas que tiene el jugador: ");
                    estrellas = s.nextInt();
                }
                System.out.print("Ingrese el rango del tiro 3 del jugador: ");
                int tiro3 = s.nextInt();
                while (tiro3 < 1 || tiro3 > 100) {
                    System.out.println("El número que ha ingresado no es válido");
                    System.out.print("Ingrese el rango del tiro 3 del jugador: ");
                    tiro3 = s.nextInt();
                }
                System.out.print("Ingrese el rando del tiro 2 del jugador: ");
                int tiro2 = s.nextInt();
                while (tiro2 < 1 || tiro2 > 100) {
                    System.out.println("El número que ha ingresado no es válido");
                    System.out.print("Ingrese el rando del tiro 2 del jugador: ");
                    tiro2 = s.nextInt();
                }
                System.out.print("Ingrese el rango del manejo del balón: ");
                int manejo = s.nextInt();
                while (manejo < 1 || manejo > 100) {
                    System.out.println("El número que ha ingresado no es válido");
                    System.out.print("Ingrese el ranfo del manejo del balón: ");
                    manejo = s.nextInt();
                }
                equipos.get(pos).getJugador().add(new Tirador(tiro3, tiro2, manejo, estrellas, nombre, apodo, num, nombre_foot, nombre_basket, jug, mayor, nacimiento));
            } else {
                System.out.println("El caracter que ha ingresado no es válido.");
            }
        } else {
            System.out.println("Ya no se pueden agregar más tiradores.");
        }
    }

    static void ModificacionJugadores() {
        System.out.print("Ingrese el equipo al que desea modificar: ");
        int pose = s.nextInt();
        System.out.print("Ingrese el jugador que desea modificar: ");
        int pos = s.nextInt();
        if (equipos.get(pose).getJugador().get(pos) instanceof Tirador) {
            System.out.print("Ingrese el nombre del jugador: ");
            String nombre = s.next();
            equipos.get(pose).getJugador().get(pos).setNombre(nombre);
            System.out.print("Ingrese el apodo del jugador: ");
            String apodo = s.next();
            equipos.get(pose).getJugador().get(pos).setApodo(apodo);
            System.out.print("Ingrese el número de camisa que tiene el jugador: ");
            int num = s.nextInt();
            equipos.get(pose).getJugador().get(pos).setNum_camisa(num);
            System.out.print("Ingrese el equipo de football favorito del jugador: ");
            String nombre_foot = s.next();
            equipos.get(pose).getJugador().get(pos).setEquipo_foot(nombre_foot);
            System.out.print("Ingrese el equipo de basketball favorito del jugador: ");
            String nombre_basket = s.next();
            equipos.get(pose).getJugador().get(pos).setEquipo_basket(nombre_basket);
            System.out.print("Ingrese el jugador favorito: ");
            String jug = s.next();
            equipos.get(pose).getJugador().get(pos).setJugador_fav(jug);
            System.out.print("Ingrese 1.- si el jugador es mayor de edad o ingrese 2.- si el jugador es menor de edad: ");
            int op = s.nextInt();
            boolean mayor = false;
            switch (op) {
                case 1:
                    mayor = true;
                    break;
                case 2:
                    mayor = false;
                    break;
                default:
                    System.out.println("El número que ha ingresado no es válido.");
                    break;
            }
            equipos.get(pose).getJugador().get(pos).setMayor(mayor);
            System.out.print("Ingrese el año de nacimiento: ");
            int nacimiento = s.nextInt();
            equipos.get(pose).getJugador().get(pos).setNacimiento(nacimiento);
            System.out.print("Ingrese el número de estrellas que tiene el jugador: ");
            int estrellas = s.nextInt();
            while (estrellas < 1 || estrellas > 5) {
                System.out.println("El número de estrellas que ha ingresado no es válido, por favor ingrese un número del 1 - 5.");
                System.out.print("Ingrese el número de estrellas que tiene el jugador: ");
                estrellas = s.nextInt();
            }
            System.out.print("Ingrese la habilidad: ");
            int habilidad = s.nextInt();
            while (habilidad < 1 || habilidad > 100) {
                System.out.println("El número que ha ingresado no es válido");
                System.out.print("Ingrese la habilidad: ");
                habilidad = s.nextInt();
            }
            System.out.print("Ingrese la fuerza del jugador: ");
            int fuerza = s.nextInt();
            while (fuerza < 1 || fuerza > 100) {
                System.out.println("El número que ha ingresado no es válido");
                System.out.print("Ingrese la fuerza del jugador: ");
                fuerza = s.nextInt();
            }
            System.out.print("Ingrese la habilidad de regate del jugador: ");
            int regate = s.nextInt();
            while (regate < 1 || regate > 100) {
                System.out.println("El número que ha ingresado no es válido");
                System.out.print("Ingrese la habilidad de regate del jugador: ");
                regate = s.nextInt();
            }
        } else {
            System.out.print("Ingrese el nombre del jugador: ");
            String nombre = s.next();
            equipos.get(pose).getJugador().get(pos).setNombre(nombre);
            System.out.print("Ingrese el apodo del jugador: ");
            String apodo = s.next();
            equipos.get(pose).getJugador().get(pos).setApodo(apodo);
            System.out.print("Ingrese el número de camisa que tiene el jugador: ");
            int num = s.nextInt();
            equipos.get(pose).getJugador().get(pos).setNum_camisa(num);
            System.out.print("Ingrese el equipo de football favorito del jugador: ");
            String nombre_foot = s.next();
            equipos.get(pose).getJugador().get(pos).setEquipo_foot(nombre_foot);
            System.out.print("Ingrese el equipo de basketball favorito del jugador: ");
            String nombre_basket = s.next();
            equipos.get(pose).getJugador().get(pos).setEquipo_basket(nombre_basket);
            System.out.print("Ingrese el jugador favorito: ");
            String jug = s.next();
            equipos.get(pose).getJugador().get(pos).setJugador_fav(jug);
            System.out.print("Ingrese 1.- si el jugador es mayor de edad o ingrese 2.- si el jugador es menor de edad: ");
            int op = s.nextInt();
            boolean mayor = false;
            switch (op) {
                case 1:
                    mayor = true;
                    break;
                case 2:
                    mayor = false;
                    break;
                default:
                    System.out.println("El número que ha ingresado no es válido.");
                    break;
            }
            equipos.get(pose).getJugador().get(pos).setMayor(mayor);
            System.out.print("Ingrese el año de nacimiento: ");
            int nacimiento = s.nextInt();
            equipos.get(pose).getJugador().get(pos).setNacimiento(nacimiento);
            System.out.print("Ingrese el número de estrellas que tiene el jugador: ");
            int estrellas = s.nextInt();
            while (estrellas < 1 || estrellas > 5) {
                System.out.println("El número de estrellas que ha ingresado no es válido, por favor ingrese un número del 1 - 5.");
                System.out.print("Ingrese el número de estrellas que tiene el jugador: ");
                estrellas = s.nextInt();
            }
            System.out.print("Ingrese el rango del tiro 3 del jugador: ");
            int tiro3 = s.nextInt();
            while (tiro3 < 1 || tiro3 > 100) {
                System.out.println("El número que ha ingresado no es válido");
                System.out.print("Ingrese el rango del tiro 3 del jugador: ");
                tiro3 = s.nextInt();
            }
            System.out.print("Ingrese el rando del tiro 2 del jugador: ");
            int tiro2 = s.nextInt();
            while (tiro2 < 1 || tiro2 > 100) {
                System.out.println("El número que ha ingresado no es válido");
                System.out.print("Ingrese el rando del tiro 2 del jugador: ");
                tiro2 = s.nextInt();
            }
            System.out.print("Ingrese el rango del manejo del balón: ");
            int manejo = s.nextInt();
            while (manejo < 1 || manejo > 100) {
                System.out.println("El número que ha ingresado no es válido");
                System.out.print("Ingrese el ranfo del manejo del balón: ");
                manejo = s.nextInt();
            }
        }
    }
}
