 package com.mukulcode.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.mukulcode.aboutme.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {

     private lateinit var binding : ActivityMainBinding
     private val myname :MyName = MyName("Mukul Kumar")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myname

//        val button = findViewById<Button>(R.id.done_button).setOnClickListener{
//            addNickName(it)
//        }
        binding.doneButton.setOnClickListener{
            addNickName(it)
        }
    }


    private fun addNickName(view : View){
//        val editText = findViewById<EditText>(R.id.my_nickname_edit)
//        val textView = findViewById<TextView>(R.id.nickname_text)


        binding.apply {
//            nicknameText.text = myNicknameEdit.text
            myname?.nickname = myNicknameEdit.text.toString()
            invalidateAll()
            myNicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }
//        textView.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        textView.visibility = View.VISIBLE

        //Hiding the keyboard automatically
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}