package me.bodnarsg.simplecalculatorkuzstu.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.bodnarsg.simplecalculatorkuzstu.domain.CalculatorViewModel

enum class CalculatorButtonType {
    NUMBER,
    OPERATOR,
    PRIMARY_ACTION,
}

data class CalculatorButton(
    val label: String,
    val type: CalculatorButtonType,
)

@Composable
fun CalculatorView(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel
) {
    val expression by viewModel.expression.collectAsState()
    val buttons: List<CalculatorButton> = listOf(
        CalculatorButton("AC", CalculatorButtonType.OPERATOR),
        CalculatorButton("⌫", CalculatorButtonType.OPERATOR),
        CalculatorButton("%", CalculatorButtonType.OPERATOR),
        CalculatorButton("/", CalculatorButtonType.OPERATOR),
        CalculatorButton("7", CalculatorButtonType.NUMBER),
        CalculatorButton("8", CalculatorButtonType.NUMBER),
        CalculatorButton("9", CalculatorButtonType.NUMBER),
        CalculatorButton("*", CalculatorButtonType.OPERATOR),
        CalculatorButton("4", CalculatorButtonType.NUMBER),
        CalculatorButton("5", CalculatorButtonType.NUMBER),
        CalculatorButton("6", CalculatorButtonType.NUMBER),
        CalculatorButton("-", CalculatorButtonType.OPERATOR),
        CalculatorButton("1", CalculatorButtonType.NUMBER),
        CalculatorButton("2", CalculatorButtonType.NUMBER),
        CalculatorButton("3", CalculatorButtonType.NUMBER),
        CalculatorButton("+", CalculatorButtonType.PRIMARY_ACTION),
        CalculatorButton("SW", CalculatorButtonType.NUMBER),
        CalculatorButton("0", CalculatorButtonType.NUMBER),
        CalculatorButton(".", CalculatorButtonType.NUMBER),
        CalculatorButton("=", CalculatorButtonType.PRIMARY_ACTION),
    )

    return Box(modifier.fillMaxSize()){
        Column(
            modifier = modifier.align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.End
            ){
            IconButton(
                onClick = {}
            ) {
                Icon(Icons.Filled.MoreVert,
                    contentDescription = "Menu",

                    modifier= Modifier.height(25.dp)

                )
            }
            Spacer(Modifier.weight(1f))
            Text(
                text = expression,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 35.dp, start = 35.dp)
                    .horizontalScroll(rememberScrollState()),
                style = TextStyle(
                    textAlign = TextAlign.End,
                    fontSize = 44.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            LazyVerticalGrid(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 25.dp,
                            topEnd = 25.dp
                        )
                    ),
                columns = GridCells.Fixed(4)
            ) {
                items(buttons.size) {
                    val button = buttons[it]
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .background(color = when(button.type){
                                CalculatorButtonType.NUMBER -> androidx.compose.material3.MaterialTheme.colorScheme.secondary
                                CalculatorButtonType.OPERATOR -> androidx.compose.material3.MaterialTheme.colorScheme.tertiary
                                CalculatorButtonType.PRIMARY_ACTION -> androidx.compose.material3.MaterialTheme.colorScheme.primary
                            })
                            .aspectRatio(1f)
                            .clickable{
                                viewModel.onButtonClick(button.label)
                            }
                    ) {
                        Text(button.label,
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold
                            ))
                    }
                }
            }
        }
    }
}