package mx.edu.itson.practica8

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView


class Regalos : AppCompatActivity() {
    var adapter: RegalosAdapter? = null

    var detalles= ArrayList<Detalles>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)

        var menuOption:String?=intent.getStringExtra("menuType")
        var tituloTxt:TextView=findViewById(R.id.titulo)
        cargarRegalos(menuOption.toString(),tituloTxt)

        adapter=RegalosAdapter(this,detalles)


        var gridDetalles: GridView =findViewById(R.id.gridCatalogo) as GridView


        gridDetalles.adapter= adapter
    }

    fun cargarRegalos(option:String, titulo:TextView){

        when(option) {
            "Detalles"-> {
                detalles.add(Detalles(R.drawable.cumplecheve, "320"))
                detalles.add(Detalles(R.drawable.cumplebotanas, "150"))
                detalles.add(Detalles(R.drawable.cumplepaletas, "190"))
                detalles.add(Detalles(R.drawable.cumpleescolar, "320"))
                detalles.add(Detalles(R.drawable.cumplesnack, "320"))
                detalles.add(Detalles(R.drawable.cumplevinos, "370"))

                titulo.setText("Detalles")
            }
            "Globos"-> {

                detalles.add(Detalles(R.drawable.globos, "240"))
                detalles.add(Detalles(R.drawable.globoamor, "820"))
                detalles.add(Detalles(R.drawable.globocumple, "260"))
                detalles.add(Detalles(R.drawable.globonum, "760"))
                detalles.add(Detalles(R.drawable.globofestejo, "450"))
                detalles.add(Detalles(R.drawable.globoregalo, "240"))
                titulo.setText("Globos")
            }
            "Peluches"-> {

                detalles.add(Detalles(R.drawable.peluches, "320"))
                detalles.add(Detalles(R.drawable.peluchemario, "320"))
                detalles.add(Detalles(R.drawable.pelucheminecraft, "290"))
                detalles.add(Detalles(R.drawable.peluchepeppa, ""))
                detalles.add(Detalles(R.drawable.peluchesony, "330"))
                detalles.add(Detalles(R.drawable.peluchestich, "280"))
                detalles.add(Detalles(R.drawable.peluchevarios, "195"))
                titulo.setText("Peluches")
            }

            "Regalos"-> {

                detalles.add(Detalles(R.drawable.regalos, "80"))
                detalles.add(Detalles(R.drawable.regalobebe, "290"))
                detalles.add(Detalles(R.drawable.regaloazul, "140"))
                detalles.add(Detalles(R.drawable.regalocajas, "85"))
                detalles.add(Detalles(R.drawable.regalocolores, ""))
                detalles.add(Detalles(R.drawable.regalovarios, "75"))
                titulo.setText("Regalos")
            }

            "Tazas"-> {

                detalles.add(Detalles(R.drawable.tazas, "120"))
                detalles.add(Detalles(R.drawable.tazaabuela, "120"))
                detalles.add(Detalles(R.drawable.tazalove, "260"))
                detalles.add(Detalles(R.drawable.tazaquiero, "280"))
                titulo.setText("Tazas")
            }

        }

    }



}

class RegalosAdapter: BaseAdapter {
    var detalles=ArrayList<Detalles>()
    var contexto: Context?=null

    constructor(context: Context, detalles:ArrayList<Detalles>){
        this.detalles=detalles;
        this.contexto=context
    }


    override fun getItem(p0: Int): Any {
        return detalles[p0]
    }

    override fun getItemId(p0: Int): Long {

        return 100
    }



    override fun getCount(): Int {
        return detalles.size
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var  regalo=detalles[p0]
        var inflador= LayoutInflater.from(contexto)
        var vista=inflador.inflate(R.layout.detalle,null)

         var imagen=vista.findViewById(R.id.iv_regalo_imagen)as ImageView
         var precio=vista.findViewById(R.id.tv_regalo_precio) as TextView

        imagen.setImageResource(regalo.image)
        precio.setText("$"+regalo.precio)
/*
        vista.setOnClickListener {
            val intent= Intent(contexto,Detalles::class.java)
            intent.putExtra("imagen",regalo.image)
            intent.putExtra("precio",regalo.precio)
            contexto!!.startActivity(intent)

        }*/
        return vista
    }


}