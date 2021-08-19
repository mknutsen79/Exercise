package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// take in the input and turn each line into an array
        Scanner read = new Scanner(System.in);
        String line;
        ArrayList<Person> people = new ArrayList<Person>();
        ArrayList<Household> houses = new ArrayList<Household>();
        Map<String, Integer> houseHolds = new HashMap<String, Integer>();
        //read each line
        while(read.hasNextLine()){
            //read the current line of input we are at in the console
            line = read.nextLine();
            //remove periods from the line to be uniform it
            line = line.replaceAll("\\.", "");
            //split on the points of "," so that way we don't cause problems with other commas
            String[] arrOfLine = line.split("\",\"");
            //remove any comma that exist in the street address portion
            arrOfLine[2] = arrOfLine[2].replaceAll(",", "");
            //remove any whitespace that will now exist due to the replacements
            arrOfLine[2] = arrOfLine[2].trim();
            //create person objects and add them to our array list of people
            people.add(new Person(arrOfLine[0], arrOfLine[1], arrOfLine[2], arrOfLine[3], arrOfLine[4], arrOfLine[5]));

        }
        //Go through our list of people and add them to their appropriate Households
        for(Person person : people){
            //check the persons street, city and state to determine their Household.
            String home = (person.street + " " + person.city + " " + person.state).toUpperCase();
            //create a Household if the list of Households is empty and add the person to its occupancy.
            if(houses.isEmpty()){
                houses.add(new Household(home));
                houses.get(0).addOccupant(person);
                //set the key to be the home address and the value to be the index it exists in the array
                houseHolds.put(home, 0);
            }else{
                //Check if our Household exists, if it does add the person to the household otherwise create and add house to array and update map
                if(houseHolds.containsKey(home)){
                    houses.get(houseHolds.get(home)).addOccupant(person);
                }else{
                    houses.add(new Household(home));
                    houses.get(houses.size() -1).addOccupant(person);
                    houseHolds.put(home, houses.size()-1);
                }
            }
        }
        //Go through our arraylist of houses, make sure we sort them properly then call the output.
        for(Household place : houses){
            place.sortOccupants();
            place.checkOccupants();
        }
    }
}
