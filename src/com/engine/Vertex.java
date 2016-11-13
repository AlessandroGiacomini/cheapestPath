package com.engine;

public class Vertex {
    private String name;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object obj) {
        return obj instanceof Vertex
                && this.name.equalsIgnoreCase(((Vertex) obj).name);
    }

    public int hashCode() {
        return name.length();
    }

}
