package com.pirest.elas.idx.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity representing {@link com.frequency.dataservice.entity.User} roles.
 */
@Entity
@Table(name = "role")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * <p>
     *     <b>Role Authorities</b></br>
     *     <ul>
     *         <li>{@link com.frequency.dataservice.entity.Role.Authority#ROLE_ANON_USER}    : User Role for anonymous users that have not yet officially registered</li>
     *         <li>{@link com.frequency.dataservice.entity.Role.Authority#ROLE_USER}         : The default User Role</li>
     *         <li>{@link com.frequency.dataservice.entity.Role.Authority#ROLE_PARTNER_USER} : Role for Users that originated from a partner's App</li>
     *         <li>{@link com.frequency.dataservice.entity.Role.Authority#ROLE_TOOLS_USER}   : User Role for accounts that have access to tools related APIs</li>
     *         <li>{@link com.frequency.dataservice.entity.Role.Authority#ROLE_ADMIN}        : User Role for users with basic administrative permissions (e.g. CRUD endpoints for guide related entities)</li>
     *         <li>{@link com.frequency.dataservice.entity.Role.Authority#ROLE_POWER_ADMIN}  : User Role for users with higher administrative permissions than ROLE_ADMIN (e.g. CRUD endpoints for user related entities)</li>
     *         <li>{@link com.frequency.dataservice.entity.Role.Authority#ROLE_FREQ_ADMIN}   : Grants access to admin APIs restricted to internal Frequency use (e.g. associate with another partner account/app)</li>
     *         <li>{@link com.frequency.dataservice.entity.Role.Authority#ROLE_ROOT}         : Grants unrestricted usage to all APIs</li>
     *     </ul>
     * </p>
     */
//    public enum Authority {
//        ROLE_ANON_USER(1L),
//        ROLE_USER(2L),
//        ROLE_PARTNER_USER(3L),
//        ROLE_TOOLS_USER(4L),
//        ROLE_ADMIN(5L),
//        ROLE_POWER_ADMIN(6L),
//        ROLE_FREQ_ADMIN(7L),
//        ROLE_ROOT(8L);
//
//        private Long roleId;
//
//        private Authority(Long roleId) {
//            this.roleId = roleId;
//        }
//
//        public Long getRoleId() {
//            return this.roleId;
//        }
//    }

    @Id
    @Column(name = "role_id")
    private Long roleId;

    //@Enumerated(EnumType.STRING)
    //@Column(name = "name", length = 26, nullable = false, insertable = false, updatable = false)
    @Column(name = "name", length = 26, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

//    public Authority getAuthority() {
//        return authority;
//    }
//
//    public void setAuthority(Authority authority) {
//        this.authority = authority;
//    }

    public List<User> getUsers() {
        return users;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean addUser(User user) {
        if (user == null) {
            return false;
        }
        if (this.users == null) {
            this.users = new ArrayList<>();
        }
        return this.users.add(user);
    }

    public boolean removeUser(User user) {
        if (user == null || this.users == null) {
            return false;
        }

        return this.users.add(user);
    }
}
