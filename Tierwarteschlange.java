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
		ListIterator<Tier> itr = this.listIterator();
		String sp = "";
		while(itr.hasNext())
		{
			sp += itr.next().getTierart()+" ("+itr.previous().getGeschlecht()+") | ";
			itr.next();
		}
		System.out.println(sp);
	}
	
	public int Sturm()
	{
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
		Tier t1 = null;
		Tier t2 = null;
		while(itrT.hasNext())
		{			
			t1 = itrT.next();			
			//overflow protection
			if(itrT.hasNext())
			{
				//checks if toxic-reptile or predator
				if(eatable(t1))
				{
					t2 = itrT.next();
					//is the Animal in front of me a predator ?
					if(t2.getRaubtier() == true)
					{
						//going back and remove the "sheep" 
						itrT.previous();
						itrT.previous();
						itrT.remove();
						counter++;
					}
					else 
					{
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
		Tier[] sp = new Tier[size];
		
		//save the elements and clearing the list
		int i = 0;
		while(itrT.hasNext())
		{
			sp[i] = itrT.next();			
			itrT.remove();
			i++;
		}
		
		//System.out.println("i: "+i);
	
		Tier compareObejct = null;
		Tier storage = null;
		for(int k = 0; k < size; k++)
		{
			//System.out.println("k "+k);
			compareObejct = sp[k];
			//k+1 because the objects before are already checked
			for(int j = k+1; j<size; j++)
			{
				//System.out.println("j: "+j);
				if((compareObejct.getTierart()).equals(sp[j].getTierart()))
				{					
					//switching the elements 					
					storage = sp[k+1];
					if(!(storage.getTierart().equals(sp[j].getTierart())))
					{
						System.out.println(storage.getTierart()+" wurde mit "+sp[j].getTierart()+" getauscht");
					}					
					sp[k+1] = sp[j];
					sp[j] = storage;
					
				}
			}
		}		
		//add them again to the List
		for(int k = 0; k < size; k++)
		{
			itrT.add(sp[k]);			
		}
		
	}
	
}
		

