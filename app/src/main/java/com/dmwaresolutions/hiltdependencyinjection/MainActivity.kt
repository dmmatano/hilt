package com.dmwaresolutions.hiltdependencyinjection

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/*** Fonte: https://www.youtube.com/watch?v=69BdgHxhUjE&list=PLrJS8IW7z9HFg1yAfjtMly5PIjlCDMoLe&index=5
 * DOC: https://developer.android.com/training/dependency-injection
 * 1- Adicionar @HiltAndroidApp na classe Application()
 * 2- @AndroidEntryPoint em todas as classe e "pais" que irão receber a dependencia
 * 3- NomeDaClasse @Inject constructor(){ ... } na classe dependência
 * 4- @Inject lateinit nomeDaClasse: NomeDaClasse, dentro da outra classe que recebe a depend|ência
 *
 */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var house: House
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        house.setSaleValue(750_000.0)
        house.alertPolice()
        Log.d("msgg", "getRentValue = ${house.getRentValue()}")

    }
}