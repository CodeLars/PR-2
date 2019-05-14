package TierGen;


import java.util.Random;


@SuppressWarnings("rawtypes")
public class Tier implements Comparable{

	private static final char MALE = 'M';
	private static final char FEMALE = 'W';
	
	private int alter;
	private int gewicht;
	private char geschlecht;
	private boolean raubtier = true;
	private String tierart = null;
		
	public Tier() {
		Random rand = new Random();
		alter = rand.nextInt(11);
		
		if (rand.nextInt(2) < 1) {
			geschlecht = MALE;
		}
		else {
			geschlecht = FEMALE;
		}
	}
	
	public Tier(String tierart, int alter, int gewicht, char geschlecht, boolean raubtier) {
		this.tierart = tierart;
		this.alter = alter;
		this.gewicht = gewicht;
		this.geschlecht = geschlecht;
		this.raubtier = raubtier;
	}
	
	
	public int getAlter() {
		return alter;
	}
	
	public int getGewicht() {
		return gewicht;
	}
	
	public char getGeschlecht() {
		return geschlecht;
	}
	
	public boolean getRaubtier () {
		return raubtier;
	}
	
	public String getTierart() {
		return tierart;
	}
	
	public void setRaubtier(boolean raubtier) {
		this.raubtier = raubtier;
	}
	
	public void setTierart(String tierart) {
		if (this.tierart == null) {
			this.tierart = tierart;
		}
	}
	
	public void setGeschlecht(char geschlecht) {
		this.geschlecht = geschlecht;
	}

	
	
	@Override
	public String toString() 
	{
		return getTierart() + " | Geschlecht: " + getGeschlecht() + " | Alter: " + getAlter() + " | Gewicht: " + getGewicht() + "| Raubtier: " + getRaubtier();
	}
	
	public int compareTo(Object Objekt) 
	{
		if(getTierart() == ((Tier)Objekt).getTierart() && getGeschlecht() == ((Tier)Objekt).getGeschlecht()) 
		{
			//getting deleted in TreeSet
			return 0;
		}
		else if(getTierart() == ((Tier)Objekt).getTierart() && getGeschlecht() == 'M' && ((Tier)Objekt).getGeschlecht() == 'W') 
		{
			//high priority
			return 1;
		}
		else if(getTierart() == ((Tier)Objekt).getTierart() && getGeschlecht() == 'W' && ((Tier)Objekt).getGeschlecht() == 'M')
		{
			//less priority 
			return -1; 
		}
		else if(getTierart() != ((Tier)Objekt).getTierart()) 
		{
			//useing compareTo from String, to sort different Animaltypes
			int ph = getTierart().compareTo(((Tier)Objekt).getTierart());
			if(ph == 0) 
			{	
				return 1;
			}
			else
			{	
				return ph;
			}
		}
		else 
		{
			throw new IllegalArgumentException();
		}
	}

}
