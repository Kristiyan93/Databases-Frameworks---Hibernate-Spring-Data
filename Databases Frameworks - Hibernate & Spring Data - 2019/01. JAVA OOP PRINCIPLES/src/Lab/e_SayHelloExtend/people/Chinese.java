package Lab.e_SayHelloExtend.people;

import Lab.e_SayHelloExtend.interfaces.Person;

public class Chinese extends BasePerson implements Person {

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
