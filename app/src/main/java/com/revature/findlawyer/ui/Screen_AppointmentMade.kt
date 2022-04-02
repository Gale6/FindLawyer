package com.revature.findlawyer.ui.ui


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Screen_AppointmentMade(/*navController: NavController*/typeOfChange:String, navMove: () -> Unit)
{
    Scaffold(){

        Column(modifier = Modifier
            .fillMaxSize()
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        )
        {
            Spacer(Modifier.height(0.dp))

            Text(
                text = "Congratulations!",
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))


            Text(
                text = typeOfChange,
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(50.dp))

            Button(
                onClick = { navMove },
                modifier = Modifier
            )
            {
                Text(
                    "Back to Main",
                    fontSize = 30.sp
                )
            }
        }
    }
}