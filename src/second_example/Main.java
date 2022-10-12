package second_example;

import weapons.Weapon;
import weapons.WeaponFinder;

import java.util.Arrays;
import java.util.List;

public class Main {

    private static final String FILE_NAME = "C:\\Users\\user\\Documents\\Schule\\3. Klasse\\POS\\Streams\\weapons.csv";

    public static void main(String[] args){
        StreamModifier modifier = new StreamModifier();

        int[] numbers = new int[1000];
        for(int i = 0; i < numbers.length; i++) numbers[i] = (int) (Math.random() * 101);
        System.out.println(modifier.average(numbers));

        String[] strings = new String[10];
        for(int i = 0; i < strings.length; i++) {
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < 10; j++) builder.append((char) ((int) (Math.random() * 128)));
            strings[i] = builder.toString();
        }
        modifier.upperCase(strings).forEach(System.out::println);

        List<Weapon> weaponList = Weapon.readFile(FILE_NAME);
        WeaponFinder weaponFinder = new WeaponFinder();
        weaponFinder.doAllMethods(weaponList);

    }

}
