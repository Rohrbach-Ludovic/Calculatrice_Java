import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Calculatrice {

    String calcul = "";
    List<String> histo = new ArrayList<>();

    // Méthode pour récupérer un calcul VALIDE (int ou double)
    public String ajoute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez votre calcul :");

        while (true) {
            calcul = scanner.nextLine();
            if (isValidCalculation(calcul)) {
                break;
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un calcul valide.");
            }
        }
        return calcul;
    }

    // Méthode pour vérifier la validité du calcul
    private boolean isValidCalculation(String calcul) {
        String regex = "^[0-9]+([+-/*%][0-9]+)*$|^[0-9]+(\\.[0-9]+)?([+-/*%][0-9]+(\\.[0-9]+)?)*$";
        return calcul.matches(regex);
    }

    // Méthode qui retourne l'historique
    public List<String> historique() {
        return histo;
    }

    // Méthodeu pour reset l'historique
    public void resetHistorique() {
        histo.clear();
        System.out.println("L'historique a été réinitialisé.");
    }

    // Méthode de construction du résultat (+ add à l'historique)
    public String calculer(String calcul) {
        double result = evaluerExpression(calcul);
        String resultString = calcul + " = " + result;
        histo.add(resultString);
        return "Le résultat est de : " + result;
    }


    // Méthode pour découper la chaine
    private double evaluerExpression(String calcul) {

        Stack<Double> valeurs = new Stack<>();
        Stack<Character> operateurs = new Stack<>();

        for (int i = 0; i < calcul.length(); i++) {
            char c = calcul.charAt(i);

            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < calcul.length() && (Character.isDigit(calcul.charAt(i)) || calcul.charAt(i) == '.')) {
                    sb.append(calcul.charAt(i));
                    i++;
                }
                i--;
                valeurs.push(Double.parseDouble(sb.toString()));
            } else if (c == '+' || c == '-') {
                while (!operateurs.isEmpty() && (operateurs.peek() == '*' || operateurs.peek() == '/' || operateurs.peek() == '%')) {
                    valeurs.push(operateurCalcul(operateurs.pop(), valeurs.pop(), valeurs.pop()));
                }
                operateurs.push(c);
            } else if (c == '*' || c == '/' || c == '%') {
                operateurs.push(c);
            }
        }
        while (!operateurs.isEmpty()) {
            valeurs.push(operateurCalcul(operateurs.pop(), valeurs.pop(), valeurs.pop()));
        }
        return valeurs.pop();
    }

    // Méthode de calcul
    private double operateurCalcul(char operateur, double b, double a) {
        switch (operateur) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division par zéro non permise.");
                }
                return a / b;
            case '%':
                if (b == 0) {
                    throw new ArithmeticException("Modulo par zéro non permis.");
                }
                return a % b;
            default: throw new IllegalArgumentException("Opérateur invalide");
        }
    }
}
