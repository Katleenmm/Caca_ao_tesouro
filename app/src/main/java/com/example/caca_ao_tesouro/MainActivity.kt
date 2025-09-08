package com.example.caca_ao_tesouro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val meuNavController = rememberNavController()

            NavHost(navController = meuNavController, startDestination = "TelaInicial") {
                composable("TelaInicial") {
                    TelaInicial(onNavEnigma01 = {
                        meuNavController.navigate("Enigma01")
                    })
                }
                composable("Enigma01") {
                    Enigma01(onNavEnigma02 = {
                        meuNavController.navigate("Enigma02")
                    },onVoltar = {
                        meuNavController.popBackStack()
                    })
                }
                composable("Enigma02") {
                    Enigma02(onNavEnigma03 = {
                        meuNavController.navigate("Enigma03")
                    },onVoltar = {
                        meuNavController.popBackStack()
                    }
                    )
                }
                composable("Enigma03") {
                    Enigma03(onNavTesouro = {
                        meuNavController.navigate("Tesouro")
                    },onVoltar = {
                        meuNavController.popBackStack()
                    })
                }
                composable("Tesouro") {
                    Tesouro(onVoltarTelaInicial = {
                        meuNavController.navigate("TelaInicial") {
                            // Remove o backstack para evitar que o usuário volte com o botão "voltar"
                            popUpTo("TelaInicial") { inclusive = true }
                        }
                    })
                }
            }
        }
    }
}

@Composable
fun TelaInicial(onNavEnigma01: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Caça ao Tesouro \n \n - KIMETSU NO YAIBA -",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(24.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Button(onClick = { onNavEnigma01() }) {
            Text("Começar!", fontSize = 18.sp)
        }
    }
}

@Composable
fun Enigma01(onNavEnigma02: () -> Unit, onVoltar: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Enigma 01",
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.padding(24.dp))

        Text(
            text = "Qual o nome da técnica secreta da Respiração do Sol, passada na família Kamado como uma dança tradicional?",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.padding(24.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { onVoltar() }) {
                Text("Voltar", fontSize = 18.sp)
            }

            Button(onClick = { onNavEnigma02() }) {
                Text("Próximo Enigma", fontSize = 18.sp)
            }
        }
    }
}

@Composable
fun Enigma02(onNavEnigma03: () -> Unit,  onVoltar: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Enigma 02",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.padding(24.dp))

        Text(
            text = "Qual é o verdadeiro nome do Hashira do Som?",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.padding(24.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { onVoltar() }) {
                Text("Voltar", fontSize = 18.sp)
            }

            Button(onClick = { onNavEnigma03() }) {
                Text("Próximo Enigma", fontSize = 18.sp)
            }
        }
    }
}

@Composable
fun Enigma03(onNavTesouro: () -> Unit, onVoltar: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Enigma 03",
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.padding(24.dp))

        Text(
            text = "Por que as espadas dos caçadores de onis são chamadas de Nichirin?",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.padding(24.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { onVoltar() }) {
                Text("Voltar",fontSize = 18.sp)
            }

            Button(onClick = { onNavTesouro() }) {
                Text("Finalizar!",fontSize = 18.sp)
            }
        }
    }
}

@Composable
fun Tesouro(onVoltarTelaInicial: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Parabéns! Você encontrou o tesouro!",
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.padding(24.dp))
        Button(onClick = { onVoltarTelaInicial() }) {
            Text("Voltar ao início", fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MeuPreview() {
    TelaInicial { }
}
