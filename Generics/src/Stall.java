import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import TierGen.Tier;



@SuppressWarnings("serial")
public class Stall<Type extends Tier> extends TreeSet<Type> 
{	
	//adds the object to the TreeSet
	public boolean add(Type obj)
	{	
		boolean cache = super.add(obj); 
		return cache;
	}
	@Override
	public String toString()
	{
		String cache = "";
		Iterator<Type> itr = this.iterator();
		while(itr.hasNext()) 
		{
	         Type ph = itr.next();
	         if(ph instanceof Tier)
	         {
	        	 cache += (((Tier) ph).getTierart() + "(" + ((Tier) ph).getGeschlecht() + ") | ");
	         }	 
	         	         
	    }
		return cache;
	}
	
	@SuppressWarnings("unchecked")
	public void raubtiertrennung(Collection<?> obj, boolean isPredator)
	{
		//sorting the Animals from treeset into queues again
		Iterator<Type> itrT = this.iterator();
		while(itrT.hasNext())
		{
			Type cache = itrT.next();			
			if(((Tier) cache).getRaubtier()==isPredator)
			{
				((Collection<Type>)obj).add(cache);
			}
		}
		
	}
}
