package net.bruty.session_one.Static;

public class MobileDevice {
    private static int volume;

    public static void maxVolume() {
        volume = 100;
        printVolume();
    }

    public static void halfVolume() {
        volume = 50;
        printVolume();
    }

    private static void printVolume() {
        System.out.println("Volume: \t" + volume);
    }
}
