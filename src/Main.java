public class Main {
    public static void main(String[] args) {
        Calculatrice calc = new Calculatrice();

        String test = calc.ajoute();



        System.out.println(calc.calculer(test));


        System.out.println("Historique des calculs : " + calc.historique());

    }
}
