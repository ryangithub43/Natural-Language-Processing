import java.util.ArrayList; 
import java.util.Scanner; 


  public class UserGiver {


    /*
     * ArrayLists that contain the adjectives and nouns.
     */
    
    private ArrayList<String> adjectives;
    private ArrayList<String> nouns;

    public UserGiver(ArrayList<String> adjectives, ArrayList<String> nouns) {
      
      this.adjectives = adjectives;
      this.nouns = nouns; 
      
    }
    
    public UserGiver() {
      
      adjectives = createUser("adjectives.txt");
      nouns = createUser("nouns.txt"); 
      
    }

    // Accesses the TextProcessor class
    public ArrayList<String> createUser(String fileName){
      
      TextProcessor tp = new TextProcessor(fileName);
      return tp.textToWords(); 
      
    }

    // Methods for UserGiver


 
    /* 
     * What's actually printed in the console. 
     */
    
    public void prompt() {
      Scanner input = new Scanner(System.in);


      // Clears the screen, only showing the intial text.
      
      System.out.println("\n");
      System.out.println("\n");
      System.out.println("\n");
      System.out.println("\n");
      System.out.println("\n");
      System.out.println("\n");
      
      // Initial text
      System.out.println("======================================================================");
      System.out.println("Welcome to the User Maker! Do you want to get started? (Type anything)");
      String getStarted = input.nextLine(); 
      System.out.println("\n");
      
      // First input 
      System.out.println("What's going to be the letter of your choice?");
      String userLetter = input.nextLine();
      System.out.println("\n"); 


      // First output
      String randAdj = chooseAdjective(userLetter);
      System.out.println("You chose " + userLetter + ". Here is a random adjective:");
      System.out.println(randAdj);
      System.out.println("\n");

      // Second input
      System.out.println("What letter again?");
      String userLetter1 = input.nextLine(); 
      System.out.println("\n"); 

      // Second output
      String randNoun = chooseNoun(userLetter1);
      System.out.println("You chose " + userLetter1 + ". Here is a random noun:");
      System.out.println(randNoun); 
      System.out.println("\n");


      // Final outputs
      System.out.println("Are you ready to see your username? (Type anything)");
      String finalStep = input.nextLine();
     

        
      int randNumber = (int)(Math.random() * 999); 
      System.out.println("\n");
      System.out.println("Here is your username together: " + randAdj + randNoun + randNumber); 

      String finalUser = randAdj + randNoun + randNumber; 

      System.out.println("\n"); 
      System.out.println("Thank you for signing in " + finalUser + "! :D ");
      System.out.println("======================================================================");
      


      input.close();
    }


     /**
     * Chooses a random adjective based on the first letter after inputting a letter. 
     * 
     * Precondition: A letter must be provided in order to proceed. 
     * Postcondition: The values inputted must be a letter and lowercase. 
     * 
     * @param letter 
     * @return Random adjective 
     */
    
    public String chooseAdjective(String letter) {

      ArrayList<String> possibleWords = new ArrayList<String>(); 
        
      for (int i = 0; i < adjectives.size(); i++) {
        String adj = adjectives.get(i); 
        
        if (adj.substring(0, 1).equals(letter)) {
          possibleWords.add(adj);
        }
      }

      int random = (int)(Math.random() * possibleWords.size());
      return possibleWords.get(random); 
    }


    /**
     * Chooses a random noun based on the first letter after inputting a letter. 
     * 
     * Precondition: A letter must be provided in order to proceed. 
     * Postcondition: The values inputted must be a letter and lowercase. 
     * 
     * @param letter 
     * @return Random noun 
     */
      

    public String chooseNoun(String letter) {

      ArrayList<String> possibleNouns = new ArrayList<String>();

      for(int i = 0; i < nouns.size(); i++) {
        String noun = nouns.get(i);

        if(noun.substring(0, 1).equals(letter)) {
          possibleNouns.add(noun);
        }
      }

      int random1 = (int)(Math.random() * possibleNouns.size());
      return possibleNouns.get(random1); 
    }

 
  
  }
