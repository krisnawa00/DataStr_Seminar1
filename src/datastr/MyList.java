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
}
