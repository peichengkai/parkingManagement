package edu.buaa.park;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiaomin
 * Date: 12-12-16
 * Time: 上午11:19
 * To change this template use File | Settings | File Templates.
 */
public interface ParkingWorker {
    public Ticket park(Car car);
    public Integer getAvailableNum();
    public Car fetch(Ticket ticket);
    public List<ParkPlace> getParkPlaces();
}
