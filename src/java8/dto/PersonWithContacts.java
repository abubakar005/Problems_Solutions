package java8.dto;

import java.util.List;

public class PersonWithContacts {

    private String name;
    private int age;
    private List<String> contacts;
    private boolean active;

    public PersonWithContacts(String name, int age, List<String> contacts, boolean active) {
        this.name = name;
        this.age = age;
        this.contacts = contacts;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getContacts() {
        return contacts;
    }

    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "PersonWithContacts{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", contacts=" + contacts +
                ", active=" + active +
                '}';
    }
}
