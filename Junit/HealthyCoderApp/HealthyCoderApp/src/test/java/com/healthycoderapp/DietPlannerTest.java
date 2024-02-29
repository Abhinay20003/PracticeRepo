package com.healthycoderapp;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DietPlannerTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Running Before all the testcases");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Exiting codes");
    }

    private DietPlanner dietPlanner;

    @BeforeEach
    void setup() {
        this.dietPlanner = new DietPlanner(20, 30, 50);
    }

    @AfterEach
    void afterEach() {
        System.out.println("End of testing");
    }


    @Test
    void should_ReturnCorrectDietPlan_When_CorrectCoder() {
        //given
        Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
        DietPlan expected = new DietPlan(2202, 110, 73, 275);
        //When
        DietPlan actual = dietPlanner.calculateDiet(coder);
        //then
        assertAll(
                () -> assertEquals(expected.getCalories(), actual.getCalories()),
                () -> assertEquals(expected.getProtein(), actual.getProtein()),
                () -> assertEquals(expected.getFat(), actual.getFat()),
                () -> assertEquals(expected.getCarbohydrate(), actual.getCarbohydrate())
        );
    }
    @RepeatedTest(value=10,name=RepeatedTest.LONG_DISPLAY_NAME)
    void should_ReturnCorrectDietPlan_When_CorrectCoder_Repeated() {// Repeat the same test for n number of times
        //given
        Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
        DietPlan expected = new DietPlan(2202, 110, 73, 275);
        //When
        DietPlan actual = dietPlanner.calculateDiet(coder);
        //then
        assertAll(
                () -> assertEquals(expected.getCalories(), actual.getCalories()),
                () -> assertEquals(expected.getProtein(), actual.getProtein()),
                () -> assertEquals(expected.getFat(), actual.getFat()),
                () -> assertEquals(expected.getCarbohydrate(), actual.getCarbohydrate())
        );
    }

}