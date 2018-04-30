
<%@ page session="true" %>

<%
    String usuario = "";
    String haySesion = "";
    HttpSession sesionOk = request.getSession();
    if (sesionOk.getAttribute("usuario") == null) {
%>

<jsp:forward page="index.jsp">
    <jsp:param name="error" value="Es obligatorio identificarse"/>
</jsp:forward>

<%    } else {
        usuario = (String) sesionOk.getAttribute("usuario");
        haySesion =  (String)sesionOk.getAttribute("haySesion");
    }
%>
<%@page import="java.util.List"%>
<%@page import="java.util.StringTokenizer"%>
<!DOCTYPE html>
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
        <%
             String User = "";
            String Cod = "";
            String AlumCurs = "AlumCurs";
            String Cursos = "Cursos";
            
            
              if (request.getParameter("Cod") != null)
                {
                    Cod = request.getParameter("Cod");
                }
              if (Cod.equals("2018-1")){AlumCurs = "AlumCurs2018";Cursos = "Cursos2018";}
              if (request.getParameter("UsuarioD") != null) {
                User = request.getParameter("UsuarioD");
                }
              
              MongoClient clienteMongo = new MongoClient("127.0.0.1", 27017);
                MongoDatabase baseDatos = clienteMongo.getDatabase("UnsaacDB");
       
        %>
        <div class="table-responsive">
          <table class="table table-sm">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Codigo</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Creditos</th>
                    <th scope="col">Categoria</th>
                  </tr>
                </thead>
                <tbody>
        <% 
            
                 BasicDBObject query = new BasicDBObject();
                query = new BasicDBObject();
                 List<String> LCursos = new ArrayList<String>();
                 MongoCollection<Document> miColeccion = baseDatos.getCollection(AlumCurs);
                
                query.put("CodE", User);
                MongoCursor<Document> cursor = miColeccion.find(query).iterator();
                String CodCurso = "";
              
                while (cursor.hasNext()) {
                            BasicDBObject G = BasicDBObject.parse( cursor.next().toJson());                       
                            LCursos.add(G.getString("CodC")); 
                            }                           
             cursor.close();
             miColeccion = baseDatos.getCollection(Cursos);
              for (int i = 0; i <= LCursos.size() - 1; i++) {
                        query = new BasicDBObject();
                        query.put("CodC", LCursos.get(i));
                        cursor = miColeccion.find(query).iterator();
                        while (cursor.hasNext()) {
                            BasicDBObject G = BasicDBObject.parse( cursor.next().toJson()); 
                            %>
                            <tr>
                                <th scope="row"><%=i+1%></th>
                                <td><%=G.getString("CodC")%></td>
                                <td><%=G.getString("Name")%></td>
                                <td><%=G.getString("Credit")%></td>
                                <td><%=G.getString("Cat")%></td>
                              </tr>
                            <%
                            } 
                       cursor.close();
                }
            %> 
            </tbody>
              </table>
          </div>
    </body>
</html>
