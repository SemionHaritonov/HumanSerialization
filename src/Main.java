import java.io.*;

public class Main {
    public static void main(String[] args) {
        File outputFile = new File(".\\output.txt");
        Human human = new Human("Steve Buscemi","1789");
        Human man = null;
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;

        try {
            fileOutputStream = new FileOutputStream(outputFile);

            Serializer.serialization(human, fileOutputStream);

            fileInputStream = new FileInputStream(outputFile);

            man = Deserializer.deserialization(fileInputStream);

            System.out.println(man.getName());
            System.out.println(man.getPassportNumber());






        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
