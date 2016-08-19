package com.cheng.daoImpl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cheng.bean.Contact;
import com.cheng.dao.ContactDao;
import com.cheng.utils.DbHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 2016/8/19 0019.
 */
public class ContactDaoImpl implements ContactDao {
    private DbHelper dbHelper;
public ContactDaoImpl(Context context){
    dbHelper=new DbHelper(context);

}

    @Override
    public long addContact(Contact contact) {//添加
        SQLiteDatabase database=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("contactName",contact.getContactName());
        values.put("contactCardID",contact.getContactCardID());
        values.put("contactPhone",contact.getContactPhone());
        values.put("contactState",contact.getContactState());
        long count=database.insert("contact",null,values);
        database.close();
        return count;
    }

    @Override
    public int deleteContact(int id) {//删除
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        int count=db.delete("contact","contactId=?",new String[]{String.valueOf(id)});
        db.close();
        return count;
    }

    @Override
    public int updateContact(Contact contact) {//修改
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("contactName",contact.getContactName());
        values.put("contactCardID",contact.getContactCardID());
        values.put("contactPhone",contact.getContactPhone());
        values.put("contactState",contact.getContactState());
        int count=db.update("contact",values,"contactId=?",
                new String[]{String.valueOf(contact.getContactId())});
        db.close();
        return count;
    }

    @Override
    public Contact findById(int id) {
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Contact contact=null;
        String sql="select * from contact where contactId=?";
        Cursor cursor=db.rawQuery(sql,new String[]{String.valueOf(id)});
        if(cursor.moveToNext()){
            String contactName=cursor.getString(cursor.getColumnIndex("contactName"));
            String contactCardID=cursor.getString(cursor.getColumnIndex("contactCardID"));
            String contactPhone=cursor.getString(cursor.getColumnIndex("contactPhone"));
            int contactState=cursor.getInt(cursor.getColumnIndex("contactState"));
            contact=new Contact(id,contactName,contactCardID,contactPhone,contactState);
        }
        return contact;
    }

    @Override
    public List<Contact> findAll() {//查找所有
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Contact contact=null;
        List<Contact> contacts=new ArrayList<Contact>();
        Cursor cursor=db.query("contact",null,null,null,null,null,null);
        while(cursor.moveToNext()){
            int contactId=cursor.getInt(cursor.getColumnIndex("contactId"));
            String contactName=cursor.getString(cursor.getColumnIndex("contactName"));
            String contactCardID=cursor.getString(cursor.getColumnIndex("contactCardID"));
            String contactPhone=cursor.getString(cursor.getColumnIndex("contactPhone"));
            int contactState=cursor.getInt(cursor.getColumnIndex("contactState"));
            contact=new Contact(contactId,contactName,contactCardID,contactPhone,contactState);
            contacts.add(contact);
        }
        return contacts;
    }
}
