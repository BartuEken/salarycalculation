package com.example.kaganbartueken
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kaganbartueken.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val UcretBox = findViewById<EditText>(R.id.UcretBox)
        val MesaiBox = findViewById<EditText>(R.id.MesaiBox)
        val HesapBtn = findViewById<Button>(R.id.HesapBtn)
        val textView3 = findViewById<TextView>(R.id.textView3)

        val isim = intent.getStringExtra("isim")
        val soyisim = intent.getStringExtra("soyisim")
        textView3.text = "Hoşgeldin,$isim $soyisim"

        HesapBtn.setOnClickListener {
            val ucret = UcretBox.text.toString().toDouble()
            val mesai = MesaiBox.text.toString().toDouble()
            val maas = ucret * mesai

            setResult(RESULT_OK,Intent().putExtra("maasResult",maas))
            finish()

        }
    }
}
