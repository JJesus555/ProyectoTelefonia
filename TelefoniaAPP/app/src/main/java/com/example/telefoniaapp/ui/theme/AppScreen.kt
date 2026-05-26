package com.example.telefoniaapp.ui.theme

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

@Composable
fun AppScreen(context: Context) {

    var numero by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        //Icono de telefono
        Icon(
            imageVector = Icons.Default.Phone,
            contentDescription = "Icono telefono",
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.CenterHorizontally),
            tint = Color(0xFF19A7D2)
        )
        Spacer(modifier = Modifier.height(64.dp))

        //Campos de texto donde se ingresa el numero
        Text("Escribe el numero que quieras guardar:")
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = numero,
            onValueChange = { numero = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Número") },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF9D9D83),
                unfocusedContainerColor = Color(0xFFF0F5BF)
            )
        )

        Spacer(modifier = Modifier.height(32.dp))


        //Campos de texto donde se ingresa el mensaje
        Text("Escribe el mensaje que se mostrara automaticamente:")
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = mensaje,
            onValueChange = { mensaje = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Mensaje") },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF9D9D83),
                unfocusedContainerColor = Color(0xFFF0F5BF)
            )
        )

        Spacer(modifier = Modifier.height(50.dp))

        //Boton de guardar
        Button(
            onClick = {
                val prefs = context.getSharedPreferences("datos", Context.MODE_PRIVATE)
                prefs.edit()
                    .putString("numero", numero)
                    .putString("mensaje", mensaje)
                    .apply()
                Toast.makeText(context, "Teléfono guardado correctamente", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFEC922C),
                contentColor = Color.White
            )
        ) {
            Text("Guardar")
        }
    }
}
