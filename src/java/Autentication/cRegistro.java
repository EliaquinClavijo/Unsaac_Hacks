/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Autentication;

import cConexion.cBD;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

/**
 *
 * @author User
 */
public class cRegistro {
    
    private String aNombre;
    private String aApellido;
    private String aEmail;
    private String aFoto;
    private String aContrasena;
    private String aTelefono;
    private String aOcupacion;
    private String aCiudad;
    private String aPais;
    private cBD aConexionBD;
    private int Sesiones = 0;
    private boolean Conectado = false;
    
    public cRegistro() 
    {
        aNombre = "";
        aCiudad = "";
        aPais = "";
    }

    public void setaNombre(String aNombre) {
        this.aNombre = aNombre;
    }

    public void setaApellido(String aApellido) {
        this.aApellido = aApellido;
    }

    public void setaEmail(String aEmail) {
        this.aEmail = aEmail;
    }

    public void setaFoto(String aFoto) {
        this.aFoto = aFoto;
    }

    public void setaContrasena(String aContrasena) {
        this.aContrasena = aContrasena;
    }

    public void setaTelefono(String aTelefono) {
        this.aTelefono = aTelefono;
    }

    public void setaOcupacion(String aOcupacion) {
        this.aOcupacion = aOcupacion;
    }

    public void setaCiudad(String aCiudad) {
        this.aCiudad = aCiudad;
    }

    public void setaPais(String aPais) {
        this.aPais = aPais;
    }

    public void setaConexionBD(cBD aConexionBD) {
        this.aConexionBD = aConexionBD;
    }

    public void setSesiones(int Sesiones) {
        this.Sesiones = Sesiones;
    }

    public void setConectado(boolean Conectado) {
        this.Conectado = Conectado;
    }
    
    
    public void Insertar(){
        this.aConexionBD = new cBD("yptBD");
        BasicDBObject Query = new BasicDBObject();
        Query.put("nombre", this.aNombre);
        DBCursor C = aConexionBD.RecuperarDatos("Usuarios",Query);
        if(!C.hasNext()){
        
        BasicDBObject Documento = new BasicDBObject();
        Documento.put("nombre", this.aNombre);
        Documento.put("apellido", this.aApellido);
        Documento.put("email", this.aEmail);
        Documento.put("foto", this.aFoto);
        Documento.put("clave", this.aContrasena);
        Documento.put("telefono", this.aTelefono);
        Documento.put("ocupacion", this.aOcupacion);
        Documento.put("ciudad", this.aCiudad);
        Documento.put("pais", this.aPais);
        Documento.put("Sesiones",this.Sesiones);
        Documento.put("Conectado",this.Conectado);
        Documento.put("enviados", 0);
        Documento.put("recibidos",0);
        this.aConexionBD.InsertarDatos("Usuarios", Documento);
        }
    }
    
    public void Eliminar(){
        this.aConexionBD = new cBD("yptBD");
        BasicDBObject Documento = new BasicDBObject();
        Documento.put("nombre", this.aNombre);
        this.aConexionBD.EliminarDatos("Usuarios", Documento);
        }
}
