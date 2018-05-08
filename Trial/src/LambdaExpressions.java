interface ComputeOddEven{
	boolean oddOrEven(int number);
}
public class LambdaExpressions {
	public static void main(String []args) {
		ComputeOddEven checkForEven = (int n) -> (n%2)==0;
		ComputeOddEven checkForOdd = (int n) -> (n%2)!=0;
		if(checkForEven.oddOrEven(4))
			System.out.println("4 is an even number");
		if(!checkForEven.oddOrEven(5))
			System.out.println("5 is an odd number");
		if(checkForOdd.oddOrEven(11)) 
			System.out.println("11 is an odd number");
		if(checkForOdd.oddOrEven(4))
			System.out.println("4 is an even number");
	}
}
