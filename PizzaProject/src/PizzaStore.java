import java.util.Scanner;

public abstract class PizzaStore
{
    abstract Pizza createPizza();

    public Pizza orderPizza()
    {
        Pizza pizza = createPizza();

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    public Pizza orderPizzaWithToppings(Scanner keyboard)
    {
        Pizza pizza = createPizza();
        System.out.println("How many toppings do you want to add? ");
        int number = keyboard.nextInt();
        for (int i = 0; i < number; i++)
        {
            System.out.println("What topping would you like to add?");
            String top = keyboard.next();
            pizza.addTopping(top);
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
