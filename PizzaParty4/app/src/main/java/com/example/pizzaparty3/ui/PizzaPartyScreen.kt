package com.example.pizzaparty3.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzaparty3.ui.theme.PizzaParty3Theme

@Composable
fun NumPeopleField(onValueChange: (String) -> Unit, numPeople: String = "", modifier: Modifier = Modifier) {
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
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        NumPeopleField(
            onValueChange = {
                pvm.numPeopleInput = it
            },
            numPeople = pvm.numPeopleInput,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        RadioButtonGroup(
            {
                pvm.selectedOption = "Light"
            },
            onClickMedium = {
                pvm.selectedOption = "Medium"
            },
            onClickRavenous = {
                pvm.selectedOption = "Ravenous"
            },
            selectedOption = pvm.selectedOption
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Total pizzas: ${pvm.totalPizzas}")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = pvm::calculateNumPizzas) {
            Text(text = "Calculate")
        }
    }
}

@Composable
fun RadioButtonGroup(onClickLight: () -> Unit, onClickMedium: () -> Unit, onClickRavenous: () -> Unit, selectedOption: String) {
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
    PizzaParty3Theme(darkTheme = false, dynamicColor = false) {
        PizzaPartyScreen(pvm = PizzaPartyViewModel())
    }
}
