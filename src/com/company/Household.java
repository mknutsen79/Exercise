package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Household {
    ArrayList<Person> people = new ArrayList<Person>();
    int occupants;
    String house;

    Household(String house){
        this.house = house;
    }

    //add a person to our list of people and up the amount of occupants the household has
    public void addOccupant(Person person){
        people.add(person);
        occupants++;
    }

    //sort the occupants in the household by last name then first name
    public void sortOccupants(){
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int res = o1.lastName.compareTo(o2.lastName);
                if( res != 0){
                    return res;
                }
                return o1.firstName.compareTo(o2.firstName);
            }
        });
    }

        //output the household placement, number of occupants, then list the people living inside who are 18 and older
    public void checkOccupants(){
        System.out.println(house + " Number of Occupants: " + occupants);
        for(Person person : people){
            String age = person.age.replaceAll("\"", "");
            int num = Integer.parseInt(age);
            if(num < 18){
                continue;
            }
            System.out.println(person.firstName + " " + person.lastName + " " + person.street + " " + person.city + " " + person.state + " " + person.age);
        }
    }


}
