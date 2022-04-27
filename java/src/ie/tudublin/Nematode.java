package ie.tudublin;

import processing.data.*;

public class Nematode {

    // Constructor method
    public Nematode(String name, int length, int limbs, Gender gender)
    {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
    }

    public Nematode (TableRow tr) {
        this(
            tr.getString("name"), 
            tr.getInt("length"),
            tr.getInt("limbs"),
            Gender.valueOf(tr.getString("gender"))
            );
    }

    // Initialize variables
    private String name;
    private int length;
    private int limbs;
    private Gender gender;

    public enum Gender {
        m, f, h, n
    }


    // Get the name
    public String getName() {
        return name;
    }

    // Set the name
    public void setName(String name) {
        this.name = name;
    }

    // Get the length
    public int getLength() {
        return length;
    }

    // Set the length 
    public void setLength(int length) {
        this.length = length;
    }

    // Get the limbs
    public int getLimbs() {
        return limbs;
    }

    // Set the limbs 
    public void setLimbs(int limbs) {
        this.limbs = limbs;
    }

    // Get the gender
    public Gender getGender() {
        return gender;
    }

    // Set the gender 
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // Return toString method
    public String toString(){
        return "Nematode " + name + ", length: " + length + ", limbs: " + limbs + ", gender: " + gender ;
    }
    
}