package hdu.course.chinese_food;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ListActivity extends Activity{
    ListView listview;

   String [] foodNames = {"1.Hot Pot","2.Peking Duck", "3.Dim Sum","4.Mo Po Tofu","5.Noodles","6.Fried Rice","7.Sichuan Pork","8.Sweet and Sour Pork"};
    int [] foodImages = {R.drawable.pot_hot1,R.drawable.peking1,R.drawable.dim1,R.drawable.tofu1,R.drawable.nodles,R.drawable.fried_rice,R.drawable.sichuan_pork,R.drawable.sweet_pork};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);

        CustomAdapter customAdapter = new CustomAdapter();
        listview.setAdapter(customAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),ListdataActivity.class);
                intent.putExtra("name",foodNames[i]);
                intent.putExtra("image",foodImages[i]);
                startActivity(intent);
            }
        });

    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return foodImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1= getLayoutInflater().inflate(R.layout.row_data,null);
            TextView name = view1.findViewById(R.id.fruits);
            ImageView image = view1.findViewById(R.id.images);
            name.setText(foodNames[i]);
            image.setImageResource(foodImages[i]);
            return view1;
        }


    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"Starting List Activity",Toast.LENGTH_SHORT).show();
    }
}
