package com.cheng.dao;

import com.cheng.bean.Contact;

import java.util.List;

/**
 * Created by cheng.
 */
public interface ContactDao {
    //添联系人
    public long addContact(Contact contact);
    //删除
    public int deleteContact(int id);
    //修改
    public int updateContact(Contact contact);
    //查询一条记录
    public Contact findById(int id);
    //查询所有记录
    public List<Contact> findAll();
}
