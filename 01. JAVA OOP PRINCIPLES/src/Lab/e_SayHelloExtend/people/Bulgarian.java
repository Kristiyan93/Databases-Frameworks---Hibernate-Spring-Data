package Lab.e_SayHelloExtend.people;

import Lab.e_SayHelloExtend.interfaces.Person;

public class Bulgarian extends BasePerson implements Person {
    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
