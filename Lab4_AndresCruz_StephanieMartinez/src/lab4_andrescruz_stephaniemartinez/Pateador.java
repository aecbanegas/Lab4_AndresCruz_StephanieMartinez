package lab4_andrescruz_stephaniemartinez;

public class Pateador extends Jugador {

    int habilidad;
    int fuerza;
    int habilidad_reg;
    int num;

    public Pateador() {
        super();
    }

    public Pateador(int habilidad, int fuerza, int habalidad_reg, int num) {
        this.habilidad = habilidad;
        this.fuerza = fuerza;
        this.habilidad_reg = habalidad_reg;
        this.num = num;
    }

    public int getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getHabalidad_reg() {
        return habilidad_reg;
    }

    public void setHabalidad_reg(int habalidad_reg) {
        this.habilidad_reg = habalidad_reg;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Pateador{" + "habilidad=" + habilidad + ", fuerza=" + fuerza + ", habilidad_reg=" + habilidad_reg + ", num=" + num + '}';
    }

    @Override
    public double Ataque(boolean cond) {
        return (habilidad + fuerza + habilidad_reg) * 0.65 * (num / 10);
    }
}
