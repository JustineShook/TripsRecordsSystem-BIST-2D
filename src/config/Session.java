/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author mypc
 */
public class Session {
    
    private static Session instance;
    private int uid;
    private String cname;
    private String ucnumber;
    private String email;
    private String username;
    private String type;
    private String status;
    
    private Session(){
        
    }
    public static synchronized Session getInstance() {
        if(instance == null){
            instance = new  Session();
        }
        return instance;
    }

    public static boolean isInstanceEmpty(Session instance) {
        return instance == null;
    }
    
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
    
    
    public String getUcnumber() {
        return ucnumber;
    }

    public void setUcnumber(String ucnumber) {
        this.ucnumber = ucnumber;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    private String imagePath;

    public String getImagePath() {
    return imagePath;
    }

    public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
}
    
    
}
