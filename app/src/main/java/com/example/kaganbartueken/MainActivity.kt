package com.example.kaganbartueken
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.kaganbartueken.R

class MainActivity : AppCompatActivity() {
    private lateinit var maasIntent: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val MaasBtn = findViewById<Button>(R.id.MaasBtn)
        val IsimBox = findViewById<EditText>(R.id.IsimBox)
        val SoyisimBox = findViewById<EditText>(R.id.SoyisimBox)
        val MaasMiktarText = findViewById<TextView>(R.id.MaasMiktarText)

        maasIntent = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->

            if(result.resultCode == RESULT_OK)
            {
                val maas = result.data!!.getDoubleExtra("maasResult",0.0)
                MaasMiktarText.setText("Personel Maaş : "+ maas)
            }
        }
        MaasBtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("isim",IsimBox.text.toString())
            intent.putExtra("soyisim",SoyisimBox.text.toString())
            maasIntent.launch(intent)
        }
    }
}
