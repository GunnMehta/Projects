public class PokemonGame {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", "Electric", 100, 55, 40, 50, 50, 90, 5, true);
        Move thunderbolt = new Move("Thunderbolt", "Electric", 90, 100, "Special", null);
        pikachu.learnMove(thunderbolt);

        Trainer ash = new Trainer("Ash");
        Item pokeball = new Item("Pokeball", "Pokeball", 50);
        ash.getInventory().add(pokeball);

        ash.catchPokemon(pikachu, pokeball);
    }
}
