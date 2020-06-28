package com.frans.pojo;


import org.apache.ibatis.type.Alias;

@Alias("users1")
public class Users {
    private int id;
    private int name;
    private int pwd;
    private int address;

    public Users(int id, int name, int pwd, int address) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.address = address;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name=" + name +
                ", pwd=" + pwd +
                ", address=" + address +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getPwd() {
        return pwd;
    }

    public void setPwd(int pwd) {
        this.pwd = pwd;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }
}
