import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class State
{
	
	static String baseConversion(String number, int sBase, int dBase) 
	{ 
		return Integer.toString(Integer.parseInt(number,sBase),dBase); 
	} 

	static ArrayList<String> separator(String str, String delimiter)
	{
		ArrayList<String> result = new ArrayList<String>();
		Scanner scan2 = new Scanner(str);
		scan2.useDelimiter(delimiter);
		while (scan2.hasNext())
		{
			result.add(scan2.next());
		}
		scan2.close();
		return result;
	}
	
	static ArrayList<Integer> listStringToInt(ArrayList<String> list)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (String s : list)
		{
			result.add(Integer.parseInt(s));
		}
		return result;
	}

	static ArrayList<Double> listStringToDouble(ArrayList<String> list)
	{
		ArrayList<Double> result = new ArrayList<Double>();
		for (String s : list)
		{
			result.add(Double.parseDouble(s));
		}
		return result;
	}
	
	static String reverser(String sent)
	{
		String result = "";
		for (int i=sent.length()-1; i>=0; i--)
		{
			result += sent.charAt(i);
		}
		return result;
	}
	
	static boolean isVowel(char c)
	{
		if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
			return true;
		return false;
	}
	
	static String sanitize(String str)
	{
		String result = "";
		for (int i=0; i<str.length(); i++)
		{
			if (Character.isDigit(str.charAt(i)))
				result += str.charAt(i);
		}
		return result;
	}
	
	static String removeWhitespace(String str) {
		String result = "";
		for (int i=0; i<str.length(); i++)
		{
			if (str.charAt(i)!=' ')
				result += str.charAt(i);
		}
		return result;
	}
	
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
	
	static ArrayList<String> inputFile(String fileName)
	{
		ArrayList<String> lines = new ArrayList<String>();
		try
		{
			Scanner fScan = new Scanner(new File(fileName));
			while (fScan.hasNextLine())
			{
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
	
	static void outputFile(String fileName, ArrayList<String> lines)
	{
		try
		{
			File f = new File(fileName);
			FileWriter fWriter = new FileWriter(f);
			for (int i=0; i<lines.size()-1; i++)
			{
				fWriter.write(lines.get(i)+System.lineSeparator());
			}
			fWriter.write(lines.get(lines.size()-1));
			fWriter.close();
		}
		catch (IOException e)
		{
			System.out.println("IO Exception.");
		}
	}
	
	static void appendFile(String fileName, String str)
	{ 
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true)); 
			out.write(str); 
			out.close(); 
		} 
		catch (IOException e) { 
			System.out.println("IO Exception"); 
		} 
	}
	
	static void appendLineFile(String fileName)
	{ 
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true)); 
			out.write(System.lineSeparator()); 
			out.close(); 
		} 
		catch (IOException e) { 
			System.out.println("IO Exception"); 
		} 
	} 
	
	//NOTE! Must create an ArrayList of the correct type and then call this method.
	static void takeDoubleInput(ArrayList<Double> inputs, String delimiter)
	{
		Scanner scan1 = new Scanner(System.in);
		try
		{
			Scanner scan2 = new Scanner(scan1.nextLine());
			scan2.useDelimiter(delimiter);
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
			takeDoubleInput(inputs, delimiter);
		}
	}
	
	//NOTE! Must create an ArrayList of the correct type and then call this method.
	static void takeIntegerInput(ArrayList<Integer> inputs, String delimiter)
	{
		Scanner scan1 = new Scanner(System.in);
		try
		{
			Scanner scan2 = new Scanner(scan1.nextLine());
			scan2.useDelimiter(delimiter);
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
			takeIntegerInput(inputs, delimiter);
		}
	}
	
	//NOTE! Must create an ArrayList of the correct type and then call this method.
	static void takeWordInput(ArrayList<String> inputs, String delimiter)
	{
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(scan1.nextLine());
		scan2.useDelimiter(delimiter);
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
	    
    static int gcdArr(ArrayList<Integer> list)
    {
    	int result = gcd(list.get(0),list.get(1));
        for(int i = 2; i < list.size(); i++)
        {
           result = gcd(result, list.get(0));
        }
        return result;
    }
    	
    //NOTE! Range is inclusive
    static int rand(int min, int max)
	{
		Random r = new Random();
		return r.nextInt((max-min)+1)+min;
	}
    
    static double rand(double min, double max)
	{
		Random r = new Random();
		return r.nextDouble()*(max-min)+min;
	}
	
    static char rand(char min, char max)
    {
    	Random r = new Random();
		return (char)(r.nextInt((max-min)+1)+min);
    }
    
	static int[] bubbleSort(int[] array) 
    { 
		int[] arr = array;
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                { 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
        return arr;
    } 
	
	static boolean hasKey(ArrayList<Map<Object,Object>> arr, Object key)
	{
		boolean flag = false;
		for(Map<Object,Object> h: arr)
		{
			if(h.containsKey(key))
			{
				flag=true;
				break;
			}
		}
		return flag;
	}
	
    static int lcm(int a, int b) 
    { 
        return (a*b)/gcd(a, b); 
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

	static void printArray(int[] arr) 
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

	static String vEncrypt(final String message, final String key)
    {

        String result = "";

        for (int i = 0, j = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)){
                if(Character.isUpperCase(c)) {
                    result += (char) ((c + key.toUpperCase().charAt(j) - 2 * 'A') % 26 + 'A');

                } else {
                    result += (char) ((c + key.toLowerCase().charAt(j) - 2 * 'a') % 26 + 'a');

                }
            } else {
                result+=c;
            }
            j = ++j % key.length();
        }
        return result;
    }

	static String vDecrypt(final String message, final String key)
    {
        String result ="";

        for(int i = 0, j = 0; i < message.length(); i++){

            char c = message.charAt(i);
            if (Character.isLetter(c)){
                if(Character.isUpperCase(c)) {
                    result += ((char)('Z'-(25-(c-key.toUpperCase().charAt(j)))%26));

                } else {
                    result += ((char)('z'-(25-(c-key.toLowerCase().charAt(j)))%26));

                }
            } else {
                result+=c;
            }

            j = ++j % key.length();

        }
        return result;
     }
	
	static boolean isPalindrome(String s) {
        s = s.toLowerCase().trim();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c))
                sb.append(c);
        }
        s = sb.toString();
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;

        }
        return true;
    }
	
	public static void main(String[] args)
	{
		ArrayList<Integer> inputs = new ArrayList<Integer>();
		takeIntegerInput(inputs, "j");
		System.out.println(inputs);
	}
	
}