package com.company;

public class Person {
    String firstName;
    String lastName;
    String age;
    String city;
    String state;
    String street;

    //Store all the needed information about a person
    Person(String first, String last,String street, String city, String state,String age){
        this.firstName = first;
        this.lastName = last;
        this.age = age;
        this.city = city;
        this.state = state;
        this.street = street;
    }

}
