import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JokeHistoryImpl implements  JokeHistory {



    @Override
    public void saveID(String jokeID) {

        try {
            Files.write(createFile("C:\\Users\\Hubert\\Desktop\\jokeID.txt").toPath(), (jokeID+"\r").getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<String> listID() {
        BufferedReader br = null;
        try {
             br = new BufferedReader(new FileReader(createFile("C:\\Users\\Hubert\\Desktop\\jokeID.txt")));
            String line = br.readLine();
            List <String> listID  = new ArrayList<>();


            while (line != null) {
                line = br.readLine();
                listID.add(line);

            }
            return listID;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Collections.emptyList();
    }
    private  File  createFile (String path) throws IOException {
        File file = new File(path);
        if (!(file.exists())) {
            file.createNewFile();
        }
        return file;
    }
}
