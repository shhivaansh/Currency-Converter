package eu.tutorials.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.tutorials.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CurrencyConverter()
                }
            }
        }
    }
}

@Composable
fun CurrencyConverter() {

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Select") }
    var outputUnit by remember { mutableStateOf("Select") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(1.00) }
    val oConversionFactor = remember { mutableStateOf(1.00) }

    fun convertUnits(){
        val inputValueDouble=inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100.0/oConversionFactor.value).roundToInt() / 100.0
        outputValue = result.toString()
    }

    Column(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Currency Converter",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Unspecified
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                inputValue=it
                convertUnits()
            },
            label = { Text("Enter value")})
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Box {
                Button(onClick = { iExpanded = true }) {
                    Text(inputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                }
                DropdownMenu(
                    expanded = iExpanded,
                    onDismissRequest = { iExpanded = false },
                    modifier = Modifier.verticalScroll(rememberScrollState()).height(200.dp)
                ) {
                    DropdownMenuItem(
                        text = { Text("US Dollar") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "US Dollar"
                            conversionFactor.value = 1.0
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Euro") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Euro"
                            conversionFactor.value = 1.09
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("British Pound") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "British Pound"
                            conversionFactor.value = 0.015
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Japanese Yen") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Japanese Yen"
                            conversionFactor.value = 0.0254
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Australian Dollar") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Australian Dollar"
                            conversionFactor.value = 0.67
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Canadian Dollar") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Canadian Dollar"
                            conversionFactor.value = 0.76
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Swiss Franc") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Swiss Franc"
                            conversionFactor.value = 1.02
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Chinese Yuan") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Chinese Yuan"
                            conversionFactor.value = 0.14
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Indian Rupee") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Indian Rupee"
                            conversionFactor.value = 0.012
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Russian Ruble") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Russian Ruble"
                            conversionFactor.value = 0.013
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Swedish Krona") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Swedish Krona"
                            conversionFactor.value = 0.091
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Singapore Dollar") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Singapore Dollar"
                            conversionFactor.value = 0.74
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("South Korean Won") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "South Korean Won"
                            conversionFactor.value = 0.00084
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Mexican Peso") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Mexican Peso"
                            conversionFactor.value = 0.053
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Brazilian Real") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Brazilian Real"
                            conversionFactor.value = 0.19
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("South African Rand") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "South African Rand"
                            conversionFactor.value = 0.071
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Turkish Lira") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Turkish Lira"
                            conversionFactor.value = 0.074
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("New Zealand Dollar") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "New Zealand Dollar"
                            conversionFactor.value = 0.64
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Norwegian Krone") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Norwegian Krone"
                            conversionFactor.value = 0.11
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Thai Baht") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Thai Baht"
                            conversionFactor.value = 0.031
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Indonesian Rupiah") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Indonesian Rupiah"
                            conversionFactor.value = 0.000071
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Malaysian Ringgit") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Malaysian Ringgit"
                            conversionFactor.value = 0.24
                            convertUnits()
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                Button(onClick = { oExpanded = true }) {
                    Text(outputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                }
                DropdownMenu(
                    expanded = oExpanded,
                    onDismissRequest = { oExpanded = false },
                    modifier = Modifier.verticalScroll(rememberScrollState()).height(200.dp)
                ) {
                    DropdownMenuItem(
                        text = { Text("US Dollar") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "US Dollar"
                            oConversionFactor.value = 1.0
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Euro") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Euro"
                            oConversionFactor.value = 1.09
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("British Pound") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "British Pound"
                            oConversionFactor.value = 0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Japanese Yen") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Japanese Yen"
                            oConversionFactor.value = 0.0254
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Australian Dollar") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Australian Dollar"
                            oConversionFactor.value = 0.67
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Canadian Dollar") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Canadian Dollar"
                            oConversionFactor.value = 0.76
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Swiss Franc") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Swiss Franc"
                            oConversionFactor.value = 1.02
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Chinese Yuan") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Chinese Yuan"
                            oConversionFactor.value = 0.14
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Indian Rupee") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Indian Rupee"
                            oConversionFactor.value = 0.012
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Russian Ruble") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Russian Ruble"
                            oConversionFactor.value = 0.013
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Swedish Krona") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Swedish Krona"
                            oConversionFactor.value = 0.091
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Singapore Dollar") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Singapore Dollar"
                            oConversionFactor.value = 0.74
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("South Korean Won") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "South Korean Won"
                            oConversionFactor.value = 0.00084
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Mexican Peso") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Mexican Peso"
                            oConversionFactor.value = 0.053
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Brazilian Real") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Brazilian Real"
                            oConversionFactor.value = 0.19
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("South African Rand") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "South African Rand"
                            oConversionFactor.value = 0.071
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Turkish Lira") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Turkish Lira"
                            oConversionFactor.value = 0.074
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("New Zealand Dollar") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "New Zealand Dollar"
                            oConversionFactor.value = 0.64
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Norwegian Krone") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Norwegian Krone"
                            oConversionFactor.value = 0.11
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Thai Baht") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Thai Baht"
                            oConversionFactor.value = 0.031
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Indonesian Rupiah") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Indonesian Rupiah"
                            oConversionFactor.value = 0.000071
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Malaysian Ringgit") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Malaysian Ringgit"
                            oConversionFactor.value = 0.24
                            convertUnits()
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Result: $outputValue $outputUnit",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Preview
@Composable
fun CurrencyConverterPreview(){
    CurrencyConverter()
}
