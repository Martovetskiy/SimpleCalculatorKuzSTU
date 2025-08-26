package me.bodnarsg.simplecalculatorkuzstu.domain

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.udojava.evalex.Expression
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CalculatorViewModel : ViewModel() {
    private val _expression = MutableStateFlow("")
    val expression: StateFlow<String> = _expression

    private val _isDarkTheme = MutableStateFlow(false)
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme

    fun onButtonClick(label: String) {
        if (expression.value.contains("Ошибка")) {
            _expression.value = ""
        }
        when (label) {
            "AC" -> _expression.value = ""
            "⌫" -> _expression.value = _expression.value.dropLast(1)
            "=" -> calculateResult()
            "SW" -> {
                _isDarkTheme.value = !_isDarkTheme.value
            }
            else -> _expression.value += label
        }
    }

    private fun calculateResult() {
        try {
            val result = Expression(_expression.value).eval().toString()
            _expression.value = result
        } catch (e: Exception) {
            _expression.value = "Ошибка"
        }
    }
}