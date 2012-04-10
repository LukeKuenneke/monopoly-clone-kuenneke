/****************************
 *@(#) Monopoly.java
 *@author: Lucas Kuenneke
 *@version 0.2 (Turn in #2)
 *@date 04/09/2012
 *Class: CEG463-01
 *Professor: Reisner
 */
package Monopoly;
import java.util.Scanner;

/**
 * 
 * @author LK
 */
public class Monopoly extends Object
{
    private Square board[];    //Square elements that comprise board
    private Player players[];  //Array o players	
    private int	   numPlayers; //Number of players
    
    Scanner keyboard = new Scanner(System.in);

    /**
     * Creates all the squares on the board.
     */
    private void setupBoard()
    {
	int rents[][] = {
            
	    //Purple Squares
            {  2,  10,  30,   90,   160,  250 }, //Mediterranean Avenue
	    {  4,  20,  60,  180,   320,  450 }, //Baltic Avenue
	    
            //Light Blue Squares
            {  6,  30,  90,  270,   400,  550 }, //Oriental Avenue
            {  6,  30,  90,  270,   400,  550 }, //Vermont Avenue
            {  8,  40, 100,  300,   450,  600 }, //Connecticut Avenue
            
            //Pink Squares
            { 10,  50, 150,  450,   625,  750 }, //St. Charles Place
            { 10,  50, 150,  450,   625,  750 }, //States Avenue
            { 12,  60, 180,  500,   700,  900 }, //Virgina Avenue
            
            //Orange Squares
            { 14, 70,  200,  550,   750,  950 }, //St. James Place
            { 14, 70,  200,  550,   750,  950 }, //Tennessee Avenue
            { 16, 80,  220,  600,   800, 1000 }, //New York Avenue
            
            //Red Squares
            { 18, 90,  250,  700,   875, 1050 }, //Kentucky Avenue
            { 18, 90,  250,  700,   875, 1050 }, //Indiana Avenue 
            { 20, 100, 300,  750,   925, 1100 }, //Illinois Avenue
            
            //Yellow Squares
            { 22, 110, 330,  800,   975, 1150 }, //Atlantic Avenue
            { 22, 110, 330,  800,   975, 1150 }, //Ventnor Avenue
            { 24, 120, 360,  850,  1025, 1200 }, //Marvin Gardens
            
            //Green Squares
            { 26, 130, 390,  900,  1100, 1275 }, //Pacific Avenue
            { 26, 130, 390,  900,  1100, 1275 }, //North Carolina Avenue
            { 28, 150, 450, 1000,  1200, 1400 }, //Pennsylvania Avenue
            
            //Blue Squares
            { 35, 175, 500, 1100,  1300, 1500 }, //Park Place
            { 50, 200, 600, 1400,  1700, 2000 }, //Boardwalk 
	};

	board     = new Square[40];
        
        board[0]   = new Action("Go");
        board[1]   = new Lot("Mediterranean Avenue", 60, 30, rents[0]);
      //board[2]   = new Action("Community Chest", "Follow instructions on top card");
        board[3]   = new Lot("Baltic Avenue", 60, 30, rents[1]);
      //board[4]   = new Action("Income Tax", "pay 10% or 200$");
      //board[5]   = new RailRoad("Reading RailRoad", 200, 100);
        board[6]   = new Lot("Oriental Avenue", 100, 50, rents[2]);
      //board[7]   = new Action("Chance", "?");
        board[8]   = new Lot("Vermont Avenue", 100, 50, rents[3]);
        board[9]   = new Lot("Connecticut Avenue", 120, 60, rents[4]);
      //board[10]  = new Action("Jail", "Just visiting or in jail"); 
        board[11]  = new Lot("St. Charles Place", 140, 70, rents[5]);
        board[12]  = new Utility("Electric Company", 150, 75, 20);
        board[13]  = new Lot("States Avenue", 140, 70, rents[6]);
        board[14]  = new Lot("Virginia Avenue", 160, 80, rents[7]);
      //board[15]  = new RailRoad("Pennsylvania RailRoad", 200, 100);
        board[16]  = new Lot("St. James Place", 180, 90, rents[8]);
      //board[17]  = new Action("Community Chest", "Follow instructions on top card");
        board[18]  = new Lot("Tennessee Avenue", 180, 90, rents[9]);
        board[19]  = new Lot("New York Avenue", 200, 100, rents[10]);
      //board[20]  = new Action("Free Parking");      
        board[21]  = new Lot("Kentucky Avenue", 220, 110, rents[11]);
      //board[22]  = new Action("Chance", "?");  
        board[23]  = new Lot("Indiana Avenue", 220, 110, rents[12]);
        board[24]  = new Lot("Illinois Avenue", 240, 120, rents[13]);
      //board[25]  = new RailRoad("B & O RailRoad", 200, 100);
        board[26]  = new Lot("Atlantic Avenue", 260, 130, rents[14]);
        board[27]  = new Lot("Ventnor Avenue", 260, 130, rents[15]);
        board[28]  = new Utility("Water Works", 150, 75, 20);
        board[29]  = new Lot("Marvin Gardens", 280, 140, rents[16]);
      //board[30]  = new Action("Go to jail", board[10]);
        board[31]  = new Lot("Pacific Avenue", 300, 150, rents[17]);
        board[32]  = new Lot("North Carolina Avenue", 300, 150, rents[18]);
      //board[33]  = new Action("Community Chest", "Follow instructions on top card");
        board[34]  = new Lot("Pennsylvania Avenue", 320, 160, rents[19]);
      //board[35]  = new RailRoad("Short Line RailRoad", 200, 100);
      //board[36]  = new Action("Chance", "?");
        board[37]  = new Lot("Park Place", 350, 175, rents[20]);
      //board[38]   = new Action("Luxury Tax", "pay 75$");
        board[39]  = new Lot("Boardwalk", 400, 200, rents[21]);
        
    }
    
