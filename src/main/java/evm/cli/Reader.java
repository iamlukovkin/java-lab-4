package evm.cli;

import java.util.Scanner;

public class Reader implements IReader {
    private static Scanner scanner;
    private static Reader reader;

    private Reader() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    public static Reader getInstance() {
        if (reader == null) {
            reader = new Reader();
        }
        return reader;
    }

    @Override
    public String readString(String message) {
        System.out.println(message);
        return scanner.next();
    }

    @Override
    public int readInteger(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    @Override
    public float readFloat(String message) {
        System.out.println(message);
        return scanner.nextFloat();
    }
}
