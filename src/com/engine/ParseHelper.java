package com.engine;

import java.util.ArrayList;

public class ParseHelper {
	
	// Get all paths from textarea
	public ArrayList<Path> fromString2Paths(String s) {
		ArrayList<Path> paths = new ArrayList<Path>();
		String[] arrPaths = s.split("\\n");;
		for (String currentPath: arrPaths) {
			String[] path = currentPath.split(",");
			
			double cost = Double.parseDouble(path[2].replaceAll("\\p{Z}",""));
			
			paths.add(
					new Path(
							new Vertex(path[0].replaceAll("\\p{Z}","")),
							new Vertex(path[1].replaceAll("\\p{Z}","")),
							cost)
					);
		}
		
		return paths;
	}
	
	// Get all vertices from textarea
	public ArrayList<Vertex> fromString2Vertices(String s) {
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		String[] arrVertices = s.split(",");
		for (String sCurrent: arrVertices) {
			vertices.add(new Vertex(sCurrent.replaceAll("\\p{Z}","")));
		}
		return vertices;
	}
}
