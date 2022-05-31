package com.nebvuu.tothetop.ui.fragments.home


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nebvuu.tothetop.data.entities.Peak
import com.nebvuu.tothetop.databinding.PeakRowBinding
import com.nebvuu.tothetop.ui.PeakViewModel
import java.io.File

class PeakAdapter: RecyclerView.Adapter<PeakAdapter.PeakViewHolder>() {


    private var peakList = emptyList<Peak>()


    inner class PeakViewHolder(val binding: PeakRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeakViewHolder {

       val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PeakRowBinding.inflate(layoutInflater, parent, false)
        return PeakViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeakViewHolder, position: Int) {
        holder.binding.apply {

            val currentPeak = peakList[position]

            //ivMountain.load(File("drawable/img_mountain.jpg"))
            tvHeight.text = currentPeak.peakHeight.toString()
            tvPeakName.text = currentPeak.peakName
            tvDate.text = currentPeak.date.toString()
            tvMountain.text = currentPeak.mountain
            tvCountry.text = currentPeak.country

            ivMore.setOnClickListener {
                Toast.makeText(holder.itemView.context, "open menu${currentPeak.country}", Toast.LENGTH_SHORT).show();
            }
        }
    }

    override fun getItemCount(): Int {
        return peakList.size
    }

    fun setData(peak: List<Peak>){
        this.peakList = peak
        notifyDataSetChanged()
    }





}