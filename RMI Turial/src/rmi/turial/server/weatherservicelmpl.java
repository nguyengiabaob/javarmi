/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.turial.server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.Date;
import rmi.turial.constant;
import rmi.turial.WeatherData;
import rmi.turial.Weatherservice;
/**
 *
 * @author Asus
 */
public class weatherservicelmpl extends UnicastRemoteObject implements Weatherservice{
     private static final long serialVersionUID = 1L;
 
  public weatherservicelmpl() throws RemoteException {
      super();
      }
 
  public synchronized WeatherData getWeather(Date date, String location)  throws RemoteException
  {
      Calendar c = Calendar.getInstance();
      c.setTime(date);
      int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
 
      // Sunday, Monday
      if (dayOfWeek == 1 || dayOfWeek == 2) {
          switch (location) {
              case constant.LOCATION_CHICAGO -> {
                  // Rain
                  return new WeatherData(date, location, constant.WEATHER_RAIN);
              }
              case constant.LOCATION_HANOI -> {
                  // Sunny
                  return new WeatherData(date, location, constant.WEATHER_SUNNY);
              }
              case constant.LOCATION_TOKYO -> {
                  // Sunny
                  return new WeatherData(date, location, constant.WEATHER_SUNNY);
              }
              default -> {
              }
          }
          return new WeatherData(date, location, constant.WEATHER_SUNNY);
      } else {
          return new WeatherData(date, location,constant.WEATHER_SUNNY);
      }
  }
}
