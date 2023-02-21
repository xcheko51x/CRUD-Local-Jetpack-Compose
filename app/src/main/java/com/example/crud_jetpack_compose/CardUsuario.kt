package com.example.crud_jetpack_compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CardUsuario(
    funNombre: (String) -> Unit,
    funEmail: (String) -> Unit,
    funTextButton: (String) -> Unit,
    funIsEditando: (Boolean) -> Unit,
    usuario: Usuario,
    funBorrarUsuario: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            Arrangement.Center
        ) {
            Text(
                text = usuario.nombre,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = usuario.email,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                    onClick = {
                        funNombre(usuario.nombre)
                        funEmail(usuario.email)
                        funTextButton("Editar Usuario")
                        funIsEditando(true)
                    }
                ) {
                    Text(
                        color = Color.White,
                        text = "Editar"
                    )
                }
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                    onClick = {
                        funBorrarUsuario(usuario.nombre)
                    }
                ) {
                    Text(
                        color = Color.White,
                        text = "Borrar"
                    )
                }
            }
        }
    }
}