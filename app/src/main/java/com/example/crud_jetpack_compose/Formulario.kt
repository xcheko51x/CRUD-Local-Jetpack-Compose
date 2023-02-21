package com.example.crud_jetpack_compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun Formulario(
    nombre: String,
    funNombre: (String) -> Unit,
    email: String,
    funEmail: (String) -> Unit,
    isEditando: Boolean,
    funIsEditando: () -> Unit,
    textButton: String,
    funTextButton: (String) -> Unit,
    listaUsuarios: MutableList<Usuario>,
    funResetCampos: () -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = nombre,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funNombre(it) },
        label = { Text(text = "Nombre") },
        enabled = !isEditando
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = email,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funEmail(it) },
        label = { Text(text = "Email") }
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    Button(modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
        onClick = {
            if (isEditando) {
                editarUsuario(nombre, email, listaUsuarios)
                funTextButton("Agregar Usuario")
                funIsEditando()

            } else {
                agregarUsuario(nombre, email, listaUsuarios)
            }
            funResetCampos()
        }
    ) {
        Text(
            color = Color.White,
            text = textButton
        )
    }
}