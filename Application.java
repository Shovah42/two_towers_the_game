
import java.util.Scanner;

public class Application {

    private int mana;

    public void run() {
        // TODO - implement Application.run
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        System.out.println("Which test case do you want to run(press number)?");
        System.out.println("0: Exit");
        System.out.println("1: Upgrade Building");
        System.out.println("2: Build Trap");
        System.out.println("3: Build Tower");
        System.out.println("4: Tower Shoot");
        System.out.println("5: Tower kills a Character");   // ezt folytassatok, meg
        System.out.println("6: Move to trapped field");     // ertelemszeruen a switchcaset
        System.out.println("7: Character Dies");            // is
        System.out.println("8: Create Character");

        Skeleton s = new Skeleton();

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        while (i != 0) {
            switch (i) {
                case 1:
                    s.upgradeBuilding();
                    break;
                case 2:
                    s.buildTrap();
                    break;
                case 3:
                    s.buildTower();
                    break;
                case 4:
                    s.towerShoot();
                    break;
                case 5:
                    s.towerKills();
                    break;
                case 6:
                    s.move();
                    break;
                case 7:
                    s.characterDies();
                    break;
                case 8:
                    s.createCharacter();
                    break;
                default:
                    System.out.println("Wrong number");
                    break;
            }
            System.out.println();
            System.out.println("0: Exit");
            System.out.println("1: Upgrade Building");
            System.out.println("2: Build Trap");
            System.out.println("3: Build Tower");
            System.out.println("4: Tower Shoot");
            System.out.println("5: Tower kills a Character");
            System.out.println("6: Move to trapped field");
            System.out.println("7: Character Dies");
            System.out.println("8: Create Character");
            i = sc.nextInt();
        }
        sc.close();
    }

    public void init() {
        // TODO - implement Application.init
        throw new UnsupportedOperationException();
    }

    public int getMana() {
        return this.mana;
    }

    /**
     *
     * @param mana
     */
    public void setMana(int mana) {
        this.mana = mana;
    }

}
