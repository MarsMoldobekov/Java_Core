package ru.android;

public class Main {
    private static class MyArraySizeException extends Exception {
        private final String MESSAGE;

        public MyArraySizeException(String message) {
            super(message);
            this.MESSAGE = message;
        }

        @Override
        public String toString() {
            return "MyArraySizeException{" +
                    "error='" + MESSAGE + '\'' +
                    '}';
        }
    }

    private static class MyArrayDataException extends Exception {
        private final String MESSAGE;

        public MyArrayDataException(String message) {
            super(message);
            this.MESSAGE = message;
        }

        @Override
        public String toString() {
            return "MyArrayDataException{" +
                    "error='" + MESSAGE + '\'' +
                    '}';
        }
    }

    private static final int ARRAY_SIZE = 4;

    public static void main(String[] args) {
        String[][] array = {
                {"1", "9", "2", "3"},
                {"1", "9", "2", "Word"},
                {"1", "9", "2", "3"},
                {"1", "9", "2", "3"}
        };

        String[][] normalArray = {
                {"1", "9", "2", "3"},
                {"1", "9", "2", "3"},
                {"1", "9", "2", "3"},
                {"1", "9", "2", "3"}
        };

        try {
            int sum = sumArrayElements(normalArray);
            System.out.printf("Сумма элементов правильного массива %d.\n", sum);

            sum = sumArrayElements(array);
            System.out.printf("Сумма элементов неправильного массива %d.\n", sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (checkArraySize(array)) {
            throw new MyArraySizeException("Неправильный размер массива.");
        }

        int result = 0;

        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE; j++) {
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            String.format("Элемент массива в индексе [%d:%d] не может быть приведён в целочисленный.", i, j)
                    );
                }
            }
        }

        return result;
    }

    private static boolean checkArraySize(String[][] array) {
        return !(array.length == ARRAY_SIZE && array[0].length == ARRAY_SIZE);
    }
}
