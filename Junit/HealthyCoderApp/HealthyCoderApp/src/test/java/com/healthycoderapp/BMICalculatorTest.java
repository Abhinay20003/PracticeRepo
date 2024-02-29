package com.healthycoderapp;

import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    @Test
    void should_ReturnTrue_When_DietRecommended() {
        //given
        double weight = 89.0;
        double height = 1.72;
        // When
        boolean recommended = BMICalculator.isDietRecommended(weight, height
        );

        //Then
        assertTrue(recommended);

    }
    //   void test(){
//        assertTrue(
//                BMICalculator.isDietRecommended(81.2,1.65)
//        );
    // }// This is shortcut for code

    @Test
    void should_ReturnFalse_When_DietNotRecommended() {
        //given
        double weight = 50.0;
        double height = 1.72;
        // When
        boolean recommended = BMICalculator.isDietRecommended(weight, height
        );

        //Then
        assertFalse(recommended);

    }

    @Test
    void should_ThrowArithmetic_When_HeightZero() {
        //given
        double weight = 50.0;
        double height = 0.00;
        // When
        Executable executable = () -> BMICalculator.isDietRecommended(weight, height);

        //Then
        assertThrows(ArithmeticException.class, executable);
    }

    @Test
    void should_ReturnWorstBMI() {
        //given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));
        // When
        Coder coderWorstBmi = BMICalculator.findCoderWithWorstBMI(coders);

        //Then
        assertAll(
                () -> assertEquals(1.82, coderWorstBmi.getHeight()),
                () -> assertEquals(98.0, coderWorstBmi.getWeight())
        );
    }

    @Test
    void should_ReturnNull_When_WorstBMI() {
        //given
        List<Coder> coders = new ArrayList<>();

        // When
        Coder coderWorstBmi = BMICalculator.findCoderWithWorstBMI(coders);

        //Then
        assertNull(coderWorstBmi);
    }

    @Test
    void should_ReturnBMIScores_BMI() {
        //given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));
        double[] exec = {18.52, 29.59, 19.53};

        // When
        double[] bmiScores = BMICalculator.getBMIScores(coders);

        //Then
        assertArrayEquals(exec, bmiScores);
    }
    @ParameterizedTest
    @ValueSource(doubles = {80.0,89.0,95.0,110.0})
    void Should_ReturnTrue(Double coderWeight) {   //one parameter i.e for weight
        //given
        double weight = coderWeight;//coderWeight takes values one by one from doubles 80.0,89.0,95.0,110.0
        double height = 1.72;
        //when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);
        //then
        assertTrue(recommended);

    }
    @ParameterizedTest(name="weight={0},height={1}")
    @CsvSource(value = {"89.0,1.72","95.0,1.75","110.0,1.78"})
    void Should_ReturnTrue_When_DietRecommend(Double coderWeight,Double coderHeight) {   //Two parameter i.e for weight
        //given
        double weight = coderWeight;//coderWeight takes values one by one from doubles 80.0,95.0,110.0
        double height = coderHeight;//coderHeight takes values one by one from doubles 1.72,1.75,1.78
        //when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);
        //then
        assertTrue(recommended);

    }

    @ParameterizedTest(name="weight={0},height={1}")
    @CsvFileSource(resources = "/diet-recommended-input-data.csv",numLinesToSkip = 1)
    void Should_ReturnTrue_When_DietRecommended(Double coderWeight,Double coderHeight) {   //Two parameter i.e for weight
        //given
        double weight = coderWeight;//coderWeight takes values one by one from doubles 80.0,95.0,110.0
        double height = coderHeight;//coderHeight takes values one by one from doubles 1.72,1.75,1.78
        //when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);
        //then
        assertTrue(recommended);
    }
    @Test
    void should_ReturnCoderWithWorstBMIin1ms_When_CoderList10000Elemnts(){
        //given
        List <Coder> coders=new ArrayList<>();
        for(int i=0;i<10000;i++){
            coders.add(new Coder(1.0+i,10.0+i));
        }
        //When
Executable executable=()->BMICalculator.findCoderWithWorstBMI(coders);
        //then
        assertTimeout(Duration.ofMillis(40),executable);
    }
}