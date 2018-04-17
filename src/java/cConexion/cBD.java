/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cConexion;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 *
 * @author User
 */
public class cBD {
    
    private String aDBName;
    private DBCollection aColeccion;
    private DBCursor aCursor;
    private DB aDB;
    protected MongoClient aMCliente;
    
    
    public cBD(String DBName) {
        
        this.aDBName = DBName;
        CrearConexion();
    }
    
    public void CrearConexion(){
        aMCliente = new MongoClient("127.0.0.1",27017);
        aDB = aMCliente.getDB(aDBName);
        
    }
    
    public boolean ConsultarDatos(String CollectionName, BasicDBObject Datos){
        aColeccion = aDB.getCollection(CollectionName);
        aCursor = aColeccion.find(Datos);
        return aCursor.hasNext();
    }
    public DBCursor RecuperarDatos(String CollectionName, BasicDBObject Datos){
        aColeccion = aDB.getCollection(CollectionName);
        aCursor = aColeccion.find(Datos);
        return aCursor;
    }
    public void InsertarDatos(String CollectionName, BasicDBObject Datos){
        aColeccion = aDB.getCollection(CollectionName);
        aColeccion.insert(Datos);
    }
     public void EliminarDatos(String CollectionName, BasicDBObject Datos){
        aColeccion = aDB.getCollection(CollectionName);
        aColeccion.remove(Datos);
    }
    public void Update(String CollectionName, BasicDBObject DatosViejos, BasicDBObject DatosNuevos)
    {
        aColeccion = aDB.getCollection(CollectionName);
        aColeccion.update(DatosViejos,DatosNuevos);
    }
    
    
    
}
