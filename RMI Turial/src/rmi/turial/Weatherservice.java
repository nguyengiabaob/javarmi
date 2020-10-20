/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.turial;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
/**
 *
 * @author Asus
 */
public interface Weatherservice extends Remote{
 
     public WeatherData getWeather(Date date, String location)
         throws RemoteException;
    
}
