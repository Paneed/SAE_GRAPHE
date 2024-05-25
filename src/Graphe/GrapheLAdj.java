package Graphe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrapheLAdj extends Graphe {

    // Pour stocker les listes d'adjacence du graphe
    private Map<String, List<Arc>> adjacence;

    // Constructeur d'un graphe
    public GrapheLAdj() {
        adjacence = new HashMap<>();
    }

    @Override
    public void ajouterSommet(String noeud) {
        if (!contientSommet(noeud)) {
            adjacence.put(noeud, new ArrayList<>());
        }
    }

    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {
        ajouterSommet(source);
        ajouterSommet(destination);
        adjacence.get(source).add(new Arc(source, destination, valeur));
    }

    @Override
    public void oterSommet(String noeud) {
        adjacence.remove(noeud);
        // Supprimer les arcs entrants et sortants liés au sommet
        adjacence.values().forEach(arcs -> arcs.removeIf(arc -> arc.getSource().equals(noeud) || arc.getDestination().equals(noeud)));
    }

    @Override
    public void oterArc(String source, String destination) {
        List<Arc> arcs = adjacence.get(source);
        if (arcs != null) {
            arcs.removeIf(arc -> arc.getSource().equals(source) && arc.getDestination().equals(destination));
        }
    }

    @Override
    public List<String> getSommets() {
        return new ArrayList<>(adjacence.keySet());
    }

    @Override
    public List<String> getSucc(String sommet) {
        List<String> successeurs = new ArrayList<>();
        List<Arc> arcs = adjacence.get(sommet);
        if (arcs != null) {
            for (Arc arc : arcs) {
                successeurs.add(arc.getDestination());
            }
        }
        return successeurs;
    }

    @Override
    public int getValuation(String src, String dest) {
        List<Arc> arcs = adjacence.get(src);
        if (arcs != null) {
            for (Arc arc : arcs) {
                if (arc.getDestination().equals(dest)) {
                    return arc.getValuation();
                }
            }
        }
        return -1; // Arc non trouvé
    }

    @Override
    public boolean contientSommet(String sommet) {
        return adjacence.containsKey(sommet);
    }

    @Override
    public boolean contientArc(String src, String dest) {
        List<Arc> arcs = adjacence.get(src);
        if (arcs != null) {
            for (Arc arc : arcs) {
                if (arc.getDestination().equals(dest)) {
                    return true;
                }
            }
        }
        return false;
    }

}