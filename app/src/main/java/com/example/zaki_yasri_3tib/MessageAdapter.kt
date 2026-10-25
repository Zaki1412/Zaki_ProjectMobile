package com.example.zaki_yasri_3tib

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.zaki_yasri_3tib.databinding.ItemMessageBinding

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root
        val data = messages[position]

        Glide.with(context)
            .load(data.avatarUrl)
            .placeholder(R.drawable.moon)
            .into(binding.avatarImg)

        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText
        binding.textTime.text = data.time

        view.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("EXTRA_JUDUL", data.senderName)
                putExtra("EXTRA_KREATOR", data.messageText)
                putExtra(
                    "EXTRA_DESKRIPSI",
                    "Karya koleksi NIRMANA (${data.senderName}) yang diunggah pada pukul ${data.time}. Menampilkan eksplorasi bentuk dan warna dalam komposisi visual digital."
                )
                putExtra("EXTRA_GAMBAR", data.avatarUrl)
            }
            context.startActivity(intent)
        }

        return view
    }
}