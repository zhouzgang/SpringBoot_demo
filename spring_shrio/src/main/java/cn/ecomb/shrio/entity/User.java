package cn.ecomb.shrio.entity;

/**
 * @author zhouzhigang
 * @date 2018/3/8.
 */
public class User {
    private String account;
    private String password;
    private String name;

    public String getAccount() {
        return account;
    }

    public User setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
}
