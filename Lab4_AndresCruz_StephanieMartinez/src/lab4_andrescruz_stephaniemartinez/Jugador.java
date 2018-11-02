package lab4_andrescruz_stephaniemartinez;

public abstract class Jugador {

    String nombre;
    String apodo;
    int num_camisa;
    String equipo_foot;
    String equipo_basket;
    String jugador_fav;
    boolean mayor;
    int nacimiento;
    int goles = 0;

    public Jugador() {
    }

    public Jugador(String nombre, String apodo, int num_camisa, String equipo_foot, String equipo_basket, String jugador_fav, boolean mayor, int nacimiento) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.num_camisa = num_camisa;
        this.equipo_foot = equipo_foot;
        this.equipo_basket = equipo_basket;
        this.jugador_fav = jugador_fav;
        this.mayor = mayor;
        this.nacimiento = nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public int getNum_camisa() {
        return num_camisa;
    }

    public void setNum_camisa(int num_camisa) {
        this.num_camisa = num_camisa;
    }

    public String getEquipo_foot() {
        return equipo_foot;
    }

    public void setEquipo_foot(String equipo_foot) {
        this.equipo_foot = equipo_foot;
    }

    public String getEquipo_basket() {
        return equipo_basket;
    }

    public void setEquipo_basket(String equipo_basket) {
        this.equipo_basket = equipo_basket;
    }

    public String getJugador_fav() {
        return jugador_fav;
    }

    public void setJugador_fav(String jugador_fav) {
        this.jugador_fav = jugador_fav;
    }

    public boolean isMayor() {
        return mayor;
    }

    public void setMayor(boolean mayor) {
        this.mayor = mayor;
    }

    public int getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(int nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }


    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", apodo=" + apodo + ", num_camisa=" + num_camisa + ", equipo_foot=" + equipo_foot + ", equipo_basket=" + equipo_basket + ", jugador_fav=" + jugador_fav + ", mayor=" + mayor + ", nacimiento=" + nacimiento + '}';
    }
    public abstract double Ataque(boolean cond);
}
