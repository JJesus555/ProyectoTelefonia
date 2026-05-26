package com.example.telefoniaapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.telephony.SmsManager
import android.util.Log

class CallReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
// Detecta una llamada entrante y si es que el número coincide con el que estaba guardado
        if (intent.action == "android.intent.action.PHONE_STATE") {
            val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)

            if (state == TelephonyManager.EXTRA_STATE_RINGING) {
                val incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
                Log.d("CALL", "Número entrante: $incomingNumber")

                val prefs = context.getSharedPreferences("datos", Context.MODE_PRIVATE)
                val savedNumber = prefs.getString("numero", "")
                val mensaje = prefs.getString("mensaje", "")

                if (incomingNumber != null && incomingNumber == savedNumber) {

                    try {
                        val smsManager = SmsManager.getDefault()
                        smsManager.sendTextMessage(
                            incomingNumber,
                            null,
                            mensaje,
                            null,
                            null
                        )

                        Log.d("SMS", "Mensaje enviado")
                    } catch (e: Exception) {
                        Log.e("SMS", "Error enviando SMS: ${e.message}")
                    }
                }
            }
        }
    }
}