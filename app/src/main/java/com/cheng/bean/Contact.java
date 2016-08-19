package com.cheng.bean;

/**
 * Created by cheng.
 */
public class Contact {
    private int contactId;
    private String contactName;
    private String contactCardID;

    private String contactPhone;
    private int contactState;

    public Contact(int contactId, String contactName, String contactCardID, String contactPhone, int contactState) {
        this.contactId = contactId;
        this.contactName = contactName;
        this.contactCardID = contactCardID;
        this.contactPhone = contactPhone;
        this.contactState = contactState;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", contactName='" + contactName + '\'' +
                ", contactCardID='" + contactCardID + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactState=" + contactState +
                '}';
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactCardID() {
        return contactCardID;
    }

    public void setContactCardID(String contactCardID) {
        this.contactCardID = contactCardID;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public int getContactState() {
        return contactState;
    }

    public void setContactState(int contactState) {
        this.contactState = contactState;
    }
}
