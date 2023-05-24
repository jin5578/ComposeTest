package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest.ui.theme.ComposeTheme

class ColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme() {
                ColumnExample()
            }
        }
    }
}

@Composable
fun ColumnExample() {
    /*Column(modifier = Modifier.size(100.dp)) {
        Text(text = "첫 번째")
        Text(text = "두 번째")
        Text(text = "세 번째")
    }*/

    // 스텝 1: horizontalAlignment를 Column에 적용해봅시다.
    /*Column(
        modifier = Modifier.size(100.dp),
        horizontalAlignment = Alignment.End
    ) {
        Text(text = "첫 번째")
        Text(text = "두 번째")
        Text(text = "세 번째")
    }*/

    // 스텝 2: Column에 verticalArrangement를 지정해봅시다.
    // SpaceAround, SpaceEvenly, SpaceBetween도 해봅시다.
    /*Column(
        modifier = Modifier.size(100.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "첫 번째")
        Text(text = "두 번째")
        Text(text = "세 번째")
    }*/

    // 스텝 3: Text에 Modifier.align을 사용해 봅시다.
    Column(
        modifier = Modifier.size(100.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "첫 번째",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "두 번째",
            modifier = Modifier.align(Alignment.Start)
        )
        Text(
            text = "세 번째",
            modifier = Modifier.align(Alignment.End)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnPreview() {
    ComposeTheme {
        ColumnExample()
    }
}