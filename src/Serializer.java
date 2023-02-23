import java.io.*;

public class Serializer {
    public static void serialization(Human human, OutputStream outputStream) throws IOException {
        serializationName(human, outputStream);
        outputStream.write('|');
        serializationPassportNumber(human, outputStream);
        System.out.println("Serialization succeed");
        outputStream.close();
    }

    public static void serializationPassportNumber(Human human, OutputStream outputStream) throws IOException {
        StringReader pasportStringReader = new StringReader(human.getPassportNumber());
        int currentInt = pasportStringReader.read();
        while (currentInt != -1) {
            int nextInt = pasportStringReader.read();
            if (nextInt != -1) {
                outputStream.write(((currentInt - '0' + nextInt - '0') % 10 + '0'));
            } else {
                outputStream.write(currentInt);
            }
            currentInt = nextInt;
        }
    }

    public static void serializationName(Human human, OutputStream outputStream) throws IOException {
        StringReader pasportStringReader = new StringReader(human.getName());
        int currentInt;
        while ((currentInt = pasportStringReader.read()) != -1) {
            outputStream.write(currentInt);
        }
    }
}
