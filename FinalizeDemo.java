class FinalizeDemo 
	{
		public static  void main(String args[])
		{
			String s = new String("durga");
			FinalizeDemo s1 = new FinalizeDemo();
			s=null;
			s1=null;
			System.gc();
			System.out.println("End of Main");
		}
		public void finalize()
		{
			System.out.println("Finalize method call");
		}
	}