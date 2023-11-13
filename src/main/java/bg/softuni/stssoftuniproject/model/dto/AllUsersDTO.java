package bg.softuni.stssoftuniproject.model.dto;

import java.util.Set;

public class AllUsersDTO {

    private Set<UserDTO> users;

    public Set<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDTO> users) {
        this.users = users;
    }
}
