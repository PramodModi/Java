package jdbcDAODemo;
import java.sql.*;
public class StudentDAO{
    Connection con = null;
    public void createConnection(){
        String url = "jdbc:mysql://localhost:3306/demo";
        String userName = "root";
        String password = "mysqlpassword";
        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Create connection and create statement
            con = DriverManager.getConnection(url, userName, password);
        }
        catch(Exception ex){
            System.out.println("In createConnection");
            ex.printStackTrace();
        }

    }
    public void closeConnection(){
        System.out.println("Closing Resources");
        //Deleting records
        String deleteQuery = "DELETE FROM students";
        if(con == null){
            return;
        }
        try {
            Statement st = con.createStatement();
            st.executeUpdate(deleteQuery);
            st.close();
            con.close();
        }
        catch(Exception ex){
            System.out.println("Exception in closeConnection");
            ex.printStackTrace();
        }
    }
    public Student getStudent(int rollno){
        Student s = new Student();
        try {
            String query = "SELECT * FROM students WHERE rollnumber = " + rollno;
            Statement st= con.createStatement();
            ResultSet rs  = st.executeQuery(query);
            rs.next();
            String name = rs.getString(2);
            s.setRollNo(rollno);
            s.setsName(name);
            rs.close();
        }
        catch(Exception ex){
            System.out.println("Exception In getStudent with roll number");
            ex.printStackTrace();
        }
        return s;
    }

    public Student getStudent(String name){
        Student s = new Student();
        try {
            String query = "SELECT * FROM student WHERE name = " + name;
            Statement st = con.createStatement();
            ResultSet rs  = st.executeQuery(query);
            rs.next();
            int rollno = rs.getInt(1);
            s.setRollNo(rollno);
            s.setsName(name);
            rs.close();
        }
        catch(Exception ex){
            System.out.println("IN getStudent with name");
            ex.printStackTrace();
        }
        return s;
    }

    public void addStudent(Student s){
        String query = "INSERT INTO students values (?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, s.getRollNo());
            ps.setString(2, s.getsName());
            ps.executeUpdate();
        }
        catch(Exception ex){
            System.out.println("Exception in addStudent");
            ex.printStackTrace();
        }

    }
}
