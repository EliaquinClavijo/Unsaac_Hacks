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
public class cRegistroCodigo {
    private String aNombre;
    private String aCodigo;
    private String aUse;
    private cBD aConexionBD;

    public String getaNombre() {
        return aNombre;
    }

    public void setaNombre(String aNombre) {
        this.aNombre = aNombre;
    }

    public String getaCodigo() {
        return aCodigo;
    }

    public void setaCodigo(String aCodigo) {
        this.aCodigo = aCodigo;
    }

    public String getaUser() {
        return aUse;
    }

    public void setaUser(String aUse) {
        this.aUse = aUse;
    }
    
    public cRegistroCodigo() 
    {
        aNombre = "";
        aCodigo = "";
        aUse = "";
    }
    public void Insertar(){
        this.aConexionBD = new cBD("UnsaacDB");
        
        BasicDBObject Documento = new BasicDBObject();
        Documento.put("fecha", this.aCodigo);
        Documento.put("codigo", this.aNombre);

        this.aConexionBD.InsertarDatos("LogEntrada", Documento);
        
    }
    
}
