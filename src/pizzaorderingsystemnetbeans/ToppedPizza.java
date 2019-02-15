package pizzaorderingsystemnetbeans;

import java.awt.Color;

/**
 *Sub class of Pizza used to add toppings.
 * @author UP777815
 */
public class ToppedPizza extends Pizza{
    private Canvas canvas;
    private double topX, topY;
    private int numToppings, toppingOne, toppingTwo;
    public ToppedPizza(int pizzaNum, Canvas win, double startX, double startY, int size, int crust, int sauce, int toppings, int topOne, int topTwo){
        super(pizzaNum, win, startX, startY, size, crust, sauce);
        topX = startX;
        topY = startY;
        numToppings = toppings;
        toppingOne = topOne;
        toppingTwo = topTwo;
        canvas = win;
    }
    /**
     * Draw pizza inherited from Pizza.
     * Overriding adds the functionality to draw the toppings
     */
    @Override
    protected void drawPizza(){
        super.drawPizza();
        drawToppings(numToppings);
    }
    /**
     * Method to draw the toppings on the pizza
     * @param numberToppings the numerical value for the number of toppings (entered by user)
     */
    private void drawToppings(int numberToppings){
        double centerX, centerY;
        centerX = topX +110;
        centerY = topY + 110;
        if(numberToppings == 1){
            for(int i=1;i<=9;i++){
                if(i%2 != 0){
                    if(toppingOne == 1){
                        drawPepperoni(centerX, centerY);
                    }else{
                        drawJalepeno(centerX, centerY);
                    }
                }
                if (centerX == (topX + 190)){
                        centerX = topX + 110;
                        centerY += 40;
                    }else{
                        centerX += 40;
                }
            }
        }else if(numToppings==2){
            for(int i=1;i<=9;i++){
                if(i%2 != 0){
                    if(toppingOne == 1){
                        drawPepperoni(centerX, centerY);
                    }else{
                        drawJalepeno(centerX, centerY);
                    }
                }else{
                    if(toppingTwo == 1){
                        drawPepperoni(centerX, centerY);
                    }else{
                        drawJalepeno(centerX, centerY);
                    }
                }
                if (centerX == (topX + 190)){
                        centerX = topX + 110;
                        centerY += 40;
                    }else{
                        centerX += 40;
                }
            }
        }
    }
    /**
     * Method to draw the pepperoni topping.
     * @param centerX the center x coordinate of the pizza
     * @param centerY the center y coordinate of the pizza
     */
    private void drawPepperoni(double centerX, double centerY){
        canvas.setForegroundColor(Color.RED);
        canvas.fillCircle(centerX, centerY, 35);
        centerX -= 8;
        double xLimit = centerX + (8*2);
        centerY -= 8;
        for(int i=0;i<9;i++){
            if(i%2==0){
                canvas.setForegroundColor(Color.PINK);
            }else{
                canvas.setForegroundColor(Color.WHITE);
            }
            canvas.fillCircle(centerX, centerY, 5);
            if(centerX == xLimit){
                centerX -= 8*2;
                centerY += 8;
            }else{
                centerX += 8;
            }
        }
    }
    /**
     * Method to draw the Jalepeno topping.
     * @param centerX center x coordinate of the pizza
     * @param centerY center y coordinate of the pizza
     */
    private void drawJalepeno(double centerX, double centerY){
        double xLimit = centerX + 8;
        canvas.setForegroundColor(Color.GREEN);
        canvas.fillCircle(centerX, centerY, 35);
        canvas.setForegroundColor(Color.WHITE);
        canvas.fillCircle(centerX, centerY, 25);
        canvas.setForegroundColor(Color.BLACK);
        centerX -= 8;
        centerY -= 8;
        for(int i=1;i<10;i++){
            if(i%2==0||i==5){
                canvas.fillCircle(centerX, centerY, 8);
            }
            if(centerX==xLimit){
                centerX-=16;
                centerY+=8;
            }else{
                centerX+=8;
            }
        }
    }
    /**
     * Metho inherited from Pizza to calculate cost.
     * Adds additional code to account for toppings
     * @return 
     */
    protected double calculateCostOfPizza(){
        double price = super.calculateCostOfPizza();
        //As both toppings relating to my up number are the same price, i simplified the logic. 
        if(numToppings == 1){
            price += (0.04*5);
        }else if(numToppings == 2){
            price += (0.04*9);
        }
        return price;
    }
}
