import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public class Global {
        //the character class can effect dialoge with npc's 1=Knight 2=Barbarian 3=Sorcerer
        public static int Class = 0;
        //stats of character
        public static int maxhp = 25;
        public static int hp = 25;
        public static int atk = 5;
        public static int maxmana = 25;
        public static int mana = 25;
        public static int hppotion = 0;
        public static int manapotion = 0;
        //enemy stats
        public static String enemyname = "...";
        public static int enemyhp = 0;
        public static int enemyatk = 0;
        public static int enemyhppotion = 0;
        public static int loopbattle = 0;
    }
    public static void hpcheck(){
        //checks if ur hp is more than ur current maximum
        if (Global.hp > Global.maxhp){
            Global.hp = Global.maxhp;
        }
        System.out.println("U have " + Global.hp);
    }
    public static void manacheck(){
        //checks if ur mana is more than ur current maximum
        if (Global.mana > Global.maxmana){
            Global.mana = Global.maxmana;
        }
        System.out.println("U have " + Global.mana);
    }

    public static void fight(){
        //start a battle, stats for enemy are pulled from interaction
        System.out.println("A battle starts!");
        int dmg = 0;
        for (Global.loopbattle = 0; Global.loopbattle == 1;) {
            //enemy turn
            if (Global.enemyhp <= 4){
                if (Global.enemyhppotion >= 1) {
                    System.out.println(Global.enemyname + " used a heal potion!");
                    enemyheal();
                }
            } else {
                System.out.println(Global.enemyname + "attacks!");
                int random = (int)(Math.random() * 100);
                dmg = random + Global.enemyatk;
                Global.hp = Global.hp - dmg;
                System.out.println("U took" + dmg + " damage");
            }
            deadcheck();
            //player turn
            System.out.println("What do u want to do? 1 to attack, 2 for spell, 3 for items");
            Scanner scan = new Scanner(System.in);
            int input;
            input = scan.nextInt();
            if (input == 1){
                int random = (int)(Math.random() * 100);
                dmg = random + Global.atk;
                Global.enemyhp = Global.enemyhp - dmg;
                System.out.println(Global.enemyname+ " took" + dmg + " damage");
                deadenemycheck();
            } else if (input == 2) {
                System.out.println("What spell do u want to use? 1 for Fireball, 2 for heal");
                input = scan.nextInt();
                if (input == 1){
                    if (Global.mana >= 50){
                        Global.mana = Global.mana - 50;
                        Global.enemyhp = Global.enemyhp - 999;
                        System.out.println("U deal 999 damage");
                        deadenemycheck();
                    } else {
                        System.out.println("U failed at using the spell because u miss mana. 50 needed. Current mana = " + Global.mana);
                    }
                } else if (input == 2) {
                    if (Global.mana == 10) {
                        Global.hp = Global.hp + 10;
                        System.out.println("U healed urself for 10hp");
                    } else {
                        System.out.println("U failed at using the spell because u miss mana. 10 needed. Current mana = " + Global.mana);
                    }
                } else if (input == 3) {
                    System.out.println("What item do u want to use? 1=hppotion 2=manapotion");
                    input = scan.nextInt();
                    if (input == 1){
                        if (Global.hppotion >= 1){
                            Global.hppotion --;
                            Global.hp = Global.hp + 20;
                            System.out.println("U healed urself for 20hp.");
                        } else {
                            System.out.println("U have no potions.");
                        }
                    } else if (input == 2) {
                        if (Global.manapotion >= 1){
                            Global.manapotion --;
                            Global.mana = Global.mana + 20;
                            System.out.println("U regained 20 mana");
                        } else {
                            System.out.println("U have no potions.");
                        }
                    } else {
                        System.out.println("wrong input, turn skipped");
                    }
                } else {
                    System.out.println("wrong input, turn skipped");
                }
            }
        }
    }

    public static void enemyheal(){
        //heal class for enemy, checks in fight class how much hp and if he has hppotions
        Global.enemyhppotion --;
        Global.enemyhp = Global.enemyhp + 3;
        System.out.println(Global.enemyhppotion + "left.");
    }

    public static void deadcheck() {
        if (Global.hp == 0) {
            Global.loopbattle ++;
            System.out.println("YOU DIED!");
            for (int deadloop = 0; deadloop == 1;) {
            }
        }
    }

    public static void deadenemycheck() {
        if (Global.enemyhp == 0) {
            Global.loopbattle ++;
            System.out.println("YOU WON!");
        }
    }

    public static void main(String[] args) {
        hpcheck();
        manacheck();
        System.out.println("Hello and welcome to my little text based Adventure game, hope ur ready. \r\nFirst of all lets pick a class, please choose ur class \r\n1=Knight 2=Barbarian 3=Sorcerer");
        Scanner scan = new Scanner(System.in);
        int input;
        input = scan.nextInt();
//the classes
        if (input == 1){
            Global.Class = 1;
            Global.hp = 40;
            Global.maxhp = 40;
            System.out.println("Congratulations, u choose the Knight Class!");
        } else if (input == 2) {
            Global.Class = 2;
            Global.atk = 10;
            Global.maxmana = 15;
            Global.mana = 15;
            System.out.println("Congratulations, u choose the Barbarian Class!");
        } else if (input == 3) {
            Global.Class = 3;
            Global.maxhp = 10;
            Global.hp = 10;
            Global.maxmana = 100;
            Global.mana = 100;
            System.out.println("Congratulations, u choose the Sorcerer Class!");
        } else {
            Global.Class = 2;
            Global.atk = 1;
            Global.maxhp = 1;
            Global.hp = 1;
            Global.maxmana = 1;
            Global.mana = 1;
            System.out.println("Cant follow a simple task? U get the dingus character, good luck.");
        }
        System.out.println("From now on 1 will = yes and 2 = No, unless i specificly state controls. U wont have the ability to go back to areas, everything is a one time event. \r\n \r\nWell then, its time to start your adventure thru Bielefeld, a magical place in germany that seemingly doesnt exist. \r\nYou wake up in a small cramped street, u look around you." +
                "\r\nThe first thing u see is a garbage can, do u want to interact with it?");
        input = scan.nextInt();
        if (input == 1){
            int random = (int)(Math.random() * 10);
            if ( random >= 5){
                Global.hp --;
                System.out.println("U look inside the bin, u see something furry. It looks up at u and jumps, it climbs onto ur head and runs away. U take 1 damage.");
            }else{
                Global.hppotion ++ ;
                System.out.println("U look inside the bin, u see something twinkling. U reach down to grab it, while pulling it back up u see it shimmering red, u already know its a healpotion. +1hppotion");
            }
        }
        System.out.println("Anyways, u decide to get out of this cramped street to check where u really are. \r\nU reach a bigger street with a monument of some metal horse. \r\nAlot of people are around, but they look all so weird, they have very colorful tunics and those weird glowing squares in their hands. U truly wonder what this weird place is?\r\nDo u want to approach someone?");
        input = scan.nextInt();
        if (input == 1){
            int random = (int)(Math.random() * 10);
            if (random == 1 ){
                if (Global.Class == 2){
                    Global.hp = Global.hp - 3;
                    System.out.println("U encounter a women in red dress, u get closer to her so u can start a conversation. She finally notices u and is very disturbed, she grabs into her bag and pulls out a little tincan with markings on it. \r\nShe starts to scream something, its just gibberish. U dont understand her \r\nShe proceeds to seemingly squeeze something out of the can which hits ur face. U take 3 damage.");
                } else {
                    Global.manapotion++;
                    System.out.println("U encounter a women in a red dress, u get closer to her so u can start a conversation. She finally notices u and seems pretty worried, she grabs into her bag and pulls out a blue bottle. \r\nThe hero u are u already know that its a manapotion. U grab the bottle and walk away. U get a mana potion");
                }
            } else {
                System.out.println("U encounter a strange looking man, wearing all black. U get closer to him to start a conversation. He Notices u and starts to smile.\r\nHe walks towards u, pulling out a knife. And holds out his hands... Are u getting robbed?\r\nPress 1 to defend urself and 2 to surrender");
                input = scan.nextInt();
                if (input == 1){

                    hpcheck();
                    manacheck();
                    fight();
                }
            }
        }
    }
    }