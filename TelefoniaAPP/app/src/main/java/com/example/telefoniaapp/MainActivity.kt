package com.example.telefoniaapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.content.ContextCompat
import com.example.telefoniaapp.ui.theme.AppScreen

class MainActivity : ComponentActivity() {
    //Inicia y solicita los permisos que se necesitan y carga la interfaz principal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestPermissions()

        setContent {
            AppScreen(this)
        }
    }

    // Es para solicitar los permisos para llamadas y enviar mensajes
    // si toavia no se otorgan
    private fun requestPermissions() {
        val permisos = arrayOf(
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.SEND_SMS,
            Manifest.permission.READ_CALL_LOG
        )

        permisos.forEach {
            if (ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(permisos, 1)
            }
        }
    }
}