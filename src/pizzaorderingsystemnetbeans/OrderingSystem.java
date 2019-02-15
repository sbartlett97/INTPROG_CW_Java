package pizzaorderingsystemnetbeans;

import java.awt.*;
import java.util.*;
/**
 * Class to manage the pizza order.
 * @author UP777815
 */
public class OrderingSystem 
{
    private GetInputs inputGetter = new GetInputs();
    private Canvas canvas;
    private KeyboardInput keyboard = new KeyboardInput();
    private ArrayList<Pizza> OrderedPizzas = new ArrayList();
    private String priceString = "Total Price of the Order: £";
    private double price = 0.00;
    /**
     * Constructor for the ordering system
     * .
     */
    public OrderingSystem()
    {
        priceString += Math.floor(price * 100)/100d;
        canvas = new Canvas("Pizza Ordering", 900, 650, Color.WHITE);
    }    
    /**
     * Method to draw the outline of the order screen.
     */
    public void drawOrderScreen()
    {
        canvas.setForegroundColor(Color.BLACK);
        // vertical dividers
        canvas.drawLine(300, 0, 300, 600);
        canvas.drawLine(600, 0, 600, 600);
        
        // halfway divider
        canvas.drawLine(0, 300, 900, 300);
        
        // total price line
        canvas.drawLine(0, 600, 900, 600);
        canvas.setFontSize(25);
        canvas.drawString(priceString, 10, 640);
    }    
    /**
     * Method to manage the ordering of the pizzas.
     */
    public void startOrdering()
    {
        double startX =0;
        double startY = 0;
        int numPizzas, pizzaSize,pizzaCrust, pizzaSauce, numToppings, toppingOne, toppingTwo = 0;
  
        System.out.println("Welcome to the Pizza Ordering System.");
        System.out.println("Please make your selections using the numbers displayed nex to the options.");
        
        
        int continueOrdering =1;
        int i=1;
        do{
            System.out.println("\nPizza " + i + "\n\n");
            OrderedPizzas.add(orderPizza(i, startX, startY));
            price += OrderedPizzas.get(i-1).calculateCostOfPizza();
            OrderedPizzas.get(i-1).displayPizza();
            updateOrderString();
            if (startX == 600){
                startX = 0;
                startY = 300;
            }else{
                startX += 300;
            }
            System.out.println("Do you want to add another pizza?");
            System.out.print("1)Yes; 2)No : ");
            continueOrdering = keyboard.getInputInteger();
            i++;
        }while(continueOrdering == 1&&i !=6);
        extendedFunctionality();
    }   
    /**
     * Method to draw the ordered pizzas to the screen.
     */
    private void drawPizzas(){
        price = 0;
        Iterator<Pizza> it = OrderedPizzas.iterator();
        Pizza currentPizza;
        while(it.hasNext()){
             currentPizza = it.next();
             currentPizza.displayPizza();
             price += currentPizza.calculateCostOfPizza();
             updateOrderString();
        }
    }
    /**
     * Method that updates the price shown to the user.
     */
    private void updateOrderString(){
        canvas.setFontSize(25);
        canvas.eraseString(priceString, 10, 640);
        priceString = "Total Price of the Order: £"+ Math.floor(price * 100)/100d;
        canvas.drawString(priceString , 10, 640);
    }
     /**
      * Method that ads the ability to edit a specific pizzas detail.
      */
    private void extendedFunctionality(){
        int pizzaToEdit;
        System.out.println("\nThank you for ordering! Please review your selections.");
            int makeChanges = inputGetter.getUserInputs(6, keyboard);
            int editOrDelete;
            if(makeChanges == 1){
                pizzaToEdit = inputGetter.getPizzaToEdit(OrderedPizzas.size(), keyboard);
                editOrDelete = inputGetter.getUserInputs(7, keyboard);
                if(editOrDelete == 1){
                    editPizza(pizzaToEdit);
                    extendedFunctionality();
                }else{
                    OrderedPizzas.remove(pizzaToEdit-1);
                    updateCanvas();
                    extendedFunctionality();
                }
                
            }
    }
    /**
     * Method that allows the user to edit a specific pizza in their order. 
     * @param pizzaToEdit the number of the pizza to edit from the screen
     */
    private void editPizza(int pizzaToEdit){
        pizzaToEdit -= 1;
        Pizza pizza = OrderedPizzas.get(pizzaToEdit);
        OrderedPizzas.remove(pizzaToEdit);
        int pizzaNum = pizza.getPizzaNumber();
        double startX = pizza.getXCoord();
        double startY = pizza.getYCoord();
        OrderedPizzas.add(pizzaToEdit, orderPizza(pizzaNum, startX, startY));
        updateCanvas();
    }
    /**
     * Method that creates a new pizza to add the the array list of ordered pizzas.
     * @param pizzaNumber the index number of the pizza - which one in the list it is
     * @param startX the startX coordinate for the pizza
     * @param startY the startY coordinate for the pizza
     * @return Returns a new pizza to be added to the OrderedPizzas array list. 
     */
    private Pizza orderPizza(int pizzaNumber,double startX, double startY){
        int pizzaSize, pizzaCrust, pizzaSauce, numToppings, toppingOne, toppingTwo = 0;
        Pizza pizza;
        pizzaSize = inputGetter.getUserInputs(0, keyboard);
        pizzaCrust = inputGetter.getUserInputs(1, keyboard);
        pizzaSauce = inputGetter.getUserInputs(2, keyboard);
        numToppings = inputGetter.getUserInputs(3, keyboard);
        if (numToppings == 1){
            toppingOne = inputGetter.getUserInputs(4, keyboard);
        }else if(numToppings == 2){
            toppingOne = inputGetter.getUserInputs(4, keyboard);
            toppingTwo = inputGetter.getUserInputs(5, keyboard);
        }else{
            toppingOne = 0;
            toppingTwo = 0;
        }
        return pizza = new ToppedPizza(pizzaNumber, canvas, startX, startY, pizzaSize, pizzaCrust, pizzaSauce, numToppings, toppingOne, toppingTwo);
    }
     /**
      * Method that updates the canvas after a pizza has been edited. 
      */
    private void updateCanvas(){
    canvas.erase();
    drawOrderScreen();
    drawPizzas();   
    }
}
