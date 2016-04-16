package ga.himanshu.home.myapplicationn;

import android.os.AsyncTask;
import android.support.annotation.RequiresPermission;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Himanshu on 4/15/2016.
 */
public class JsonLoader extends AsyncTask<JsonRequest,Void,Void> {

    private final String API_URL="https://api.backand.com/1/objects/contacts";
    private final String ANNONYMOUS_TOKEN="8af1d249-dbbb-4103-9048-868e7713b3f3";

    @Override
    protected Void doInBackground(JsonRequest... params) {
        JsonRequest request=params[0];


        String jh=request.mobile;
        String ph=request.mobile;
        String jjnh=request.mobile;
        String jckh=request.mobile;




        try{

            String urlstring=API_URL;
            URL url =new URL(urlstring);

            HttpURLConnection connection=(HttpURLConnection)url.openConnection();

            connection.setRequestProperty("AnonymousToken", ANNONYMOUS_TOKEN);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("name",jh);
            InputStream stream=connection.getInputStream();

            BufferedReader r=new BufferedReader(new InputStreamReader(stream));
            String totalresponse="";
            String line;



        }catch (Exception e){

        }

        return null;
    }
}
