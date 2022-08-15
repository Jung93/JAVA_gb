package myLambdaTask;

@FunctionalInterface
public interface Calc {
	//두 정수를 전달받은 후 더하거나 빼서 리턴한다. 
	int calc(int firstNumber, int secondNumber);

}
