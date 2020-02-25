public class CustomLib {

	static int gcd(int a, int b) 
	    { 
	        // Everything divides 0  
	        if (a == 0) 
	          return b; 
	        if (b == 0) 
	          return a; 
	       
	        // base case 
	        if (a == b) 
	            return a; 
	       
	        // a is greater 
	        if (a > b) 
	            return gcd(a-b, b); 
	        return gcd(a, b-a); 
		} 
		
	static long maxPrimeFactors(long n) 
		{ 
			// Initialize the maximum prime 
			// factor variable with the 
			// lowest one 
			long maxPrime = -1; 
	  
			// Print the number of 2s 
			// that divide n 
			while (n % 2 == 0) { 
				maxPrime = 2; 
	  
				// equivalent to n /= 2 
				n >>= 1; 
			} 
	  
			// n must be odd at this point, 
			// thus skip the even numbers 
			// and iterate only for odd 
			// integers 
			for (int i = 3; i <= Math.sqrt(n); i += 2) { 
				while (n % i == 0) { 
					maxPrime = i; 
					n = n / i; 
				} 
			} 
	  
			// This condition is to handle 
			// the case when n is a prime 
			// number greater than 2 
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
        // Corner cases 
        if (n <= 1) return false; 
        if (n <= 3) return true; 
      
        // This is checked so that we can skip  
        // middle five numbers in below loop 
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

    public static int lcm(int a, int b) 
    { 
        return (a*b)/gcd(a, b); 
    } 
	
}