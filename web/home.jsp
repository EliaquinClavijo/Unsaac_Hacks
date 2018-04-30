
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
<html>
<title>yp</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet" href="css/bootstrap.min.css">
<style> 
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}


</style>
<body class="w3-light-grey w3-content" style="max-width:1600px">
<%
    String Nombre = usuario;
       MongoClient clienteMongo = new MongoClient("127.0.0.1", 27017);
   MongoDatabase baseDatos = clienteMongo.getDatabase("UnsaacDB");
       
       String NombreE = "";
       BasicDBObject query = new BasicDBObject();
       
       MongoCollection<Document> miColeccion = baseDatos.getCollection("Alumnos");
       MongoCursor<Document> cursor;
                query.put("CodE", Nombre);
                cursor = miColeccion.find(query).iterator();
                String NameAll = "";
                String Apellido = "";
                int hq = 1;
                while (cursor.hasNext()) {
                            BasicDBObject G = BasicDBObject.parse( cursor.next().toJson());
                          
                            NombreE = G.getString("Name");
                            
                            StringTokenizer tokens=new StringTokenizer(NombreE,"-");
                                while(tokens.hasMoreTokens()){
                                    if ((hq == 1) || (hq == 2)){Apellido = Apellido +" "+ tokens.nextToken();}
                                    else
                                    {
                                        NameAll = tokens.nextToken();
                                    }
                                    hq ++;
                                }
                             
                            }
              
             cursor.close();
       

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
<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container w3-center" >
    <a href="#" onclick="w3_close()" class="w3-hide-large w3-right w3-jumbo w3-padding w3-hover-grey" title="close menu">
      <i class="fa fa-remove"></i>
     
    </a>
      <% Nombre =((Nombre.equals("140992"))? "000000" : Nombre);%>
      <img src="http://ccomputo.unsaac.edu.pe/alumno/fotos/<%=Nombre%>.jpg" style="width:70%;" class="w3-round"><br><br>
      <% Nombre =((Nombre.equals("000000"))? "140992" : Nombre);%>
      <h4><b>Perfil</b></h4>
    <p class="w3-text-grey"><%=NameAll+" "+Apellido%></p>
  </div>
    <form  id="Menu_1"  method="POST"> 
  <div class="w3-bar-block " >
    <a value="140992" name="CodigoE" href="home.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-padding w3-text-teal"><i class="fa fa-th-large fa-fw w3-margin-right"></i>HOME</a> 
    <a id="VerAll1" href="#" onclick="w3_close()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-search fa-fw w3-margin-right"></i>ESTADISTICAS</a> 
    <a id="VerAll3" href="index.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-close fa-fw w3-margin-right"></i>SALIR</a>
  </div>
    </form>
