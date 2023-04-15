package com.example.decorator.ui.design.decoratorDesign

import com.example.decorator.databinding.FragmentDesignBinding

abstract class Cat(protected val context: FragmentDesignBinding) {
    abstract fun Draw()
}