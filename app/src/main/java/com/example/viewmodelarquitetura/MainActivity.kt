package com.example.viewmodelarquitetura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelarquitetura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.textWelcome.observe(this, Observer {txtWelcome->
            binding.textWelcome.text = txtWelcome
        })

        viewModel.login.observe(this,{
            if(it){
                Toast.makeText(applicationContext,"Login com Sucesso" ,Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"Erro no login" ,Toast.LENGTH_SHORT).show()

            }
        })

        binding.buttonLogin.setOnClickListener{
            viewModel.login(binding.editName.text.toString())
        }

    }
}