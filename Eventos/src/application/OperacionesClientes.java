package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class OperacionesClientes {

    Connection connection;

    public OperacionesClientes(Connection conn){
        this.connection = conn;
    }
    
    //Metodo para consultar
    public Cliente getCliente(int id){
        int clienteId = 0;
        String nombre = "", apellidos = "", direccion = "";

        String query = "SELECT clienteid, nombre, apellidos, direccion " +
                "FROM cliente " +
                "WHERE clienteID = " + id;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                clienteId = rs.getInt("clienteid");
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellidos");
                direccion = rs.getString("direccion");
            }

            return new Cliente(clienteId, nombre, apellidos, direccion);
        }
        catch (java.sql.SQLException ex){
            ex.printStackTrace();
            System.out.println("SQLException:" + ex.getMessage());
            System.out.println("SQLState:" + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());

            return null;
        }
    }
    
    
    //Metodo de la tabla para CONSULTAR con Nombre
    public ObservableList getClienteNom(String nom){
        int clienteId = 0;
        String nombre = "", apellidos = "", direccion = "";
        ArrayList cliente=new ArrayList();
        String query = "SELECT clienteid, nombre, apellidos, direccion " +
                "FROM cliente " +
                "WHERE nombre = '" + nom+"'";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                clienteId = rs.getInt("clienteid");
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellidos");
                direccion = rs.getString("direccion");
                cliente.add(new Cliente(clienteId, nombre, apellidos, direccion));
            }
            ObservableList data = FXCollections.observableList(cliente);

            return data;
        }
        catch (java.sql.SQLException ex){
            ex.printStackTrace();
            System.out.println("SQLException:" + ex.getMessage());
            System.out.println("SQLState:" + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());

            return null;
        }
    }
    
    
  //Metodo de la tabla para CONSULTAR por ID
    public ObservableList getClienteIdMostrar(int Id){
        int clienteId = 0;
        String nombre = "", apellidos = "", direccion = "";
        ArrayList cliente=new ArrayList();
        String query = "SELECT clienteid, nombre, apellidos, direccion " +
                "FROM cliente " +
                "WHERE clienteID = " + Id;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                clienteId = rs.getInt("clienteid");
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellidos");
                direccion = rs.getString("direccion");
                cliente.add(new Cliente(clienteId, nombre, apellidos, direccion));
            }
            ObservableList data = FXCollections.observableList(cliente);

            return data;
        }
        catch (java.sql.SQLException ex){
            ex.printStackTrace();
            System.out.println("SQLException:" + ex.getMessage());
            System.out.println("SQLState:" + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());

            return null;
        }
    }
    
    //Metodo de la tabla para CONSULTAR por Apellido
    public ObservableList getClienteApe(String ape){
        int clienteId = 0;
        String nombre = "", apellidos = "", direccion = "";
        ArrayList cliente=new ArrayList();
        String query = "SELECT clienteid, nombre, apellidos, direccion " +
                "FROM cliente " +
                "WHERE apellidos = '" + ape+"'";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                clienteId = rs.getInt("clienteid");
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellidos");
                direccion = rs.getString("direccion");
                cliente.add(new Cliente(clienteId, nombre, apellidos, direccion));
            }
            ObservableList data = FXCollections.observableList(cliente);

            return data;
        }
        catch (java.sql.SQLException ex){
            ex.printStackTrace();
            System.out.println("SQLException:" + ex.getMessage());
            System.out.println("SQLState:" + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());

            return null;
        }
    }
    
    
    //Metodo para Eliminar Cliente por ID
    public int deleteCliente(int id){
        int clienteId;
        String nombre, apellidos, direccion;

        String query = "delete from cliente where clienteID = " + id;

        int numRegs = 0;
        try {
            Statement stmt = connection.createStatement();
            numRegs = stmt.executeUpdate(query);

            System.out.println("Cantidad de registros afectados: " + numRegs);
        }
        catch (java.sql.SQLException ex){
            ex.printStackTrace();
            System.out.println("SQLException:" + ex.getMessage());
            System.out.println("SQLState:" + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());

        }

        return numRegs;
    }
    
    
  //Metodo para añadir un Cliente
    public int insertCliente(String nombre, String apellidos, String direccion){

        String query = "insert into cliente(nombre, apellidos, direccion) " +
                "values ('" + nombre + "', '" + apellidos + "', '" + direccion + "')";

        int numRegs = 0;
        try {
            Statement stmt = connection.createStatement();
            numRegs = stmt.executeUpdate(query);

            System.out.println("Cantidad de registros afectados: " + numRegs);

        }
        catch (java.sql.SQLException ex){
            ex.printStackTrace();
            System.out.println("SQLException:" + ex.getMessage());
            System.out.println("SQLState:" + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());
        }

        return numRegs;
    }

    
    //Metodo para Modificar Cliente
    public int ModifCliente(int id,String nom, String ape, String direc){
        int clienteId = 0;
        String nombre = "", apellidos = "", direccion = "";

        String query = "UPDATE cliente " +
                "set nombre =  '" +nom+"', apellidos= '"+ape+"', direccion='"+direc+"' "+
                "WHERE clienteID = " + id;
        int rs=0;
        try {
            Statement stmt = connection.createStatement();
             rs = stmt.executeUpdate(query);
        }
        catch (java.sql.SQLException ex){
            ex.printStackTrace();
            System.out.println("SQLException:" + ex.getMessage());
            System.out.println("SQLState:" + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());
        }
        return rs;
    }
    
    
    //Metodo de la tabla para mostrar todo
    public ObservableList getClienteTodo(){
        int clienteId = 0;
        String nombre = "", apellidos = "", direccion = "";
        ArrayList cliente=new ArrayList();
        String query = "SELECT clienteid, nombre, apellidos, direccion " +
                "FROM cliente ";   

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                clienteId = rs.getInt("clienteid");
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellidos");
                direccion = rs.getString("direccion");
                cliente.add(new Cliente(clienteId, nombre, apellidos, direccion));
            }
            ObservableList data = FXCollections.observableList(cliente);

            return data;
        }
        catch (java.sql.SQLException ex){
            ex.printStackTrace();
            System.out.println("SQLException:" + ex.getMessage());
            System.out.println("SQLState:" + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());

            return null;
        }
    }
}

