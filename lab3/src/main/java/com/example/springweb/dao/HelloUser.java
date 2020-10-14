package com.example.springweb.dao;

import org.springframework.stereotype.Service;

import java.io.Serializable;
@Service
public class HelloUser implements Serializable {
    private String id;
    private String name;
    private String password;
    private String email;
    private String question;
    private  String answer;
    private  boolean isMaster;
    private String ensure;

    public HelloUser(){
        id = null;
        name = null;
        password = null;
        email=null;
        question=null;
        answer=null;
        isMaster=false;
        ensure=null;
    }
    public HelloUser(String id,String name,String password,String email,String question,String answer,boolean isMaster,String ensure){
        this.id=id;
        this.name=name;
        this.password=password;
        this.email=email;
        this.question=question;
        this.answer=answer;
        this.isMaster=isMaster;
        this.ensure=ensure;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

    public String getQuestion(){return question;}
    public void setQuestion(String question){this.question=question;}

    public String getAnswer(){return answer;}
    public void setAnswer(String answer){this.answer=answer;}

    public boolean getIsMaster(){return isMaster;}
    public void setIsMaster(boolean isMaster){this.isMaster=isMaster;}

    public String getEnsure(){return ensure;}
    public void setEnsure(String ensure){this.ensure=ensure;}
    @Override
    public String toString() {
        return "id:"+id + ", name:" + name + ", password:" + password+", email:"+email+", question:"+question+", answer:"+answer+", isMaster:"+isMaster+", ensure:"+ensure;
    }
}
