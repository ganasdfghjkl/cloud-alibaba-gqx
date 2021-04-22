package com.gqx.cloud.serverone.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;
@TableName(value = "test")
public class Test implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("nacos"));
        System.out.println(new BCryptPasswordEncoder().encode("nacos"));

    }
}
