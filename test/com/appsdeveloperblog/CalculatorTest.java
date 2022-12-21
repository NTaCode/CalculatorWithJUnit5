package com.appsdeveloperblog;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math operations in Calculator class")
class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void setup(){
        System.out.println("Executing @BeforeAll method");
    }
    @AfterAll
    static void cleanup(){
        System.out.println("Executing @AftereAll method");
    }

    @BeforeEach
    void beforeEachTestMethod(){
        System.out.println("Executing @BeforeEach method");
        calculator=new Calculator();
    }

    @AfterEach
    void afterEachTestMethod(){
        System.out.println("Executing @AfterEach method.");
    }

    // test<System Under Test>_<Condition or State Change>_Expected Result>
    @DisplayName("Test 4/2=2")
    @Test
    void testIntegerDivision_WhenFourIsDividedByTwo_Two() {
        System.out.println("Running Test 4/2=2");
        // Arrange // Given

        int dividend=4;
        int divisor=2;
        int expectedResult=2;

        //Act // When
        int result = calculator.integerDivision(4,2);

        //Assert //Then
        assertEquals(2,result);

    }

    //@Disabled("TO DO : Still Need to work on it")
    @DisplayName("Division by zero")
    @Test
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException(){
        System.out.println("Running Division by zero");
        // Arrange
        int dividend=4;
        int divisor=0;
        String expectedExceptionMessage="/ by zero";
        // Act & Assert
        ArithmeticException actualException=assertThrows(ArithmeticException.class,()->{
            // Assert
            calculator.integerDivision(dividend,divisor);
        },"Division by zero should have thrown an Arithmetic exception ");

        // Assert
        assertEquals(expectedExceptionMessage,actualException.getMessage(),"Unexpected exception message");
    }

    @ParameterizedTest
    @ValueSource(strings = {"John","Kate","Alice"})
    void valueSourceDemonstration(String firstName){
        System.out.println(firstName);
        assertNotNull(firstName);
    }


    @DisplayName("Test integer substraction [minuend,subtrahend,expectedResult]")
    @ParameterizedTest
    //@MethodSource()
    /*@CsvSource({
            "33,1,32",
            "54,1,53",
            "24,1,23"})*/
    @CsvFileSource(resources = "/integerSubstraction.csv")
    void integerSubtraction(int minuend,int subtrahend,int expectedResult) {

        System.out.println("Running Test "+minuend+" - "+subtrahend+"=32");

        int result = calculator.integerSubtraction(minuend,subtrahend);


        int actualResult=calculator.integerSubtraction(minuend,subtrahend);

        assertEquals(expectedResult,actualResult,
                ()->minuend+"-"+subtrahend+" did not produce "+expectedResult);
    }
    /*private static Stream<Arguments> integerSubtraction(){
        return Stream.of(
                Arguments.of(33,1,32),
                Arguments.of(54,1,53),
                Arguments.of(24,1,23)
        );
    }*/
}