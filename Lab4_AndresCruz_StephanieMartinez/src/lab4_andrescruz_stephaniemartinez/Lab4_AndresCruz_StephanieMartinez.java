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
            if(opcion_menu == 2){
                System.out.println("--------------------------------");
                System.out.println("1.- Creación de jugadores\n2.- Eliminar jugadores\n3.- Modificar jugadores");
                System.out.print("  Ingrese una ocpción: ");
                int opcion_jugadores = s.nextInt();
                if(opcion_jugadores == 1){
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
    
    static void CreacionJugadores(){
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = s.next();
        System.out.print("");
    }
}
