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
	
public void delete(int index) throws Exception {
	if (isEmpty()) {
		Exception myException = new Exception("Nav ko dzest lol");
		throw myException;
	}
	else {
		if(index < 0 || index > counter)
		{
			Exception myException = new Exception("Jusu index nav atbilstoss");
			throw myException;
		}
		for (int i = index; i < counter-1; i++) {
			list[i+1] = list[i];
			
		}
		list[counter-1] = ' ';
		counter--;
	}}
public char get (int index) throws Exception {
	if (isEmpty()) {
		Exception myException = new Exception("Tukss");
		throw myException;
	}
	else {
		if(index < 0 || index > counter)
		{
			Exception myException = new Exception("Jusu index nav atbilstoss");
			throw myException;
		}
	return list[index];
}
	
	
}
	
public boolean search (char element) throws Exception {
	if (isEmpty()) {
		Exception myException = new Exception("Tukss");
		throw myException;
	}
		for (int i = 0; i < counter; i++) {
			if (list[i] == element) {
				return true;
			}
			
		}
		return false;
}
	
public void sort(String sortingType) throws Exception {
	//parbaude par isEmpty
	if(isEmpty())
	{
		Exception myException = new Exception("Saraksts ir tukšs, tāpēc nevar veikt kārtošanu");
		throw myException;
	}
	
	if(sortingType != null && (sortingType.equalsIgnoreCase("asc") 
			||  (sortingType.equalsIgnoreCase("desc"))))
	{
		
		if(sortingType.equalsIgnoreCase("asc"))
		{
			for(int i = 0; i < counter; i++) {
				for(int j = 0; j < counter; j++) {
					if(list[i] > list[j])
					{
						swap(i,j);
					}
				}
			}
			
			
			
		}
		else if (sortingType.equalsIgnoreCase("desc")){
			
		}
		
		
		
	}
	else
	{
		Exception myException = new Exception("Kārtošanas parametrs nav atbilstošs");
		throw myException;

	}
	
	
	
	
}


}