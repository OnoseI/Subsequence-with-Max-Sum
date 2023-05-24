import java.util.*;//for scanner
import java.io.*;//for file storage and reading
public class MainA5 {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in); //scanner declaration

        //pass the path to the file as a parameter for each input file
        //create scanner object passing each .txt file for file reading.
        File file1_1 = new File("C:\\Users\\cromw\\OneDrive\\Documents\\A5.1.txt");
        Scanner sc1_1 = new Scanner(file1_1);
        File file2_1 = new File("C:\\Users\\cromw\\OneDrive\\Documents\\A5.2.txt");
        Scanner sc2_1 = new Scanner(file2_1);
        File file3_1 = new File("C:\\Users\\cromw\\OneDrive\\Documents\\A5.3.txt");
        Scanner sc3_1 = new Scanner(file3_1);
        File file4_1 = new File("C:\\Users\\cromw\\OneDrive\\Documents\\A5.4.txt");
        Scanner sc4_1 = new Scanner(file4_1);


        int length; //integer used to store element count/length
        int[] sequence; //int array used to store array of elements from file
        int choice;  //integer used to determine case in switch statement

        //prompt and scanner (input) statement for switch statement deciding which .txt file to use
        System.out.print("Enter 1 for file 1, 2 for file 2, 3 for file 3, and 4 for file 4: ");
        choice = input.nextInt();

        //switch statement for each file type. All cases are the same besides the input file passed to getArray().
        switch (choice){
            case 1:
                length = sc1_1.nextInt(); //reads first integer and stores element count as the int length
                sequence = getArray(sc1_1, length); // getArray() call passing input file and length (element count)
                System.out.print(maxSumOfIncreasingSubSequence(sequence, length)); //print the maxSumOfIncreasingSubSequence passing array and length
                break;
            case 2:
                length = sc2_1.nextInt();
                sequence = getArray(sc2_1, length);
                System.out.print(maxSumOfIncreasingSubSequence(sequence, length));
                break;
            case 3:
                length = sc3_1.nextInt();
                sequence = getArray(sc3_1, length);
                System.out.print(maxSumOfIncreasingSubSequence(sequence, length));
                break;
            case 4:
                length = sc4_1.nextInt();
                sequence = getArray(sc4_1, length);
                System.out.print(maxSumOfIncreasingSubSequence(sequence, length));
                break;
        }
    }

    //method that finds the max sum of an increasing subsequence
    public static int maxSumOfIncreasingSubSequence(int a[], int length) {
        int sum = 0; //initialize max sum to 0
        int sumOfSubSequences[] = new int[length]; //integer array designed to store sum of subsequences

        //initialize SubSequence array with values of all integers from the input array
        for (int i = 0; i < length; i++)
            sumOfSubSequences[i] = a[i];

        //compute max sum in bottom up computation
        for (int i = 1; i < length; i++)
            for (int j = 0; j < i; j++)
                if (a[i] >= a[j] && sumOfSubSequences[i] < sumOfSubSequences[j] + a[i])
                    sumOfSubSequences[i] = sumOfSubSequences[j] + a[i];

        //find max sum in sumSubSequence array
        for (int i = 0; i < length; i++)
            if (sum < sumOfSubSequences[i])
                sum = sumOfSubSequences[i];
        return sum; //return int sum
    }


    //populate array with file elements and return array
    public static int[] getArray(Scanner file, int length){
        int[] a = new int[length];
        for (int i = 0; i < length; i++)
            a[i] = file.nextInt();
        return a;
    }

}
