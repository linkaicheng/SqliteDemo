package com.cheng.sqlitedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.cheng.bean.Contact;
import com.cheng.dao.ContactDao;
import com.cheng.daoImpl.ContactDaoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Map<String, Object>> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) this.findViewById(R.id.listView);
        //得到数据源
        mData = getData();
        //创建适配器
        SimpleAdapter adapter = new SimpleAdapter(this, mData, R.layout.item_my_contact, new String[]{"name", "idCard", "tel"}, new int[]{R.id.tvContactName, R.id.tvContactIdCard, R.id.tvContactTel});
        //设置适配器
        listView.setAdapter(adapter);
    }

    private List<Map<String, Object>> getData() {

        ContactDao conDao = new ContactDaoImpl(this);
        List<Contact> contacts = conDao.findAll();
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        Map<String, Object> row = null;
        for (Contact contact : contacts) {
            row = new HashMap<String, Object>();
            row.put("name", contact.getContactName());
            row.put("idCard", contact.getContactCardID());
            row.put("tel", contact.getContactPhone());
            data.add(row);
        }
        return data;

    }
}
