
												Garbage collection Part-4 || finalization-1	
											==================================================
------------------
  Finalization 											
------------------
 
 -> Just before distroying an object garbage collector calls finalize() method to perform cleanUp activities.

 -> Once finalize() methods complites automatically garbage collector distroyes that object.

 -> finalize() method prasent in Object class with following declaration:

		--------------------------------------------
		|protected void finalize() throws Throwable|
		--------------------------------------------
		
 -> We can overide finalize() method in our class to define our own cleanUp activities.

---------
 Case 1: 
---------

 -> just before distroying an object garbage collector call finalize() method on the object which is eligible for gc 
	then the corrusponding class finalize() method will be executed.
	
	For example if String Object eligible for gc then String class finalize() method will be executed but not Test class 
	finalize() method.

	Ex. 
 
	class FinalizeDemo 
	{
		public static  void main(String args[])
		{
			String s = new String("durga");
			s=null;
			System.gc(); // After System.gc() there is two thread are there first main and second gc thread.
			System.out.println("End of Main");
		}
		public void finalize()
		{
			System.out.println("Finalize method call");
		}
	}
	
	- In the above example String object eligible for gc and hence a String class finalize() method got executed which 
	   has empty implementation and hence the output is End of Main.
	   
	- If we replace String object with Test object then Test class finalize() method will be executed in this case the 
	  output is End of Main, finalize method call or Finalize method Call or End of Main.

---------	  
 Case 2:
---------

	-> Based on our requirement we can call finalize() method explicitly then it will be executed just like normal method 
	   call and object won't be distroyed.

		class Test1 
		{
			public static void main(String args[])
			{
				Test1 t = new Test1();
				t.finalize();
				t.finalize();
				t=null;
				System.gc();
				System.out.println("End of Main");
			}
			public void finalize()
			{
				System.out.println("Finalize method call");
			}
		}
 
		output:
		
		Finalize method call
		Finalize method call
		Finalize method call
		End of Main
		
	-> In the above program finalize() method got executed three times in that two time  explicitly by the programmer 
	   and one time by garbage collector.
	   
	-> In this case output is:
	
		Finalize method call
        Finalize method call
        Finalize method call
        End of Main
		
 Note: 

	- IF we are calling finalize() method explicitly then it will be executed like a normal method call and object won't
	  distroyed.
	  
	- If garbage collector calls finalize() method then object will be distroyed.
	
	
 Note: 

	int(), service() and destroy() are considard as life cycle method of servlets.
	
	-> just before destroying servlets object web container call destroy() method to perform cleanUp activities then but 
	   based on our requirement we can call destroy() method from int() and service() methods then destroy() method will
	   be executed just like a normal method call and servlet object won't destroyed.