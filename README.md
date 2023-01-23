# Hilt


<pre>
gradle do projeto:
plugins {
  ...
  id("com.google.dagger.hilt.android") version "2.44" apply false
}

gradle do app:
plugins {
  kotlin("kapt")
  id("com.google.dagger.hilt.android")
}

android {
  ...
}

dependencies {
  implementation("com.google.dagger:hilt-android:2.44")
  kapt("com.google.dagger:hilt-android-compiler:2.44")
}

// Allow references to generated code
kapt {
  correctErrorTypes = true
}

...

android {
  ...
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
}
</pre>

Classe Application deve ter a anotação:

@HiltAndroidApp
class ExampleApplication : Application() { ... }
<br><br>
Onde for usar dependencia:<br>
@AndroidEntryPoint
class ExampleActivity : AppCompatActivity() { ... }<br><br>
No manifest, a tag application recebe o atributo:<br>
android.name=".YourClassApplication"<br><br>
Atualmente, o Hilt é compatível com as seguintes classes do Android:
<br>
- Application (ao usar @HiltAndroidApp)
- ViewModel (ao usar @HiltViewModel)
- Activity
- Fragment
- View
- Service
- BroadcastReceiver
<br><br>
Para receber dependencias uso @Inject:<br>
<pre>
@AndroidEntryPoint
class ExampleActivity : AppCompatActivity() {

  @Inject lateinit var analytics: AnalyticsAdapter
  ...
}
</pre>
No viewmodel usamo @HiltViewModel. No construtor usamos @Inject. <br>
<br>
<pre>
@Module
@InstallIn(ViewModelComponent::class)
interface DomainBlabla{
   @Binds
   fun bindCreateProd(useCase: CreateProdImpl): CreateProd
   ...
}  
</pre>

