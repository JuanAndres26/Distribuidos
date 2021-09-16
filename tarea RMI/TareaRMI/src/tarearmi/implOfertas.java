/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarearmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author casta
 */
public class implOfertas extends UnicastRemoteObject implements ofertas {
    private List<String> ofertas;
    public implOfertas() throws RemoteException{
        ofertas = new ArrayList<>();
    }
    
    @Override
    public void registrar(String nombre) throws RemoteException {
        ofertas.add(nombre);
        System.out.println("Se agrego oferta");
    }

    @Override
    public void consultar() throws RemoteException {
        for(int i = 0; i < ofertas.size(); i++)
            System.out.println(" " + i +") " + ofertas.get(i));
    }
    
}
