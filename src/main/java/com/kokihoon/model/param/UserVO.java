package main.java.com.kokihoon.model.param;


import java.util.Date;

public class UserVO {
    
    private int IDX;
    private String ID;
    private String EMAIL;
    private String MAME;
    private String PASSWORD;
    private int GRADE;
    private Date REGDATE;
    
    public int getIDX() {
        return IDX;
    }
    public void setIDX(int iDX) {
        IDX = iDX;
    }
    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public String getEMAIL() {
        return EMAIL;
    }
    public void setEMAIL(String eMAIL) {
        EMAIL = eMAIL;
    }
    public String getMAME() {
        return MAME;
    }
    public void setMAME(String mAME) {
        MAME = mAME;
    }
    public String getPASSWORD() {
        return PASSWORD;
    }
    public void setPASSWORD(String pASSWORD) {
        PASSWORD = pASSWORD;
    }
    public int getGRADE() {
        return GRADE;
    }
    public void setGRADE(int gRADE) {
        GRADE = gRADE;
    }
    public Date getREGDATE() {
        return REGDATE;
    }
    public void setREGDATE(Date rEGDATE) {
        REGDATE = rEGDATE;
    }
 
}