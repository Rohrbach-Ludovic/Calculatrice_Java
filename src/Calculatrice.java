import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.util.SequencedCollection;

public class Calculatrice {

    // une fonction qui prend le calcul
    // un fn qui extrait
    // une fn calcul
    String calcul = "";
    List<String> b = new ArrayList<>();

    public Object ajoute(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez votre calcul");
        b.add(calcul);
        return calcul = scanner.next();
    }

    public List<String> historique(){
        return b;
    }

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

    @Override
    public String toString() {
        return "Calculatrice{" +
                "calcul='" + calcul + '\'' +
                ", b=" + b +
                '}';
    }
}
