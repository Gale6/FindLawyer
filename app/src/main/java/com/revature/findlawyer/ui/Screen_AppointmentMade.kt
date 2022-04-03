package com.revature.findlawyer.ui.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.revature.findlawyer.DrawerScreens
import com.revature.findlawyer.R

@Composable
fun Screen_AppointmentMade(navController: NavHostController,typeOfChange:String)
{
    Scaffold(){
        Image(painter = painterResource(id = R.drawable.searching), contentDescription = "",contentScale = ContentScale.FillBounds,alpha = .4f)

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
                onClick = { navController.navigate(DrawerScreens.Screen_CurrentAppointments.route) },
                modifier = Modifier
            )
            {
                Text(
                    "Back",
                    fontSize = 30.sp
                )
            }
        }
    }
}