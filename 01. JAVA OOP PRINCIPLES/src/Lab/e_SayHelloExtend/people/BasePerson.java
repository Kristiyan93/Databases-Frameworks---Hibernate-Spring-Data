package Lab.e_SayHelloExtend.people;

import Lab.e_SayHelloExtend.interfaces.Person;

public abstract class BasePerson implements Person {
    private String name;

    public BasePerson(String name) {
        setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public abstract String sayHello();
}
