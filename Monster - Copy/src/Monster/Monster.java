//Monster game: Fight between 3 Monsters and a Hero. The monsters fight with hero one after another and continues till all the monsters or heros is alive. 
package Monster;

import java.util.Random;

public abstract class Monster {
	public String name;
	public int health;
	public int attackPower;

	public boolean isAlive() {
		if (this.health > 0) {
			return true;
		} else {
			System.out.println(this.name + " is dead");
			return false;
		}
	}

	abstract public void takeDamage();

	abstract public void attack(Monster creature);

	public abstract void takeDamage(int health);

	{

	}

	public Monster(String name, int health, int attackPower) {
		this.name = name;
		this.health = health;
		this.attackPower = attackPower;
	}

	// Main method
	public static void main(String[] args) {
		// Hero objHero = new Hero();
		Monster[] creatures = new Monster[4];
		creatures[0] = new Rat("Larry", 3, 3);
		creatures[1] = new Ogre("Evan", 4, 5);
		creatures[2] = new Goblin("Deadflare", 5, 7);
		creatures[3] = new Hero("Gizmo", 40, 4);
		Hero.fight(creatures); // fight triggered by hero
	}
}

class Rat extends Monster {

	public void takeDamage() {
	}

	public void takeDamage(int power) {
		// this.health--;
		this.health = this.health - power;

	}

	public void attack(Monster creature) {
		creature.takeDamage(this.attackPower);
	}

	public Rat(String name, int health, int power) {
		super(name, health, power);
	}

}

class Ogre extends Monster {
	public void takeDamage() {
	}

	public void takeDamage(int power) {
		this.health = this.health - power;
	}

	public void attack(Monster creature) {
		creature.takeDamage(this.attackPower);
	}

	public Ogre(String name, int health, int power) {
		super(name, health, power);
	}

}

//
class Goblin extends Monster {
	public void takeDamage() {
	}

	public void takeDamage(int power) {
		this.health = this.health - power;
	}

	public void attack(Monster creature) {
		creature.takeDamage(this.attackPower);
	}

	public Goblin(String name, int health, int power) {
		super(name, health, power);
	}

}

//
class Hero extends Monster {

	public int i;

	public Hero(String name, int health, int power) {
		super(name, health, power);
	}

	public Hero() {
		super("Gizmo", 40, 60);
	}

	// Fight method initiates attacks and continues execution till all the
	// monsters or hero is alive
	public static void fight(Monster[] creature) {
		int i;
		for (i = 0; i <= 2; i++) {
			while (creature[i].isAlive() && creature[3].isAlive()) {
				Random r = new Random();
				double d = Math.ceil((r.nextDouble()) * 2);

				if (d == 1) {
					creature[3].attack(creature[i]); // hero attacks and
														// monsters take damage
				} else {
					creature[i].attack(creature[3]); // monsters attack and hero
														// takes damage
				}
			}
		}

		System.out.println("Game over");
		if (creature[3].isAlive()) {
			System.out.println(creature[3].name + " kills all Monsters");
		} else {
			System.out.println(creature[3].name + " is dead");
			System.out.println("Monsters kill " + creature[3].name);
		}
	}

	public void attack(Monster creature) {
		creature.takeDamage(this.attackPower);
	}

	public void takeDamage(int power) {
		this.health = this.health - power;
	}

	public void takeDamage() {
	}

	public boolean isAlive() {
		if (this.health > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void attack() {

	}

}
