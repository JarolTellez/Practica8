package mx.edu.itson.practica8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

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

        cargarRegalos()

        adapter=RegalosAdapter(this,detalles)
        adapter=RegalosAdapter(this,globos)
        adapter=RegalosAdapter(this,peluches)
        adapter=RegalosAdapter(this,regalos)
        adapter=RegalosAdapter(this,tazas)

        var gridDetalles:GridView =findViewById(R.id.gridCatalogo) as GridView


        gridDetalles.adapter= adapter


    }

    fun cargarRegalos(){

        detalles.add(Detalles(R.drawable.cumplecheve,"320"))
        detalles.add(Detalles(R.drawable.cumplebotanas,"150"))
        detalles.add(Detalles(R.drawable.cumplepaletas,"190"))
        detalles.add(Detalles(R.drawable.cumpleescolar,"320"))
        detalles.add(Detalles(R.drawable.cumplesnack,"320"))
        detalles.add(Detalles(R.drawable.cumplevinos,"370"))

        globos.add(Detalles(R.drawable.globos,"240"))
        globos.add(Detalles(R.drawable.globoamor,"820"))
        globos.add(Detalles(R.drawable.globocumple,"260"))
        globos.add(Detalles(R.drawable.globonum,"760"))
        globos.add(Detalles(R.drawable.globofestejo,"450"))
        globos.add(Detalles(R.drawable.globoregalo,"240"))

        peluches.add(Detalles(R.drawable.peluches,"320"))
        peluches.add(Detalles(R.drawable.peluchemario,"320"))
        peluches.add(Detalles(R.drawable.pelucheminecraft,"290"))
        peluches.add(Detalles(R.drawable.peluchepeppa,""))
        peluches.add(Detalles(R.drawable.peluchesony,"330"))
        peluches.add(Detalles(R.drawable.peluchestich,"280"))
        peluches.add(Detalles(R.drawable.peluchevarios,"195"))

        regalos.add(Detalles(R.drawable.regalos,"80"))
        regalos.add(Detalles(R.drawable.regalobebe,"290"))
        regalos.add(Detalles(R.drawable.regaloazul,"140"))
        regalos.add(Detalles(R.drawable.regalocajas,"85"))
        regalos.add(Detalles(R.drawable.regalocolores,""))
        regalos.add(Detalles(R.drawable.regalovarios,"75"))

        tazas.add(Detalles(R.drawable.tazas,"120"))
        tazas.add(Detalles(R.drawable.tazaabuela,"120"))
        tazas.add(Detalles(R.drawable.tazalove,"260"))
        tazas.add(Detalles(R.drawable.tazaquiero,"280"))



    }



}

class RegalosAdapter:BaseAdapter{
    var detalles=ArrayList<Detalles>()
    var contexto: Context?=null

    constructor(context: Context,detalles:ArrayList<Detalles>){
        this.detalles=detalles;
        this.contexto=context
    }


    override fun getItem(p0: Int): Any {
        return detalles[p0]
    }

    override fun getItemId(p0: Int): Long {

    }



    override fun getCount(): Int {
        return detalles.size
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var  regalo=detalles[p0]
        var inflador=LayoutInflater.from(contexto)
        var vista=inflador.inflate(R.layout.activity_regalos,null)

        var imagen=vista.findViewById(R.id.iv_regalo_imagen)as ImageView
        var precio=vista.findViewById(R.id.tv_regalo_precio) as TextView

        vista.setOnClickListener {
            var intent:Intent=Intent(contexto,Detalles::class.java)
            intent.putExtra("imagen",regalo.image)
            intent.putExtra("precio",regalo.precio)
            contexto!!.startActivity(intent)

        }
        return vista
    }
}