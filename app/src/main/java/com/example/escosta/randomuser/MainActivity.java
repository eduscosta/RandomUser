package com.example.escosta.randomuser;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.escosta.randomuser.databinding.ActivityMainBinding;
import com.example.escosta.randomuser.model.DataUser;
import com.example.escosta.randomuser.model.Result;
import com.example.escosta.randomuser.utils.MyService;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import static com.example.escosta.randomuser.R.id.imageView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private ProgressDialog load;

    ImageView photo;

    private DatabaseReference mDatabase;

    List<Result> user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        photo = (ImageView) findViewById(imageView);

    }

    public void runNewPerson(View view){

        GetJson download = new GetJson();

        download.execute();

    }

    public void runPutInDatabase(View view){

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("foo").setValue(user.get(0).getName());

    }

    private class GetJson extends AsyncTask<Object, Object, DataUser> {

        @Override
        protected void onPreExecute(){
            load = ProgressDialog.show(MainActivity.this, "Please wait for it ...", "Request data from server...");
        }

        @Override
        protected DataUser doInBackground(Object... params) {

            MyService util = new MyService();

            return util.getInformation("https://randomuser.me/api/");

        }

        @Override
        protected void onPostExecute(DataUser person){

            user =  person.getResults();

            binding.setUser(user.get(0));

//            photo.setImageBitmap(user.get(0).getPhoto());

            load.dismiss();
        }
    }
}
