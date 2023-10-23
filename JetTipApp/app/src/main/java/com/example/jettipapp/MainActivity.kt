@file:OptIn(ExperimentalComposeUiApi::class)

package com.example.jettipapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jettipapp.components.InputField
import com.example.jettipapp.ui.theme.JetTipAppTheme
import com.example.jettipapp.util.calculateTotalPerPerson
import com.example.jettipapp.util.calculateTotalTip
import com.example.jettipapp.widgets.RoundIconButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetTipAppTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            content()
        }
    }
}

@Composable
fun TopHeader(totalPerPerson: Double = 134.0) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .height(150.dp)
            .clip(shape = RoundedCornerShape(corner = CornerSize(12.dp))),
        color = Color(0xFFE9D7F7)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val total = "%.2f".format(totalPerPerson)
            Text(
                text = "Total Per Peson",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "$$total",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun MainContent() {
    val splitByState = remember {
        mutableStateOf(1)
    }

    // val range = IntRange(start = 1, endInclusive = 100)

    val tipAmountState = remember {
        mutableStateOf(0.0)
    }

    val totalPerPersonState = remember {
        mutableStateOf(0.0)
    }

    Column(modifier = Modifier.padding(all = 12.dp)) {
        BillForm(
            splitByState = splitByState,
            tipAmountState = tipAmountState,
            totalPerPersonState = totalPerPersonState
        ) {}
    }
}

@Composable
fun BillForm(
    modifier: Modifier = Modifier,
    range: IntRange = 1..100,
    splitByState: MutableState<Int>,
    tipAmountState: MutableState<Double>,
    totalPerPersonState: MutableState<Double>,
    onValChange: (String) -> Unit = {}
) {

    val totalBillState = remember {
        mutableStateOf("")
    }

    val validState = remember(totalBillState.value) {
        totalBillState.value.trim().isNotEmpty()
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    val sliderPositionState = remember {
        mutableStateOf(0f)
    }

    val tipPercentage = (sliderPositionState.value * 100).toInt()

    Surface(
        modifier = modifier
            .padding(2.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {

        Column(
            modifier = modifier.padding(6.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            TopHeader(totalPerPerson = totalPerPersonState.value)

            Card(
                modifier = modifier.padding(5.dp),
                border = BorderStroke(width = 1.dp, color = Color.LightGray)
            ) {
                InputField(
                    modifier = modifier.padding(vertical = 10.dp),
                    valueState = totalBillState,
                    labelId = "Enter Bill",
                    enable = true,
                    isSingleLine = true,
                    onAction = KeyboardActions {
                        if (!validState) return@KeyboardActions
                        onValChange(totalBillState.value.trim())

                        keyboardController?.hide()
                    }
                )
                //   if (validState) {
                Row(
                    modifier = modifier.padding(start = 5.dp, end = 5.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Split", modifier = modifier
                            .align(
                                alignment = Alignment.CenterVertically
                            )
                            .padding(start = 3.dp)
                    )
                    Spacer(modifier = modifier.width(150.dp))
                    Row(
                        modifier = modifier.padding(horizontal = 3.dp),
                        horizontalArrangement = Arrangement.End,
                    ) {
                        RoundIconButton(
                            imageVector = Icons.Default.Remove,
                            onClick = {
                                splitByState.value =
                                    if (splitByState.value > 1) splitByState.value - 1 else 1

                                totalPerPersonState.value =
                                    calculateTotalPerPerson(
                                        totalBill = totalBillState.value.toDouble(),
                                        splitBy = splitByState.value,
                                        tipPercentage = tipPercentage
                                    )
                            })

                        Text(
                            text = "${splitByState.value}",
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(start = 9.dp, end = 9.dp)
                        )

                        RoundIconButton(
                            imageVector = Icons.Default.Add,
                            onClick = {
                                if (splitByState.value < range.last) {
                                    splitByState.value = splitByState.value + 1
                                }

                                totalPerPersonState.value =
                                    calculateTotalPerPerson(
                                        totalBill = totalBillState.value.toDouble(),
                                        splitBy = splitByState.value,
                                        tipPercentage = tipPercentage
                                    )
                            })
                    }

                }

                //TipRow
                Row(
                    modifier = modifier.padding(horizontal = 3.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Tip",
                        modifier = modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 3.dp)
                    )
                    Spacer(modifier = modifier.width(200.dp))
                    Text(
                        text = "$ ${tipAmountState.value}",
                        modifier = modifier.align(Alignment.CenterVertically)
                    )
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = modifier.height(30.dp))

                    Text(text = "$tipPercentage %")

                    Spacer(modifier = modifier.height(14.dp))

                    //Slider
                    Slider(
                        modifier = modifier.padding(start = 16.dp, end = 16.dp),
                        value = sliderPositionState.value,
                        onValueChange = { newVal ->
                            sliderPositionState.value = newVal
                            tipAmountState.value =
                                calculateTotalTip(
                                    totalBill = totalBillState.value.toDouble(),
                                    tipPercentage = tipPercentage
                                )
                            totalPerPersonState.value =
                                calculateTotalPerPerson(
                                    totalBill = totalBillState.value.toDouble(),
                                    splitBy = splitByState.value,
                                    tipPercentage = tipPercentage
                                )
                        },
                        onValueChangeFinished = {

                        }
                    )
                }
            }
        }
    }
}