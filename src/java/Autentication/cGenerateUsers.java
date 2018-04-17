package Autentication;

import cConexion.cBD;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

/**
 *
 * @author User
 */
public class cGenerateUsers{
    
    private String aNombreGrupo;
    private String aNombre; 
    private String aAdmi;
    private cBD aConexionBD;

    
    public cGenerateUsers() 
    {
        aNombre = "";
        aNombreGrupo = "";
        aAdmi = "";
    }

    public String getaNombreGrupo() {
        return aNombreGrupo;
    }

    public void setaNombreGrupo(String aNombreGrupo) {
        this.aNombreGrupo = aNombreGrupo;
    }

    public String getaNombre() {
        return aNombre;
    }

    public void setaNombre(String aNombre) {
        this.aNombre = aNombre;
    }

    public String getaAdmi() {
        return aAdmi;
    }

    public void setaAdmi(String aAdmi) {
        this.aAdmi = aAdmi;
    }

    public cBD getaConexionBD() {
        return aConexionBD;
    }

    public void setaConexionBD(cBD aConexionBD) {
        this.aConexionBD = aConexionBD;
    }




    
    
    public void Insertar(){
        this.aConexionBD = new cBD("yptBD");
        BasicDBObject Documento = new BasicDBObject();
        Documento.put("nombre", this.aNombre);
        Documento.put("administrador", this.aAdmi);
        this.aConexionBD.InsertarDatos(aNombreGrupo, Documento);
        }
    
    public void Eliminar(){
        this.aConexionBD = new cBD("yptBD");
        BasicDBObject Documento = new BasicDBObject();
        Documento.put("nombre", this.aNombre);
        this.aConexionBD.EliminarDatos(aNombreGrupo, Documento);
        }
}
