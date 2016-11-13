package com.engine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphHelper {
	
    private Map<String,String> pred = new HashMap<String,String>();
    
    public Graph run(Vertex source, Graph g) {
    		// Insert source distance with cost = 0
        g.getDistance().put(source, new Double(0));
        // Add source to not visited node
        g.getNotVisitedVertices().add(source);
        // While the Set of the not visited nodes is not empty get the vertex
        // with the minimum cost, add it to the Set of visited nodes
        // and find the distance with the minimum cost for vertex
        // Greedy BFS on adjacent nodes of vertex
        
        
        while (!g.getNotVisitedVertices().isEmpty()) {

            Vertex vertex = getVertexMinCostPath(g.getNotVisitedVertices(), g);
            g.getVisitedVertices().add(vertex);
            g.getNotVisitedVertices().remove(vertex);
            // Greedy BFS
            // Get all adjacent nodes of vertex
            List<Vertex> adjanceNodes = getAdjacentNodes(vertex, g);
            
            
            for (Vertex target : adjanceNodes) {
            		// Compare the known cost of the path towards target with
            		// the computed cost to reach the target trough the source vertex    	
            		// Update the distance of the target with the lower one,
            		// Add it to the not visited nodes
            			
                if (getCostShortestPath(target, g) > 
                		getCostShortestPath(vertex, g) + getCostPath(vertex, target, g)) {
                	
                		pred.put(vertex.getName(), target.getName());	
                		g.getDistance().put(target, getCostShortestPath(vertex, g) + getCostPath(vertex, target, g));
                		g.getNotVisitedVertices().add(target);
                }

            }
        }
        return g;
    }

    // Return the cheapest path from source to dest nodes
    public String getFinalPath(Vertex source, Vertex dest) { 
    		String s = source.getName();
	    String d = dest.getName();
	    String current=s;
	    String finalPath = s;
	    for (int i=0; i<pred.size(); i++) {
	    			finalPath+="=>"+pred.get(current);
	    			current = pred.get(current);
		    		if(current.equals(d)) {
		    			return finalPath;
		    		}
	    	} 
	   return "noPath";
    }
    
    // Find the cost of the path from input source and target vertices
    private double getCostPath(Vertex source, Vertex target, Graph g) {
        for (Path p : g.getPaths()) {
            if (p.getSource().equals(source)
                    && p.getDestination().equals(target)) {
                return p.getCost();
            }
        }
        throw new RuntimeException("Ops");
    }

    // Get all adjacent nodes of vertex
    private List<Vertex> getAdjacentNodes(Vertex vertex, Graph g) {
        List<Vertex> neighbors = new ArrayList<>();
        for (Path p : g.getPaths()) {
        		// Find the path with Vertex as source and 
        		// check that the destination Vertex is not visited
            if (p.getSource().equals(vertex) && !g.getVisitedVertices()
                    .contains(p.getDestination())) {
                neighbors.add(p.getDestination());
            }
        }
        return neighbors;
    }

    // Get the vertex with the minimum shortest path
    private Vertex getVertexMinCostPath(Set<Vertex> notVisitedVertices, Graph g) {
        Vertex min = null;
        for (Vertex vertex : notVisitedVertices) {
            if (min == null) {
                min = vertex;
            } else {
                if (getCostShortestPath(min, g) > getCostShortestPath(vertex, g)) {
                    min = vertex;
                }
            }
        }
        return min;
    }

    // Find the known cost of the shortest path from source to the input target vertex
    // if the distance is unknown return and add infinity value of distance to 
    // the target
    private double getCostShortestPath(Vertex target, Graph g) {

        if (g.getDistance() == null || g.getDistance().isEmpty()) {
            throw new RuntimeException("Ops");
        }
        Double cost = g.getDistance().get(target);
        if (cost == null) {
        	g.getDistance().put(target, g.getInfinity());
            return g.getInfinity();
        }
        return cost.doubleValue();
    }

	public Map<String, String> getPred() {
		return pred;
	}

	public void setPred(Map<String, String> pred) {
		this.pred = pred;
	}
}