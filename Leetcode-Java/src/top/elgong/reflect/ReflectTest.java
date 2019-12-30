package top.elgong.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest {

	public ReflectTest() {
		
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		// 获得class 对象
		/**
		 *  1. Class 类的 forName 静态方法,  包的全名+ 字符串
		 *  2. 获取某一个对象的 class
		 *  3. 调用某个对象的 getClass() 方法
		 */
		
		Class cls1 = Class.forName("top.elgong.reflect.MyClass");
		System.out.println("cls1 = " + cls1);
		
		Class cls2 = MyClass.class;
		System.out.println("cls2 = " + cls2);
		
		MyClass myclass = new MyClass();
		Class cls3 = myclass.getClass();
		System.out.println("cls3 = " + cls3);
		
		// 同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次
		System.out.println(cls1 == cls2);
		System.out.println(cls1 == cls3);
		
		System.out.println(MyClass.class.isInstance(myclass));
		
		int i = 0;
		System.out.println(myclass instanceof  MyClass);
		
		
		//  创建对象
		/**
		 *  1. Class对象的newInstance()方法
		 *  2. Class对象获取指定的Constructor对象
		 */
		
		Class cls4 = String.class;
		// 只调用无参数构造
		Object obj1 = cls4.newInstance();
		
	
		//获取String所对应的Class对象
		Class c = String.class;
		
		//获取String类带一个String参数的构造器
		Constructor constructor = c.getConstructor(String.class);
		
		//根据构造器创建实例
		Object obj2 = constructor.newInstance("23333");
		System.out.println(obj2);
	}

}
