package com.example.viewmodelarquitetura

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var mTextWelcome = MutableLiveData<String>()
    var textWelcome = mTextWelcome
    private var mRepository = PersonRepository()
    private var mLogin = MutableLiveData<Boolean>()
    var login = mLogin

    init {
        mTextWelcome.value = "Seja Bem Vindo"
    }

    fun login(valor:String){
        val ret = mRepository.login(valor)
        mLogin.value = ret
        if(ret){
            mTextWelcome.value = "Ola $valor Seja Bem Vindo"
        }
    }

}