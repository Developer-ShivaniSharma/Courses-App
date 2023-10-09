package com.myapp.coursesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myapp.coursesapp.model.Topic
import com.myapp.coursesapp.ui.theme.CoursesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseLayoutApp()
                }
            }
        }
    }
}

@Composable
fun CourseLayoutApp() {
}

@Composable
fun CourseLayout(topic: Topic, modifier: Modifier = Modifier) {
    Box {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(topic.imageResourceID),
                contentDescription = stringResource(topic.topicName),
                modifier = Modifier.padding(10.dp)
            )
            Column {
                Text(
                    text = LocalContext.current.getString(topic.topicName),
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 8.dp
                    ),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row {
                    Image(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier.padding(start = 16.dp, end = 8.dp),
                        colorFilter = ColorFilter.tint(Color.Black)
                    )
                    Text(
                        text = topic.associatedCourse.toString(),
                        modifier = Modifier.padding(top = 5.dp),
                        style = MaterialTheme.typography.labelMedium
                    )

                }

            }
        }
    }
}

@Composable
fun CourseList(topicList: List<Topic>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier) {
        items(topicList) { topic ->
            CourseLayout(
                topic = topic,
                modifier = Modifier.padding(16.dp)
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun CourseLayoutPreview() {
    CoursesAppTheme {
        CourseLayout(Topic(R.string.architecture, 58, R.drawable.architecture))
    }
}
@Preview(showBackground = true)
@Composable
fun CourseListPreview() {
    CourseList(topicList = listOf(
        Topic(R.string.architecture, 58, R.drawable.architecture),
        Topic(R.string.architecture, 58, R.drawable.architecture),
        Topic(R.string.architecture, 58, R.drawable.architecture),
        Topic(R.string.architecture, 58, R.drawable.architecture),
        Topic(R.string.architecture, 58, R.drawable.architecture),
        Topic(R.string.architecture, 58, R.drawable.architecture),
        Topic(R.string.architecture, 58, R.drawable.architecture),
        Topic(R.string.architecture, 58, R.drawable.architecture),
        Topic(R.string.architecture, 58, R.drawable.architecture),
        Topic(R.string.architecture, 58, R.drawable.architecture),
        Topic(R.string.architecture, 58, R.drawable.architecture),
    )
    )
}