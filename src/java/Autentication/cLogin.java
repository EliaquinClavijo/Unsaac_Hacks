/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Autentication;

import cConexion.cBD;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;

/**
 *
 * @author User
 */
public class cLogin {
    
    private String aUsuario;
    private String aContraseña;
    private cBD aConexionBD;
    

    public cLogin() {
        aUsuario = "";
        
    }

    public void setaUsuario(String aUsuario) {
        this.aUsuario = aUsuario;
    }

    public void setaContraseña(String aContraseña) {
        this.aContraseña = aContraseña;
    }

    public void setCon(cBD Con) {
        this.aConexionBD = Con;
    }

  
    
    
    public boolean ValidarLogIn()
    {
        this.aConexionBD = new cBD("yptBD");
        aConexionBD.CrearConexion();
        BasicDBObject Datos = new BasicDBObject();
        Datos.put("nombre",aUsuario);
        Datos.put("clave", aContraseña);
        Cursor cur = aConexionBD.RecuperarDatos("Usuarios", Datos);
        if (cur.hasNext()) 
        {
            
            BasicDBObject update = new BasicDBObject();
            update.append("$inc", new BasicDBObject().append("Sesiones", 1));
            update.append("$set", new BasicDBObject().append("Conectado", true));
            
            aConexionBD.Update("Usuarios", Datos, update);
            return true;
        }
        else
            return false;
        }
    public boolean ContarMensajeEnvi()
    {
        this.aConexionBD = new cBD("yptBD");
        aConexionBD.CrearConexion();
        BasicDBObject Datos = new BasicDBObject();
        Datos.put("nombre",aUsuario);
        Cursor cur = aConexionBD.RecuperarDatos("Usuarios", Datos);
        if (cur.hasNext()) 
        {
            
            BasicDBObject update = new BasicDBObject();
            update.append("$inc", new BasicDBObject().append("enviados", 1));
   
            aConexionBD.Update("Usuarios", Datos, update);
            return true;
        }
        else
            return false;
        }
    
    public boolean ContarMensajeReciv()
    {
        this.aConexionBD = new cBD("yptBD");
        aConexionBD.CrearConexion();
        BasicDBObject Datos = new BasicDBObject();
        Datos.put("nombre",aUsuario);
        Cursor cur = aConexionBD.RecuperarDatos("Usuarios", Datos);
        if (cur.hasNext()) 
        {
            
            BasicDBObject update = new BasicDBObject();
            update.append("$inc", new BasicDBObject().append("recibidos", 1));
   
            aConexionBD.Update("Usuarios", Datos, update);
            return true;
        }
        else
            return false;
        }
    public boolean Salir()
    {
        this.aConexionBD = new cBD("yptBD");
        aConexionBD.CrearConexion();
        BasicDBObject Datos = new BasicDBObject();
        Datos.put("nombre",aUsuario);
        Cursor cur = aConexionBD.RecuperarDatos("Usuarios", Datos);
        if (cur.hasNext()) 
        {
            
            BasicDBObject update = new BasicDBObject();
            update.append("$inc", new BasicDBObject().append("Sesiones", -1));
            update.append("$set", new BasicDBObject().append("Conectado", false));
            
            aConexionBD.Update("Usuarios", Datos, update);
            return true;
        }
        else
            return false;
        }
    
}
