package uz.muhammadtrying.carcrudmicroservicesresttemplate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.muhammadtrying.carcrudmicroservicesresttemplate.entity.Car;
import uz.muhammadtrying.carcrudmicroservicesresttemplate.service.CarService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping()
public class CarController {
    private final CarService carService;

    @GetMapping("/get/all")
    public List<Car> getAllCars() {
        return carService.findAll();
    }

    @GetMapping("/get/{carId}")
    public Car findById(@PathVariable Integer carId) {
        return carService.findById(carId);
    }

    @PostMapping("/add")
    public Integer addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @DeleteMapping("/delete/{carId}")
    public Integer deleteById(@PathVariable Integer carId) {
        return carService.deleteById(carId);
    }

    @PostMapping("/update")
    public Car update(@RequestBody Car car) {
        return carService.update(car);
    }
}
