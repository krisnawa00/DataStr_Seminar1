package service;

import datastr.MyList;

public class MainService {

	public static void main(String[] args) {
		MyList listForChar = new MyList(2);

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

	}

}