# sponsor-data-sdk

Este documento será tu guía para la integración través de las diferentes librerías para hacer una conexión con el API

## Installation

Descarga del link [sponsor-data](https://pip.pypa.io/en/stable/) la librería AAR. Agrega el módulo sponsor-data desde el Project Structure de tu módulo principal(app). Para mas información consulta el link [aquí](https://developer.android.com/studio/projects/android-library?hl=es-419)

    implementation project(path: ':sponsordata-debug')

## Usage

### Uso con Volley (https://developer.android.com/training/volley?hl=es-419)

Para integrar sponsor-data-sdk con la librería de Volley agrega lo siguiente:

En tu build.gradle:
		
		//Volley
		implementation 'com.android.volley:volley:1.1.1'
		
Configura tu request:

	  private val requestQueue = SponsorData.newRequestQueue(context, Environment.Sandbox)
		
### Uso con Retrofit (https://square.github.io/retrofit/)

Agrega en tu build.gradle:

	//Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.6.1'
    implementation 'com.squareup.retrofit2:converter-gson:2.6.1'
		
Agrega la configuración para el uso de sponsor data

	object RetrofitClientInstance {
    private var retrofit: Retrofit? = null
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(SponsorData.addSponsorDataClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
		}

Agrega el context en el MainActivity.kt:

	class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SponsorData.context = this
        this.supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, LoginFragment.newInstance())
            .commit()
    }
	}
		






