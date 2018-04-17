
<%@page import="com.mongodb.client.MongoCursor"%>
<%@page import="org.bson.Document"%>
<%@page import="com.mongodb.client.MongoCollection"%>
<%@page import="com.mongodb.BasicDBObject"%>
<%@page import="com.mongodb.client.MongoDatabase"%>
<%@page import="com.mongodb.MongoClient"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.StringTokenizer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            MongoClient clienteMongo = new MongoClient("127.0.0.1", 27017);
            MongoDatabase baseDatos = clienteMongo.getDatabase("UnsaacDB");
            List<String> NameS = new ArrayList<String>();             
            List<String> Alumnos = new ArrayList<String>();
            List<String> Codigos = new ArrayList<String>();
            List<String> AlumnosEstate = new ArrayList<String>();
            String Name = "";
            String Cod = "";
            
            if (request.getParameter("Cod") != null) {
                Cod = request.getParameter("Cod");
                }
            if (request.getParameter("Name") != null)
            {
                Name = request.getParameter("Name");
            }  
            
           %>
           <%!
            public static String Carrera(String CodigoA,MongoDatabase baseDatos){
                MongoCollection<Document> miColeccion = baseDatos.getCollection("AlumCurs");
                MongoCollection<Document> miColeccion1 = baseDatos.getCollection("Cursos");
                MongoCursor<Document> cursor;
                BasicDBObject query = new BasicDBObject();
                query.put("CodE",CodigoA);
                cursor = miColeccion.find(query).iterator();
                String Name1 = "";
                
                while (cursor.hasNext()) {
                            BasicDBObject G = BasicDBObject.parse( cursor.next().toJson());
                            Name1 = G.getString("CodC");
                            BasicDBObject query1 = new BasicDBObject(); 
                            MongoCursor<Document> cursor1;
                            query1.put("CodC", G.getString("CodC"));
                            cursor1 = miColeccion1.find(query1).iterator();
                        
                            
                            while (cursor1.hasNext()) 
                            {
                                BasicDBObject G1 = BasicDBObject.parse( cursor1.next().toJson());
                                Name1 = (G1.getString("CodCP"));
                                break;
                            }
                            break;
                    }
                    cursor.close();  
                return (Name1);
              }
              %>
              
              <%
           
                  
            StringTokenizer tokens=new StringTokenizer(Name," ");
               while(tokens.hasMoreTokens())
               {
                   NameS.add(tokens.nextToken().toUpperCase());
                   
               }
            for (int i = 0; i <= NameS.size() - 1; i++) 
            {
               
                BasicDBObject query = new BasicDBObject();
                MongoCollection<Document> miColeccion = baseDatos.getCollection("Alumnos");
                MongoCursor<Document> cursor;
                query.put("Name",java.util.regex.Pattern.compile(NameS.get(i)));
                
                cursor = miColeccion.find(query).iterator();
                while (cursor.hasNext())     
                {
                    BasicDBObject G = BasicDBObject.parse( cursor.next().toJson());       
                    Alumnos.add(G.getString("Name"));
                    Codigos.add(G.getString("CodE"));
                    AlumnosEstate.add("1");
                }
                cursor.close(); 
                break;
            }
            if (NameS.size() > 1)
            {
                for (int i = 1; i <= NameS.size() - 1; i++) 
                {
                    for (int j = 0; j <= Alumnos.size() - 1; j++) 
                    {
                        if ( Alumnos.get(j).indexOf(NameS.get(i)) == -1)
                          {
                              AlumnosEstate.set(j,"0");
                              
                          } 
                    
                    }
                    
                }
            }
            %>
            <form id="users" name="Yuli11" method="post" action="home_visit.jsp" >
                            <div class="table-responsive">

                            <table class="table">
                        <thead class="thead-dark">
                          <tr>
                            <th scope="col" align="justify" >Nombre</th>
                            <th scope="col">Ver Cursos</th>
                          </tr>
                        </thead>
                        <tbody>
            <%
            
            for (int j = 0; j <= Alumnos.size() - 1; j++)
            {
                if (AlumnosEstate.get(j).equals("1"))
                {
                    
                    
                    if (!Cod.equals("-1"))
                    {
                        if (Cod.equals(Carrera(Codigos.get(j),baseDatos)))
                        {
                            %>
                            <tr>
           
                                <td class="align-middle"><%=Alumnos.get(j)%></td>
                                <td class="align-middle"> <input class="w3-large" id="wtf" name = "CodigoE" type ="submit" value="<%=Codigos.get(j)%>" /><br>
                            </td>
                              </tr>
                        
                            <%
                            
                        }
                        
                    }
                    else
                    {
                        %>
                            <tr>
           
                                <td class="align-middle"><%=Alumnos.get(j)%></td>
                                <td class="align-middle"> <input class="w3-large" id="wtf" name = "CodigoE" type ="submit" value="<%=Codigos.get(j)%>" /><br>
                            </td>
                              </tr>
                        
                            <%
                    }
                           
                            
                            
                }
            }
            
            
            
        %>
        <br>
        
   <div class="container-fluid">
       <a href="home.jsp" style="width:100%" class="w3-button"><i class="fa fa-home w3-margin-right"></i>Home</a>
  </div>
    </body>
</html>
