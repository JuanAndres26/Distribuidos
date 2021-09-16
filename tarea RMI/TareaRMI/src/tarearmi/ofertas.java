/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarearmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author casta
 */
public interface ofertas {
    public void registrar(String nombre) throws RemoteException;
    public void consultar() throws RemoteException;
}
