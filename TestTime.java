package testexcept;

 class Time {
	
	private int h,m, n, t, k;
	
	Time(int h,int m) //l'exception est traitée localement donc on n a pas besoin d'ajouter throws
	{
		try
		{
			if(h<0 || h>23 ) throw new TimeExcept("heures invalides");
			this.h=h;
		
	    	if(m<0 || m>=60) throw new TimeExcept("minutes invalides");
			this.m=m;
		}
		catch(TimeExcept e)
		{
			System.out.println(e.getMessage());
			//ajoutée dans question 2
			this.h=(int)(Math.random()*24);
			this.m=(int)(Math.random()*60);
		}
	}
	
	public void affiche()
	{
		System.out.println(h+" : "+m );
	}
   }
	
	class TimeExcept extends Exception
	{
		TimeExcept(String s)
		{
			super(s);
		}
	}
	
	public class TestTime 
	{
		public static void main(String[] args)
       {
				Time t= new Time (Integer.parseInt(args[0]) , Integer.parseInt(args[1]));
				//on récupère les heures et minutes de l'entrée standard
				t.affiche();
	   }
    }
