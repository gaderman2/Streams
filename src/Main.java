import weapons.CombatType;
import weapons.DamageType;
import weapons.Weapon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final String FILE_NAME = "weapons.csv";

    public static void main(String[] args) {
        List<Weapon> weaponList = new ArrayList<>();

       try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
           String line = br.readLine();
           while((line = br.readLine()) != null){
               String[] parts = line.split(";");

               weaponList.add(new Weapon(parts[0], CombatType.valueOf(parts[1]), DamageType.valueOf(parts[2]),
                       Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6])));
           }
       }catch (IOException e){
           System.err.println(e.toString() + " occured!");
           e.printStackTrace();
       }

       weaponList.sort((x, y) -> y.getDamage() - x.getDamage());

       Printable printable = w -> w.forEach(System.out::println);
       printable.print(weaponList);
    }
}