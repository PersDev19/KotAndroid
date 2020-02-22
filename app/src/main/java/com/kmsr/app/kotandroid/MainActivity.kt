package com.kmsr.app.kotandroid

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        auth = FirebaseAuth.getInstance()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        Toast.makeText(this,"currentUser:$currentUser",Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
//        super.onBackPressed()
        val alertDialog = AlertDialog.Builder(this)

        alertDialog.setTitle(resources.getString(R.string.info))
        alertDialog.setMessage(R.string.msgFinish)
        alertDialog.setPositiveButton("예", DialogInterface.OnClickListener { dialog, which -> finish()  })
        alertDialog.setNegativeButton("아니오", DialogInterface.OnClickListener { dialog, which ->  })
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
}
