package Graphe.IHM;


import Graphe.Implements.GrapheLArcs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Main {
    public static void main(String[] args) {
        // CrÃ©ation d'un graphe avec une liste d'adjacence
        GrapheLArcs graphe = new GrapheLArcs();

        // Ajout de quelques sommets
        graphe.ajouterSommet("A");
        graphe.ajouterSommet("B");
        graphe.ajouterSommet("C");

        // Ajout de quelques arcs avec leurs valuations
        graphe.ajouterArc("A", "B", 5);
        graphe.ajouterArc("A", "C", 3);
        graphe.ajouterArc("B", "C", 2);
        graphe.ajouterArc("A", "P", 2);

        // Affichage des successeurs de chaque sommet
        System.out.println("Successeurs de A : " + graphe.getSucc("A"));
        System.out.println("Successeurs de B : " + graphe.getSucc("B"));
        System.out.println("Successeurs de C : " + graphe.getSucc("C"));

        // Affichage des valuations des arcs
        System.out.println("Valuation de l'arc (A, B) : " + graphe.getValuation("A", "B"));
        System.out.println("Valuation de l'arc (A, C) : " + graphe.getValuation("A", "C"));
        System.out.println("Valuation de l'arc (B, C) : " + graphe.getValuation("B", "C"));

        graphe.ajouterSommet("P");
        graphe.ajouterArc("P", "C", 6);
        graphe.ajouterArc("P", "A", 3);
        graphe.ajouterArc("M","E",2);
        System.out.println("Successeurs de P : " + graphe.getSucc("P"));
        System.out.println("Valuation de l'arc (P, C) : " + graphe.getValuation("P", "C"));
        System.out.println("Valuation de l'arc (P, A) : " + graphe.getValuation("P", "A"));

        //Oter des Arc
        graphe.oterArc("P","C");
        System.out.println("Successeurs de P : " + graphe.getSucc("P"));

        graphe.oterArc("A","B");
        System.out.println("Successeurs de A : " + graphe.getSucc("A"));

        //fonctionne !
        //graphe.oterArc("P","M");
        //graphe.oterArc("Z","E");

        //Oter des sommets
        graphe.oterSommet("P");
        System.out.println("Successeurs de A : " + graphe.getSucc("A"));

        //Liste des sommets
        System.out.println(graphe.getSommets());

        graphe.oterSommet("A");
        System.out.println("Successeurs de A : " + graphe.getSucc("A"));
        System.out.println("Successeurs de B : " + graphe.getSucc("B"));
        System.out.println("Successeurs de C : " + graphe.getSucc("C"));
        System.out.println("Successeurs de P : " + graphe.getSucc("P"));
        System.out.println("Successeurs de R : " + graphe.getSucc("R"));
        System.out.println(graphe.getSommets());

        graphe.ajouterSommet("A");
        System.out.println(graphe.getSommets());
        graphe.ajouterSommet("M");
        System.out.println(graphe.getSommets());
        graphe.ajouterSommet("L");
        System.out.println(graphe.getSommets());

        graphe.oterSommet("L");
        System.out.println(graphe.getSommets());

        //Valuation
        System.out.println(graphe.getValuation("B","C"));
        System.out.println(graphe.getValuation("B","O"));

        graphe.toString();
    }
}