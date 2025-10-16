### FILE: ./app/src/main/java/com/chaos/asratly/MainActivity.kt
package com.chaos.asratly


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chaos.asratly.ui.theme.MyComposeApplicationTheme
import com.chaos.asratly.ui.navigation.AppNavGraph
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.compose.rememberNavController


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    /*
                    val navController = rememberNavController()
                    AppNavGraph(navController = navController)
                    */
                    Text("Hello Asratly")
                }
            }
        }
    }
}


### FILE: ./app/src/main/java/com/chaos/asratly/ui/theme/Color.kt
package com.chaos.asratly.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


### FILE: ./app/src/main/java/com/chaos/asratly/ui/theme/Theme.kt
package com.chaos.asratly.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme =
    darkColorScheme(primary = Purple80, secondary = PurpleGrey80,
        tertiary = Pink80)

private val LightColorScheme =
    lightColorScheme(primary = Purple40, secondary = PurpleGrey40,
        tertiary = Pink40

        /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */)

@Composable
fun MyComposeApplicationTheme(darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
                              dynamicColor: Boolean = true,
                              content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(
                context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window,
                view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(colorScheme = colorScheme, typography = Typography,
        content = content)
}


### FILE: ./app/src/main/java/com/chaos/asratly/ui/theme/Type.kt
package com.chaos.asratly.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal, fontSize = 16.sp, lineHeight = 24.sp,
        letterSpacing = 0.5.sp)/* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */)


### FILE: ./app/src/main/java/com/chaos/asratly/ui/theme/Shape.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/theme/Typography.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/home/HomeScreen.kt
package com.chaos.asratly.ui.screen.home;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.chaos.asratly.ui.navigation.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Home Screen", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "This is the home page.", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController as NavHostController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Home Screen", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "This is the settings page.", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
*/


### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/home/HomeViewModel.kt
package com.chaos.asratly.ui.screen.home;

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() 



### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/addincome/AddIncomeScreen.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/addincome/AddIncomeViewModel.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/addexpense/AddExpenseScreen.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/addexpense/AddExpenseViewModel.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/debts/DebtScreen.kt
package com.chaos.asratly.ui.screen.debts;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.chaos.asratly.ui.navigation.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DebtScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController as NavHostController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Debts Screen", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "This is the settings page.", style = MaterialTheme.typography.bodyLarge)
        }
    }
}


### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/debts/DebtViewModel.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/asrat/AsratScreen.kt
package com.chaos.asratly.ui.screen.asrat;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.chaos.asratly.ui.navigation.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AsratScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController as NavHostController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Asrat Screen", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "This is the settings page.", style = MaterialTheme.typography.bodyLarge)
        }
    }
}


### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/asrat/AsratViewModel.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/setting/SettingScreen.kt
package com.chaos.asratly.ui.screen.setting;


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.chaos.asratly.ui.navigation.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController as NavHostController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Settings Screen", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "This is the settings page.", style = MaterialTheme.typography.bodyLarge)
        }
    }
}


### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/setting/SettingViewModel.kt
package com.chaos.asratly.ui.screen.setting;

public class SettingViewModel {
}



### FILE: ./app/src/main/java/com/chaos/asratly/ui/component/CardComponent.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/component/ChartComponent.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/component/FormComponent.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/navigation/Screen.kt
package com.chaos.asratly.ui.navigation;

sealed class Screen (val route:String){

   object Onboarding : Screen("onboarding_screen")
   object Home : Screen("home_screen")
   object Debts : Screen("debts_screen")
   object Asrat : Screen("asrat_screen")
   object Settings : Screen("settings_screen") 
   
}


### FILE: ./app/src/main/java/com/chaos/asratly/ui/navigation/NavGraph.kt
package com.chaos.asratly.ui.navigation;

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chaos.asratly.ui.screen.home.HomeScreen
//import com.chaos.asratly.ui.onboarding.OnboardingScreen
import com.chaos.asratly.ui.screen.debts.DebtScreen
import com.chaos.asratly.ui.screen.asrat.AsratScreen
import com.chaos.asratly.ui.screen.setting.SettingsScreen
//import com.chaos.asratly.ui.splash.SplashViewModel

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}

