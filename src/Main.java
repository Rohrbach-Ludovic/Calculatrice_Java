public class Main {
    public static void main(String[] args) {
        Calculatrice calc = new Calculatrice();

        String test = calc.ajoute();
        String test2 = calc.ajoute();

        System.out.println(calc.calculer(test));
        System.out.println(calc.calculer(test2));


        System.out.println("Historique des calculs : " + calc.historique());
        //calc.resetHistorique();
        //System.out.println(calc.historique());
    }
}
