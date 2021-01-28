package ssafy_0126;

class Test1{
	   public void view1() { System.out.println("view1 method"); }
	   public void view3() { System.out.println("view3 method"); }
	}
	class Test2 extends Test1{
	   
	   public void view1() { System.out.println("view11 method"); }
	   public void view2() { System.out.println("view22 method"); }
	}
	
public class OverrideEx {
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Test2 ob = new Test2();
	ob.view1(); //view11 method
	ob.view2(); //view22 method
	ob.view3(); //view3 method
	
	
}
}
