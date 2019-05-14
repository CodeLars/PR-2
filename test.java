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
		Tiergenerator G1 = new Tiergenerator();
		Tierwarteschlange richtigeAffen = new Tierwarteschlange();
		
		int i=10;
		while(i > 0)
		{
			richtigeAffen.add(G1.getTier());
			i--;
		}
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("START");
		richtigeAffen.printWarteschlange();
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("FRESSEN");
		int test2 = richtigeAffen.grossesFressen();
		System.out.println("Es wurden "+test2+" Tiere gefressen");
		richtigeAffen.printWarteschlange();
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("STURM");
		int test = richtigeAffen.Sturm();
		System.out.println("Es sind "+test+" Vögel geflohen");
		richtigeAffen.printWarteschlange();
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("FRESSEN");
		test2 = richtigeAffen.grossesFressen();
		System.out.println("Es wurden "+test2+" Tiere gefressen");
		richtigeAffen.printWarteschlange();
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("SORT");
		int k = 0;
		ListIterator<Tier> itr= richtigeAffen.listIterator();  
		while(itr.hasNext())
		{			
			itr.next();
			k++;
		}		
		richtigeAffen.sort(k);		
		richtigeAffen.printWarteschlange();
		
		//aufgabe 2
		
		Arche A1 = new Arche();
		while(A1.Stallbestand() < 20)
		{
			A1.add(G1.getTier());
		}
		System.out.println();
		System.out.println();
		System.out.println("Aufgabe 2");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("Stallbelegung Arche");
		A1.printStallbelegung();
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("Stallbelegung-Fütterung Arche");
		A1.erstelleFuetterungsWarteschlangen();
		
	}
	

}
