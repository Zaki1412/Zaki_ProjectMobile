package com.example.zaki_yasri_3tib

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.zaki_yasri_3tib.databinding.FragmentHomeBinding
import com.google.android.material.chip.Chip

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = ""

        val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username", "kyass")
        binding.tvWelcome.text = "Jelajahi Karya ($username)"

        binding.cardKarya1.setOnClickListener { bukaDetail() }
        binding.cardKarya2.setOnClickListener { bukaDetail() }
        binding.cardKarya3.setOnClickListener { bukaDetail() }
        binding.cardKarya4.setOnClickListener { bukaDetail() }


        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                Toast.makeText(requireContext(), "Filter: ${chip.text}", Toast.LENGTH_SHORT).show()

            }
        }


        binding.btnKat1.setOnClickListener { tampilKategori("Dwimatra") }
        binding.btnKat2.setOnClickListener { tampilKategori("Trimatra") }
        binding.btnKat3.setOnClickListener { tampilKategori("Lanskap") }
        binding.btnKat4.setOnClickListener { tampilKategori("Kaca Patri") }
        binding.btnKat5.setOnClickListener { tampilKategori("Fantasi") }
        binding.btnKat6.setOnClickListener { tampilKategori("Karakter") }
    }

    private fun bukaDetail() {
        startActivity(Intent(requireContext(), DetailActivity::class.java))
    }

    private fun tampilKategori(nama: String) {
        Toast.makeText(requireContext(), "Kategori: $nama", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}