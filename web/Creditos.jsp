<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>87</title>
    </head>
<body>

     <%
            String Cod = "asdffg";
            String Pass = "";
           
            if (request.getParameter("Cod") != null) {
                Cod = request.getParameter("Cod");
                }
            if (request.getParameter("Pass") != null) {
                Pass = request.getParameter("Pass");
            }

            String command = "C:\\Users\\User\\AppData\\Local\\Programs\\Python\\Python36\\python C:\\data\\Total_Creditos.py";
            String param=" --Cod "+Cod+" --Pass "+Pass;
            
            ProcessBuilder builder1 = new ProcessBuilder( "cmd.exe", "/c", command + param );
            builder1.redirectErrorStream(true);
            Process p1 = builder1.start();
            BufferedReader r1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
            String line1;
            %>
            <div class="w3-white w3-margin">
        <div class="w3-container w3-padding w3-black">
          <h4>Consulta Creditos</h4>
        </div>
        <ul class="w3-ul w3-hoverable w3-white">
            <%
               int start = 1; 
               boolean Va = false;
            while (true) {
                
                line1 = r1.readLine();
    
                if (line1.equals("End") )  { 
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
                    %>
            <li class="w3-padding-16">
            <span class="w3-large"><%=line1%></span>
            <br>
            
          </li>
                    <%
               
                }
            else
                   {%>
                   <div align="center">
                       <br>
                       <br>
                       <span class="w3-large"> Datos Erroneos </span> </div>
                       <%
                           break;
                    }
                    start ++;
                    
               
            }
            r1.close();
        %>
        </ul>
      </div>
      <hr>
        <div class="container-fluid">
       <a href="home.jsp" style="width:100%" class="w3-button"><i class="fa fa-home w3-margin-right"></i>Home</a>
  </div>
    </body>
</html>