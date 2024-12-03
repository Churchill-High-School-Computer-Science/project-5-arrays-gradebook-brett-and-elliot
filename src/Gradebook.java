public class Gradebook {

    String[] labels = { "Last", "First", "Test1", "Test2", "Quiz1", "Quiz2", "Homework1", "Homework2", "Homework3",
            "Homework4", "Homework5", "Homework6", "Homework7", "Homework8", "Homework9", "Homework10" };

    String[][] book;

    public Gradebook(String[][] b) {
        if (b.length > 0 && b[0].length == 16) {
            book = b;
        }

        else {
            System.out.println("Gradebook is not the right size. Ensure that formatting is correct.");
            book = new String[1][16];
        }
    }

    public boolean changeGrade(String lastName, String assnName, int newGrade) {
        // Your code here
        for ( int i = 0 ; i< book.length ; i++){
            if (book[i][0].equals(lastName)){
                for (int x = 0; x< labels.length;x++){
                    if (assnName.equals(labels[x])){
                        book[i][x] = Integer.toString(newGrade);
                        return true;
                    }
                    
                }
            }
        }  
        return false;   
    }

    public double findAssignmentAverage(String assnName) {
        // Your code here
        int where = -1;
        int index = 0;
        while (index < labels.length)
        {
	        if (labels[index] == assnName)
	        {
		        where = index;
	        }
	        index ++;
        }
        if (where == -1){
            return -1;
        }
        double count =0.0;
        double total =0.0;
        for (int i = 0; i < book.length; i++){
            count += 1;
            total += Double.valueOf(book[i][where]);
        }
        return total/count;
    }

    public double findStudentAverage(String lastName) {
        // Your code here
        double tests = 0.0;
        double quiz = 0.0;
        double daily = 0.0;
        for (int i = 0; i< book.length; i++){
            if (book[i][0].equals(lastName)){
                for (int x = 2; x < book[0].length; x++){
                    if (x < 4){
                        tests += Double.valueOf(book[i][x]);
                    }
                    if (x >=4 && x < 6){
                        quiz += Double.valueOf(book[i][x]);
                    }
                    if (x>=6){
                        daily += Double.valueOf(book[i][x]);
                    }
                }
            }
            }
        if (tests == 0.0 && quiz == 0.0 && daily == 0.0){
            return -1.0;
        }
        return (daily /10)*.4 + (tests /2) * .3 + (quiz /2)*.3;
    }

    public void printStudentInfo(String lastName) {
        // Your code here
        int index = 0;
        while (index < book.length)
        {
	        if (book[0][index] == lastName)
	        {
		        break;
	        }
	        index ++;
        }
        if (index == book.length){
            System.out.println("That student does not exist");
        }
        for (int i = 0; i < book[0].length; i++){
            System.out.println(labels[i] + ": " + book[index][i]);
        }
        
    }

}
