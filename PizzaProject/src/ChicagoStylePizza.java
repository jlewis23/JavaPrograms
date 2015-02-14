public class ChicagoStylePizza extends Pizza
{
    public ChicagoStylePizza()
    {
        super("Chicago Style Deep Dish Cheese Pizza", "Extra Thick Crustdough",
                "Plum Tomatoe Sauce");
        addTopping("Shredded Mozzarella Cheese");
    }

    public void cut()
    {
        System.out.println("Cut pizza into SQUARES.");
    }

    public void bake()
    {
        System.out.println("Bake for 50 minutes at 375.");
    }

    @Override
    public String toString()
    {
        return "ChicagoStylePizza [name=" + name + ", dough=" + dough
                + ", sauce=" + sauce + ", toppings=" + toppings + "]";
    }

}
