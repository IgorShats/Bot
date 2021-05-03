import java.io.Serializable;

public class TeacherUser implements Serializable {
    private String chair = null; //Закрепляем за пользователем кафедру
    private String name = ""; //Закрепляем за пользователем имя
    private long userID = 0; //ID пользователя
    private String faculty = "";// факультет
    private long time;//время ожидания

    public void setChair(String chair) {
        this.chair = chair;
    }

    public String getChair() {
        return chair;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserID() {
        return userID;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public long getTime() {
        return time;
    }

    public String getName() {
        return name;
    }
}
