package com.atguigu01.string.exer1;

//考查：方法参数的值传递机制、String的不可变性
public class StringTest {
	int age = 18;
	String str = "good";
	char[] ch = new char[]{ 't', 'e', 's', 't' };
	public void change(String str, char ch[]) {
		str = "test ok";
//		this.str = "test ok";
		ch[0] = 'b';
	}

	public static void main(String[] args) {
		StringTest ex = new StringTest();
		System.out.println(Integer.toHexString(System.identityHashCode(ex.str)));
		ex.change(ex.str, ex.ch);
		System.out.println(Integer.toHexString(System.identityHashCode(ex.str)));
		System.out.println(ex.str); //
		System.out.println(ex.ch); //
		char[] ch = new char[]{ 't', 'e', 's', 't' };
		ch[1] = 'a';
		System.out.println(ch);
	}
}
