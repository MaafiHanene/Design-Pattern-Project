
public abstract class Porte {
    private String adresse;
    private int numero;

    public Porte() {
    }

    public Porte(String adr, int num) {
        this.adresse = adr;
        this.numero = num;
    }

    public void setNumero(int num) {
        this.numero = num;
    }

    public int getNumero() {
        return this.numero;
    }

    public String toString() {
        return "pas vide";
    }
}
