package com.blockworld.blockWorld.utils;

public class Logger {
    public static String prefix;

    public static void info(String message) {
        System.out.println(prefix + " [INFO] " + message);
    }
}
