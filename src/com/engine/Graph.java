package com.engine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

		// storage for nodes that already visited
		private Set<Vertex> visitedVertices = new HashSet<>();
		// storage for nodes that already unvisited
		private Set<Vertex> notVisitedVertices = new HashSet<>();
		// storage for provided path
		private List<Path> paths = new ArrayList<>();
		// storage for each nodes
		private List<Vertex> vertices = new ArrayList<>();
		// storage for shortest distance from source nodes to each destination nodes
		private Map<Vertex, Double> distance = new HashMap<>();
		// Double.MAX_VALUE = (2-2^(-52))·2^1023
		private double infinity = Double.MAX_VALUE;
		
		public Graph(List<Vertex> vertices, List<Path> paths) {
			this.vertices = vertices;
			this.paths = paths;
		}
		
		// Getters and Setters

		public List<Vertex> getVertices() {
			return this.vertices;
		}

		public void setVertices(List<Vertex> vertices) {
			this.vertices = vertices;
		}

		public List<Path> getPaths() {
			return this.paths;
		}

		public void setPaths(List<Path> paths) {
			this.paths = paths;
		}

		public Map<Vertex, Double> getDistance() {
			return this.distance;
		}

		public void setDistance(Map<Vertex, Double> distance) {
			this.distance = distance;
		}

		public Set<Vertex> getVisitedVertices() {
			return this.visitedVertices;
		}

		public void setVisitedVertices(Set<Vertex> visitedVertices) {
			this.visitedVertices = visitedVertices;
		}

		public Set<Vertex> getNotVisitedVertices() {
			return this.notVisitedVertices;
		}

		public void setNotVisitedVertices(Set<Vertex> notVisitedVertices) {
			this.notVisitedVertices = notVisitedVertices;
		}

		public double getInfinity() {
			return this.infinity;
		}

		public void setInfinity(double infinity) {
			this.infinity = infinity;
		}
}
