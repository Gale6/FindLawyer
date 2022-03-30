package com.revature.findlawyer.ui

import android.view.MenuItem
import android.widget.GridLayout
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.revature.findlawyer.R
import com.revature.findlawyer.Screens
import com.revature.findlawyer.ui.theme.Cormorantgaramond
import com.revature.findlawyer.ui.theme.Shapes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Preview
@Composable
fun botdrawer(){
    bottDrawer()
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun bottDrawer(/*onDestinationClicked:(route:String)->Unit,scaffoldState: ScaffoldState,scope:CoroutineScope,navController: NavController*/){

    Column(horizontalAlignment = Alignment.CenterHorizontally,modifier= Modifier
        .fillMaxSize()
        .shadow(elevation = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.scales),
            contentDescription = "",
            modifier = Modifier
                .width(160.dp)
                .offset(y = 70.dp)
        )
        Spacer(Modifier.height(100.dp))

        //change this to start from search
        Screens.forEach { screen ->
            Spacer(Modifier.height(24.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp, 0.dp,)) {

                Icon(Icons.Default.KeyboardArrowRight, contentDescription = "Profile")

                Text(
                    text = screen.title,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.clickable {/*onDestinationClicked(screen.route) */ })


            }


        }
    }


}



/////////////////////////////  Bot App Bar  ///////////////////////////////

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BotBar(scaffoldState: ScaffoldState,scope:CoroutineScope){

    BottomAppBar() {
        Icon(Icons.Rounded.Menu, contentDescription = "Menu", Modifier.clickable {
            scope.launch {
                scaffoldState.drawerState.apply {
                    if (isClosed) open() else close()
                }
            }
        }
        )
        Spacer(Modifier.weight(1f,true))
        Icon(Icons.Rounded.Person, contentDescription = "Profile",modifier = Modifier.clickable {  })
    }

}


////////////////////////////////////  LOGO  /////////////////////////////////////////

//@Preview
//@Composable
//fun previewLogo(){
//    Logo()
//}

@Composable
fun Logo(){
    Box(modifier=Modifier/*.border(2.dp,color=Color.Black)*/.fillMaxSize(),contentAlignment = Alignment.TopCenter) {
        Image(painter = painterResource(id = R.drawable.scales), contentDescription = "",alignment = Alignment.TopCenter,
            modifier = Modifier
                .width(160.dp)
                .offset(y = 70.dp)
        )
    }


}

//////////////////////////////  THIS IS FOR THE MAIN SCREEN ////////////////////////////////////
@Composable
fun LogoMain(){
    Box(modifier=Modifier/*.border(2.dp,color=Color.Black)*/.fillMaxSize(),contentAlignment = Alignment.TopCenter) {
        Image(painter = painterResource(id = R.drawable.scales), contentDescription = "",alignment = Alignment.TopCenter,
            modifier = Modifier
                .width(130.dp)
                .offset(x = 61.dp, y = 50.dp)
        )
    }
}

