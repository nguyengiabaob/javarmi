/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.turial.cilent;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import rmi.turial.constant;
import rmi.turial.WeatherData;
import rmi.turial.Weatherservice;
/**
 *
 * @author Asus
 */
public class client {
  private static final String HOST = "localhost";
   private static final int PORT = 1099;
   private static Registry registry;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        registry = LocateRegistry.getRegistry(HOST, PORT);
 
       // Lookup WeatherService in the Registry.
       Weatherservice service = (Weatherservice) registry
               .lookup(Weatherservice.class.getSimpleName());
 
       Date today = new Date();
 
       // Get Chicago weather info:
       WeatherData chicagoWeather = service.getWeather(today,
               constant.LOCATION_CHICAGO);
 
       System.out.println("Chicago weather today: "
               + chicagoWeather.getWeather());
        
       // Get Hanoi weather info:
       WeatherData hanoiWeather = service.getWeather(today,
               constant.LOCATION_HANOI);
 
       System.out.println("Hanoi weather today: " + hanoiWeather.getWeather());
 
   }
    }
    