/*
@Composable
fun AppNavGraph(
    navController: NavHostController,
    //splashViewModel: SplashViewModel
) {
    val startDestination = Screen.Home.route

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        /*
        composable(Screen.Onboarding.route) {
            OnboardingScreen(
                navController = navController
            )
        }
        */
        composable(Screen.Home.route) {
            HomeScreen(
                navController = navController
            )
        }
        composable(Screen.Debts.route) {
            DebtScreen(
                navController = navController,
                //viewModel = signUpViewModel
            )
        }
        composable(Screen.Asrat.route) {
            AsratScreen(
                navController = navController
            )
        }
        composable(Screen.Settings.route) {
            SettingsScreen(
                navController = navController
            )
        }
    }
}
*/


### FILE: ./app/src/main/java/com/chaos/asratly/ui/navigation/BottomNavigation.kt
package com.chaos.asratly.ui.navigation;


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    

    val items = listOf(
        BottomNavItem("Home", Screen.Home.route, Icons.Filled.Home),
        BottomNavItem("Debts", Screen.Debts.route, Icons.Filled.List),
        BottomNavItem("Asrat", Screen.Asrat.route, Icons.Filled.AccountBalanceWallet),
        BottomNavItem("Settings", Screen.Settings.route, Icons.Filled.Settings)
    )
   

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination to avoid building up a large stack
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        // Avoid multiple instances of the same destination
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

data class BottomNavItem(
    val label: String,
    val route: String,
    val icon: ImageVector
)


### FILE: ./app/src/main/java/com/chaos/asratly/data/local/AppDatabase.kt
package com.chaos.asratly.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chaos.asratly.domain.model.Income
import com.chaos.asratly.domain.model.Expense
import com.chaos.asratly.domain.model.Debt

@Database(entities = [Income::class, Expense::class, Debt::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun incomeDao(): IncomeDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun debtDao(): DebtDao
}


### FILE: ./app/src/main/java/com/chaos/asratly/data/local/IncomeDao.kt
package com.chaos.asratly.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.chaos.asratly.domain.model.Income

@Dao
interface IncomeDao {
    @Insert
    suspend fun insertIncome(income: Income)

    @Query("SELECT * FROM income")
    suspend fun getAllIncomes(): List<Income>
}


### FILE: ./app/src/main/java/com/chaos/asratly/data/local/ExpenseDao.kt
package com.chaos.asratly.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.chaos.asratly.domain.model.Expense

@Dao
interface ExpenseDao {
    @Insert
    suspend fun insertExpense(expense: Expense)

    @Query("SELECT * FROM expense")
    suspend fun getAllExpenses(): List<Expense>
}


### FILE: ./app/src/main/java/com/chaos/asratly/data/local/DebtDao.kt
package com.chaos.asratly.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.chaos.asratly.domain.model.Debt

@Dao
interface DebtDao {
    @Insert
    suspend fun insertDebt(debt: Debt)

    @Query("SELECT * FROM debt")
    suspend fun getAllDebts(): List<Debt>
}


### FILE: ./app/src/main/java/com/chaos/asratly/data/remote/RemoteDataSource.kt



### FILE: ./app/src/main/java/com/chaos/asratly/data/repository/FinanceRepository.kt
package com.chaos.asratly.data.repository

import com.chaos.asratly.data.local.IncomeDao
import com.chaos.asratly.data.local.ExpenseDao
import com.chaos.asratly.data.local.DebtDao
import com.chaos.asratly.domain.model.Income
import com.chaos.asratly.domain.model.Expense
import com.chaos.asratly.domain.model.Debt

class FinanceRepository(
    private val incomeDao: IncomeDao,
    private val expenseDao: ExpenseDao,
    private val debtDao: DebtDao
) {
    suspend fun addIncome(income: Income) = incomeDao.insertIncome(income)
    suspend fun getIncomes() = incomeDao.getAllIncomes()
    suspend fun addExpense(expense: Expense) = expenseDao.insertExpense(expense)
    suspend fun getExpenses() = expenseDao.getAllExpenses()
    suspend fun addDebt(debt: Debt) = debtDao.insertDebt(debt)
    suspend fun getDebts() = debtDao.getAllDebts()
}


### FILE: ./app/src/main/java/com/chaos/asratly/domain/model/Income.kt
package com.chaos.asratly.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "income")
data class Income(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val amount: Double,
    val description: String,
    val date: Long
)


