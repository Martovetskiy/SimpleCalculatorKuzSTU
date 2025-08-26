package me.bodnarsg.simplecalculatorkuzstu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import me.bodnarsg.simplecalculatorkuzstu.domain.CalculatorViewModel
import me.bodnarsg.simplecalculatorkuzstu.ui.theme.SimpleCalculatorKuzSTUTheme
import me.bodnarsg.simplecalculatorkuzstu.ui.views.CalculatorView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel: CalculatorViewModel by viewModels()
        setContent {
            val isDarkTheme by viewModel.isDarkTheme.collectAsState()
            SimpleCalculatorKuzSTUTheme(darkTheme = isDarkTheme) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculatorView(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}