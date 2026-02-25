package com.example.pizzaparty3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.pizzaparty3.ui.PizzaPartyScreen
import com.example.pizzaparty3.ui.PizzaPartyViewModel
import com.example.pizzaparty3.ui.theme.PizzaParty3Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val pvm = remember { PizzaPartyViewModel() }
            PizzaParty3Theme(
                dynamicColor = false
            ) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Pizza Party")
                            }
                        )
                    }
                ) { innerPadding ->
                    PizzaPartyScreen(
                        pvm = pvm,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
