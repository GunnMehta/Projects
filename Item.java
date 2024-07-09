public class Item {
    private String name;
    private String type;
    private int effect; // This can be varied based on the item type

    public Item(String name, String type, int effect) {
        this.name = name;
        this.type = type;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public int getCatchRate() {
        return type.equals("Pokeball") ? effect : 0;
    }

    public void use(Pokemon target) {
        if (type.equals("Healing")) {
            target.takeDamage(-effect);
        }
        // Add more item types and their effects as needed
    }
}
