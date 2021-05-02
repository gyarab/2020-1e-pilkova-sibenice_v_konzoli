

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Sibenice1 {

    public static void main(String[] args) {

        Scanner vstup = new Scanner(System.in);

        System.out.println("1 nebo 2 hraci?");
        String hraci = vstup.nextLine();

        String slovo;

        if (hraci.equals("1")) {
            System.out.println("!slova jsou v anglictine!");
            Scanner scanner = new Scanner("slovnik.txt");
            List<String> slova = new ArrayList<>();
          
            while (scanner.hasNext()) {
                slova.add(scanner.nextLine());
            }
            Random rand = new Random();
            slovo = slova.get(rand.nextInt(slova.size()));

        } else {
            System.out.println("Hraci 1 napiš slovo, ktere bude tvuj spoluhrac hadat:");
            slovo = vstup.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Hraci 2 muzes hadat! Hodne stesti!");
        }
        int trest = 0;
        List<Character> odhad = new ArrayList<>();

        while (true) {
            vykresleniSibenice(trest);

            if (trest >= 9) {
                System.out.println("Prohral jsi!");
                System.out.println("Hledane slovo bylo: " + slovo);
                break;
            }

            pocetPismen(slovo, odhad);

            if (!hracuvOdhad(vstup, slovo, odhad)) {
                trest++;
            }

            if (pocetPismen(slovo, odhad)) {
                System.out.println("Vyhral jsi!");
                break;
            }

            System.out.println("Zkus uhadnout slovo:");

            if (vstup.nextLine().equals(slovo)) {
                System.out.println("Vyhral jsi!");
                break;
            } else {
                System.out.println("Ne! Zkus to znovu.");
            }
        }
    }

    private static void vykresleniSibenice(int sibenice) {
        switch (sibenice) {
            case 1:
                if (sibenice >= 1) {
                    System.out.println("          ");
                    System.out.println("          ");
                    System.out.println("          ");
                    System.out.println("          ");
                    System.out.println("          ");
                    System.out.println("          ");
                    System.out.println("**********");
                }
                break;
            case 2:
                if (sibenice >= 2) {
                    System.out.println(" -------  ");
                    System.out.println("       |  ");
                    System.out.println("       |  ");
                    System.out.println("       |  ");
                    System.out.println("       |  ");
                    System.out.println("       |  ");
                    System.out.println("**********");
                }
                break;

            case 3:
                if (sibenice >= 3) {
                    System.out.println(" -------  ");
                    System.out.println(" |     |  ");
                    System.out.println("       | ");
                    System.out.println("       |  ");
                    System.out.println("       | ");
                    System.out.println("       |  ");
                    System.out.println("**********");
                }
                break;
            case 4:
                if (sibenice >= 4) {
                    System.out.println(" -------  ");
                    System.out.println(" |     |  ");
                    System.out.println(" O     |  ");
                    System.out.println("       |  ");
                    System.out.println("       |  ");
                    System.out.println("       |  ");
                    System.out.println("**********");
                }
                break;
            case 5:
                if (sibenice >= 5) {
                    System.out.println(" -------  ");
                    System.out.println(" |     |  ");
                    System.out.println(" O     |  ");
                    System.out.println(" |     |  ");
                    System.out.println("       |  ");
                    System.out.println("       |  ");
                    System.out.println("**********");
                }
                break;
            case 6:
                if (sibenice >= 6) {
                    System.out.println(" -------  ");
                    System.out.println(" |     |  ");
                    System.out.println(" O     |  ");
                    System.out.println(" |\\   |  ");
                    System.out.println("       |  ");
                    System.out.println("       |  ");
                    System.out.println("**********");
                    break;
                }
            case 7:
                if (sibenice >= 7) {
                    System.out.println(" -------  ");
                    System.out.println(" |     |  ");
                    System.out.println(" O     | ");
                    System.out.println("/|\\   |  ");
                    System.out.println("       |  ");
                    System.out.println("       |  ");
                    System.out.println("**********");
                }
                break;
            case 8:
                if (sibenice >= 8) {
                    System.out.println(" -------  ");
                    System.out.println(" |     |  ");
                    System.out.println(" O     |  ");
                    System.out.println("/|\\   |  ");
                    System.out.println("/      |  ");
                    System.out.println("       |  ");
                    System.out.println("**********");
                }
                break;
            case 9:
                if (sibenice >= 9) {
                    System.out.println(" -------  ");
                    System.out.println(" |     |  ");
                    System.out.println(" O     |  ");
                    System.out.println("/|\\   |  ");
                    System.out.println("/ \\   |  ");
                    System.out.println("       |  ");
                    System.out.println("**********");
                }
                break;
        }
    }

    private static boolean hracuvOdhad(Scanner vstup, String slovo, List<Character> odhad) {
        System.out.println("Hadej pismeno:");
        String pismeno = vstup.nextLine();
        odhad.add(pismeno.charAt(0));

        return slovo.contains(pismeno);
    }

    private static boolean pocetPismen(String slovo, List<Character> odhad) {
        int spravnyOdhad = 0;
        for (int i = 0; i < slovo.length(); i++) {
            if (odhad.contains(slovo.charAt(i))) {
                System.out.print(slovo.charAt(i));
                spravnyOdhad++;
            } else {
                System.out.print("-");
            }
        }
        System.out.println();

        return (slovo.length() == spravnyOdhad);
    }
}
