package pizzaorderingsystemnetbeans;

import java.awt.*;
/**
 * Class to represent a single pizza.
 * @author UP777815
 */
public class Pizza 
{
    private String crustTypes[] = {"Deep Pan", "Thin Crust","Stuffed Crust"};
    private double crustCosts[] = {0.11,0.08,0.14};
    private double baseAreas[] = {(Math.PI * Math.pow(5,2)), (Math.PI*Math.pow(6, 2)), (Math.PI*Math.pow(7, 2))};
    private String sizes[] = {"Small", "Medium", "Large"};
    private String sauces[] = {"Tomato", "BBQ"};
    private Canvas canvas;
    private double topLeftX;
    private double topLeftY;
    private int size, crust, sauce, pizzaNumber;
    /**
     * Constructor for pizza.
     * @param pizzaNum the number of the current pizza in the order
     * @param win the window to draw the pizza on
     * @param startX the top-left x coordinate for the section of screen to draw pizza on
     * @param startY the top-left y coordinate for the section of screen to draw pizza on
     * @param pizzaSize the size of the pizza
     * @param crustType the type of crust the pizza has
     * @param sauceType the sauce on the Pizza
     */
    public Pizza(int pizzaNum, Canvas win, double startX, double startY, int pizzaSize, int crustType, int sauceType)
    {        
        canvas = win;
        topLeftX = startX;
        topLeftY = startY;
        size = pizzaSize;
        crust = crustType;
        sauce = sauceType;
        pizzaNumber = pizzaNum;
    }   
    /**
     * Method to display the pizza information on the screen.
     */
    public void displayPizza()
    {
        drawPizza();
        drawTopLine();
        drawBottomLine();
    }    
    /**
     * Method to display the pizza on the screen.
     */
    void drawPizza()
    {
        canvas.setForegroundColor(Color.YELLOW);
        canvas.fillCircle(topLeftX + 150, topLeftY + 150, 200);
        if(sauce == 2){
            canvas.setForegroundColor(Color.ORANGE);
        }else{
            canvas.setForegroundColor(Color.RED);
        }
        canvas.fillCircle(topLeftX + 150, topLeftY + 150, 175);
        canvas.setForegroundColor(Color.WHITE);
        canvas.fillCircle(topLeftX + 150, topLeftY + 150, 160);
    }    
    /**
     * Method to write the information shown in the bottom line of the 
     * individual pizza on the screen. 
     * This method will display the pizza number and size at the top of the 
     * screen
     */
    private void drawTopLine()
    {
        String topLine = "Pizza " + pizzaNumber + " ("+ sizes[size-1] +")";               
        double stringX = topLeftX+10;
        double stringY = topLeftY + 25;    
        canvas.setForegroundColor(Color.BLACK);
        canvas.setFontSize(15);
        canvas.drawString(topLine, stringX, stringY);
    }  
    /**
     * Method to write the information shown in the bottom line of the 
     * individual pizza on the screen.  
     * This method will display the type of crust and sauce ordered
     */
    private void drawBottomLine()
    {
        String bottomLine = "Crust: " + (crustTypes[crust-1] + "; " + sauces[sauce-1] + " sauce" );          
        double stringX = topLeftX+10;
        double stringY = topLeftY + 290;
        canvas.setForegroundColor(Color.BLACK);
        canvas.setFontSize(15);
        canvas.drawString(bottomLine, stringX, stringY);
    }  
    /**
     * Method that calculates the cost of an individual pizza.
     * (Without Toppings)
     * @return returns the calculated price
     */
    protected double calculateCostOfPizza(){
        double price = 0 ;
        price =  baseAreas[size-1] * crustCosts[crust-1] ;
        if(sauce == 2){
            price += 0.50;
        }
        return price;
    }
    /**
     * Method to return the number corresponding to a pizza
     * @return 
     */
    public int getPizzaNumber(){
        return pizzaNumber;
    }
    /**
     * Method to return the start X coordinate of a pizza
     * @return 
     */
    public double getXCoord(){
        return topLeftX;
    }
    /**
     * Method to return the start Y coordinate of a pizza
     * @return 
     */
    public double getYCoord(){
        return topLeftY;
    }
}
