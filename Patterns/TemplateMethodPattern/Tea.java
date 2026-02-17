package TemplateMethodPattern;

public class Tea extends CaffineBeverage {

    public void brew() {
        System.out.println("Adding tea leaf to boiling water ...");
    }

    public void addCondiments() {
        System.out.println("Adding lemon ...");
    }
    
}
