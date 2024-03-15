		class Test2 
		{
			static int count = 0;
			public static void main(String args[])
			{
				for(int i=0;i<1000000;i++)
				{
					Test1 t = new Test1();
					t=null;
				}
			}
			public void finalize()
			{
				System.out.println("Finalize method call : " + ++count);
			}
		}