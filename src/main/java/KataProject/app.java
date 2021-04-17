package KataProject;

public class app {
    public static void main(String[] args) {
        Babysitter jennifer = new Babysitter();

        System.out.println("Jennifer had worked from 8pm to 4 am. She tucked away Timmy at 11pm.");
        System.out.println("The total amount she earned was " + jennifer.calculatedTotalPay(8,11,4));

    }
}
