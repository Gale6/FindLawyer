package com.revature.findlawyer.ui.postreview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import kotlin.math.roundToInt
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import com.revature.findlawyer.DrawerScreens
import com.revature.findlawyer.ui.postreview.ui.theme.FindLawyerTheme
import com.revature.findlawyer.viewmodel.PostReviewViewModel


@Composable
fun screen_postReview(navHostController: NavHostController, viewModel:PostReviewViewModel) {
    var headline = remember() {mutableStateOf("")}
    var body = remember() {mutableStateOf("")}
    var expanded by remember { mutableStateOf(false) }
    var ratingSliderValue = remember() { mutableStateOf(0f)}


    val suggestions = listOf("1","2", "3", "4", "5")
    var selectedText = remember() { mutableStateOf("")}
    var textfieldSize by remember { mutableStateOf(Size.Zero)}
    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current




    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = MaterialTheme.colors.primary,
                title = {Text("Post Review")})
        }
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = headline.value,
                onValueChange = { headline.value = it },
                label = { Text(text = "Headline") },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color(0xff586ae0),
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                )
            )

            TextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(200.dp),
                value = body.value,
                onValueChange = { body.value = it },
                label = { Text(text = "Write a review...") },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color(0xff586ae0),
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                )
            )

//slider
            Text(text = "Rating: ${ratingSliderValue.value.roundToInt()}"+"/5",
                color = MaterialTheme.colors.primary,
                modifier = Modifier.padding(top = 16.dp)
            )
            Slider(
                value = ratingSliderValue.value,
                valueRange = 0f..5f,
                colors = SliderDefaults.colors(
                    activeTrackColor = Color.Yellow,
                    inactiveTrackColor = Color.LightGray,
                    inactiveTickColor = Color.Black,
                    thumbColor = Color.Yellow),
                modifier = Modifier.padding(4.dp)
                    .width(200.dp),
                steps = 3,
                onValueChange = { newValue ->
                    ratingSliderValue.value = newValue
                }
            )

            Button(onClick = {
                viewModel.newReview(ratingSliderValue.value,headline.value,body.value)
                Toast.makeText(context, "Review submitted", Toast.LENGTH_SHORT).show()
                navHostController.navigate(DrawerScreens.Screen_Histories.route)
            }) {
                Text(text = "Submit")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    FindLawyerTheme {
//        screen_postReview()
    }
}