    /**
     * Creates player instances for the game.
     */
    private void createPlayers()
    {
        System.out.print("How many players (2 to 8): ");
       
        while (numPlayers > 8 || numPlayers < 2)
        {
            numPlayers = keyboard.nextInt();
            if (numPlayers > 8 || numPlayers < 2)
                System.out.print("Please enter a valid number of "
                        + "players (2 to 8): ");
            else
            players = new Player[numPlayers];
        }
        
	for (int x = 0; x < numPlayers; x++)
        {
            String player_name = getPlayerName(numPlayers - (numPlayers - (x + 1)));
            players[x] = new Player(player_name, 1500);
        }
    }
    
    /**
     * 
     * @param current_player
     * @return
     */
    public String getPlayerName(int current_player)
    {
        System.out.print("Please enter the name of Player " 
                + current_player + ": ");
        String player_name = keyboard.next();
        return player_name;
    }

   /**
    *Print out player information
    */
    public void printBoard()
    {
        System.out.println("\nBoard Squares:");
	for (int x = 0; x < 40; x++)
        if (board[x] != null)
        System.out.println(board[x]);
    }
    
   /**
    *Print out player information
    */
    private void printPlayers()
    {
	System.out.println("\nPlayers:");
	for (int x = 0; x < numPlayers; x++)
	    System.out.println(players[x]);
    }
    
    /**
     *Plays the game.
     */
    private void play()
    {
        boolean game_over = false;
        
        printBoard();
        
        while (!game_over)
        {
          printPlayers();                    
          for (int x = 0; x < players.length; x++)
          {
            if (!players[x].jailStatus())
            {
                int die1, die2;
                String user_input;
                
                System.out.println("");
                die1 = players[x].rollDie();
                die2 = players[x].rollDie();
                
                
                if (die1 == die2)
                {
                    System.out.println(players[x].getName() + ", you have "
                        + "rolled a double! " + die1 + " and a " + die2 + "."
                            +" Rolling again..");                     

                    die1 = players[x].rollDie();
                    die2 = players[x].rollDie();
                    
                    players[x].setPosition(die1 + die2);
                }

                System.out.println(players[x].getName() + ", you have "
                        + "rolled a " + die1 + " and a " + die2 + ".");
                players[x].setPosition(die1 + die2);
                
                System.out.println(players[x]);
                
                if (board[players[x].getPosition()].mayBeBought() 
                        && board[players[x].getPosition()] != null)
                {
                 System.out.print("\n" 
                         + board[players[x].getPosition()].toString() + "\n" +
                        players[x].getName() + ", would you like to buy this"
                         + " property (Yes or No): ");
                    
                    user_input = keyboard.next();
                    
             if (user_input.charAt(0) == 78 || user_input.charAt(0) == 110)
             {
                System.out.println(players[x].getName() + 
                       " did not buy " + board[players[x].getPosition()].name);
             } 
             else if (user_input.charAt(0) == 89 || user_input.charAt(0) == 121)
             {
                board[players[x].getPosition()].buyIt(players[x]);
                
                System.out.println(players[x].getName() + " bought " +
                         board[players[x].getPosition()].name);
             }
             }
            }
            }
        }
    }
    
    /**
     *Runs the Monopoly game
     * @param args 
     */
    public static void main(String args[])
    {
	Monopoly game = new Monopoly();
	game.setupBoard();
	game.createPlayers();
	game.play();
    }
}