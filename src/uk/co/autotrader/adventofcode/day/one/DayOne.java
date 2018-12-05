package uk.co.autotrader.adventofcode.day.one;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DayOne {

    public static Integer calculateFrequency(){
        List<Integer> frequencyChangesList = new ArrayList<>();
        List<Integer> runningTotalsList = new ArrayList<>();
        boolean foundSecondOccurence = false;

        Integer result = 0;
        runningTotalsList.add(result);

        try(Stream<String> stream = Files.lines(Paths.get("/Users/fraser.chapman/Work/AdventOfCode/src/uk/co/autotrader/adventofcode/day/one/resources/PuzzleInput.txt"))) {
            stream.forEach(line -> {
                frequencyChangesList.add(Integer.parseInt(line));


            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(!foundSecondOccurence) {
            for (Integer value : frequencyChangesList) {
                result += value;

                if (runningTotalsList.contains(result)) {
                    foundSecondOccurence = true;
                    break;
                }

                runningTotalsList.add(result);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(calculateFrequency());
    }
}
