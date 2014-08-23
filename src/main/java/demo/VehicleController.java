package demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

	@RequestMapping(value = "/")
	public ResponseEntity<Car> get() {

		Car car = new Car();
		car.setColor("Blue");
		car.setMiles(100);
		car.setVIN("1234");

		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Car> update(@RequestBody Car car) {

		if (car != null) {
			car.setMiles(car.getMiles() + 100);
		}
		
		// TODO: call persistence layer to update
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cars", method = RequestMethod.POST)
	public ResponseEntity<List<Car>> update(@RequestBody List<Car> cars) {

		cars.stream().forEach(c -> c.setMiles(c.getMiles() + 100));
		
		// TODO: call persistence layer to update
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/carsandtrucks", method = RequestMethod.POST)
	public ResponseEntity<RequestWrapper> updateWithMultipleObjects(
			@RequestBody RequestWrapper requestWrapper) {

		requestWrapper.getCars().stream()
				.forEach(c -> c.setMiles(c.getMiles() + 100));

		// TODO: call persistence layer to update
		return new ResponseEntity<RequestWrapper>(requestWrapper, HttpStatus.OK);
	}
	
	
	
	
	
	
	
}
