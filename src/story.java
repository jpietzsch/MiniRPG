public class story {
    public static void intro() {
        combat.hpcheck();
        combat.manacheck();
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
        controls controls = new controls();
        int input = controls.getInput();
//the classes
        if (input == 1) {
            Globals.variables.character = 1;
            Globals.variables.hp = 40;
            Globals.variables.maxhp = 40;
            System.out.println("Congratulations, u chose the Knight character!");
        } else if (input == 2) {
            Globals.variables.character = 2;
            Globals.variables.atk = 10;
            Globals.variables.maxmana = 15;
            Globals.variables.mana = 15;
            System.out.println("Congratulations, u chose the Barbarian character!");
        } else if (input == 3) {
            Globals.variables.character = 3;
            Globals.variables.maxhp = 10;
            Globals.variables.hp = 10;
            Globals.variables.maxmana = 100;
            Globals.variables.mana = 100;
            System.out.println("Congratulations, u chose the Sorcerer character!");
        } else if (input ==69){
            Globals.variables.character = 1;
            Globals.variables.atk = 50;
            Globals.variables.maxhp = 100;
            Globals.variables.hp = 100;
            Globals.variables.maxmana = 100;
            Globals.variables.mana = 100;
            System.out.println("Congratulations, u found the secret character! This game is a breeze now.");
        } else {
            Globals.variables.character = 2;
            Globals.variables.atk = 1;
            Globals.variables.maxhp = 1;
            Globals.variables.hp = 1;
            Globals.variables.maxmana = 1;
            Globals.variables.mana = 1;
            System.out.println("Cant follow a simple task? U get the dingus character, good luck.");
        }
        System.out.println("U have " + Globals.variables.hp);
        monument();
    } //introStory

    public static void monument() {
        System.out.println("From now on 1 will = yes and 2 = No, unless i specificly state controls.\r\n \r\nWell then, its time to start your adventure thru Bielefeld, a magical place in germany that seemingly doesnt exist. \r\nYou wake up in a small cramped street, u look around you." +
                "\r\nThe first thing u see is a garbage can, do u want to interact with it?");
        controls controls = new controls();
        int input = controls.getInput();
        if (input == 1) {
            int random = (int) (Math.random() * 10);
            if (random >= 5 && Globals.variables.area1racoon == 0) {
                Globals.variables.area1racoon++;
                Globals.variables.hppotion++;
                System.out.println("U look inside the bin, u see something twinkling. U reach down to grab it, while pulling it back up u see it shimmering red, u already know its a healpotion. +1hppotion");
            } else  {
                Globals.variables.hp--;
                System.out.println("U look inside the bin, u see something furry. It looks up at u and jumps, it climbs onto ur head and runs away. U take 1 damage.");
                combat.deadcheck();
            }
        }
        System.out.println("\r\nAnyways, u decide to get out of this cramped street to check where u really are. \r\nU reach a bigger street with a monument of some metal horse. \r\nAlot of people are around, but they look all so weird, they have very colorful tunics and those weird glowing squares in their hands. U truly wonder what this weird place is?\r\nDo u want to approach someone?");
        input = controls.getInput();
        if (input == 1) {
            int random = (int) (Math.random() * 10);
            if (random <= 3) {
                if (Globals.variables.character == 2) {
                    Globals.variables.hp = Globals.variables.hp - 3;
                    System.out.println("U encounter a women in red dress, u get closer to her so u can start a conversation. She finally notices u and is very disturbed, she reaches into her bag and pulls out a little tincan with markings on it. \r\nShe starts to scream something, its just gibberish. U dont understand her \r\nShe proceeds to seemingly squeeze something out of the can which hits ur face. U take 3 damage.");
                    combat.deadcheck();
                } else if (Globals.variables.area1women == 0){
                    Globals.variables.area1women++;
                    Globals.variables.manapotion++;
                    System.out.println("U encounter a women in a red dress, u get closer to her so u can start a conversation. She finally notices u and seems pretty worried, she grabs into her bag and pulls out a blue bottle. \r\nThe hero u are u already know that its a manapotion. U grab the bottle and walk away. U get a mana potion");
                } else {
                    Globals.variables.hp = Globals.variables.hp - 3;
                    System.out.println("U encounter a women in red dress, u get closer to her so u can start a conversation. She finally notices u and is very disturbed, she reaches into her bag and pulls out a little tincan with markings on it. \r\nShe starts to scream something, its just gibberish. U dont understand her \r\nShe proceeds to seemingly squeeze something out of the can which hits ur face. U take 3 damage.");
                    combat.deadcheck();
                }
            } else {
                System.out.println("U encounter a strange looking man, wearing all black. U get closer to him to start a conversation. He Notices u and starts to smile.\r\nHe walks towards u, pulling out a knife. And holds out his hands... Are u getting robbed?\r\nPress 1 to defend urself and 2 to surrender");
                input = controls.getInput();
                if (input == 1) {
                    Globals.variables.enemyhp = 20;
                    Globals.variables.enemyatk = 3;
                    Globals.variables.enemyhppotion = 0;
                    Globals.variables.enemyname = "Bandit";
                    combat.hpcheck();
                    combat.manacheck();
                    combat.fight();
                } else {
                    random = (int) (Math.random() + 10);
                    if (random <= 5) {
                        System.out.println("U start running the other direction, back to the little street u came from. \r\nU outrun him and he looses you. Quite the luck u got.");
                    } else {
                        System.out.println("U start running the other direction, back to the little street u came from. \r\nHe catches up quickly and grabs u by the shoulder.");
                        if (Globals.variables.manapotion == 0 && Globals.variables.hppotion == 0) {
                            System.out.println("He reaches throws u onto the ground and checks ur pockets... U dont have anything on u? Frustrated the guy kicks u in the side and leaves. \r\nU take 3 damage from his kick.");
                            Globals.variables.hp = Globals.variables.hp - 3;
                            combat.deadcheck();
                        } else {
                            System.out.println("He throws u onto the ground and checks ur pockets... He took everything u had and runs away. \r\nUr potions are gone");
                            Globals.variables.manapotion = 0;
                            Globals.variables.hppotion = 0;
                        }
                    }
                }
            }
        } else if (input == 2) {
            System.out.println("U decide to dont go there...");
        }
        System.out.println("\n \n \nU head in a other direction, u see a poster talking about a festival. U decide to go there.");
        Globals.variables.checkpoints = 1;
        System.out.println("Hey quick tutorial time, i decided to implement the feature to replay areas. Everytime u finish a area, it will be unlocked. Press 2 now to open the checkpoints.");
        input = controls.getInput();
        if (input == 2) {
            Globals.areas();
        }
        graveyard();
    } //story

    public static void graveyard() {
        System.out.println("The festival is at a graveyard, how odd. \nU can see some people around here, but they are all so pale, they almost look like they are dead. Are they zombies? \n");
        System.out.println("Do you want to attack the zombies?");
        controls controls = new controls();
        int input = controls.getInput();
        if (input == 1) {
            Globals.variables.enemyname = "Zombie Boy";
            Globals.variables.enemyatk = 2;
            Globals.variables.enemyhp = 15;
            combat.fight();
            Globals.variables.enemyname = "Zombie Tank";
            Globals.variables.enemyhp = 40;
            Globals.variables.enemyatk = 1;
            Globals.variables.enemyhppotion = 1;
            combat.fight();
            Globals.variables.karma = Globals.variables.karma + 15;
            System.out.println("U defeated the zombies, but why is everyone terrified and running away from u? U probably just smell bad so dont worry ¯\\_(ツ)_/¯ \nLets proceed with our adventure to find a river!");
        } else {
            System.out.println("U decide to inspect this situation a bit closer...\nThey dont seem to be aggressive towards u, who knows maybe zombies are good in this world\n");
            if (Globals.variables.area2zombiehp == 0) {
                Globals.variables.area2zombiehp++;
                System.out.println("One of the zombies hands u a red potion. +1 hppotion");
                Globals.variables.hppotion++;
            }
            System.out.println("One of the zombies reaches out to u to shake ur hand, after a quick handshake he tells u something in a weird language.\nU cant make out what hes saying but it seems like he wants u to follow him.\nDo you follow him?");
            input = controls.getInput();
            if (input == 1) {
                System.out.println("U decide to follow, he brings u to a open grave. He starts to speak some gibberish again.");
                if (Globals.variables.area2zombie == 0){
                    System.out.println("U notice that hes holding a blue bottle in his left hand.");
                }
                System.out.println("\nUr far away from the others by now, just u and him. Do u kick him down the grave?");
                input = controls.getInput();
                if (input == 1) {
                    int random = (int) (Math.random() * 10);
                    if (random <= 7) {
                        System.out.println("U kick him down no problem");
                        if (Globals.variables.area2zombie == 0){
                            Globals.variables.area2zombie++;
                            System.out.println(" pickup the bottle +1 Manapotion");
                            Globals.variables.manapotion++;
                        }
                        System.out.println("and throw a rock into the grave. He instantly dies and u decide to run away.");
                        Globals.variables.karma = Globals.variables.karma + 10;
                    } else {
                        System.out.println("U kick him, but hes standing there solid as a rock. Looking more pissed off every second. \n Well get ready to fight...");
                        Globals.variables.enemyname = "Pissed Zombie";
                        Globals.variables.enemyatk = 5;
                        Globals.variables.enemyhp = 20;
                        Globals.variables.enemyhppotion = 0;
                        combat.fight();
                        System.out.println("U managed to kill the zombie.");
                        if (Globals.variables.area2zombie == 0){
                            Globals.variables.area2zombie++;
                            System.out.println("Sadly the bottle broke.");
                        }
                        Globals.variables.karma = Globals.variables.karma + 10;
                    }
                } else {
                    System.out.println("U decide not to do it, u try talking to him but without success. U decide to walk away.\nWhile walking u see a zombie on the sidewalk, he doesnt look good completly dry and his skin is turning blue. Do u want to give gim a hppotion?");
                    input = controls.getInput();
                    if (input == 1) {
                        System.out.println("U give him a hppotion, hes super thank full. He doesnt have anything to give but he offers u a hug. U accept and get on ur way. -1 hppotion");
                        Globals.variables.zombiehelpevent = 1;
                    } else {
                        System.out.println("U decide to just walk past him, afterall its not your problem");
                        Globals.variables.karma = Globals.variables.karma + 3;

                    }
                }
            } else {
                System.out.println("U decide not to follow him, he looks somewhat dissapointed but thats ok. U walk out of the graveyard.\nWhile walking u see a zombie on the sidewalk, he doesnt look good completly dry and his skin is turning blue. Do u want to give gim a hppotion?");
                input = controls.getInput();
                if (input == 1) {
                    System.out.println("U give him a hppotion, hes super thank full. He doesnt have anything to give but he offers u a hug. U accept and get on ur way. -1 hppotion");
                    Globals.variables.zombiehelpevent = 1;
                } else {
                    System.out.println("U decide to just walk past him, afterall its not your problem");
                    Globals.variables.karma = Globals.variables.karma + 3;
                }
            }
        }
        System.out.println("\n \nWell, time for u to adventure on, to the river it is. U are stinking alot afterall, so clean up.");
        Globals.variables.checkpoints = 2;
        System.out.println("Here we are again, 2 to open the checkpoint menu. Continue if u want to tho.");
        input = controls.getInput();
        if (input == 2) {
            Globals.areas();
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
