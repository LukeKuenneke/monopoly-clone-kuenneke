/***s*************************
 *@(#) Action.java
 *@author: Lucas Kuenneke
 *@version 0.2 (Turn in #2)
 *@date 04/09/2012
 *Class: CEG463-01
 *Professor: Reisner
 */
package Monopoly;
/**
 * 
 * @author LK
 */
public class Action extends Square
{
    /**
     * 
     * @param name
     */
    public Action(String name)
    {
	super(name);
    }
    
    /**
     * 
     * @return
     */
    public int collectOnGo()
    {
        return 200;
    }

    @Override
    public boolean mayBeBought() 
    {
        return false;
    }

    @Override
    public void buyIt(Player player) 
    {
    }
}