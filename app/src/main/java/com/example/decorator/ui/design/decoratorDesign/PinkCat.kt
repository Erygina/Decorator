package com.example.decorator.ui.design.decoratorDesign

import com.example.decorator.R
import com.example.decorator.databinding.FragmentDesignBinding

class PinkCat(context: FragmentDesignBinding): Cat(context) {
    override fun Draw(){
        context.catImageView.setImageResource(R.drawable.cat)
    }
}