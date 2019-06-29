import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.List;
import java.util.Stack;

public class APIJokeSource implements  JokeSource {

    @Override
    public List<NorrisJoke> getSource(int how) {
        Gson gson = new Gson();

        List<NorrisJoke> jokes = new Stack<>();
        JokeHistory jokeHistory = new JokeHistoryImpl();
        List<String> listID = jokeHistory.listID();

        while (jokes.size() < how) {
            HttpResponse<JsonNode> value;
            try {
                value = Unirest.get("https://api.chucknorris.io/jokes/random").asJson();
                NorrisJoke norrisJoke = gson.fromJson(value.getBody().toString(), NorrisJoke.class);
                if (!listID.contains(norrisJoke.getId())) {
                    jokes.add(norrisJoke);
                    jokeHistory.saveID(norrisJoke.getId());
                }

            } catch (UnirestException e) {
                System.out.println(e.getMessage());
            }
        }
        return jokes;
    }
}
