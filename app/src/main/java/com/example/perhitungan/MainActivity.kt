package com.example.perhitungan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var inputBLG1: EditText
    private lateinit var inputBLG2: EditText
    private lateinit var BTNsimpan: Button
    private lateinit var hasil : TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputBLG1 = findViewById(R.id.blg1)
        inputBLG2 = findViewById(R.id.blg2)
        BTNsimpan = findViewById(R.id.btnsimpan)
        hasil = findViewById(R.id.hasilnya)
        recyclerView = findViewById(R.id.rvbilangan)

        val data = mutableListOf<Data>()
        viewManager = LinearLayoutManager(this)
        recyclerAdapter = adapter(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager

        //setOnClickLIstener untuk tombol tambah data
        BTNsimpan.setOnClickListener{
            val bilangan1 = inputBLG1.text.toString().toInt()
            val bilangan2 = inputBLG2.text.toString().toInt()
            val hsl = hasil.text.toString()
            val datablg = Data(bilangan1,bilangan2,hsl)
            data.add(datablg)
            recyclerAdapter.notifyDataSetChanged()

        }
        val tambah = findViewById<Button>(R.id.btntambah)
        val kurang = findViewById<Button>(R.id.btnkurang)
        val kali = findViewById<Button>(R.id.btnkali)
        val bagi  = findViewById<Button>(R.id.btnbagi)

        tambah.setOnClickListener {tambah()}
        kurang.setOnClickListener{kurang()}
        kali.setOnClickListener{kali()}
        bagi.setOnClickListener{bagi()}
    }
    fun tambah(){
        val bil1 = findViewById<EditText>(R.id.blg1)
        val bil2 = findViewById<EditText>(R.id.blg2)
        val hasil = findViewById<TextView>(R.id.hasilnya)
        val hitung = bil1.text.toString().toDouble() + bil2.text.toString().toDouble()
        hasil.text = hitung.toString()
    }
    fun kurang(){
        val bil1 = findViewById<EditText>(R.id.blg1)
        val bil2 = findViewById<EditText>(R.id.blg2)
        val hasil = findViewById<TextView>(R.id.hasilnya)
        val hitung = bil1.text.toString().toDouble() - bil2.text.toString().toDouble()
        hasil.text = hitung.toString()

    }
    fun kali(){
        val bil1 = findViewById<EditText>(R.id.blg1)
        val bil2 = findViewById<EditText>(R.id.blg2)
        val hasil = findViewById<TextView>(R.id.hasilnya)
        val hitung = bil1.text.toString().toDouble() * bil2.text.toString().toDouble()
        hasil.text = hitung.toString()
    }
    fun bagi(){
        val bil1 = findViewById<EditText>(R.id.blg1)
        val bil2 = findViewById<EditText>(R.id.blg2)
        val hasil = findViewById<TextView>(R.id.hasilnya)
        val hitung = bil1.text.toString().toDouble() / bil2.text.toString().toDouble()
        hasil.text = hitung.toString() }
}