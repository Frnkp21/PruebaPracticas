package DTO;


import Entities.User;

public class UserDto {
    private Integer id;
    private String name;

    public UserDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public UserDto(User user){

    }

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


}



