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
    public void parkBoy_ShouldParkCar(){
        Car car=new Car();
        int maxParkingNum=20;
        ParkPlace parkPlace=new ParkPlace(maxParkingNum);
        ArrayList<ParkPlace> parkPlaces=new ArrayList<ParkPlace>();
        parkPlaces.add(parkPlace) ;
        ParkingBoy parkingBoy= new ParkingBoy(parkPlaces, new FirstAvailableParkingLotChooser());
        Ticket ticket=parkingBoy.park(car);
        Assert.assertEquals(new Integer(maxParkingNum - 1), parkingBoy.getAvailableNum());
    }
}