### FILE: ./app/src/main/java/com/chaos/asratly/domain/model/Expense.kt
package com.chaos.asratly.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense")
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val amount: Double,
    val description: String,
    val date: Long
)


### FILE: ./app/src/main/java/com/chaos/asratly/domain/model/Debt.kt
package com.chaos.asratly.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "debt")
data class Debt(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val amount: Double,
    val description: String,
    val date: Long
)


### FILE: ./app/src/main/java/com/chaos/asratly/domain/usecase/AddIncomeUseCase.kt



### FILE: ./app/src/main/java/com/chaos/asratly/domain/usecase/AddExpenseUseCase.kt



### FILE: ./app/src/main/java/com/chaos/asratly/domain/usecase/AddDebtUseCase.kt



### FILE: ./app/src/main/java/com/chaos/asratly/domain/usecase/CalculateAsratUseCase.kt



### FILE: ./app/src/main/java/com/chaos/asratly/domain/usecase/GetSummaryUseCase.kt



### FILE: ./app/src/main/java/com/chaos/asratly/di/AppModule.kt
package com.chaos.asratly.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context = context
}


### FILE: ./app/src/main/java/com/chaos/asratly/di/DatabaseModule.kt
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase // assuming AppDatabase extends RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


import com.chaos.asratly.data.local.AppDatabase

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "asratly_database"
        ).build()
    }
}


### FILE: ./app/src/main/java/com/chaos/asratly/di/RepositoryModule.kt
package com.chaos.asratly.di

import com.chaos.asratly.data.local.IncomeDao
import com.chaos.asratly.data.local.ExpenseDao
import com.chaos.asratly.data.local.DebtDao
import com.chaos.asratly.data.repository.FinanceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideFinanceRepository(
        incomeDao: IncomeDao,
        expenseDao: ExpenseDao,
        debtDao: DebtDao
    ): FinanceRepository {
        return FinanceRepository(incomeDao, expenseDao, debtDao)
    }
}


### FILE: ./app/src/main/java/com/chaos/asratly/util/Constants.kt



### FILE: ./app/src/main/java/com/chaos/asratly/util/Extensions.kt



### FILE: ./app/src/main/java/com/chaos/asratly/util/DateUtils.kt



### FILE: ./app/src/main/java/com/chaos/asratly/AsratlyApplication.kt
package com.chaos.asratly

import android.app.Application
import android.os.StrictMode
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AsratlyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build()
            )
            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build()
            )
        }
    }
}


### FILE: ./app/src/main/AndroidManifest.xml
<?xml version="1.0" encoding="utf-8"?>

<manifest 
    xmlns:android="http://schemas.android.com/apk/res/android">
    <uses-permission 
        android:name="android.permission.FOREGROUND_SERVICE_DATA_SYNC" />
    <application 
        android:allowBackup="true" 
        android:icon="@mipmap/ic_launcher" 
        android:roundIcon="@mipmap/ic_launcher" 
        android:label="@string/app_name" 
        android:supportsRtl="true" 
        android:theme="@style/AppTheme">
        <activity 
            android:name=".MainActivity" 
            android:exported="true">
            <intent-filter>
                <action 
                    android:name="android.intent.action.MAIN" />
                <category 
                    android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>


### FILE: ./app/proguard-rules.pro
# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


### FILE: ./android_llm_ready.kt
### FILE: ./app/src/main/java/com/chaos/asratly/MainActivity.kt
package com.chaos.asratly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chaos.asratly.ui.theme.MyComposeApplicationTheme
import com.chaos.asratly.ui.navigation.AppNavGraph
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.compose.rememberNavController


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    /*
                    val navController = rememberNavController()
                    AppNavGraph(navController = navController)
                    */
                    Text("Hello Asratly")
                }
            }
        }
    }
}


