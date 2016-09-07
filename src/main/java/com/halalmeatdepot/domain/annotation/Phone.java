package com.halalmeatdepot.domain.annotation;

import javax.persistence.Embeddable;

/**
 * Created by vashishta on 9/3/16.
 */
@Embeddable
public class Phone {

    private String home;
    private String mobile;
    private String work;

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
