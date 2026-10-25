package com.example.zaki_yasri_3tib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.zaki_yasri_3tib.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val artworkList = listOf(
        MessageModel(
            "Pegunungan",
            "Karya Ilham · Lanskap Digital",
            "https://images.unsplash.com/photo-1506744038136-46273834b3fb?w=400",
            "08.30"
        ),
        MessageModel(
            "Senja Lembayung",
            "Karya Nadira · Ilustrasi Alam",
            "https://images.unsplash.com/photo-1470071459604-3b5ec3a7fe05?w=400",
            "09.15"
        ),
        MessageModel(
            "Mawar Kaca Patri",
            "Karya Rael · Stained Glass Art",
            "https://images.unsplash.com/photo-1518709268805-4e9042af9f23?w=400",
            "10.05"
        ),
        MessageModel(
            "Cahaya Astral",
            "Karya Kyass · Fantasy Concept",
            "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=400",
            "11.20"
        ),
        MessageModel(
            "Geometri Ruang",
            "Karya Dimas · Nirmana Trimatra",
            "https://images.unsplash.com/photo-1541701494587-cb58502866ab?w=400",
            "13.00"
        ),
        MessageModel(
            "Kabut Hutan Pinus",
            "Karya Citra · Matte Painting",
            "https://images.unsplash.com/photo-1448375240586-882707db888b?w=400",
            "14.45"
        ),
        MessageModel(
            "Ritme Garis Hitam",
            "Karya Fajar · Nirmana Dwimatra",
            "https://images.unsplash.com/photo-1550684848-fac1c5b4e853?w=400",
            "16.10"
        ),
        MessageModel(
            "Harmoni Samudra",
            "Karya Gita · Digital Watercolor",
            "https://images.unsplash.com/photo-1507525428034-b723cf961d3e?w=400",
            "17.55"
        ),
        MessageModel(
            "Siluet Kota Malam",
            "Karya Irfan · Cyberpunk Visual",
            "https://images.unsplash.com/photo-1519501025264-65ba15a82390?w=400",
            "19.20"
        ),
        MessageModel(
            "Konstelasi Bintang",
            "Karya Hana · Surreal Art",
            "https://images.unsplash.com/photo-1462331940025-496dfbfc7564?w=400",
            "21.00"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Koleksi Karya Tersimpan"

        val adapter = MessageAdapter(requireContext(), artworkList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}