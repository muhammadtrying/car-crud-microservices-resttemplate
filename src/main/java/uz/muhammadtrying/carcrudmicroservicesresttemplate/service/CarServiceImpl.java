package uz.muhammadtrying.carcrudmicroservicesresttemplate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.muhammadtrying.carcrudmicroservicesresttemplate.entity.Car;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final RestTemplate restTemplate;

    @Override
    public List<Car> findAll() {
        return restTemplate.exchange(
                "http://localhost:8080/api/car/get/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Car>>() {
                }
        ).getBody();
    }

    @Override
    public Car findById(Integer carId) {
        return restTemplate.getForObject("http://localhost:8080/api/car/get/" + carId, Car.class);
    }

    @Override
    public Integer addCar(Car car) {
        HttpEntity<Car> request = new HttpEntity<>(car);
        ResponseEntity<Integer> response = restTemplate.exchange(
                "http://localhost:8080/api/car/add",
                HttpMethod.POST,
                request,
                Integer.class
        );
        return response.getBody();
    }

    @Override
    public Integer deleteById(Integer carId) {
        String url = "http://localhost:8080/api/car/delete/" + carId;

        ResponseEntity<Integer> response = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                null,
                Integer.class
        );

        return response.getBody();
    }

    @Override
    public Car update(Car car) {
        HttpEntity<Car> request = new HttpEntity<>(car);
        ResponseEntity<Car> response = restTemplate.exchange(
                "http://localhost:8080/api/car/update",
                HttpMethod.POST,
                request,
                Car.class
        );
        return response.getBody();
    }
}
