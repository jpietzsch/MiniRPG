public class Globals {
    public class variables {
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

    public static void areas() {
        while (true) {
            //checks and sends u to previous areas
            if (Globals.variables.checkpoints == 1) {
                Globals.variables.area1check = Globals.variables.area1;
            } else if (Globals.variables.checkpoints == 2) {
                Globals.variables.area1check = Globals.variables.area1;
                Globals.variables.area2check = Globals.variables.area2;
            } else if (Globals.variables.checkpoints == 3) {
                Globals.variables.area1check = Globals.variables.area1;
                Globals.variables.area2check = Globals.variables.area2;
                Globals.variables.area3check = Globals.variables.area3;
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\n\nWelcome at the checkpoint system. Where would you like to travel?\n" + Globals.variables.area1check + " " + Globals.variables.area2check + " " + Globals.variables.area3check);
            controls controls = new controls();
            int input = controls.getInput();
            if (input == 1) {
                story.monument();
            } else if (input == 2) {
                if (Globals.variables.checkpoints >= 2) {
                    story.graveyard();
                } else {
                    System.out.println("u dont have this area unlocked yet.");
                }
            } else if (input == 3) {
                if (Globals.variables.checkpoints >= 3) {
                    story.river();
                } else {
                    System.out.println("u dont have this area unlocked yet.");
                }
            } else {
                System.out.println("Wrong input");
            }
        }
    } //menu

}
