
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
            
            
              if (request.getParameter("Cod1") != null)
                {
                    Cod = request.getParameter("Cod1");
                }
              if (Cod.equals("2018-1")){AlumCurs = "AlumCurs2018";Cursos = "Cursos2018";}
              if (request.getParameter("UsuarioD") != null) {
                User = request.getParameter("UsuarioD");
                }
              
              MongoClient clienteMongo = new MongoClient("127.0.0.1", 27017);
                MongoDatabase baseDatos = clienteMongo.getDatabase("UnsaacDB");
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
         %>
         <nav class="navbar navbar-default">
                <div class="container-fluid">
                  <!-- Brand and toggle get grouped for better mobile display -->
                  <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                      <span class="sr-only">Toggle navigation</span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Consulta</a>
                  </div>

                  <!-- Collect the nav links, forms, and other content for toggling -->
                  <div class="collapse navbar-collapse"  id="bs-example-navbar-collapse-1">
                    <form  id="Send12" name="Yuli2" method="POST" >
                       <div class="w3-row-padding">
                       <div class="w3-half">
                      <input type="hidden" name="UsuarioD" value="<%=User%>"/>
                      <input type="hidden" name="Semestre" value="<%=Cod%>"/>
                   <div class="form-group">
                      <select   name="Cod" class="form-control">
                        
                            <%
                        miColeccion = baseDatos.getCollection(Cursos);
                            for (int i = 0; i <= LCursos.size() - 1; i++) {
                                      query = new BasicDBObject();
                                      query.put("CodC", LCursos.get(i));
                                      cursor = miColeccion.find(query).iterator();
                                      while (cursor.hasNext()) {
                                          BasicDBObject G = BasicDBObject.parse( cursor.next().toJson());                       
                                          %>
                                          <option value=<%=LCursos.get(i)%>><%=G.getString("Name")%></option>
                                          <%
                                          } 
                                     cursor.close();
                                    }
                                %>
                        
                      </select>
                  </div>
                           </div>   
                        <div class="w3-half">
                            <div class="w3-row-padding">
                                
                                    
                                    <div class="w3-half">
                                  <button id="Sendqq" type="button"  class="btn btn-default">Consultar</button>
                                    </div>
                                
                            </div>  
                       </div>
                       </div>
                   </form>
                  </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
        </nav>
                                <script>
                                     $(document).ready(function () {
                
                $("#Sendqq").click(function (event) {
                
                    $.ajax({
                        data: $("#Send12").serialize(),
                        url: "ClassMate.jsp",
                        type:"POST",
                        success:
                                function (result) {
                                    $("#Replace3").html(result);
                                }});
                        
                });
                
            });
                                </script>
    </body>
    
</html>
