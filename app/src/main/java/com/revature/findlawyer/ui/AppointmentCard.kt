package com.revature.findlawyer.ui

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.findlawyer.ui.theme.FindLawyerTheme
import kotlin.math.round

@Composable
fun AppointmentCard(targetName:String,time:String){
    
    Card(modifier = Modifier
        .fillMaxWidth()
        .border(
            width = 2.dp,
            color = androidx.compose.ui.graphics.Color.Black,
            shape = RectangleShape
        )
    ) {

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {

            Spacer(modifier = Modifier)

            Text(text = targetName)

            Text(text = time)

            Column {
                Button(modifier = Modifier
                    .width(130.dp)
                    .padding(3.dp),
                    shape = RoundedCornerShape(6.dp),
                    onClick = { /*TODO*/ }) {
                    Text(text = "reschedule")
                }
                //Spacer(modifier = Modifier.height(3.dp))

                Button(modifier = Modifier
                    .width(130.dp)
                    .padding(3.dp),
                    shape = RoundedCornerShape(6.dp),
                    onClick = { /*TODO*/ }) {
                    Text(text = "cancel")
                }
            }



        }
    }
}

@Preview
@Composable
fun AppointmentCardPreview() {
    FindLawyerTheme {
        AppointmentCard(targetName = "john", time = "3/22/22 14:00")
    }
}