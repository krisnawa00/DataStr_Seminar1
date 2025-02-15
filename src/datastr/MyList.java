package datastr;

public class MyList {

	private char[]list;
	private final int DEFAULT_SIZE =10;
	private int size = DEFAULT_SIZE;
	private int counter = 0;
	
	public MyList() {
		list = new char [size];
	}
	public MyList (int inputSize) {
		if (inputSize > 0) {
			size = inputSize;
		}
		list = new char [size];
	}
	public boolean isFull()
	{
		return (counter == size) ? true : false;
		
	}
	public boolean isEmpty()
	{
		return (counter == 0);
		
	}
	public int HowManyElements()
	{
		return counter;
		
	}
	private void resize() {
		size = (counter<100) ? size*2 : (int) (size * 1.5);
		char[]listNew = new char [size];
		for (int i = 0; i < counter;i++) {
			listNew[i] = list [i];
		}
		list = listNew;
		System.gc();
		
	}
	public void add(char element) {
		if(isFull()) {
			resize();
		}
		list[counter++] = element;
		counter++;
	}
	public void add(char element, int index) {
		
		if (index < 0 || index > counter) {
			//TODO izmest iznemumu
		}
		else {
			if(isFull()) {
				resize();
			}
			for (int i = counter; i > index; i--) {
				list[i+1] = list[i];
			}
			list[index] = element;
			counter++;
		}
	}
}
