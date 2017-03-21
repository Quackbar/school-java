public abstract class ResourceValue
{
	protected int fuel = 0;
	protected int steel = 0;
	protected int plutonium = 0;
	protected int plasma = 0;
	protected int energy = 100000000;
	protected int population = 100000;
	protected int populationSurplus = 0;
	protected int ppLocal = 0;
	protected int ppLocalP = 0;
	protected int ppLocal2 = 0;
	protected int ammo = 50;
	protected boolean build = false;
	protected boolean buildC = false;
	protected boolean gtg = false;
	protected boolean namec = false;
	protected String name = "City17";

	public void setFuel(int ful)
	{
		fuel = fuel += ful;
	}
	public int getFuel()
	{
		return fuel;
	}
	public void setSteel(int stel)
	{
		steel = steel += stel;
	}
	public int getSteel()
	{
		return steel;
	}
	public void setPlutonium(int plut)
	{
		plutonium = plutonium += plut;
	}
	public int getPlutonium()
	{
		return plutonium;
	}
	public void setPlasma(int plas)
	{
		plasma = plasma += plas;
	}
	public int getPlasma()
	{
		return plasma;
	}
	public void setEnergy(int ener)
	{
		energy = energy += ener;
	}
	public int getEnergy()
	{
		return energy;
	}
	public void setPopulation(int pop)
	{
		population = population += pop;
	}
	public int getPopulation()
	{
		return population;
	}
	public void setPopulationSurplus(int popS)
	{
		populationSurplus = populationSurplus += popS;
	}
	public int getPopulationSurplus()
	{
		return populationSurplus;
	}
	public void setPpLocal(int pp)
	{
		ppLocal = ppLocal += pp;
	}
	public int getPpLocal()
	{
		return ppLocal;
	}
	public void setPpLocal2(int pp2)
	{
		ppLocal2 = ppLocal2 += pp2;
	}
	public int getPpLocal2()
	{
		return ppLocal2;
	}
	public void setAmmo(int amm)
	{
		ammo = ammo += amm;
	}
	public int getAmmo()
	{
		return ammo;
	}
	public void setPpLocalP(int ppP)
	{
		ppLocalP = ppLocalP += ppP;
	}
	public int getPpLocalP()
	{
		return ppLocalP;
	}

}