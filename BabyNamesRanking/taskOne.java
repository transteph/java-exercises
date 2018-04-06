/**********************************************

 Workshop #4

 Course:<JAC444> - WINTER Semester

 Last Name:<TRAN>

 First Name:<STEPHANIE>

 ID:<134 233 162>

 Section:<SCD>

 This assignment represents my own work in accordance with Seneca Academic Policy.

STEPHANIE TRAN

 Date:<APRIL 02 2018>

 **********************************************/

import java.util.Arrays;
import java.util.List;

public class taskOne {

    private static List<String> topNames2017 = Arrays.asList(
            "Amelia",
            "Olivia",
            "emily",
            "Isla",
            "Ava",
            "oliver",
            "Jack",
            "Charlie",
            "harry",
            "Jacob"
    );

    public static List<String> getNames() {
        return topNames2017;
    }

    public static void main(String args[]) {
        try {
            List<String> names = getNames();

            names
                    .stream()
                    // capitalize first letter (at index 0 of string) and set rest of string lowercase
                    // substring(int beginIndex, int endIndex)
                    .map(s-> s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase() )
                    .sorted()
                    .forEach(System.out::println);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}