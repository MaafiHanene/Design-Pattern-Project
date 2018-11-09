
public class Restaurant {
    private String nom;
    private double superficie;
    private String URL;
    public static int count;

    public Restaurant(String nom, double superficie, String URL) {
        this.nom = nom;
        this.superficie = superficie;
        this.URL = URL;
    }

    public double getSuperficie() {
        return this.superficie;
    }

    public String getNom() {
        return this.nom;
    }

    public String getUrl() {
        return this.URL;
    }

}
