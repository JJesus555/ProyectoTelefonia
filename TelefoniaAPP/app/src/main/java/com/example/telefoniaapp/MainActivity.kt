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

        //requestPermissions()

        setContent {
            AppScreen(this)
        }
    }
}