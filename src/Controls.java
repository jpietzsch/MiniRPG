import java.util.Scanner;

public class Controls {
    private Scanner scan;
    private int input;

    public Controls()  {
        scan = new Scanner(System.in);
    }

    public int getInput() {
        this.input = scan.nextInt();
        return input;
    } //controls
}
