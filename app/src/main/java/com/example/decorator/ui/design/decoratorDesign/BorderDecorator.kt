package com.example.decorator.ui.design.decoratorDesign

import com.example.decorator.R
import com.example.decorator.databinding.FragmentDesignBinding

class BorderDecorator(context: FragmentDesignBinding, cat: Cat): CatDecorator(context, cat) {
    override fun Draw() {
        super.Draw()
        Border()
    }
    private fun Border(){
        context.catImageView.setBackgroundResource(R.drawable.border)
    }
}