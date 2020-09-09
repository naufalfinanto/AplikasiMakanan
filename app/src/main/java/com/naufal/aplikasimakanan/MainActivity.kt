package com.naufal.aplikasimakanan

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_makanan.view.*

class MainActivity : AppCompatActivity() {

    val listMakanan = ArrayList<Makanan>()
    var adapter : AdapterMakanan? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listMakanan.add(Makanan("Asinan Betawi", "Asinan betawi adalah makanan khas Jakarta", R.drawable.asinanbetawi))
        listMakanan.add(Makanan("Kerak Telor", "Kerak Telor adalah makanan khas Jakarta", R.drawable.keraktelor))
        listMakanan.add(Makanan("Nasi Campur Bali", "Nasi Campur Bali adalah makanan khas Bali", R.drawable.nasicampurbali))
        listMakanan.add(Makanan("Nasi Goreng", "Nasi Goreng adalah makanan khas Indonesia", R.drawable.nasigoreng))
        listMakanan.add(Makanan("Nasi Padang", "Nasi Padang adalah makanan khas Padang", R.drawable.nasipadang))
        listMakanan.add(Makanan("Tempoyak Patin", "Tempoyak Patin adalah makanan khas Jambi", R.drawable.tempoyakpatin))

        adapter = AdapterMakanan(this, listMakanan)
        gvListMakanan.adapter = adapter
    }
    inner class AdapterMakanan(context: Context, listOfFood: ArrayList<Makanan>) : BaseAdapter() {
        var listMakanan = listOfFood
        var context:Context? = context


        @SuppressLint("ViewHolder", "InflateParams")
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val  makanan = this.listMakanan[p0]
            val  inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val foodView = inflator.inflate(R.layout.item_makanan,null)
            foodView.ivGambarMakanan.setImageResource(makanan.gambar!!)

            foodView.ivGambarMakanan.setOnClickListener{
                val intent = Intent(context, DetailMakanan::class.java)
                intent.putExtra("nama", makanan.nama!!)
                intent.putExtra("deskripsi", makanan.deskripsi!!)
                intent.putExtra("gambar", makanan.gambar!!)
            }
            foodView.tvNamaMakanan.text = makanan.nama!!
            return foodView
        }

        override fun getCount(): Int {
            return listMakanan.size
        }

        override fun getItem(p0: Int): Any {
            return  listMakanan[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }
    }
}