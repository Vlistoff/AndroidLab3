package ru.vlistoff.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ru.vlistoff.lab3.adapter.CardAdapter
import ru.vlistoff.lab3.api.ClientOkHttp
import ru.vlistoff.lab3.databinding.ActivityMainBinding
import ru.vlistoff.lab3.repository.CardRepository
import ru.vlistoff.lab3.viewmodel.CardViewModel
import ru.vlistoff.lab3.viewmodel.CardViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var cardAdapter: CardAdapter
    private lateinit var cardViewModel: CardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val api = ClientOkHttp.api
        val repository = CardRepository(api)

        cardViewModel = ViewModelProvider(
            this,
            CardViewModelFactory(repository)
        )[CardViewModel::class.java]

        cardAdapter = CardAdapter(emptyList())
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = cardAdapter
        }

        cardViewModel.cards.observe(this) { characters ->
            characters?.let {
                cardAdapter.updateData(it)
            }
        }
    }
}
