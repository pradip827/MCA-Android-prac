package com.imcostmca.wmtpracticals;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final int version = 1;
    private static final String name = "office";
    private static final String table = "mEmployee";
    private static final String nID = "nID";
    private static final String sEmployeeName = "sEmployeeName";
    private List<Employee> lstEmployee = new ArrayList<Employee>();

    private SQLiteDatabase sqLiteDatabase;
    boolean flag = false, flagUpdate = false, flagDelete = false;

    public MyDBHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + table + "(" + nID + " INTEGER PRIMARY KEY AUTOINCREMENT," + sEmployeeName + " TEXT NOT NULL)");
        Log.d("DBCreated", "Successful");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table);
        onCreate(db);
    }

    public boolean insertRecord(Employee employee) {
        try {
            Log.d("DbInsert", employee.sEmployeeName);
            sqLiteDatabase = this.getWritableDatabase();
            //sqLiteDatabase.execSQL("INSERT INTO " + table + " (sEmployeeName) VALUES('" + employee.sEmployeeName + "')");
            ContentValues contentValues = new ContentValues();
            contentValues.put("sEmployeeName", employee.sEmployeeName);
            sqLiteDatabase.insert(table, null, contentValues);
            flag = true;
        } catch (Exception e) {
            Log.d("DBException", e.getMessage().toString());
        } finally {
            return flag;
        }
    }

    public List<Employee> getAllEmployee() {
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * from " + table, null);
        if (cursor.moveToFirst()) {
            do {
                Employee employee = new Employee();
                employee.setnID(cursor.getInt(0));
                employee.setsEmployeeName(cursor.getString(1));
                lstEmployee.add(employee);
            } while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        Log.d("DBCount", lstEmployee.size() + " Items");
        return lstEmployee;
    }

    public Employee getEmployee(String sName) {
        Employee e = new Employee();
        String qry = "SELECT * from " + table + " Where " + sEmployeeName + " = '" + sName + "'";
        sqLiteDatabase = this.getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery(qry, null);
        if (c.moveToFirst()) {
            do {
                e.setnID(c.getInt(0));
                e.setsEmployeeName(c.getString(1));
            } while (c.moveToNext());
        }
        sqLiteDatabase.close();
        return e;
    }

    public boolean isEdit(Employee employee) {
        try {
            if (employee != null) {
                sqLiteDatabase = this.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(nID, employee.getnID());
                contentValues.put(sEmployeeName, employee.getsEmployeeName());
                sqLiteDatabase.update(table, contentValues, nID + "=?", new String[]{String.valueOf(employee.getnID())});
                flagUpdate = true;
            } else {
                flagUpdate = false;
            }

        } catch (Exception e) {
            Log.e("UpdateError", e.getMessage().toString());
        }
        return flagUpdate;
    }

    public boolean isDelete(Employee employee) {
        try {
            sqLiteDatabase = this.getWritableDatabase();
            sqLiteDatabase.delete(table, nID + "=?", new String[]{String.valueOf(employee.getnID())});
            flagDelete = true;
        } catch (Exception e) {
            Log.e("DeleteError", e.getMessage().toString());
        }
        return flagDelete;
    }
}
