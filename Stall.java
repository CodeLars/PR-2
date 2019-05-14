import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import TierGen.Tier;



@SuppressWarnings("serial")
public class Stall<T extends Tier> extends TreeSet<T> 
{	
	public boolean add(T e)
	{	
		boolean result = super.add(e); 
		return result;
	}
	@Override
	public String toString()
	{
		String result = "";
		Iterator<T> itr = this.iterator();
		while(itr.hasNext()) 
		{
	         T ph = itr.next();
	         if(ph instanceof Tier)
	         {
	        	 result += (((Tier) ph).getTierart() + "(" + ((Tier) ph).getGeschlecht() + ") | ");
	         }	 
	         	         
	    }
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public void raubtiertrennung(Collection<?> e, boolean raubT)
	{
		Iterator<T> itrT = this.iterator();
		while(itrT.hasNext())
		{
			T sp = itrT.next();			
			if(((Tier) sp).getRaubtier()==raubT)
			{
				((Collection<T>)e).add(sp);
			}
		}
		
	}
}
