package com.siwoo.classes;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private final int BASE_PRICE = 10, SAUCE_PRICE = 2;
    private final String BASIC_SAUCE = "tomato sauce";
    private List<Topping> toppings = new ArrayList<>();
    private String sauce = BASIC_SAUCE;
    
    public void addTopping(Topping topping) {
        if (topping == null) throw new IllegalArgumentException();
        for (Topping t: toppings) {
            if (t.getClass() == topping.getClass()) {
                t.setAmount(t.amount() + topping.amount());
                return;
            }
        }
        this.toppings.add(topping);
    }
    
    public void addTopping(Potato potato) {
        this.addTopping((Topping) potato);
    }
    
    public void addTopping(Sausage sausage) {
        this.addTopping((Topping) sausage);
    }
    
    public void addTopping(Olives olives) {
        this.addTopping((Topping) olives);
    }
    
    public void addTopping(Topping topping, String sauce) {
        this.addTopping(topping);
        this.setSauce(sauce);
    }

    private void setSauce(String sauce) {
        if (sauce == null) throw new IllegalArgumentException();
        this.sauce = sauce;
    }

    public int price() {
        int price = BASE_PRICE + (BASIC_SAUCE.equals(this.sauce)? 0: 2);
        for (Topping t: toppings)
            price += t.totalPrice();
        return price;
    }
    
    public String information() {
        StringBuilder info = new StringBuilder("Your Pizza: \n");
        info.append("sauce: ").append(sauce).append("\n")
                .append("toppings: ").append("\n");
        for (Topping topping: toppings) {
            info.append(topping.name()).append(", ").append(topping.amount()).append("\n");
        }
        info.append("[Total price: ").append(this.price()).append(", ").append("Enjoy!]");
        return info.toString();
    }

    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        pizza.addTopping(new BlackOlives(2));
            //2 * 2 = 4
        pizza.addTopping(new Sausage(3));
            // 5 * 3 = 15
        pizza.addTopping(new Potato(1));
            // 1 * 1 = 1
            // base = 10
        System.out.println(pizza.price());
        System.out.println();
        System.out.println(pizza.information());
        pizza.addTopping(new Potato(3), "sambal");
        System.out.println(pizza.price());
        System.out.println();
        System.out.println(pizza.information());
        System.out.println();
        
        pizza.addTopping(new GreenOlives(3));
        System.out.println(pizza.price());
        System.out.println();
        System.out.println(pizza.information());
        System.out.println();
    }
}


interface Topping {
    int amount();
    void setAmount(int amount);
    int unitPrice();
    
    default int totalPrice() {
        return amount() * unitPrice();
    }
    
    String name();
}

class Potato implements Topping {
    private int amount;

    public Potato(int amount) {
        this.amount = amount;
    }

    @Override
    public int amount() {
        return this.amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int unitPrice() {
        return 1;
    }

    @Override
    public String name() {
        return "potato";
    }
}

class Sausage implements Topping {
    private int amount;
    
    public Sausage(int amount) {
        this.amount = amount;
    }

    @Override
    public int amount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int unitPrice() {
        return 5;
    }

    @Override
    public String name() {
        return "sausage";
    }
}

abstract class Olives implements Topping {
    private int amount;

    public Olives(int amount) {
        this.amount = amount;
    }

    @Override
    public int amount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }
}

class BlackOlives extends Olives {

    public BlackOlives(int amount) {
        super(amount);
    }

    @Override
    public int unitPrice() {
        return 2;
    }

    @Override
    public String name() {
        return "black olives";
    }
}


class GreenOlives extends Olives {

    public GreenOlives(int amount) {
        super(amount);
    }

    @Override
    public int unitPrice() {
        return 3;
    }

    @Override
    public String name() {
        return "green olives";
    }
}