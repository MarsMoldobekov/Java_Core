package org.java_lesson;

public class Array {
    public boolean checkForOnesAndFours(int[] arr) {
        boolean fourExists = false;
        boolean oneExists = false;

        for (int element : arr) {
            switch (element) {
                case 1:
                    oneExists = true;
                    break;
                case 4:
                    fourExists = true;
                    break;
                default:
                    return false;
            }
        }

        return fourExists && oneExists;
    }
}
