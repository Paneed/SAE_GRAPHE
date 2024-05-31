package Graphe.Implements;

import Graphe.Core.*;

import java.util.*;

public class GrapheLArcs extends Graphe{

    private Map<String, Integer> noeudsMap;
    private List<Arc> arcs;

    public GrapheLArcs() {
        noeudsMap = new HashMap<>();
        arcs = new ArrayList<>();
    }

    @Override
    public void ajouterSommet(String noeud) {
        if (!contientSommet(noeud)) {
            noeudsMap.put(noeud, noeudsMap.size());
        }
    }

    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {
        if(!contientSommet(source))
            ajouterSommet(source);
        if(!contientSommet(destination))
            ajouterSommet(destination);
        if (contientArc(source, destination)) {
            throw new IllegalArgumentException("L'arc existe déjà.");
        }
        if (valeur < 0)
            throw new IllegalArgumentException("Les valuations ne peuvent pas être négatives");
        arcs.add(new Arc(source, destination, valeur));
    }

    @Override
    public void oterSommet(String noeud) {
        noeudsMap.remove(noeud);
        arcs.removeIf(arc -> arc.getSource().equals(noeud) || arc.getDestination().equals(noeud));
    }

    @Override
    public void oterArc(String source, String destination) {
        if (!contientArc(source, destination)) {
            throw new IllegalArgumentException("L'arc n'existe pas.");
        }
        arcs.removeIf(arc -> arc.getSource().equals(source) && arc.getDestination().equals(destination));
    }


    @Override
    public List<String> getSommets() {
        return new ArrayList<>(noeudsMap.keySet());
    }

    @Override
    public List<String> getSucc(String sommet) {
        List<String> successeurs = new ArrayList<>();
        for (Arc arc : arcs) {
            if (arc.getSource().equals(sommet)) {
                successeurs.add(arc.getDestination());
            }
        }
        return successeurs;
    }

    @Override
    public int getValuation(String src, String dest) {
        for (Arc arc : arcs) {
            if (arc.getSource().equals(src) && arc.getDestination().equals(dest)) {
                return arc.getValuation();
            }
        }
        return -1; // Arc non trouvé
    }

    @Override
    public boolean contientSommet(String sommet) {
        return noeudsMap.containsKey(sommet);
    }

    @Override
    public boolean contientArc(String src, String dest) {
        for (Arc arc : arcs) {
            if (arc.getSource().equals(src) && arc.getDestination().equals(dest)) {
                return true;
            }
        }
        return false;
    }

}