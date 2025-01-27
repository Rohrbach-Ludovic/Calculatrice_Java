public class Main {
    public static void main(String[] args) {

        Calculatrice calc = new Calculatrice();
        String leCalcul = (String) calc.ajoute();
        System.out.println(calc.calculer(leCalcul));

        System.out.println();
    }
}