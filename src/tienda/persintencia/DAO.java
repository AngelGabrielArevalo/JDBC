package tienda.persintencia;

import java.sql.*;
/*@author Angel Gabriel Arévalo*/
public abstract class DAO {
    
    protected Connection conexion=null;
    protected Statement sentencia=null;
    protected ResultSet resultado=null;
    
    private final String USER="root";
    private final String PASSWORD="root";
    private final String DATABASE="tienda";
    private final String DRIVER="com.mysql.cj.jdbc.Driver";
    
    protected void conectarBase() throws SQLException, ClassNotFoundException{
        try{
            Class.forName(DRIVER);
            String url="jdbc:mysql://localhost:3306/" + DATABASE;
            conexion=DriverManager.getConnection(url, USER, PASSWORD);
            
        }catch(SQLException | ClassNotFoundException e){
            throw e;
        }
    }
    
    protected void desconectarBase() throws SQLException{
        try{
            if (conexion!=null) {
                conexion.close();
            }
            if (sentencia!=null) {
                sentencia.close();
            }
            if (resultado!=null) {
                resultado.close();
            }
        }catch(SQLException e){
            throw e;
        }
    }
    
    protected void insertarModificarEliminar(String sql) throws ClassNotFoundException, SQLException{
        try{
            conectarBase();
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sql);
        }catch(ClassNotFoundException | SQLException e){
            throw e;          
        }finally{
            desconectarBase();
        }
    }
    
    protected void consultarBase(String sql) throws ClassNotFoundException, SQLException{
        try{
            conectarBase();
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sql);
            
        }catch(ClassNotFoundException | SQLException e){
            throw e;
        }
    }
}
