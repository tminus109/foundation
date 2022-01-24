package petrol_station;

public class Station {
    int gasAmount;

    public void refill(Car car) {
        int refillAmount = car.capacity - car.gasAmount;
        this.gasAmount -= refillAmount;
        car.gasAmount += refillAmount;
    }
}
