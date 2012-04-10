/****************************
 *@(#) Player.java
 *@author: Lucas Kuenneke
 *@version 0.2 (Turn in #2)
 *@date 04/09/2012
 *Class: CEG463-01
 *Professor: Reisner
 */
package Monopoly;
public class Player extends Object
{
    private String name;           //Name of player
    private int account;           //Money the player has
    private int position;	   //Players position on board
    private boolean jail;          //Players jail status flag
    private Property[] properties; //Properties owned by player
    
    /**
     *Creates the Monopoly players
     *@param name player name
     *@param money starting balance
     */
    public Player(String name, int money)
    {
	this.name = name;
	this.account = money;

        //Player is put at the Go square
	this.position = 0;

        //Array will hold properties the player owns
	this.properties = new Property[28];
        
        //Player is not put in jail initally
        this.jail = false;
    }

    /**
     *Deducts money from a player
     *@param money amount to be deducted from player
     */
    public void deduct(int money)
    {
	account -= money;
    }

  /**
    *Rolls the dice for the player
    *This method will be moved to Monopoly.java if appropriate.
    *@return die result
    */
    public int rollDie()
    {
        return (int)(Math.random()*6) + 1;
    }
        
  /**
    *Is the player in jail?
    *@return true if the player is in jail
    */
    public boolean jailStatus()
    {
        return this.jail;
    }
    
  /**
    *The players name
    *@return the players name
    */    
    public String getName()
    {
        return this.name;
    }

  /**
    *The players position on the board
    *@return the players position as int
    */    
    public int getPosition()
    {
        return this.position;
    }

   /**
    *Moves the player according to the dice
    *@param new_position the sum of the two die
    */
    public void setPosition(int new_position)
    {
        if ((this.position + new_position) > 40)
        {
            this.position = ((new_position + this.position) - 40);
        }
        else
        {
            this.position += new_position;
        }
    }
    
    /**
     *Returns information about the Player in a String
     *@return string representation of this player
     */
    @Override
    public String toString()
    {
	return ("\n" + this.name + " has $" + this.account 
                + "\nPosition: " + this.position);
    }
}