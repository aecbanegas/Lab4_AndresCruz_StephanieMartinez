package lab4_andrescruz_stephaniemartinez;

public class Tirador extends Jugador {

    int tiro3;
    int tiro2;
    int manejo;
    int num;

    public Tirador() {
        super();
    }

    public Tirador(int tiro3, int tiro2, int manejo, int num) {
        this.tiro3 = tiro3;
        this.tiro2 = tiro2;
        this.manejo = manejo;
        this.num = num;
    }

    public int getTiro3() {
        return tiro3;
    }

    public void setTiro3(int tiro3) {
        this.tiro3 = tiro3;
    }

    public int getTiro2() {
        return tiro2;
    }

    public void setTiro2(int tiro2) {
        this.tiro2 = tiro2;
    }

    public int getManejo() {
        return manejo;
    }

    public void setManejo(int manejo) {
        this.manejo = manejo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Tirador{" + "tiro3=" + tiro3 + ", tiro2=" + tiro2 + ", manejo=" + manejo + ", num=" + num + '}';
    }

    @Override
    public double Ataque(boolean cond) {
        if (cond) {
            return (tiro3 + manejo) * 0.90 * (num / 10);
        } else {
            return (tiro2 + manejo) * 0.95 * (num / 10);
        }
    }
}
