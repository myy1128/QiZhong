package com.example.myy.qizhong;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DbBean {
    @Id(autoincrement = true)
    private Long id;

    @Property
    private String img;

    @Property
    private String title;

    @Generated(hash = 1227249784)
    public DbBean(Long id, String img, String title) {
        this.id = id;
        this.img = img;
        this.title = title;
    }

    @Generated(hash = 1953169116)
    public DbBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
