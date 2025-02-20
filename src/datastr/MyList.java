package datastr;

public class MyList <Ttype>{
	//mainīgie
	private Ttype[] list;
	private final int DEFAULT_SIZE = 10;
	private int size = DEFAULT_SIZE;
	private int counter = 0;
	
	//bezargumenta konstruktors
	public MyList() {
		list = (Ttype[])new Object[size];
	}
	
	//argumenta konstruktors
	public MyList(int inputSize) {
		if(inputSize > 0) {
			size = inputSize;
		}
		
		list = (Ttype[])new Object[size];
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
			size = size * 2;
		}
		else
		{
			size = (int)(size * 1.5);
		}
		*/
		//īsais if-else
		size = (counter < 100) ? size * 2 : (int)(size * 1.5);
		Ttype[] listNew = (Ttype[])new Object[size];
		
		for(int i = 0; i < counter; i++) {
			listNew[i] = list[i];
		}
		list = listNew;
		System.gc();//izsaucam atkritumu savācēju, kas izdzēsīs mazā masīva elementus
		
	}
	
	public void add(Ttype element) {
		if(isFull()) {
			resize();
		}
		
		//garais pieraksts
		list[counter] = element;
		counter++;
		
		//īsais pieraksts
		//list[counter++] = element;
	}
	
	public void add(Ttype element, int index) throws Exception {
		if(index < 0 || index > counter)
		{
			Exception myException = new Exception("Jūsu index nav atbilstošs");
			throw myException;
		}
		else
		{
			if(isFull()) {
				resize();
			}
			
			for(int i = counter-1; i >= index; i--) {
				list[i+1] = list[i];
			}
			list[index] = element;
			counter++;
			
		}
	}
	
	//funkcijas deklarācija
	public void remove(int index) throws Exception
	{
		//parbaude, vai sarakstā ir elementi, ko dzēst
		if(isEmpty())
		{
			Exception myException = new Exception("Saraksts ir tukšs, tāpēc nevar neko izdzēst");
			throw myException;
		}

		//parbaude uz indeksu - cik pareizs tas ir
		if(index < 0 || index >= counter) {
			Exception myException = new Exception("Jūsu index nav atbilstošs");
			throw myException;
		}
		
	//veikt kopēsanu pa vienu iedaļu uz kreiso pusei sākot no dzēstā indeksa
		for(int i = index; i < counter-1; i++) {
			list[i] = list[i+1];
		}
	//pēdedje aizņemta šuna jaaizpili ar noklusejuma vērtību ' '
		list[counter-1] = null;
	//samzaināt counter par 1
		counter--;
	}
	
	//funkcijas deklaracija
	public Ttype get(int index) throws Exception {
		//parbaude par isEmpty
		if(isEmpty())
		{
			Exception myException = new Exception("Saraksts ir tukšs, tāpēc nevar piekļūt elementiem");
			throw myException;
		}
		//parbaude par indeksu, ko lietotājs padod
		if(index < 0 || index >= counter) {
			Exception myException = new Exception("Jūsu index nav atbilstošs");
			throw myException;
		}
		//atgriezt elemtnu, kas atrodas index šūnā
		return list[index];

	}
	
	//funkcijas deklarācija
	public boolean search(Ttype element) throws Exception {
		//parbaude par isEmpty
		if(isEmpty())
		{
			Exception myException = new Exception("Saraksts ir tukšs, tāpēc nevar meklēt elementus");
			throw myException;
		}
		
		//ar fotr ciklu iet cauri visiem elementiem un salīdzināt ar padoto elementu
		//un ja sakrīt, tad var atgriezt true
		for(int i = 0; i < counter; i++) {
			if(list[i].equals(element)) {
				return true;
			}
		}
		return false;
	
	}

	//TODO Izveidot funkciju, kas kā argumentu saņem elementu un atgriež nākamo elementu (veikt nepieciešamās pārbaudes);\
	
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
						//if(list[i] < list[j])
						if(((Comparable)(list[i])).compareTo(list[j]) == -1)
						{
							swap(i,j);
						}
					}
				}
				
				
				
			}
			else if (sortingType.equalsIgnoreCase("desc")){
				for(int i = 0; i < counter; i++) {
					for(int j = 0; j < counter; j++) {
						//if(list[i] > list[j])
						if(((Comparable)(list[i])).compareTo(list[j]) == 1)
						{
							swap(i,j);
						}
					}
				}
				
			}
			
			
			
		}
		else
		{
			Exception myException = new Exception("Kārtošanas parametrs nav atbilstošs");
			throw myException;

		}
		
		
		
		
	}
	
	private void swap(int index1, int index2) {
		Ttype temp = list[index1];
		list[index1] = list[index2];
		list[index2] = temp;	
	}

	
	//funkciajs deklaracija
	public void print() throws Exception
	{
		//pārbaudi uz isEmpty
		if(isEmpty())
		{
			Exception myException = new Exception("Saraksts ir tukšs, tāpēc nevar veikt printēšanu");
			throw myException;
		}
		
		for(int i = 0; i < counter ; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		
		
	}
	
	public void makeEmpty() {
		if(!isEmpty()) {
			size = DEFAULT_SIZE;
			counter = 0;
			list = (Ttype[]) new Object[size];
			System.gc();
		}
	}
	
	
	
	

}