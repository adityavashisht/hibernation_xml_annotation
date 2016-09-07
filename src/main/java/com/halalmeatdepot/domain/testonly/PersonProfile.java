package com.halalmeatdepot.domain.testonly;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

/**
 * Created by sjchen on 9/7/16.
 */
@Entity
public class PersonProfile {

    @Id
    @Column(name="ID",unique=true, nullable=false)
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign",parameters=@Parameter(name="property", value="personInProfile"))
    private Long id;

    private String profileName;
    @OneToOne
    @PrimaryKeyJoinColumn
    private  Person personInProfile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public Person getPersonInProfile() {
        return personInProfile;
    }

    public void setPersonInProfile(Person personInProfile) {
        this.personInProfile = personInProfile;
    }
}
