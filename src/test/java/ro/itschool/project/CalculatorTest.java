package ro.itschool.project;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.itschool.project.services.Calculator;

public class CalculatorTest {

    private Calculator calculator; 
    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }

    @Test
    void testAddition_ShouldPass_WithValidInput() {
        // GIVEN
        int firstNumber = 3;
        int secondNumber = 15;
        int expectedResult = firstNumber + secondNumber;
        System.out.println(Integer.MAX_VALUE+1);

        // WHEN
        int result = calculator.add(firstNumber, secondNumber);

        // THEN
        Assertions.assertEquals(expectedResult,result,"The addition result should be equal to the expected result");
    }

    @Test
    void testAddition_ShouldFail_WithResultExceedingIntegerMaxValue() {
        // GIVEN
        int firstNumber = Integer.MAX_VALUE;
        int secondNumber = 1;
        long expectedResult = (long) firstNumber + secondNumber;


        // WHEN
        int result = calculator.add(firstNumber, secondNumber);
        System.out.println("Integer Max Value: "+ Integer.MAX_VALUE);
        System.out.println("Expected Result: "+ expectedResult);
        System.out.println("Actual Result: "+ result);

        // THEN
        Assertions.assertNotEquals(expectedResult, result);
//        Assertions.assertThrows(ArithmeticException.class, () -> calculator.add(firstNumber,secondNumber), "Adding two numbers should throw Arithmetic Exception, when result exceeds Integre.MAX_VALUE.");
    }

    @Test
    void testSubtraction_ShouldPass_WithValidInput() {
        // GIVEN
        int firstNumber = 10;
        int secondNumber = 15;
        int expectedResult = firstNumber - secondNumber;

        // WHEN
        int result = calculator.subtract(firstNumber,secondNumber);

        // THEN
        Assertions.assertEquals(expectedResult,result,"The subtraction result should be equal to the expected result");
    }
}
