package com.mnp.strings;

public class MethodOverriding {
	public static void main(String[] args) {
		Parent p = new Child();
		System.out.println(p.getObject());
	    p.print();
	}
}

class Parent {
	int x = 10;

	public Parent getObject() {
		return new Parent();
	}
	public  void print() {
        System.out.println("I am Parent");
    }
}

class Child extends Parent {
	int x = 20;

	public Child getObject() {
		return new Child();
	}
	
	public  void print() {
        System.out.println("I am Child");
    }
}