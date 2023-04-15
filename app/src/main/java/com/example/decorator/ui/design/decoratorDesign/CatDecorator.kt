package com.example.decorator.ui.design.decoratorDesign

import com.example.decorator.databinding.FragmentDesignBinding

abstract class CatDecorator(context: FragmentDesignBinding, private val cat: Cat): Cat(context) {
    override fun Draw(){
        cat.Draw()
    }
}