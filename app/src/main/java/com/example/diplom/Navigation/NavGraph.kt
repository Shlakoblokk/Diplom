package com.example.diplom.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.diplom.AdminClubMembershipScanScreen
import com.example.diplom.FixedAssets.CardFixedAssets
import com.example.diplom.FixedAssets.CreateFixedAssets
import com.example.diplom.FixedAssets.EditFixedAssets
import com.example.diplom.FixedAssets.EditStatusFixedAssets
import com.example.diplom.FixedAssets.FiltersFixedAssets
import com.example.diplom.FixedAssets.FixedAssets
import com.example.diplom.MaterialRes.CardMaterialRes
import com.example.diplom.MaterialRes.CreateMaterialRes
import com.example.diplom.MaterialRes.EditMaterialRes
import com.example.diplom.MaterialRes.EditStatusMaterialRes
import com.example.diplom.MaterialRes.FiltersMaterialRes
import com.example.diplom.MaterialRes.MaterialRes
import com.example.diplom.Users.CardUsers
import com.example.diplom.Users.CreateUsers
import com.example.diplom.Users.EditUsers
import com.example.diplom.Users.FiltersUsers
import com.example.diplom.Users.Login
import com.example.diplom.Users.ProfileUsers
import com.example.diplom.Users.Users

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("material_res") { MaterialRes(navController = navController) }
        composable("card_material_res") { CardMaterialRes(navController = navController) }
        composable("create_material_res") { CreateMaterialRes(navController = navController) }
        composable("filter_material_res") { FiltersMaterialRes(navController = navController) }
        composable("edit_status_material_res") { EditStatusMaterialRes(navController = navController) }
        composable("edit_material_res") { EditMaterialRes(navController = navController) }

        composable("fixed_assets") { FixedAssets(navController = navController) }
        composable("card_fixed_assets") { CardFixedAssets(navController = navController) }

        /*composable(
            "card_fixed_assets/{scanResult}",
            arguments = listOf(navArgument("scanResult") { type = NavType.StringType })
        ) { backStackEntry ->
            val scanResult = backStackEntry.arguments?.getString("scanResult")
            CardFixedAssets(navController, scanResult)
        }*/




        composable("create_fixed_assets") { CreateFixedAssets(navController = navController) }
        composable("edit_fixed_assets") { EditFixedAssets(navController = navController) }
        composable("edit_status_fixed_assets") { EditStatusFixedAssets(navController = navController) }
        composable("filter_fixed_assets") { FiltersFixedAssets(navController = navController) }

        composable("users") { Users(navController = navController) }
        composable("card_users") { CardUsers(navController = navController) }
        composable("profile_users") { ProfileUsers(navController = navController) }
        composable("create_users") { CreateUsers(navController = navController) }
        composable("edit_users") { EditUsers(navController = navController) }
        composable("filter_users") { FiltersUsers(navController = navController) }

        composable("login") { Login(navController = navController) }

        composable("scan") {
            AdminClubMembershipScanScreen(navController = navController)
        }


    }


}