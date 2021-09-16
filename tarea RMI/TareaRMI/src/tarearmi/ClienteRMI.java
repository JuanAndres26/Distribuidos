/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package tarearmi;
import java.rmi.Naming;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
/**
 *
 * @author casta
 */
public class ClienteRMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    try{
        Registry miRegistro = LocateRegistry.getRegistry("localhost", 1100);
        ofertas o = (ofertas) Naming.lookup("ofertas");
        while(true){
            System.out.println("Que opcion desea:\n"
                    + "1) Agregar oferta\n"
                    + "2) Mostrar todas las ofertas\n");
            System.out.print("Seleccione una opcion");
            String respuesta = sc.nextLine();
        }
    }catch(Exception e){
        System.out.println("Servidor no Encontrado");
    }
    }
}
