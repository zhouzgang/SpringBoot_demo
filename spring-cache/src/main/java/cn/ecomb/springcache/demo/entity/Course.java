package cn.ecomb.springcache.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhouzhigang on 2017/11/7.
 */
@Entity
public class Course implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
