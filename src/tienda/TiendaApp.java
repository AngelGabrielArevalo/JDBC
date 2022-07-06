package tienda;

/*@author Angel Gabriel Arévalo*/
import java.util.Scanner;
import javax.xml.transform.Source;
import tienda.servicios.FabricanteService;

public class TiendaApp {

    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        FabricanteService fc = new FabricanteService();
        System.out.println("Ingrese nombre de fabricante:");
        String nombre=entrada.next();
        try{
            fc.crearFabricante(10, nombre);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
