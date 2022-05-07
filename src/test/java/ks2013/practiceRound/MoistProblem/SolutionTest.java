package ks2013.practiceRound.MoistProblem;

import org.junit.jupiter.api.Test;

class SolutionTest extends BaseTest{
    private final Runnable runnable = () -> Solution.main(new String[0]);
    private final String testDataDirectory = "ks2013/practiceRound/MoistProblem/";
    @Test
    public void test1(){
        this.performTest(testDataDirectory +"input1.txt", testDataDirectory +"output1.txt", runnable);
    }

    @Test
    public void test2(){
        this.performTest(testDataDirectory +"ts1_input.txt", testDataDirectory +"ts1_output.txt", runnable);
    }

    @Test
    public void test3(){
        this.performTest(testDataDirectory +"ts2_input.txt", testDataDirectory +"ts2_output.txt", runnable);
    }
}