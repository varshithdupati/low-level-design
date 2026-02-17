package TemplateMethodPattern;

public class BeveragePreparationDemo {
    
    public static void main(String[] args) {
        
        CaffineBeverage tea = new Tea();
        tea.prepareBeverage();
        System.out.println("Tea is served!");

        CaffineBeverage coffee = new Coffee();
        coffee.prepareBeverage();
        System.out.println("Coffee is served!");
        
    }

}
