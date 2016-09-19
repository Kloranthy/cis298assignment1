package edu.kvcc.cis298.cis298assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CounterActivity
		extends AppCompatActivity
{

	private Button mPlusButton, mMinusButton;
	private TextView mCounterTextView;
	private int mCount = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter);

		mCounterTextView = (TextView) findViewById(R.id.counter_text_view);
		updateCounter();

		mPlusButton = (Button) findViewById(R.id.plus_button);
		mMinusButton = (Button) findViewById(R.id.minus_button);

		mPlusButton.setOnClickListener(
				new View.OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						incrementCount();
						updateCounter();
					}
				}
		);

		mMinusButton.setOnClickListener(
				new View.OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						decrementCount();
						updateCounter();
					}
				}
		);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings)
		{
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	private void incrementCount()
	{
		mCount++;
		if (mCount == 21)
		{
			Toast.makeText(
					CounterActivity.this,
					R.string.exceeded_twenty_toast,
					Toast.LENGTH_SHORT
			).show();
		}
	}

	private void decrementCount()
	{
		if (mCount > 0)
		{
			mCount--;
		}
	}

	private void updateCounter()
	{
		mCounterTextView.setText("count: " + mCount);
	}
}
