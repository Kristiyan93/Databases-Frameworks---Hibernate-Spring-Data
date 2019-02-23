package Exercise.f_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemon;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemon = new ArrayList<>();
    }

    public List<Pokemon> getPokemon() {
        this.badges++;
        return this.pokemon;
    }

    public void setPokemon(String element) {
        this.pokemon.stream().forEach(p -> {
            if (!p.getElement().equals(element)) {
                p.setHealth();
            }

            if (p.getHealth() < 1) {
                this.badges--;
            }
        });
    }
}
