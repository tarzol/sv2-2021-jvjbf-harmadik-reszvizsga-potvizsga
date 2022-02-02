package examinformation;

public class ExamResult {
    private int theory;
    private int practice;


    public ExamResult(int theory, int practice) {
        this.theory = theory;
        this.practice = practice;
    }

    public int getPractice() {
        return practice;
    }

    public int getTheory() {
        return theory;
    }
}


//    @Test
//    void createExamResult() {
//        ExamResult examResult = new ExamResult(50, 80);
//
//        assertEquals(80, examResult.getPractice());
//        assertEquals(50, examResult.getTheory());
//    }