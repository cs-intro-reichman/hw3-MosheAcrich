// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if(x2 >= 0 ){
			for (int i = 0; i < x2; i++){
				x1++;
			}
		}
		else{
			for (int i = 0; i > x2; i--){
				x1--;
			}
		}
		// Replace the following statement with your code
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if(x2 >= 0){
		for(int i = 0; i < x2; i++){
			x1--;
		}
		}
		else{
			for(int i = 0; i > x2; i--){
				x1++;
			}
		}
		// Replace the following statement with your code
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int Value = 0;
		if(x2 >= 0){
		for(int i = 0; i < x2; i++){
			 Value = plus(Value, x1);
		}
		}
		else{
			for(int i = 0; i > x2; i--){
				Value = minus(Value, x1);


			}
		}
		// Replace the following statement with your code
		return Value;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int Value = x;
		if(n == 0){
			Value = 1;
		}
		else{
		for(int i = 1; i < n; i++){
			Value = times(Value,x);
		}
		}
		// Replace the following statement with your code
		return Value;
	}

// Returns the integer part of x1 / x2 
public static int div(int x1, int x2) {// I will make everything positive and then put the sign if needed
    int sign = 1;


    if (x1 < 0) {
        x1 = minus(0, x1);   
        sign = -sign;
    }
    if (x2 < 0) {
        x2 = minus(0, x2);   
        sign = -sign;
    }

    int Value = x1;
    int division = 0;

    for (; Value >= x2; division++) {
        Value = minus(Value, x2);
    }

    if (sign < 0) division = minus(0, division);

    return division;
}


	// Returns x1 % x2

	public static int mod(int x1, int x2) {
    	int a = x1;
    	int b = x2;

    	if (a < 0) {
        	a = minus(0, a); // abs
    	}
    	if (b < 0) {
        	b = minus(0, b);
    }

    int Value = a;

    for (; Value >= b; ) {
        Value = minus(Value, b);
    }

    return Value;
}


// Returns the integer part of sqrt(x) 
public static int sqrt(int x) {
    int Answer = 0;
    int Value = 0;

    while (true) {
        Value = times(Answer, Answer);
        if (Value > x) break;
        Answer++;
    }

    return Answer - 1;
}
 	  
}