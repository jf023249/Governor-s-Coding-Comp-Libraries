import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomLibSAM {
	
	static int maxListInt(ArrayList<Integer> list)
	{
		int max = Integer.MIN_VALUE;
		for (int i : list)
		{
			if (i>max)
				max = i;
		}
		return max;
	}
	
	static int minListInt(ArrayList<Integer> list)
	{
		int min = Integer.MAX_VALUE;
		for (int i : list)
		{
			if (i<min)
				min = i;
		}
		return min;
	}
	
	static double maxListDouble(ArrayList<Double> list)
	{
		double max = Double.MIN_VALUE;
		for (double d : list)
		{
			if (d>max)
				max = d;
		}
		return max;
	}
	
	static double minListDouble(ArrayList<Double> list)
	{
		Double min = Double.MAX_VALUE;
		for (double d : list)
		{
			if (d<min)
				min = d;
		}
		return min;
	}

	static ArrayList<Integer> arrayToArrayList(int[] list)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i : list)
		{
			result.add(i);
		}
		return result;
	}
	
	static ArrayList<Double> arrayToArrayList(double[] list)
	{
		ArrayList<Double> result = new ArrayList<Double>();
		for (double d : list)
		{
			result.add(d);
		}
		return result;
	}
	
	static ArrayList<String> inputFile(String fileName) {
		ArrayList<String> lines = new ArrayList<String>();
		try {
			Scanner fScan = new Scanner(new File(fileName));
			while (fScan.hasNextLine()) {
				lines.add(fScan.nextLine());
			}
			fScan.close();
			return lines;
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return lines;
		}
	}
	
	static void outputFile(String fileName, ArrayList<String> lines) {
		try {
			File f = new File(fileName);
			System.out.println("it worked");
			FileWriter fWriter = new FileWriter(f);
			for (String s : lines) {
				fWriter.write(s+"\n");
			}
			fWriter.close();
		}
		catch (IOException e) {
			System.out.println("IO Exception.");
		}
	}
	
	//NOTE! Must create an ArrayList of the correct type and then call this method.
	static void takeDoubleInput(ArrayList<Double> inputs)
	{
		Scanner scan1 = new Scanner(System.in);
		try
		{
			Scanner scan2 = new Scanner(scan1.nextLine());
			while (scan2.hasNext())
			{
				inputs.add(scan2.nextDouble());
			}
			scan1.close();
			scan2.close();
		}
		catch (Exception e)
		{
			System.out.println("INVALID INPUT: Enter only doubles separated by spaces.");
			inputs.clear();
			takeDoubleInput(inputs);
		}
	}
	
	static void takeIntegerInput(ArrayList<Integer> inputs)
	{
		Scanner scan1 = new Scanner(System.in);
		try
		{
			Scanner scan2 = new Scanner(scan1.nextLine());
			while (scan2.hasNext())
			{
				inputs.add(scan2.nextInt());
			}
			scan1.close();
			scan2.close();
		}
		catch (Exception e)
		{
			System.out.println("INVALID INPUT: Enter only integers separated by spaces.");
			inputs.clear();
			takeIntegerInput(inputs);
		}
	}
	
	static void takeWordInput(ArrayList<String> inputs)
	{
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(scan1.nextLine());
		scan1.close();
		while (scan2.hasNext())
		{
			inputs.add(scan2.next());
		}
		scan2.close();
	}
	
	static int lcmArr(ArrayList<Integer> list) 
    { 
        int result = 1; 
        int divisor = 2; 
          
        while (true) { 
            int counter = 0; 
            boolean divisible = false; 
              
            for (int i = 0; i < list.size(); i++) { 
  
                if (list.get(i) == 0) { 
                    return 0; 
                } 
                else if (list.get(i) < 0) { 
                    list.set(i,list.get(i) * (-1)); 
                } 
                if (list.get(i) == 1) { 
                    counter++; 
                } 

                if (list.get(i) % divisor == 0) { 
                    divisible = true; 
                    list.set(i,list.get(i)/divisor); 
                } 
            } 

            if (divisible) { 
                result = result * divisor; 
            } 
            else { 
                divisor++; 
            } 
  
            if (counter == list.size()) { 
                return result; 
            } 
        } 
    } 
	
    static int lcm(int a, int b) 
    { 
        return (a*b)/gcd(a, b); 
    } 
    
    static int gcdArr(ArrayList<Integer> list) {
    	int result = gcd(list.get(0),list.get(1));
        for(int i = 2; i < list.size(); i++){
           result = gcd(result, list.get(0));
        }
        return result;
    }
    
	static int gcd(int a, int b) 
	    { 
	        if (a == 0) 
	          return b; 
	        if (b == 0) 
	          return a; 
	        if (a == b) 
	            return a; 
	        if (a > b) 
	            return gcd(a-b, b); 
	        return gcd(a, b-a); 
		}
	
	static long maxPrimeFactor(long n) 
		{ 

			long maxPrime = -1; 
	  
			while (n % 2 == 0) { 
				maxPrime = 2; 
	  
				n >>= 1; 
			}  
			for (int i = 3; i <= Math.sqrt(n); i += 2) { 
				while (n % i == 0) { 
					maxPrime = i; 
					n = n / i; 
				} 
			} 

			if (n > 2) 
				maxPrime = n; 
	  
			return maxPrime; 
		} 
	 
	static int fib(int n) 
		{ 
		if (n <= 1) 
		   return n; 
		return fib(n-1) + fib(n-2); 
		} 
	 
	static int factorial(int n) 
    { 
        if (n == 0) 
            return 1; 
  
        return n * factorial(n - 1); 
    } 

	static int doubleFactorial(int n) 
    { 
        int res = 1; 
        for (int i = n; i >= 0; i = i-2) 
        { 
            if (i == 0 || i == 1) 
                return res; 
            else
                res *= i; 
        } 
          
        return res; 
    } 
	
	static boolean isPrime(int n) 
    { 
        if (n <= 1) return false; 
        if (n <= 3) return true; 
        if (n % 2 == 0 || n % 3 == 0) return false; 
      
        for (int i = 5; i * i <= n; i = i + 6) 
            if (n % i == 0 || n % (i + 2) == 0) 
            return false; 
      
        return true; 
    } 
	
	static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
	
	static String currencyFormat(double d)
	{
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
		return formatter.format(d);
	}
	
	public static void main(String[] args)
	{
		ArrayList<String> lines = inputFile("inputfile.txt");
		System.out.println(lines);
		outputFile("goose.txt", lines);
	}
}