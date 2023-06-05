package kz.bitlab.springboot.techboot.db;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name = "application_request")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {
    Long id;
    String userName;
    String courseName;
    String commentary;
    String phone;
    boolean handled; //обработано или нет
}