### FILE: ./app/src/main/java/com/chaos/asratly/ui/theme/Color.kt
package com.chaos.asratly.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


### FILE: ./app/src/main/java/com/chaos/asratly/ui/theme/Theme.kt
package com.chaos.asratly.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme =
    darkColorScheme(primary = Purple80, secondary = PurpleGrey80,
        tertiary = Pink80)

private val LightColorScheme =
    lightColorScheme(primary = Purple40, secondary = PurpleGrey40,
        tertiary = Pink40

        /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */)

@Composable
fun MyComposeApplicationTheme(darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
                              dynamicColor: Boolean = true,
                              content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(
                context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window,
                view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(colorScheme = colorScheme, typography = Typography,
        content = content)
}


### FILE: ./app/src/main/java/com/chaos/asratly/ui/theme/Type.kt
package com.chaos.asratly.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal, fontSize = 16.sp, lineHeight = 24.sp,
        letterSpacing = 0.5.sp)/* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */)


### FILE: ./app/src/main/java/com/chaos/asratly/ui/theme/Shape.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/theme/Typography.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/home/HomeScreen.kt
package com.chaos.asratly.ui.screen.home;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.chaos.asratly.ui.navigation.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController as NavHostController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Home Screen", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "This is the settings page.", style = MaterialTheme.typography.bodyLarge)
        }
    }
}


### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/home/HomeViewModel.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/addincome/AddIncomeScreen.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/addincome/AddIncomeViewModel.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/addexpense/AddExpenseScreen.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/addexpense/AddExpenseViewModel.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/debts/DebtScreen.kt
package com.chaos.asratly.ui.screen.debts;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.chaos.asratly.ui.navigation.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DebtScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController as NavHostController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Debts Screen", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "This is the settings page.", style = MaterialTheme.typography.bodyLarge)
        }
    }
}


### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/debts/DebtViewModel.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/asrat/AsratScreen.kt
package com.chaos.asratly.ui.screen.asrat;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.chaos.asratly.ui.navigation.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AsratScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController as NavHostController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Asrat Screen", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "This is the settings page.", style = MaterialTheme.typography.bodyLarge)
        }
    }
}


### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/asrat/AsratViewModel.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/setting/SettingScreen.kt
package com.chaos.asratly.ui.screen.setting;


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.chaos.asratly.ui.navigation.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController as NavHostController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Settings Screen", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "This is the settings page.", style = MaterialTheme.typography.bodyLarge)
        }
    }
}


### FILE: ./app/src/main/java/com/chaos/asratly/ui/screen/setting/SettingViewModel.kt
package com.chaos.asratly.ui.screen.setting;

public class SettingViewModel {
}



### FILE: ./app/src/main/java/com/chaos/asratly/ui/component/CardComponent.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/component/ChartComponent.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/component/FormComponent.kt



### FILE: ./app/src/main/java/com/chaos/asratly/ui/navigation/Screen.kt
package com.chaos.asratly.ui.navigation;

sealed class Screen (val route:String){

   object Onboarding : Screen("onboarding_screen")
   object Home : Screen("home_screen")
   object Debts : Screen("debts_screen")
   object Asrat : Screen("asrat_screen")
   object Settings : Screen("settings_screen") 
   
}


### FILE: ./app/src/main/java/com/chaos/asratly/ui/navigation/NavGraph.kt
package com.chaos.asratly.ui.navigation;

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chaos.asratly.ui.screen.home.HomeScreen
//import com.chaos.asratly.ui.onboarding.OnboardingScreen
import com.chaos.asratly.ui.screen.debts.DebtScreen
import com.chaos.asratly.ui.screen.asrat.AsratScreen
import com.chaos.asratly.ui.screen.setting.SettingsScreen
//import com.chaos.asratly.ui.splash.SplashViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController,
    //splashViewModel: SplashViewModel
) {
    val startDestination = Screen.Home.route

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        /*
        composable(Screen.Onboarding.route) {
            OnboardingScreen(
                navController = navController
            )
        }
        */
        composable(Screen.Home.route) {
            HomeScreen(
                navController = navController
            )
        }
        composable(Screen.Debts.route) {
            DebtScreen(
                navController = navController,
                //viewModel = signUpViewModel
            )
        }
        composable(Screen.Asrat.route) {
            AsratScreen(
                navController = navController
            )
        }
        composable(Screen.Settings.route) {
            SettingsScreen(
                navController = navController
            )
        }
    }
}



