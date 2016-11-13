package com.cheapestPath;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.engine.Graph;
import com.engine.GraphHelper;
import com.engine.ParseHelper;
import com.engine.Path;
import com.engine.Vertex;


@SuppressWarnings("serial")
public class CheapestPathServlet extends HttpServlet {
	
	public CheapestPathServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
						 throws ServletException, IOException {
		
		RequestDispatcher rd = null;    
		rd = request.getRequestDispatcher("/home.jsp");
		rd.forward(request, response);
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
						  throws ServletException, IOException {
		
		RequestDispatcher rd = null;    

		try {
			String stringVertices = request.getParameter("textVertices");
			String stringPaths = request.getParameter("textPaths");
			ParseHelper parser = new ParseHelper();
			List<Vertex> vertices = parser.fromString2Vertices(stringVertices);
			List<Path> paths = parser.fromString2Paths(stringPaths);
			Graph g = new Graph(vertices, paths);
			GraphHelper helper = new GraphHelper();
			List<Path> allpaths = g.getPaths();
			Vertex startVertex = new Vertex(request.getParameter("startVertex"));
			Vertex endVertex = new Vertex(request.getParameter("endVertex"));
			g = helper.run(startVertex, g); 
			String finalPath = helper.getFinalPath(startVertex, endVertex);			
		    Double distance = g.getDistance().get(endVertex);
			String stringErr="";
		    Pattern p = Pattern.compile("[A-D]");
			Matcher m1 = p.matcher(startVertex.getName());
			Matcher m2 = p.matcher(endVertex.getName());
		
			if ((!startVertex.getName().equals(""))&&(!endVertex.getName().equals(""))) {
	
				if (((m1.find())&&(m2.find()))&&
					(startVertex.getName().length()==1)&&
					(startVertex.getName().length()==1)) {
					
					if ((distance==null)||(finalPath.equals("noPath"))) {
						rd = request.getRequestDispatcher("/nopath.jsp");
					}
					
					else {
						rd = request.getRequestDispatcher("/output.jsp");
					    request.setAttribute("distance", distance);
					    request.setAttribute("startVertex", startVertex);
					    request.setAttribute("endVertex", endVertex);
					    request.setAttribute("finalPath", finalPath);
					}
				}
			    
			    else {
			    		rd = request.getRequestDispatcher("/home.jsp");
			    		stringErr = "Vertices must be in range A-D";
				    request.setAttribute("graph", allpaths);
				    request.setAttribute("err", stringErr);
			    }
			}
	
			else {
				rd = request.getRequestDispatcher("/home.jsp");
				stringErr = "Both vertices must be specified";
			    request.setAttribute("graph", allpaths);
				request.setAttribute("err", stringErr);
			}
		}
		
		catch (Exception exc) {
			rd = request.getRequestDispatcher("/error.jsp");
		}
				
		rd.forward(request, response);
	}
}
