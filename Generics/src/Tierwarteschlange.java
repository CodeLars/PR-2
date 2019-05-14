import java.util.LinkedList; 
import java.util.ListIterator;
import TierGen.Reptil;
import TierGen.Tier;
import  TierGen.Vogel;

@SuppressWarnings({"serial" })
public class Tierwarteschlange extends LinkedList<Tier> 
{
	public void printWarteschlange()
	{
		//going through the list and collecting one by 1 the attributes
		ListIterator<Tier> itr = this.listIterator();
		String cache = "";
		while(itr.hasNext())
		{
			cache += itr.next().getTierart()+" ("+itr.previous().getGeschlecht()+") | ";
			itr.next();
		}
		System.out.println(cache);
	}
	
	public int Sturm()
	{
		//going through the list and remove all birds
		ListIterator<Tier> itr = this.listIterator();		
		int counter = 0;
		
		while(itr.hasNext())
		{
			if(itr.next() instanceof Vogel)
			{
				itr.remove();
				counter++;
			}
		}
				
		return counter;
	}
	
	public int grossesFressen()
	{
		ListIterator<Tier> itrT = this.listIterator();
		int counter = 0;
		Tier behind = null;
		Tier foreman = null;
		while(itrT.hasNext())
		{			
			behind = itrT.next();			
			//overflow protection
			if(itrT.hasNext())
			{
				//checks if toxic-reptile or predator
				if(eatable(behind))
				{
					foreman = itrT.next();
					//is the Animal in front of me a predator ?
					if(foreman.getRaubtier() == true)
					{
						//going back and remove the "sheep" 
						itrT.previous();
						itrT.previous();
						itrT.remove();
						counter++;
					}
					else 
					{
						//only one field back, because nothing got removed
						itrT.previous();
					}

				}
				
			}

		}					
		return counter;
	}
	
	private boolean eatable(Tier t1)
	{
		if(t1 instanceof Reptil)
		{
			if(((Reptil) t1).getGiftig()==true)
			{
				return false;
			}			
		}
		
		if(t1.getRaubtier() == true)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}

	public void sort(int size)
	{
		ListIterator<Tier> itrT = this.listIterator();
		Tier[] cache = new Tier[size];
		
		//save the elements and clearing the list
		int i = 0;
		while(itrT.hasNext())
		{
			cache[i] = itrT.next();			
			itrT.remove();
			i++;
		}		
	
		Tier compareObejct = null;
		Tier storage = null;
		for(int k = 0; k < size; k++)
		{
			compareObejct = cache[k];
			//k+1 because the objects before are already checked
			for(int j = k+1; j<size; j++)
			{
				//System.out.println("j: "+j);
				if((compareObejct.getTierart()).equals(cache[j].getTierart()))
				{					
					//switching the elements 					
					storage = cache[k+1];
					if(!(storage.getTierart().equals(cache[j].getTierart())))
					{
						System.out.println(storage.getTierart()+" wurde mit "+cache[j].getTierart()+" getauscht");
					}					
					cache[k+1] = cache[j];
					cache[j] = storage;
					
				}
			}
		}		
		//add them again to the List
		for(int k = 0; k < size; k++)
		{
			itrT.add(cache[k]);			
		}
		
	}
	
}
		

