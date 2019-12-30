package top.elgong.reflect;

public class MyClass {

	public  String strPublic = "public string !";
	protected String strProtected = "protected string";
	private String strPrivate = "private string";
	
	
	// 构造
	public MyClass() {
			
	}


	public MyClass(String strPublic, String strProtected, String strPrivate) {
		super();
		this.strPublic = strPublic;
		this.strProtected = strProtected;
		this.strPrivate = strPrivate;
	}
	
	
	public static int sum(int a, int b) {
		
		return a+b;
	}


	@Override
	public String toString() {
	
		return super.toString();
	}
	
	
	
	
	
	

}
