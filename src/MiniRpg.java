
public class MiniRpg extends Controls{
    //the character class can effect dialoge with npc's 1=Knight 2=Barbarian 3=Sorcerer
    public static int character = 0;
    //stats of character
    private static int maxhp = 25;
    private static int hp = 25;
    private static int atk = 5;
    private static int maxmana = 25;
    private static int mana = 25;
    private static int hppotion = 0;
    private static int manapotion = 0;
    private static int karma = 0;

    //enemy  stats
    private  static String enemyname = "...";
    private  static int enemyhp = 0;
    private  static int enemyatk = 0;
    private  static int enemyhppotion = 0;

    //events  and checkpoints
    private  static int loopbattle = 0;
    private  static int checkpoints = 0;
    private  static String area1 = "The monument";
    private  static String area1check = "unavailable";
    private  static int area1racoon = 0;
    private  static int area1women = 0;
    private  static String area2 = "The graveyard";
    private  static String area2check = "unavailable";
    private  static int area2zombie = 0;
    private  static int area2zombiehp = 0;
    private  static int zombiehelpevent = 0;
    private  static String area3 = "The river";
    private  static String area3check = "unavailable";

    public MiniRpg()   {

    }
}
