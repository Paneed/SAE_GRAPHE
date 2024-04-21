package graphe;

public class  Arc {

    String source;
    String destination;
    int valuation;

    public Arc(String source, String destination) {
        this.source = source;
        this.destination = destination;
        this.valuation = 0; // Par défaut
    }

    public Arc(String source, String destination, int valuation) {
        this.source = source;
        this.destination = destination;
        this.valuation = valuation;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getValuation() {
        return valuation;
    }

}


