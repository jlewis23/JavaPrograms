import java.util.Scanner;

/**
 * 
 */

/**
 * @author nnapier
 *
 */
public class PizzaStoreTester
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        PizzaStore store = new NYStylePizzaStore();
        
        if (args != null && args.length >= 1)
        {
            // Use command line arguments to determine which kind of
            // Store to create
            if (args[0].equalsIgnoreCase("chicago"))
            {
                store = new ChicagoStylePizzaStore();
            }
        }
        
        Scanner keyboard = new Scanner(System.in);
        
        Pizza plainPizza = store.orderPizza();
        System.out.println("-----> Plain pizza created: \n" + plainPizza);
        
        Pizza toppingPizza = store.orderPizzaWithToppings(keyboard);
        System.out.println("-----> Pizza with Toppings created: \n" + toppingPizza);
        

    }

}
