import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculatrice {


    String calcul = "";
    List<String> b = new ArrayList<>();

    // Méthode pour ajouter un calcul
    public String ajoute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez votre calcul :");
        calcul = scanner.next();
        // Ajouter le calcul à l'historique
        b.add(calcul);
        return calcul;
    }

    // Méthodes pour récupérer l'historique des calculs et ensuite l'effacer
    public List<String> historique() {
        return b;
    }
    public void resetHistorique() {
        b.clear(); // Efface tous les éléments de la liste
        System.out.println("L'historique a été réinitialisé.");
    }

    // Méthode pour effectuer le calcul
    public double calculer(String calcul) {

        if (calcul.contains("+")) {
            String[] parts = calcul.split("\\+");
            return Double.parseDouble(parts[0].trim()) + Double.parseDouble(parts[1].trim());
        } else if (calcul.contains("-")) {
            String[] parts = calcul.split("-");
            return Double.parseDouble(parts[0].trim()) - Double.parseDouble(parts[1].trim());
        } else if (calcul.contains("*")) {
            String[] parts = calcul.split("\\*");
            return Double.parseDouble(parts[0].trim()) * Double.parseDouble(parts[1].trim());
        } else if (calcul.contains("/")) {
            String[] parts = calcul.split("/");
            return Double.parseDouble(parts[0].trim()) / Double.parseDouble(parts[1].trim());
        } else if (calcul.contains("%")) {
            String[] parts = calcul.split("%");
            return Double.parseDouble(parts[0].trim()) % Double.parseDouble(parts[1].trim());
        } else {
            throw new IllegalArgumentException("Le calcul entré n'est pas valide !");
        }
    }

    // Méthode pour afficher les détails dans l'obj
    @Override
    public String toString() {
        return "Calculatrice{" +
                "calcul='" + calcul + '\'' +
                ", historique=" + b +
                '}';
    }
}
