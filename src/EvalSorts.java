
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class EvalSorts {

	public static void main(String[] args) throws FileNotFoundException {
		long seed; 
		int length; 
		long startTime;
		long endTime;

		int[] masterData ;

		do {
			// input data source 
			prompt("Data source? (0 = file, 1 = generated)");
			if (getInput() == 0L){
			
				//get data from file
				//process data from file
				//input file name
				prompt("File name? ");
				String fname = getFileName();
				masterData = readFile(fname);
				
			} else {
				
				// get experiment parameters
				prompt("How many values?");
				length = getInput();
				prompt("What seed? 0 = default ");
				seed = getInput();

				// generate random data
				masterData = new int[length];
				setRandomSeed(seed);
				for (int i = 0; i < length; i++){
					masterData[i] = nextRandomInt();
				}								

			}
			runSorts(masterData);
				
			prompt("Another experiment? (0 = no, 1 = yes) ");
		} while (getInput() == 1L);
	}
	
	public static void runSorts(int[] inData){
		long startTime;
		long endTime;
		// perform insertion sort
		int[] masterData = inData;
		int[] localData ;

		localData = makeCopy(masterData);
		startTime = getTime();
		insertionSort(localData);
		endTime = getTime();
		System.out.format("%20.20s %10d %10d %n", "insertion Sort", localData.length, endTime-startTime);
		
		// perform selection sort
		localData = makeCopy(masterData);
		startTime = getTime();
		selectionSort(localData);
		endTime = getTime();
		System.out.format("%20.20s %10d %10d %n", "selection Sort", localData.length, endTime-startTime);

		// perform merge sort
		localData = makeCopy(masterData);
		startTime = getTime();
		mergeSort(localData);
		endTime = getTime();
		System.out.format("%20.20s %10d %10d %n", "merge Sort", localData.length, endTime-startTime);

		// perform quick sort
		localData = makeCopy(masterData);
		startTime = getTime();
		qSort(localData);
		endTime = getTime();
		System.out.format("%20.20s %10d %10d %n", "quick Sort", localData.length, endTime-startTime);
		

	}
	
	public static int[] readFile( String fname) throws FileNotFoundException{
		Scanner fscan = new Scanner(new File(fname));
		int numEntries = fscan.nextInt();
		int[] data = new int[numEntries];
		for (int i = 0; i < numEntries; i++){
			data[i] = fscan.nextInt();
		}
		fscan.close();
		return data;
	}

	
	public static int[] makeCopy(int[] source){
		int[] retData = new int[source.length];
		for (int i = 0; i < source.length; i++){
			retData[i] = source[i];
		}
		return retData;
	}
	
	// my make believe library follows. 
	private static Scanner scan = new Scanner(System.in);

	public static int getInput(){
		return scan.nextInt();
	}
	
	public static String getFileName(){
		return scan.next();
	}
	
	public static void prompt(String query){
		System.out.println(query);
	}
	
	public static int[] insertionSort(int[] data){
		randomDelay();
		return data; 
	}

	public static int[] qSort(int[] data){
		randomDelay();
		return data; 
	}

	public static int[] mergeSort(int[] data){
		randomDelay();
		return data; 
	}

	public static int[] selectionSort(int[] data){
		randomDelay();
		return data; 
	}

	public static Random generator ;
	private static void setRandomSeed(long seed) {
		generator = new Random(seed);		
	}

	private static int nextRandomInt() {
		if (generator == null) {
			setRandomSeed(0L); //create default generator
		}
		return generator.nextInt();
	}

	private static long getTime() {
		return System.currentTimeMillis();
	}

	public static void randomDelay(){
		if (generator == null){
			setRandomSeed(0L); // create default
		}
		try {
			Thread.sleep(generator.nextInt(30));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
