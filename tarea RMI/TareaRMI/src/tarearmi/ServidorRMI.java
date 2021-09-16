/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarearmi;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author casta
 */
public class ServidorRMI {
    public static void main(String[] args) {
        try{
            Registry r =  LocateRegistry.createRegistry(1100);
            r.rebind("ofertas", new implOfertas());
            System.out.println("Esta Corriendo el Servidor.....");
        }catch(Exception e){
            System.out.println("No prendio el servidor");
        }
    }
}
