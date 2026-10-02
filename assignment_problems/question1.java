package assignment_problems;

// Class encapsulating game character health boundaries
class Character {
    private final int maxHealth;
    private int currentHealth;

    // Constructor initializing max health and setting current health to max
    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    // Reduces health by damage amount, floor clamped at 0
    public void takeDamage(int amount) {
        if (amount <= 0) return;
        this.currentHealth = Math.max(0, this.currentHealth - amount);
    }

    // Increases health by heal amount, cap clamped at maxHealth
    public void heal(int amount) {
        if (amount <= 0) return;
        this.currentHealth = Math.min(this.maxHealth, this.currentHealth + amount);
    }

    // Read-only getter for current health
    public int getCurrentHealth() {
        return this.currentHealth;
    }

    // Read-only getter for max health
    public int getMaxHealth() {
        return this.maxHealth;
    }
}

public class question1 {

    public static void main(String[] args) {
        // Instantiate character with 100 max health
        Character c = new Character(100);

        // Take 30 damage -> 70
        c.takeDamage(30);
        System.out.println("c.takeDamage(30) -> health = " + c.getCurrentHealth());

        // Heal 50 -> capped at 100
        c.heal(50);
        System.out.println("c.heal(50) -> health = " + c.getCurrentHealth() + " (capped)");

        // Take 150 damage -> floored at 0
        c.takeDamage(150);
        System.out.println("c.takeDamage(150) -> health = " + c.getCurrentHealth() + " (floored)");
    }
}
