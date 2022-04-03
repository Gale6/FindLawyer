package com.revature.findlawyer.ui

import android.util.Log
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
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.revature.findlawyer.AddItem
import com.revature.findlawyer.DrawerScreens
import com.revature.findlawyer.R
import com.revature.findlawyer.Screens
import com.revature.findlawyer.ui.theme.Cormorantgaramond
import com.revature.findlawyer.ui.theme.Shapes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


/////////////////////////////  BOTTOM NAV BAR  ///////////////////////////////

@Preview
@Composable
fun previewNavBar(){
    BottNavBar(navController = rememberNavController())
}

@Composable
fun BottNavBar(navController:NavHostController){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation() {
        Screens.forEach { screen->

            AddItem(screen = screen, currentDestination = currentDestination, navController =navController )

        }

    }
}



/////////////////////////////  DRAWER  ///////////////////////////////

@Preview
@Composable
fun Previewtopdrawer(){
    topDrawer()
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun topDrawer(/*onDestinationClicked:(route:String)->Unit,scaffoldState: ScaffoldState,scope:CoroutineScope,navController: NavController*/){

    Column(horizontalAlignment = Alignment.CenterHorizontally,modifier= Modifier
        .fillMaxSize()) {
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


/////////////////////////////  Top App Bar  ///////////////////////////////

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TopBar(scaffoldState: ScaffoldState,scope:CoroutineScope){

    TopAppBar() {
        Icon(Icons.Rounded.Menu, contentDescription = "Menu", Modifier.clickable {
            scope.launch {
                Log.d("hihi","hi")
                scope.launch { scaffoldState.drawerState.open() }
                Log.d("hihi","yio")

            }
        }
        )
        Spacer(Modifier.weight(1f,true))
        Icon(Icons.Rounded.Person, contentDescription = "Profile",modifier = Modifier.clickable { /*Todo*/ })
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


//////////////////////////////  HEADER ////////////////////////////////////

@Preview
@Composable
fun headerPrieview(){
    Header(text = "Hello Test")
}

@Composable
fun Header(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(fontFamily = Cormorantgaramond,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        text = text,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .semantics { heading() }
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .offset(130.dp)
    )
}