### FILE: ./app/src/main/java/com/chaos/asratly/ui/navigation/BottomNavigation.kt
package com.chaos.asratly.ui.navigation;


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    

    val items = listOf(
        BottomNavItem("Home", Screen.Home.route, Icons.Filled.Home),
        BottomNavItem("Debts", Screen.Debts.route, Icons.Filled.List),
        BottomNavItem("Asrat", Screen.Asrat.route, Icons.Filled.AccountBalanceWallet),
        BottomNavItem("Settings", Screen.Settings.route, Icons.Filled.Settings)
    )
   

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination to avoid building up a large stack
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        // Avoid multiple instances of the same destination
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

data class BottomNavItem(
    val label: String,
    val route: String,
    val icon: ImageVector
)


### FILE: ./app/src/main/java/com/chaos/asratly/data/local/AppDatabase.kt



### FILE: ./app/src/main/java/com/chaos/asratly/data/local/IncomeDao.kt



### FILE: ./app/src/main/java/com/chaos/asratly/data/local/ExpenseDao.kt



### FILE: ./app/src/main/java/com/chaos/asratly/data/local/DebtDao.kt



### FILE: ./app/src/main/java/com/chaos/asratly/data/remote/RemoteDataSource.kt



### FILE: ./app/src/main/java/com/chaos/asratly/data/repository/FinanceRepository.kt



### FILE: ./app/src/main/java/com/chaos/asratly/domain/model/Income.kt



### FILE: ./app/src/main/java/com/chaos/asratly/domain/model/Expense.kt



### FILE: ./app/src/main/java/com/chaos/asratly/domain/model/Debt.kt



### FILE: ./app/src/main/java/com/chaos/asratly/domain/usecase/AddIncomeUseCase.kt



### FILE: ./app/src/main/java/com/chaos/asratly/domain/usecase/AddExpenseUseCase.kt



### FILE: ./app/src/main/java/com/chaos/asratly/domain/usecase/AddDebtUseCase.kt



### FILE: ./app/src/main/java/com/chaos/asratly/domain/usecase/CalculateAsratUseCase.kt



### FILE: ./app/src/main/java/com/chaos/asratly/domain/usecase/GetSummaryUseCase.kt



### FILE: ./app/src/main/java/com/chaos/asratly/di/AppModule.kt



### FILE: ./app/src/main/java/com/chaos/asratly/di/DatabaseModule.kt



### FILE: ./app/src/main/java/com/chaos/asratly/di/RepositoryModule.kt



### FILE: ./app/src/main/java/com/chaos/asratly/util/Constants.kt



### FILE: ./app/src/main/java/com/chaos/asratly/util/Extensions.kt



### FILE: ./app/src/main/java/com/chaos/asratly/util/DateUtils.kt



### FILE: ./app/src/main/java/com/chaos/asratly/AsratlyApplication.kt
package com.chaos.asratly;
import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AsratlyApplication : Application()



### FILE: ./app/src/main/AndroidManifest.xml
<?xml version="1.0" encoding="utf-8"?>

<manifest 
    xmlns:android="http://schemas.android.com/apk/res/android">
    <uses-permission 
        android:name="android.permission.FOREGROUND_SERVICE_DATA_SYNC" />
    <application 
        android:allowBackup="true" 
        android:icon="@mipmap/ic_launcher" 
        android:roundIcon="@mipmap/ic_launcher" 
        android:label="@string/app_name" 
        android:supportsRtl="true" 
        android:theme="@style/AppTheme">
        <activity 
            android:name=".MainActivity" 
            android:exported="true">
            <intent-filter>
                <action 
                    android:name="android.intent.action.MAIN" />
                <category 
                    android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>


### FILE: ./app/proguard-rules.pro
# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile





