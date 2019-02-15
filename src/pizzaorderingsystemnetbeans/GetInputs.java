/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorderingsystemnetbeans;
/**
 *Class that handles the users inputs and sends them to the validator class.
 * @author samuelbartlett
 */
public class GetInputs {
    private int userInput;                           //Set up arrays containig all of the messages to display, 
    private String inputMessages[] ={                //the corresponding input promtps
        "Please select a size from the following:",  //and the ammount of options for each choice (used for CheckInputs)
        "What kind of crust would you like?",
        "Which sauce would you like?",
        "How many toppings would you like?",
        "Select topping one: ",
        "Select Topping two:",
        "Would you like to edit or remove any pizzas?",
        "would you like to edit or delete this pizza?"
    };   
    private String SelectionMessages[] = {
        "1)Small(10'); 2)Medium(12'); 3)Large(14'): ",
        "1)Deep Pan ; 2)Thin Crust ; 3)Stuffed Crust: ",
        "1)Tomato; 2)BBQ: ",
        "1)One Topping; 2)Two Toppings; 3)No Toppings: ",
        "1)Pepperoni; 2)Jalepenos: ",
        "1)Pepperoni; 2)Jalepenos: ",
        "1)Yes; 2)No: ",
        "1)Edit; 2)Delete: "
        }; 
    private int inputLengths[] = {3, 3, 2, 3, 2, 2, 2, 2};
    /**
     * Blank constructor.
     */
    public GetInputs(){
    }
    /**
     * Method to get the user inputs with meaningful prompts
     * @param input The number of the input to be referenced from the arrays
     * @param keyboard the keyboard input system to use for user inputs
     * @return returns the users input
     */
    public int getUserInputs(int input, KeyboardInput keyboard){
        do{                                                                         //Loop until there is a valid input
            System.out.println(inputMessages[input]);
            System.out.println(SelectionMessages[input]);
            userInput = keyboard.getInputInteger();
        }while(CheckInputs.validateInputs(userInput, inputLengths[input])==false);
        return userInput;
    }    
    /**
     * Method to get the number for the pizza the user would like to edit
     * @param numPizzas the number of pizzas in the array list
     * @param keyboard the keyboard input class to use for the users input
     * @return returns the numerical value for the pizza to be edited
     */
    public int getPizzaToEdit(int numPizzas, KeyboardInput keyboard){
        int pizzaToEdit = 0;                                                        //set a defeault value (code does not compile otherwise)
        do{
            System.out.println("Which Pizza would you like to edit?");              //Specialist input function for editing pizzas - dependant on size of array list
            System.out.print("Make your selection by entering the number next to the pizza: ");
            pizzaToEdit = keyboard.getInputInteger();
        }while(CheckInputs.validateInputs(userInput, numPizzas) == false);      
        return pizzaToEdit;
    }
}
