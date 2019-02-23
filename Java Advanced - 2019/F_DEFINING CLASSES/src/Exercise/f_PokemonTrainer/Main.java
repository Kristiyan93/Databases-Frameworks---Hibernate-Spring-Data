package Exercise.f_PokemonTrainer;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Trainer> trainers = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, health);

            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).getPokemon().add(pokemon);

            input = scanner.nextLine();
        }

        String element = scanner.nextLine();

        while (!element.equals("End")) {
            element = scanner.nextLine();
        }
    }
}
