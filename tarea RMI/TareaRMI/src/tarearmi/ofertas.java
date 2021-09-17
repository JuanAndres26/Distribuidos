/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarearmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author casta
 */
public interface ofertas extends Remote {
    public void registrar(int id, String descripcion, double precio) throws RemoteException;
    public ArrayList<Oferta> consultar() throws RemoteException;
}
