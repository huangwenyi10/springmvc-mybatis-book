package com.ay.model;
import java.io.Serializable;
import java.util.List;

/**
 * 用户实体
 * @author Ay
 * @date  2018/04/02
 */
public class AyUser implements Serializable{

    private Integer id;
    private String name;
    private String password;
    private Integer age;
    //用户和地址一一对应，即一个用户只有一个老家地址
    private AyUserAddress ayUserAddress;

    private List<AyRole> ayRoleList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public AyUserAddress getAyUserAddress() {
        return ayUserAddress;
    }

    public void setAyUserAddress(AyUserAddress ayUserAddress) {
        this.ayUserAddress = ayUserAddress;
    }

    public List<AyRole> getAyRoleList() {
        return ayRoleList;
    }

    public void setAyRoleList(List<AyRole> ayRoleList) {
        this.ayRoleList = ayRoleList;
    }
}
