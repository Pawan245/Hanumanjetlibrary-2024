package com.ram.Hanumanjetlibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ram.androidhanumanjetlibrery.R;
import com.ram.hanumanjetpacklibrery.HanumanAdapter;
import com.ram.hanumanjetpacklibrery.HanumanCheckInternet;
import com.ram.hanumanjetpacklibrery.RetroApiAnyCall;
import com.ram.hanumanjetpacklibrery.RetrofitClient;
import com.ram.hanumanjetpacklibrery.StartAnyActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {

    HanumanAdapter fg,t;
    RecyclerView rvc,rfv;
    TextView tt;
    List<Hero> ty,yy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int layoutID = R.layout.activity_main;
        Log.i("SS", "" + layoutID + "");
        ty=new ArrayList<>();
        yy=new ArrayList<>();
        rvc = findViewById(R.id.category_recycler);
        rfv= findViewById(R.id.rfv);
      //  getCategory();
        getCategorys();
        if(HanumanCheckInternet.isConnected(MainActivity.this))
        {
            //online
        }
       else {
           //offline
       }

        

    }






    private void getCategorys() {

        apii service = RetrofitClient.getStringClient("http://pawankumar00-001-site1.btempurl.com/").create(apii.class);

        Call<String> stringCall = service.login("WATER_CSDL","8", "1");


        RetroApiAnyCall.ApiStringCallRetro(stringCall, new RetroApiAnyCall.RetroCallbackApi() {
            @Override
            public void onSuccess(String result) {
                Log.i("TAGXT", ""+result.toString()+"");
                //do stuff here
            }

            @Override
            public void onError(String result) {


                Log.i("TAGXTM", ""+ result.toString()+"");
                //do stuff here
            }
        });
    }










    private void getCategory() {

        api service = RetrofitClient.getModelClient("https://simplifiedcoding.net/demos/").create(api.class);


        Call<List<Hero>> stringCall = service.getHeroes();

        RetroApiAnyCall.ApiModelCallRetro(stringCall, new RetroApiAnyCall.RetroCallbackApiModel() {
            @Override
            public void onError(String result) {
                Log.i("PPZ", "" + result + "");
            }

            @Override
            public <E> void onSuccess(List<E> body) {
                int layoutID = R.layout.items;
              //  HanumanAdapter.setlayoutid(layoutID);
                ty = (List<Hero>) body;
yy= (List<Hero>) body;
                fg = new HanumanAdapter(MainActivity.this, ty);

                // preferenceManager.putstring(Constant.PRODUCT_COUNT, String.valueOf(cartAdapter.getItemCount()));
                rvc.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rvc.setAdapter(fg);
                rvc.smoothScrollToPosition(0);
                //cartAdapter.setOnItemClickListener(Cart.this);
                fg.notifyDataSetChanged();



                t= new HanumanAdapter(MainActivity.this, ty);
                rfv.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
                rfv.setAdapter(fg);
                rfv.smoothScrollToPosition(0);
                //cartAdapter.setOnItemClickListener(Cart.this);
                t.notifyDataSetChanged();

t.setHanumanAdapter(new HanumanAdapter.HanumanAdapterCallback() {
    @Override
    public int setlayoutid() {
        int layoutID = R.layout.items;
        return layoutID;
    }

    @Override
    public void MyViewholder(View itemView) {
        tt = itemView.findViewById(R.id.txt);
    }

    @Override
    public <T> void onBindViewHolder(List<T> list, HanumanAdapter<T>.MyViewholder holder, int position) {
        List<Hero> df = (List<Hero>) list;
        TextView hh = holder.itemView.findViewById(R.id.txt);
        hh.setText("" + df.get(position).getName() + "");
        hh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  Toast.makeText(getApplicationContext(),""+hh.getText().toString()+"",Toast.LENGTH_LONG).show();

                EditText ty = findViewById(R.id.txtm);

              //  fg.getFilter().filter(ty.getText().toString());
            }

        });
    }

    @Override
    public <T> List<T> filterresult(CharSequence constraint) {
        return null;
    }
});









                fg.setHanumanAdapter(new HanumanAdapter.HanumanAdapterCallback() {
                    @Override
                    public int setlayoutid() {
                        int layoutID = R.layout.items;
                        return layoutID;
                    }

                    @Override
                    public void MyViewholder(View itemView) {
                        tt = itemView.findViewById(R.id.txt);
                    }

                    @Override
                    public <T> void onBindViewHolder(List<T> list, HanumanAdapter<T>.MyViewholder holder, int position) {
                        List<Hero> df = (List<Hero>) list;
                        TextView hh = holder.itemView.findViewById(R.id.txt);
                        hh.setText("" + df.get(position).getName() + "");
                        hh.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                              //  Toast.makeText(getApplicationContext(),""+hh.getText().toString()+"",Toast.LENGTH_LONG).show();

                                EditText ty = findViewById(R.id.txtm);

fg.getFilter().filter(ty.getText().toString());
                            }

                        });
                    }

                    @Override
                    public List filterresult(CharSequence constraint) {



                       if (constraint.length() > 0) {
                            constraint = constraint.toString().toUpperCase();
                            ArrayList<Hero> filter = new ArrayList<Hero>();
                            for (int i = 0; i < ty.size(); i++) {
                                if (ty.get(i).getName().toUpperCase().equals(constraint)) {
                                    Toast.makeText(getApplicationContext(),""+constraint+"",Toast.LENGTH_LONG).show();

                                    Hero p = new Hero(ty.get(i).getName(), ty.get(i).getRealname(), ty.get(i).getTeam(), ty.get(i).getFirstappearance(), ty.get(i).getCreatedby(), ty.get(i).getPublisher(), ty.get(i).getImageurl(), ty.get(i).getBio());
                                    filter.add(p);

                                }
                            }
ty.clear();

                           Toast.makeText(getApplicationContext(),""+filter.size()+"",Toast.LENGTH_LONG).show();

                            ty=filter;
return ty;
                          // fg.notifyDataSetChanged();



                        } else {

ty.clear();
ty=yy;
                          // fg.notifyDataSetChanged();
return ty;
                        }
                    }
                });


                // Log.i("PP", "" + ty.get(4).getName() + "");


            }


     /*   stringCall.enqueue(new Callback<List<Hero>>() {




            @Override
            public void onResponse(Call<List<Hero>> call, retrofit2.Response<List<Hero>> response) {

                if (response.isSuccessful()) {
                    *//* *//*
                    switch (response.code()) {
                        case 404:

                            break;

                        case 500:

                            break;

                        case 200:
                            if (response.isSuccessful()) {

                                Log.i("PP",""+response.body()+"");

                            }
                            break;

                        default:
                          //  callback.onError("error");
                            break;

                    }

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

                if (call.isCanceled()) {
                    //callback.onError("abort");
                } else {

                    Log.i("PP",""+t.toString()+"");
                  //  callback.onError(call.toString());
                }

            }
        });*/

        });


    }


       /* RetroApiAnyCall.ApiModelCallRetro(stringCall, new RetroApiAnyCall.RetroCallbackApiModel() {
            @Override
            public void onError(String result) {
                Log.i("PP",""+result+"");
            }

            @Override
            public <E> void onSuccess(E body) {
                Log.i("PP",""+body+"");
            }
        });*/


    public interface api {


        @GET("marvel")
        Call<List<Hero>> getHeroes();

    }


    public  interface  apii{

        @GET("appservice.asmx/login")
        Call<String> login(@Query("PaasCode") String jobseeker, @Query("uiname") String username, @Query("Paasd") String pass);


    }


}