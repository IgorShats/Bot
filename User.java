import java.io.Serializable;

public class User implements Serializable {
    private String group = ""; //Закрепляем за пользователем группу
    private long userID = 0; //ID пользователя
    private String faculty = "";// факультет
    private long time;//время ожидания

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public void setTime(long time) {
        this.time = time;
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

}
