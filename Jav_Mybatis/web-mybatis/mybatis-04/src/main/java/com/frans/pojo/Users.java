package com.frans.pojo;


import org.apache.ibatis.type.Alias;

@Alias("users1")
public class Users {
    private int id;
    private int name;
    private int password;
    private int address;

    public Users(int id, int name, int password, int address) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
    }



    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name=" + name +
                ", password=" + password +
                ", address=" + address +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(int name) {
        this.name = name;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public int getName() {
        return name;
    }

    public int getPassword() {
        return password;
    }

    public int getAddress() {
        return address;
    }
}
