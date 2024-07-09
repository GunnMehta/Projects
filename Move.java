public class Move {
    private String name;
    private String type;
    private int power;
    private int accuracy;
    private String category; // "Physical" or "Special"
    private String effect; // Optional

    public Move(String name, String type, int power, int accuracy, String category, String effect) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
        this.category = category;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public boolean isHit() {
        return Math.random() * 100 < accuracy;
    }

    public int calculateDamage(Pokemon attacker, Pokemon defender) {
        int damage = (int)(((2 * attacker.getLevel() / 5 + 2) * power * attacker.getStat(category.equals("Physical") ? "attack" : "special attack") / defender.getStat("defense")) / 50 + 2);
        return damage;
    }

    public void applyEffect(Pokemon target) {
        if (effect != null) {
            // Apply specific effect logic here
        }
    }
}
