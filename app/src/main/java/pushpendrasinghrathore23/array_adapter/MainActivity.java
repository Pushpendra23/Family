package pushpendrasinghrathore23.array_adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    ListView l;
    String s[] = {"Calculator", "Pattern", "Calling","Messaging","E-mail"};
    String n[] = {"", "","","",""};
    int[] i={R.mipmap.ob1,R.mipmap.ob1,R.mipmap.ob1,R.mipmap.ob1,R.mipmap.ob1};
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        l = (ListView) findViewById(R.id.listView);


        Adapterim adp = new Adapterim(getApplicationContext(), s, n,i);

        l.setAdapter(adp);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "You are directed to " + s[position], Toast.LENGTH_SHORT).show();


                //intent on each array adapter item in list
                int selection;
                selection=Integer.parseInt(String.valueOf(position));

                if(selection==0){
                    Intent i=new Intent(MainActivity.this,calculator.class);
                    startActivity(i);
                }
                if(selection==1){
                    Intent i=new Intent(MainActivity.this,pattern.class);
                    startActivity(i);
                }
                if(selection==2){
                    Intent i=new Intent(MainActivity.this,calling.class);
                    startActivity(i);
                }
                if(selection==3){
                    Intent i=new Intent(MainActivity.this,messaging.class);
                    startActivity(i);
                }
                if(selection==4){
                    Intent i=new Intent(MainActivity.this,email.class);
                    startActivity(i);
                }
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://pushpendrasinghrathore23.array_adapter/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://pushpendrasinghrathore23.array_adapter/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    class Adapterim extends ArrayAdapter<String> {
        String[] s = {};
        String[] n = {};
        int []i={};
        Context c;
        LayoutInflater inflater;

        public Adapterim(Context context, String[] s, String[] n,int[]i) {
            super(context, R.layout.customicerik, s);
            this.s = s;
            this.n = n;
            this.i=i;
            this.c = context;
        }

        public class Viewholder {
            ImageView v;
            TextView t1;
            TextView t2;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.customicerik, null, true);
            }
            final Viewholder holder = new Viewholder();
            holder.v=(ImageView)convertView.findViewById(R.id.img);
            holder.t1 = (TextView) convertView.findViewById(R.id.textvw1);
            holder.t2 = (TextView) convertView.findViewById(R.id.textvw2);
            holder.v.setImageResource(i[position]);
            holder.t1.setText(s[position]);
            holder.t2.setText(n[position]);
            return convertView;
        }
    }
}