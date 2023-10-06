package com.myapp.coursesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
fun CourseLayoutApp(){}

@Composable
fun CourseLayout(topic:Topic, modifier: Modifier = Modifier) {
Box(modifier=modifier) {
    Row {
        Image(painter = painterResource(topic.imageResourceID),
            contentDescription = stringResource(topic.topicName),
            modifier=Modifier.padding(68.dp))
        Text(
            text = LocalContext.current.getString(topic.topicName),
            modifier=Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium)
    }
}
}

@Preview(showBackground = true)
@Composable
fun CourseLayoutPreview() {
    CoursesAppTheme {
        CourseLayout(Topic(R.string.architecture,58,R.drawable.architecture))
    }
}