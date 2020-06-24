package entity;

public class Avatar {
    private int userid;
    private String name;
    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
