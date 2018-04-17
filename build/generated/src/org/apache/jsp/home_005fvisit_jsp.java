package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.StringTokenizer;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public final class home_005fvisit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");

    String usuario = "";
    String haySesion = "";
    HttpSession sesionOk = request.getSession();
    if (sesionOk.getAttribute("usuario") == null) {

      out.write('\n');
      out.write('\n');
      if (true) {
        _jspx_page_context.forward("index.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("error", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("Es obligatorio identificarse", request.getCharacterEncoding()));
        return;
      }
      out.write('\n');
      out.write('\n');
    } else {
        usuario = (String) sesionOk.getAttribute("usuario");
        haySesion =  (String)sesionOk.getAttribute("haySesion");
    }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write(" \n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<title>yp</title>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Raleway\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("<link href=\"//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("<style> \n");
      out.write("body,h1,h2,h3,h4,h5,h6 {font-family: \"Raleway\", sans-serif}\n");
      out.write("\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("<body class=\"w3-light-grey w3-content\" style=\"max-width:1600px\">\n");

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
       


      out.write("\n");
      out.write("<!-- Sidebar/menu -->\n");
      out.write("<nav class=\"w3-sidebar w3-collapse w3-white w3-animate-left\" style=\"z-index:3;width:300px;\" id=\"mySidebar\"><br>\n");
      out.write("  <div class=\"w3-container w3-center\" >\n");
      out.write("    <a href=\"#\" onclick=\"w3_close()\" class=\"w3-hide-large w3-right w3-jumbo w3-padding w3-hover-grey\" title=\"close menu\">\n");
      out.write("      <i class=\"fa fa-remove\"></i>\n");
      out.write("     \n");
      out.write("    </a>\n");
      out.write("      <img src=\"http://ccomputo.unsaac.edu.pe/alumno/fotos/");
      out.print(Nombre);
      out.write(".jpg\" style=\"width:70%;\" class=\"w3-round\"><br><br>\n");
      out.write("    <h4><b>Perfil</b></h4>\n");
      out.write("    <p class=\"w3-text-grey\">");
      out.print(NameAll+" "+Apellido);
      out.write("</p>\n");
      out.write("  </div>\n");
      out.write("    <form  id=\"Menu_1\"  method=\"POST\"> \n");
      out.write("  <div class=\"w3-bar-block \" >\n");
      out.write("    <a value=\"140992\" name=\"CodigoE\" href=\"home.jsp\" onclick=\"w3_close()\" class=\"w3-bar-item w3-button w3-padding w3-text-teal\"><i class=\"fa fa-th-large fa-fw w3-margin-right\"></i>HOME</a> \n");
      out.write("    <a id=\"VerAll1\" href=\"#\" onclick=\"w3_close()\" class=\"w3-bar-item w3-button w3-padding\"><i class=\"fa fa-search fa-fw w3-margin-right\"></i>ESTADISTICAS</a> \n");
      out.write("    <a id=\"VerAll3\" href=\"index.jsp\" onclick=\"w3_close()\" class=\"w3-bar-item w3-button w3-padding\"><i class=\"fa fa-close fa-fw w3-margin-right\"></i>SALIR</a>\n");
      out.write("  </div>\n");
      out.write("    </form>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("<!-- Overlay effect when opening sidebar on small screens -->\n");
      out.write("<div class=\"w3-overlay w3-hide-large w3-animate-opacity\" onclick=\"w3_close()\" style=\"cursor:pointer\" title=\"close side menu\" id=\"myOverlay\"></div>\n");
      out.write("\n");
      out.write("<!-- !PAGE CONTENT! -->\n");
      out.write("<div  class=\"w3-main\" style=\"margin-left:300px\">\n");
      out.write("\n");
      out.write("  <!-- Header -->\n");
      out.write("   <header id=\"portfolio\" class=\"w3-container w3-padding-24 w3-white\">\n");
      out.write("       \n");
      out.write("    <a href=\"#\"><img src=\"http://ccomputo.unsaac.edu.pe/alumno/fotos/");
      out.print(Nombre);
      out.write(".jpg\" style=\"width:65px;\" class=\"w3-circle w3-right w3-margin w3-hide-large w3-hover-opacity\"></a>\n");
      out.write("    <span class=\"w3-button w3-hide-large w3-xxlarge w3-hover-text-grey\" onclick=\"w3_open()\"><i class=\"fa fa-bars\"></i></span>\n");
      out.write("    <h1 class=\"w3-xxlarge\"><b> Consultas y mas :v </b></h1>\n");
      out.write("    <h6> Bienvenido, <span> :v</span></h6>\n");
      out.write("  </header>\n");
      out.write("  <div id=\"Replace\" class=\"w3-row w3-padding \">\n");
      out.write("\n");
      out.write("    <!-- Blog entries -->\n");
      out.write("    <div class=\"w3-col l8 s12\">\n");
      out.write(" \n");
      out.write("\n");
      out.write("      <!-- Blog entry -->\n");
      out.write("      <div class=\"w3-container w3-white w3-margin w3-padding-large\">\n");
      out.write("        <div class=\"w3-center\">\n");
      out.write("          <h3>MIS CURSOS</h3>\n");
      out.write("          <h5> Semestre Academico <span class=\"w3-opacity\">2017-2</span></h5>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"w3-justify\">\n");
      out.write("          <p><strong> Consultado </strong> el 23/03/2018 14:24 </p>\n");
      out.write("          <div class=\"table-responsive\">\n");
      out.write("          <table class=\"table table-sm\">\n");
      out.write("                <thead>\n");
      out.write("                  <tr>\n");
      out.write("                    <th scope=\"col\">#</th>\n");
      out.write("                    <th scope=\"col\">Codigo</th>\n");
      out.write("                    <th scope=\"col\">Nombre</th>\n");
      out.write("                    <th scope=\"col\">Creditos</th>\n");
      out.write("                    <th scope=\"col\">Categoria</th>\n");
      out.write("                  </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                  \n");
      out.write("                \n");
      out.write("           ");

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
             miColeccion = baseDatos.getCollection("Cursos");
              for (int i = 0; i <= LCursos.size() - 1; i++) {
                        query = new BasicDBObject();
                        query.put("CodC", LCursos.get(i));
                        cursor = miColeccion.find(query).iterator();
                        while (cursor.hasNext()) {
                            BasicDBObject G = BasicDBObject.parse( cursor.next().toJson()); 
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <th scope=\"row\">");
      out.print(i+1);
      out.write("</th>\n");
      out.write("                                <td>");
      out.print(G.getString("CodC"));
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(G.getString("Name"));
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(G.getString("Credit"));
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(G.getString("Cat"));
      out.write("</td>\n");
      out.write("                              </tr>\n");
      out.write("                            ");

                            } 
                       cursor.close();
                }
            
      out.write(" \n");
      out.write("          <!-- Example of comment field -->\n");
      out.write("                </tbody>\n");
      out.write("              </table>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <!-- Blog entry -->\n");
      out.write("      <div class=\"w3-container w3-white w3-margin w3-padding-large\">\n");
      out.write("        <div class=\"w3-center\">\n");
      out.write("          <h3>COMPAÑEROS</h3>\n");
      out.write("          <h5>Semestre Academico <span class=\"w3-opacity\"> 2017-2 </span></h5>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"w3-justify\">\n");
      out.write("          <p><strong> Consultado </strong> el 23/03/2018 14:24 </p> \n");
      out.write("          <nav class=\"navbar navbar-default\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                  <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("                  <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\n");
      out.write("                      <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                      <span class=\"icon-bar\"></span>\n");
      out.write("                      <span class=\"icon-bar\"></span>\n");
      out.write("                      <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">Consulta</a>\n");
      out.write("                  </div>\n");
      out.write("\n");
      out.write("                  <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("                  <div class=\"collapse navbar-collapse\"  id=\"bs-example-navbar-collapse-1\">\n");
      out.write("                    <form  id=\"Send12\" name=\"Yuli2\" method=\"POST\" >\n");
      out.write("                       <div class=\"w3-row-padding\">\n");
      out.write("                       <div class=\"w3-half\">\n");
      out.write("                      <input type=\"hidden\" name=\"UsuarioD\" value=\"");
      out.print(Nombre);
      out.write("\"/>\n");
      out.write("                   <div class=\"form-group\">\n");
      out.write("                      <select   name=\"Cod\" class=\"form-control\">\n");
      out.write("                        \n");
      out.write("                            ");

                        miColeccion = baseDatos.getCollection("Cursos");
                            for (int i = 0; i <= LCursos.size() - 1; i++) {
                                      query = new BasicDBObject();
                                      query.put("CodC", LCursos.get(i));
                                      cursor = miColeccion.find(query).iterator();
                                      while (cursor.hasNext()) {
                                          BasicDBObject G = BasicDBObject.parse( cursor.next().toJson());                       
                                          
      out.write("\n");
      out.write("                                          <option value=");
      out.print(LCursos.get(i));
      out.write('>');
      out.print(G.getString("Name"));
      out.write("</option>\n");
      out.write("                                          ");

                                          } 
                                     cursor.close();
                                    }
                                
      out.write("\n");
      out.write("                        \n");
      out.write("                      </select>\n");
      out.write("                  </div>\n");
      out.write("                           </div>   \n");
      out.write("                        <div class=\"w3-half\">\n");
      out.write("                            <div class=\"w3-row-padding\">\n");
      out.write("                                \n");
      out.write("                                    <div class=\"w3-half\">\n");
      out.write("                                  <input id =\"fg\" name=\"Cod2\" type=\"text\" class=\"form-control\" placeholder=\"Buscar Curso\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"w3-half\">\n");
      out.write("                                  <button id=\"Sendqq\" type=\"button\"  class=\"btn btn-default\">Consultar</button>\n");
      out.write("                                    </div>\n");
      out.write("                                \n");
      out.write("                            </div>  \n");
      out.write("                       </div>\n");
      out.write("                       </div>\n");
      out.write("                   </form>\n");
      out.write("                  </div><!-- /.navbar-collapse -->\n");
      out.write("                </div><!-- /.container-fluid -->\n");
      out.write("        </nav>\n");
      out.write("                        \n");
      out.write("             <div id=\"Replace3\"></div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("    <!-- END BLOG ENTRIES -->\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- About/Information menu -->\n");
      out.write("    <div class=\"w3-col l4\">\n");
      out.write("      <!-- About Card -->\n");
      out.write("      <div class=\"w3-white w3-margin\">\n");
      out.write("         <div id=\"Replace1\" class=\"w3-content w3-container w3-padding-64\">\n");
      out.write("            <h3 class=\"w3-center\">Consultar Creditos </h3>\n");
      out.write("            <p class=\"w3-center\"><em> La consulta puede tardar, sea paciente :v</em></p>\n");
      out.write("            <div  id=\"Replace2\" class=\"w3-row-padding\" >\n");
      out.write("                      <form  id=\"Send123\" name=\"Yuli1\" method=\"POST\" > \n");
      out.write("                    <div class=\"w3-row\">\n");
      out.write("                      <input class=\"w3-input w3-border\" type=\"text\" placeholder=\"Codigo\" required name=\"Cod\" autocomplete=\"off\">\n");
      out.write("                    </div>\n");
      out.write("                          <br>\n");
      out.write("                    <div class=\"w3-row\">\n");
      out.write("                      <input class=\"w3-input w3-border\" type=\"password\" placeholder=\"Contraseña\" required name=\"Pass\">\n");
      out.write("                    </div>\n");
      out.write("                      <button id=\"Sendq\" class=\"w3-button w3-black w3-right w3-section\"  type=\"button\">\n");
      out.write("                    <i class=\"fa fa-paper-plane\"></i> Buscar\n");
      out.write("                  </button>\n");
      out.write("                    </form>\n");
      out.write("             </div>\n");
      out.write("            \n");
      out.write("             </div>\n");
      out.write("      </div>\n");
      out.write(" \n");
      out.write("      <hr>\n");
      out.write("\n");
      out.write("      <!-- Advertising -->\n");
      out.write("      <div class=\"w3-white w3-margin\">\n");
      out.write("        <div class=\"w3-container w3-padding w3-black\">\n");
      out.write("          <h4> Buscar Compañero(a)</h4>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"w3-container w3-white\">\n");
      out.write("          <div class=\"w3-container w3-display-container w3-light-grey w3-section\" >\n");
      out.write("              <p class=\"w3-center\"><em> Ingrese sus datos, no es necesario rellenar todo el formulario, solo la informacion que disponga.</em></p>\n");
      out.write("           <div  id=\"Replace3\" class=\"w3-row-padding\" >\n");
      out.write("                      <form  id=\"Send123\" name=\"Yuli1\" method=\"POST\" > \n");
      out.write("                    <div class=\"w3-row\">\n");
      out.write("                      <input class=\"w3-input w3-border\" type=\"text\" placeholder=\"Nombre o Apellido \" required name=\"Name\" autocomplete=\"off\">\n");
      out.write("                    </div>\n");
      out.write("                          <br>\n");
      out.write("                    <div class=\"w3-row\">\n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                      <select   name=\"Cod\" class=\"form-control\">\n");
      out.write("                        <option value=\"-1\"> Carrera (Si dispone) </option>\n");
      out.write("                            ");

                                    miColeccion = baseDatos.getCollection("CP");

                                      cursor = miColeccion.find().iterator();
                                      while (cursor.hasNext()) {
                                          BasicDBObject G = BasicDBObject.parse( cursor.next().toJson());                       
                                          
      out.write("\n");
      out.write("                                          <option value=");
      out.print(G.getString("Cod"));
      out.write('>');
      out.print(G.getString("Name"));
      out.write("</option>\n");
      out.write("                                          ");

                                          } 
                                     cursor.close();
                                    
                                
      out.write("\n");
      out.write("                        \n");
      out.write("                      </select>\n");
      out.write("                  </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"w3-row\">\n");
      out.write("                      <input class=\"w3-input w3-border\" type=\"text\" placeholder=\"Codigo ej 13,14,15 ...  \"  name=\"Codd\" autocomplete=\"off\">\n");
      out.write("                    </div>\n");
      out.write("                                <br>   \n");
      out.write("                     <div class=\"w3-row\">\n");
      out.write("                      <input class=\"w3-input w3-border\" type=\"text\" placeholder=\"Curso (nombre si lleva(ó))\"  name=\"\" autocomplete=\"off\">\n");
      out.write("                    </div>\n");
      out.write("                      <button id=\"SendYul\" class=\"w3-button w3-black w3-right w3-section\"  type=\"button\">\n");
      out.write("                    <i class=\"fa fa-paper-plane\"></i> Buscar\n");
      out.write("                  </button>\n");
      out.write("                    </form>\n");
      out.write("             </div>\n");
      out.write("               </div>\n");
      out.write("      </div>\n");
      out.write("      <hr>\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("      <hr>\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("    <!-- END About/Intro Menu -->\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("  <!-- END GRID -->\n");
      out.write("  </div>\n");
      out.write("  \n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("// Script to open and close sidebar\n");
      out.write("function w3_open() {\n");
      out.write("    document.getElementById(\"mySidebar\").style.display = \"block\";\n");
      out.write("    document.getElementById(\"myOverlay\").style.display = \"block\";\n");
      out.write("}\n");
      out.write("\n");
      out.write("function w3_close() {\n");
      out.write("    document.getElementById(\"mySidebar\").style.display = \"none\";\n");
      out.write("    document.getElementById(\"myOverlay\").style.display = \"none\";\n");
      out.write("}\n");
      out.write("\n");
      out.write("$(document).ready(function () {\n");
      out.write("                $(\"#VerAll1\").click(function (event) {\n");
      out.write("                    $.ajax({\n");
      out.write("                        data: $(\"#Menu_1\").serialize(),\n");
      out.write("                        url: \"Page1.jsp\",\n");
      out.write("                        type:\"POST\",\n");
      out.write("                        success:\n");
      out.write("                                function (result) {\n");
      out.write("                                    $(\"#Replace\").html(result);\n");
      out.write("                                }});\n");
      out.write("                });\n");
      out.write("            }); \n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\"#VerAll3\").click(function (event) {\n");
      out.write("                    $.ajax({\n");
      out.write("                        data: $(\"#Menu_1\").serialize(),\n");
      out.write("                        url: \"Page3.jsp\",\n");
      out.write("                        type:\"POST\",\n");
      out.write("                        success:\n");
      out.write("                                function (result) {\n");
      out.write("                                    $(\"#Replace\").html(result);\n");
      out.write("                                }});\n");
      out.write("                });\n");
      out.write("            }); \n");
      out.write("\n");
      out.write("            \n");
      out.write("\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                \n");
      out.write("                $(\"#Sendq\").click(function (event) {\n");
      out.write("                \n");
      out.write("                    $.ajax({\n");
      out.write("                        data: $(\"#Send123\").serialize(),\n");
      out.write("                        url: \"Creditos.jsp\",\n");
      out.write("                        type:\"POST\",\n");
      out.write("                        success:\n");
      out.write("                                function (result) {\n");
      out.write("                                    $(\"#Replace1\").html(result);\n");
      out.write("                                }});\n");
      out.write("                        $('#Replace2').html('<br><div align=\"center\"><img src=\"loading.gif\"/></div>');\n");
      out.write("                });\n");
      out.write("                \n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            $(document).ready(function () {\n");
      out.write("                \n");
      out.write("                $(\"#Sendqq\").click(function (event) {\n");
      out.write("                \n");
      out.write("                    $.ajax({\n");
      out.write("                        data: $(\"#Send12\").serialize(),\n");
      out.write("                        url: \"ClassMate.jsp\",\n");
      out.write("                        type:\"POST\",\n");
      out.write("                        success:\n");
      out.write("                                function (result) {\n");
      out.write("                                    $(\"#Replace3\").html(result);\n");
      out.write("                                }});\n");
      out.write("                        \n");
      out.write("                });\n");
      out.write("                \n");
      out.write("            });\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
