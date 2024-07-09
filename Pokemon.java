import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private String name;
    private String type;
    private int health;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;
    private int level;
    private int experience;
    private List<Move> moves;
    private boolean isWild;

    public Pokemon(String name, String type, int health, int attack, int defense, int specialAttack, int specialDefense, int speed, int level, boolean isWild) {
        this.name = name;
        this.type = type;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.level = level;
        this.experience = 0;
        this.moves = new ArrayList<>();
        this.isWild = isWild;
    }

    public void attack(Pokemon opponent, Move move) {
        if (move.isHit()) {
            int damage = move.calculateDamage(this, opponent);
            opponent.takeDamage(damage);
        } else {
            System.out.println(this.name + "'s attack missed!");
        }
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
            System.out.println(this.name + " fainted!");
        }
    }

    public void gainExperience(int exp) {
        this.experience += exp;
        if (this.experience >= this.level * 100) {
            levelUp();
        }
    }

    public void levelUp() {
        this.level++;
        this.attack += 2;
        this.defense += 2;
        this.specialAttack += 2;
        this.specialDefense += 2;
        this.speed += 2;
        this.health += 10;
        System.out.println(this.name + " leveled up to " + this.level + "!");
    }

    public void learnMove(Move move) {
        if (this.moves.size() < 4) {
            this.moves.add(move);
            System.out.println(this.name + " learned " + move.getName() + "!");
        } else {
            System.out.println(this.name + " already knows 4 moves. Please forget a move to learn " + move.getName() + ".");
        }
    }

    public int getStat(String stat) {
        switch (stat.toLowerCase()) {
            case "health": return health;
            case "attack": return attack;
            case "defense": return defense;
            case "special attack": return specialAttack;
            case "special defense": return specialDefense;
            case "speed": return speed;
            default: throw new IllegalArgumentException("Invalid stat: " + stat);
        }
    }

    public int getLevel() {
        return this.level;
    }

    public boolean isWild() {
        return this.isWild;
    }

    public String getName() {
        return this.name;
    }
}








