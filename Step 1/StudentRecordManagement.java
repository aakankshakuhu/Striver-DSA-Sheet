import java.util.Scanner;

class Student{
    String name;
    int age, rollno;
    String grade;

    Student(String name, int rollno, int age, String grade){
    this.name = name;
    this.rollno = rollno;
    this.age = age;
    this.grade = grade;
}
}

public class StudentRecordManagement{

    static Student[] students = new Student[100]; //max 100 students
    static int count = 0;

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int choice;

        while(true){
            System.out.println("----- Student Record Manager ----");
            System.out.println("1. Add Student.");
            System.out.println("2. Display all students.");
            System.out.println("3. Search by name.");
            System.out.println("4. Delete by roll no.");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1 -> addStudent(in);
                case 2 -> displayStudents();
                case 3 -> searchbyName(in);
                case 4 -> deletebyRollno(in);
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }

    public static void addStudent(Scanner in){
        if(count >= 100){
            System.out.println("Database full, cannot add more students.");
            return;
        }

        System.out.println("Student's name: ");
        String name = in.nextLine();
        System.out.println("Student's Roll no: ");
        int rollno = in.nextInt();

        for(int i = 0; i < count; i++){
            if(students[i].rollno == rollno){
                System.out.println("Roll no already exists. Retry.");
                return;
            }
        }

        System.out.println("Student's age: ");
        int age = in.nextInt();
        System.out.println("Student's Grade: ");
        String grade = in.next();

        students[count++] = new Student(name, rollno, age, grade);
    }

    public static void displayStudents(){
        if (count == 0){
            System.out.println("Sorry, no database found.");
            return;
        }

        System.out.println("---- All Student Records ----");
        for (int i = 0; i < count; i++){
            System.out.println("Name: " + students[i].name);
            System.out.println("Rollno: " + students[i].rollno);
            System.out.println("Age: " + students[i].age);
            System.out.println("Grade: " + students[i].grade);
            System.out.println("-----------------------------");
        }
    }

    public static void searchbyName(Scanner in){
        System.out.println("Enter name to be searched: ");
        String searchName = in.nextLine();
        boolean found = false;

        for(int i = 0; i < count; i++){
            if(students[i].name.equalsIgnoreCase(searchName)){
                System.out.println("Record Found: ");
                System.out.println("Name: " + students[i].name);
                System.out.println("Rollno: " + students[i].rollno);
                System.out.println("Age: " + students[i].age);
                System.out.println("Grade: " + students[i].grade);
                System.out.println("-----------------------------");
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("Student Not Found.");
        }
    }

    public static void deletebyRollno(Scanner in){
        System.out.println("Enter roll no to delete: ");
        int rollno = in.nextInt();
        boolean found = false;

        for(int i = 0; i < count; i++){
            if(students[i].rollno == rollno){
                //shift all remaining students

                for(int j = i; j < count - 1; j++){
                    students[j] = students[j+1];
                }

                students[count - 1] = null;
                count--;//database mein se ek students chla gya
                found = true;
                System.out.println("Students deleted from database successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Student Not Found.");
        }
    }

}

