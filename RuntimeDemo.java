import java.util.Date;
		class RuntimeDemo
		{
			public static void main(String args[])
			{
				Runtime r = Runtime.getRuntime(); // Here i got Runtime object 
				
				System.out.println(r.totalMemory());
				System.out.println(r.freeMemory());
				for(int i = 1 ; i<=10000; i++)
				{
					Date d = new Date();
					d=null;
				}
				
				System.out.println(r.freeMemory());
				r.gc();
				System.out.println(r.freeMemory());
			}
		}