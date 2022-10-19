package weapons;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Weapon {

    private String name;
    private CombatType combatType;
    private DamageType damageType;
    private int damage;
    private int speed;
    private int strength;
    private int value;

    public Weapon(String name, CombatType combatType, DamageType damageType, int damage, int speed, int strength, int value) {
        this.name = name;
        this.combatType = combatType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.strength = strength;
        this.value = value;
    }

    public static List<Weapon> readFile(String file) {
        List<Weapon> weaponList = new ArrayList<>();
        try {
            Stream<String> lineStream = Files.lines(Paths.get(file));
            lineStream.forEach(line -> {
                String[] parts = line.split(";");

                if(!parts[0].equals("name"))
                    weaponList.add(new Weapon(parts[0], CombatType.valueOf(parts[1]), DamageType.valueOf(parts[2]),
                            Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6])));
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return weaponList;
    }

    @Override
    public String toString() {
        return "Weapon{" + "name=" + name + ", combatType=" + combatType + ", damageType=" + damageType + ", damage=" + damage + ", speed=" + speed + ", minStrength=" + strength + ", value=" + value + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return damage == weapon.damage && speed == weapon.speed && strength == weapon.strength && value == weapon.value && name.equals(weapon.name) && combatType == weapon.combatType && damageType == weapon.damageType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, combatType, damageType, damage, speed, strength, value);
    }

    public String getName() {
        return name;
    }

    public CombatType getCombatType() {
        return combatType;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStrength() {
        return strength;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
