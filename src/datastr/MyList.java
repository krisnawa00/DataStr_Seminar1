package datastr;

public class MyList {
	//mainīgie
	private char[] list;
	private final int DEFAULT_SIZE = 10;
	private int size = DEFAULT_SIZE;
	private int counter = 0;
	
	//bezargumenta konstruktors
	public MyList() {
		list = new char[size];
	}
	
	//argumenta konstruktors
	public MyList(int inputSize) {
		if(inputSize > 0) {
			size = inputSize;
		}
		
		list = new char[size];	
	}
	
	public boolean isFull()
	{
		//garais if-else
		/*if(counter == size) {
			return true;
		}
		else
		{
			return false;
		}
		*/
		
		//īso if-else
		//return (counter == size) ? true : false;
		
		
		//īsā forma priekš true/false
		return (counter == size);
		
	}
	
	public boolean isEmpty() {
		return (counter == 0);
	}
	
	public int howManyElements() {
		return counter;
	}
	
	private void resize() {
		//garais if-else
		/*if(counter < 100) {
			size = size * 2;f
		}
		else
		{
			size = (int)(size * 1.5);
		}
		*/
		//īsais if-else
		size = (counter < 100) ? size * 2 : (int)(size * 1.5);
		char[] listNew = new char[size];
		
		for(int i = 0; i < counter; i++) {
			listNew[i] = list[i];
		}
		list = listNew;
		System.gc();//izsaucam atkritumu savācēju, kas izdzēsīs mazā masīva elementus
		
	}
	
	public void add(char element) {
		if(isFull()) {
			resize();
		}
		
		//garais pieraksts
		list[counter] = element;
		counter++;
		
		//īsais pieraksts
		//list[counter++] = element;
	}
	
	public void add(char element, int index) throws Exception {
		if(index < 0 || index > counter)
		{
			Exception myException = new Exception("Jusu index nav atbilstoss");
			throw myException;
		}
		else
		{
			if(isFull()) {
				resize();
			}
			
			for(int i = counter; i >= index; i--) {
				list[i+1] = list[i];
			}
			list[index] = element;
			counter++;
			
		}
	}
	
	
	
	

}