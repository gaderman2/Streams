package weapons;

import java.util.List;

public class WeaponFinder {

    public void doAllMethods(List<Weapon> weaponList){
        System.out.println();
        System.out.println("Lowest Damage Weapon: " + findLowestDamage(weaponList));
        System.out.println("Highest Strength Weapon: " + findHighestStrength(weaponList));
        System.out.println("All Missile Weapons: " + findAllMissiles(weaponList));
        System.out.println("Longest Name Weapon: " + findLongestName(weaponList));
        System.out.println("Name List: " + transformToNameList(weaponList));
        System.out.println("Speed Array: " + transformIntoSpeedArray(weaponList));
        System.out.println("Sum of Values: " + getSumOfAllValues(weaponList));
        System.out.println("Total Hash Code: " + getTotalHashCode(weaponList));
        System.out.println("Without Duplicates: " + getListWithoutDuplicates(weaponList));
        System.out.println("Increased Value by 10%: " + increaseEachValue(weaponList));
    }

    public Weapon findLowestDamage(List<Weapon> weaponList){
        return weaponList.stream().reduce((x, y) -> x.getDamage() < y.getDamage() ? x : y).get();
    }

    public Weapon findHighestStrength(List<Weapon> weaponList){
        return weaponList.stream().reduce((x, y) -> x.getStrength() > y.getStrength() ? x : y).get();
    }

    public List<Weapon> findAllMissiles(List<Weapon> weaponList){
        return weaponList.stream().filter(x -> x.getDamageType() == DamageType.MISSILE).toList();
    }

    public Weapon findLongestName(List<Weapon> weaponList){
        return weaponList.stream().reduce((x, y) -> x.getName().length() > y.getName().length() ? x : y).get();
    }

    public List<String> transformToNameList(List<Weapon> weaponList){
        return weaponList.stream().map(Weapon::getName).toList();
    }

    public int[] transformIntoSpeedArray(List<Weapon> weaponList){
        return weaponList.stream().mapToInt(Weapon::getSpeed).toArray();
    }

    public int getSumOfAllValues(List<Weapon> weaponList){
        return weaponList.stream().mapToInt(x -> x.getValue()).reduce(0, Integer::sum);
    }

    public int getTotalHashCode(List<Weapon> weaponList){
        return weaponList.stream().mapToInt(x -> x.hashCode()).reduce(0, Integer::sum);
    }

    public List<Weapon> getListWithoutDuplicates(List<Weapon> weaponList){
        return weaponList.stream().distinct().toList();
    }

    public List<Weapon> increaseEachValue(List<Weapon> weaponList){
        return weaponList.stream().map(x -> {
            x.setValue((int) (x.getValue() * 1.1));
            return x;
        }).toList();
    }

}
