import java.util.ArrayList;

public abstract class Pizza
{
    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings;

    public Pizza()
    {
        name = "Plain";
        dough = "Regular Dough";
        sauce = "Red";
        toppings = new ArrayList<String>();
    }

    Pizza(String name, String dough, String sauce)
    {
        this.name = name;
        this.dough = dough;
        this.sauce = sauce;
        this.toppings = new ArrayList<String>();
    }

    @Override
    public String toString()
    {
        return "Pizza [name=" + name + ", dough=" + dough + ", sauce=" + sauce
                + ", toppings=" + toppings + "]";
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDough()
    {
        return dough;
    }

    public void setDough(String dough)
    {
        this.dough = dough;
    }

    public String getSauce()
    {
        return sauce;
    }

    public void setSauce(String sauce)
    {
        this.sauce = sauce;
    }

    public ArrayList<String> getToppings()
    {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings)
    {
        this.toppings = toppings;
    }

    public void addTopping(String topping)
    {
        toppings.add(topping);
    }

    public void prepare()
    {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...." + dough);
        System.out.println("Adding sauce...." + sauce);
        System.out.println("Adding toppings: ");

        for (String topping : toppings)
        {
            System.out.println("-- " + topping);
        }
    }

    public void bake()
    {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut()
    {
        System.out.println("Cutting the pizza into diagonal slices.");
    }

    public void box()
    {
        System.out.println("Place in official box");
    }
}
