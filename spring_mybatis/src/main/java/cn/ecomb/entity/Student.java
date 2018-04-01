package cn.ecomb.entity;

/**
 * @author zhouzhigang
 * @date 2018/3/6.
 */
public class Student {
    private String sno;
    private String sname;
    private String pinyin;
    private String ssex;
    private String sbirthday;

    public String getSno() {
        return sno;
    }

    public Student setSno(String sno) {
        this.sno = sno;
        return this;
    }

    public String getSname() {
        return sname;
    }

    public Student setSname(String sname) {
        this.sname = sname;
        return this;
    }

    public String getPinyin() {
        return pinyin;
    }

    public Student setPinyin(String pinyin) {
        this.pinyin = pinyin;
        return this;
    }

    public String getSsex() {
        return ssex;
    }

    public Student setSsex(String ssex) {
        this.ssex = ssex;
        return this;
    }

    public String getSbirthday() {
        return sbirthday;
    }

    public Student setSbirthday(String sbirthday) {
        this.sbirthday = sbirthday;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sbirthday='" + sbirthday + '\'' +
                '}';
    }
}
