package tienda.persintencia;

import tienda.entidades.Fabricante;

/*@author Angel Gabriel Arévalo*/
public final class FabricanteDao extends DAO{
    
    public void insertarFabricante(Fabricante fabricante) throws Exception{
        try{
            if(fabricante==null){
                throw new Exception("Debe ingresar un usuario!");
            }
            String sql="insert into fabricante values(" + fabricante.getCodigo() + ",'" + fabricante.getNombre() + "');";
            insertarModificarEliminar(sql);
        }catch(Exception e){
            throw e;
        }
    }
    
}
