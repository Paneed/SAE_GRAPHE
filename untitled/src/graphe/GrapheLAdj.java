package graphe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrapheLAdj extends Graphe {

    private Map<String, List<Arc>> adjacence;

    public GrapheLAdj() {
        adjacence = new HashMap<>();
    }

    @Override
    public void ajouterSommet(String noeud) {

    }

    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {

    }

    @Override
    public void oterSommet(String noeud) {

    }

    @Override
    public void oterArc(String source, String destination) {

    }

    @Override
    public List<String> getSommets() {
        return List.of();
    }

    @Override
    public List<String> getSucc(String sommet) {
        return List.of();
    }

    @Override
    public int getValuation(String src, String dest) {
        return 0;
    }

    @Override
    public boolean contientSommet(String sommet) {
        return false;
    }

    @Override
    public boolean contientArc(String src, String dest) {
        return false;
    }
}
