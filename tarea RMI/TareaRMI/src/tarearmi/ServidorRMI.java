/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarearmi;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 *
 * @author casta
 */
public class ServidorRMI {
    public static void main(String[] args) {
        String linea;
        ArrayList<Oferta> cache = new ArrayList<>();
        try{
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
            archivo = new File ("Cache.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            while((linea = br.readLine()) != null){
                StringTokenizer tokens = new StringTokenizer(linea);
                int id = Integer.parseInt(tokens.nextToken());
                String descripcion = "";
                if(tokens.nextToken().equals("[")){
                    String parte =  tokens.nextToken(); 
                    do{
                        descripcion = descripcion + " " + parte;
                        parte = tokens.nextToken();
                       }while(!parte.equals("]"));
                }
                double precio = Double.parseDouble(tokens.nextToken());
                Oferta of = new Oferta(id,descripcion,precio);
                cache.add(of);
            }
            Registry r =  LocateRegistry.createRegistry(1099);
            r.rebind("ofertas", new implOfertas(cache));
            System.out.println("Esta Corriendo el Servidor.....");
        }catch(Exception e){
            System.out.println("No prendio el servidor");
        }
    }
}
