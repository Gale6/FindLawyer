package com.revature.findlawyer.ui

import android.view.MenuItem
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Menu
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
fun bottDrawer(){

    Column(modifier= Modifier
        .fillMaxSize()
        .padding(start = 24.dp, top = 48.dp)
        .shadow(8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.scales),
            contentDescription = "",
            alignment = Alignment.TopCenter,
            modifier = Modifier
                .width(160.dp)
                .offset(y = 70.dp)
        )
        Spacer(Modifier.height(24.dp))

        Screens.forEach { screen ->
            Spacer(Modifier.height(24.dp))
            Text(
                text = screen.title,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.clickable {/*onDestinationClicked(screen.route) */ })

        }
    }

//    BottomDrawer(
//        drawerElevation = 10.dp,
//
//        drawerContent = {
//            Column(horizontalAlignment = Alignment.Start,modifier=Modifier.size(300.dp,400.dp)) {
//
//                Icon(imageVector = Icons.Default.Home, contentDescription = "")
//                Text(text = "/*To Do*/",Modifier.padding(start = 16.dp))
//
//                DropdownMenuItem(onClick = {/*scope.launch{state.close()} */}) {
//                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
//                    Text(text = "/*To Do*/",Modifier.padding(start = 16.dp))
//                }
//
//            }
//        }
//    ){}




}




//
//


/////////////////////////////  Bot App Bar  ///////////////////////////////

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BotBar(scaffoldState: ScaffoldState,scope:CoroutineScope){

    BottomAppBar() {
        Icon(Icons.Rounded.Menu, contentDescription = "test", Modifier.clickable {
            scope.launch {
                scaffoldState.drawerState.apply {
                    if (isClosed) open() else close()
                }
            }
        }
        )
        Spacer(Modifier.weight(1f,true))
        Icon(Icons.Rounded.Settings, contentDescription = "test", Modifier.clickable {
            scope.launch {
                scaffoldState.drawerState.apply {
                    if (isClosed) open() else close()
                }
            }
        }
        )
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

