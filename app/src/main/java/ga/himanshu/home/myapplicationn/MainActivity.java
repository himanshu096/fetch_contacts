package ga.himanshu.home.myapplicationn;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver resolver=getContentResolver();

        Uri uri= ContactsContract.Contacts.CONTENT_URI;
        String projection[]={ContactsContract.Contacts.DISPLAY_NAME};
        String args[]={};

       Cursor cursor= resolver.query( uri, projection,"",args, ContactsContract.Contacts.DISPLAY_NAME);

        while(cursor.moveToNext()){
            Log.d("codekamp",cursor.getString(0));
        }
    }
}
