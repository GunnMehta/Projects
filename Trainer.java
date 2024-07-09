import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private List<Pokemon> team;
    private List<Item> inventory;

    public Trainer(String name) {
        this.name = name;
        this.team = new ArrayList<>();
        this.inventory = new ArrayList<>();
    }

    public List<Item> getInventory() {
        return this.inventory;
    }

    public void catchPokemon(Pokemon wildPokemon, Item pokeball) {
        if (wildPokemon.isWild() && inventory.contains(pokeball)) {
            if (Math.random() * 100 < pokeball.getCatchRate()) {
                team.add(wildPokemon);
                inventory.remove(pokeball);
                System.out.println(this.name + " caught " + wildPokemon.getName() + "!");
            } else {
                System.out.println(wildPokemon.getName() + " escaped!");
            }
        } else {
            System.out.println("Cannot catch this Pokémon.");
        }
    }

    public void useItem(Item item, Pokemon target) {
        if (inventory.contains(item)) {
            item.use(target);
            inventory.remove(item);
            System.out.println(this.name + " used " + item.getName() + " on " + target.getName() + ".");
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    public void battle(Trainer opponent) {
        // Implement turn-based battle logic
    }
}
