package top.elgong.reflect;

import top.elgong.reflect.impl.UserImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest {



	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		// 获得class 对象
		/**
		 *  1. Class 类的 forName 静态方法,  包的全名+ 字符串
		 *  2. 获取某一个对象的 class
		 *  3. 调用某个对象的 getClass() 方法
		 */

		// 1. 获取 Class 对象
		String cls = "top.elgong.reflect.impl.UserImpl";
		Class aClass = Class.forName(cls);
		System.out.println(aClass);

		// 2. 调用无参构造创建对象
		UserImpl u1 = (UserImpl) aClass.newInstance();
		u1.setAge(18);
		u1.setName("elgong");
		System.out.println(u1);

		// 3. 调用有参数构造
		Constructor constructor = aClass.getConstructor(String.class, Integer.class);
		System.out.println(constructor);

		UserImpl u2 = (UserImpl) constructor.newInstance("elgong2", 19);
		System.out.println(u2.toString());

	}

}
