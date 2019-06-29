public class Main {

    public static void main(String[] args) {

        APIJokeSource apiJokeSource = new APIJokeSource();

        apiJokeSource.getSource(5).forEach(joke -> System.out.println(joke.getValue()));


    }
}
