/****************************
 *@(#) Property.java
 *@author: Lucas Kuenneke
 *@version 0.2 (Turn in #2)
 *@date 04/09/2012
 *Class: CEG463-01
 *Professor: Reisner
 */
package Monopoly;
public abstract class Property extends Square
{
    /**
     * 
     */
    protected int purchase; //Cost to purchase
    /**
     * 
     */
    protected int mortgage; //Mortgage rate

    /**
     *Cost of rent for property
     * @return cost for landing on space
     */
    public abstract int getRent();

    /**
     *Property constructor
     *@param name          Property name
     *@param cost          Cost to purchase property
     *@param mortgage_rate Value when mortaged
     */
    public Property(String name, int cost, int mortgage_rate)
    {
	super(name);
	this.purchase = cost;
	this.mortgage = mortgage_rate;
    }

    /**
     *Can this property be bought?
     *@return true if the property can be purchased
     */
    @Override
    public boolean mayBeBought()
    {
	return (!isOwned());
    }

    /**
     *Purchases this property for player, removes funds
     *@param player player who is buying property
     */
    @Override
    public void buyIt(Player player)
    {
	this.owner = player;
	player.deduct(this.purchase);
    }
    
    /**
     *Returns information about the Property in a String
     *@return string representation of this property
     */
    @Override
    public String toString()
    {
	String property_info = this.name + "\n\t costs: $" + this.purchase 
                + "\n\tmortgage: $" + this.mortgage;
	
        if (isOwned())
        {
	    property_info += ", owned by " + this.owner;
        }
        
        property_info += "\n";
        
	return property_info;
    }
}