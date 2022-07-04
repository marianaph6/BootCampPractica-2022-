package com.example.imbd.presentation.navigation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imbd.databinding.FragmentHomeBinding
import com.example.imbd.domain.Movie
import com.example.recyclerviewkotlin.linearHorizontal.MovieLinearHorizontalAdapter
import com.example.recyclerviewkotlin.linearHorizontal.MovieOnClickListener

class HomeFragment : Fragment(), MovieOnClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapterMovies: MovieLinearHorizontalAdapter

    private val data = mutableListOf<Movie>()

    private lateinit var svSearch: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        initRecyclerView()
        initData()
        //binding.searchViewMovie.setOnQueryTextListener(object: SearchView.OnQueryTextListener)
        return binding.root
    }

    private fun initListener(){


    }

    private fun initRecyclerView() {
        adapterMovies = MovieLinearHorizontalAdapter(data, this)
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            adapter = adapterMovies

        }
    }

    private fun initData() {
        val newData = getData()
        data.clear()
        data.addAll(newData)
        adapterMovies.notifyDataSetChanged()
    }


    private fun getData(): List<Movie> {
        val list = listOf("Actor1", "Actor2", "Ator3")
        return listOf(
            Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://media.filmelier.com/tit/69klfB/poster/los-croods-2-una-nueva-era_g4ThBII.jpeg",
                title = "Los Croods",
                //rating = 5.0F,
                actors = list,
                year = 2010
            ),
            Movie(
                url = "https://www.themoviedb.org/t/p/w220_and_h330_face/iDah4ZcDX3F316LcLlmNNAzsRqF.jpg",
                title = "Era de Hielo",
                //rating = 5.0F,
                actors = list,
                year = 2000
            ),
            Movie(
                url = "https://media.filmelier.com/tit/MMUHbS/poster/un-disfraz-para-nicolas_ZCTb9Cg.jpeg",
                title = "Un disfraz para nicolas",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://es.web.img3.acsta.net/c_310_420/pictures/14/05/28/11/24/435900.jpg",
                title = "Cars",
                //rating = 5.0F,
                actors = list,
                year = 2010
            ),
            Movie(
                url = "https://media.filmelier.com/images/filmes/cartaz/the-fast-and-the-furious73665.jpeg",
                title = "Rapido y furioso",
                //rating = 5.0F,
                actors = list,
                year = 2000
            ),
            Movie(
                url = "https://media.filmelier.com/tit/9613/poster/de-padres-e-hijos_RxEsz2U.jpeg",
                title = "De padres e Hijos",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/top_gun_maverick_93017.jpg",
                title = "Top Gun: Maverick",
                //rating = 5.0F,
                actors = list,
                year = 2010
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/avatar_el_sentido_del_agua_93560.jpeg",
                title = "Avatar: El sentido del agua",
                //rating = 5.0F,
                actors = list,
                year = 2000
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/uncharted_91788.jpeg",
                title = "Uncharted",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/the_batman_92011.jpg",
                title = "The Batman",
                //rating = 5.0F,
                actors = list,
                year = 2010
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/morbius_92173.jpg",
                title = "Morbius",
                //rating = 5.0F,
                actors = list,
                year = 2000
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/minions_el_origen_de_gru_93433.jpg",
                title = "Minions: El origen de Gru",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/muerte_en_el_nilo_91613.jpg",
                title = "Muerte en el Nilo",
                //rating = 5.0F,
                actors = list,
                year = 2010
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/doctor_strange_en_el_multiverso_de_la_locura_93159.jpeg",
                title = "Doctor Strange en el multiverso de la locura",
                //rating = 5.0F,
                actors = list,
                year = 2000
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/animales_fantasticos_los_secretos_de_dumbledore_92664.jpeg",
                title = "Animales fantásticos: Los secretos de Dumbledore",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/hotel_transilvania_transformania_91792.jpg",
                title = "Hotel Transilvania: Transformanía",
                //rating = 5.0F,
                actors = list,
                year = 2010
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/thor_love_and_thunder_93712.jpg",
                title = "Thor: Love and Thunder",
                //rating = 5.0F,
                actors = list,
                year = 2000
            ),
            Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://media.filmelier.com/tit/69klfB/poster/los-croods-2-una-nueva-era_g4ThBII.jpeg",
                title = "Los Croods",
                //rating = 5.0F,
                actors = list,
                year = 2010
            ),
            Movie(
                url = "https://www.themoviedb.org/t/p/w220_and_h330_face/iDah4ZcDX3F316LcLlmNNAzsRqF.jpg",
                title = "Era de Hielo",
                //rating = 5.0F,
                actors = list,
                year = 2000
            ),
            Movie(
                url = "https://media.filmelier.com/tit/MMUHbS/poster/un-disfraz-para-nicolas_ZCTb9Cg.jpeg",
                title = "Un disfraz para nicolas",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://es.web.img3.acsta.net/c_310_420/pictures/14/05/28/11/24/435900.jpg",
                title = "Cars",
                //rating = 5.0F,
                actors = list,
                year = 2010
            ),
            Movie(
                url = "https://media.filmelier.com/images/filmes/cartaz/the-fast-and-the-furious73665.jpeg",
                title = "Rapido y furioso",
                //rating = 5.0F,
                actors = list,
                year = 2000
            ),
            Movie(
                url = "https://media.filmelier.com/tit/9613/poster/de-padres-e-hijos_RxEsz2U.jpeg",
                title = "De padres e Hijos",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/top_gun_maverick_93017.jpg",
                title = "Top Gun: Maverick",
                //rating = 5.0F,
                actors = list,
                year = 2010
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/avatar_el_sentido_del_agua_93560.jpeg",
                title = "Avatar: El sentido del agua",
                //rating = 5.0F,
                actors = list,
                year = 2000
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/uncharted_91788.jpeg",
                title = "Uncharted",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/the_batman_92011.jpg",
                title = "The Batman",
                //rating = 5.0F,
                actors = list,
                year = 2010
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/morbius_92173.jpg",
                title = "Morbius",
                //rating = 5.0F,
                actors = list,
                year = 2000
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/minions_el_origen_de_gru_93433.jpg",
                title = "Minions: El origen de Gru",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/muerte_en_el_nilo_91613.jpg",
                title = "Muerte en el Nilo",
                //rating = 5.0F,
                actors = list,
                year = 2010
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/doctor_strange_en_el_multiverso_de_la_locura_93159.jpeg",
                title = "Doctor Strange en el multiverso de la locura",
                //rating = 5.0F,
                actors = list,
                year = 2000
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/animales_fantasticos_los_secretos_de_dumbledore_92664.jpeg",
                title = "Animales fantásticos: Los secretos de Dumbledore",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/hotel_transilvania_transformania_91792.jpg",
                title = "Hotel Transilvania: Transformanía",
                //rating = 5.0F,
                actors = list,
                year = 2010
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/thor_love_and_thunder_93712.jpg",
                title = "Thor: Love and Thunder",
                //rating = 5.0F,
                actors = list,
                year = 2000
            ),
            Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://media.filmelier.com/tit/69klfB/poster/los-croods-2-una-nueva-era_g4ThBII.jpeg",
                title = "Los Croods",
                //rating = 5.0F,
                actors = list,
                year = 2010
            ),
            Movie(
                url = "https://www.themoviedb.org/t/p/w220_and_h330_face/iDah4ZcDX3F316LcLlmNNAzsRqF.jpg",
                title = "Era de Hielo",
                //rating = 5.0F,
                actors = list,
                year = 2000
            ),
            Movie(
                url = "https://media.filmelier.com/tit/MMUHbS/poster/un-disfraz-para-nicolas_ZCTb9Cg.jpeg",
                title = "Un disfraz para nicolas",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://es.web.img3.acsta.net/c_310_420/pictures/14/05/28/11/24/435900.jpg",
                title = "Cars",
                //rating = 5.0F,
                actors = list,
                year = 2010
            ),
            Movie(
                url = "https://media.filmelier.com/images/filmes/cartaz/the-fast-and-the-furious73665.jpeg",
                title = "Rapido y furioso",
                //rating = 5.0F,
                actors = list,
                year = 2000
            ),
            Movie(
                url = "https://media.filmelier.com/tit/9613/poster/de-padres-e-hijos_RxEsz2U.jpeg",
                title = "De padres e Hijos",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/top_gun_maverick_93017.jpg",
                title = "Top Gun: Maverick",
                //rating = 5.0F,
                actors = list,
                year = 2010
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/avatar_el_sentido_del_agua_93560.jpeg",
                title = "Avatar: El sentido del agua",
                //rating = 5.0F,
                actors = list,
                year = 2000
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/uncharted_91788.jpeg",
                title = "Uncharted",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/the_batman_92011.jpg",
                title = "The Batman",
                //rating = 5.0F,
                actors = list,
                year = 2010
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/morbius_92173.jpg",
                title = "Morbius",
                //rating = 5.0F,
                actors = list,
                year = 2000
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/minions_el_origen_de_gru_93433.jpg",
                title = "Minions: El origen de Gru",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/muerte_en_el_nilo_91613.jpg",
                title = "Muerte en el Nilo",
                //rating = 5.0F,
                actors = list,
                year = 2010
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/doctor_strange_en_el_multiverso_de_la_locura_93159.jpeg",
                title = "Doctor Strange en el multiverso de la locura",
                //rating = 5.0F,
                actors = list,
                year = 2000
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/animales_fantasticos_los_secretos_de_dumbledore_92664.jpeg",
                title = "Animales fantásticos: Los secretos de Dumbledore",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/hotel_transilvania_transformania_91792.jpg",
                title = "Hotel Transilvania: Transformanía",
                //rating = 5.0F,
                actors = list,
                year = 2010
            ),
            Movie(
                url = "https://www.elseptimoarte.net/carteles/341/thor_love_and_thunder_93712.jpg",
                title = "Thor: Love and Thunder",
                //rating = 5.0F,
                actors = list,
                year = 2000
            ),
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(movie: Movie) {
        TODO("Not yet implemented")
    }
}