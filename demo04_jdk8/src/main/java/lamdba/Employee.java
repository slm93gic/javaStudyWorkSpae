package lamdba;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import stream.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String name;
    private Integer age;
    private Double salary;
    private Status status;

}