</nav>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div  class="w3-main" style="margin-left:300px">

  <!-- Header -->
   <header id="portfolio" class="w3-container w3-padding-24 w3-white">
     <% Nombre =((Nombre.equals("140992"))? "000000" : Nombre);%>  
    <a href="#"><img src="http://ccomputo.unsaac.edu.pe/alumno/fotos/<%=Nombre%>.jpg" style="width:65px;" class="w3-circle w3-right w3-margin w3-hide-large w3-hover-opacity"></a>
    <% Nombre =((Nombre.equals("000000"))? "140992" : Nombre);%>
    <span class="w3-button w3-hide-large w3-xxlarge w3-hover-text-grey" onclick="w3_open()"><i class="fa fa-bars"></i></span>
    <h1 class="w3-xxlarge"><b> Consultas y mas :v </b></h1>
    <h6> Bienvenido, <span> Seguridad primero :v</span></h6>
  </header>
  <div id="Replace" class="w3-row w3-padding ">

    <!-- Blog entries -->
    <div class="w3-col l8 s12">
      <!-- Blog entry -->
      <div class="w3-container w3-white w3-margin w3-padding-large">
          <form  id="2018a" name="YuliSeFue" method="POST" >
              <input type="hidden" name="UsuarioD" value="<%=Nombre%>"/>
        <div class="w3-center">
          <h3>MIS CURSOS</h3>
          <h5> Semestre Academico <select id="Aver"  name="Cod" >
                                 <option value=2018-1>2018-1</option>
                                 <option value=2017-2>2017-2</option>                               
                      </select></h5>
          
          <%
              BasicDBObject query1 = new BasicDBObject(); 
                            MongoCollection<Document> miColeccion1 = baseDatos.getCollection("CP");
                            MongoCursor<Document> cursor1;
                            query1.put("Cod",Carrera(usuario,baseDatos) );
                            cursor1 = miColeccion1.find(query1).iterator();

                            while (cursor1.hasNext()) 
                            {
                                BasicDBObject G1 = BasicDBObject.parse( cursor1.next().toJson());
                                %><h5> <%=G1.getString("Name")%></h5><%
                                
                                break;
                            }
          %>
        </div>
          </form>

        <div class="w3-justify">
          <p><strong> Consultado </strong> el 28/04/2018 00:48 </p>
          <div id="Aqui" ></div>
   
           <%
               query = new BasicDBObject();
                 List<String> LCursos = new ArrayList<String>();
                 miColeccion = baseDatos.getCollection("AlumCurs");
                
                query.put("CodE", Nombre);
                cursor = miColeccion.find(query).iterator();
                String CodCurso = "";
              
                while (cursor.hasNext()) {
                            BasicDBObject G = BasicDBObject.parse( cursor.next().toJson());                       
                            LCursos.add(G.getString("CodC")); 
                            }                           
             cursor.close();
            
            %> 
          <!-- Example of comment field -->
                
        </div>
      </div>

      <!-- Blog entry -->
      <div class="w3-container w3-white w3-margin w3-padding-large">
          <form  id="2018b" name="YuliSeFue1" method="POST" >
              <input type="hidden" name="UsuarioD" value="<%=Nombre%>"/>
        <div class="w3-center">
          <h3>COMPAÑEROS</h3>
          <h5>Semestre Academico <select  id="Aver1" name="Cod1" >
                                <option value=2018-1>2018-1</option>
                                 <option value=2017-2>2017-2</option>
                                 
                      </select></h5>
        </div>
          </form>
        <div class="w3-justify">
          <p><strong> Consultado </strong> el 28/04/2018 00:47 </p> 
          <div id="Aqui1" ></div>
          
                        
             <div id="Replace3"></div>
        </div>
      </div>
      
    <!-- END BLOG ENTRIES -->
    </div>

    <!-- About/Information menu -->
    <div class="w3-col l4">
      <!-- About Card -->
      <div class="w3-white w3-margin">
         <div id="Replace1" class="w3-content w3-container w3-padding-64">
            <h3 class="w3-center">Consultar Creditos </h3>
            <p class="w3-center"><em> La consulta puede tardar de 1 a 2 minutos, sea paciente :v </em></p>
            <div  id="Replace2" class="w3-row-padding" >
                      <form  id="Send123" name="Yuli1" method="POST" > 
                    <div class="w3-row">
                      <input class="w3-input w3-border" type="text" placeholder="Codigo" required name="Cod" autocomplete="off">
                    </div>
                          <br>
                    <div class="w3-row">
                      <input class="w3-input w3-border" type="password" placeholder="Contraseña" required name="Pass">
                    </div>
                      <button id="Sendq" class="w3-button w3-black w3-right w3-section"  type="button">
                    <i class="fa fa-paper-plane"></i> Buscar
                  </button>
                    </form>
             </div>
            
             </div>
      </div>
 
      <hr>

      <!-- Advertising -->
      <div class="w3-white w3-margin">
        <div class="w3-container w3-padding w3-black">
          <h4> Buscar Compañero(a)</h4>

        </div>
        <div id="Replace5" class="w3-container w3-white">
          <div class="w3-container w3-display-container w3-light-grey w3-section" >
              <p class="w3-center"><em> Ingrese sus datos, no es necesario rellenar todo el formulario, solo la informacion que disponga.</em></p>
           <div  id="Replace4" class="w3-row-padding" >
                   <form  id="Send122" name="Yuli1" method="POST" > 
                    <div class="w3-row">
                      <input class="w3-input w3-border" type="text" placeholder="Nombre o parte del mismo" required name="Name" autocomplete="off">
                    </div>
                          <br>
                    <div class="w3-row">
                      <div class="form-group">
                      <select   name="Cod" class="form-control">
                        <option value="-1"> Carrera (Si dispone) </option>
                            <%
                                    miColeccion = baseDatos.getCollection("CP");

                                      cursor = miColeccion.find().iterator();
                                      while (cursor.hasNext()) {
                                          BasicDBObject G = BasicDBObject.parse( cursor.next().toJson());                       
                                          %>
                                          <option value=<%=G.getString("Cod")%>><%=G.getString("Name")%></option>
                                          <%
                                          } 
                                     cursor.close();
                                    
                                %>
                        
                      </select>
                  </div>
                    </div>
                    
                      <button id="SendYul1" class="w3-button w3-black w3-right w3-section"  type="button">
                    <i class="fa fa-paper-plane"></i> Buscar
                  </button>
                    </form>
             </div>
               </div>
      </div>
      <hr>

      </div>
                                

    <!-- END About/Intro Menu -->
    </div>

  <!-- END GRID -->
  </div>
  

