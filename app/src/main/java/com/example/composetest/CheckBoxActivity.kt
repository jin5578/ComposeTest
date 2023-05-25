package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetest.ui.theme.ComposeTheme

class CheckBoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                CheckBoxExample()
            }
        }
    }
}

@Composable
fun CheckBoxExample() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        // 스텝 1: Checkbox를 만들어봅시다. checked 속성은 false
        // onCheckedChange는 비워둡시다.
        /*Checkbox(checked = false, onCheckedChange = {})*/

        // 스텝 2: onCheckedChange에서 boolean 값 변수를 바꾸고
        // checked에서 그 값을 반영해봅시다. (잘 되지 않습니다.)
        /*var checked = false
        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = !checked
            }
        )*/

        // 스텝 3: boolean 대신 remember { mutableStateOf(false) }를
        // 사용하여 상태를 도입합시다. (value 프로퍼티를 이용해야 합니다.)
        /*var checked = remember { mutableStateOf(false) }
        Checkbox(
            checked = checked.value,
            onCheckedChange = {
                checked.value = !checked.value
            }
        )*/

        // 스텝 4: delegated properties로 변경해봅시다.
        /*var checked by remember {
            mutableStateOf(false)
        }
        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = !checked
            }
        )*/
        // 스텝 5: destruction으로 상태를 받아서 사용해봅시다.
        val (getter, setter) = remember {
            mutableStateOf(false)
        }
        Checkbox(
            checked = getter,
            onCheckedChange = setter
        )

        // Checkbox를 앞에 넣어주세요.
        Text(
            text = "프로그래머입니까?",
            modifier = Modifier.clickable {
                setter(!getter)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CheckBoxPreview() {
    ComposeTheme {
        CheckBoxExample()
    }
}