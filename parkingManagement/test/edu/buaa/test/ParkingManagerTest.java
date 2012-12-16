package edu.buaa.test;

import edu.buaa.park.*;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: lixiaomin
 * Date: 12-12-16
 * Time: 上午11:11
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManagerTest {

    /**
     *
     */
    @Test
    public void parkManager_ShouldParkCar(){
        Car car=new Car();
        int maxParkingNum=20;
        ParkPlace parkPlace=new ParkPlace(maxParkingNum);
        ArrayList<ParkPlace> parkPlaces=new ArrayList<ParkPlace>();
        parkPlaces.add(parkPlace) ;
        ParkingWorker parkingWorker= new ParkingManager(parkPlaces, new FirstAvailableParkingLotChooser());
        Ticket ticket=parkingWorker.park(car);
        Assert.assertEquals(new Integer(maxParkingNum - 1), parkingWorker.getAvailableNum());
    }


    @Test
    public void parkBoy_park_parkManager_park(){
        Car car=new Car();
        int maxParkingNum=20;
        ParkPlace parkPlace=new ParkPlace(maxParkingNum);
        ArrayList<ParkPlace> parkPlaces=new ArrayList<ParkPlace>();
        parkPlaces.add(parkPlace) ;
        ParkingBoy parkingBoy= new ParkingBoy(parkPlaces, new FirstAvailableParkingLotChooser());
        Ticket ticket=parkingBoy.park(car);
        Assert.assertEquals(new Integer(maxParkingNum - 1), parkingBoy.getAvailableNum());


        Car carM=new Car();
        int mMaxParkingNum=20;
        ParkPlace parkPlaceM=new ParkPlace(mMaxParkingNum);
        ArrayList<ParkPlace> mParkPlaces=new ArrayList<ParkPlace>();
        mParkPlaces.add(parkPlaceM) ;
        ParkingManager  parkingManager= new ParkingManager(mParkPlaces, new FirstAvailableParkingLotChooser());

        ticket=parkingManager.park(car);
        parkingManager.addParkingBoy(parkingBoy);

        Assert.assertEquals(parkingManager.getParkPlaces().size(), 2);
    }
}
