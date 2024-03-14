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