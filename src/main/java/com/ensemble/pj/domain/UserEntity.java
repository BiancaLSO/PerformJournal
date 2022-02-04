package com.ensemble.pj.domain;


import com.ensemble.pj.dto.Role;
import com.ensemble.pj.dto.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private boolean active;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    @Column(name="role")
    @CollectionTable(name = "userrole", joinColumns=@JoinColumn(name="userId"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"userId", "role"}))
    @Getter @Setter
    private List<Role> roles = new ArrayList<>();

    public static User toUser(UserEntity userEntity) {
        if(userEntity == null)
            return null;

        User user = new User();

        user.setId(userEntity.getIdString());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setUsername(userEntity.getUsername());
        user.setActive(userEntity.isActive());
        user.setCreatedAt(userEntity.formattedCreatedAt());
        user.setModifiedAt(userEntity.formattedModifiedAt());
        user.setRoles(userEntity.getRoles());

        return user;
    }

}
