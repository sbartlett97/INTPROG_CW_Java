package pizzaorderingsystemnetbeans;
/**
 *Class used to handle the validation of a users numerical input.
 * Ensures a users input is greater than 0 but not greater than the highest option they could have chosen
 * @author UP777815
 */
public class CheckInputs {
    /**
     * Method that checks whether the users input is within specified bounds and is valid
     * @param userInput the users input
     * @param higestOption the highest value they could have chosen
     * @return returns a true or false based off of validation tests
     */
    public static boolean validateInputs(int userInput, int higestOption){
        if (userInput == (int)userInput){                                   //check that the user has entered a number
            if(userInput < 0 || userInput > higestOption){                  //check that the users input is valid for the options they were given
                System.out.println("That is not a valid option.");          //Error message
                return false;
            }else{
                System.out.println("Thank you.\n");                         //Confirmation Message
                return true;
            }
        }else{
            return false;
        }       
    }  
}
