public class Main {
    public static void main(String[] args) {
        Calculatrice calc = new Calculatrice();


        calc.ajoute();
        calc.ajoute();


        System.out.println("Historique des calculs : " + calc.historique());
        calc.resetHistorique();
        System.out.println(calc.historique());
    }
}
