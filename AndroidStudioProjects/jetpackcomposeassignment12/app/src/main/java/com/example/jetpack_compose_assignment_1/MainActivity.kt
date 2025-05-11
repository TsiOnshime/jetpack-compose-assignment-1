package com.example.jetpack_compose_assignment_1

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose_assignment_1.R
import com.example.jetpack_compose_assignment_1.ui.theme.Jetpackcomposeassignment1Theme

data class Course(
    val title: String,
    val code: String,
    val creditHours: Int,
    val description: String,
    val prerequisites: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpackcomposeassignment1Theme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    Surface(modifier, color = MaterialTheme.colorScheme.background) {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            CourseListScreen()
        }
    }
}

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Academic Courses!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("View Courses")
        }
    }
}

@Composable
fun CourseListScreen(modifier: Modifier = Modifier) {
    val courses = remember {
        listOf(
            Course(
                "Introduction to Python Programing",
                "CS101",
                3,
                "This foundational course provides a comprehensive introduction to the Python programming language. Students will learn fundamental programming concepts, including data types, control flow, functions, and basic object-oriented principles. Through hands-on exercises and projects, learners will develop the ability to write clear, concise, and functional Python code for a variety of applications. No prior programming experience is required.",
                "None"
            ),
            Course(
                "Data Structures and Algorithms",
                "CS201",
                4,
                "This course covers fundamental data structures and algorithms.",
                "CS101"
            ),
            Course(
                "Calculus I",
                "MA101",
                4,
                "An introductory course to differential calculus.",
                "None"
            ),
            Course(
                "Fundamentals of Networking",
                "NET101",
                3,
                "This course delves into the foundational principles and theoretical underpinnings of computer networking. Topics include network architectures, communication protocols, data transmission techniques, network addressing and routing algorithms, and an introduction to network performance analysis. Students will develop a strong conceptual understanding of how data is transmitted and managed across networks, laying the groundwork for more advanced networking studies.",
                "MA101"
            ),
            Course(
                "Web Development Fundamentals",
                "IT205",
                3,
                "Learn the basics of HTML, CSS, and JavaScript for web development.",
                "None"
            ),
            Course(
                "Fundamentals of Software Engineering",
                "SWE100",
                4,
                "Fundamentals of Software Engineering provides a practical introduction to the discipline of creating robust and maintainable software systems. Through hands-on exercises and case studies, students will learn about planning, designing, building, and testing software. Key topics include requirements gathering, software architecture basics, coding best practices, and fundamental testing techniques.",
                "IT205"
            )
        )
    }
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(courses) { course ->
            CourseItem(course = course)
        }
    }
}

@Composable
fun CourseItem(course: Course, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CourseContent(course = course)
    }
}

@Composable
private fun CourseContent(course: Course) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(
                text = course.title,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            Text(text = "Code: ${course.code}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Credits: ${course.creditHours}", style = MaterialTheme.typography.bodyMedium)
            if (expanded) {
                Text(text = "Description: ${course.description}", style = MaterialTheme.typography.bodySmall)
                Text(text = "Prerequisites: ${course.prerequisites}", style = MaterialTheme.typography.bodySmall)
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Filled.ExpandLess else Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "CourseListPreviewDark"
)
@Preview(showBackground = true, widthDp = 320)
@Composable
fun CourseListPreview() {
    Jetpackcomposeassignment1Theme {
        CourseListScreen()
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    Jetpackcomposeassignment1Theme {
        OnboardingScreen(onContinueClicked = {})
    }
}

@Preview
@Composable
fun MyAppPreview() {
    Jetpackcomposeassignment1Theme {
        MyApp(Modifier.fillMaxSize())
    }
}