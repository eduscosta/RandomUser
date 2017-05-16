package com.example.escosta.randomuser;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.escosta.randomuser.databinding.ActivityMainBinding;
import com.example.escosta.randomuser.model.DataUser;
import com.example.escosta.randomuser.model.Result;
import com.example.escosta.randomuser.utils.MyService;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        GetJson download = new GetJson();

        download.execute();

    }

    private class GetJson extends AsyncTask<Void, Void, DataUser> {

        @Override
        protected void onPreExecute(){
            load = ProgressDialog.show(MainActivity.this, "Please wait for it ...", "Request data from server...");
        }

        @Override
        protected DataUser doInBackground(Void... params) {

            MyService util = new MyService();

            return util.getInformation("https://randomuser.me/api/");

        }

        @Override
        protected void onPostExecute(DataUser person){

            List<Result> user =  person.getResults();

            binding.setUser(user.get(0));

            load.dismiss();
        }
    }
}
