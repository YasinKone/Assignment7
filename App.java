import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.io.*;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Option 1: make an array");
        System.out.println("Option 2: Sort existing array");

        int choice = scanner.nextInt();

        if(choice == 1){
            System.out.print("Enter array length: ");
            int length = scanner.nextInt();
            scanner.nextLine();

            System.out.println("What would ypou like your array to be called?");
            String filename = scanner.nextLine();

            int [] array = createRandomArray(length);

            writeArrayToFile(array, filename + ".txt");
            System.out.println("Your array was saved as " + filename + ".txt");
        }

        else if(choice == 2){
            System.out.println("Enter name of file you want to sort");

            scanner.nextLine();

            String fileToSort = scanner.nextLine();
            int [] array = readFileToArray(fileToSort);

            bubbleSort(array);
            writeArrayToFile(array, fileToSort);

            System.out.println(fileToSort + " has been sorted");
        }
        scanner.close();
    }

    public static int[] createRandomArray(int arrayLength){
int[] array = new int[arrayLength];
Random random = new Random();

for(int i = 0; i < arrayLength; i++){
    array[i] = random.nextInt(101);


}
return array;
    }

public static void writeArrayToFile(int [] array, String filename) throws IOException {
   try(PrintWriter writer = new PrintWriter(new FileWriter(filename))){
        for(int num : array){
            writer.println(num);
        }
    }
}

public static int[] readFileToArray(String filename) throws FileNotFoundException {
Scanner scanner = new Scanner(new File(filename));
List<Integer> list = new ArrayList<>();
while(scanner.hasNextInt()){
    list.add(scanner.nextInt());
}
scanner.close();
return list.stream().mapToInt(i -> i).toArray();
}

public static void bubbleSort(int[] array){
   boolean swap = true;
   while(swap){

    swap = false;
   for(int i = 0; i < array.length - 1 ;i++){ if(array[i] > array[i + 1]){
    swap = true;
    int temp = array[i];
    array[i] = array[i + 1];
    array[i + 1] = temp;
}
   }
       
    }
}
}



    

