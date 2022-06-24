public class combat {
    public static void hpcheck() {
        //checks if ur hp is more than ur current maximum
        if (Globals.variables.hp > Globals.variables.maxhp) {
            Globals.variables.hp = Globals.variables.maxhp;
        }
    } //get_data

    public static void manacheck() {
        //checks if ur mana is more than ur current maximum
        if (Globals.variables.mana > Globals.variables.maxmana) {
            Globals.variables.mana = Globals.variables.maxmana;
        }
    } //getData

    public static void fight() {
        //start a battle, stats for enemy are in the story which are stored in Globals
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("A battle starts!");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        int dmg;
        Globals.variables.loopbattle = 0;
        while (Globals.variables.loopbattle == 0) {
            //enemy turn
            if (Globals.variables.enemyhp <= 4) {
                if (Globals.variables.enemyhppotion >= 1) {
                    System.out.println(Globals.variables.enemyname + " used a heal potion!");
                    enemyheal();
                }
            } else {
                System.out.println(Globals.variables.enemyname + " attacks!");
                int random = (int) (Math.random() * 10);
                dmg = random + Globals.variables.enemyatk;
                Globals.variables.hp = Globals.variables.hp - dmg;
                System.out.println("U took " + dmg + " damage");
            }
            deadcheck();
            //player turn
            System.out.println("U have " + Globals.variables.hp + " hp and " + Globals.variables.mana + " mana left");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("What do u want to do? 1 to attack, 2 for spell, 3 for items");
            controls controls = new controls();
            int input = controls.getInput();
            if (input == 1) {
                System.out.println("                                        \n" +
                        "  @@@@                             @@@  \n" +
                        "   @@@@@@@                    @@@@@@@   \n" +
                        "    @@@@ @@@@               @@@@ @@@    \n" +
                        "      @@@@ @@@@           @@@ @@@@      \n" +
                        "         @@@@ @@@      @@@@ @@@@        \n" +
                        "            @@@ @@@@ @@@ @@@@           \n" +
                        "              &@@@ @@@ @@@              \n" +
                        "                 @@@ @@@                \n" +
                        "              @@@ # @@@ @@              \n" +
                        "         @@  @ @@@     @@ @@ @@@        \n" +
                        "           @@@             @@           \n" +
                        "         @ ,  @@        @@@   @@@       \n" +
                        "      @                        @ #@     \n" +
                        "  @@ @                              @@@ \n" +
                        " @@@@                               @@@@\n");
                int random = (int) (Math.random() * 10);
                dmg = random + Globals.variables.atk;
                Globals.variables.enemyhp = Globals.variables.enemyhp - dmg;
                System.out.println(Globals.variables.enemyname + " took " + dmg + " damage");
            } else if (input == 2) {
                System.out.println("                                        \n" +
                        "         @        ,@         @     &(   \n" +
                        "      @@  @@      @@@@@@    @    @@  @@ \n" +
                        "         @        @@@@@@@          &(   \n" +
                        "    @         @%   @*                   \n" +
                        "     @         @                   &&   \n" +
                        "     #(     @           @@@@@      @    \n" +
                        "      @.    /            @@@@#    @     \n" +
                        "       @    (               @    @      \n" +
                        "                                        \n" +
                        "   @@@@@@@@@@@@#         #@@@@@@@@@@@@  \n" +
                        "               **@@* .@@(*              \n" +
                        "   @@@@@@@@@@@@@@@/   ,@@@@@@@@@@@@@@@  \n" +
                        "   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" +
                        "                  @@@@@                 ");
                System.out.println("What spell do u want to use? 1 for Fireball, 2 for heal");
                input = controls.getInput();
                if (input == 1) {
                    if (Globals.variables.mana >= 50) {
                        Globals.variables.mana = Globals.variables.mana - 50;
                        Globals.variables.enemyhp = Globals.variables.enemyhp - 999;
                        System.out.println("U deal 999 damage");
                    } else {
                        System.out.println("U failed at using the spell because u miss mana. 50 needed. Current mana = " + Globals.variables.mana);
                    }
                } else if (input == 2) {
                    if (Globals.variables.mana >= 10) {
                        Globals.variables.hp = Globals.variables.hp + 10;
                        System.out.println("U healed urself for 10hp");
                        hpcheck();
                    } else {
                        System.out.println("U failed at using the spell because u miss mana. 10 needed. Current mana = " + Globals.variables.mana);
                    }
                }
            } else if (input == 3) {
                System.out.println("\n" +
                        "                &&&&&&&&&@              \n" +
                        "                 &&&&&&&& &             \n" +
                        "                 &&&&&&&&  /            \n" +
                        "               & @&&&&&& .              \n" +
                        "               &                        \n" +
                        "              &          .&@            \n" +
                        "          %,                  @         \n" +
                        "        #                       @       \n" +
                        "       .  &&& .                  /.     \n" +
                        "       & &&&&&&&&&&&&&&&@&  ### & @     \n" +
                        "       / &&&&&..&&&&&&&&&&&&&&&&& &     \n" +
                        "       & &&&&&&(  &&@  &&&&&&&&&        \n" +
                        "        & @&&&&/  &&@&&&&&&&&&&/%%      \n" +
                        "         &  &&&&&&&& ,&&&&&&&% &        \n" +
                        "           &&  *&&&&&&&&&&&  &&         \n" +
                        "               #@&@(  &@&               \n");
                System.out.println("What item do u want to use? 1=hppotion 2=manapotion");
                input = controls.getInput();
                if (input == 1) {
                    if (Globals.variables.hppotion >= 1) {
                        Globals.variables.hppotion--;
                        Globals.variables.hp = Globals.variables.hp + 20;
                        System.out.println("U healed urself for 20hp.");
                        hpcheck();
                    } else {
                        System.out.println("U have no potions.");
                    }
                } else if (input == 2) {
                    if (Globals.variables.manapotion >= 1) {
                        Globals.variables.manapotion--;
                        Globals.variables.mana = Globals.variables.mana + 20;
                        System.out.println("U regained 20 mana");
                        manacheck();
                    } else {
                        System.out.println("U have no potions.");
                    }
                } else {
                    System.out.println("wrong input, turn skipped");
                }
            } else {
                System.out.println("wrong input, turn skipped");
            }
            deadenemycheck();
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    public static void enemyheal() {
        //heal class for enemy, checks in fight class how much hp and if he has hppotions
        Globals.variables.enemyhppotion--;
        Globals.variables.enemyhp = Globals.variables.enemyhp + 3;
        System.out.println(Globals.variables.enemyhppotion + "left.");
    }

    public static void deadcheck() {
        if (Globals.variables.hp <= 0) {
            Globals.variables.loopbattle++;
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("                       ______\n" +
                    "                    .-\"      \"-.\n" +
                    "                   /            \\\n" +
                    "       _          |              |          _\n" +
                    "      ( \\         |,  .-.  .-.  ,|         / )\n" +
                    "       > \"=._     | )(__/  \\__)( |     _.=\" <\n" +
                    "      (_/\"=._\"=._ |/     /\\     \\| _.=\"_.=\"\\_)\n" +
                    "             \"=._ (_     ^^     _)\"_.=\"\n" +
                    "                 \"=\\__|IIIIII|__/=\"\n" +
                    "                _.=\"| \\IIIIII/ |\"=._\n" +
                    "      _     _.=\"_.=\"\\          /\"=._\"=._     _\n" +
                    "     ( \\_.=\"_.=\"     `--------`     \"=._\"=._/ )\n" +
                    "      > _.=\"                            \"=._ <\n" +
                    "     (_/                        -            \\_)");
            System.out.println("" +
                    "                      YOU DIED!\r\n");
            while (true) {
            }
        }
    } //getData

    public static void deadenemycheck() {
        if (Globals.variables.enemyhp <= 0) {
            Globals.variables.loopbattle++;
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\r\nYOU WON!\r\n");

        }
    } //getData
}
