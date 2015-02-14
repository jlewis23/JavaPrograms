public class NYStylePizza extends Pizza
{

    public NYStylePizza()
    {
        super("NY Style Sauce and Cheese Pizza", "Thin Crust Dough",
                "Marinara Sauce");
        addTopping("Extra Cheese");
    }

    public void box()
    {
        System.out.println("Place in white box with Red Letters.");
    }

    @Override
    public String toString()
    {
        return "NYStylePizza [name=" + name + ", dough=" + dough + ", sauce="
                + sauce + ", toppings=" + toppings + "]";
    }

}
