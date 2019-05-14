import TierGen.Vogel;
import TierGen.Saeuger;

import java.util.ListIterator;

import TierGen.Reptil;
import TierGen.Tier;

public class Arche
{
	Stall<Tier> birds = new Stall<Tier>();	
	Stall<Tier> reptiles = new Stall<Tier>();	
	Stall<Tier> mammals = new Stall<Tier>();	
	
	public boolean add(Tier animal)
	{
		if(animal instanceof Reptil)
		{
			reptiles.add(animal);
		}
		else if(animal instanceof Saeuger)
		{
			mammals.add(animal);
		}
		else if(animal instanceof Vogel)
		{
			birds.add(animal);
		}
		
		return false;
	}
	
	public void printStallbelegung()
	{
		System.out.println("Vogel-Stall:");
		System.out.println(birds.toString());
		System.out.println("Säuger-Stall:");
		System.out.println(mammals.toString());
		System.out.println("Reptilien-Stall:");
		System.out.println(reptiles.toString());
	}
	
	
	public void erstelleFuetterungsWarteschlangen()
	{
		Tierwarteschlange raubtiere = new Tierwarteschlange();
		Tierwarteschlange harmlos = new Tierwarteschlange();				
		
		birds.raubtiertrennung(raubtiere, true);
		birds.raubtiertrennung(harmlos, false);
		
		reptiles.raubtiertrennung(raubtiere, true);
		reptiles.raubtiertrennung(harmlos, false);
		
		mammals.raubtiertrennung(raubtiere, true);
		mammals.raubtiertrennung(harmlos, false);
		
		raubtiere.printWarteschlange();
		harmlos.printWarteschlange();	
	}
	public int Stallbestand()
	{
		int erg = 0;
		erg += birds.size();
		erg += mammals.size();
		erg += reptiles.size();
		return erg;
	}	
}