</div>

<script>
// Script to open and close sidebar
function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}

function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}
        $(document).ready(function () {
               
                    $.ajax({
                        data: $("#2018a").serialize(),
                        url: "Cursos.jsp",
                        type:"POST",
                        success:
                                function (result) {
                                    $("#Aqui").html(result);
                                }});
                       
            
            }); 

        $(document).ready(function () {
                $("#Aver").click(function (event) {
                    $.ajax({
                        data: $("#2018a").serialize(),
                        url: "Cursos.jsp",
                        type:"POST",
                        success:
                                function (result) {
                                    $("#Aqui").html(result);
                                }});
                       
                });
            }); 
            $(document).ready(function () {
               
                    $.ajax({
                        data: $("#2018b").serialize(),
                        url: "MainClassMate.jsp",
                        type:"POST",
                        success:
                                function (result) {
                                    $("#Aqui1").html(result);
                                }});
                       
            
            }); 

        $(document).ready(function () {
                $("#Aver1").click(function (event) {
                    $.ajax({
                        data: $("#2018b").serialize(),
                        url: "MainClassMate.jsp",
                        type:"POST",
                        success:
                                function (result) {
                                    $("#Aqui1").html(result);
                                }});
                       
                });
            }); 
$(document).ready(function () {
                $("#VerAll1").click(function (event) {
                    $.ajax({
                        data: $("#Menu_1").serialize(),
                        url: "Page1.jsp",
                        type:"POST",
                        success:
                                function (result) {
                                    $("#Replace").html(result);
                                }});
                });
            }); 
            $(document).ready(function () {
                $("#VerAll3").click(function (event) {
                    $.ajax({
                        data: $("#Menu_1").serialize(),
                        url: "Page3.jsp",
                        type:"POST",
                        success:
                                function (result) {
                                    $("#Replace").html(result);
                                }});
                });
            }); 

            

            $(document).ready(function () {
                
                $("#Sendq").click(function (event) {
                
                    $.ajax({
                        data: $("#Send123").serialize(),
                        url: "Creditos.jsp",
                        type:"POST",
                        success:
                                function (result) {
                                    $("#Replace1").html(result);
                                }});
                        $('#Replace2').html('<br><div align="center"><img src="loading.gif"/></div>');
                });
                
            });
            $(document).ready(function () {
                
                $("#SendYul1").click(function (event) {
                
                    $.ajax({
                        data: $("#Send122").serialize(),
                        url: "SearchAlumno.jsp",
                        type:"POST",
                        success:
                                function (result) {
                                    $("#Replace5").html(result);
                                }});
                        $('#Replace4').html('<br><div align="center"><img src="loading.gif"/></div><br>');
                });
                
            });
            
           
</script>

</body>

</html>
