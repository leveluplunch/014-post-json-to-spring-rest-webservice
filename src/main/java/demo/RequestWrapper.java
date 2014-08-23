package demo;

import java.util.List;

public class RequestWrapper {

	List<Car> cars;
	Truck truck;
	
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	public Truck getTruck() {
		return truck;
	}
	public void setTruck(Truck truck) {
		this.truck = truck;
	}
	
	
}
