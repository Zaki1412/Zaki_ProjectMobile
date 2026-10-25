package com.example.zaki_yasri_3tib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.zaki_yasri_3tib.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    private val dataListWithDesc = listOf(
        mapOf(
            "title" to "Nirmana Dwimatra (2D)",
            "desc" to "Eksplorasi titik, garis, bidang, dan warna pada kanvas datar"
        ),
        mapOf(
            "title" to "Nirmana Trimatra (3D)",
            "desc" to "Susunan elemen visual bervolume, ruang, dan kedalaman"
        ),
        mapOf(
            "title" to "Ilustrasi Lanskap Digital",
            "desc" to "Lukisan pemandangan alam dengan atmosfer pencahayaan dramatis"
        ),
        mapOf(
            "title" to "Seni Stained Glass Modern",
            "desc" to "Komposisi warna kontras dengan garis kontur tegas"
        ),
        mapOf(
            "title" to "Surealisme & Fantasi",
            "desc" to "Visualisasi imajinatif melampaui batas realitas fisik"
        ),
        mapOf(
            "title" to "Concept Art Karakter",
            "desc" to "Perancangan siluet, anatomi, dan kostum tokoh fiksi"
        ),
        mapOf(
            "title" to "Tipografi Eksperimental",
            "desc" to "Seni merangkai huruf sebagai elemen utama komposisi visual"
        ),
        mapOf(
            "title" to "Minimalisme Monokrom",
            "desc" to "Penyederhanaan bentuk dengan fokus pada kontras gelap-terang"
        ),
        mapOf(
            "title" to "Pixel Art Retro",
            "desc" to "Penyusunan karya digital berbasis grid piksel resolusi rendah"
        ),
        mapOf(
            "title" to "Matte Painting Sinematik",
            "desc" to "Penggabungan foto dan lukisan digital untuk latar film"
        ),
        mapOf(
            "title" to "Vector Pop Art",
            "desc" to "Ilustrasi berbasis kurva geometris dengan warna berani"
        ),
        mapOf(
            "title" to "Cyberpunk Futurisme",
            "desc" to "Visualisasi dunia masa depan dengan kontras lampu neon"
        ),
        mapOf(
            "title" to "Abstrak Ekspresionis",
            "desc" to "Penyampaian emosi melalui sapuan kuas digital spontan"
        ),
        mapOf(
            "title" to "Isometric Illustration",
            "desc" to "Penggambaran objek tiga dimensi dengan sudut proyeksi tetap"
        ),
        mapOf(
            "title" to " Botanical Art Digital",
            "desc" to "Lukisan detail anatomi flora dan dedaunan secara realistis"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Cari Kategori Seni"

        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        binding.listViewItems.adapter = adapter

        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataListWithDesc[position]
            val title = selectedItem["title"]
            val desc = selectedItem["desc"]
            Toast.makeText(requireContext(), "Kategori: $title ($desc)", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}