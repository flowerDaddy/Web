package cn.llj.domain;

public class Person {
    private int id;
    private String name;
    private byte age;
    private String skill;
    private String school;
    private String post;
    private String password;
    public Person() {
    }

    public Person(int id, String name, byte age, String skill, String school, String post, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.skill = skill;
        this.school = school;
        this.post = post;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", skill='" + skill + '\'' +
                ", school='" + school + '\'' +
                ", post='" + post + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
