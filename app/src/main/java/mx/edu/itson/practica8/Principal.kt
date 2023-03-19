package mx.edu.itson.practica8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class Principal : AppCompatActivity() {
    var adapter: RegalosAdapter? = null

    var detalles= ArrayList<Detalles>()
    var globos= ArrayList<Detalles>()
    var peluches= ArrayList<Detalles>()
    var regalos= ArrayList<Detalles>()
    var tazas= ArrayList<Detalles>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        var btnDetalles:Button=findViewById(R.id.btnDetalles)as Button
        var btnGlobos:Button=findViewById(R.id.btnGlobos)as Button
        var btnPeluches:Button=findViewById(R.id.btnPeluches)as Button
        var btnRegalos:Button=findViewById(R.id.btnRegalos)as Button
        var btnTazas:Button=findViewById(R.id.btnTazas)as Button


        btnDetalles.setOnClickListener{
            var intent:Intent=Intent(this, Regalos::class.java)
            intent.putExtra("menuType","Detalles")
            startActivity(intent)

        }

        btnGlobos.setOnClickListener{
            var intent:Intent=Intent(this, Regalos::class.java)
            intent.putExtra("menuType","Globos")
            startActivity(intent)

        }
        btnPeluches.setOnClickListener{
            var intent:Intent=Intent(this, Regalos::class.java)
            intent.putExtra("menuType","Peluches")
            startActivity(intent)

        }
        btnRegalos.setOnClickListener{
            var intent:Intent=Intent(this, Regalos::class.java)
            intent.putExtra("menuType","Regalos")
            startActivity(intent)

        }
        btnTazas.setOnClickListener{
            var intent:Intent=Intent(this, Regalos::class.java)
            intent.putExtra("menuType","Tazas")
            startActivity(intent)

        }


    }


}