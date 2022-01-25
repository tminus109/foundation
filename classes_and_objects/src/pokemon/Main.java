package pokemon;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pokemon> pokemonListOfAsh = initializePokemons();
        Pokemon wildPokemon = new Pokemon("Oddish", "grass", "water");
        Pokemon chooseThisPokemon = null;

        for (Pokemon pokemon : pokemonListOfAsh) {
            if (pokemon.isEffectiveAgainst((wildPokemon))) {
                chooseThisPokemon = pokemon;
            }
        }

        assert chooseThisPokemon != null;
        System.out.print("I choose you, " + chooseThisPokemon.name + "!");
    }

    private static List<Pokemon> initializePokemons() {
        List<Pokemon> pokemon = new ArrayList<>();

        pokemon.add(new Pokemon("Bulbasaur", "grass", "water"));
        pokemon.add(new Pokemon("Pikachu", "electric", "water"));
        pokemon.add(new Pokemon("Charizard", "fire", "grass"));
        pokemon.add(new Pokemon("Pidgeot", "flying", "fighting"));
        pokemon.add(new Pokemon("Kingler", "water", "fire"));

        return pokemon;
    }
}
