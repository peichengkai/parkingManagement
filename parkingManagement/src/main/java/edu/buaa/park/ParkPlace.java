package edu.buaa.park;
import java.util.*;

public class ParkPlace {
    private int capacity;
    private String placesNo;

    public int getFullCapacity() {
        return fullCapacity;
    }

    private int fullCapacity;
    private Map<Ticket,Car> placeCarMaps=new HashMap<Ticket,Car>() ;
    public ParkPlace(int capacity) {
        this.capacity=capacity;
        this.fullCapacity = capacity;
    }
    public ParkPlace(String placesNo,int capacity) {
        this.placesNo=placesNo;
        this.capacity=capacity;
        this.fullCapacity = capacity;
    }

    public Ticket  parkCar(Car car){
        if(capacity<=0) throw new ParkFullException("车库满了");
        Ticket ticket=new Ticket();
        placeCarMaps.put(ticket,car);
        capacity--;
        return ticket;
    }
    public int getAvailableNum() {
        return capacity;
    }
    public Car fecthCar(Ticket ticket) {

        Car car=placeCarMaps.get(ticket);
        if(car!=null){
        placeCarMaps.remove(ticket);
        capacity++;}
        return car;

    }
}
