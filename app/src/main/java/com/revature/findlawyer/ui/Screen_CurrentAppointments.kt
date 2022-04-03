package com.revature.findlawyer.ui


import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.revature.findlawyer.DrawerScreens
import com.revature.findlawyer.R
import com.revature.findlawyer.ui.theme.FindLawyerTheme
import com.revature.findlawyer.viewmodel.AppointmentViewModel


@Composable
fun Screen_CurrentAppointmentScreen(navController: NavHostController,viewModel:AppointmentViewModel){

    val listState = rememberLazyListState()
    val selected = remember{ mutableStateOf("")}

    val openDialogState = remember { mutableStateOf(false) }
    val openCancelDialog = remember{ mutableStateOf(false)}

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(backgroundColor = MaterialTheme.colors.primary,
                title = {Text("Current Appointments")})
        },
        bottomBar = {
            BottNavBar(navController)
        }

        ) {
        Image(painter = painterResource(id = R.drawable.searching), contentDescription = "",contentScale = ContentScale.FillBounds,alpha = .4f)

        LazyColumn(state = listState, modifier = Modifier.fillMaxHeight(.8f)){
            items(viewModel.result.value){
                    item: com.revature.findlawyer.data.network.Appointment -> AppointmentCard(
                navController = navController,
                firstName = item.firstName,
                lastName = item.lastName,
                typeOfPractice = item.typeOfPractice,
                rating = item.rating,
                image = item.img,
                numCases = item.numOfCases,
                time = item.time,
                openConfirmationDialog = openCancelDialog,
                openDialogState = openDialogState,
                viewModel = viewModel,
                selected = selected
            )
                UpdateAppointmentDialog(navHostController = navController, viewModel = viewModel,openDialogState,selected,"targetName",item.time)
                CancelConfirmationDialog(openDialogState = openCancelDialog, viewModel = viewModel, navHostController = navController)
            }
        }
    }
}


@OptIn(ExperimentalCoilApi::class)
@Composable
fun AppointmentCard(navController: NavHostController,firstName:String,lastName:String,typeOfPractice:String,rating:Float,image:String,numCases:Int,time:String,openDialogState:MutableState<Boolean>,viewModel: AppointmentViewModel,selected:MutableState<String>,openConfirmationDialog:MutableState<Boolean>) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()

        ) {

            Image(
                painter = rememberImagePainter(image),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit
            )
            Column(
                Modifier
                    .padding(8.dp)
                    .fillMaxWidth()) {

                Text(
                    text = firstName+" "+lastName,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                Text(
                    text = typeOfPractice,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Row() {
                    Text(
                        text = rating.toString(),
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.onSurface,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Image(painter = painterResource(R.drawable.star3_ccexpress), contentDescription = null,
                        Modifier
                            .size(20.dp)
                            .padding(2.dp))

                    Text(
                        text = numCases.toString()+" cases",
                        style = MaterialTheme.typography.body2,
                        fontStyle = FontStyle.Italic,
                        color = MaterialTheme.colors.onSurface,
                        modifier = Modifier.absolutePadding(bottom = 4.dp, left = 28.dp)
                    )
                }

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start){
                    Text(text = "Appointment Time: ")
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start){
                    Text(text = "$time", fontSize = 25.sp)
                }

                Row(modifier = Modifier.fillMaxWidth().padding(15.dp), horizontalArrangement = Arrangement.End){

                    Text(text = "Reschedule",
                        modifier = Modifier.clickable {
                        viewModel.fetchAvailableAppointment()
                        openDialogState.value = true
                    },
                        color = MaterialTheme.colors.primary
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Text(text = "Cancel", modifier = Modifier.clickable { openConfirmationDialog.value = true }, color = Color.Red)
                }

            }
        }
    }
}
