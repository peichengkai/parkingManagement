package edu.buaa.park;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiaomin
 * Date: 12-12-16
 * Time: 上午11:22
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManager implements ParkingWorker {
    protected List<ParkPlace> parkPlaces;
    private final ParkingLotChooser parkingLotChooser;
    protected List<ParkingBoy> parkingBoys;

    public ParkingManager(List<ParkPlace> parkPlaces, ParkingLotChooser parkingLotChooser){

            this.parkPlaces=parkPlaces;
            this.parkingLotChooser = parkingLotChooser;
            this.parkingBoys = new ArrayList<ParkingBoy>();

    }

    public ParkingManager(List<ParkPlace> parkPlaces, ParkingLotChooser parkingLotChooser,List<ParkingBoy> parkingBoys){

        this.parkPlaces=parkPlaces;
        this.parkingLotChooser = parkingLotChooser;
        this.parkingBoys=parkingBoys;

    }

    public List<ParkingBoy> getParkingBoys(){
        return   parkingBoys;
    }

    public void setParkingBoys(List<ParkingBoy> parkingBoys){
        //this.parkingBoys=   parkingBoys;
        for(ParkingBoy parkBoy:parkingBoys){
               addParkingBoy(parkBoy);
        }
    }

    public void addParkingBoy(ParkingBoy parkingBoy){

        parkingBoys.add( parkingBoy);
        parkPlaces.addAll(parkingBoy.getParkPlaces());

    }

    public Ticket park(Car car) {
        return parkingLotChooser.getAvailablePark(parkPlaces).parkCar(car);
    }

    public Integer getAvailableNum() {
        int availableNum=0;
        for(ParkPlace parkPlace:parkPlaces){
            availableNum+=parkPlace.getAvailableNum();
        }
        return availableNum;
    }
    public Car fetch(Ticket ticket) {
        Car fetchedCar=null;
        for(ParkPlace parkPlace:parkPlaces){
            fetchedCar=parkPlace.fecthCar(ticket);
            if(fetchedCar!=null){return fetchedCar;}
        }
        throw new NoCarException("没有此车");
    }

    public List<ParkPlace> getParkPlaces(){
        return parkPlaces;
    }

}
