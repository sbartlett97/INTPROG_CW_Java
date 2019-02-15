package pizzaorderingsystemnetbeans;

/**
 * Class to start the running of the Pizza Ordering System.  You should not 
 * need to change this class
 * @author Claire Ancient
 */
public class PizzaMain 
{

    public static void main(String[] args) 
    {
        OrderingSystem orders = new OrderingSystem();
        orders.drawOrderScreen();
        orders.startOrdering();
    }
    
}
