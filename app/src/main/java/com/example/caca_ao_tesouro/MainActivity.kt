package com.example.caca_ao_tesouro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.caca_ao_tesouro.ui.theme.Caca_ao_tesouroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val meuNavController = rememberNavController()
            NavHost(navController = meuNavController, startDestination = "Tela01"){
                composable("TelaInicial") {
                    TelaInicial(onNavEnigma01 ={meuNavController.navigate("Enigma01")})
                }
                composable("Enigma01") {
                    Enigma01()
                }
                composable("Enigma02") {
                    Enigma02()
                }
                composable("Enigma03") {
                    Enigma03()
                }
                composable("Tesouro") {
                    Tesouro()
                }
            }
        }
    }
}

@Composable
fun TelaInicial(onNavEnigma01: () -> Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Caça ao Tesouro",
            fontSize = 24.sp
        )
        Button(onClick = {onNavEnigma01}) {
            Text("Começar!")
        }
    }
}

fun Enigma01(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Enigma01",
            fontSize = 24.sp
        )
        Button(onClick = {onNavEnigma02}) {
            Text("!")
        }
        Button(onClick = {onNavEnigma02}) {
            Text("!")
        }
    }
}

fun Enigma02(){

}

fun Enigma03(){

}

fun Tesouro(){

}

@Preview(showBackground = true)
@Composable
fun MeuPreview(){
    TelaInicial {  }
}