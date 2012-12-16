package edu.buaa.park;

/**
 * Created with IntelliJ IDEA.
 * User: lixiaomin
 * Date: 12-12-16
 * Time: 上午11:19
 * To change this template use File | Settings | File Templates.
 */
public interface ParkingWorker {
    Ticket park(Car car);
    public Integer getAvailableNum();
    public Car fetch(Ticket ticket);
}
