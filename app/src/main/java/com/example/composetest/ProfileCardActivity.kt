package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.composetest.ui.theme.ComposeTheme

class ProfileCardActivity : ComponentActivity() {
    companion object {
        val cardData = CardData(
            imageUri = "https://w7.pngwing.com/pngs/930/532/png-transparent-computer-icons-personal-web-page-user-name-icon-monochrome-user-tag.png",
            imageDescription = "엔텔로프 캐년",
            author = "Dalinaum",
            description = "엔텔로프 캐년은 죽기 전에 꼭 봐야할 절경으로 소개되었습니다."
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        ProfileCardExample(data = cardData)
                        ProfileCardExample(data = cardData)
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileCardExample(data: CardData) {
    val placeHolderColor = Color(0x33000000)

    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(4.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            // 스텝 1: `AsyncImage`, `Spacer`, `Column`, `Text`로
            // 레이아웃을 만들어보세요.
            /*AsyncImage(
                model = data.imageUri,
                contentDescription = data.imageDescription,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column {
                Text(
                    text = data.author
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = data.description
                )
            }*/

            // 스텝 2: `AsyncImage`에는 `placeholder`를 지정하고,
            // `contentScale`을 `ContentScale.Crop`으로 설정합시다.
            // `clip(CircleShape)`로 둥근 외양을 만들어 봅시다.
            AsyncImage(
                model = data.imageUri,
                contentScale = ContentScale.Crop,
                contentDescription = data.imageDescription,
                placeholder = ColorPainter(placeHolderColor),
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column {
                Text(
                    text = data.author
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = data.description
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileCardPreview() {
    ComposeTheme {
        Row {
            ProfileCardExample(ProfileCardActivity.cardData)
        }
    }
}

data class CardData(
    val imageUri: String,
    val imageDescription: String,
    val author: String,
    val description: String
)