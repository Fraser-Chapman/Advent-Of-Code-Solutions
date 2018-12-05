package uk.co.autotrader.adventofcode.day.two;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DayTwo {
    static char tripleChar;
    private static Integer calculateCheckSum() {
        List<String> idList = new ArrayList<>();
        Integer amountOfDoubles = 0;
        Integer amountOfTriples = 0;

        try (Stream<String> stream = Files.lines(Paths.get("/Users/fraser.chapman/Work/AdventOfCode/src/uk/co/autotrader/adventofcode/day/two/DayTwoInput.txt"))) {
            stream.forEach(line -> {
                idList.add(line);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String id : idList) {
            if(containsTriple(id)) {
                amountOfTriples++;
            }

            if (containsDouble(id)) {
                amountOfDoubles++;
            }
        }
        System.out.println(amountOfDoubles);
        System.out.println(amountOfTriples);

        return amountOfDoubles * amountOfTriples;
    }

    private static boolean containsDouble(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    if (input.charAt(i) != tripleChar)
                    return true;
                }

            }
        }

        return false;
    }

    private static boolean containsTriple(String input) {
        for (int i = 0; i < input.length(); i++) {
            int charCount = 0;

            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    charCount++;

                    if (charCount == 2) {
                        tripleChar = input.charAt(i);
                        return true;
                    }
                }

            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(calculateCheckSum());
    }
}
