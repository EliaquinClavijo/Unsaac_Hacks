package Autentication;

import cConexion.cBD;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

/**
 *
 * @author User
 */
public class cRegistroGrupo {
    
    private String aNombre;
    private String aPrivacidad;
    private String aFoto;
    private cBD aConexionBD;

    
    public cRegistroGrupo() 
    {
        aNombre = "";
        aPrivacidad = "";
        aFoto = "";
    }

    public String getaNombre() {
        return aNombre;
    }

    public void setaNombre(String aNombre) {
        this.aNombre = aNombre;
    }

    public String getaPrivacidad() {
        return aPrivacidad;
    }

    public void setaPrivacidad(String aPrivacidad) {
        this.aPrivacidad = aPrivacidad;
    }

    public String getaFoto() {
        return aFoto;
    }

    public void setaFoto(String aFoto) {
        this.aFoto = aFoto;
    }


    
    
    public void Insertar(){
        this.aConexionBD = new cBD("yptBD");
        BasicDBObject Query = new BasicDBObject();
        Query.put("nombre", this.aNombre);
        DBCursor C = aConexionBD.RecuperarDatos("Grupos",Query);
        if(!C.hasNext()){
        
        BasicDBObject Documento = new BasicDBObject();
        Documento.put("nombre", this.aNombre);
        Documento.put("privacidad", this.aPrivacidad);
        Documento.put("foto", this.aFoto);
        this.aConexionBD.InsertarDatos("Grupos", Documento);
        }
    }
}
