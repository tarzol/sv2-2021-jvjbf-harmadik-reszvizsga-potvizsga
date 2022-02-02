package examinformation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.*;

public class ExamService {

    private int theoryMax;
    private int practiceMax;

    public Map<String, ExamResult> getResults() {
        return results;
    }

    private Map<String, ExamResult> results = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    });


    public void readFromFIle(Path path) {
        List<String> lines;

        try {
            lines = Files.readAllLines(path);
            String[] minMaxPoints = lines.get(0).split(" ");
            theoryMax = Integer.parseInt(minMaxPoints[0]);
            practiceMax =Integer.parseInt(minMaxPoints[1]);
            lines.remove(0);
            for (String actual : lines) {

                String[] temp = actual.split(";");
                String examinerName = temp[0];
                String[] points = temp[1].split(" ");
                ExamResult newExamResult = new ExamResult(Integer.parseInt(points[0]), Integer.parseInt(points[1]));
                //System.out.println(examinerName + " " + newExamResult);
                writeExamResultsIntoMap(examinerName, newExamResult);
            }

        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file: src\\main\\java\\data.txt", ioe);
        }
    }


    public int getTheoryMax() {
        return theoryMax;
    }

    public int getPracticeMax() {
        return practiceMax;
    }

    public Map<String, ExamResult> getExamResults() {
        return results;
    }

    private void writeExamResultsIntoMap(String examinerName, ExamResult newExam) {
            results.put(examinerName, newExam);

    }

    public List<String> findPeopleFailed() {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, ExamResult> actual : results.entrySet()) {
            if ( (actual.getValue().getTheory() / (double)theoryMax) < 0.51  || (actual.getValue().getPractice() /(double)practiceMax) < 0.51) {
                result.add(actual.getKey());
            }
        }
        return result;
    }

    public String findBestPerson() {
        String bestPerson = "";
        int highestPoints = 0;
        for (Map.Entry<String, ExamResult> actual : results.entrySet() ) {
            if ((actual.getValue().getPractice() + actual.getValue().getTheory()) > highestPoints ) {
                bestPerson = actual.getKey();
            }
        }
        return bestPerson;
    }

    public static void main(String[] args) {
        ExamService service = new ExamService();
        service.readFromFIle(Path.of("src/test/resources/data.txt"));
    }

}
