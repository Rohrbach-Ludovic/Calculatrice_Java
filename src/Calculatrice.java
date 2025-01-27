import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculatrice {
    
    String calcul = "";
    List<String> histo = new ArrayList<>();

    
    // Méthode pour ajouter un calcul
    public String ajoute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez votre calcul :");
        calcul = scanner.next();
        return calcul;
    }
    

    // Méthodes pour récupérer l'historique des calculs et ensuite l'effacer
    public List<String> historique() {
        return histo;
    }
    public void resetHistorique() {
        histo.clear(); // Efface tous les éléments de la liste
        System.out.println("L'historique a été réinitialisé.");
    }

    
    // Méthode pour effectuer le calcul
    public String calculer(String calcul) {
        double result;

        if (calcul.contains("+")) {
            String[] parts = calcul.split("\\+");
            result = Double.parseDouble(parts[0].trim()) + Double.parseDouble(parts[1].trim());
        } else if (calcul.contains("-")) {
            String[] parts = calcul.split("-");
            result = Double.parseDouble(parts[0].trim()) - Double.parseDouble(parts[1].trim());
        } else if (calcul.contains("*")) {
            String[] parts = calcul.split("\\*");
            result = Double.parseDouble(parts[0].trim()) * Double.parseDouble(parts[1].trim());
        } else if (calcul.contains("/")) {
            String[] parts = calcul.split("/");
            double denominator = Double.parseDouble(parts[1].trim());
            if (denominator == 0) {
                throw new ArithmeticException("Division par zéro non permise.");
            }
            result = Double.parseDouble(parts[0].trim()) / denominator;
        } else if (calcul.contains("%")) {
            String[] parts = calcul.split("%");
            double denominator = Double.parseDouble(parts[1].trim());
            if (denominator == 0) {
                System.err.println("Erreur : Modulo par zéro !");
                throw new ArithmeticException("Modulo par zéro non permis.");
            }
            result = Double.parseDouble(parts[0].trim()) % denominator;
        } else {
            throw new IllegalArgumentException("Le calcul entré n'est pas valide !");
        }

        String resultString = calcul + " = " + result;
        histo.add(resultString);

        return "Le résultat est de : " + result;
    }



    // Méthode pour afficher les détails dans l'obj
    @Override
    public String toString() {
        return "Calculatrice{" +
                "calcul='" + calcul + '\'' +
                ", historique=" + histo +
                '}';
    }
}
