package service;

import datastr.MyList;

public class MainService {

	public static void main(String[] args) {
		
		System.out.println("-----------------CHARACTER-------------------");
		MyList<Character> listForChar = new MyList<Character>(2);

		listForChar.add('g');// g
		listForChar.add('r');// g r
		listForChar.add('z');// g r z

		try {
			listForChar.print();// g r z
			listForChar.add('w', 1);// g w r z
			listForChar.print();// g w r z
			listForChar.remove(0);// izdzēsisies g un jāpaliek -> w r z
			listForChar.print();// w r z
			System.out.println(listForChar.get(1));// r
			System.out.println(listForChar.search('z'));// true
			System.out.println(listForChar.search('a'));// false
			listForChar.sort("asc");
			listForChar.print();// r w z

			listForChar.makeEmpty();
			listForChar.print();// sagaidu izņēmumu

		} catch (Exception e) {
			System.out.println(e);
		}

		listForChar.add('A');// A
		try {
			listForChar.print();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("-----------------INTEGER-------------------");

		MyList<Integer> listForInt = new MyList<Integer>(2);

		listForInt.add(1);//1
		listForInt.add(6);//1 6
		listForInt.add(2);//1 6 2

		try {
			listForInt.print();//1 6 2
			listForInt.add(100, 1);//1 100 6 2
			listForInt.print();//1 100 6 2
			listForInt.remove(0);// izdzēsisies 1 un jāpaliek -> 100 6 2
			listForInt.print();// 100 6 2
			System.out.println(listForInt.get(1));// 6
			System.out.println(listForInt.search(2));// true
			System.out.println(listForInt.search(-99));// false
			listForInt.sort("asc");
			listForInt.print();// 2 6 100

			listForInt.makeEmpty();
			listForInt.print();// sagaidu izņēmumu

		} catch (Exception e) {
			System.out.println(e);
		}

		listForInt.add(300);// 300
		try {
			listForInt.print();
		} catch (Exception e) {
			System.out.println(e);
		}

		
		
		
	}

}