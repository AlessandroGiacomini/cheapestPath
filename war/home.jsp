<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstra.min.css" type="text/css">
<link rel="stylesheet" href="style.css" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Orbitron" rel="stylesheet">
<title>Home Page</title>
</head>
<body>
	<header>
      <h1>Cheapest path from one vertex to another in a directed acyclic graph </h1>
    </header>
	<article>
 	<div class="container">
        	<div class="row">
              <div class="col-md-12 text-center">
                	<form action="CheapestPathServlet" method="post">
                	<p>NodeA,NodeB..</p>	
                		<textarea name="textVertices" style="margin: 0px; height: 25px; width: 162px;">A,B,C,D</textarea><p>Source,Destination,Cost</p>
                		<textarea name="textPaths" style="margin: 0px; height: 107px; width: 162px;">
A,B,1.0
A,C,2.5
A,D,0.4
B,C,1.0
D,B,0.3</textarea>
                		<br>
                		<p>-insert only directed acyclic graph-</p>
                		<input type="text" name="startVertex" class="form-control" placeholder="STARTING VERTEX">
				        <input type="text" name="endVertex" class="form-control" placeholder="ENDING VERTEX">				        
				        <input class="btn btn-lg btn-primary btn-block" type="submit" value="Compute"></input>
					</form>	
              </div>
        	</div>
	</div>
	<p style="color:red;"> ${requestScope['err']}</p>
	<br>
    	<div class="container">
        	<div class="row">
              <div class="col-md-12 text-center">
				<p>
				Sample: When finding the cheapest path from A to C, the expected answer is A=>D=>B=>C, cost 1.7
				<table align="center">
				  <tr>
				    <th>Source</td>
				    <th>Destination</td>
				    	<th>Cost</td>
				  </tr>
				  <tr>
				    <td>A</td>
				    <td>B</td>
				    	<td>1.0</td>
				  </tr>
				  <tr>
				    <td>A</td>
				    <td>C</td>
				    	<td>2.5</td>
				  </tr>
				  <tr>
				    <td>A</td>
				    <td>D</td>
				    	<td>0.4</td>
				  </tr>				  
				  <tr>
				    <td>B</td>
				    <td>C</td>
				    	<td>1.0</td>
				  </tr>				  
				  <tr>
				    <td>D</td>
				    <td>B</td>
				    	<td>0.3</td>
				  </tr>				
				  </table>
				</div>
				 
				<br>
				</p>
              </div>
        	</div>
	</div>    
	</article>
	<footer>
    </footer>
</body>
</html>