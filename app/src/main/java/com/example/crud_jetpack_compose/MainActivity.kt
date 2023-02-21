package com.example.crud_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.crud_jetpack_compose.ui.theme.CRUD_Jetpack_ComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            CRUD_Jetpack_ComposeTheme {

                val listaUsuarios = remember { mutableStateListOf<Usuario>() }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ScreenCRUD(listaUsuarios)
                    }
                }
            }
        }
    }
}

@Composable
fun ScreenCRUD(listaUsuarios: MutableList<Usuario>) {

    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var isEditando by remember { mutableStateOf(false) }
    var textButton by remember { mutableStateOf("Agregar Usuario") }

    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(12.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()
        ) {
            Formulario(
                nombre = nombre,
                funNombre = { nombre = it },
                email = email,
                funEmail = { email = it },
                isEditando = isEditando,
                funIsEditando = { isEditando = false },
                textButton = textButton,
                funTextButton = { textButton = it },
                listaUsuarios = listaUsuarios,
                funResetCampos = {
                    nombre = ""
                    email = "" 
                }
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(listaUsuarios) { usuario ->

                        CardUsuario(
                            funNombre = { nombre = it },
                            funEmail =  { email = it },
                            usuario = usuario,
                            funTextButton = { textButton = it },
                            funIsEditando = { isEditando = it },
                            funBorrarUsuario = { borrarUsuario(it, listaUsuarios) }
                        )
                    }
                }
            }
        }
    }
}

fun agregarUsuario(nombre: String, email: String, listaUsuarios: MutableList<Usuario>) {
    listaUsuarios.add(Usuario(nombre, email))
}

fun editarUsuario(nombre: String, email: String, listaUsuarios: MutableList<Usuario>) {
    listaUsuarios.forEach { usuario ->
        if (usuario.nombre == nombre) {
            usuario.email = email
        }
    }
}

fun borrarUsuario(nombre: String, listaUsuarios: MutableList<Usuario>) {
    listaUsuarios.forEach { usuario ->
        if (usuario.nombre == nombre) {
            listaUsuarios.remove(usuario)
        }
    }
}
