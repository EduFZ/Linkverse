package br.com.empresa.linkverse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button = findViewById<Button>(R.id.login_button)

        button.setOnClickListener {
         presentHomeActivity()
        }
    }

    fun presentHomeActivity () {
        val changePage = Intent(this, HomeActivity::class.java)
        startActivity(changePage)
    }
}



