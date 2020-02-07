package com.company;


import java.util.*;
import java.util.stream.Collectors;


public class Mastermind {
    private int[] winCombinatie;
    private HashMap<String, Integer> kleuren = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private int rij = 1;
    private boolean spelGestart = false;


    public Mastermind() {
        this.winCombinatie = bepaalWinCombinatie();
        kleuren.put("r", 0);
        kleuren.put("g", 1);
        kleuren.put("b", 2);
        kleuren.put("y", 3);
        welkom();
    }

    private void welkom() {
        System.out.println("Welkom bij Mastermind. Probeer de juiste kleuren combinatie te raden" +
                " door de eerste letter van je keuze door te geven in de console. ");
        System.out.println("Je kan kiezen uit rood(r), groen(g), blauw(b), geel(y). " +
                "veel succes! ");
        speelSpel();
    }

    public static void main(String[] args) {
        Mastermind m = new Mastermind();
    }

    private int[] bepaalWinCombinatie() {
        int[] p = new int[4];
        Random r = new Random();

        for (int i = 0; i < p.length; i++) {
            p[i] = r.nextInt(4);
        }
        return p;
    }

    private String[] spelerInvoer() {
        return scanner.nextLine().split("(?!^)");
    }

    private void speelSpel() {
        for (int i : winCombinatie) {
            System.out.println(i);
        }

        String[] spelerInvoer;
        boolean geldigeInvoer;
        spelGestart = true;

        while (spelGestart && rij < 9) {

            spelerInvoer = spelerInvoer();
            geldigeInvoer = checkSpelerinvoer(spelerInvoer);

            if (geldigeInvoer) {
                System.out.println("Speler invoer voor rij " + rij + ": " + spelerInvoer[0] + " " + spelerInvoer[1] + " " + spelerInvoer[2] + " " + spelerInvoer[3] + " ");
                geefHint(spelerInvoer);
                rij++;
            } else {
                System.out.println("Probeer het nog een keer :)");
            }

        }

        if (spelGestart) {
            System.out.println("Dat waren al je beurten! helaas heb je het niet geraden :(");
        }

        opnieuwSpelen();

    }

    private void opnieuwSpelen() {
        System.out.println("Wil je opnieuw spelen? klik dan op j. Wil je stoppen? klik op n.");
        String doorgaan = scanner.nextLine();

        if (doorgaan.equals("j")) {
            winCombinatie = bepaalWinCombinatie();
            rij = 1;
            System.out.print("\033[H\033[2J");
            welkom();
        } else {
            System.exit(0);
        }

    }

    private void geefHint(String[] invoer) {

        int goedePositieGoedeKleur = goedePositieGoedeKleur(invoer);
        int foutePositieGoedeKleur = foutePositieGoedekleur(invoer) - goedePositieGoedeKleur;

        System.out.println("Goede positie, goede kleur: " + goedePositieGoedeKleur);
        System.out.println("Foute positie, goede kleur: " + foutePositieGoedeKleur);

        if (goedePositieGoedeKleur == 4) {
            gewonnen();
        }
    }

    private int foutePositieGoedekleur(String[] invoer) {
        int aantal = 0;


        List<String> uniekeIngevoerdeKleuren = Arrays.stream(invoer).distinct().collect(Collectors.toList());
        List<Integer> winCombinatieLijst = Arrays.stream(winCombinatie).boxed().collect(Collectors.toList());


        for (String s : uniekeIngevoerdeKleuren) {
            for (int i : winCombinatieLijst) {
                if (kleuren.get(s) == i) {
                    aantal++;
                }
            }
        }

        return aantal;
    }

    private void gewonnen() {
        System.out.println("Je hebt gewonnen!");
        spelGestart = false;

    }

    private int goedePositieGoedeKleur(String[] invoer) {
        int aantal = 0;

        for (int i = 0; i < invoer.length; i++) {
            if (kleuren.get(invoer[i]) == winCombinatie[i]) {
                aantal++;
            }
        }

        return aantal;
    }

    private boolean checkSpelerinvoer(String[] invoer) {
        String[] gefilterdeInvoer = Arrays.stream(invoer).filter(i -> i.equals("r") || i.equals("g") || i.equals("b") || i.equals("y")).toArray(String[]::new);

        if (invoer.length != 4) {
            System.out.println("Je moet vier kleuren invullen. Niet meer, niet minder!");
            return false;
        } else if (gefilterdeInvoer.length != 4) {
            System.out.println("Je mag alleen kiezen tussen de eerste letter van rood(r), groen(g), blauw(b), geel(y)");
            return false;
        }

        return true;

    }


}
