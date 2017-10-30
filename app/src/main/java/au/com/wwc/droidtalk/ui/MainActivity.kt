package au.com.wwc.droidtalk.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import au.com.wwc.droidtalk.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById(R.id.message_list) as ListView
        val messages = ArrayList<String>()
        messages.add("Message 1")
        messages.add("Message 2")
        messages.add("Message 3")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, messages)
        listView.adapter = adapter

        val submitButton = findViewById(R.id.message_button) as Button
        val messageEditText = findViewById(R.id.message_input) as EditText
        submitButton.setOnClickListener {
            messages.add(messageEditText.text.toString())
            adapter.notifyDataSetChanged()
        }
    }
}
