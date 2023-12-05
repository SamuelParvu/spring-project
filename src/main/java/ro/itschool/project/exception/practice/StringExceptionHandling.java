package ro.itschool.project.exception.practice;

public class StringExceptionHandling {

    public static void main(String[] args) {
        String input = "Hello";
        //              01234

        int validIndex = 2;
        int invalidIndex = 7;

        charAt(input, invalidIndex);

        int[] array = {1,7,9};

        try {
            System.out.println("Array elemet: " + array[3]);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("IndexOutOfBoundsException:" + exception.getMessage());
        }
    }

    private static void charAt(String input, int index){
        try {
            System.out.println("charater at index " + index + ": " + input.charAt(index));
        } catch (StringIndexOutOfBoundsException exceptionn) {
            System.out.println("StringIndexOutOfBoundsException was thrown: " + exceptionn.getMessage());
        }
    }
}
