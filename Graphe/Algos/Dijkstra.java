package Graphe.Algos;

import Graphe.Core.IGraphe;

import java.util.*;

import java.util.*;

public class Dijkstra {
    public static void dijkstra(IGraphe g, String source, Map<String, Integer> dist, Map<String, String> prev) {
        // Initialiser les distances et les précédents
        for (String noeud : g.getSommets()) {
            dist.put(noeud, Integer.MAX_VALUE);
            prev.put(noeud, null);
        }
        dist.put(source, 0);

        // Utilisation d'un tas binaire pour une mise à jour efficace de la priorité
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(dist::get));
        queue.add(source);

        while (!queue.isEmpty()) {
            String currentNoeud = queue.poll();
            int currentDistance = dist.get(currentNoeud);

            // Si la distance actuelle est infinie, passer au prochain nœud
            if (currentDistance == Integer.MAX_VALUE) {
                continue;
            }

            // Parcourir les successeurs du noeud courant
            for (String successeur : g.getSucc(currentNoeud)) {
                int newDistance = currentDistance + g.getValuation(currentNoeud, successeur);
                if (newDistance < dist.get(successeur)) {
                    dist.put(successeur, newDistance);
                    prev.put(successeur, currentNoeud);
                    queue.add(successeur);
                }
            }
        }

        // Supprimer les nœuds inaccessibles (distances infinies)
        dist.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE);
    }
}
