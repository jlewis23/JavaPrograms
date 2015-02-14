public class ChicagoStylePizzaStore extends PizzaStore
{
    @Override
    Pizza createPizza()
    {
        ChicagoStylePizza myPizza = new ChicagoStylePizza();
        return myPizza;
    }
}
