package com.example.pizzaparty3.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.pizzaparty3.ui.theme.PizzaParty3Theme

@Composable
fun NumPeopleField(onValueChange: (String) -> Unit, numPeople: String = "", modifier: Modifier = Modifier) {
    Toast.makeText(LocalContext.current, "NumPeopleField recomposed", Toast.LENGTH_SHORT).show()
    TextField(
        label = { Text("Enter number of people in your party:") },
        value = numPeople,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = onValueChange,
        modifier = modifier
    )

}

@Composable
fun PizzaPartyScreen(pvm: PizzaPartyViewModel, modifier: Modifier = Modifier) {

//    var numPeople by remember { mutableStateOf("") }

    Column {
        Text(
            text = "Pizza Party",
            modifier = modifier
        )

//    var numPeople by remember { mutableStateOf("") }
//    var numPeople = ""
        NumPeopleField({Log.d("MainActivity", it)
            pvm.numPeopleInput = it }, numPeople = pvm.numPeopleInput
        )

//    var selectedOption by remember { mutableStateOf("Light") }
        //val isOptionSelected: (String)->Boolean = {pvm.selectedOption == it}

        RadioButtonGroup({ pvm.selectedOption = "Light" }, onClickMedium = { pvm.selectedOption = "Medium" }, onClickRavenous = { pvm.selectedOption = "Ravenous" }, selectedOption = pvm.selectedOption, )


        //   var totalPizzas =0
        // var totalPizzas  by remember {  mutableIntStateOf(0) }

        Text(text = "Total pizzas: ${pvm.totalPizzas}")

        val context = LocalContext.current
        Button(onClick = {
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            pvm.calculateNumPizzas()
        }){
            Text(text = "Calculate")
        }


    }

}

@Composable
fun RadioButtonGroup(onClickLight: ()->Unit, onClickMedium: ()->Unit, onClickRavenous: ()->Unit, selectedOption: String) {
    Toast.makeText(LocalContext.current, "Radio button recomposed", Toast.LENGTH_SHORT).show()
    Text(text = "How hungry are they?")
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(onClick = onClickLight, selected = (selectedOption == "Light"))
        Text(text = "Light")
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(onClick = onClickMedium, selected = (selectedOption == "Medium"))
        Text(text = "Medium")
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            onClick = onClickRavenous,
            selected = (selectedOption == "Ravenous")
        )
        Text(text = "Ravenous")
    }
}

@Preview(showBackground = true)
@Composable
fun PizzaPartyScreenPreview() {
    PizzaParty3Theme {
        PizzaPartyScreen(pvm= PizzaPartyViewModel())
    }
}