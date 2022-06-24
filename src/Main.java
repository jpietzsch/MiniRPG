import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public class Global {
        //the character class can effect dialoge with npc's 1=Knight 2=Barbarian 3=Sorcerer
        public static int character = 0;
        //stats of character
        public static int maxhp = 25;
        public static int hp = 25;
        public static int atk = 5;
        public static int maxmana = 25;
        public static int mana = 25;
        public static int hppotion = 0;
        public static int manapotion = 0;
        public static int karma = 0;
        //enemy stats
        public static String enemyname = "...";
        public static int enemyhp = 0;
        public static int enemyatk = 0;
        public static int enemyhppotion = 0;
        //events and checkpoints
        public static int loopbattle = 0;
        public static int zombiehelpevent = 0;
        public static int checkpoints = 0;
        public static String area1 = "The monument";
        public static String area1check = "unavailable";
        public static int area1racoon = 0;
        public static int area1women = 0;
        public static String area2 = "The graveyard";
        public static String area2check = "unavailable";
        public static int area2zombie = 0;
        public static int area2zombiehp = 0;
        public static String area3 = "The river";
        public static String area3check = "unavailable";


    }

    private static int getInput() {
        Scanner scan = new Scanner(System.in);
        int input;
        input = scan.nextInt();
        return input;
    } //controls
    
    public static void areas() {
        while (true) {
            //checks and sends u to previous areas
            if (Global.checkpoints == 1) {
                Global.area1check = Global.area1;
            } else if (Global.checkpoints == 2) {
                Global.area1check = Global.area1;
                Global.area2check = Global.area2;
            } else if (Global.checkpoints == 3) {
                Global.area1check = Global.area1;
                Global.area2check = Global.area2;
                Global.area3check = Global.area3;
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\n\nWelcome at the checkpoint system. Where would you like to travel?\n" + Global.area1check + " " + Global.area2check + " " + Global.area3check);
            int input = getInput();
            if (input == 1) {
                monument();
            } else if (input == 2) {
                if (Global.checkpoints >= 2) {
                    graveyard();
                } else {
                    System.out.println("u dont have this area unlocked yet.");
                }
            } else if (input == 3) {
                if (Global.checkpoints >= 3) {
                    river();
                } else {
                    System.out.println("u dont have this area unlocked yet.");
                }
            } else {
                System.out.println("Wrong input");
            }
        }
    } //menu

    public static void hpcheck() {
        //checks if ur hp is more than ur current maximum
        if (Global.hp > Global.maxhp) {
            Global.hp = Global.maxhp;
        }
    } //get_data

    public static void manacheck() {
        //checks if ur mana is more than ur current maximum
        if (Global.mana > Global.maxmana) {
            Global.mana = Global.maxmana;
        }
    } //getData

    public static void fight() {
        //start a battle, stats for enemy are pulled from interaction
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("A battle starts!");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        int dmg = 0;
        Global.loopbattle = 0;
        while (Global.loopbattle == 0) {
            //enemy turn
            if (Global.enemyhp <= 4) {
                if (Global.enemyhppotion >= 1) {
                    System.out.println(Global.enemyname + " used a heal potion!");
                    enemyheal();
                }
            } else {
                System.out.println(Global.enemyname + " attacks!");
                int random = (int) (Math.random() * 10);
                dmg = random + Global.enemyatk;
                Global.hp = Global.hp - dmg;
                System.out.println("U took " + dmg + " damage");
            }
            deadcheck();
            //player turn
            System.out.println("U have " + Global.hp + " hp and " + Global.mana + " mana left");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("What do u want to do? 1 to attack, 2 for spell, 3 for items");
            new Scanner(System.in);
            int input;
            input = getInput();
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
                dmg = random + Global.atk;
                Global.enemyhp = Global.enemyhp - dmg;
                System.out.println(Global.enemyname + " took " + dmg + " damage");
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
                input = getInput();
                if (input == 1) {
                    if (Global.mana >= 50) {
                        Global.mana = Global.mana - 50;
                        Global.enemyhp = Global.enemyhp - 999;
                        System.out.println("U deal 999 damage");
                    } else {
                        System.out.println("U failed at using the spell because u miss mana. 50 needed. Current mana = " + Global.mana);
                    }
                } else if (input == 2) {
                    if (Global.mana >= 10) {
                        Global.hp = Global.hp + 10;
                        System.out.println("U healed urself for 10hp");
                        hpcheck();
                    } else {
                        System.out.println("U failed at using the spell because u miss mana. 10 needed. Current mana = " + Global.mana);
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
                input = getInput();
                if (input == 1) {
                    if (Global.hppotion >= 1) {
                        Global.hppotion--;
                        Global.hp = Global.hp + 20;
                        System.out.println("U healed urself for 20hp.");
                        hpcheck();
                    } else {
                        System.out.println("U have no potions.");
                    }
                } else if (input == 2) {
                    if (Global.manapotion >= 1) {
                        Global.manapotion--;
                        Global.mana = Global.mana + 20;
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
        Global.enemyhppotion--;
        Global.enemyhp = Global.enemyhp + 3;
        System.out.println(Global.enemyhppotion + "left.");
    }

    public static void deadcheck() {
        if (Global.hp <= 0) {
            Global.loopbattle++;
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
        if (Global.enemyhp <= 0) {
            Global.loopbattle++;
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\r\nYOU WON!\r\n");

        }
    } //getData

    public static void main(String[] args) {
        intro();
        monument();
    }

    public static void intro() {
        hpcheck();
        manacheck();
        System.out.println("Hello and welcome to my little text based Adventure game, hope ur ready. \r\nFirst of all lets pick a class, please choose ur class \r\n1=Knight 2=Barbarian 3=Sorcerer");
        System.out.println("                                        \n" +
                "    @@ _     @@@@@@@@@@         @@@@    \n" +
                "   @   @@@@               @@@ @     @   \n" +
                "   @   @                      @@   @@   \n" +
                "    @@@                          @ @    \n" +
                "    @.                            @     \n" +
                "    @ @@@@@        @@@@@@          @    \n" +
                "   &@                              @    \n" +
                "   @                                @   \n" +
                "   @        @@    @                 @   \n" +
                "   @          @@@^                  @   \n" +
                "  (@                                 @  \n" +
                "  @         __   ___        #@_      @  \n" +
                "  @@@@@  @@    @     @@ @@*     @@@@@   \n" +
                "                                        \n");
        int input = getInput();
//the classes
        if (input == 1) {
            Global.character = 1;
            Global.hp = 40;
            Global.maxhp = 40;
            System.out.println("Congratulations, u chose the Knight character!");
        } else if (input == 2) {
            Global.character = 2;
            Global.atk = 10;
            Global.maxmana = 15;
            Global.mana = 15;
            System.out.println("Congratulations, u chose the Barbarian character!");
        } else if (input == 3) {
            Global.character = 3;
            Global.maxhp = 10;
            Global.hp = 10;
            Global.maxmana = 100;
            Global.mana = 100;
            System.out.println("Congratulations, u chose the Sorcerer character!");
        } else if (input ==69){
            Global.character = 1;
            Global.atk = 50;
            Global.maxhp = 100;
            Global.hp = 100;
            Global.maxmana = 100;
            Global.mana = 100;
            System.out.println("Congratulations, u found the secret character! This game is a breeze now.");
        } else {
            Global.character = 2;
            Global.atk = 1;
            Global.maxhp = 1;
            Global.hp = 1;
            Global.maxmana = 1;
            Global.mana = 1;
            System.out.println("Cant follow a simple task? U get the dingus character, good luck.");
        }
        System.out.println("U have " + Global.hp);
    } //introStory

    public static void monument() {
        int input;
        System.out.println("From now on 1 will = yes and 2 = No, unless i specificly state controls.\r\n \r\nWell then, its time to start your adventure thru Bielefeld, a magical place in germany that seemingly doesnt exist. \r\nYou wake up in a small cramped street, u look around you." +
                "\r\nThe first thing u see is a garbage can, do u want to interact with it?");
        input = getInput();
        if (input == 1) {
            int random = (int) (Math.random() * 10);
            if (random >= 5 && Global.area1racoon == 0) {
                Global.area1racoon++;
                Global.hppotion++;
                System.out.println("U look inside the bin, u see something twinkling. U reach down to grab it, while pulling it back up u see it shimmering red, u already know its a healpotion. +1hppotion");
            } else  {
                Global.hp--;
                System.out.println("U look inside the bin, u see something furry. It looks up at u and jumps, it climbs onto ur head and runs away. U take 1 damage.");
                deadcheck();
            }
        }
        System.out.println("\r\nAnyways, u decide to get out of this cramped street to check where u really are. \r\nU reach a bigger street with a monument of some metal horse. \r\nAlot of people are around, but they look all so weird, they have very colorful tunics and those weird glowing squares in their hands. U truly wonder what this weird place is?\r\nDo u want to approach someone?");
        input = getInput();
        if (input == 1) {
            int random = (int) (Math.random() * 10);
            if (random <= 3) {
                if (Global.character == 2) {
                    Global.hp = Global.hp - 3;
                    System.out.println("U encounter a women in red dress, u get closer to her so u can start a conversation. She finally notices u and is very disturbed, she reaches into her bag and pulls out a little tincan with markings on it. \r\nShe starts to scream something, its just gibberish. U dont understand her \r\nShe proceeds to seemingly squeeze something out of the can which hits ur face. U take 3 damage.");
                    deadcheck();
                } else if (Global.area1women == 0){
                    Global.area1women++;
                    Global.manapotion++;
                    System.out.println("U encounter a women in a red dress, u get closer to her so u can start a conversation. She finally notices u and seems pretty worried, she grabs into her bag and pulls out a blue bottle. \r\nThe hero u are u already know that its a manapotion. U grab the bottle and walk away. U get a mana potion");
                } else {
                    Global.hp = Global.hp - 3;
                    System.out.println("U encounter a women in red dress, u get closer to her so u can start a conversation. She finally notices u and is very disturbed, she reaches into her bag and pulls out a little tincan with markings on it. \r\nShe starts to scream something, its just gibberish. U dont understand her \r\nShe proceeds to seemingly squeeze something out of the can which hits ur face. U take 3 damage.");
                    deadcheck();
                }
            } else {
                System.out.println("U encounter a strange looking man, wearing all black. U get closer to him to start a conversation. He Notices u and starts to smile.\r\nHe walks towards u, pulling out a knife. And holds out his hands... Are u getting robbed?\r\nPress 1 to defend urself and 2 to surrender");
                input = getInput();
                if (input == 1) {
                    Global.enemyhp = 20;
                    Global.enemyatk = 3;
                    Global.enemyhppotion = 0;
                    Global.enemyname = "Bandit";
                    hpcheck();
                    manacheck();
                    fight();
                } else {
                    random = (int) (Math.random() + 10);
                    if (random <= 5) {
                        System.out.println("U start running the other direction, back to the little street u came from. \r\nU outrun him and he looses you. Quite the luck u got.");
                    } else {
                        System.out.println("U start running the other direction, back to the little street u came from. \r\nHe catches up quickly and grabs u by the shoulder.");
                        if (Global.manapotion == 0 && Global.hppotion == 0) {
                            System.out.println("He reaches throws u onto the ground and checks ur pockets... U dont have anything on u? Frustrated the guy kicks u in the side and leaves. \r\nU take 3 damage from his kick.");
                            Global.hp = Global.hp - 3;
                            deadcheck();
                        } else {
                            System.out.println("He throws u onto the ground and checks ur pockets... He took everything u had and runs away. \r\nUr potions are gone");
                            Global.manapotion = 0;
                            Global.hppotion = 0;
                        }
                    }
                }
            }
        } else if (input == 2) {
            System.out.println("U decide to dont go there...");
        }
        System.out.println("\n \n \nU head in a other direction, u see a poster talking about a festival. U decide to go there.");
        Global.checkpoints = 1;
        System.out.println("Hey quick tutorial time, i decided to implement the feature to replay areas. Everytime u finish a area, it will be unlocked. Press 2 now to open the checkpoints.");
        input = getInput();
        if (input == 2) {
            areas();
        }
        graveyard();
    } //story

    public static void graveyard() {
        System.out.println("The festival is at a graveyard, how odd. \nU can see some people around here, but they are all so pale, they almost look like they are dead. Are they zombies? \n");
        System.out.println("Do you want to attack the zombies?");
        int input;
        input = getInput();
        if (input == 1) {
            Global.enemyname = "Zombie Boy";
            Global.enemyatk = 2;
            Global.enemyhp = 15;
            fight();
            Global.enemyname = "Zombie Tank";
            Global.enemyhp = 40;
            Global.enemyatk = 1;
            Global.enemyhppotion = 1;
            fight();
            Global.karma = Global.karma + 15;
            System.out.println("U defeated the zombies, but why is everyone terrified and running away from u? U probably just smell bad so dont worry ¯\\_(ツ)_/¯ \nLets proceed with our adventure to find a river!");
        } else {
            System.out.println("U decide to inspect this situation a bit closer...\nThey dont seem to be aggressive towards u, who knows maybe zombies are good in this world\n");
            if (Global.area2zombiehp == 0) {
                Global.area2zombiehp++;
                System.out.println("One of the zombies hands u a red potion. +1 hppotion");
                Global.hppotion++;
            }
            System.out.println("One of the zombies reaches out to u to shake ur hand, after a quick handshake he tells u something in a weird language.\nU cant make out what hes saying but it seems like he wants u to follow him.\nDo you follow him?");
            input = getInput();
            if (input == 1) {
                System.out.println("U decide to follow, he brings u to a open grave. He starts to speak some gibberish again.");
                if (Global.area2zombie == 0){
                    System.out.println("U notice that hes holding a blue bottle in his left hand.");
                }
                System.out.println("\nUr far away from the others by now, just u and him. Do u kick him down the grave?");
                input = getInput();
                if (input == 1) {
                    int random = (int) (Math.random() * 10);
                    if (random <= 7) {
                        System.out.println("U kick him down no problem");
                        if (Global.area2zombie == 0){
                            Global.area2zombie++;
                            System.out.println(" pickup the bottle +1 Manapotion");
                            Global.manapotion++;
                        }
                        System.out.println("and throw a rock into the grave. He instantly dies and u decide to run away.");
                        Global.karma = Global.karma + 10;
                    } else {
                        System.out.println("U kick him, but hes standing there solid as a rock. Looking more pissed off every second. \n Well get ready to fight...");
                        Global.enemyname = "Pissed Zombie";
                        Global.enemyatk = 5;
                        Global.enemyhp = 20;
                        Global.enemyhppotion = 0;
                        fight();
                        System.out.println("U managed to kill the zombie.");
                        if (Global.area2zombie == 0){
                            Global.area2zombie++;
                            System.out.println("Sadly the bottle broke.");
                        }
                        Global.karma = Global.karma + 10;
                    }
                } else {
                    System.out.println("U decide not to do it, u try talking to him but without success. U decide to walk away.\nWhile walking u see a zombie on the sidewalk, he doesnt look good completly dry and his skin is turning blue. Do u want to give gim a hppotion?");
                    input = getInput();
                    if (input == 1) {
                        System.out.println("U give him a hppotion, hes super thank full. He doesnt have anything to give but he offers u a hug. U accept and get on ur way. -1 hppotion");
                        Global.zombiehelpevent = 1;
                    } else {
                        System.out.println("U decide to just walk past him, afterall its not your problem");
                        Global.karma = Global.karma + 3;

                    }
                }
            } else {
                System.out.println("U decide not to follow him, he looks somewhat dissapointed but thats ok. U walk out of the graveyard.\nWhile walking u see a zombie on the sidewalk, he doesnt look good completly dry and his skin is turning blue. Do u want to give gim a hppotion?");
                input = getInput();
                if (input == 1) {
                    System.out.println("U give him a hppotion, hes super thank full. He doesnt have anything to give but he offers u a hug. U accept and get on ur way. -1 hppotion");
                    Global.zombiehelpevent = 1;
                } else {
                    System.out.println("U decide to just walk past him, afterall its not your problem");
                    Global.karma = Global.karma + 3;
                }
            }
        }
        System.out.println("\n \nWell, time for u to adventure on, to the river it is. U are stinking alot afterall, so clean up.");
        Global.checkpoints = 2;
        System.out.println("Here we are again, 2 to open the checkpoint menu. Continue if u want to tho.");
        input = getInput();
        if (input == 2) {
            areas();
        }
        river();

    } //story

    public static void river(){
        System.out.println("end");
        System.out.println("                                                                                \n" +
                "                                ,@&@@@@@@@@@                                    \n" +
                "                             &*&&&& KEK @@&((&#                                \n" +
                "                            @&&&#(((#@////@&#(((@                               \n" +
                "                            @&&&&        ,&@//&%&                               \n" +
                "                             &&             &&&&@                               \n" +
                "                            &&          @@  #&//#&                              \n" +
                "                          &&,,,,,,,&        #%////*@                            \n" +
                "                    ,&&(,,,,,,,,,,,@&       @//(@&%                             \n" +
                "                   @.,,,,,,,,,,,,,&&       @                                    \n" +
                "                               *&         &                                     \n" +
                "                                 &       @,                                     \n" +
                "                                 &       &                                      \n" +
                "                                &,       /@              @&  @(                 \n" +
                "                               &           &           &     *@                 \n" +
                "                            @@               &@.      &     &@@  &/             \n" +
                "                         &*                        /@@     @    .&              \n" +
                "                      &.                               @  ,&  &*&&              \n" +
                "                    @                   @                 #  @ *&               \n" +
                "                   &                  @                     @&                  \n" +
                "                  &.                 a                    .&..&                 \n" +
                "                  @                   a              @        @(                \n" +
                "                  *&                    @ @aapppaa@@         @                  \n" +
                "                   &                                       &/                   \n" +
                "                    &@a_                                .&(                     \n" +
                "                        @&@@aa                       @&&                        \n" +
                "                              &&,@a@a@a@a@a@a@a@  %&                            \n" +
                "                               #,&         &,&                                  \n" +
                "                              ,@&        &(&/                                   \n" +
                "                         &#(&@&% #&&&,.,((&&&##                                   ");
    } //story
}    
