public class Student {
  private String first_name;
  private String last_name;
  private String email_id;
  private String timestamp;
  private ArrayList<int[]> preferances = new ArrayList<int[]>();

  public Student(String first, String last, String email, String time, ArrayList pref){
      first_name = first;
      last_name = last;
      email_id = email;
      timestamp = time;
      preferances = pref;
    }

  public Student(Student list){
      this.first_name = list.first_name;
      this.last_name = list.last_name;
      this.email_id = list.email_id;
      this.timestamp = list.timestamp;
    }

  public String get_first_name() {
    return first_name;
  }

  public String get_last_name() {
    return last_name;
  }

  public String get_email_id() {
    return email_id;
  }

  public String get_Time() {
    return timestamp;
  }
  
  public ArrayList get_preferances(){
    return preferances;
  }
}
