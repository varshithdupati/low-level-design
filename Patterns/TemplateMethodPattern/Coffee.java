package TemplateMethodPattern;

public class Coffee extends CaffineBeverage {

    public void brew() {
        System.out.println("Adding coffee beans to boiling water ...");
    }

    public void addCondiments() {
        // can add sugar
        // System.out.println("Adding sugar ...");
    }
    
}
