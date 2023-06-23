package hdu.course.chinese_food;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);
    }
public void Next_page(View view)
{
    setContentView(R.layout.main_view1);
}
public void Next_page1(View view) {setContentView(R.layout.recipe);}
    public void Next_page2(View view) {setContentView(R.layout.main_view2);}
    public void Next_page3(View view)
    {
        setContentView(R.layout.main_view3);
    }
    public void Next_page4(View view)
    {
        setContentView(R.layout.mo_po_tofu);
    }
    public void Next_page5(View view)
    {
        setContentView(R.layout.main_view5);
    }
    public void Next_page6(View view)
    {
        setContentView(R.layout.landing_page);
    }

    public void click(View view) {
        Intent intent = new Intent(MainActivity.this, Rating_activity.class);
        startActivity(intent);
    }
    public void click2(View view) {
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        startActivity(intent);
    }
    public void Video(View view) {
        Intent intent = new Intent(MainActivity.this, Video_Activity.class);
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"Starting Main Activity",Toast.LENGTH_SHORT).show();
    }

}
