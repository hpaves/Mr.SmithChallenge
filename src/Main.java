import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;

public class Main {
    public static int[] plats = new int[13];
    public static void main(String args[]) {
        System.out.println("Pane end võitluseks valmis!!");
        System.out.println("Autor: Henri");
        System.out.println();

        int neo = (int) (plats.length / 2);
        int smith = (int) (Math.random() * plats.length);
        paheKukkumisKontroll(smith, neo);
            Scanner klaviatuur = new Scanner(System.in);
            while (true) {
                plats[neo] = 1;
                plats[smith] = 2;
                System.out.println(Arrays.toString(plats));
                System.out.println();
                if (neo == smith) {
                    System.out.println("Mäng läbi!");
                    break;
                } else {
                    System.out.println("Sisesta käik (asd või f):");
                    String sisend = klaviatuur.nextLine();
                    if (sisend.equals("a")) {
                        if (liikumisKontroll(neo - 1) == true) {
                            neo--;
                            plats[neo + 1] = 0;
                        } else {
                            System.out.println("Sa ei saa sinna liikuda.");
                            System.out.println();
                        }
                    } else if (sisend.equals("d")) {
                        if (liikumisKontroll(neo + 1) == true) {
                            neo++;
                            plats[neo - 1] = 0;
                        } else {
                            System.out.println("Sa ei saa sinna liikuda.");
                            System.out.println();
                        }
                    } else if (sisend.equals("s")) {
                        System.out.println("Jäid paigale");
                    } else if (sisend.equals("f")) {
                        if (smith == neo - 1 || smith == neo + 1) {
                            plats[smith] = 0;
                            smith = (int) (Math.random() * plats.length);
                        } else {
                            System.out.println("Sa ei saa nii kaugelt lüüa.");
                        }

                    } else {
                        System.out.println("Vale klahv. Väljun mängust.");
                        break;
                    }
                }

                if (neo < smith) {
                    smith--;
                    plats[smith + 1] = 0;
                } else if (neo > smith) {
                    smith++;
                    plats[smith - 1] = 0;
                }

            }
        }

    private static boolean paheKukkumisKontroll(int smith, int neo) {
        while (true) {
            if (smith == neo || smith == neo + 1 || smith == neo - 1) {
                smith = (int) (Math.random() * plats.length);
            } else {
                return false;
            }
        }
    }


    private static boolean liikumisKontroll(int neoSamm) {
            if (neoSamm == -1) {
                return false;
            } else if (neoSamm == plats.length) {
                return false;
            } else if (plats[neoSamm] == 2) {
                return false;
            } else {
                return true;
            }
        }
}
