import weapons.CombatType;
import weapons.DamageType;
import weapons.Weapon;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    private static final String FILE_NAME = "weapons.csv";
    private static String[] categories;

    public static void main(String[] args) {
        List<Weapon> weaponList = new ArrayList<>();
        List<String[]> table = new ArrayList<>();


       /*try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
           String line = br.readLine();
           categories = line.split(";");
           while((line = br.readLine()) != null){
               String[] parts = line.split(";");

               weaponList.add(new Weapon(parts[0], CombatType.valueOf(parts[1]), DamageType.valueOf(parts[2]),
                       Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6])));
               table.add(new String[]{parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6],});
           }
       }catch (IOException e){
           System.err.println(e.toString() + " occured!");
           e.printStackTrace();
       }*/

        Stream<String> lineStream = null;
        try {
            lineStream = Files.lines(Paths.get(FILE_NAME));
            lineStream.forEach(line -> {
                String[] parts = line.split(";");

                if(!parts[0].equals("name")) {
                    weaponList.add(new Weapon(parts[0], CombatType.valueOf(parts[1]), DamageType.valueOf(parts[2]),
                            Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6])));
                    table.add(new String[]{parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6],});

                }else categories = parts;
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        weaponList.sort((x, y) -> y.getDamage() - x.getDamage());

        weaponList.sort((x, y) -> {
            if (x.getCombatType().compareTo(y.getCombatType()) != 0)
                return x.getCombatType().compareTo(y.getCombatType());
            if (x.getDamageType().compareTo(y.getDamageType()) != 0)
                return y.getCombatType().compareTo(x.getCombatType());
            return x.getName().compareTo(y.getName());
        });

        Printable printable = l -> l.forEach(System.out::println);
        printable.print(weaponList);
        System.out.println();

        Printable printable1 = l -> {
            List<Integer> lengths = new ArrayList<>();

            for (int j = 0; j < table.get(0).length; j++) {
                List<String> values = new ArrayList<>();
                for (int i = 0; i < table.size(); i++) values.add(table.get(i)[j]);

                values.add(categories[j]);
                lengths.add(getLongest(values.stream()));
            }

            System.out.println(lengthenString(" Name", lengths.get(0)) + " | " + lengthenString("CombatType", lengths.get(1)) + " | " + lengthenString("DamageType", lengths.get(2)) + " | " + lengthenString("Damage", lengths.get(3)) + " | " + lengthenString("Speed", lengths.get(4)) + " | " + lengthenString("Strength", lengths.get(5)) + " | " + lengthenString("Value", lengths.get(6)) + " | ");

            for (Weapon weapon : l) {
                printLineSeperator(lengths);
                printWeaponInTable(weapon, lengths);
            }
        };
        printable1.print(weaponList);
    }

    private static int getLongest(Stream<String> stream) {
        return stream.reduce((x, y) -> x.length() > y.length() ? x : y).get().length();
    }

    private static void printWeaponInTable(Weapon weapon, List<Integer> lengths) {
        StringBuilder builder = new StringBuilder();
        builder.append(" " + lengthenString(weapon.getName(), lengths.get(0)));
        builder.append("| ");
        builder.append(lengthenString(weapon.getCombatType().toString(), lengths.get(1)));
        builder.append(" | ");
        builder.append(lengthenString(weapon.getDamageType().toString(), lengths.get(2)));
        builder.append(" | ");
        builder.append(lengthenString(weapon.getDamage() + "", lengths.get(3)));
        builder.append(" | ");
        builder.append(lengthenString(weapon.getSpeed() + "", lengths.get(4)));
        builder.append(" | ");
        builder.append(lengthenString(weapon.getStrength() + "", lengths.get(5)));
        builder.append(" | ");
        builder.append(lengthenString(weapon.getValue() + "", lengths.get(6)));
        builder.append(" | ");

        System.out.println(builder);
    }

    private static void printLineSeperator(List<Integer> lengths) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < lengths.size(); i++) {
            for (int j = -2; j < lengths.get(i); j++) output.append("-");
            output.append("+");
        }
        output.replace(0, 1, "");
        System.out.println(output);
    }

    private static String lengthenString(String s, int length) {
        int voidCount = length - s.length();

        StringBuilder sBuilder = new StringBuilder(s);
        for (int i = 0; i < voidCount; i++) sBuilder.append(" ");
        return sBuilder.toString();
    }
}