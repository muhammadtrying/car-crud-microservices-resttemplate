package uz.muhammadtrying.carcrudmicroservicesresttemplate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Car {
    private Integer id;
    private String name;
    private Integer price;
    private String company;
}
