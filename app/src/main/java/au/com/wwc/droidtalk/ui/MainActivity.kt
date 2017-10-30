package au.com.wwc.droidtalk.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import au.com.wwc.droidtalk.R
import au.com.wwc.droidtalk.data.api.MessageApi
import au.com.wwc.droidtalk.data.model.Message
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var messages: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var messageApi: MessageApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById(R.id.message_list) as ListView
        messages = ArrayList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, messages)
        listView.adapter = adapter

        messageApi = MessageApi.create()

        setUpMessagesList()

        setUpSendingMessages()
    }

    private fun setUpMessagesList() {
        messageApi.getMessages()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ retrievedMessages ->
                    for (message in retrievedMessages) {
                        messages.add(message.content)
                    }
                    adapter.notifyDataSetChanged()
                }, { error ->
                    error.printStackTrace()
                })
    }

    private fun setUpSendingMessages() {
        val submitButton = findViewById(R.id.message_button) as Button
        val messageEditText = findViewById(R.id.message_input) as EditText
        submitButton.setOnClickListener {
            messageApi.sendMessage(Message(messageEditText.text.toString()))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({ _ ->
                        setUpMessagesList()
                    }, { error ->
                        error.printStackTrace()
                    })
        }
    }

}
