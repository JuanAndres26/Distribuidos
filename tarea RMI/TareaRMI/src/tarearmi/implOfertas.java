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
    private ArrayList<Oferta> ofertas;
    public implOfertas() throws RemoteException{
        ofertas = new ArrayList<>();
    }
    
    @Override
    public void registrar(int id, String descripcion, double precio) throws RemoteException {
        Oferta of = new Oferta(id,descripcion,precio);
        ofertas.add(of);
        System.out.println("Se agrego oferta");
    }

    @Override
    public ArrayList<Oferta> consultar() throws RemoteException {
        return ofertas;
    }
    
}
