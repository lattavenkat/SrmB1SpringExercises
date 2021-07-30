package com.org.spring.associationmap;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
// import javax.validation.constraints.NotNull;


@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // @NotNull
    private String staffname;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private Set<StaffRoles> roles = new HashSet<>();

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public Set<StaffRoles> getStaffRoles() {
        return roles;
    }

    public void setStaffRoles(Set<StaffRoles> roles) {
        this.roles = roles;

        for(StaffRoles s : roles) {
            s.setStaff(this);
        }
    }


}
