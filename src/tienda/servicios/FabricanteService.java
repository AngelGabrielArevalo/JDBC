package tienda.servicios;

import tienda.entidades.Fabricante;
import tienda.persintencia.FabricanteDao;

/*@author Angel Gabriel Arévalo*/
public class FabricanteService {

    public void crearFabricante(Integer codigo, String nombre) throws Exception {

        try {
            if (codigo != null) {
                throw new Exception("El código debe ser null ya que es pk autocremental!");
            }
            if (nombre == null) {
                throw new Exception("Debe ingresar un nombre!!");
            }
            FabricanteDao dao = new FabricanteDao();
            Fabricante fabricante = new Fabricante(codigo, nombre);
            dao.insertarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }
}
