package com.example.decorator.ui.design.decoratorDesign

import com.example.decorator.databinding.FragmentDesignBinding

class TransparentDecorator(context: FragmentDesignBinding, cat: Cat): CatDecorator(context, cat) {
    override fun Draw(){
        super.Draw()
        if(context.digitEdtText.text.isNotEmpty()) Transparent()
    }
    private fun Transparent(){
        val transparencyLevel = context.digitEdtText.text.toString().toFloat()
        context.catImageView.setAlpha(transparencyLevel)
    }
}