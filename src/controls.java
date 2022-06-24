import java.util.Scanner;
public class controls {
    private int input;
    private Scanner scan;
    public controls() {
        scan = new Scanner(System.in);
    }
    public int getInput() {
        this.input = scan.nextInt();
        return input;
    } //controls
}