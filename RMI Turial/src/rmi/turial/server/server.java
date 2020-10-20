/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.turial.server;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.turial.Weatherservice;
/**
 *
 * @author Asus
 */
public class server {
private static final int PORT = 1099;
   private static Registry registry;
 
   public static void startRegistry() throws RemoteException {
 
       // Tạo một bộ đăng ký (Registry) tại Server.
       registry =  LocateRegistry.createRegistry(PORT);
   }
    public static void registerObject(String name, Remote remoteObj)
           throws RemoteException, AlreadyBoundException {
        registry.bind(name, remoteObj);
       System.out.println("Registered: " + name + " -> "
               + remoteObj.getClass().getName() + "[" + remoteObj + "]");
    }
    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args)throws Exception{
        // TODO code application logic here
        System.out.println("Server starting...");
        startRegistry();
        registerObject(Weatherservice.class.getSimpleName(),new weatherservicelmpl());
         System.out.println("Server started!");
    }
    
}
