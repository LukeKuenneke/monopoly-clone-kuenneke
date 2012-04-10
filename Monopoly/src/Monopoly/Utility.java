/****************************
 *@(#) Utility.java
 *@author: Lucas Kuenneke
 *@version 0.2 (Turn in #2)
 *@date 04/09/2012
 *Class: CEG463-01
 *Professor: Reisner
 */
package Monopoly;
public class Utility extends Property
{
    private int rent; //Rent amount for utility square

    /**
     *Constructs new instance of utility.
     *@param name          Name of square
     *@param cost          Amount to purchase the property
     *@param mortgage_rate Value when mortaged
     *@param rent_amount   Rent due for using utility
     */
    public Utility(String name, int cost, int mortgage_rate, int rent_amount)
    {
	super(name, cost, mortgage_rate);
	this.rent = rent_amount;
    }

    /**
     *Returns the fee amount to be paid for landing on this utility
     *@return Amount to be paid by player for landing on the utility
     */
    @Override
    public int getRent()
    {
	return this.rent;
    }

    /**
     *Returns information about the utility in a String
     *@return String information about the utility
     */
    @Override
    public String toString()
    {
	return ("Utility: " + super.toString());
    }
}