package com.example.mickeymouse.Database;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.example.mickeymouse.models.user;
import java.util.ArrayList;
public class DatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseHelper sInstance;
    Context context;
    //database ver and name
    private static final String DATABASE_NAME = "MickeyMouse";
    private static final int DATABASE_VERSION = 1;
    //table name
    private static final String TABLE_NAME = "user";
    //columns of the table
    private static final String KEY_name ="name";
    private static final String KEY_Email ="email";
    private static final String KEY_password ="password";
    public static synchronized DatabaseHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String Create_Table= "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                " ( " + KEY_name + " TEXT , "
                + KEY_Email + " TEXT PRIMARY KEY, "
                + KEY_password + " TEXT " + " );";
        db.execSQL(Create_Table);

        final user[] users = {
                new user ("kid1","kid1@kid1.com","123"),
                new user ("kid2","kid2@kid2.com","123")
        };
        for (user u : users ){
            String insert = String.format("INSERT INTO %s (%s,%s,%s) VALUES ('%s','%s','%s');",
                    TABLE_NAME, KEY_name, KEY_Email,KEY_password, u.getName(),u.getEmail(),u.getPassword());
            db.execSQL(insert);
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        }
    }
    public void signup (String name, String email, String password){
        String INSERT_QUERY = String.format("INSERT INTO %s (%s,%s,%s) VALUES ('%s','%s','%s');",
                TABLE_NAME, KEY_name, KEY_Email, KEY_password, name, email, password);
        SQLiteDatabase db = getReadableDatabase();
        try {
            db.execSQL(INSERT_QUERY);

        } catch (Exception e) {
            System.out.println("epurr epurr");
            Toast.makeText(context, "error while signing up", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean login (String email, String password){
        String SELECT_QUERY = String.format("SELECT * FROM %s where %s = '%s' and %s= '%s'",
                TABLE_NAME, KEY_Email, email, KEY_password, password);
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                return true;
            } else
                return false;


        } catch (Exception e) {
            System.out.println("epurr epurr");
            Toast.makeText(context, "error while logging in", Toast.LENGTH_SHORT).show();
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return false;
    }
    public static boolean validmail (String email ){
        String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
