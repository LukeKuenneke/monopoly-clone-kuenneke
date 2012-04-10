/****************************
 *@(#) Square.java
 *@author: Lucas Kuenneke
 *@version 0.2 (Turn in #2)
 *@date 04/09/2012
 *Class: CEG463-01
 *Professor: Reisner
 */
package Monopoly;
public abstract class Square
{
    /**
     * 
     */
    protected String name;            //Name of the square
    /**
     * 
     */
    protected Player owner = null;    //Owner of the square

    /**
     *Is the square able to be bought?
     *@return true if the square is able to be purchased
     */
    public abstract boolean mayBeBought();

    /**
     *Associates the player with the square as the owner
     *@param player Player who is buying the square
     */
    public abstract void buyIt(Player player);

    /**
     *Constructs new instance of square.
     *@param name Name of this square
     */
    public Square(String name)
    {
	this.name = name;
    }

    /**
     *Returns Player who owns the square
     *@return Player who owns the square
     */
    public Player getOwner()
    {
	return (this.owner);
    }
    
    /**
     *Is the square owned?
     *@return true if the square is owned
     */
    public boolean isOwned()
    {
	return (this.owner != null);
    }
    
    /**
     *Returns information about the Square in a String
     *@return string representation of this square
     */
    @Override
    public String toString()
    {
	return this.name;
    }
}