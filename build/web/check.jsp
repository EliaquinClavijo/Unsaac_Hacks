
<%@page import="java.util.Date"%>
<%@page import="com.mongodb.DBObject"%>
<%@page import="com.mongodb.DBCursor"%>
<%@page import="com.mongodb.DBCollection"%>
<%@page import="com.mongodb.DB"%>
<%@page import="com.mongodb.DB"%>
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

<%          
        String Nombre = "";
        if (request.getParameter("CodigoE") != null) {
                Nombre = request.getParameter("CodigoE");
                    }
       MongoClient clienteMongo = new MongoClient("127.0.0.1", 27017);
       MongoDatabase baseDatos = clienteMongo.getDatabase("UnsaacDB");
       
       String NombreE = "";
       BasicDBObject query = new BasicDBObject();
       
       MongoCollection<Document> miColeccion = baseDatos.getCollection("Alumnos");
       MongoCursor<Document> cursor;
           query.put("CodE", Nombre);

         if(miColeccion.count(query)!= 0){
        HttpSession sesionOK = request.getSession();  
        
        sesionOK.setAttribute("usuario", Nombre);
        sesionOK.setAttribute("isLogin", "true");
         Date date = new Date();
        %>
        <jsp:useBean id="NewUser" class="Autentication.cRegistroCodigo" scope = "session">
                
        </jsp:useBean>
     <%
         NewUser.setaNombre(Nombre);
         NewUser.setaCodigo(date.toString());          
        NewUser.Insertar();
     %>
        
                <jsp:forward page="home.jsp" />
        <%
        
        }
else {
%>
<jsp:forward page="index.jsp">
    <jsp:param name="error" value="Usuario y/o clave incorrectos.<br>Vuelve a intentarlo."/>
</jsp:forward>
<%    }
%>