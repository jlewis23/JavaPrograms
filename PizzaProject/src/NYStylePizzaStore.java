
public class NYStylePizzaStore extends PizzaStore
{

    @Override
    Pizza createPizza()
    {
        NYStylePizza myPizza = new NYStylePizza();
        return myPizza;
    }

}
