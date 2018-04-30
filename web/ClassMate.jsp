<%@page import="java.util.List"%>
<%@page import="java.util.StringTokenizer"%>
 <%@ page session="true" %>
 <%@page import ="com.mongodb.BasicDBObject"%>
<%@page import ="com.mongodb.Block"%>
<%@page import ="com.mongodb.MongoClient"%>
<%@page import ="com.mongodb.client.FindIterable"%>
<%@page import ="com.mongodb.client.MongoCollection"%>
<%@page import ="com.mongodb.client.MongoCursor"%>
<%@page import ="com.mongodb.client.MongoDatabase"%>

<%@page import ="org.bson.Document"%>
 <%@page import ="com.sun.org.apache.bcel.internal.generic.AALOAD"%>
<%@page import ="java.io.File"%>
<%@page import ="java.util.ArrayList"%>
<%@page import ="java.util.Scanner"%>
<%@page import ="java.util.Set"%>
<%@page import ="java.util.regex.Pattern"%>
<%@page import ="javax.swing.JFileChooser"%>
<%@page import ="javax.swing.filechooser.FileNameExtensionFilter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="w3-card w3-margin">
          <div class="table-responsive">  
            <ul class="w3-ul w3-hoverable w3-white">
              
              
           
        <%
            String Sem = "";
            String User = "";
            String Cod = "";
            String Cod2 = "Date";
            String AlumCurs = "AlumCurs";
            String Cursos = "Cursos";
            if (request.getParameter("Cod") != null) {
                Cod = request.getParameter("Cod");
                }
            if (request.getParameter("Cod2") != null) {
                Cod2 = request.getParameter("Cod2");
                }
            if (request.getParameter("UsuarioD") != null) {
                User = request.getParameter("UsuarioD");
                }
            if (request.getParameter("Semestre") != null)
                {
                    Sem = request.getParameter("Semestre");
                }
            if (Sem.equals("2018-1")){AlumCurs = "AlumCurs2018";Cursos = "Cursos2018";}
            
            MongoClient clienteMongo = new MongoClient("127.0.0.1", 27017);
            MongoDatabase baseDatos = clienteMongo.getDatabase("UnsaacDB");
            String CodE = "";
            String NombreE = "";
            BasicDBObject query = new BasicDBObject();
       
            MongoCollection<Document> miColeccion = baseDatos.getCollection(AlumCurs);
            MongoCursor<Document> cursor;
            query.put("CodC", Cod);
            cursor = miColeccion.find(query).iterator();
                
            MongoCollection<Document> miColeccion1 = baseDatos.getCollection("Alumnos");   
            %>
                        <form id="users" name="Yuli11" method="post" action="home_visit.jsp" >
                            <div class="table-responsive">

                            <table class="table">
                        <thead class="thead-dark">
                          <tr>
                            <th scope="col">Foto</th>
                            <th scope="col" align="justify" >Nombre</th>
                            <th scope="col">Ver Cursos</th>
                          </tr>
                        </thead>
                        <tbody>
                        <%
            while (cursor.hasNext()) {
                        BasicDBObject G = BasicDBObject.parse( cursor.next().toJson());
                        BasicDBObject query1 = new BasicDBObject(); 
                        MongoCursor<Document> cursor1;
                        query1.put("CodE", G.getString("CodE"));
                        cursor1 = miColeccion1.find(query1).iterator();
                        
                            
                        while (cursor1.hasNext()) 
                        {
                            BasicDBObject G1 = BasicDBObject.parse( cursor1.next().toJson());
                            if (!G1.getString("CodE").equals(User)){
                            %>
                            <tr>
                                <th scope="row"><img src="http://ccomputo.unsaac.edu.pe/alumno/fotos/<%=G1.getString("CodE")%>.jpg" alt="Not found" class="w3-left w3-margin-right" style="width:60px">
                           </th>
                                <td class="align-middle"><%=G1.getString("Name")%></td>
                                <td class="align-middle"> <input class="w3-large" id="wtf" name = "CodigoE" type ="submit" value="<%=G1.getString("CodE")%>" /><br>
                            </td>
                              </tr>
                        
                            <%
                                }
                        }
                           
                         cursor1.close();
                             
                         }
              
             cursor.close();
            
            
        %>
                            </tbody>
                            </table>
                            </div>
                        </form>
            </ul>
          </div>
        </div>
  <hr> 
        
    </body>
    <script>
            function clear() 
            {
               document.getElementById('fg').value = '';
            }
            clear();
        </script>
</html>
