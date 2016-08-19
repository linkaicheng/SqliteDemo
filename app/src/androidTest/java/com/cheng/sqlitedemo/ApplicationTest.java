package com.cheng.sqlitedemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.cheng.bean.Contact;
import com.cheng.dao.ContactDao;
import com.cheng.daoImpl.ContactDaoImpl;
import com.cheng.utils.DbHelper;

import java.util.List;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    private DbHelper dbHelper;
    public ApplicationTest() {

        super(Application.class);
    }
    //测试创建数据库
public void testDBCreate(){
    dbHelper=new DbHelper(getContext());
    SQLiteDatabase db=dbHelper.getWritableDatabase();

}
    //测试添加联系人
    public void testAddContact(){
        Contact contact=new Contact();
        contact.setContactCardID("454454542121212");
        contact.setContactName("cheng");
        contact.setContactPhone("454574111212");
        contact.setContactState(0);
        ContactDao dao=new ContactDaoImpl(getContext());
        long count=dao.addContact(contact);
        Log.e("TAG","****count"+count);

    }
    //测试删除联系人
     public void testDeleteContace(){
         ContactDao dao=new ContactDaoImpl(getContext());
         int count=dao.deleteContact(1);
         Log.e("TAG","***"+count);
     }
//测试更新
    public void testUpdate(){
        ContactDao contactDao=new ContactDaoImpl(getContext());
        Contact contactAA=contactDao.findById(3);
        contactAA.setContactName("ZZ");
       int count= contactDao.updateContact(contactAA);
        Log.e("TAG","***"+count);


    }
    //测试查询一个对象
    public void testFindById(){
        ContactDao contactDao=new ContactDaoImpl(getContext());
        Contact contact=contactDao.findById(3);
        Log.e("TAG",contact.toString());
    }
    public void testFindAll(){
        ContactDao conDao = new ContactDaoImpl(getContext());
        List<Contact> contacts=conDao.findAll();
        for (Contact contact:contacts) {
            Log.i("TAG","***********"+contact.toString());
        }
    }




}