package br.com.fiap.pokedex.ui.pesquisa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.fiap.pokedex.R
import br.com.fiap.pokedex.data.remote.api.APIService
import br.com.fiap.pokedex.data.remote.model.PokemonPayload
import br.com.fiap.pokedex.data.repository.PokemonRepositoryImpl
import br.com.fiap.pokedex.domain.entity.Pokemon
import br.com.fiap.pokedex.domain.repository.PokemonRepository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pesquisa.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PesquisaActivity : AppCompatActivity() {

    lateinit var pesquisaViewModel: PesquisaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)

        pesquisaViewModel = ViewModelProvider(this).get(PesquisaViewModel::class.java)
        btPesquisar.setOnClickListener {
            pesquisaViewModel.pesquisar(etPokemon.text.toString())
        }

        pesquisaViewModel.pokemonResponse.observe(this, Observer{
            tvNomePokemon.text = it.nome
            Picasso.get().load(it.urlImagem).into(ivPokemon)
        })

        pesquisaViewModel.mensagemErroResponse.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}