package jdbcDAODemo;

public class MainClass {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        dao.createConnection();
        dao.addStudent(new Student(12, "Ritu"));
        dao.addStudent(new Student(13, "Pramod"));
        dao.addStudent(new Student(14, "Aarav"));
        dao.addStudent(new Student(15, "Akshita"));

        Student s3 = dao.getStudent(14);
        System.out.println("Roll Number : " + s3.getRollNo());
        System.out.println("name : " + s3.getsName());

        dao.closeConnection();
    }
}
