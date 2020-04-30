package testexcept;

public class Test {

	public static void main(String[] args) throws ErrPoint {
		
			Point a = new Point (1, 4) ;
			a.affiche() ;
			try
			{
			    a = new Point (-3, 5) ;
			    a.affiche() ;
			}
		
	     	catch (ErrPoint e)
		   { 
			System.out.println (e.getMessage()) ;
		   }
			try
			{
			a.deplace (-3, 5) ;
			a = new Point (-3, 5) ;
	        a.affiche() ;
			}
			
			catch (ErrPoint e)
			   { 
				System.out.println (e.getMessage()) ;
			   }
		
		
	}
}


class Point {
	public Point(int x, int y) throws ErrConst
	{
		if ( (x<0) || (y<0)) throw new ErrConst("coordonnées inférieures à zero") ;
	       this.x = x ; this.y = y ;
	}
	
	public void affiche()
	{ 
		System.out.println ("coordonnees : " + x + " " + y) ;
		
	}
	public void deplace (int dx, int dy) throws ErrDepl
	{
		if ( ((x+dx)<0) || ((y+dy)<0)) throw new ErrDepl("Erreur de déplacement") ;
             x += dx ; y += dy ;
	}
	private int x, y ;
	}

class ErrPoint extends Exception
{
	ErrPoint(String s)
	{
		super(s);
	}
}
class ErrConst extends ErrPoint
{
	ErrConst(String s)
	{
		super(s);
	}
}
class ErrDepl extends ErrPoint
{
	ErrDepl(String s)
	{
		super(s);
	}
}

