package ga.himanshu.home.myapplicationn;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String hf=null;
    String gh=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver resolver=getContentResolver();

        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String projection[]={ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME};
        String args[]={};

       Cursor cursor= resolver.query( uri, null,"",args, null);





        while(cursor.moveToNext()){
           // Log.d("codekamp",cursor.getString(0));

            hf=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            gh=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            Log.d("codekamp",hf+"      "+gh);

            JSONObject jsonObject=new JSONObject();
            try {
                jsonObject.accumulate("name",gh);
                jsonObject.accumulate("Mobile",hf);
            } catch (JSONException e) {
                e.printStackTrace();
            }




            JsonLoader loader=new JsonLoader();
            loader.execute(new JsonRequest(jsonObject.toString()));


        }



    }
}
