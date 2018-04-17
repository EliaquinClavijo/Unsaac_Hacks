package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public final class Creditos_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>87</title>\n");
      out.write("    </head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("     ");

            String Cod = "140992";
            String Pass = "47792";
           
            if (request.getParameter("Cod") != null) {
                Cod = request.getParameter("Cod");
                }
            if (request.getParameter("Pass") != null) {
                Pass = request.getParameter("Pass");
            }

            String command = "C:\\Users\\User\\AppData\\Local\\Programs\\Python\\Python36\\python C:\\data\\Total_Creditos.py";
            String param=" --Cod "+Cod+" --Pass "+Pass;
            System.out.println(command +param);
            ProcessBuilder builder1 = new ProcessBuilder( "cmd.exe", "/c", command + param );
            builder1.redirectErrorStream(true);
            Process p1 = builder1.start();
            BufferedReader r1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
            String line1;
            
      out.write("\n");
      out.write("            <div class=\"w3-white w3-margin\">\n");
      out.write("        <div class=\"w3-container w3-padding w3-black\">\n");
      out.write("          <h4>Consulta Creditos</h4>\n");
      out.write("        </div>\n");
      out.write("        <ul class=\"w3-ul w3-hoverable w3-white\">\n");
      out.write("            ");

               int start = 1; 
               boolean Va = false;
            while (true) {
                line1 = r1.readLine();
    
                if (line1.equals(null) || start == 10 ) { 
                    break; 
                }
                if  (start == 1)
                {
                    if (line1.substring(0,5).equals("Categ"))
                    {
                        Va = true;
                    }
                    
                }
               if (Va)
                {
                    
      out.write("\n");
      out.write("            <li class=\"w3-padding-16\">\n");
      out.write("            <span class=\"w3-large\">");
      out.print(line1);
      out.write("</span>\n");
      out.write("            <br>\n");
      out.write("            \n");
      out.write("          </li>\n");
      out.write("          ");

               
                }
            else
                   {
      out.write("\n");
      out.write("                   <div align=\"center\">\n");
      out.write("                       <br>\n");
      out.write("                       <br>\n");
      out.write("                       <span class=\"w3-large\"> Datos Erroneos </span> </div>");

                           break;
                    }
                    start ++;
                    
               
            }         
        
      out.write("\n");
      out.write("        </ul>\n");
      out.write("      </div>\n");
      out.write("      <hr>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("       <a href=\"home.jsp\" style=\"width:100%\" class=\"w3-button\"><i class=\"fa fa-home w3-margin-right\"></i>Home</a>\n");
      out.write("  </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
