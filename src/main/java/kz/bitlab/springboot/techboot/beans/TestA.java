package kz.bitlab.springboot.techboot.beans;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component //запускает только первый конструктор
//@Scope(value = "prototype") //singleton - стоит по умолчанию
public class TestA {


    public TestA(){
        System.out.println("I am creating new object of Test A");
        this.name = "Some name";
        this.price = 2000;
    }

    public TestA(String name){
        System.out.println("Using parametrized constructor");
        this.name=name;
    }

    private String name;
    private int price;
}
