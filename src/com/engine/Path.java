package com.engine;

public class Path {
    private Vertex source;
    private Vertex destination;
    private double cost;

    public Path(Vertex source, Vertex destination, double d) {
        super();
        this.source = source;
        this.destination = destination;
        this.cost = d;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
