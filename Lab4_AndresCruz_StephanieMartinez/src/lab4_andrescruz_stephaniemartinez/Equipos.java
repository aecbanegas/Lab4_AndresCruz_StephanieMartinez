
package lab4_andrescruz_stephaniemartinez;

import java.util.ArrayList;


public class Equipos {
    String nombre;
    String estadio;
    String pais;
    String nombre_entrenador;
    String nombre_dueno;
    String nombre_masc;
    String fecha;
    String color;
    ArrayList<Jugador> jugador = new ArrayList();

    public Equipos() {
    }

    public Equipos(String nombre, String estadio, String pais, String nombre_entrenador, String nombre_dueno, String nombre_masc, String fecha, String color) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.pais = pais;
        this.nombre_entrenador = nombre_entrenador;
        this.nombre_dueno = nombre_dueno;
        this.nombre_masc = nombre_masc;
        this.fecha = fecha;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombre_entrenador() {
        return nombre_entrenador;
    }

    public void setNombre_entrenador(String nombre_entrenador) {
        this.nombre_entrenador = nombre_entrenador;
    }

    public String getNombre_dueno() {
        return nombre_dueno;
    }

    public void setNombre_dueno(String nombre_dueno) {
        this.nombre_dueno = nombre_dueno;
    }

    public String getNombre_masc() {
        return nombre_masc;
    }

    public void setNombre_masc(String nombre_masc) {
        this.nombre_masc = nombre_masc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Jugador> getJugador() {
        return jugador;
    }

    public void setJugador(ArrayList<Jugador> jugador) {
        this.jugador = jugador;
    }

    @Override
    public String toString() {
        return "Equipos{" + "nombre=" + nombre + ", estadio=" + estadio + ", pais=" + pais + ", nombre_entrenador=" + nombre_entrenador + ", nombre_dueno=" + nombre_dueno + ", nombre_masc=" + nombre_masc + ", fecha=" + fecha + ", color=" + color + ", jugador=" + jugador + '}';
    }
    
}
