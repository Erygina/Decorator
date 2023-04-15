package com.example.decorator.ui.design.decoratorDesign

import com.example.decorator.databinding.FragmentDesignBinding

class RotateDecorator(context: FragmentDesignBinding, cat: Cat): CatDecorator(context, cat) {
    override fun Draw() {
        super.Draw()
        if(context.digitEdtText.text.isNotEmpty()) Rotate()
    }

    private fun Rotate(){
        val alpha = context.digitEdtText.text.toString().toFloat()
        context.catImageView.rotation = alpha
    }
}