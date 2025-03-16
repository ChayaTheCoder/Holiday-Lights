/**
 * The HolidayLights class demonstrates the functionality of the LightChain 
 * class by performing a series of operations on a linked list of holiday lights.
 * It creates a light chain, inserts a new light, removes an existing light, 
 * and replaces a light with another color.
 * 
 * Tasks performed in this program:
 * - Create a LightChain with initial colors.  
 * - Traverse and display the LightChain.  
 * - Insert a new light after a specified color.  
 * - Remove a light of a specific color.  
 * - Replace all occurrences of a color with another color.  
 * 
 * @Author: Michaya Mohamed
 * @Version: 3-16-25
 */
public class HolidayLights {
    public static void main(String argv[]) {
        // Task 1: Creating the Light Chains and link them.
        LightChain stringOfLights = new LightChain();

        // Task 2 Traversing the Light Chains.
        System.out.println("After the task 1 (Creating the Light Chains), we have");
        stringOfLights.traverseLightChain();

        // Task 3: Inserting a New Light.
        stringOfLights.insertAfter(LightChain.ORANGE, LightChain.BLUE);

        System.out.println("After the Task 3 (Inserting a Orange after Blue), we have");
        stringOfLights.traverseLightChain();

        // Task 4: Removing a Light.
        stringOfLights.remove(LightChain.GREEN);

        System.out.println("After the task 4 (Removing a green), we have");
        stringOfLights.traverseLightChain();

        // Task 5: Replacing a Light.
        stringOfLights.replaceAll(LightChain.ORANGE, LightChain.PURPLE);

        System.out.println("After the task 5 (Replacing all orange with purple), we have");
        stringOfLights.traverseLightChain();
    }
}

