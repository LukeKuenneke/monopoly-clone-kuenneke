/****************************
 *@(#) Lot.java
 *@author: Lucas Kuenneke
 *@version 0.2 (Turn in #2)
 *@date 04/09/2012
 *Class: CEG463-01
 *Professor: Reisner
 */
package Monopoly;
public class Lot extends Property
{
    private int house_cost;     //cost per house on lot
    private int num_houses = 0; //Current number of houses
    private int house_array[];  //Collection of houses

    /**
     *Lot Constructor
     *@param name         Name of square
     *@param cost         Amount to purchase the property
     *@param mortage_rate Value when mortaged
     *@param rent_amount  Rent due for houses(0 to 5)
     */
    public Lot(String name, int cost, int mortage_rate, int[] rent_amount)
    {
	super(name, cost, mortage_rate);
	house_array = rent_amount;
    }
    
    /**
     *Returns the rent amount to be paid for landing on this lot
     *@return Amount to be paid by player for landing on the lot
     */
    @Override
    public int getRent()
    {
	return this.house_array[num_houses];
    }
    
    /**
     *Returns information about the lot in a String
     *@return String information about the lot
     */
    @Override
    public String toString()
    {
	return ("Lot: " + super.toString());
    }
}