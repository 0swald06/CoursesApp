package com.example.coursesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coursesapp.Modelo.Local.Database.CoursesEntity
import com.example.coursesapp.databinding.CoursesListBinding

class CoursesAdapter :RecyclerView.Adapter<CoursesAdapter.CoursesVH>() {

    private var listCourse= listOf<CoursesEntity>()
    private val selectedCourse= MutableLiveData<CoursesEntity>()


    fun update(list:List<CoursesEntity>){

        listCourse=list
notifyDataSetChanged()
    }

    fun selectedCourse():LiveData<CoursesEntity> = selectedCourse

    inner class  CoursesVH(private val mBinding: CoursesListBinding):
            RecyclerView.ViewHolder(mBinding.root), View.OnClickListener{

                fun bind(course:CoursesEntity){
                    Glide.with(mBinding.ivLogo).load(course.image).centerCrop()
                        .into(mBinding.ivLogo)
                    mBinding.tvname.text=course.title
                    mBinding.tvdescription.text=course.previewDescription
                    mBinding.tvduration.text="Duracion: "+course.weeks.toString()+
                            " semanas"
                    mBinding.tvstart.text="Inicio: "+ course.star
                    itemView.setOnClickListener(this)


                }

        override fun onClick(p0: View?) {
            selectedCourse.value=listCourse[adapterPosition]
        }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesVH {
        return  CoursesVH(CoursesListBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: CoursesVH, position: Int) {
        val course = listCourse[position]
        holder.bind(course)
    }
    override fun getItemCount()= listCourse.size




}