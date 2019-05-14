import java.util.ListIterator;
import java.util.concurrent.SynchronousQueue;

import TierGen.Tier;
import TierGen.Tiergenerator;

import java.util.Iterator;

@SuppressWarnings("unused")
public class test 
{
	@SuppressWarnings("static-access")
	public static void main(String[] args)
	{
		Tiergenerator generator = new Tiergenerator();
		Tierwarteschlange SurvivalOfThePredator = new Tierwarteschlange();
		
		//adding 10 Animals to the Queue
		int i=10;
		while(i > 0)
		{
			SurvivalOfThePredator.add(generator.getTier());
			i--;
		}
		//console shizzle
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("START");
		SurvivalOfThePredator.printWarteschlange();
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("FRESSEN");
		int test2 = SurvivalOfThePredator.grossesFressen();
		System.out.println("Es wurden "+test2+" Tiere gefressen");
		SurvivalOfThePredator.printWarteschlange();
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("STURM");
		int test = SurvivalOfThePredator.Sturm();
		System.out.println("Es sind "+test+" Vögel geflohen");
		SurvivalOfThePredator.printWarteschlange();
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("FRESSEN");
		test2 = SurvivalOfThePredator.grossesFressen();
		System.out.println("Es wurden "+test2+" Tiere gefressen");
		SurvivalOfThePredator.printWarteschlange();
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("SORT");
		
		ListIterator<Tier> itr= SurvivalOfThePredator.listIterator(); 
		int k = 0;
		while(itr.hasNext())
		{			
			itr.next();
			k++;
		}
		//sorts the amount of remaining animals
		SurvivalOfThePredator.sort(k);		
		SurvivalOfThePredator.printWarteschlange();
		
		//aufgabe 2
		//adds Animals to Ark until 20 is reached, because the TreeSet sorts the duplicates out
		Arche Ark = new Arche();
		while(Ark.Stallbestand() < 20)
		{
			Ark.add(generator.getTier());
		}
		System.out.println();
		System.out.println();
		System.out.println("Aufgabe 2");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("Stallbelegung Arche");
		Ark.printStallbelegung();
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("Stallbelegung-Fütterung Arche");
		Ark.erstelleFuetterungsWarteschlangen();
		
	}
	

}
