package lab4_andrescruz_stephaniemartinez;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab4_AndresCruz_StephanieMartinez {

    static Scanner s = new Scanner(System.in);
    static ArrayList<Equipos> equipos = new ArrayList();
    static ArrayList<Jugador> jugador = new ArrayList();

    public static void main(String[] args) {
        int opcion = 0;
        while (opcion != 10) {
            System.out.println("1.- Equipos\n2.- Jugadores\n3.- Juego");
            System.out.print("  Ingrese una opción: ");
            int opcion_menu = s.nextInt();
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
            }
            if (opcion_menu == 2) {
                System.out.println("--------------------------------");
                System.out.println("1.- Creación de jugadores\n2.- Eliminar jugadores\n3.- Modificar jugadores");
                System.out.print("  Ingrese una ocpción: ");
                int opcion_jugadores = s.nextInt();
                if (opcion_jugadores == 1) {
                    System.out.println("--------------------------------");
                }
            }
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

    static void CreacionJugadores() {
        System.out.print("Ingrese una 'p' si quiere crear un pateador o una 't' si quiere crear un tirador");
        char jugs = s.next().charAt(0);
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
            jugador.add(new Pateador(habilidad, fuerza, regate, estrellas, nombre, apodo, num, nombre_foot, nombre_basket, jug, mayor, nacimiento));
        }if(jugs == 't' || jugs == 'T'){
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
            
        }
    }
}
