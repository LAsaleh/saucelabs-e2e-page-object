package com.academy.techcenture.saucelabs.pages;

import com.github.javafaker.Faker;

public class JavaFaker {


    public  String randomFirstName (){

      return new Faker().name().firstName();

    }

    public String randomLastName(){
        return new Faker().name().lastName();
    }

    public String randomPostalCode(){
        return new Faker().address().zipCode().substring(0,5);
    }

}


//26. Fill out the form with random First name , Last name and zip code (use faker dependency)
//        27. Verify Continue button is enabled and click it