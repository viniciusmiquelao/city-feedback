import com.cityfeedback.app.models.CepResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface CepService {
    @GET("ws/{cep}/json/")
    suspend fun getCepInfo(@Path("cep") cep: String): CepResponse
}

object RetrofitInstance {
    val api: CepService by lazy {
        Retrofit.Builder()
            .baseUrl("https://viacep.com.br/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CepService::class.java)
    }
}
