import java.io.*;
import java.util.Arrays;

public class Deserializer {

    public static Human deserialization(InputStream inputStream) throws IOException {
        return new Human(deserializationName(inputStream), deserializationPassportNumber(inputStream));
    }

    public static String deserializationName(InputStream inputStream) throws IOException {
        StringBuilder stringBuilderName = new StringBuilder();
        int currentInt;
        while ((currentInt = inputStream.read()) != '|') {
            stringBuilderName.append((char) currentInt);
        }

        return stringBuilderName.toString();
    }

    public static String deserializationPassportNumber(InputStream inputStream) throws IOException {
        StringBuilder stringBuilderPassport = new StringBuilder();
        int currentInt;
        while ((currentInt = inputStream.read()) != -1) {
            stringBuilderPassport.append((char) currentInt);
        }

        char[] subResult = new char[stringBuilderPassport.length()];

        stringBuilderPassport.getChars(0, stringBuilderPassport.length(), subResult, 0);

        for (int counter = subResult.length - 2; counter >= 0; counter--) {
            if (subResult[counter] >= subResult[counter + 1]) {
                subResult[counter] = (char) ((int) subResult[counter]
                        - (int) subResult[counter + 1] + '0');
            } else {
                subResult[counter] = (char) ((int) subResult[counter]
                        - (int) subResult[counter + 1] + 10 + '0');
            }
        }

        return String.copyValueOf(subResult);
    }
}
