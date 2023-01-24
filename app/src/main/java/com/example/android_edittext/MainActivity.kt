package com.example.android_edittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        var textView_1 = findViewById<TextView>(R.id.textView_1)
        var edittext_1 = findViewById<EditText>(R.id.edittext_1)
        var bn_click = findViewById<Button>(R.id.bn_click)


        edittext_1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                bn_click.setEnabled(edittext_1.text.isNotEmpty())
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                textView_1.text = p0
                bn_click.setEnabled(edittext_1.text.isNotEmpty())
            }

            override fun afterTextChanged(p0: Editable?) {
                bn_click.setEnabled(edittext_1.text.isNotEmpty())

            }

        })

        edittext_1.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if (event!!.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_MENU) {
                    return false;
                }
                return false;
            }

        })
    }
}