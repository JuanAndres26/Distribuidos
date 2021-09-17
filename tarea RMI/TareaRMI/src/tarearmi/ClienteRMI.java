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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author casta
 */
public class ClienteRMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Oferta of = new Oferta();
    try{
        Registry miRegistro = LocateRegistry.getRegistry("localhost", 1099);
        ofertas o = (ofertas) Naming.lookup("//192.168.100.137/ofertas");
        while(true){
            System.out.println("Que opcion desea:\n"
                    + "1) Agregar oferta\n"
                    + "2) Consultar todas las ofertas\n"
                    + "3) Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("-------------------------------");
                    System.out.println("Ingrese el id del registro : ");
                    int id = sc.nextInt();
                    System.out.println("Ingrese la descripcion de la oferta :");
                    String des = sc.next();
                    System.out.println("Ingrese el precio :");
                    double pres =sc.nextDouble();
                    System.out.println( id+" "+des+" "+pres);
                    o.registrar(id,des,pres);
                    break;
                case 2:
                    System.out.println("Todas las ofertas son: ");
                    ArrayList<Oferta> ofertas = o.consultar();
                    for(int i = 0; i < ofertas.size(); i++)
                        System.out.println(" " + (i+1) +") " + ofertas.get(i).getId()+" "+ofertas.get(i).getDescripcion()+" "+ofertas.get(i).getPrecio());
                    System.out.println("-------------------------------");
                    break;
                case 3:
                    return;
            }
        }
    }catch(Exception e){
        System.out.println("Servidor no Encontrado" + e);
    }
    }
}
