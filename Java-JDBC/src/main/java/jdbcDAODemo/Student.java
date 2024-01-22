package jdbcDAODemo;

public class Student {
   int rollNo;
   String sName;

   public Student(){}
   public Student(int rollNo, String sName) {
        this.rollNo = rollNo;
        this.sName = sName;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
}
