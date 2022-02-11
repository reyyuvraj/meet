package com.example.meet

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import org.jitsi.meet.sdk.JitsiMeetActivity
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions
import java.net.URL


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val options = JitsiMeetConferenceOptions.Builder()
            .setServerURL(URL(""))
            .setRoom("test123")
            .setAudioMuted(false)
            .setVideoMuted(false)
            .setAudioOnly(false)
            .setWelcomePageEnabled(false)
            .setConfigOverride("requireDisplayName", true)
            .build()
    }

    fun onButtonClick(v: View){
        val editText: EditText = findViewById(R.id.conferenceName)
        val text: String = editText.text.toString()

        if(text.isNotEmpty()){
            val options = JitsiMeetConferenceOptions.Builder()
                .setRoom(text)
                .build()
            JitsiMeetActivity.launch(this, options)
        }
    }
}