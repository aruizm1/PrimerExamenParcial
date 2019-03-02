package com.singular.blogapi.blogapi.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    private String title;
    private String text;
    private String imagen;
    private boolean status;
    private Timestamp timestamp;

    @ManyToMany
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "post_like",
            joinColumns = @JoinColumn(name = "posts_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "likes_id", referencedColumnName = "id"))
    private Set<Enjoy> enjoys = new HashSet<>();

    @ManyToMany
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(name = "posts_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tags_id", referencedColumnName = "id"))
    private Set<Tag> tagsPost = new HashSet<>();

    @OneToMany
    private Set<Comment> comments = new HashSet<>();

    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Set<Enjoy> getEnjoys() {
        return enjoys;
    }

    public void setEnjoys(Set<Enjoy> enjoys) {
        this.enjoys = enjoys;
    }

    public Set<Tag> getTagsPost() {
        return tagsPost;
    }

    public void setTagsPost(Set<Tag> tagsPost) {
        this.tagsPost = tagsPost;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
