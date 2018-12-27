package cn.ecomb.kafka;

/**
 * @author zhouzg
 * @date 2018/9/25
 */
public class Message {
    private Integer id;
    private String msg;

    public Message() {
    }

    public Message(Integer id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                '}';
    }
}
